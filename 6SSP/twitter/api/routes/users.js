const express = require("express");

const usersController = require("../controllers/users.controller");

const usersRoutes = express.Router();

usersRoutes.route("/users")
  .post(usersController.insertOne)

usersRoutes.route("/users/signin")
  .post(usersController.signIn)

module.exports = usersRoutes;