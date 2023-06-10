const express = require("express");
const benefitsController = require("../controllers/benefits.controller");

const benefitsRoutes = express.Router();

benefitsRoutes.route("/activities/:activityId/benefits")
  .get(benefitsController.findAll)
  .post(benefitsController.insertOne)

benefitsRoutes.route("/activities/:activityId/benefits/:benefitId")
  .get(benefitsController.findOne)
  .delete(benefitsController.deleteOne)
  .patch(benefitsController.partialUpdate)
  .put(benefitsController.fullUpdate)

module.exports = benefitsRoutes;