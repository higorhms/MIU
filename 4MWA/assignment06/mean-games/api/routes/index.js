const express = require("express");
const gamesController = require("../controllers/games.controller")

const router = express.Router();

router.route("/games")
  .get(gamesController.findAll)
  .post(gamesController.insertOne)

router.route("/games/:gameId")
  .get(gamesController.findOne)
  .delete(gamesController.deleteOne)
  .patch(gamesController.partialUpdate)
  .put(gamesController.fullUpdate)

module.exports = router;