const mongoose = require("mongoose");

const benefitSchema = require("./benefit.model")

const activitySchema = mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    duration: {
        type: String,
        required: true
    },
    description: {
        type: String,
        required: true
    },
    benefits: [benefitSchema]
});

mongoose.model(process.env.ACTIVITY_MODEL, activitySchema, process.env.ACTIVITY_COLLECTION);