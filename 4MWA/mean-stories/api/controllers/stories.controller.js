const mongoose = require("mongoose");
const { successResponse, createError, errorResponse } = require("./util/utils");
const { is } = require("express/lib/request");

const Story = mongoose.model("Story");

const DEFAULT_COUNT = 10;
const DEFAULT_OFFSET = 1;

const _validatePaginationParams = function(offset, count){
  return new Promise((resolve, reject) => {
    if(!offset) offset = DEFAULT_OFFSET;
    if(!count) count = DEFAULT_COUNT;

    if(isNaN(offset) || isNaN(count)) reject(createError(400, "offset and count must be numbers"));

    offset = (offset - 1) * count;    
    resolve({offset, count})
  })
}

const findAll = function(req, res){
  const offset = parseInt(req.query.offset);
  const count = parseInt(req.query.count);

  _validatePaginationParams(offset, count)
    .then(({offset, count}) => Story.find().skip(offset).limit(count).exec())
    .then((stories) => successResponse(res, stories))
    .catch((error) => errorResponse(res, error))
}

const findOne = function(req, res){
  const storyId = req.params.storyId;

  _validateObjectId(storyId)
    .then(() => Story.findById(storyId))
    .then((story) => _checkIfStoryExist(story))
    .then((story) => successResponse(res, story))
    .catch((error) => errorResponse(res, error))
}

const _validateNewStatus = function(newStatus){
  return new Promise((resolve, reject) =>{
    if(newStatus !== "popular" && newStatus !== "un-popular"){ reject(createError(400, "invalid status: " + newStatus))}
    resolve(newStatus);
  })
}

const updateStatus = function(req, res){
  const storyId = req.params.storyId;
  const newStatus = req.body.status;

  _validateObjectId(storyId)
    .then(() => _validateNewStatus(newStatus))
    .then(() => Story.findById(storyId))
    .then((story) => _checkIfStoryExist(story))
    .then(()=> Story.findOneAndUpdate({_id: storyId}, {status: newStatus}, {new: true}))
    .then((updatedStory) => successResponse(res, updatedStory))
    .catch((error) => errorResponse(res, error));
}

const _checkIfStoryExist = function(story){
  return new Promise((resolve, reject) =>{
    if(!story) reject(createError(404, "Story not found"));
    resolve(story);
  })
}

const _validateObjectId = function(objectId){
  return new Promise((resolve, reject)=>{
    const isValid =  mongoose.isValidObjectId(objectId);
    if(!isValid) reject(createError(400, "invalid id" + objectId));
    resolve(objectId);
  })
}

module.exports = {
  findAll,
  findOne,
  updateStatus
}