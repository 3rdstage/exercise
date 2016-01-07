/**
 *
 */
package thirdstage.exercise.lang.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class InheritanceTest2 {

	@Test
	public void testThisAndInheritance(){

		Shape a = new Shape();
		Shape b = new Rectangle();
		Rectangle c = new Rectangle();


		Assert.assertEquals(a.className, "Shape");
		Assert.assertEquals(b.className, "Rectangle");
		Assert.assertEquals(c.className, "Rectangle");

	}

	public static class Shape{

		protected String className = this.getClass().getSimpleName();

		public double getArea(){
			return -1.0;
		}
	}

	public static class Rectangle extends Shape{

		private double width;
		private double height;

		@Override
		public double getArea(){
			return width * height;
		}
	}



}
