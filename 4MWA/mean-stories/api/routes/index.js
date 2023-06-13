const express = require("express");
const storiesController = require("../controllers/stories.controller");

const routes = express.Router();

routes.route("/stories")
  .get(storiesController.findAll);

routes.route("/stories/:storyId")
  .get(storiesController.findOne)
  .patch(storiesController.updateStatus)

module.exports = routes;