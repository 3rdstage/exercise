var server = require('net');
var port = 3100;

server.createServer(function(socket){
	var addr = socket.remoteAddress

	console.log("Connection established from " + addr);
	socket.write("Welcome to TCP echo server");


	socket.on('data', function(data){
		console.log("Received : " + data + " from " + addr);
		socket.write(data);
		socket.write('\n');
	});

	socket.on('close', function(data){
		console.log("Connection closed from " + addr);
	});
}).listen(port);

//console.log("Server started at " + server.address() + ":" + port);
