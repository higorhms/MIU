function slow(callback){ 
  setTimeout(() => {
    for(let i=0; i<= 5e8; i++){}

    if (Math.random() > 0.5) {
      return callback("Error", null);
    }

    return callback(null, { id: 12345 });
  }, 0);
} 

function exec(fn){ 
  // Complete the code here to implement chaining with callback
  const callbacks = {
      done: null,
      fail: null
    };

  fn(function(err, data){
    if(err){
      callbacks.fail(err);
    }else{
      callbacks.done(data);
    }
  });

  return {
    done: function(fn) {
      callbacks.done = fn;
      return this;
    },
    fail: function(fn){
      callbacks.fail = fn;
      return this;
    }
  }
}

exec(slow)
  .done(function(data){ 
    console.log("Done: " + JSON.stringify(data)); 
  })
  .fail(function(err){ 
    console.log("Error: " + JSON.stringify(err)); 
  }); 
