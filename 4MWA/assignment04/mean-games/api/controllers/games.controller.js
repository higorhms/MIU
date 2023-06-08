const { ObjectId } = require("mongodb");
const dbConnection = require("../data/dbConnection");
const callbackify = require("util").callbackify;

const getAllGamesWithCallBack = callbackify((offset,count) => {
  return dbConnection.get().collection("games").find().skip(offset).limit(count).toArray();
})

const getOneGameByIdWithCallback = callbackify((gameId) => {
  return dbConnection.get().collection("games").findOne({_id: new ObjectId (gameId)});
})

const deleteOneGameByIdWithCallback = callbackify((gameId) => {
  return dbConnection.get().collection("games").deleteOne({_id: new ObjectId (gameId)});
})

const addGameWithCallback = callbackify((game) => {
  return dbConnection.get().collection("games").insertOne(game);
})

const _countRule = (count) => {
  if(count > 10 || count < 0) return 10;
  return count;
}

const getAll = (req, res) => {
  let offset = 0;
  let count = 4;

  if(req.query && req.query.offset) offset = parseInt(req.query.offset);
  if(req.query && req.query.count) count = parseInt(req.query.count);

  const realCount = _countRule(count);

  getAllGamesWithCallBack(offset, realCount, (err, games)=>{
    if(err) return res.status(500).json({message: err.message});
    return res.status(200).json(games);
  })
}

const getOne = (req, res) => {
  let gameId = req.params.gameId;

  getOneGameByIdWithCallback(gameId, (err, game)=>{
    if(err) return res.status(500).json({message: err.message});
    if(game == null) return res.status(404).send();
    return res.status(200).json(game);
  })
}

const deleteOne = (req, res) => {
  let gameId = req.params.gameId;
  if(!ObjectId.isValid(gameId)) return res.status(400).json({message: "Invalid Game ID"})

  deleteOneGameByIdWithCallback(gameId, (err, game)=>{
    if(err) return res.status(500).json({message: err.message});
    console.log(game);
    if(game == null) return res.status(404).send();
    return res.status(200).json(game);
  })
}

const _validateRequiredGameParams = (game) => {
  const errors = [];

  if(game.title === null) errors.push("title is missing.");
  if(game.price === null) errors.push("price is missing.");
  if(game.minPlayers === null) errors.push("minPlayers is missing.");
  if(game.maxPlayers === null) errors.push("maxPlayers is missing.");
  if(game.minAge === null) errors.push("minAge is missing.");
  if(typeof game.price !== 'number') errors.push("price must be a number.");
  if(typeof game.minPlayers !== 'number') errors.push("minPlayers must be a number.");
  if(typeof game.maxPlayers !== 'number') errors.push("maxPlayers must be a number.");
  if(typeof game.minAge !== 'number') errors.push("minAge must be a number.");
  if(game.minPlayers < 1 || game.maxPlayers > 10) errors.push("Number of players must be between 1-10");
  if(game.minAge < 7 || game.minAge > 99) errors.push("Age must be between 7-99");

  return errors;
}

const _populateGame = (data) => {
  return {
    title: data.title,
    price: data.price,
    minAge: data.minAge,
    minPlayers: data.minPlayers,
    maxPlayers: data.maxPlayers,
  }
}

const addOne = (req, res) => {
  let game = {};

  if(req.body) game = _populateGame(req.body);

  const errors = _validateRequiredGameParams(game);

  if(errors.length) return res.status(400).json({message: errors })

  addGameWithCallback(game, (err, acknowledged) => {
    return res.status(200).json({
      insertedId: acknowledged.insertedId
    });
  })
}

module.exports = {
  getAll,
  getOne,
  addOne,
  deleteOne
}