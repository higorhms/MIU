const jwt = require("jsonwebtoken");
const constants = require("../constants");
const util = require("util");

const authenticate = function (req, res, next) {
  const headerExist = req.headers.authorization;

  if (!headerExist) { return res.status(constants.FORBIDDEN_STATUS).json({ message: process.env.NO_TOKEN_PROVIDED_MESSAGE }) }

  const token = req.headers.authorization.split(" ")[1];
  const verify = util.promisify(jwt.verify);

  verify(token, process.env.ENCODING_SECRET)
    .then(() => next())
    .catch(() => res.status(constants.UNAUTHORIZED_STATUS).json({ message: process.env.UNAUTHORIZED_MESSAGE }))
}

module.exports = {
  authenticate
};