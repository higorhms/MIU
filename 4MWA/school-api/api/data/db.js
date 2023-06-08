require('./models/student');
const mongoose = require("mongoose");

mongoose.connect("mongodb://localhost:27017/schools");

mongoose.connection.on("connected", () => {
  console.log("connected")
})
