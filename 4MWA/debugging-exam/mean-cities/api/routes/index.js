const express= require("express");
const citiesController= require("../controllers/cities.controllers");

const router= express.Router();

router.route("/cities")
        .get(citiesController.getAll);

router.route("/cities/:cityId")
        .get(citiesController.getOne)
        .delete(citiesController.deleteOne);

module.exports= router;