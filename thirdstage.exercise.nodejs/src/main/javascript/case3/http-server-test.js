var http = require('http');

var server = http.createServer(function(req, resp) {
	resp.setHeader("Content-type", "text/plain");

	resp.end("Hello World !");
});

server.listen(3000);

