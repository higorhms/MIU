const mongoose = require("mongoose");
const Station = mongoose.model(process.env.STATION_MODEL);

const DEFAULT_COUNT = 15;
const DEFAULT_OFFSET = 1;

const getAll = function (req, res) {
    let offset = parseInt(req.query.offset);
    let count = parseInt(req.query.count);
    if(!offset) offset = DEFAULT_OFFSET;
    if(!count) count = DEFAULT_COUNT;

    const response = {
        status: parseInt(process.env.REST_API_OK, 10),
        message: ""
    };

    if(isNaN(offset) || isNaN(count)) {return res.status(400).json({message: "offset and count must be numbers"})}
    if(count > 15){ return res.status(400).json({message: "you cannot ask for more than 15 recors"})} 
    offset = (offset - 1) * count;

    Station.find().skip(offset).limit(count).exec().then((stations)=>{
        response.message= stations;
    })
    .catch((err)=>{
        response.status= parseInt(process.env.REST_API_SYSTEM_ERROR, 10);
        response.message= err;
    })
    .finally(()=>{
        console.log(response.message);
        res.status(response.status).json(response.message);
    });
}

const getOne = function (req, res) {
    const stationId = req.params.stationId;
    const response = {
        status: parseInt(process.env.REST_API_OK, 10),
        message: ""
    };
    Station.findById(stationId).exec().then((station)=>{
        if (!station) {
            response.status = parseInt(process.env.REST_API_RESOURCE_NOT_FOUND_ERROR, 10);
            response.message = {
                "message": process.env.REST_API_RESOURCE_NOT_FOUND_MESSAGE
            };
        } else {
            response.message= station;
        }
    })
    .catch((err)=>{
        response.status= parseInt(process.env.REST_API_SYSTEM_ERROR, 10);
        response.message= err;
    })
    .finally(()=>{
        res.status(response.status).json(response.message);
    });
}

const deleteMany = function(req, res){
    const listToDelete = req.params.stationId.split(",");

    const response = {
        status: parseInt(process.env.REST_API_OK),
        message: ""
    }

    const arrayOfPromises = listToDelete.map(id => Station.deleteOne({_id: id}))

    Promise.all(arrayOfPromises)
        .then(()=>{
            response.message = {
                "message": process.env.REST_API_OK
            }
        })
        .catch((error) => {
            response.status=parseInt(process.env.REST_API_SYSTEM_ERROR, 10)
            response.message = error;
        })
        .finally(()=>{
            console.log("finally called", response)
            res.status(response.status).json(response.message)
        })
}

module.exports = {
    getAll,
    getOne,
    deleteMany
};