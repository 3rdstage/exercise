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
public class ReturnTest{
	
	@Test
	public void testReturn1(){
		Rectangle rect1 = new Rectangle(3, 5);
		
		Assert.assertEquals(rect1.getArea(), 15);
		
	}
}

class Rectangle{
	
	private int x, y;
	
	public Rectangle(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getArea(){
		int result;
		
		return result = x * y;
	}
	
	
}
