const express = require("express");
const gamesController = require("../controllers/games.controller")

const router = express.Router();

router.route("/games")
  .get(gamesController.getAll)


module.exports = router;