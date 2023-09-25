const mongoose = require("mongoose");
const constants = require("../constants");
const callbackify = require("util").callbackify;
const {
  validateObjectId,
  internalServerError,
  notfoundResponse,
  badRequestResponse,
  successResponse
} = require("./utils/controller.utils");

const Game = mongoose.model(process.env.GAME_MODEL);

const insertOneWithCallback = callbackify(function (newGame) {
  return Game.create(newGame);
})

const findAllWithCallback = callbackify(function (offset, count) {
  return Game.find().skip(offset).limit(count).exec();
})

const findByIdWithCallback = callbackify(function (gameId) {
  return Game.findById(gameId).exec();
})

const deleteOneByIdWithCallback = callbackify(function (gameId) {
  return Game.deleteOne({ _id: gameId }).exec();
})

const partialUpdateWithCallback = callbackify(function (gameId, newProperties) {
  return Game.findOneAndUpdate({ _id: gameId }, newProperties, { new: true });
})

const fullUpdateWithCallback = callbackify(function (gameId, newGame) {
  return Game.findOneAndReplace({ _id: gameId }, newGame, { new: true });
})

const validateWithCallback = callbackify(function (game) {
  return Game.validate(game);
})

const findAll = function (req, res) {
  const offset = req.query.offset || constants.DEFAULT_OFFSET;
  const count = req.query.count || constants.DEFAULT_COUNT;

  if (isNaN(offset) || isNaN(count)) return badRequestResponse(res, process.env.INVALID_PAGINATION_MESSAGE);
  if (count > constants.DEFAULT_COUNT) return badRequestResponse(res, process.env.INVALID_COUNT_MESSAGE);

  findAllWithCallback(offset, count, function (err, activities) {
    if (err) return internalServerError(res, err);
    return successResponse(res, activities);
  });
}

const findOne = (req, res) => {
  try {
    const gameId = req.params.gameId;
    validateObjectId(gameId);

    findByIdWithCallback(gameId, function (error, game) {
      if (error) return internalServerError(res, error);
      if (!game) return notfoundResponse(res, process.env.GAME_NOT_FOUND_MESSAGE);
      return successResponse(res, game);
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const insertOne = function (req, res) {
  const newGame = req.body;

  insertOneWithCallback(newGame, (error, game) => {
    if (error) return internalServerError(res, error);
    return successResponse(res, game);
  });
}

const deleteOne = function (req, res) {
  try {
    const gameId = req.params.gameId;
    validateObjectId(gameId);

    findByIdWithCallback(gameId, function (error, game) {
      if (error) return internalServerError(res, error);
      if (!game) return notfoundResponse(res, process.env.GAME_NOT_FOUND_MESSAGE);

      deleteOneByIdWithCallback(gameId, (deleteError, acknowledgeObject) => {
        if (deleteError) return internalServerError(res, deleteError);

        return successResponse(res, acknowledgeObject);
      });
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const partialUpdate = function (req, res) {
  try {
    const gameId = req.params.gameId;
    const update = req.body;

    validateObjectId(gameId);

    findByIdWithCallback(gameId, function (error, game) {
      if (error) return internalServerError(res, error);
      if (!game) return notfoundResponse(res, process.env.GAME_NOT_FOUND_MESSAGE);

      partialUpdateWithCallback(gameId, update, function (err, updatedGame) {
        if (err) return internalServerError(res, err);
        return successResponse(res, updatedGame);
      })
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const fullUpdate = function (req, res) {
  try {
    const gameId = req.params.gameId;
    const update = req.body;

    validateObjectId(gameId);

    findByIdWithCallback(gameId, function (error, game) {
      if (error) return internalServerError(res, error);
      if (!game) return notfoundResponse(res, process.env.GAME_NOT_FOUND_MESSAGE);

      validateWithCallback(update, function (validateError) {
        if (validateError) return badRequestResponse(res, validateError);

        fullUpdateWithCallback(gameId, update, function (err, updatedGame) {
          if (err) return internalServerError(res, err);
          return successResponse(res, updatedGame);
        })
      });
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

module.exports = {
  findAll,
  findOne,
  insertOne,
  deleteOne,
  partialUpdate,
  fullUpdate,
}