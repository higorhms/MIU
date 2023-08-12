const mongoose = require("mongoose");

const userSchema = mongoose.Schema({
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
  followers: [String],
  following: [String]
})

mongoose.model(process.env.USER_MODEL, userSchema, process.env.USER_COLLECTION)

module.exports = userSchema;
