/**
 *
 */
package thirdstage.exercise.red5.case1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class SimpleRtmpClientTest {

	public static final int RTMP_PORT_DEFAULT = 1935;

	private final transient Logger logger = LoggerFactory.getLogger(this.getClass());



	@Test
	public void testConstructor1(){

		String host = "fms.12E5.edgecastcdn.net";
		int port = RTMP_PORT_DEFAULT;
		String app = "0012E5";

		SimpleRtmpClient client = new SimpleRtmpClient(host, port, app);

	}

}
