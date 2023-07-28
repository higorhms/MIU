# Lab 1
## Exercise 1
Write the necessary Node script to make this code work for all arrays:
[1,2,3,4,5,6,7,8].even(); // [2,4,6,8]
[1,2,3,4,5,6,7,8].odd(); // [1,3,5,7]
Test your code in Node.JS CLI

## Exercise 2
1. Explain why do we want sometimes to use setImmediate instead of using setTimeout? 
R: Because within an I/O cycle setImmediate will always be executed after the Poll queue.

2. Explain the difference between process.nextTick and setImmediate?
R: The process.nextTick is going to store the callbacks in a queue with higher priprity and execute it on the next iteration and before any other queue. setImmediate is going to be executed before I/O operations have a chance to run but, only in the Check phase.

3. Name 10 global modules/methods available in Node environment.

1 - Buffer.
2 - console.
3 - process.
4 - setTimeout.
5 - clearTimeout.
6 - setInterval.
7 - clearInterval.
8 - setImmediate.
9 - clearImmediate.
10 - global.

## Exercise 3 (Optional)
	// Fix the slow function to be asynchronous/non-blocking
	function slow(callback){ 
		for(let i=0; i<= 5e8; i++){}
		if (Math.random() > 0.5) { 	
			return callback("Error",null) 
		} 
		return callback(null, {id:12345}) 
	} 

	function exec(fn){ 
		// Complete the code here to implement chaining with callback
	}

	exec(slow).done(function(data){ console.log(data); })
		.fail(function(err){ console.log("Error: " + err); }); 
