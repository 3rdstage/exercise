/**
 *
 */
package thirdstage.exercise.rtmp.client;

import org.red5.client.net.rtmp.ClientExceptionHandler;
import org.red5.client.net.rtmp.RTMPClient;
import org.red5.server.api.event.IEvent;
import org.red5.server.api.event.IEventDispatcher;
import org.red5.server.api.service.IPendingServiceCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 * @see https://code.google.com/p/red5/source/browse/java/client/trunk/test/org/red5/client/ClientTest.java?r=4352
 */
public class FirstTest {

	protected static Logger logger = LoggerFactory.getLogger(FirstTest.class);

	public static void main(String[] args){

		RTMPClient client = new RTMPClient();
		client.setExceptionHandler(new ClientExceptionHandler(){
			@Override
			public void handleException(Throwable th){
				logger.error(th.toString());
			}
		});

		client.setStreamEventDispatcher(new IEventDispatcher(){
			@Override
			public void dispatchEvent(IEvent ev){
				logger.info("ClientStream.dispatchEvent() : " + ev.toString());
			}
		});

		//@stopped

	}

}
