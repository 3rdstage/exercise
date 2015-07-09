/**
 *
 */
package thirdstage.exercise.red5.case1;

import org.red5.client.net.rtmp.RTMPClient;
import org.red5.server.api.service.IPendingServiceCall;
import org.red5.server.api.service.IPendingServiceCallback;
import org.red5.server.net.rtmp.RTMPConnection;
import org.red5.server.net.rtmp.codec.RTMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 * @see <a href="https://ptrthomas.wordpress.com/2008/04/19/how-to-record-rtmp-flash-video-streams-using-red5/">How to record RTMP flash video streams using Red5</a>
 * @see <a href="http://www.mekya.com/2014/11/07/how-to-extract-snapsot-image-from-rtmp-streams-videodata-in-red5-app/">How to extract snapsot image from RTMP stream’s videodata in Red5 App</a>
 * @see <a href="http://support.jwplayer.com/customer/portal/articles/1430358-using-rtmp-streaming">Using RTMP Streaming</a>
 */
public class SimpleRtmpClient{

	private final transient Logger logger = LoggerFactory.getLogger(this.getClass());

	private RTMPClient client = new RTMPClient();

	public SimpleRtmpClient(String host, int port, String app){

		IPendingServiceCallback connCallback = new IPendingServiceCallback(){
			@Override
			public void resultReceived(IPendingServiceCall call){
				if("connect".equals(call.getServiceMethodName())){
					logger.debug("Connection callback is invoked.");

				}
			}
		};

		client.connect(host, port, app, connCallback);
	}

	public void play(String file){

	}




}
