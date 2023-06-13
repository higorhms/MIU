const express = require("express");
const cors = require("cors");
require("./api/data/db")
const routes = require("./api/routes");
const app = express();

app.use(cors());
app.use(express.json());

app.use("/api", routes);

app.set("port", 3000);

app.listen(app.get("port"), ()=>{
  console.log("listening to", app.get("port"))
})