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
public class StringTest{

	@Test
	public void testSplit1(){
		
		String str = "home\\me\\books";
		
		// single backslash in Java = "\\"
		// double backslash in Regex with Java = "\\\\"
		String[] tokens = str.split("\\\\"); 
		Assert.assertEquals(tokens.length, 3);
	}
	
	@Test(expectedExceptions={RuntimeException.class})
	public void testSplit2(){
		String str = "home\\me\\books";
		
		// the following line would throw Exception
		String[] tokens = str.split(java.io.File.separator); 
	}
	
	@Test
	public void testEquals1(){
		
		String str1 = "A";
		String str2 = "ABC";
		
		Assert.assertTrue("A".equals(str1)); // absolutely true
		Assert.assertTrue(str1 == "A"); // can be true, cause of String pooling
		Assert.assertTrue("A".equals(str2.substring(0,1))); //absolutely true
		Assert.assertFalse(str2.substring(0,1) == "A"); //definitely false
		Assert.assertFalse(new String("A") == str1); //definitely false
		
		
		int n = 50000;
		String[] strs = new String[n];
		for(int i = 0; i < n; i++){
			strs[i] = String.valueOf(i).intern();
		}
		
		Assert.assertTrue(str1 == "A"); // can be true, cause of String pooling
		
	}
	
	
}
