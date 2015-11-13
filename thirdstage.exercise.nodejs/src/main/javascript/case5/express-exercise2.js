/*
 * GET http://127.0.0.1:3000/movies
 * GET http://127.0.0.1:3000/movies/Avatar
 * GET http://127.0.0.1:3000/posters/Avatar-poster.jpg
 * GET http://127.0.0.1:3000/clips/Avatar-clip-001.jpg
 * GET http://127.0.0.1:3000/files/Avatar-clips.zip
 * GET http://127.0.0.1:3000/movies/Matrix
 */
var express = require('express');
var morgan = require('morgan');
var router = require('./express-exercise2-router.js');

var app = express();
app.listen(3000);

app.use(morgan('dev'));
app.use('/posters', express.static('posters'));
app.use('/clips', express.static('clips'));
app.use('/files', express.static('files'));

app.use(router);

app.use(function(req, resp){
	console.log("Express");
	resp.end("Express");
});


app.use(function(err, req, resp, next){
	console.log(err);
	resp.statusCode = err.code;
	resp.end(err.message);
});




