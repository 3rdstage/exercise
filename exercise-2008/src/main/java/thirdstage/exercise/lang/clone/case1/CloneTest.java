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

}
