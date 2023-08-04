const http = require('http');
const fs = require('fs');
const querystring = require('querystring');
const path = require('path');

const server = http.createServer((req, res) => {
  if (req.method === 'GET') {
    res.writeHead(200, { 'Content-Type': 'text/html' });
    const file = fs.readFileSync(path.join(__dirname, "index.html"))
    res.write(file);
    return res.end();
  } 
  
  if (req.method === 'POST' && req.url === '/submit') {
    let body = '';

    req.on('data', (chunk) => {
      body += chunk;
    });

    req.on("end", ()=>{
      const post = querystring.parse(body);
      fs.writeFile('user-input.json', JSON.stringify(post), (err) => {
        if (err) throw err;
        res.writeHead(200, { 'Content-Type': 'text/html' });
        const file = fs.readFileSync(path.join(__dirname, "success.html"))
        res.write(file);
      });
    })
  }
});

server.listen(3000, () => {
  console.log(`Server running on http://localhost:3000`);
});