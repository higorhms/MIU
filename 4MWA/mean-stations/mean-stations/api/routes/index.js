const express= require("express");

const router= express.Router();
const stationsController= require("../controllers/stations.controllers");

router.route("/stations")
        .get(stationsController.getAll);

router.route("/stations/:stationId")
        .get(stationsController.getOne)
        .delete(stationsController.deleteMany)

module.exports= router;