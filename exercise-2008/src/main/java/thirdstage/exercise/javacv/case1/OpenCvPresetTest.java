/**
 *
 */
package thirdstage.exercise.javacv.case1;

import java.io.File;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_highgui;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class OpenCvPresetTest {


	@Test
	public void testCvShowImage() throws Exception{

		File f = new File(ClassLoader.getSystemResource("thirdstage/exercise/javacv/case1/drop.png").toURI());
		String name = f.getAbsolutePath();

		IplImage img = opencv_imgcodecs.cvLoadImage(name);
		opencv_highgui.cvShowImage("Sample Image", img);
		opencv_highgui.waitKey();
		opencv_core.cvReleaseImage(img);
	}

}
