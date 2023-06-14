const mongoose = require("mongoose");
const constants = require("../constants");
const { validateObjectId, successResponse, createError, errorResponse, validatePaginationParams } = require("./utils/controller.utils");

const Activity = mongoose.model(process.env.ACTIVITY_MODEL);

const findAll = function (req, res) {
  validatePaginationParams(req.query.offset, req.query.count)
    .then(({ page, count }) => Activity.find().skip(page).limit(count).exec())
    .then((activities) => successResponse(res, activities))
    .catch((error) => errorResponse(res, error))
}

const findOne = (req, res) => {
  validateObjectId(req.params.activityId)
    .then((activityId => Activity.findById(activityId).exec()))
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => successResponse(res, activity))
    .catch((error) => errorResponse(res, error))
}

const insertOne = function (req, res) {
  _fillActivity(req.body)
    .then((activity) => Activity.create(activity))
    .then((activity) => successResponse(res, activity))
    .catch((error) => errorResponse(res, error))
}

const deleteOne = function (req, res) {
  validateObjectId(req.params.activityId)
    .then((activityId) => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => Activity.deleteOne({ _id: activity._id }).exec())
    .then((acknowledgeObject) => successResponse(res, acknowledgeObject))
    .catch((error) => errorResponse(res, error))
}

const partialUpdate = function (req, res) {
  const activityId = req.params.activityId;
  const update = req.body;

  validateObjectId(activityId)
    .then((activityId) => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then(() => _fillActivity(update))
    .then((activity) => Activity.findOneAndUpdate({ _id: activityId }, activity, { new: true }))
    .then((updatedActivity) => successResponse(res, updatedActivity))
    .catch((error) => errorResponse(res, error))
}

const fullUpdate = function (req, res) {
  const activityId = req.params.activityId;
  const update = req.body;

  validateObjectId(activityId)
    .then((activityId) => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then(() => _fillActivity(update))
    .then((activityToUpdate) => _validateSchema(activityToUpdate))
    .then((activityToUpdate) => Activity.findOneAndReplace({ _id: activityId }, activityToUpdate, { new: true }))
    .then((updatedActivity) => successResponse(res, updatedActivity))
    .catch((error) => errorResponse(res, error))
}

const _validateSchema = function (activity) {
  return new Promise((resolve, reject) => {
    Activity.validate(activity).then(() => {
      resolve(activity);
    }).catch((error) => {
      error.status = constants.BAD_REQUEST_STATUS;
      reject(error);
    })
  })
}

const _fillActivity = function (data) {
  return new Promise((resolve, reject) => {
    const newActivity = {};
    if (data.name) newActivity.name = data.name;
    if (data.duration) newActivity.duration = data.duration;
    if (data.description) newActivity.description = data.description;
    if (data.benefits) newActivity.benefits = data.benefits;
    resolve(newActivity);
  })
}

const _checkIfActivityExist = function (activity) {
  return new Promise((resolve, reject) => {
    if (!activity) reject(
      createError(constants.BAD_REQUEST_STATUS, process.env.ACTIVITY_NOT_FOUND_MESSAGE)
    );
    resolve(activity);
  })
}

module.exports = {
  findAll,
  findOne,
  insertOne,
  deleteOne,
  partialUpdate,
  fullUpdate,
  util: {
    _checkIfActivityExist
  }
}