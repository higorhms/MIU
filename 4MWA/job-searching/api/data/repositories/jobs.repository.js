const mongoose = require("mongoose");
const { createError } = require("../../controllers/utils/controller.utils");

const Job = mongoose.model("Job");

const findAll = function(offset, count, query) {
  return Job.find(query).skip(offset).limit(count).exec();
}

const findOneById = function(id){
  return Job.findById(id).exec();
}

const insertOne = function(job){
  return Job.create(job);
}

const validate = function(job){
  return Job.validate(job);
}

const deleteOne = function(jobId){
  return Job.deleteOne({ _id: jobId });
}

const validateObjectId = function(id){
  return new Promise((resolve, reject)=>{
    const isValid = mongoose.isValidObjectId(id);
    if(!isValid) reject(createError(400, "invalid object id"));
    resolve(id);
  })
}

module.exports = {
  findAll,
  insertOne,
  validate,
  validateObjectId,
  findOneById,
  deleteOne
}