const students = require("../data/school.json")

const getAll = (req, res) => {
  res.status(200).json(students);
}

const getOne = (req, res) => {
  let studentIndex = req.params.studentIndex;
  if(studentIndex > 0) studentIndex = studentIndex - 1;
  res.status(200).json(students[studentIndex]);
}

module.exports = {
  getAll,
  getOne
}