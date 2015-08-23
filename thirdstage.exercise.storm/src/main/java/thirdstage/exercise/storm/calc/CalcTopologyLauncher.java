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

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.LocalDRPC;
import backtype.storm.drpc.DRPCSpout;
import backtype.storm.drpc.ReturnResults;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class CalcTopologyLauncher {
   
   public static final String DEFAULT_NAME = "CalcTopology";
   
   private static Logger logger = LoggerFactory.getLogger(CalcTopologyLauncher.class);

	public enum Function{
		SUM,
		PRIME,
	}


	public static void main(String... args) throws Exception{

		TopologyBuilder builder = new TopologyBuilder();

		if(args == null || args.length == 0){
			LocalDRPC drpc = new LocalDRPC();

			DRPCSpout sumSpt = new DRPCSpout(Function.SUM.name(), drpc);
			builder.setSpout("drpc-sum", sumSpt);
			builder.setBolt("sum-partitioner", new SumPartitioningBolt(), 5).shuffleGrouping("drpc-sum");
			builder.setBolt("sum-return", new ReturnResults(), 3).shuffleGrouping("sum-partitioner");

			LocalCluster cluster = new LocalCluster();
			Config conf = new Config();
			cluster.submitTopology(DEFAULT_NAME, conf, builder.createTopology());
			
			logger.info(drpc.execute(Function.SUM.name(), "100"));
			logger.info(drpc.execute(Function.SUM.name(), "200"));
		}
	}

}
