const mongoose = require("mongoose");

const bookSchema = mongoose.Schema({
  title: {
    type: String,
    required: true,
  },
  ISBN: {
    type: String,
    required: true,
  },
  publishedDate: {
    type: String,
    required: true,
  },
  author: {
    type: String,
    required: true,
  }
})

mongoose.model('Book', bookSchema)