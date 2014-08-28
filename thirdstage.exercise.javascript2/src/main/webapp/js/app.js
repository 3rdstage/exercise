(function(window, undefined) {
	"use strict";

	
	var app = {};

	var tags_0_5 = {
		"!top" : [ "workflow-app", "switch", "kill", "map-reduce", "pig",
				"sub-workflow", "fs", "java" ],
		"workflow-app" : {
			"attrs" : {
				"name" : null
			},
			"children" : [ "parameters", "global", "credentials", "start",
					"end", "decision", "fork", "join", "kill", "action" ]
		},
		"parameters" : {
			"children" : [ "property" ]
		},
		"property" : {
			"children" : [ "name", "value", "description" ]
		}
	};

	app.getOozieTags = function() {

		return tags_0_5;
	};

	if (typeof define === "function" && define.amd) {
	    define(app);
	  } else if (typeof module === "object" && module.exports) {
	    module.exports = app;
	  } else {
	    window.app = app;	// Is this okay? Why not 'window'? What about Eclipse' outline view.
	  }

}(window));