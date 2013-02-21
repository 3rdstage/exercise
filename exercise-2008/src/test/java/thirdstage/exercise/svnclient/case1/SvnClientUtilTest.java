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
		
		String url = "http://203.235.212.49/svn2/framework-j2ee-6/main/trunk/nexcore.framework.core/src/main/java";
		String username = "OhSangMoon";
		String passwd = "201202svn";
		
		List<String> paths = SvnClientUtil.listNonJavaSourceFilesUnderUrl(url, username, passwd);
		
		for(String path : paths){
			System.out.println(path);
		}
		
		
	}

}
