/**
 * 
 */
package thirdstage.exercise.classloader;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 3rdstage
 *
 */
public class SimplestClassLoaderTest{
	
	protected ClassLoader cl;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		this.cl = new SimplestClassLoader();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{}

	/**
	 * Test method for {@link thirdstage.exercise.classloader.SimplestClassLoader#loadClass(java.lang.String)}.
	 */
	@Test
	public void testLoadClassString() throws Exception{
		
		this.cl.loadClass("thirdstage.exercise.classloader.Order");
		
		this.cl.loadClass("thirdstage.exercise.classloader.Order");
		
		
	}

}
