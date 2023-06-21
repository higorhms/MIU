const express = require("express");
const activitiesController = require("../controllers/activities.controller");
const authenticationController = require("../controllers/authentication.controller");

const activitiesRoutes = express.Router();

activitiesRoutes.route("/activities")
  .get(activitiesController.findAll)
  .post(authenticationController.authenticate, activitiesController.insertOne)

activitiesRoutes.route("/activities/:activityId")
  .get(activitiesController.findOne)
  .delete(authenticationController.authenticate, activitiesController.deleteOne)
  .patch(authenticationController.authenticate, activitiesController.partialUpdate)
  .put(authenticationController.authenticate, activitiesController.fullUpdate)

module.exports = activitiesRoutes;