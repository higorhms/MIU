const mongoose = require("mongoose");
require("./models/index");
const callbackify = require("util").callbackify;

const mongooseDisconnectWithCallback = callbackify(function () {
  return mongoose.disconnect();
})

mongoose.connect(process.env.MONGODB_CONNECTION_STRING + process.env.MONGODB_DATABASE_NAME);

mongoose.connection.on("connected", function () {
  console.log(process.env.MONGOOSE_CONNECTED_MESSAGE + process.env.MONGODB_DATABASE_NAME);
})

mongoose.connection.on("disconnected", function () {
  console.log(process.env.MONGOOSE_DISCONNECTED_MESSAGE + process.env.MONGODB_DATABASE_NAME);
})

mongoose.connection.on("error", function (error) {
  console.log(process.env.MONGOOSE_CONNECTION_ERROR_MESSAGE + error);
})

process.on('SIGINT', function () {
  mongooseDisconnectWithCallback(function () {
    console.log(process.env.SIGINT_MESSAGE)
    process.exit(0);
  })
})