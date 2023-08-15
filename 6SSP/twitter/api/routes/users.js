const express = require("express");

const authenticationController = require('../controllers/authentication.controller')
const usersController = require("../controllers/users.controller");

const usersRoutes = express.Router();

usersRoutes.route("/")
  .get(authenticationController.verifyToken, usersController.findAll)
  .post(usersController.insertOne)

usersRoutes.route("/:userId")
  .get(authenticationController.verifyToken, usersController.findOne)

usersRoutes.route("/signin")
  .post(usersController.signIn)

usersRoutes.route("/follow")
  .post(authenticationController.verifyHeader, authenticationController.verifyToken, usersController.follow)

usersRoutes.route("/unfollow")
  .post(authenticationController.verifyHeader, authenticationController.verifyToken, usersController.unfollow)

module.exports = usersRoutes;