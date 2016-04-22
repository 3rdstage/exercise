/*
 * GET http://127.0.0.1:3000/movies
 */
var express = require('express');
var morgan = require('morgan');
var router = require('./route.js');

var app = express();
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.use(morgan('dev'));
app.use(router);

app.use(function(req, resp, next){
	var err;
	console.log("Unmapped URL");

	err = new Error("There's no service mapped to '" + req.url + "'");
	err.code = 404;
	next(err);
});

app.use(function(err, req, resp, next){
	console.log(err);
	resp.statusCode = err.code;
	resp.end(err.message);
});

app.listen(3000);