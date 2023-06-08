const express = require("express");
const mathController = require("../controllers/math.controller")

const router = express.Router();

router.route("/multiply/:firstNumber")
  .get(mathController.multiply);

module.exports = router;