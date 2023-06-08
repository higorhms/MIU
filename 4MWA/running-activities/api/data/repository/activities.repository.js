const mongoose = require("mongoose");

const Activity = mongoose.model(process.env.ACTIVITY_MODEL);

const findAll = async function (offset, count) {
  return Activity.find().skip(offset).limit(count).exec();
}

const findById = async function(activityId) {
  return Activity.findById(activityId).exec();
}

module.exports = {
  findAll,
  findById
}