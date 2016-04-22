
var express = require('express');
var router = express.Router();

var mongo = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/test";
var objId = require('mongodb').ObjectID;

var db;

mongo.connect(url, function(err, database){
	db = database;
	console.log("MongoDB connected to '", url, "'");

});

function showMovieList(req, resp){
	console.log("Starting showMovieList");
	db.collection('movies').find({}).toArray(function(err, docs){
		if(err){
			console.error(err);
			throw err;
		}
		console.log("Found all movies.\n", docs);
		resp.render('movie-list', {movies:docs});
	});
};


router.get('/movies', function(req, resp){
	showMovieList(req, resp);
});

module.exports = router;


