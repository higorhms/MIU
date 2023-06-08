const mongoose = require("mongoose");

const benefitSchema = mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  description: {
    type: String,
    required: true
  }
})

mongoose.model(process.env.BENEFIT_MODEL, benefitSchema, process.env.BENEFITS_COLLECTION);

module.exports = benefitSchema;