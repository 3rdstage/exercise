/**
 *
 */
package thirdstage.exercise.lang.generics.case1;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;

import thirdstage.exercise.lang.generics.case1.Canvas.Point;


/**
 * @author 3rdstage
 *
 */
public class GenericsTest1 {

	@Test(description="Tests generics subtyping for collection element.")
	public void testSubtyping1(){

		//List<Shape> shapes1 = new ArrayList<Square>(); //compile-time error
		List<Rectangle> rects1 = new ArrayList<Rectangle>();
		List<Square> squares1 = new ArrayList<Square>();


		rects1.add(new Rectangle(10.0, 20.0));
		rects1.add(new Square(5.0)); //okay
		rects1.add(new Rectangle(10.0, 15.0));
		Assert.assertEquals(rects1.size(), 3);

		List<? extends Shape> shapes2 = rects1;
		List<? extends Rectangle> rects2 = new ArrayList<Square>();

		//shapes2.add(new Square(4.0));  //compile-time error
		Assert.assertEquals(shapes2.size(), 3);
		shapes2.remove(2);
		Assert.assertEquals(shapes2.size(), 2);


	}

	@Test(description="Test generics and Pair class of Apache Commons")
	public void testSubtyping2(){

		//compile time error
		//Pair<Shape, Shape> pair = Pair.of(new Rectangle(10.0, 15.0),  new Triangle(10.0, 10.0, 15.0));

		Pair<? extends Shape, ? extends Shape> pair = Pair.of(new Rectangle(10.0, 15.0),  new Triangle(10.0, 10.0, 15.0));

		Shape left = pair.getLeft();
		Rectangle rect = (Rectangle)pair.getLeft();

		Assert.assertEquals(left.getName(), rect.getName());
		Assert.assertEquals(left.getArea(), rect.getArea());

		Shape right = pair.getRight();
		Triangle tri = (Triangle)right;

		Assert.assertEquals(right.getName(), tri.getName());
		Assert.assertEquals(right.getArea(), tri.getArea());

	}


	@Test(description="Tests generic method")
	public void testSubtyping3(){

		Canvas canvas = new Canvas(1024, 768);

		canvas.draw(new Rectangle(10.0, 5.0), new Point(0.1, 0.1));

		Assert.assertEquals(canvas.getNumberOfElements(), 1);

		canvas.draw(new Square(8.5), new Point(0.5, 0.5));
		canvas.draw(new Triangle(7.5, 2.0, 7.5), new Point(0.7, 0.7));

		Assert.assertEquals(canvas.getNumberOfElements(), 3);

	}
}
