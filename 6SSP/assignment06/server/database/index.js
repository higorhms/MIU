const MongoClient = require('mongodb').MongoClient;

let connection = null;

const get = () => {
  return connection;
}

const connect = () => MongoClient.connect('mongodb://localhost:27017')
    .then((client) => {
      connection = client.db('assignment06')
      console.log('Connected to database...')
    })


module.exports = {
  connect,
  get,
}