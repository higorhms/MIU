const mongoose = require("mongoose");

const Benefit = mongoose.model(process.env.BENEFIT_MODEL);

const validate = function (benefit) {
  return Benefit.validate(benefit);
}

module.exports = {
  validate
}