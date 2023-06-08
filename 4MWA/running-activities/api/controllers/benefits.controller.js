
const mongoose = require("mongoose");
const callbackify = require("util").callbackify;
const {
  validateObjectId,
  notfoundResponse,
  successResponse,
  badRequestResponse,
  internalServerError
} = require("./utils/controller.utils");

const Activity = mongoose.model(process.env.ACTIVITY_MODEL);
const Benefit = mongoose.model(process.env.BENEFIT_MODEL);

const findAllWithCallback = callbackify(function (activityId) {
  return Activity.findById(activityId).select(process.env.BENEFITS_COLLECTION).exec();
})

const partialUpdateWithCallback = callbackify(function (activityId, updatedActivity) {
  return Activity.findOneAndUpdate({ _id: activityId }, updatedActivity, { new: true })
})

const validateWithCallback = callbackify(function (benefit) {
  return Benefit.validate(benefit);
})

const findAll = function (req, res) {
  try {
    const activityId = req.params.activityId;
    validateObjectId(activityId);

    findAllWithCallback(activityId, function (error, activity) {
      if (error) return internalServerError(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      return successResponse(res, activity.benefits);
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message })
  }
}

const findOne = function (req, res) {
  try {
    const activityId = req.params.activityId;
    const benefitId = req.params.benefitId;

    validateObjectId(activityId);
    validateObjectId(benefitId);

    findAllWithCallback(activityId, function (error, activity) {
      if (error) return internalServerError(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      const benefit = activity.benefits.id(benefitId);

      if (!benefit) return notfoundResponse(res, process.env.BENEFIT_NOT_FOUND_MESSAGE);

      return successResponse(res, benefit);
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const insertOne = function (req, res) {
  try {
    const activityId = req.params.activityId;
    const newBenefit = req.body;

    validateObjectId(activityId);

    findAllWithCallback(activityId, function (error, activity) {
      if (error) return internalServerError(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      validateWithCallback(newBenefit, function (validateError) {
        if (validateError) return badRequestResponse(res, validateError);

        activity.benefits.push(newBenefit);

        partialUpdateWithCallback(activityId, activity, function (err, activity) {
          if (error) return internalServerError(res, err);

          return successResponse(res, activity);
        })
      })
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
}

const deleteOne = function (req, res) {
  try {
    const activityId = req.params.activityId;
    const benefitId = req.params.benefitId;

    validateObjectId(activityId);
    validateObjectId(benefitId);

    findAllWithCallback(activityId, function (error, activity) {
      if (error) return internalServerError(res, error);
      if (!activity) return notfoundResponse(res, process.env.ACTIVITY_NOT_FOUND_MESSAGE);

      const benefit = activity.benefits.id(benefitId);

      if (!benefit) return notfoundResponse(res, process.env.BENEFIT_NOT_FOUND_MESSAGE);

      partialUpdateWithCallback(activityId, { $pull: { benefits: { _id: benefitId } } }, function (err, acknowledgeObject) {
        if (error) return internalServerError(res, err);

        return successResponse(res, acknowledgeObject);
      })
    })
  } catch (error) {
    return res.status(error.status).json({ message: error.message });
  }
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

module.exports = {
  findAll,
  insertOne,
  findOne,
  deleteOne,
  partialUpdate,
  fullUpdate
}