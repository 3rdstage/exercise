
/**
 * 
*/ 
function scatterChart(spec){
	"use strict";
	
	var that = {};
	var defaultSpec = {};

	//initialize external property.
	//some properties would be fixed after initialized and others wouldn't
	var canvas = spec.canvas;
	var width = spec.width || 800;
	var height = spec.height || 600;
	var paddingTop = spec.paddingTop || spec.padding || 50;
	var paddingRight = spec.paddingRight || spec.padding || 50;
	var paddingBottom = spec.paddingBottom || spec.padding || 50;
	var paddingLeft = spec.paddingLeft || spec.padding || 50;
	var minX = spec.minX || 0;
	var maxX = spec.maxX || 1000;
	var minY = spec.minY || 0;
	var maxY = spec.maxY || 500;
	var pointSize = spec.pointSize || 2;
	var flowDuration = spec.flowDuration.initial || 10000; // speed in millisecond per pixel in screen
	var flowDurationMax = spec.flowDuration.max || 600000;
	var flowDurationMin = spec.flowDuration.min || 10000;
	var flowDurationStep = spec.flowDuration.step || 500;

	var dataMeta = {};
	dataMeta.meta = {
			fields : ["xValue", "yValue"],
			defaults : {
				index : [0, 1],
				name : ["x", "y"],
				unit : ["", ""],
				desc : ["", ""]
			} 
	};

	for(var i = 0; i < dataMeta.meta.fields.length; i++){
		dataMeta[dataMeta.meta.fields[i]] = {};
		if(spec.dataMeta && spec.dataMeta[dataMeta.meta.fields[i]]){
			dataMeta[dataMeta.meta.fields[i]].index = spec.dataMeta[dataMeta.meta.fields[i]].index || dataMeta.meta.defaults.index[i];
			dataMeta[dataMeta.meta.fields[i]].name = spec.dataMeta[dataMeta.meta.fields[i]].name || dataMeta.meta.defaults.name[i];
			dataMeta[dataMeta.meta.fields[i]].unit = spec.dataMeta[dataMeta.meta.fields[i]].unit || dataMeta.meta.defaults.unit[i];
			dataMeta[dataMeta.meta.fields[i]].desc = spec.dataMeta[dataMeta.meta.fields[i]].desc || dataMeta.meta.defaults.desc[i];
		}else{
			dataMeta[dataMeta.meta.fields[i]] = {
				index : dataMeta.meta.defaults.index[i],
				name : dataMeta.meta.defaults.name[i],
				unit : dataMeta.meta.defaults.unit[i],
				desc : dataMeta.meta.defaults.desc[i]
			};
		}
	}

	var dataAccessor = spec.dataAccessor;
	
	//time interval in millisecond to call data access function
	var dataAccessInterval = spec.dataAccessInterval.initial || 1000; 
	var dataAccessIntervalMax = spec.dataAccessInterval.max || 5000;
	var dataAccessIntervalMin = spec.dataAccessInterval.min || 400;
	var dataAccessIntervalStep = spec.dataAccessInterval.step || 200;
	

	//initialize internal properties
	var _xScale = d3.scale.linear().domain([minX, maxX]).range([paddingLeft, width - paddingRight]);
	var _yScale = d3.scale.linear().domain([minY, maxY]).range([height - paddingBottom, paddingTop]);

	var _xAxis = d3.svg.axis().scale(_xScale).orient("bottom");
	var _yAxis = d3.svg.axis().scale(_yScale).orient("left");

	var _svg = null;
	var _isFlowing = false;
	var _pointSeq = 0;  //@todo point sequence should be able to wrapped to avoid to become too large above the limit of the variable size;
	var _unstartedPoints = null;
	var _startedPoints = null;
	var _dataAccessorTimer = null;
	var _pointLabel = null;

	function drawPoints(){
		var _points = null;
		var _point = null;
		
		if(_isFlowing){
			_points = _svg.selectAll("circle")
				.data(dataAccessor, function(d){ return _pointSeq++;})
				.enter()
				.append("circle")
				.attr("cx", function(d){ return _xScale(d[dataMeta.xValue.index]);})
				.attr("cy", function(d){ return _yScale(d[dataMeta.yValue.index]);})
				.attr("r", pointSize);
	
			_points.transition()
				.attrTween("cx", function(){
					return d3.interpolateNumber(Number(d3.select(this).attr("cx")), width - paddingRight);
				})
				.duration(function(d){
					return flowDuration * (width - paddingRight - d3.select(this).attr("cx"))/(width - paddingRight - paddingLeft);
				})
				.ease("linear")
				.each("end", function(){
					d3.select(this).remove();
				});
					
			_svg.selectAll("circle").on("mouseover.tooltip", function(d){
				_point = d3.select(this);
				
				_pointLabel = _svg.append("text")
					.text("[" + d[0] + ", " + d[1] + "]")
					.attr("x", _point.attr("cx"))
					.attr("y", _point.attr("cy"));
					
			});
		}
	}

	that.draw = function(){
		_svg = d3.select(canvas)
			.append("svg")
			.attr("width", width)
			.attr("height", height);

		_svg.append("g")
			.classed("axis", true)
			.attr("transform", "translate(0, " + (height - paddingBottom) + ")")
			.call(_xAxis);

		_svg.append("g")
			.classed("axis", true)
			.attr("transform", "translate(" + paddingLeft + ", 0)")
			.call(_yAxis);

		_svg.selectAll(".axis line, .axis path")
			.style("fill", "none")
			.style("stroke", "black")
			.style("shape-rendering", "crispEdges");

		_dataAccessorTimer = self.setInterval(drawPoints, dataAccessInterval);

		return that;
	};

	that.isFlowing = function(){
		return _isFlowing;
	};

	that.flow = function(){
		if(_isFlowing) return;

		_svg.selectAll("circle").transition()
			.attrTween("cx", function(){
				return d3.interpolateNumber(Number(d3.select(this).attr("cx")), width - paddingRight);
			})
			.duration(function(d){
				return flowDuration * (width - paddingRight - d3.select(this).attr("cx"))/(width - paddingRight - paddingLeft);
			})
			.ease("linear")
			.each("end", function(){
				d3.select(this).remove();
			});

		_isFlowing = true;
		return that; 
	};

	that.stopFlow = function(){
		if(!_isFlowing) return;

		//@todo Still can't understand difference between _svg.selectAll("circle") and _points. 
		//They do be different. but why? and how?
		_svg.selectAll("circle").transition().duration(0);
		_isFlowing = false;
		return that;
	};

	that.getDataMeta = function(){
		return dataMeta;
	};

	that.getFlowDuration = function(){
		return flowDuration;
	};

	that.setFlowDuration = function(speed){

		if(speed > flowDurationMax) flowDuration = flowDurationMax;
		else if(speed < flowDurationMin) flowDuration = flowDurationMin;
		else flowDuration = speed;

		return that;
	};

	/**
	 * Increase the speed of the flow. 
	 * This function doesn't flow status of the chart. That means the frozen chart
	 * remains frozen after this function is called, although the attribute for the speed is changed.
	 * 
	 */
	that.speedUp = function(){
		var status = that.isFlowing();
		if(status) that.stopFlow();			 
		that.setFlowDuration(flowDuration - flowDurationStep);
		if(status) that.flow();
	};

	/**
	 * Decrease the speed of the flow.
	 * This function doesn't flow status of the chart. That means the frozen chart
	 * remains frozen after this function is called, although the attribute for the speed is changed.
	 */
	that.speedDown = function(){
		var status = that.isFlowing();
		if(status) that.stopFlow();			 
		that.setFlowDuration(flowDuration + flowDurationStep);
		if(status) that.flow();
	};
	
	that.initSpeed = function(){
		that.setFlowDuration(spec.flowDuration.initial);
	};
	
	that.getDataAccessInterval = function(){
		return dataAccessInterval;
	};
	
	that.setDataAccessInterval = function(interval){

		if(interval > dataAccessIntervalMax) dataAccessInterval = dataAccessIntervalMax;
		else if(interval < dataAccessIntervalMin) dataAccessInterval = dataAccessIntervalMin;
		else dataAccessInterval = interval;
		
		self.clearInterval(_dataAccessorTimer);
		_dataAccessorTimer = self.setInterval(drawPoints, dataAccessInterval);
		
		return that;
	};

	return that;
}


