const express = require("express");
const routes = express.Router();

const benefitsRoutes = require("./benefits");
const activitiesRoutes = require("./activities");
const usersRoutes = require("./users");

routes.use(activitiesRoutes);
routes.use(benefitsRoutes);
routes.use(usersRoutes);

module.exports = routes;