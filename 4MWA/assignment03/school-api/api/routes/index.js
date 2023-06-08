const express = require("express");
const studentsController = require("../controllers/students.controller")

const router = express.Router();

router.route("/students")
  .get(studentsController.getAll);

router.route("/students/:studentIndex")
  .get(studentsController.getOne);

module.exports = router;