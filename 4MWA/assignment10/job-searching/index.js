const cors = require("cors");
require("./api/data/db");
const express = require("express");
const routes = require("./api/routes");

const app = express();
app.use(cors());
app.use(express.json());

app.use("/api", routes);

app.listen(3000, ()=>{
  console.log("Listening")
})