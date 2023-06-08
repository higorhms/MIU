const games = require("../data/games.json")

const getAll = (req, res) => {
  res.status(200).json(games);
}

module.exports = {
  getAll
}