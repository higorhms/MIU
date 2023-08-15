const express = require("express");
const tweetsController = require("../controllers/tweets.controller");
const authenticationController = require("../controllers/authentication.controller");

const tweetsRoutes = express.Router();

tweetsRoutes.route("/tweets")
  .get(authenticationController.verifyToken, tweetsController.findAll)
  .post(authenticationController.verifyHeader, authenticationController.verifyToken, tweetsController.insertOne)

module.exports = tweetsRoutes;