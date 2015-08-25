package thirdstage.exercise.storm.calc;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
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
import backtype.storm.ILocalDRPC;
import backtype.storm.LocalCluster;
import backtype.storm.LocalDRPC;
import backtype.storm.StormSubmitter;
import backtype.storm.drpc.DRPCSpout;
import backtype.storm.drpc.ReturnResults;
import backtype.storm.generated.StormTopology;
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

	protected static StormTopology buildTopology(@Nullable ILocalDRPC localDrpc){
		int sumJobBoltNum = 2;
		int sumTaskBoltNum = 5;
		int sumJoinBoltNum = 2;
		int resultBoltNum = 2;

		TopologyBuilder builder = new TopologyBuilder();

		DRPCSpout sumSpt = null;
		if(localDrpc != null){
			//@TODO Find out the way to add LocalDRPC after building topology
			sumSpt = new DRPCSpout(Function.SUM.name(), localDrpc);
		}else{
			sumSpt = new DRPCSpout(Function.SUM.name());
		}

		builder.setSpout("drpc-sum", sumSpt);
		builder.setBolt("sum-job", new SumJobBolt(), sumJobBoltNum).shuffleGrouping("drpc-sum");
		builder.setBolt("sum-task", new SumTaskBolt(), sumTaskBoltNum).shuffleGrouping("sum-job");
		builder.setBolt("sum-task-result-join", new SumTaskResultJoinBolt(), sumJoinBoltNum)
		.fieldsGrouping("sum-task", new Fields("job-id"));
		builder.setBolt("sum-return", new ReturnResults(), resultBoltNum).shuffleGrouping("sum-task-result-join");

		return builder.createTopology();
	}

	public static void printUsage(PrintStream out){

		out.println("Specify the topology name in command line.");

	}

	public static void main(String... args) throws Exception{

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JaxbAnnotationModule());

		if(args == null || args.length == 0){
			printUsage(System.out);
			return;
		}

		String name = args[0];

		StormTopology topology = buildTopology(null);
		Config conf = new Config();
		conf.setFallBackOnJavaSerialization(false);
		conf.registerSerialization(SumTaskRequest.class);
		conf.registerSerialization(SumTaskResult.class);
		conf.setNumWorkers(3);

		try{
			logger.info("Submitting storm topology(name: {}) at {}", name, InetAddress.getLocalHost().getHostName());
			StormSubmitter.submitTopology(name, conf, topology);
		}catch(Exception ex){
			logger.error("Fail to submit the topology.", ex);
			throw ex;
		}
	}

}
