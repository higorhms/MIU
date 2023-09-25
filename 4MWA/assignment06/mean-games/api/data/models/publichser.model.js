const mongoose = require("mongoose");

const publisherSchema = mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  country: {
    type: String,
    required: true
  },
  established: {
    type: Number,
    required: true
  },
  location: {
    coordinates: {
      type: [Number],
      index: "2dsphere"
    }
  },
});

mongoose.model(process.env.PUBLISHER_MODEL, publisherSchema, process.env.PUBLISHER_COLLECTION);

module.exports = publisherSchema