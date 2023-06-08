const express = require("express");
require("dotenv").config();
const path = require("path");

const app = express();

app.use(express.static(path.join(__dirname, "..", "pages")));

app.post("*", (req,res)=> {
  return res.json({message: true});
});

app.listen(process.env.PORT, () => {
  console.log("Listening to port: ", process.env.PORT);
});
