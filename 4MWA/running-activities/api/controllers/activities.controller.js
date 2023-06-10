const constants = require("../constants");
const {
  validateObjectId,
  successResponse,
  createError,
  errorResponse,
  validatePaginationParams
} = require("./utils/controller.utils");
const activitiesRepository = require("../data/repository/activities.repository");

const findAll = function (req, res) {
  validatePaginationParams(req.query.offset, req.query.count)
    .then((page, count) => activitiesRepository.findAll(page, count))
    .then((activities) => successResponse(res, activities))
    .catch((error) => errorResponse(res, error))
}

const findOne = (req, res) => {
  validateObjectId(req.params.activityId)
    .then((activityId => activitiesRepository.findById(activityId)))
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => successResponse(res, activity))
    .catch((error) => errorResponse(res, error))
}

const insertOne = function (req, res) {
  _fillActivity(req.body)
    .then((activity) => activitiesRepository.insertOne(activity))
    .then((activity) => successResponse(res, activity))
    .catch((error) => errorResponse(res, error))
}

const deleteOne = function (req, res) {
  validateObjectId(req.params.activityId)
    .then((activityId) => activitiesRepository.findById(activityId))
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => activitiesRepository.deleteOne(activity._id))
    .then((acknowledgeObject) => successResponse(res, acknowledgeObject))
    .catch((error) => errorResponse(res, error))
}

const partialUpdate = function (req, res) {
  const activityId = req.params.activityId;
  const update = req.body;

  validateObjectId(activityId)
    .then((activityId) => activitiesRepository.findById(activityId))
    .then((activity) => _checkIfActivityExist(activity))
    .then(() => _fillActivity(update))
    .then((activity) => activitiesRepository.partialUpdate(activityId, activity))
    .then((updatedActivity) => successResponse(res, updatedActivity))
    .catch((error) => errorResponse(res, error))
}

const fullUpdate = function (req, res) {
  const activityId = req.params.activityId;
  const update = req.body;

  validateObjectId(activityId)
    .then((activityId) => activitiesRepository.findById(activityId))
    .then((activity) => _checkIfActivityExist(activity))
    .then(() => _fillActivity(update))
    .then((activityToUpdate) => _validateSchema(activityToUpdate))
    .then((activityToUpdate) => activitiesRepository.fullUpdate(activityId, activityToUpdate))
    .then((updatedActivity) => successResponse(res, updatedActivity))
    .catch((error) => errorResponse(res, error))
}

const _validateSchema = function (activity) {
  return new Promise((resolve, reject) => {
    activitiesRepository.validate(activity).then(() => {
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
}