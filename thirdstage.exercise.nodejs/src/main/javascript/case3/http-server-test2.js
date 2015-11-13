
var http = require("http");
var querystring = require("querystring");

var server = http.createServer(function(req, resp) {
	console.log('req.method', req.method);

	var body = '';

	req.on('data', function(data){
		body += data;
	});

	req.on('end', function(){
		var parsed = querystring.parse(body);
		console.log('name1 : ', parsed['name1']);
		resp.end("Post sample completed.");
	})

}).listen(3000);