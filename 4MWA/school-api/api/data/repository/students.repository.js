const mongoose = require("mongoose");

const Student = mongoose.model('Student');

const getAll = async function () {
  const students = await Student.find().exec();
  return students;
}

const getOneById = async function (id) {
  const student = await Student.findById(id).exec();
  return student;
}

const addOne = async function(student){
  return Student.create(student);
}

const validateId = function (id) {
  return mongoose.isValidObjectId(id);
}

const validateSchema = async function (student) {
  return Student.validate(student);
}

module.exports = { getAll, getOneById, validateId, validateSchema, addOne }