/**
 * 
 */
package thirdstage.exercise.lang.clone.case1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 3rdstage
 *
 */
public class CloneTest{
	
	
	@Test
	public void testCallCloneInNonClonableClass(){
		
		Point pt = new Point(3, 1, "Purple");
		Point anotherPt = pt.clone();
		
		Assert.assertEquals(anotherPt.getX(), pt.getX());
		Assert.assertEquals(anotherPt.getY(), pt.getY());
		Assert.assertEquals(anotherPt.getColor(), pt.getColor());
	}
	
	
	@Test
	public void testCloneablePointWithoutCloneMethod(){
		
		Point2 pt = new Point2(3, 1, "Purple");
	}
	
	@Test
	public void testNormalCloneableObject() throws Exception{
		
		Point3 pt = new Point3(3, 1, "Purple");
		Point3 anotherPt = pt.clone();
		
		Assert.assertEquals(anotherPt.getX(), pt.getX());
		Assert.assertEquals(anotherPt.getY(), pt.getY());
		Assert.assertEquals(anotherPt.getColor(), pt.getColor());
	}
}
