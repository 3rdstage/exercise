/**
 * 
 */
package thirdstage.exercise.lang.misc;


import java.math.BigInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 3rdstage
 *
 */
public class BigIntegerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testToString16() throws Exception{
		
		String s = new String("!@#ABC123");
		byte[] bytes = s.getBytes();
		
		System.out.println("Byte array for '" + s + "' is : ");
		for(int i = 0, n = bytes.length; i < n; i++){
			System.out.print("[" + bytes[i] + "]");
		}
		
		String str = new BigInteger(bytes).toString(16);
		System.out.println("");
		System.out.println("Hex representation of BigInteger object constructed with above byte array is : " + str);
	}
}
