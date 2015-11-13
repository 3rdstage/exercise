/*
 * GET http://127.0.0.1:3000/movies
 * GET http://127.0.0.1:3000/movies/Avatar
 * GET http://127.0.0.1:3000/posters/Avatar-poster.jpg
 * GET http://127.0.0.1:3000/clips/Avatar-clip-001.jpg
 * GET http://127.0.0.1:3000/files/Avatar-clip-001.jpg
 * GET http://127.0.0.1:3000/movies/Matrix
 */
var express = require('express');
var app = express();

app.listen(3000);

app.use('/posters', express.static('posters'));
app.use('/clips', express.static('clips'));
app.use('/files', express.static('files'));

app.get('/movies', function(req, resp){
	resp.end("Movie List");
});

app.get('/movies/Avatar', function(req, resp){
	resp.end("Movie Detail : Avatar");
});

app.use(function(req, resp){
	console.log("Express");
	resp.end("Express");
});


