const express = require("express");
const routes = express.Router();
const activitiesController = require("../controllers/activities.controller");
const benefitsController = require("../controllers/benefits.controller");

routes.route("/activities")
  .get(activitiesController.findAll)
  .post(activitiesController.insertOne)

routes.route("/activities/:activityId")
  .get(activitiesController.findOne)
  .delete(activitiesController.deleteOne)
  .patch(activitiesController.partialUpdate)
  .put(activitiesController.fullUpdate)

routes.route("/activities/:activityId/benefits")
  .get(benefitsController.findAll)
  .post(benefitsController.insertOne)

routes.route("/activities/:activityId/benefits/:benefitId")
  .get(benefitsController.findOne)
  .delete(benefitsController.deleteOne)
  .patch(benefitsController.partialUpdate)
  .put(benefitsController.fullUpdate)

module.exports = routes;