	function Animal(){
		
		name = "a";
		
		this.greetings = function(){
			return "Hi, my name is " + this.name;
		}
		
		this.hello = function(){
			return this.greetings();
		}
	}	