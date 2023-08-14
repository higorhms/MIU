const express = require("express");
const tweetsController = require("../controllers/tweets.controller");
const authenticationController = require("../controllers/authentication.controller");

const tweetsRoutes = express.Router();

tweetsRoutes.route("/tweets")
  .get(authenticationController.authorize, tweetsController.findAll)
  .post(authenticationController.authenticate, authenticationController.authorize, tweetsController.insertOne)

module.exports = tweetsRoutes;