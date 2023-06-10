const mongoose = require("mongoose");
const { createError } = require("../../controllers/utils/controller.utils");
const constants = require("../../constants");

const User = mongoose.model(process.env.USER_MODEL);

const validate = function (user) {
  return new Promise((resolve, reject) => {
    User.validate(user)
      .then(() => resolve(user))
      .catch((error) => {
        error.status = constants.BAD_REQUEST_STATUS;
        reject(error)
      })
  })
}

const insertOne = async function (user) {
  return User.create(user);
}

const findByUsername = async function (username) {
  return User.findOne({ username }).exec();
}

module.exports = {
  validate,
  insertOne,
  findByUsername
}