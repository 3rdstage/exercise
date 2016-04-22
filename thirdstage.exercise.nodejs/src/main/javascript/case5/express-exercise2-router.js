
var express = require('express');
var router = express.Router();

router.get('/movies', function(req, resp){
	resp.end("Movie List");
});

router.get('/movies/Avatar', function(req, resp){
	resp.end("Movie Detail : Avatar");
});

router.get('/movies/Matrix', function(req, resp, next){
	var err = new Error("The movie list doens't contain 'Matrix'");
	err.code = 404;
	next(err);
});

router.get('/songs', function(req, resp, next){
	var err = new Error("This system doensn't provide song list");
	err.code = 501;
	next(err);
})

module.exports = router;