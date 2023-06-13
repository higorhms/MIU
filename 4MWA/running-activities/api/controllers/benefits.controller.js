
const mongoose = require("mongoose");
const callbackify = require("util").callbackify;
const {
  validateObjectId,
  notfoundResponse,
  successResponse,
  badRequestResponse,
  errorResponse,
  createError
} = require("./utils/controller.utils");
const { _checkIfActivityExist } = require("./activities.controller").util;
const activitiesRepository = require("../data/repository/activities.repository");
const benefitsRepository = require("../data/repository/benefits.repository");
const constants = require("../constants");
const { rejects } = require("assert");

const Activity = mongoose.model(process.env.ACTIVITY_MODEL);
const Benefit = mongoose.model(process.env.BENEFIT_MODEL);

const partialUpdateWithCallback = callbackify(function (activityId, updatedActivity) {
  return Activity.findOneAndUpdate({ _id: activityId }, updatedActivity, { new: true })
})

const validateWithCallback = callbackify(function (benefit) {
  return Benefit.validate(benefit);
})

const findAll = function (req, res) {
  const activityId = req.params.activityId;
  validateObjectId(activityId)
    .then((activityId) => activitiesRepository.findById(activityId))
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => successResponse(res, activity.benefits))
    .catch((error) => errorResponse(res, error))
}

const findOne = function (req, res) {
  const activityId = req.params.activityId;
  const benefitId = req.params.benefitId;

  validateObjectId(activityId)
    .then(() => validateObjectId(benefitId))
    .then(() => activitiesRepository.findById(activityId))
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => _checkIfBenefitExist(activity, benefitId))
    .then((benefit) => successResponse(res, benefit))
    .catch((error) => errorResponse(res, error))
}

const insertOne = function (req, res) {
  const activityId = req.params.activityId;
  const newBenefit = _fillBenefit(req.body);

  validateObjectId(activityId)
    .then(() => _validateSchema(newBenefit))
    .then(() => activitiesRepository.findById(activityId))
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
    .then(() => activitiesRepository.findById(activityId))
    .then((activity) => _checkIfActivityExist(activity))
    .then((activity) => _checkIfBenefitExist(activity, benefitId))
    .then((activity) => _removeBenefitFromActivity(activity, benefitId))
    .then((activity) => activity.save()) 
    .then((activity) => successResponse(res, activity))
    .catch((error) => errorResponse(res, error))
}

const partialUpdate = function (req, res) {
  try {
    const activityId = req.params.activityId;
    const benefitId = req.params.benefitId;
    const newBenefit = req.body;

    validateObjectId(activityId);
    validateObjectId(benefitId);

    findAllWithCallback(activityId, function (error, activity) {
      if (error) return internalServerError(res, error)
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      const benefit = activity.benefits.id(benefitId);

      if (!benefit) return notfoundResponse(res, process.env.BENEFIT_NOT_FOUND_MESSAGE);
      if (newBenefit.name) benefit.name = newBenefit.name;
      if (newBenefit.description) benefit.description = newBenefit.description;

      partialUpdateWithCallback(activityId, { $set: { benefits: activity.benefits } }, function (err, activity) {
        if (err) return internalServerError(res, err);
        const benefit = activity.benefits.id(benefitId);
        return successResponse(res, benefit);
      })
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const fullUpdate = function (req, res) {
  try {
    const activityId = req.params.activityId;
    const benefitId = req.params.benefitId;
    const newBenefit = req.body;

    validateObjectId(activityId);
    validateObjectId(benefitId);

    validateWithCallback(newBenefit, function (validateError) {
      if (validateError) badRequestResponse(res, validateError);

      findAllWithCallback(activityId, function (error, activity) {
        if (error) return internalServerError(res, error);
        if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

        const benefit = activity.benefits.id(benefitId);

        if (!benefit) return notfoundResponse(res, process.env.BENEFIT_NOT_FOUND_MESSAGE);

        const index = activity.benefits.findIndex(benefit => benefit._id.toString() === benefitId);
        newBenefit._id = benefit._id;
        activity.benefits[index] = newBenefit;

        partialUpdateWithCallback(activityId, { $set: { benefits: activity.benefits } }, function (err, activity) {
          if (error) return internalServerError(res, err);
          const benefit = activity.benefits.id(benefitId);
          return successResponse(res, benefit);
        })
      })
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
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
    benefitsRepository.validate(benefitSchema)
      .then(() => resolve(benefitSchema))
      .catch((error) => {
        error.status = constants.BAD_REQUEST_STATUS;
        reject(error);
      })
  })
}

const _addBenefitToActivity = function (activity, newBenefit) {
  return new Promise((resolve, reject) => {
    activity.benefits.push(newBenefit);
    resolve(activity);
  })
}

const _removeBenefitFromActivity = function (activity, benefitId) {
  return new Promise((resolve, reject) => {
    activity.benefits = activity.benefits.filter(benefit => benefit._id.toString() !== benefitId);
    resolve(activity)
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