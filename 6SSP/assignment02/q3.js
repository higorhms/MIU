const fs = require("fs");
const path = require("path");
const zlib = require("zlib");

const readStream = fs.createReadStream(path.join(__dirname, "hello.txt.zip"));
const writeStream = fs.createWriteStream(path.join(__dirname, "unzipped.txt"));

const gzip = zlib.createGunzip();

gzip.on("error", (error) => {
  console.error(error)
})

readStream.pipe(gzip).pipe(writeStream);