const express = require("express");
const jobsController = require("../controllers/jobs.controller");

const routes = express.Router();

routes.route("/jobs")
  .get(jobsController.findAll)
  .post(jobsController.insertOne)

routes.route("/jobs/:jobId")
  .get(jobsController.findOne)
  .patch(jobsController.updateOne)
  .delete(jobsController.deleteOne)

module.exports = routes;