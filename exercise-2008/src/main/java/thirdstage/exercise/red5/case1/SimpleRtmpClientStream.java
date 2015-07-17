/**
 *
 */
package thirdstage.exercise.red5.case1;

import org.red5.server.api.event.IEvent;
import org.red5.server.api.event.IEventDispatcher;
import org.red5.server.net.rtmp.event.IRTMPEvent;
import org.red5.server.stream.AbstractClientStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 */
public class SimpleRtmpClientStream extends AbstractClientStream implements
		IEventDispatcher {

	private transient final Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * The number of RTMP events this stream patched.
	 */
	private volatile int eventNum = 0;

	public int getNumberOfEvents(){ return this.eventNum; }

	/* (non-Javadoc)
	 * @see org.red5.server.api.stream.IStream#start()
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.red5.server.api.stream.IStream#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.red5.server.api.stream.IStream#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.red5.server.api.event.IEventDispatcher#dispatchEvent(org.red5.server.api.event.IEvent)
	 */
	@Override
	public void dispatchEvent(IEvent event) {
		if(!(event instanceof IRTMPEvent)){
			logger.debug("Skipping non RTMP event : {}", event.toString());
			return;
		}

		IRTMPEvent ev = (IRTMPEvent)event;
		this.eventNum++;
		logger.debug("RTMP event - no: {}, header: {}, class: {}",
				this.eventNum, ev.getHeader(), ev.getClass().getSimpleName());


	}

}
