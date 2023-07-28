const dns = require('dns');

dns.resolve("www.miu.edu", (err, data) => {
  console.log("IP : " + data);
})

