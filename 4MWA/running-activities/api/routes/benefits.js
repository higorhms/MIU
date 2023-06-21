const express = require("express");
const benefitsController = require("../controllers/benefits.controller");
const authenticationController = require("../controllers/authentication.controller");

const benefitsRoutes = express.Router();

benefitsRoutes.route("/activities/:activityId/benefits")
  .get(benefitsController.findAll)
  .post(authenticationController.authenticate, benefitsController.insertOne)

benefitsRoutes.route("/activities/:activityId/benefits/:benefitId")
  .get(benefitsController.findOne)
  .delete(authenticationController.authenticate, benefitsController.deleteOne)
  .patch(authenticationController.authenticate, benefitsController.partialUpdate)
  .put(authenticationController.authenticate, benefitsController.fullUpdate)

module.exports = benefitsRoutes;