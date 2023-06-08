const studentsRepository = require('../data/repository/students.repository')

const _notFoundError = function(){
  const error = new Error('Student Not found');
  error.code = 404;
  throw error;
}

const _invalidIdError = function(id){
  const error = new Error('Invalid Id: ' + id);
  error.code = 400;
  throw error;
}

const getAll = async function(req, res){
  try {
    const students = await studentsRepository.getAll();

    return res.status(200).json(students);
  } catch (error) {
    return res.status(500).json(error.message);
  }
}

const getOne = async function(req, res){
  try {
    let studentId = req.params.studentId;

    if(!studentsRepository.validateId(studentId)) _invalidIdError(studentId); 

    const student = await studentsRepository.getOneById(studentId);

    if(!student) _notFoundError();
 
    return res.status(200).json(student);
  } catch (error) {
    return res.status(error.code).json({ message: error.message })
  }
}

const addOne = async function (req, res){
  const newStudent = _fillStudent(req.body);
  try {
    await studentsRepository.validateSchema(newStudent);
  } catch (error) {
    return res.status(400).json({ message: error});
  }

  try {
    const student = await studentsRepository.addOne(newStudent);

    return res.status(200).send(student)
  } catch (error) {
    return res.status(error.code).json({ message: error});
  }
}

const _fillStudent = function(data){
  const newStudent = {};

  if(data.name) newStudent.name = data.name;
  if(data.gpa) newStudent.gpa = data.gpa;

  return newStudent;
}

module.exports = {
  getAll,
  getOne,
  addOne
}