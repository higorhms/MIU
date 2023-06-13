const mongoose = require("mongoose");
require("../models/story.model")

mongoose.connect("mongodb://localhost:27017/meanStories");

mongoose.connection.on("connected", ()=>{
  console.log("mongoose connected")
})