/**
 *
 */
package thirdstage.exercise.red5.case1;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.Validate;
import org.apache.mina.core.buffer.IoBuffer;
import org.red5.server.api.event.IEvent;
import org.red5.server.api.event.IEventDispatcher;
import org.red5.server.net.rtmp.event.IRTMPEvent;
import org.red5.server.net.rtmp.event.VideoData;
import org.red5.server.net.rtmp.event.VideoData.FrameType;
import org.red5.server.net.rtmp.message.Header;
import org.red5.server.stream.AbstractClientStream;
import org.red5.server.stream.IStreamData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 */
public class VideoDataHandlingStream extends AbstractClientStream implements
		IEventDispatcher {

	private transient final Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * The number of RTMP events this stream dispatched.
	 */
	private volatile int eventNum = 0;

	/**
	 * The number of video data this stream dispatched.
	 */
	private volatile int videoDataNum = 0;

	public int getNumberOfEvents(){ return this.eventNum; }

	public int getNumberOfVideoData(){ return this.videoDataNum; }

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

		if(!(ev instanceof IStreamData)){
			logger.debug("Skipping non stream data");
			return;
		}
		if(ev.getHeader().getSize() == 0){
			logger.debug("Skipping event with 0 size");
			return;
		}
		if(ev instanceof VideoData){
			//delegate logging to handleVideoData method to prevent duplicate logging.
			this.videoDataNum++;
			this.handleVideoData((VideoData)ev);
		}

	}

	protected void handleVideoData(@Nonnull VideoData ev){
		Validate.isTrue(ev != null, "The video data to handle shouldn't null.");

		Header header = ev.getHeader();
		FrameType frmType = ev.getFrameType();
		byte dataType = ev.getDataType();
		IoBuffer data = ev.getData();

		logger.debug("Dispatched video event[data type: {}, frame type: {}]", dataType, frmType);

	}

}
