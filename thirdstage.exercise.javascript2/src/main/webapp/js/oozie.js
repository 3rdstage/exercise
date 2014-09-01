(function(window, undefined) {
	"use strict";


	var oozie = {};

	var schemas = {};
	
	schemas["0.5"] = {
		"!top": ["workflow-app", "switch", "kill", "map-reduce", "pig", "sub-workflow", "fs", "java"],

		"workflow-app": {
			"attrs": {
				"name": null
			},
			"children": ["parameters", "global", "credentials", "start", "decision", "fork", "join", "kill", "action", "end"]
		},

		"parameters": {
			"children": ["property"]
		},
		"property": {
			"children": ["name", "value", "description"]
		},
		"name": {},
		"value": {},
		"description": {},

		"global": {
			"children": ["job-tracker", "name-node", "job-xml", "configuration"]
		},
		"job-tracker": {},
		"name-node": {},
		"job-xml": {},
		"configuration": {
			"children": ["property"]
		},

		"credentials": {
			"children": ["credential"]
		},
		"credential": {
			"attrs": {
				"name": null,
				"type": null
			},
			"children": ["property"]
		},	

		"start": {
			"attrs": {
				"to": null
			}
		},


		"decision": {
			"attrs": {
				"name": null
			},
			"children": ["switch"]
		},
		"switch": {
			"children": ["case", "default"]
		},
		"case": {
			"attrs": {
				"to": null
			}
		},
		"default": {
			"attrs": {
				"to": null
			}
		},	

		"fork": {
			"attrs": {
				"name": null
			},
			"children": ["path"]
		},
		"path": {
			"attrs": {
				"start": null
			}
		},	

		"join": {
			"attrs": {
				"name": null,
				"to": null
			}
		},

		"kill": {
			"attrs": {
				"name": null
			},
			"children": ["message"]
		},
		"message": {},


		"action": {
			"attrs": {
				"name": null,
				"cred": null,
				"retry-max": null,
				"retry-interval": null
			},
			"children": ["map-reduce", "pig", "sub-workflow", "fs", "java", "ok", "error"]
		},


		"map-reduce": {
			"children": ["job-tracker", "name-node", "prepare", "streaming", "pipes", "job-xml", "configuration", "file", "archive"]
		},
		"prepare": {
			"children": ["delete", "mkdir"]
		},
		"delete": {
			"attrs": {
				"path": null
			}
		},
		"mkdir": {
			"attrs": {
				"path": null
			}
		},
		"streaming": {
			"children": ["mapper", "reducer", "record-reader", "record-reader-mapping", "env"]
		},
		"mapper": {},
		"reducer": {},
		"record-reader": {},
		"record-reader-mapping": {},
		"env": {},
		"pipes": {
			"children": ["map", "reduce", "inputformat", "partitioner", "writer", "program"]
		},
		"map": {},
		"reduce": {},
		"inputformat": {},
		"partitioner": {},
		"writer": {},
		"program": {},
		"file": {},
		"archive": {},


		"pig": {
			"children": ["job-tracker", "name-node", "prepare", "job-xml", "configuration", "script", "param", "argument", "file", "archive"]
		},
		"script": {},
		"param": {},
		"argument": {},


		"sub-workflow": {
			"children": ["app-path", "propagate-configuration", "configuration"]
		},
		"app-path": {},
		"propagate-configuration": {},


		"fs": {
			"children": ["name-node", "job-xml", "configuration", "delete", "mkdir", "move", "chmod", "touchz", "chgrp"]
		},
		"move": {
			"attrs": {
				"source": null,
				"target": null
			}
		},
		"chmod": {
			"attrs": {
				"path": null,
				"permissions": null,
				"dir-files": null
			},
			"children": ["recursive"]
		},
		"recursive": {},
		"touchz": {
			"attrs": {
				"path": null
			}
		},
		"chgrp": {
			"attrs": {
				"path": null,
				"group": null,
				"dir-files": null
			},
			"children": ["recursive"]
		},


		"java": {
			"children": ["job-tracker", "name-node", "prepare", "job-xml", "configuration", "main-class", "java-opts", "java-opt", "arg", "file", "archive", "capture-output"]
		},
		"main-class": {},
		"java-opts": {},
		"java-opt": {},
		"arg": {},
		"capture-output": {},


		"ok": {
			"attrs": {
				"to": null
			}
		},

		"error": {
			"attrs": {
				"to": null
			}
		},

		"end": {
			"attrs": {
				"name": null
			}
		}
	};
	
	var idAttrs = {};
	idAttrs["0.5"] = [
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		{tag : "workflow-app", attr : "name"},
		
		
	];
	

	
	var workflowSamples = {};
	
	workflowSamples["0.1"] = 
		"<workflow-app name='example-forkjoinwf' xmlns=\"uri:oozie:workflow:0.1\">"
		+ "    <start to='firstjob' />"
		+ "    <action name=\"firstjob\">"
		+ "        <map-reduce>"
		+ "            <job-tracker>${jobtracker}</job-tracker>"
		+ "            <name-node>${namenode}</name-node>"
		+ "            <configuration>"
		+ "                <property>"
		+ "                    <name>mapred.mapper.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdMapper</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.reducer.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdReducer</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.map.tasks</name>"
		+ "                    <value>1</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.input.dir</name>"
		+ "                    <value>${input}</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.output.dir</name>"
		+ "                    <value>/usr/foo/${wf:id()}/temp1</value>"
		+ "                </property>"
		+ "            </configuration>"
		+ "        </map-reduce>"
		+ "        <ok to=\"fork\" />"
		+ "        <error to=\"kill\" />"
		+ "    </action>"
		+ "    <fork name='fork'>"
		+ "        <path start='secondjob' />"
		+ "        <path start='thirdjob' />"
		+ "    </fork>"
		+ "    <action name=\"secondjob\">"
		+ "        <map-reduce>"
		+ "            <job-tracker>${jobtracker}</job-tracker>"
		+ "            <name-node>${namenode}</name-node>"
		+ "            <configuration>"
		+ "                <property>"
		+ "                    <name>mapred.mapper.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdMapper</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.reducer.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdReducer</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.map.tasks</name>"
		+ "                    <value>1</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.input.dir</name>"
		+ "                    <value>/usr/foo/${wf:id()}/temp1</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.output.dir</name>"
		+ "                    <value>/usr/foo/${wf:id()}/temp2</value>"
		+ "                </property>"
		+ "            </configuration>"
		+ "        </map-reduce>"
		+ "        <ok to=\"join\" />"
		+ "        <error to=\"kill\" />"
		+ "    </action>"
		+ "    <action name=\"thirdjob\">"
		+ "        <map-reduce>"
		+ "            <job-tracker>${jobtracker}</job-tracker>"
		+ "            <name-node>${namenode}</name-node>"
		+ "            <configuration>"
		+ "                <property>"
		+ "                    <name>mapred.mapper.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdMapper</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.reducer.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdReducer</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.map.tasks</name>"
		+ "                    <value>1</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.input.dir</name>"
		+ "                    <value>/usr/foo/${wf:id()}/temp1</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.output.dir</name>"
		+ "                    <value>/usr/foo/${wf:id()}/temp3</value>"
		+ "                </property>"
		+ "            </configuration>"
		+ "        </map-reduce>"
		+ "        <ok to=\"join\" />"
		+ "        <error to=\"kill\" />"
		+ "    </action>"
		+ "    <join name='join' to='finalejob'/>"
		+ "    <action name=\"finaljob\">"
		+ "        <map-reduce>"
		+ "            <job-tracker>${jobtracker}</job-tracker>"
		+ "            <name-node>${namenode}</name-node>"
		+ "            <configuration>"
		+ "                <property>"
		+ "                    <name>mapred.mapper.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdMapper</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.reducer.class</name>"
		+ "                    <value>org.apache.hadoop.example.IdReducer</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.map.tasks</name>"
		+ "                    <value>1</value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.input.dir</name>"
		+ "                    <value>/usr/foo/${wf:id()}/temp2,/usr/foo/${wf:id()}/temp3"
		+ "                    </value>"
		+ "                </property>"
		+ "                <property>"
		+ "                    <name>mapred.output.dir</name>"
		+ "                    <value>${output}</value>"
		+ "                </property>"
		+ "            </configuration>"
		+ "        </map-reduce>"
		+ "        <ok to=\"end\" />"
		+ "        <ok to=\"kill\" />"
		+ "    </action>"
		+ "    <kill name=\"kill\">"
		+ "        <message>Map/Reduce failed, error message[${wf:errorMessage()}]</message>"
		+ "    </kill>"
		+ "    <end name='end'/>"
		+ "</workflow-app>"


		
	oozie.getTags = function(ver) {

		return schemas[ver];
	};
	
	oozie.getWorkflowSample = function(ver){
		return workflowSamples[ver];
	}

	window.app = window.app || {};
	window.app.oozie = oozie;

}(window));