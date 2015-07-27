/**
 *
 */
package thirdstage.exercise.red5.case1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.red5.server.net.rtmp.event.VideoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 3rdstage
 *
 */
@Aspect
public class Red5VideoDataLoggingAspect {

	private final Logger logger = LoggerFactory.getLogger("RtmpVideoDataLogger");

	@Before("call(public void thirdstage.exercise.red5.case1.VideoDataHandlingStream.handleVideoData(org.red5.server.net.rtmp.event.VideoData)) && args(data)")
	public void beforeHadleVideoData(VideoData data){

		this.logger.debug((data != null) ? data.getData().toString() : "");
	}

}
