/**
 *
 */
package thirdstage.exercise.javacv.case1;

import java.io.File;

import org.apache.commons.lang3.Validate;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 * @see <a href="https://github.com/bytedeco/javacv/issues/160">FFmpegFrameGrabber could not play a rtmp stream</a>
 * @see <a href="https://groups.google.com/forum/#!topic/javacv/4O_iwvdIQyU">Capturing RTSP stream using javacv on Android</a>
 */
public class RtmpFrameCaptureTest {

	public static final String SAMPLE_RTMP_URL1="rtmp://fms.12E5.edgecastcdn.net/0012E5/mp4:videos/8Juv1MVa-485.mp4";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Test
	public void testCapture1(){

		String tmpDir = System.getenv("TMP");
		if(tmpDir == null){ tmpDir = System.getenv("TEMP"); }
		Validate.validState(tmpDir != null,
			"At least one of environment variables 'TMP' or 'TEMP' is expected to be defined.");

		//@TODO Extend Validate by
		//      adding validSystemProperty()
		//      adding validEnv()
		//      adding validFile()

		File f1 = new File(tmpDir + "/sample-001.mp4");
		Validate.validState(f1.exists(),
			"The file sample-001.mp4 is expected to be under " + tmpDir + " to run this test-case.");

		FFmpegFrameGrabber grabber = null;
		CanvasFrame canvas = null;

		try{
		grabber = new FFmpegFrameGrabber(SAMPLE_RTMP_URL1);
		//grabber.setFormat("mp4"); //useless, although confusing
		grabber.start();
		canvas = new CanvasFrame("Capture Preview", CanvasFrame.getDefaultGamma()/grabber.getGamma());
		Frame frame = null;

		while((frame = grabber.grabFrame()) != null){
			if(canvas.isVisible()){
				canvas.showImage(frame);
			}
		}

		}catch(Exception ex){
			logger.error("Exception occurred.", ex);
		}finally{

			if(canvas != null){
				canvas.dispose();
			}
			if(grabber != null){
				try{ grabber.stop(); }
				catch(Exception ex){}
			}
		}
	}

}
