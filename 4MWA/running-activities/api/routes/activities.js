const express = require("express");
const activitiesController = require("../controllers/activities.controller");

const activitiesRoutes = express.Router();

activitiesRoutes.route("/activities")
  .get(activitiesController.findAll)
  .post(activitiesController.insertOne)

activitiesRoutes.route("/activities/:activityId")
  .get(activitiesController.findOne)
  .delete(activitiesController.deleteOne)
  .patch(activitiesController.partialUpdate)
  .put(activitiesController.fullUpdate)

module.exports = activitiesRoutes;