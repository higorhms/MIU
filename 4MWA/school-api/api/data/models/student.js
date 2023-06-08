const mongoose = require("mongoose");

const studentSchema = mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  gpa: {
    type: Number,
    required: true,
  }
})

mongoose.model('Student', studentSchema, 'students');