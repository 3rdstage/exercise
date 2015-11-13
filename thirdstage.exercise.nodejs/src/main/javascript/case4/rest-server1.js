/*
 * POST http://127.0.0.1:3000/movies?title=Matrix&director=Wachowskis&year=1999
 */

var http = require('http');
var urlencode = require('urlencode');
var querystring = require('querystring');

var movieList = {
		titles: ['Avatar', 'Star Wars', 'Interstellar']
	};

var movieDetail = {
	'Avatar' : {
		'director' : 'James Cameron',
		'year' : 2009
	},
	'Star Wars' : {
		'director' : 'George Lucas',
		'year' : 1977
	},
	'Interstellar' : {
		'director' : 'Christopher Nolan',
		'year' : 2014

	}
}

var server = http.createServer(function(req, resp){

	var url = req.url;
	var method = req.method.toLowerCase();

	if(method == 'get'){

		if(url == '/movies'){
			showMovieList(req, resp);
		}else{
			showMovieDetail(req, resp);
		}

	}else if(method == 'post'){
		if(url == '/movies'){
			addMovie(req, resp);
		}else{

		}
	}
}).listen(3000);

function showMovieList(req, resp){

	resp.writeHead(200, {'Content-type':'application/json'});
	resp.end(JSON.stringify(movieList));
}

function showMovieDetail(req, resp){
	var title = req.url.split('/')[2];
	title = urlencode.decode(title);

	var item = movieDetail[title];
	if(item){
		resp.writeHead(200, {'Content-type':'application/json'});
		resp.end(JSON.stringify(item));

	}else{
		resp.writeHead(404);
		resp.end("No movie titled '" + title + "'.");
	}

}

function addMovie(req, resp){
	var body = '';

	req.on('data', function(data){
		body += data;
	});

	req.on('end', function(){
		var parsed = querystring.parse(body);
		var title = parsed['title'];
		var director = parsed['director'];

		movieList.titles.push(title);
		movieDetail[title] = {};
		movieDetail[title]['director'] = director;

		resp.writeHead(200, {'Content-type':'application/plain'});
		resp.end("Added movie titled '" + title + "'");
	});
}
