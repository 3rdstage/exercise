
var mocha = require('mocha');

it('Add', function(done){
	var value = 1 + 2;
	assert.equal(value, 3);
	done();
});

it('Minus', function(done){
	var value = 1 - 2;
	assert.equal(value, -1);
	done();
});
