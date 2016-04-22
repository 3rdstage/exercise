/*
 * POST http://127.0.0.1:3000/movies?title=Matrix&director=Wachowskis&year=1999
 */
var express = require('express');
var bodyParser = require('body-parser');

var app = express();

app.listen(3000);

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

app.post('/movies', function(req, resp){
	console.log('Received movie to add in', req.get('Content-type'), ' type: ', req.body);
	resp.end('Received movie to add: ' + req.body);

});
