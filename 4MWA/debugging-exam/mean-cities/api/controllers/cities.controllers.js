const mongoose = require("mongoose");
const City = mongoose.model(process.env.CITY_MODEL);

const getAll = function (req, res) {
    let offset = parseInt(req.params.offset)
    let count = parseInt(req.params.count)

    if (!offset) offset = parseInt(process.env.DEFAULT_FIND_OFFSET);
    if (!count) count = parseInt(process.env.DEFAULT_FIND_COUNT);

    if (isNaN(offset) || isNaN(count)) { return res.status(process.env.REST_API_BAD_REQUEST_ERROR).json({ message: process.env.REST_API_COUNT_OFFSET_MESSAGE }) }
    if (count > process.env.DEFAULT_MAX_FIND_LIMIT) { return res.status(process.env.REST_API_BAD_REQUEST_ERROR).json({ message: process.env.REST_API_COUNT_EXCEEDED_MESSAGE }) }

    const response = {
        status: parseInt(process.env.REST_API_OK, 10),
        message: []
    };

    City.find().skip(offset).limit(count).exec()
        .then((cities) => {
            response.message = cities;
        })
        .catch((error) => {
            response.status = parseInt(process.env.REST_API_SYSTEM_ERROR, 10);
            response.message = error;
        })
        .finally(() => {
            return res.status(response.status).json(response.message);
        })
}

const getOne = function (req, res) {
    const cityId = req.params.cityId;
    City.findById(cityId).exec(function (err, city) {
        const response = {
            status: parseInt(process.env.REST_API_OK, 10),
            message: city
        };
        if (err) {
            response.status = parseInt(process.env.REST_API_SYSTEM_ERROR, 10);
            response.message = err;
        } else if (!city) {
            response.status = parseInt(process.env.REST_API_RESOURCE_NOT_FOUND_ERROR, 10);
            response.message = {
                "message": process.env.REST_API_RESOURCE_NOT_FOUND_MESSAGE
            };
        }
        res.status(response.status).json(response.message);
    });
}

const deleteOne = function (req, res) {
    const cityId = req.params.cityId;

    const response = {
        status: parseInt(process.env.REST_API_OK, 10),
        message: ""
    };
    City.findById(cityId)
        .then((city) => _checkIfCityExist(city))
        .then(() => City.deleteOne({ _id: cityId }))
        .then((acknowlegdeObj) => {
            response.message = acknowlegdeObj;
        })
        .catch((err) => {
            response.status = parseInt(process.env.REST_API_SYSTEM_ERROR, 10);
            response.message = err;
        })
        .finally(() => {
            res.status(response.status).json(response.message);
        })
}

const _checkIfCityExist = function (city) {
    return new Promise((resolve, reject) => {
        if (!city) reject({ status: parseInt(process.env.REST_API_RESOURCE_NOT_FOUND_ERROR), message: process.env.REST_API_RESOURCE_NOT_FOUND_MESSAGE })
        resolve(city);
    })
}

module.exports = {
    getAll,
    getOne,
    deleteOne
};