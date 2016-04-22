/*
 * GET http://127.0.0.1:3000/movies/Avatar
 */
var express = require('express');
var morgan = require('morgan');

var app = express();
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.use(morgan('dev'));
app.use('/posters', express.static('posters'));

app.get('/movies/Avatar', function(req, resp){
	var item = {
		'title' : 'Avatar',
		'director' : 'James Cameron'
	};
	resp.render('movie', item);
	//resp.end("Wow");
});

app.listen(3000);

