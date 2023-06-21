const express = require("express");
const usersController = require("../controllers/users.controller");
const authenticationController = require("../controllers/authentication.controller");

const usersRoutes = express.Router();

usersRoutes.route("/users")
  .post(usersController.insertOne)

usersRoutes.route("/users/signin")
  .get(authenticationController.authenticate) // add find one
  .post(usersController.signIn)

module.exports = usersRoutes;