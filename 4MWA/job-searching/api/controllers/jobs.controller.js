const bcrypt = require("bcrypt");
const jobsRepository = require("../data/repositories/jobs.repository")
const { successResponse, errorResponse, createError } = require("./utils/controller.utils")

const _validatePaginationParams = function (offset, count) {
  return new Promise((resolve, reject) => {
    if (!offset) offset = 1;
    if (!count) count = 15;

    if (isNaN(offset) || isNaN(count)) reject(createError(400, "Offset and count must be numbers"));
    offset = (offset - 1) * count;
    resolve({ offset, count });
  })
}

const findAll = function (req, res) {
  const offset = req.query.offset;
  const count = req.query.count;
  const lat = parseFloat(req.query.lat);
  const lng = parseFloat(req.query.lng);
  let skills = req.query.skills;
  const sixMonthsAgo = new Date();
  sixMonthsAgo.setMonth(sixMonthsAgo.getMonth() - 6);
  let query = {
    postDate: {
      $gte: sixMonthsAgo,
    }
  };
  if (lat && lng) {
    query = {
      "location.coordinates": {
        $near: {
          $geometry: { type: "Point", coordinates: [lng, lat] },
          $maxDistance: 5000
        }
      }
    }
  } 
  if (skills) {
    skills = skills.split(" ")
    const regexQuery = skills.map(skill => new RegExp(skill, "i"));
    query.skills = {
      $in: regexQuery
    }
  }

  _validatePaginationParams(offset, count)
    .then(({ offset, count }) => jobsRepository.findAll(offset, count, query))
    .then((jobs) => successResponse(res, jobs))
    .catch((error) => errorResponse(res, error));
}

const insertOne = function (req, res) {
  _fillJob(req.body)
    .then((jobToBeCreated) => _validateJobSchema(jobToBeCreated))
    .then((jobToBeCreated) => _encryptSalary(jobToBeCreated))
    .then((jobToBeCreated) => jobsRepository.insertOne(jobToBeCreated))
    .then((job) => successResponse(res, job))
    .catch((error) => errorResponse(res, error))
}

const _encryptSalary = function (job) {
  return new Promise((resolve, reject) => {
    bcrypt.genSalt(10)
      .then((salt) => bcrypt.hash(job.salary, salt))
      .then((encrypted) => {
        job.salary = encrypted;
        resolve(job)
      }).catch((error) => reject(error))
  })
}

const updateOne = function (req, res) {
  const jobId = req.params.jobId;

  jobsRepository.validateObjectId(jobId)
    .then(() => jobsRepository.findOneById(jobId))
    .then((job) => _fillJob(req.body, job))
    .then((job) => job.save())
    .then((job) => successResponse(res, job))
    .catch((error) => errorResponse(res, error))
}

const findOne = function(req, res){
  const jobId = req.params.jobId;

  jobsRepository.validateObjectId(jobId)
    .then(() => jobsRepository.findOneById(jobId))
    .then((job) => _checkIfJobExist(job))
    .then((job) => successResponse(res, job))
    .catch((error) => errorResponse(res, error))
}

const _checkIfJobExist = function (job) {
  return new Promise((resolve, reject) => {
    if (!job) reject(createError(404, "job not found"));
    resolve(job);
  })
}

const deleteOne = function (req, res) {
  const jobId = req.params.jobId;
  jobsRepository, jobsRepository.validateObjectId(jobId)
    .then(() => jobsRepository.findOneById(jobId))
    .then((job) => _checkIfJobExist(job))
    .then(() => jobsRepository.deleteOne(jobId))
    .then((result) => successResponse(res, result))
    .catch((error) => errorResponse(res, error))
}

const _validateJobSchema = function (job) {
  return new Promise((resolve, reject) => {
    jobsRepository.validate(job)
      .then(() => resolve(job))
      .catch((error) => reject(error))
  })
}

const _fillJob = function (data, filledJob = {}) {
  return new Promise((resolve, reject) => {
    if (data.title) filledJob.title = data.title;
    if (data.salary) filledJob.salary = data.salary;
    if (data.location) filledJob.location = data.location;
    if (data.description) filledJob.description = data.description;
    if (data.experience) filledJob.experience = data.experience;
    if (data.skills) filledJob.skills = data.skills;
    resolve(filledJob);
  }).catch((error) => reject(error))
}

module.exports = {
  findAll,
  insertOne,
  updateOne,
  deleteOne,
  findOne
}