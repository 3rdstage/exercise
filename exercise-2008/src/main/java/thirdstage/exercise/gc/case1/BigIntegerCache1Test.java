/**
 * 
 */
package thirdstage.exercise.gc.case1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author 3rdstage
 *
 */
public class BigIntegerCache1Test {

	@Test
	public void testGarbageCollection1() throws Exception{
		BigIntegerCache1 cache = new BigIntegerCache1();
		System.out.printf("The cache object is created and referenced.%n");
		System.out.printf("The size of cache : %1$d%n", cache.getSize());
		
		cache.getBigInteger(500); //1st breakpoint
		cache.getBigInteger(40000);
		
		cache = null;
		System.gc(); 
		
		System.out.printf("The cache object is dereferenced and GC is requested.%n");
		System.out.printf("The test is completed.%n"); //2nd breakpoint
		
		Assert.assertTrue(true);
	}
}
