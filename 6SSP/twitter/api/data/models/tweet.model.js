const mongoose = require("mongoose");
const userSchema = require("./user.model");

const tweetsSchema = mongoose.Schema({
  description: {
    type: String,
    required: true
  },
  author: {
    type: mongoose.Schema.Types.ObjectId,
    ref: process.env.USER_MODEL, 
    required: true
  },
  date: {
    type: Date,
    required: true
  }
})

mongoose.model(process.env.TWEET_MODEL, tweetsSchema, process.env.TWEETS_COLLECTION);

module.exports = tweetsSchema;