const express = require("express");
const activitiesController = require("../controllers/tweets.controller");

const tweetsRoutes = express.Router();

tweetsRoutes.route("/tweets")
  .get(activitiesController.findAll)
  .post(activitiesController.insertOne)

module.exports = tweetsRoutes;