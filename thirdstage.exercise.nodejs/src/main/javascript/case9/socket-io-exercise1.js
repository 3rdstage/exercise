
var http = require('http');
var fs = require('fs');
var path = require('path');
var io = require('socket.io');

var server = http.createServer(function(req, resp){

	fs.readFile('./socket-io-exercise1-client.html', encoding='utf-8', function(err, data){
		resp.writeHead(200, {"Content-type": "text/html; charset=UTF-8"});
		resp.end(data);

	});
})

server.listen(37091);

io = io.listen(server);

io.sockets.on('connection', function(socket){
	console.log('Connected');

	socket.on('disconnect', function(){
		console.log('Disconnected');
	});
})