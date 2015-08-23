package thirdstage.exercise.storm.calc;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class SumPartitioningBolt extends BaseBasicBolt {
   
   private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		logger.info("Starting {}.execute", this.getClass().getSimpleName());
		String arg = input.getString(0);
		collector.emit(new Values(arg, input.getValue(1)));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	   declarer.declare(new Fields("result", "return-info"));

	}

}
