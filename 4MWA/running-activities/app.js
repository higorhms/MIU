require("dotenv").config();
require("./api/data/db");
const express = require("express");

const routes = require("./api/routes");
const app = express();

app.use(function (req, res, next) {
  res.header('Access-Control-Allow-Origin', 'http://localhost:4200');
  res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS, PATCH');
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, Authorization');
  next();
})

app.use(express.json());
app.use("/api", routes);

app.set("port", process.env.PORT);

app.listen(app.get("port"), function () {
  console.log(process.env.MSG_STARTED_TO_LISTEN + app.get("port"));
})