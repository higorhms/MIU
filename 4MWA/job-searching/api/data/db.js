const mongoose = require("mongoose");
require("./models/index")
mongoose.connect("mongodb://localhost:27017/jobs");

mongoose.connection.on("connected", ()=>{
  console.log("mongoose connected");
})