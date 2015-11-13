
var http = require('http');
var formidable = require('formidable');

var server = http.createServer(function(req, resp){

	var form = new formidable.IncomingForm({
	});

	console.log('Form encoding: ', form.encoding);

	form.parse(req, function(err, fields, files){
		console.log('== Fields');
		console.log(fields);
		console.log('== Files');
		console.log('file1 : ', files['file1']['path']);
		console.log('file2 : ', files['file2']['path']);
		resp.end('Server process completed.');
	});

}).listen(3000);