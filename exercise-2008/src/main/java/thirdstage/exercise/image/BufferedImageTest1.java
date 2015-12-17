/**
 *
 */
package thirdstage.exercise.image;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;

import org.jcodec.common.Assert;
import org.testng.annotations.Test;

/**
 * @author Sangmoon Oh
 *
 */
public class BufferedImageTest1 {

	@Test
	public void testGetRGB() throws Exception{

		String imgLoc = null;
		BufferedImage img = null;
		int w = 0;
		int h = 0;
		int[] pixels1 = null;
		int[] pixels2 = null;

		imgLoc = "thirdstage/exercise/image/gg-1.bmp";
		img = ImageIO.read(new File(ClassLoader.getSystemResource(imgLoc).toURI()));
		w = img.getWidth();
		h = img.getHeight();
		pixels1 = this.getPixelsFromBufferedImage(img);
		Assert.assertEquals(pixels1.length, w * h);
		pixels2 = this.getPixelsFromPixelGrabber(img);
		Assert.assertEquals(pixels2.length, w * h);
		Assert.assertArrayEquals(pixels1, pixels2);

		imgLoc = "thirdstage/exercise/image/gg-1.jpg";
		img = ImageIO.read(new File(ClassLoader.getSystemResource(imgLoc).toURI()));
		w = img.getWidth();
		h = img.getHeight();
		pixels1 = this.getPixelsFromBufferedImage(img);
		Assert.assertEquals(pixels1.length, w * h);
		pixels2 = this.getPixelsFromPixelGrabber(img);
		Assert.assertEquals(pixels2.length, w * h);
		Assert.assertArrayEquals(pixels1, pixels2);

	}

	private int[] getPixelsFromBufferedImage(@Nonnull BufferedImage img){
		int w = img.getWidth();
		int h = img.getHeight();
		return img.getRGB(0, 0, w, h, null, 0, w);
	}

	private int[] getPixelsFromPixelGrabber(@Nonnull BufferedImage img) throws Exception{
		int w = img.getWidth();
		int h = img.getHeight();

		PixelGrabber pg = new PixelGrabber(img, 0, 0, w, h, true);  //force RGB
		pg.grabPixels();

		return (int[])pg.getPixels();
	}



}
