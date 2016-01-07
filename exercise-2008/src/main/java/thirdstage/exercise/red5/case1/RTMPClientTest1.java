/**
 *
 */
package thirdstage.exercise.red5.case1;

import java.util.Map;

import org.red5.client.net.rtmp.RTMPClient;
import org.red5.server.api.event.IEvent;
import org.red5.server.api.event.IEventDispatcher;
import org.red5.server.api.service.IPendingServiceCall;
import org.red5.server.api.service.IPendingServiceCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 * @see
 */
public class RTMPClientTest1 {

	private final transient Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test(enabled=false)
	public void test1(){

		if(true){
			throw new IllegalStateException("Not yet implemented.");
		}

		IEventDispatcher evDispatcher = new IEventDispatcher(){
			@Override
			public void dispatchEvent(IEvent ev){
				logger.debug("Event dispatched: {}", ev.toString());
			}
		};

		IPendingServiceCallback pendingSrvCb = new IPendingServiceCallback(){
			@Override
			public void resultReceived(IPendingServiceCall call){
				Map<?, ?> map = (Map<?, ?>) call.getResult();
				logger.debug("Pending service call back, response: {}", map.toString());
			}
		};

		RTMPClient client = new RTMPClient();
		client.setStreamEventDispatcher(evDispatcher);

		//@TODO To be continnued !
	}

}
