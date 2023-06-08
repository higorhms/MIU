const http = require("http");
const fs = require("fs");
const path = require("path");
require("dotenv").config();

const indexPage = fs.readFileSync(path.join(__dirname, "..", "pages", "index.html"))
const page1 = fs.readFileSync(path.join(__dirname, "..", "pages", "page1.html"))
const page2 = fs.readFileSync(path.join(__dirname, "..", "pages", "page2.html"))

const serveJson = (req, res) => {
  res.setHeader("Content-Type", "application/json");
  res.writeHead(200);
  res.end('{message: true}')
}

const serveIndex = (req, res) => {
  res.setHeader("Content-Type", "text/html");
  res.writeHead(200);
  res.end(indexPage)
}

const servePage1 = (req, res) => {
  res.setHeader("Content-Type", "text/html");
  res.writeHead(200);
  res.end(page1)
}

const servePage2 = (req, res) => {
  res.setHeader("Content-Type", "text/html");
  res.writeHead(200);
  res.end(page2)
}

const serveNotFoundPage = (req, res) => {
  res.setHeader("Content-Type", "text/html");
  res.writeHead(404);
  res.end("<html><body><h1>Not found</h1></body></html>")
}

const postRoutes = (req, res) => {
  serveJson(req, res);
}

const getRoutes = (req, res) => {
  const url = req.url;

  switch(url) {
    case "/": {
      serveIndex(req, res);
      break;
    }
    case "/index.html": {
      serveIndex(req, res);
      break;
    }
    case "/page1.html": {
      servePage1(req, res)
      break;
    }
    case "/page2.html": {
      servePage2(req, res)
      break;
    }
    default: {
      serveNotFoundPage(req, res);
      break;
    }
  }
}

const routing = (req, res) => {
  const method = req.method;

  switch(method){
    case 'GET': {
      return getRoutes(req, res);
    }
    case 'POST':{
      return postRoutes(req, res);
    }
  }
}

const server = http.createServer(routing);

server.listen(process.env.PORT, ()=>{
  console.log("Listening to port: ", process.env.PORT)
});