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
public class ArrayTest{
	
	@Test
	public void testArrayInit(){
		
		String[][] strs = new String[3][2];
		
		Assert.assertEquals(strs.length, 3);
		for(int i = 0, n = strs.length; i < n; i++){
			Assert.assertEquals(strs[i].length, 2);
		}
		for(String[] row : strs){
			for(String cell : row){
				Assert.assertNull(cell);
			}
		}
	}

}
