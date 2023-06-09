const mongoose = require("mongoose");

const Activity = mongoose.model(process.env.ACTIVITY_MODEL);

const findAll = async function (offset, count) {
  return Activity.find().skip(offset).limit(count).exec();
}

const findById = async function (activityId) {
  return Activity.findById(activityId).exec();
}

const insertOne = async function (newActivity) {
  return Activity.create(newActivity);
}

const deleteOne = async function (activityId) {
  return Activity.deleteOne({ _id: activityId }).exec();
}

const partialUpdate = function (activityId, newProperties) {
  return Activity.findOneAndUpdate({ _id: activityId }, newProperties, { new: true });
}

const validate = function (activity) {
  return Activity.validate(activity);
}

const fullUpdate = function (activityId, newActivity) {
  return Activity.findOneAndReplace({ _id: activityId }, newActivity, { new: true });
}

module.exports = {
  findAll,
  findById,
  insertOne,
  deleteOne,
  partialUpdate,
  validate,
  fullUpdate
}