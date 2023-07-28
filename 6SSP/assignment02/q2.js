const fs = require("fs");
const http = require("http");
const path = require("path");

const server = http.createServer();

server.on("request", (request, response)=>{
  fs.readFile(path.join(__dirname, "large.jpeg"), (err, data)=>{
    console.log(data);

    response.write(data);
    response.end();
  })  
})

server.listen(3000, ()=>console.log("Listening to 3000"))