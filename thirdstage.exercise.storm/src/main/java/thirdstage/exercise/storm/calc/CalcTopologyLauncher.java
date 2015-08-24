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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

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
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JaxbAnnotationModule());

		if(args == null || args.length == 0){
			LocalDRPC drpc = new LocalDRPC();

			DRPCSpout sumSpt = new DRPCSpout(Function.SUM.name(), drpc);
			builder.setSpout("drpc-sum", sumSpt);
			builder.setBolt("sum-job", new SumJobBolt(), 2).shuffleGrouping("drpc-sum");
			builder.setBolt("sum-task", new SumTaskBolt(), 5).shuffleGrouping("sum-job");
			builder.setBolt("sum-task-result-join", new SumTaskResultJoinBolt(), 2)
				.fieldsGrouping("sum-task", new Fields("job-id"));
			builder.setBolt("sum-return", new ReturnResults(), 2).shuffleGrouping("sum-task-result-join");

			LocalCluster cluster = new LocalCluster();
			Config conf = new Config();
			Config.setFallBackOnJavaSerialization(conf, false);
			Config.registerSerialization(conf, SumTaskRequest.class);
			Config.registerSerialization(conf, SumTaskResult.class);
			cluster.submitTopology(DEFAULT_NAME, conf, builder.createTopology());

			SumJobRequest req1 = new SumJobRequest("R001", 1, 100, 1, 3, SumJobRequest.DEFAULT_DELAY);
			String reqStr1 = mapper.writeValueAsString(req1);

			SumJobRequest req2 = new SumJobRequest("R002", 101, 200, 1, 3, SumJobRequest.DEFAULT_DELAY);
			String reqStr2 = mapper.writeValueAsString(req2);

			logger.info(drpc.execute(Function.SUM.name(), reqStr1));
			logger.info(drpc.execute(Function.SUM.name(), reqStr2));
		}
	}

}
