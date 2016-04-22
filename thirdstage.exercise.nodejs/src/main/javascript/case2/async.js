function task1(){
	console.log("Task1 started.");
	setTimeout(function(){
		console.log("Task1 done.");
	}, 3000);
}

function task2(){
	console.log("Task2 started.");
	setTimeout(function(){
		console.log("Task2 done.");
	}, 1000);
}

console.log("Concurrent execution.");
task1();
task2();


function task3(callback){
	console.log("Task3 started.");
	setTimeout(function(){
		console.log("Task3 done.");
		callback(null, "1");
	}, 3000);

}

function task4(callback){
	console.log("Task4 started.");
	setTimeout(function(){
		console.log("Task4 done.");
		callback(null, "2");
	}, 1000);

}

console.log("Sequential execution.");
var async = require('async');
async.series(
	[task3, task4],
	function(err, results){
		console.log('Success', results);
	});
