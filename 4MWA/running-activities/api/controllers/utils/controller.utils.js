const mongoose = require("mongoose");
const constants = require("../../constants");

const validateObjectId = function (objectId) {
  if (!mongoose.isValidObjectId(objectId)) {
    const error = new Error(process.env.INVALID_OBJECT_ID_MESSAGE + objectId);
    error.status = constants.BAD_REQUEST_STATUS;
    throw error;
  }
}

const internalServerErrorResponse = function (res, message) {
  return res.status(constants.INTERNAL_SERVER_ERROR_STATUS).send({ message: message });
}

const notfoundResponse = function (res, message) {
  return res.status(constants.NOT_FOUND_STATUS).json({ message: message });
}

const badRequestResponse = function (res, message) {
  return res.status(constants.BAD_REQUEST_STATUS).json({ message: message });
}

const successResponse = function (res, message) {
  return res.status(constants.SUCCESS_STATUS).json(message);
}

module.exports = {
  validateObjectId,
  internalServerErrorResponse,
  notfoundResponse,
  badRequestResponse,
  successResponse
}