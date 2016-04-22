
var users = {

	'user1' : {id: 'user1', username: 'Sangmmon', password: '1234'}
}

exports.findUserById = function(id){
	return users[id];
}

exports.addUser = function(user){
	users[user.id] = user;
}