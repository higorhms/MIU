const express = require("express");

const authenticationController = require('../controllers/authentication.controller')
const usersController = require("../controllers/users.controller");

const usersRoutes = express.Router();

usersRoutes.route("/")
  .get(authenticationController.authenticate, authenticationController.authorize, usersController.findAll)
  .post(usersController.insertOne)

usersRoutes.route("/signin")
  .post(usersController.signIn)

usersRoutes.route("/follow")
  .post(authenticationController.authenticate, authenticationController.authorize, usersController.follow)

usersRoutes.route("/unfollow")
  .post(authenticationController.authenticate, authenticationController.authorize, usersController.unfollow)

module.exports = usersRoutes;