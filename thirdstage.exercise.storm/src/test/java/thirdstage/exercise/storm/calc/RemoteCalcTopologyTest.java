package thirdstage.exercise.storm.calc;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import thirdstage.exercise.storm.calc.CalcTopologyLauncher.Function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import backtype.storm.Config;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.utils.DRPCClient;

public class RemoteCalcTopologyTest {

	public static final String SYS_PROP_DRPC_ADDRESS = "exercise.storm.drpc.address";
	public static final String SYS_PROP_DRPC_PORT = "exercise.storm.drpc.port";

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String address;

	private int port;

	private ObjectMapper mapper;

	@BeforeClass
	public void beforeClass(){
		String addr = System.getProperty(SYS_PROP_DRPC_ADDRESS);
		if(addr != null){ this.address = addr; }
		else{ this.address = "203.235.192.39"; }

		int port = NumberUtils.toInt(System.getProperty(SYS_PROP_DRPC_PORT), -1);
		if(port > 0){ this.port = port; }
		else{ this.port = 3772; }

		this.mapper = new ObjectMapper();
		mapper.registerModule(new JaxbAnnotationModule());
	}

	@Test
	public void testSimple1() throws Exception{

		Config conf = new Config();
		conf.setFallBackOnJavaSerialization(false);
		conf.registerSerialization(SumTaskRequest.class);
		conf.registerSerialization(SumTaskResult.class);
		conf.put(Config.STORM_THRIFT_TRANSPORT_PLUGIN, "backtype.storm.security.auth.SimpleTransportPlugin");
		conf.put(Config.STORM_NIMBUS_RETRY_TIMES, 3);
		conf.put(Config.STORM_NIMBUS_RETRY_INTERVAL, 1000);
		conf.put(Config.STORM_NIMBUS_RETRY_INTERVAL_CEILING, 2000);
		conf.put(Config.DRPC_MAX_BUFFER_SIZE, 3000);
		DRPCClient client = new DRPCClient(conf, this.address, this.port);

		SumJobRequest req1 = new SumJobRequest("R001", 1, 100, 1, 3, SumJobRequest.DEFAULT_DELAY);
		String arg1 = mapper.writeValueAsString(req1);

		logger.info("Sending job request to DRPC server: {}", arg1);
		String resultStr1 = client.execute(Function.SUM.name(), arg1);
		logger.info("Recevied job result from DRPC server: {}", resultStr1);

		SumJobRequest req2 = new SumJobRequest("R002", 1, 1000, 1, 30, SumJobRequest.DEFAULT_DELAY);
		String arg2 = mapper.writeValueAsString(req2);

		logger.info("Sending job request to DRPC server: {}", arg2);
		String resultStr2 = client.execute(Function.SUM.name(), arg2);
		logger.info("Recevied job result from DRPC server: {}", resultStr2);

	}


}
