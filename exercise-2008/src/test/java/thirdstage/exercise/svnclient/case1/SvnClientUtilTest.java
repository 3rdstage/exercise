/**
 * 
 */
package thirdstage.exercise.svnclient.case1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 3rdstage
 *
 */
public class SvnClientUtilTest {

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

	/**
	 * Test method for {@link thirdstage.exercise.svnclient.case1.SvnClientUtil#listNonJavaSourceFilesUnderUrl(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testListNonJavaSourceFilesUnderUrl() throws Exception{
		
		String url = "http://jetlang.googlecode.com/svn/trunk/";
		String username = "guest";
		String passwd = null;
		
		List<String> paths = SvnClientUtil.listNonJavaSourceFilesUnderUrl(url, username, passwd);
		
		for(String path : paths){
			System.out.println(path);
		}
	}

	@Test
	public void testListNonJavaSourceFilesUnderUrl2() throws Exception{
		
		//String url = "http://jetlang.googlecode.com/svn/trunk/";
		String url = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		
		String username = null;
		String passwd = null;
		
		List<String> paths = SvnClientUtil.listNonJavaSourceFilesUnderUrl2(url, username, passwd);
		
		for(String path : paths){
			System.out.println(path);
		}
	}
	
}
