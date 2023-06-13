const mongoose = require("mongoose");

const storySchema = mongoose.Schema({
  href: String,
  title: String,
  comments: Number,
  container: {
    name: String,
    short_name: String,
  },
  submit_date: Number,
  topic: {
    name: String,
    short_name: String,
  },
  promote_date: String,
  id: String,
  media: String,
  diggs: Number,
  description: String,
  link: String,
  user: {
    name: String,
    registered: Number,
    icon: String,
    profileviews: Number,
  },
  status: String
})

mongoose.model("Story", storySchema, "stories");