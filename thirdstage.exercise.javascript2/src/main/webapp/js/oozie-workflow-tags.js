(function(window, undefined) {

	var plus = {};

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
		},
		"name" : {},
		"value" : {},
		"description" : {},
		"global" : {
			"children" : [ "job-tracker", "name-node", "job-xml",
				"configuration" ]
		},
		"job-tracker" : {},
		"name-node" : {},
		"job-xml" : {},
		"configuration" : {
			"children" : [ "property" ]
		},
		"property" : {
			"children" : [ "name", "value", "description" ]
		},
		"name" : {},
		"value" : {},
		"description" : {},
		"credentials" : {
			"children" : [ "credential" ]
		},
		"credential" : {
			"attrs" : {
				"name" : null,
				"type" : null
			},
			"children" : [ "property" ]
		},
		"property" : {
			"children" : [ "name", "value", "description" ]
		},
		"name" : {},
		"value" : {},
		"description" : {},
		"start" : {
			"attrs" : {
				"to" : null
			}
		},
		"decision" : {
			"attrs" : {
				"name" : null
			},
			"children" : [ "switch" ]
		},
		"switch" : {
			"children" : [ "case", "default" ]
		},
		"case" : {
			"attrs" : {
				"to" : null
			}
		},
		"default" : {
			"attrs" : {
				"to" : null
			}
		},
		"fork" : {
			"attrs" : {
				"name" : null
			},
			"children" : [ "path" ]
		},
		"path" : {
			"attrs" : {
				"start" : null
			}
		},
		"join" : {
			"attrs" : {
				"name" : null,
				"to" : null
			}
		},
		"kill" : {
			"attrs" : {
				"name" : null
			},
			"children" : [ "message" ]
		},
		"message" : {},
		"action" : {
			"attrs" : {
				"name" : null,
				"cred" : null,
				"retry-max" : null,
				"retry-interval" : null
			},
			"children" : [ "ok", "error", "map-reduce", "pig", "sub-workflow",
				"fs", "java" ]
		},
		"map-reduce" : {
			"children" : [ "job-tracker", "name-node", "prepare", "job-xml",
				"configuration", "file", "archive", "streaming", "pipes" ]
		},
		"job-tracker" : {},
		"name-node" : {},
		"prepare" : {
			"children" : [ "delete", "mkdir" ]
		},
		"delete" : {
			"attrs" : {
				"path" : null
			}
		},
		"mkdir" : {
			"attrs" : {
				"path" : null
			}
		},
		"streaming" : {
			"children" : [ "mapper", "reducer", "record-reader",
				"record-reader-mapping", "env" ]
		},
		"mapper" : {},
		"reducer" : {},
		"record-reader" : {},
		"record-reader-mapping" : {},
		"env" : {},
		"pipes" : {
			"children" : [ "map", "reduce", "inputformat", "partitioner",
				"writer", "program" ]
		},
		"map" : {},
		"reduce" : {},
		"inputformat" : {},
		"partitioner" : {},
		"writer" : {},
		"program" : {},
		"job-xml" : {},
		"configuration" : {
			"children" : [ "property" ]
		},
		"file" : {},
		"archive" : {},
		"pig" : {
			"children" : [ "job-tracker", "name-node", "prepare", "job-xml",
				"configuration", "script", "param", "argument", "file",
				"archive" ]
		},
		"job-tracker" : {},
		"name-node" : {},
		"prepare" : {
			"children" : [ "delete", "mkdir" ]
		},
		"job-xml" : {},
		"configuration" : {
			"children" : [ "property" ]
		},
		"script" : {},
		"param" : {},
		"argument" : {},
		"file" : {},
		"archive" : {},
		"sub-workflow" : {
			"children" : [ "app-path", "propagate-configuration",
				"configuration" ]
		},
		"app-path" : {},
		"propagate-configuration" : {},
		"configuration" : {
			"children" : [ "property" ]
		},
		"fs" : {
			"children" : [ "name-node", "job-xml", "configuration", "delete",
				"mkdir", "move", "chmod", "touchz", "chgrp" ]
		},
		"name-node" : {},
		"job-xml" : {},
		"configuration" : {
			"children" : [ "property" ]
		},
		"delete" : {
			"attrs" : {
				"path" : null
			}
		},
		"mkdir" : {
			"attrs" : {
				"path" : null
			}
		},
		"move" : {
			"attrs" : {
				"source" : null,
				"target" : null
			}
		},
		"chmod" : {
			"attrs" : {
				"path" : null,
				"permissions" : null,
				"dir-files" : null
			},
			"children" : [ "recursive" ]
		},
		"recursive" : {},
		"touchz" : {
			"attrs" : {
				"path" : null
			}
		},
		"chgrp" : {
			"attrs" : {
				"path" : null,
				"group" : null,
				"dir-files" : null
			},
			"children" : [ "recursive" ]
		},
		"recursive" : {},
		"java" : {
			"children" : [ "job-tracker", "name-node", "prepare", "job-xml",
				"configuration", "main-class", "arg", "file", "archive",
				"capture-output", "java-opts", "java-opt" ]
		},
		"job-tracker" : {},
		"name-node" : {},
		"prepare" : {
			"children" : [ "delete", "mkdir" ]
		},
		"job-xml" : {},
		"configuration" : {
			"children" : [ "property" ]
		},
		"main-class" : {},
		"java-opts" : {},
		"java-opt" : {},
		"arg" : {},
		"file" : {},
		"archive" : {},
		"capture-output" : {},
		"ok" : {
			"attrs" : {
				"to" : null
			}
		},
		"error" : {
			"attrs" : {
				"to" : null
			}
		},
		"end" : {
			"attrs" : {
				"name" : null
			}
		},
		"switch" : {
			"children" : [ "case", "default" ]
		},
		"kill" : {
			"attrs" : {
				"name" : null
			},
			"children" : [ "message" ]
		},
		"map-reduce" : {
			"children" : [ "job-tracker", "name-node", "prepare", "job-xml",
				"configuration", "file", "archive", "streaming", "pipes" ]
		},
		"pig" : {
			"children" : [ "job-tracker", "name-node", "prepare", "job-xml",
				"configuration", "script", "param", "argument", "file",
				"archive" ]
		},
		"sub-workflow" : {
			"children" : [ "app-path", "propagate-configuration",
				"configuration" ]
		},
		"fs" : {
			"children" : [ "name-node", "job-xml", "configuration", "delete",
				"mkdir", "move", "chmod", "touchz", "chgrp" ]
		},
		"java" : {
			"children" : [ "job-tracker", "name-node", "prepare", "job-xml",
				"configuration", "main-class", "arg", "file", "archive",
				"capture-output", "java-opts", "java-opt" ]
		}
	};

	plus.getOozieTags = function(ver) {

		return tags_0_5;
	}

	if (typeof define === "function" && define.amd) {
		define(plus);
	} else if (typeof module === "object" && module.exports) {
		module.exports = plus;
	} else {
		this.plus = plus;
	}
})(window);