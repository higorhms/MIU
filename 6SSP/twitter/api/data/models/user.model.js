const mongoose = require("mongoose");

const userSchema = mongoose.Schema({
  name: {
    type: String,
    required: true,
  },
  username: {
    type: String,
    required: true,
    unique: true
  },
  password: {
    type: String,
    required: true,
    minlength: 8
  },
  followers: [{
    type: mongoose.Schema.Types.ObjectId,
    ref: process.env.USER_MODEL
  }]
})

mongoose.model(process.env.USER_MODEL, userSchema, process.env.USER_COLLECTION)

module.exports = userSchema;
