require("dotenv").config();
require("./api/data/db");
const express = require("express");

const routes = require("./api/routes");
const app = express();

app.use(express.json());
app.use("/api", routes);

app.set("port", process.env.PORT);

app.listen(app.get("port"), function () {
  console.log(process.env.MSG_STARTED_TO_LISTEN + app.get("port"));
})