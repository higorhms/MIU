const EventEmitter = require('events');

const eventEmitter = new EventEmitter();

eventEmitter.on("user-created", (data) => {
  console.log("user-created", data);
})

eventEmitter.emit("user-created", { id: 1, name: "Higor" })

