const mongoose = require("mongoose");

const jobSchema = mongoose.Schema({
  title: {
    type: String,
    required: true
  },
  salary: {
    type: String,
    required: true
  },
  location: {
    coordinates: {
      type: [Number],
      index: "2dsphere"
    },
  },
  description: {
    type: String,
    required: true
  },
  experience: {
    type: String,
    required: true
  },
  skills: {
    type: [String],
    required: true
  },
  postDate: {
    type: Date,
    default: new Date()
  }
})

mongoose.model("Job", jobSchema, "jobs");