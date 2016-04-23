
	
var world = {};

$(function(){

	var continents = [
	   { "code": "AF", "name": "Africa",
		 "countries": [
		    {"name": "Ethiopia", "code": "ET"},
		    {"name": "Kenya", "code": "KE"},
		    {"name": "Zambia", "code": "ZM"},
		    {"name": "Cameroon", "code": "CM"},
		    {"name": "Egypt", "code": "EG"}
		 ]},
	   { "code": "AS", "name": "Asia",
		 "countries": [
		    {"name": "Korea, Republic of", "code": "KR"},
		    {"name": "Japan", "code": "JP"},
		    {"name": "China", "code": "CH"},
		    {"name": "India", "code": "IN"},
		    {"name": "Viet Nam", "code": "VN"}
		 ]}, 
	   { "code": "NA", "name": "North America",
		 "countries": [
		    {"name": "United States", "code": "US"},
		    {"name": "Canada", "code":"CA"},
		    {"name": "Mexico", "code":"MX"}
		 ]}, 
	   { "code": "SA", "name": "South America",
		 "countries": [
		    {"name": "Argentina", "code": "AR"},
		    {"name": "Brazil", "code": "BR"},
		    {"name": "Cambodia", "code": "KH"},
		    {"name": "Peru", "code": "PE"},
		    {"name": "Uruguay", "code": "UY"}
		 ]}, 
	   { "code": "EU", "name": "Europe",
		 "countries": [
		    {"name": "France", "code": "FR"},
		    {"name": "Italy", "code": "IT"},
		    {"name": "Denmark", "code": "DK"},
		    {"name": "Germany", "code": "DE"},
		    {"name": "Sweden", "code": "SE"}
		 ]}, 
	   { "code": "OC", "name": "Australia",
		 "countries": [
		    {"name": "Australia", "code": "AU"},
		    {"name": "New Zealand", "code": "NZ"}
		 ]}
	];
	
	world.getContinents = function(){
		return continents;
	};

	world.getCountriesByContinent = function(continentCode){
		var rt = [];
	
		$.each(continents, function(){
			if(this.code === continentCode){
				rt = this.countries;
				return false;
			};
		});
		return rt;
	};
	
	
	world.addCountries = function(continentCode, countries){

	}

	return world
});
	
