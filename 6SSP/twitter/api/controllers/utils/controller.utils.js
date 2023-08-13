const mongoose = require("mongoose");
const constants = require("../../constants");

const validateObjectId = function (objectId) {
  return new Promise((resolve, reject) => {
    if (!mongoose.isValidObjectId(objectId)) {
      reject(createError(constants.BAD_REQUEST_STATUS, process.env.INVALID_OBJECT_ID_MESSAGE + objectId));
    }
    resolve(objectId);
  })
}

const validatePaginationParams = function (offset, count) {
  return new Promise((resolve, reject) => {
    if (!offset) offset = constants.DEFAULT_OFFSET;
    if (!count) count = constants.DEFAULT_COUNT;

    if (isNaN(offset) || isNaN(count)) {
      reject(createError(constants.BAD_REQUEST_STATUS, process.env.INVALID_PAGINATION_MESSAGE))
    }
    if (count > constants.DEFAULT_COUNT) {
      createError(constants.BAD_REQUEST_STATUS, process.env.INVALID_COUNT_MESSAGE)
    }

    const page = (offset - 1) * count;
    resolve({ page, count });
  })
}

const successResponse = function (res, message, status = constants.SUCCESS_STATUS) { 
  return res.status(status).json(message);
}

const noContentResponse = function (res, status = constants.NO_CONTENT_STATUS) { 
  return res.status(status).send();
}

const errorResponse = function (res, error) {
  return res.status(error.status || constants.INTERNAL_SERVER_ERROR_STATUS).json({ message: error.message });
}

const createError = function (status, message) {
  const error = new Error(message);
  error.status = status;
  throw error;
}

module.exports = {
  validateObjectId,
  successResponse,
  createError,
  errorResponse,
  validatePaginationParams
}