const bcrypt = require("bcrypt");

const usersRepository = require("../data/repository/users.repository");
const { successResponse, errorResponse, createError } = require("./utils/controller.utils");
const constants = require("../constants");

const insertOne = function (req, res) {
  _fillUser(req.body)
    .then((userToBeCreated) => usersRepository.validate(userToBeCreated))
    .then((userToBeCreated) => _checkIfUserAlreadyExist(userToBeCreated))
    .then((userToBeCreated) => _encryptPassword(userToBeCreated))
    .then((userToBeCreated) => usersRepository.insertOne(userToBeCreated))
    .then((user) => successResponse(res, user))
    .catch((error) => errorResponse(res, error))
}

/*
Change to return the true autentication
*/
const signIn = function (req, res) {
  _validateRequestCredentials(req.body)
    .then((credentials) => usersRepository.findByUsername(credentials.username))
    .then((user) => _checkIfUserExist(user))
    .then((user) => _checkIfPasswordMatches(user.password, req.body.password))
    .then((passwordMatches) => successResponse(res, { message: passwordMatches }))
    .catch((error) => errorResponse(res, error))
}

const _checkIfPasswordMatches = function (databasePassword, requestPassword) {
  return new Promise((resolve, reject) => {
    bcrypt.compare(requestPassword, databasePassword)
      .then((passwordMatches) => {
        if (!passwordMatches) reject(createError(constants.UNAUTHORIZED_STATUS, process.env.UNAUTHORIZED_MESSAGE));
        resolve(passwordMatches);
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
    usersRepository.findByUsername(userToBeCreated.username)
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

  return new Promise((resolve, reject) => {
    resolve(newUser);
  })
}

const _validateRequestCredentials = function (data) {
  return new Promise((resolve, reject) => {
    if (!data.username) reject(createError(constants.BAD_REQUEST_STATUS, process.env.MISSING_USERNAME_MESSAGE));
    if (!data.password) reject(createError(constants.BAD_REQUEST_STATUS, process.env.MISSING_PASSWORD_MESSAGE));
    resolve({ username: data.username, password: data.password });
  })
}

module.exports = {
  insertOne,
  signIn
}