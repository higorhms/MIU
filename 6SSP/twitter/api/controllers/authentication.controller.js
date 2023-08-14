const jwt = require("jsonwebtoken");

const constants = require("../constants");
const util = require("util");
const { errorResponse } = require("./utils/controller.utils")

const authorize = function (req, res, next) {
  const headerExist = req.headers.authorization;

  if (headerExist) {
    const token = req.headers.authorization.split(" ")[1];
    const verify = util.promisify(jwt.verify);

    verify(token, process.env.ENCODING_SECRET)
      .then((data) => {
        req.userId = data._id;
        next()
      })
      .catch(() => errorResponse(res, { status: constants.UNAUTHORIZED_STATUS, message: process.env.UNAUTHORIZED_MESSAGE }))
  }
  next();
}

const authenticate = function (req, res, next) {
  const headerExist = req.headers.authorization;

  if (!headerExist) {
    return errorResponse(res, { status: constants.FORBIDDEN_STATUS, message: process.env.NO_TOKEN_PROVIDED_MESSAGE });
  }
}

module.exports = {
  authenticate,
  authorize
};