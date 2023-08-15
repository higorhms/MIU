const express = require("express");
const routes = express.Router();

const tweetsRoutes = require("./tweets");
const usersRoutes = require("./users");

routes.use('/users', usersRoutes);
routes.use('/tweets', tweetsRoutes);

module.exports = routes;