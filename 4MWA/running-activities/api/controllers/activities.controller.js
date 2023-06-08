const mongoose = require("mongoose");
const constants = require("../constants");
const callbackify = require("util").callbackify;
const {
  validateObjectId,
  internalServerErrorResponse,
  notfoundResponse,
  badRequestResponse,
  successResponse
} = require("./utils/controller.utils");

const activitiesRepository = require("../data/repository/activities.repository");

const Activity = mongoose.model(process.env.ACTIVITY_MODEL);

const insertOneWithCallback = callbackify(function (newActivity) {
  return Activity.create(newActivity);
})

const findByIdWithCallback = callbackify(function (activityId) {
  return Activity.findById(activityId).exec();
})

const deleteOneByIdWithCallback = callbackify(function (activityId) {
  return Activity.deleteOne({ _id: activityId }).exec();
})

const partialUpdateWithCallback = callbackify(function (activityId, newProperties) {
  return Activity.findOneAndUpdate({ _id: activityId }, newProperties, { new: true });
})

const fullUpdateWithCallback = callbackify(function (activityId, newActivity) {
  return Activity.findOneAndReplace({ _id: activityId }, newActivity, { new: true });
})

const validateWithCallback = callbackify(function (activity) {
  return Activity.validate(activity);
})

const findAll = function (req, res) {
  const offset = req.query.offset || constants.DEFAULT_OFFSET;
  const count = req.query.count || constants.DEFAULT_COUNT;

  if (isNaN(offset) || isNaN(count)) {return badRequestResponse(res, process.env.INVALID_PAGINATION_MESSAGE)};
  if (count > constants.DEFAULT_COUNT) return badRequestResponse(res, process.env.INVALID_COUNT_MESSAGE);

  activitiesRepository.findAll(offset, count)
    .then((activities) => successResponse(res, activities))
    .catch((err) => internalServerErrorResponse(res, err))
}

const findOne = (req, res) => {
  try {
    const activityId = req.params.activityId;
    validateObjectId(activityId);

    findByIdWithCallback(activityId, function (error, activity) {
      if (error) return internalServerErrorResponse(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);
      return successResponse(res, activity);
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const insertOne = function (req, res) {
  const newActivity = req.body;

  insertOneWithCallback(newActivity, (error, activity) => {
    if (error) return internalServerErrorResponse(res, error);
    return successResponse(res, activity);
  });
}

const deleteOne = function (req, res) {
  try {
    const activityId = req.params.activityId;
    validateObjectId(activityId);

    findByIdWithCallback(activityId, function (error, activity) {
      if (error) return internalServerErrorResponse(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      deleteOneByIdWithCallback(activityId, (deleteError, acknowledgeObject) => {
        if (deleteError) return internalServerErrorResponse(res, deleteError);

        return successResponse(res, acknowledgeObject);
      });
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const partialUpdate = function (req, res) {
  try {
    const activityId = req.params.activityId;
    const update = req.body;

    validateObjectId(activityId);

    findByIdWithCallback(activityId, function (error, activity) {
      if (error) return internalServerErrorResponse(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      partialUpdateWithCallback(activityId, update, function (err, updatedActivity) {
        if (err) return internalServerErrorResponse(res, err);
        return successResponse(res, updatedActivity);
      })
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const fullUpdate = function (req, res) {
  try {
    const activityId = req.params.activityId;
    const update = req.body;

    validateObjectId(activityId);

    findByIdWithCallback(activityId, function (error, activity) {
      if (error) return internalServerErrorResponse(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      validateWithCallback(update, function (validateError) {
        if (validateError) return badRequestResponse(res, validateError);

        fullUpdateWithCallback(activityId, update, function (err, updatedActivity) {
          if (err) return internalServerErrorResponse(res, err);
          return successResponse(res, updatedActivity);
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