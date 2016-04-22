
var express = require('express')
var session = require('express-session')

var app = express();

app.use(session({
	secret: 'My Secret',
	resave: false,
	saveUninitialized: false
}));

app.use(function(req, resp){
	var sessId = req.sessionID;
	var now = new Date();

	console.log('Received request from the client whose session ID: ' + sessId);

	if(req.session.visits){
		req.session.visits = parseInt(req.session.visits) + 1;
	}else{
		req.session.visits = 1;
	}

	req.session.last = now.getFullYear() + "/" + (now.getMonth() + 1) + "/" + now.getDate()
		+ " " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();

	if(!req.session.since){
		req.session.since = req.session.last;
	}

	console.log('The session detail - visits: ' + req.session.visits + ', last: ' + req.session.last
		+ ', since: ' + req.session.since);

	resp.end('Your visit histroy - visits: ' + req.session.visits + ', last: ' + req.session.last
		+ ', since: ' + req.session.since);
});

app.listen(3000);
