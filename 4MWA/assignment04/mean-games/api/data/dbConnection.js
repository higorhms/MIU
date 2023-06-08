const MongoClient = require("mongodb").MongoClient;
const callbackify = require("util").callbackify;

const mongoConnectWithCallBack = callbackify((url) => MongoClient.connect(url));

let _connection = null;

const get = () => {
  return _connection;
}

const open = () => {
  if(_connection !== null) return _connection;
  mongoConnectWithCallBack(process.env.CONNECTION_STRING, (err, client) => {
    if(err) console.log(err);
    _connection = client.db(process.env.DATABASE_NAME);
    console.log(process.env.MSG_DATABASE_CONNECTED)
  })
}

module.exports = {
  get, open
}