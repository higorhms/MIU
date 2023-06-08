const mongoose = require("mongoose");

const reviewSchema = mongoose.Schema({
  name: {
    type: String,
    required: true
  }, 
  review: {
    type: String,
    required: true
  }, 
  date: {
    type: Date,
    required: true
  }
});

mongoose.model(process.env.REVIEW_MODEL, reviewSchema, process.env.REVIEW_COLLECTION);

module.exports = reviewSchema;