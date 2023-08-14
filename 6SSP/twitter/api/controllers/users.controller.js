const mongoose = require("mongoose");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const util = require("util");

const { successResponse, errorResponse, createError, noContentResponse } = require("./utils/controller.utils");
const constants = require("../constants");

const User = mongoose.model(process.env.USER_MODEL);

const findAll = function (req, res) {
  const userId = req.userId;
  const username = req.query.username;
  const filter = { _id: { $ne: new mongoose.Types.ObjectId(userId) } };
  if(username) filter.username = { $regex: new RegExp(username, 'i') };
  User.find(filter).exec()
    .then(users => successResponse(res, users))
    .catch((error) => errorResponse(res, error))
}

const insertOne = function (req, res) {
  const userToBeCreated = _fillUser(req.body);

  _validateSchema(userToBeCreated)
    .then((userToBeCreated) => _checkIfUserAlreadyExist(userToBeCreated))
    .then((userToBeCreated) => _encryptPassword(userToBeCreated))
    .then((userToBeCreated) => User.create(userToBeCreated))
    .then((user) => successResponse(res, user, constants.CREATE_STATUS))
    .catch((error) => errorResponse(res, error))
}

const signIn = function (req, res) {
  _validateRequestCredentials(req.body)
    .then((credentials) => User.findOne({ username: credentials.username }).exec())
    .then((user) => _checkIfUserExist(user))
    .then((user) => _checkPassword(user, req.body.password))
    .then((user) => _generateToken(user._id)) 
    .then((token) => successResponse(res, { token }))
    .catch(() => errorResponse(res, { status: constants.UNAUTHORIZED_STATUS, message: process.env.UNAUTHORIZED_MESSAGE }))
}

const follow = function (req, res) {
  const username = req.body.username;
  const userId = req.userId;

  User.findOne({ username: username }).exec()
    .then((userToFollow) => _checkIfUserExist(userToFollow))
    .then((userToFollow) => _addFollower(userToFollow, userId))
    .then(() => noContentResponse(res))
    .catch((error) => errorResponse(res, error))
}

const unfollow = function (req, res) {
  const username = req.body.username;
  const userId = req.userId;

  User.findOne({ username: username }).exec()
    .then((userToUnfollow) => _checkIfUserExist(userToUnfollow))
    .then((userToUnfollow) => _removeFollower(userToUnfollow, userId))
    .then(() => noContentResponse(res))
    .catch((error) => errorResponse(res, error))
}

const _removeFollower = function (userToUnfollow, follower) {
  return new Promise((resolve, reject) => {
    userToUnfollow.followers = userToUnfollow.followers.filter(storedFollower => storedFollower.toString() !== follower);
    userToUnfollow.save()
      .then(() => resolve())
      .catch(error => reject(error))
  })
}

const _addFollower = function (userToFollow, follower) {
  return new Promise((resolve, reject) => {
    const alreadyFollowing = userToFollow.followers.find(storedFollower => storedFollower.toString() === follower);
    if (alreadyFollowing) reject(createError(constants.BAD_REQUEST_STATUS, "Already following"));
    userToFollow.followers.push(new mongoose.Types.ObjectId(follower));
    userToFollow.save()
      .then(() => resolve())
  })
}

const _generateToken = function (userId) {
  const sign = util.promisify(jwt.sign);
  return sign({ _id: userId }, process.env.ENCODING_SECRET, { expiresIn: constants.EXPIRATION_TIME });
}

const _checkPassword = function (databaseUser, requestPassword) {
  return new Promise((resolve, reject) => {
    bcrypt.compare(requestPassword, databaseUser.password)
      .then((passwordMatches) => {
        if (!passwordMatches) reject(createError(constants.UNAUTHORIZED_STATUS, process.env.UNAUTHORIZED_MESSAGE));
        resolve(databaseUser);
      })
      .catch((error) => reject(error));
  })
}

const _checkIfUserExist = function (user) {
  return new Promise((resolve, reject) => {
    if (!user) reject(createError(constants.NOT_FOUND_STATUS, process.env.USER_NOT_FOUND_MESSAGE))
    resolve(user);
  })
}

const _checkIfUserAlreadyExist = function (userToBeCreated) {
  return new Promise((resolve, reject) => {
    User.findOne({ username: userToBeCreated.username }).exec()
      .then((foundUser) => {
        if (foundUser) reject(createError(constants.BAD_REQUEST_STATUS, process.env.USER_ALREADY_EXIST_MESSAGE));
        resolve(userToBeCreated);
      }).catch(error => reject(error));
  })
}

const _encryptPassword = function (user) {
  return new Promise((resolve, reject) => {
    bcrypt.genSalt(constants.ENCRYPTION_SALT)
      .then((salt) => bcrypt.hash(user.password, salt))
      .then((hashedPassword) => {
        user.password = hashedPassword;
        resolve(user);
      })
      .catch((error) => reject(createError(constants.INTERNAL_SERVER_ERROR_STATUS, error)))
  })
}

const _fillUser = function (data) {
  const newUser = {};
  if (data.name) newUser.name = data.name;
  if (data.username) newUser.username = data.username;
  if (data.password) newUser.password = data.password;
  return newUser;
}

const _validateRequestCredentials = function (data) {
  return new Promise((resolve, reject) => {
    if (!data.username) reject(createError(constants.BAD_REQUEST_STATUS, process.env.MISSING_USERNAME_MESSAGE));
    if (!data.password) reject(createError(constants.BAD_REQUEST_STATUS, process.env.MISSING_PASSWORD_MESSAGE));
    resolve({ username: data.username, password: data.password });
  })
}

const _validateSchema = function (user) {
  return new Promise((resolve, reject) => {
    User.validate(user)
      .then(() => resolve(user))
      .catch((error) => {
        error.status = constants.BAD_REQUEST_STATUS;
        reject(error)
      })
  })
}


module.exports = {
  insertOne,
  signIn,
  follow,
  unfollow,
  findAll
}