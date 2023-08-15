const express = require("express");
const routes = express.Router();

const tweetsRoutes = require("./tweets");
const usersRoutes = require("./users");

routes.use('/users', usersRoutes);
routes.use(tweetsRoutes);

module.exports = routes;