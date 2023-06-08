const child_process = require("child_process");

console.log("1: Start App");

child_process.spawn("node", [`compute.js`], {stdio: "inherit"});

console.log("2: App continues..");
