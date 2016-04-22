
var express = require('express');
var morgan = require('morgan');
var bodyParser = require('body-parser');
var session = require('express-session');
var passport = require('passport');
var users = require('./users');
var LocalStrategy = require('passport-local').Strategy;

var strategy;
var app = express();

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

app.use(morgan('dev'));
app.use(bodyParser.urlencoded({extended: false}));
app.use(session({
	secret: 'My Secret',
	resave: false,
	saveUninitialized: true
}));

app.use(passport.initialize());
app.use(passport.session());

strategy = new LocalStrategy({passReqToCallback: true},
	function(req, username, password, done){
		console.log("Local strategy; ", username, password);

		var user = users.findUserById(username);
		if(!user){
			return done(null, false, {message: "Unexisting username: " + username});
		}else if(user.password != password){
			return done(null, false, {message: "Incorrect password."});
		}
		console.log("User authenticated. : ", username);
});
passport.use(strategy);

passport.serializeUser(function(user, done){
	console.log("User serialized.: ", user);
	done(null, user.id);
});
passport.deserializeUser(function(id, done){
	console.log("User desialized.: ", id);
	var user = users.findUserById(id);
	done(null, user);
});

function isAuthenticated(req, resp, next){
	console.log('Authenticated: ', req.isAuthenticated());
	if(req.isAuthenticated()){
		return next();
	}else{
		resp.redirect('/login');
	}
};

app.get('/login', function(req, resp){
	resp.render('login', {isAthenticated: req.isAuthenticated()});
});

app.post('/login', passport.authenticate('local',
	{successRedirect: "/", failureRedirect: "/login"}));

app.listen(3000, function(err){
	if(err){
		console.error("Server startup error.", err);
		throw err;
	}
	console.log("Server started and listening port " + 3000);
});
