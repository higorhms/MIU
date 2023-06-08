const express = require("express");
require("dotenv").config();
const router = require("./api/routes");

const app = express();

app.use("/api", router);

app.set("port", process.env.PORT);

app.listen(app.get("port"), () => {
  console.log(process.env.MSG_START_APPLICATION, app.get("port"))
})