const mongoose = require("mongoose");

const publisherSchema = require("./publichser.model")
const reviewSchema = require("./review.model")

const gameSchema = mongoose.Schema({
    title: {
        type: String,
        required: true
    },
    year: {
        type: Number,
        required: true
    },
    rate: {
        type: Number,
        required: true
    },
    price: {
        type: Number,
        required: true
    },
    minPlayers: {
        type: Number,
        required: true
    },
    maxPlayers: {
        type: Number,
        required: true
    },
    minAge: {
        type: Number,
        required: true
    },
    designers: [String],
    publisher: publisherSchema,
    reviews: [reviewSchema],
});

mongoose.model(process.env.GAME_MODEL, gameSchema, process.env.GAME_COLLECTION);