const express = require("express");
const routes = express.Router();

const tweetsRoutes = require("./tweets");
const usersRoutes = require("./users");
const authenticationController = require('../controllers/authentication.controller');

routes.use(usersRoutes);
routes.use(authenticationController.authenticate)
routes.use(tweetsRoutes);

module.exports = routes;