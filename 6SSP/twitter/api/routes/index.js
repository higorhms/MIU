const express = require("express");
const routes = express.Router();

const benefitsRoutes = require("./benefits");
const activitiesRoutes = require("./activities");
const usersRoutes = require("./users");
const authenticationController = require('../controllers/authentication.controller')

routes.use(usersRoutes);
routes.use(authenticationController.authenticate)
routes.use(activitiesRoutes);
routes.use(benefitsRoutes);

module.exports = routes;