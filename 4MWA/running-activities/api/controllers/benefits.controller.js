const mongoose = require("mongoose");
const { validateObjectId, successResponse, errorResponse, createError } = require("./utils/controller.utils");
const { _checkIfActivityExist } = require("./activities.controller").util;
const constants = require("../constants");

const Activity = mongoose.model(process.env.ACTIVITY_MODEL);
const Benefit = mongoose.model(process.env.BENEFIT_MODEL);

const findAll = function (req, res) {
  const activityId = req.params.activityId;

  validateObjectId(activityId)
    .then((activityId) => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => successResponse(res, activity.benefits))
    .catch((error) => errorResponse(res, error))
}

const findOne = function (req, res) {
  const activityId = req.params.activityId;
  const benefitId = req.params.benefitId;

  validateObjectId(activityId)
    .then(() => validateObjectId(benefitId))
    .then(() => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => _checkIfBenefitExist(activity, benefitId))
    .then((activity) => successResponse(res, activity.benefits.id(benefitId)))
    .catch((error) => errorResponse(res, error))
}

const insertOne = function (req, res) {
  const activityId = req.params.activityId;
  const newBenefit = _fillBenefit(req.body);

  validateObjectId(activityId)
    .then(() => _validateSchema(newBenefit))
    .then(() => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => _addBenefitToActivity(activity, newBenefit))
    .then((activity) => activity.save())
    .then((activity) => successResponse(res, activity))
    .catch((error) => errorResponse(res, error))
}

const deleteOne = function (req, res) {
  const activityId = req.params.activityId;
  const benefitId = req.params.benefitId;

  validateObjectId(activityId)
    .then(() => validateObjectId(benefitId))
    .then(() => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => _checkIfBenefitExist(activity, benefitId))
    .then((activity) => _removeBenefitFromActivity(activity, benefitId))
    .then((activity) => activity.save())
    .then((activity) => successResponse(res, activity))
    .catch((error) => errorResponse(res, error))
}

const partialUpdate = function (req, res) {
  const activityId = req.params.activityId;
  const benefitId = req.params.benefitId;
  const newBenefit = _fillBenefit(req.body);

  validateObjectId(activityId)
    .then(() => validateObjectId(benefitId))
    .then(() => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => _checkIfBenefitExist(activity, benefitId))
    .then((activity) => _updateFields(activity, benefitId, newBenefit))
    .then((activity) => activity.save())
    .then((activity) => successResponse(res, activity.benefits.id(benefitId)))
    .catch((error) => errorResponse(res, error));
}

const fullUpdate = function (req, res) {
  const activityId = req.params.activityId;
  const benefitId = req.params.benefitId;
  const newBenefit = _fillBenefit(req.body);

  validateObjectId(activityId)
    .then(() => validateObjectId(benefitId))
    .then(() => _validateSchema(newBenefit))
    .then(() => Activity.findById(activityId).exec())
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => _checkIfBenefitExist(activity, benefitId))
    .then((activity) => _updateFields(activity, benefitId, newBenefit))
    .then((activity) => successResponse(res, activity.benefits.id(benefitId)))
    .catch((error) => errorResponse(res, error))
}

const _checkIfBenefitExist = function (activity, benefitId) {
  return new Promise((resolve, reject) => {
    const benefit = activity.benefits.id(benefitId);
    if (!benefit) reject(
      createError(constants.NOT_FOUND_STATUS, process.env.BENEFIT_NOT_FOUND_MESSAGE)
    );
    resolve(activity);
  })
}

const _fillBenefit = function (data) {
  const filledBenefit = {};
  if (data.name) filledBenefit.name = data.name;
  if (data.description) filledBenefit.description = data.description;
  return filledBenefit;
}

const _validateSchema = function (benefitSchema) {
  return new Promise((resolve, reject) => {
    Benefit.validate(benefitSchema)
      .then(() => resolve(benefitSchema))
      .catch((error) => {
        error.status = constants.BAD_REQUEST_STATUS;
        reject(error);
      })
  })
}

const _addBenefitToActivity = function (activity, newBenefit) {
  return new Promise((resolve) => {
    activity.benefits.push(newBenefit);
    resolve(activity);
  })
}

const _removeBenefitFromActivity = function (activity, benefitId) {
  return new Promise((resolve) => {
    activity.benefits = activity.benefits.filter(benefit => benefit._id.toString() !== benefitId);
    resolve(activity)
  })
}

const _updateFields = function (activity, benefitId, newBenefit) {
  return new Promise((resolve) => {
    const benefit = activity.benefits.id(benefitId);
    if (newBenefit.name) benefit.name = newBenefit.name;
    if (newBenefit.description) benefit.description = newBenefit.description;
    resolve(activity);
  })
}


module.exports = {
  findAll,
  insertOne,
  findOne,
  deleteOne,
  partialUpdate,
  fullUpdate
}