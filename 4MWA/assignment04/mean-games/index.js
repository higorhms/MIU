require("dotenv").config();
require("./api/data/dbConnection").open();

const express = require("express");
const path = require("path");
const router = require("./api/routes");

const app = express();

app.use(express.json());

app.use(express.static(path.join(__dirname, "pages")));

app.use("/api", router);

app.set("port", process.env.PORT);
app.listen(app.get("port"), () => {
  console.log(process.env.MSG_START_APPLICATION, app.get("port"))
})