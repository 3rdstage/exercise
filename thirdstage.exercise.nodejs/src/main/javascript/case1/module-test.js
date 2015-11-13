var greeting1 = require('./module1');
greeting1.goodMorning();

var greeting2 = require('./module2');
var app = new greeting2();
app.howAreYou();
app.sayGoodbye("John");