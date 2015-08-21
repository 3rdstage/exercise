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

import backtype.storm.LocalDRPC;
import backtype.storm.drpc.DRPCSpout;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class CalcTopologyLauncher {

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


		}
	}

}
