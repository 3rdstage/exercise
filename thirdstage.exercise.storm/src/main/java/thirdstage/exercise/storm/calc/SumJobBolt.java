package thirdstage.exercise.storm.calc;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import org.apache.commons.math3.fraction.BigFraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class SumJobBolt extends BaseBasicBolt {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private ObjectMapper mapper = null;

	@Override
	public void prepare(Map conf, TopologyContext cntx){

		//@TODO Register the Jaskson mapper to the platform mbean server.
		super.prepare(conf, cntx);
		this.mapper = new ObjectMapper();
		mapper.registerModule(new JaxbAnnotationModule());
	}

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		String arg = input.getString(0);
		if(arg == null){
			throw new IllegalStateException("No argument is transfered.");
		}else{
			logger.debug("SumJobBolt - Received sum job: {}", arg);
		}

		SumJobRequest req = null;
		try{
			 req = this.mapper.readValue(arg, SumJobRequest.class);

		}catch(Exception ex){
			throw new IllegalStateException("The request is not deserialized properly.", ex);
		}
		List<SumTaskRequest> taskReqs = partitionSumRequest(req);
		final List<String> taskStrs = new ArrayList<>();
		String taskStr;
		for(int i = 0, n = taskReqs.size(); i < n; i++){
			try{
				taskStr = this.mapper.writeValueAsString(taskReqs.get(i));
				taskStrs.add(taskStr);
			}catch(Exception ex){
				//@TODO Need much more consideration on this situation.
				logger.error("The task is not serialized properly.", ex);
			}
		}

		for(String str : taskStrs){
			collector.emit(new Values(input.getValue(1), req.getId(), taskStrs.size(), str));
			logger.debug("SumJobBolt - Emitted sum task: {}", str);
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("return-info", "job-id", "tasks-total", "task-req"));
	}

	@Nonnull
	public static List<SumTaskRequest> partitionSumRequest(@Nonnull SumJobRequest req){
		final List<SumTaskRequest> taskReqs = new ArrayList<>(); //final for non-null return

		int from = req.getFrom();
		int to = req.getTo();
		int step = req.getStep();
		int partitions = req.getPartitions();
		int delay = req.getDelay();

		BigFraction interval = new BigFraction(to - from, partitions);

		int cnt = 1;
		int a = from;
		for(int i = from; i <= to; i = i + step){
			if(new BigFraction(i - from).compareTo(interval.multiply(cnt)) > 0){
				taskReqs.add(new SumTaskRequest(cnt, a, i - step, step, delay));
				a = i;
				cnt++;
			}
			if(i + step > to){ //the last loop
				taskReqs.add(new SumTaskRequest(cnt, a, to, step, delay));
			}
		}
		return taskReqs;
	}


}
