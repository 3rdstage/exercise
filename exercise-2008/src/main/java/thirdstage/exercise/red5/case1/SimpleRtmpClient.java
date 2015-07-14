/**
 *
 */
package thirdstage.exercise.red5.case1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.Validate;
import org.hibernate.validator.constraints.NotEmpty;
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
@ParametersAreNonnullByDefault
public class SimpleRtmpClient{

	public final static int CONNECTION_TIMEOUT_DEFAULT = 10000;

	private final transient Logger logger = LoggerFactory.getLogger(this.getClass());

	private final String host;

	private final int port;

	private final String app;

	/**
	 * Connection timeout for this client instance.
	 */
	private final int connTimeout;

	private final RTMPClient client = new RTMPClient(){

		@Override
		public void connectionOpened(RTMPConnection conn){
			super.connectionOpened(conn);
			logger.debug("RTMP Connection is opening.");
		}

		@Override
		public void connectionClosed(RTMPConnection conn){
			super.connectionClosed(conn);
			logger.debug("RTMP Connection is closing.");
		}
	};

	/**
	 * @param host
	 * @param port TCP port of the RTMP server to connect
	 * @param app
	 */
	public SimpleRtmpClient(@NotEmpty String host, @Min(1) @Max(65535) int port, String app){

		this(host, port, app, CONNECTION_TIMEOUT_DEFAULT);
	}

	/**
	 * @param host
	 * @param port TCP port of the RTMP server to connect
	 * @param app
	 * @param connTimeout connection timeout in millisecond
	 */
	public SimpleRtmpClient(@NotEmpty String host, @Min(1) @Max(65535) int port, String app, @Min(1) int connTimeout){

		Validate.inclusiveBetween(1, 65535, port, String.format("The port value %1$d is invalid.", port));
		Validate.isTrue(connTimeout > 0, "The connection timeout should be positive.");

		this.host = host;
		this.port = port;
		this.app = app;
		this.connTimeout = connTimeout;
	}


	/**
	 * Lock object to guard connect process only
	 */
	private final Lock connLock = new ReentrantLock();

	private final Condition connected = connLock.newCondition();

	/**
	 * Is there preceding try of connecting by any thread.
	 */
	private final AtomicBoolean isFirstConnecting = new AtomicBoolean(true);

	/**
	 * Is the connection established?
	 */
	private final AtomicBoolean isConnected = new AtomicBoolean(false);

	@GuardedBy("connLock")
	public void connect(){

		connLock.lock();

		//@TODO Need more consideration and code enhancement on connection timeout.
		try{
			if(isFirstConnecting.compareAndSet(true, false)){
				IPendingServiceCallback connCallback = new IPendingServiceCallback(){

					@Override
					public void resultReceived(IPendingServiceCall call){
						if("connect".equals(call.getServiceMethodName())){
							connLock.lock();
							try{
								isConnected.set(true);
								connected.signal();
								logger.debug("RTMP connection is established by thread[id: {}].", Thread.currentThread().getId());
							}finally{
								connLock.unlock();
							}
						}
					}
				};

				boolean succeeded;
				this.client.connect(host, port, app, connCallback);
				if(isConnected.get()){
					succeeded = true;
				}else{
					logger.debug("Thread[id: {}] will wait {} milli-seconds", Thread.currentThread().getId(), this.connTimeout);
					succeeded = this.connected.await(this.connTimeout, TimeUnit.MILLISECONDS);
				}

				if(succeeded){
					logger.debug("RTMP connection is made successfully by current thread.");
				}else{
					logger.error("RTMP connection try by current thread has timed-out");
				}
			}
			else{
				logger.debug("RTMP connection is in try by another thread.");
				boolean succeeded = this.connected.await(this.connTimeout, TimeUnit.MILLISECONDS);
				if(succeeded){
					logger.debug("RTMP connection is made successfully by a preceding try");
				}else{
					logger.debug("RTMP connection has failed by a preceding try and no retry would be made.");
				}
			}

		}catch(Exception ex){

		}finally{
			connLock.unlock();
		}
	}


	public void disconnect(){
		this.client.disconnect();
	}

	public void play(String file){

	}
}
