/**
 * 
 */
package thirdstage.exercise.svnkit.case1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tmatesoft.svn.core.SVNDirEntry;


/**
 * @author 3rdstage
 *
 */
public class SvnUtilTest {
	
	private final static String USERNAME =  "OhSangMoon";
	
	private final static String PASSWD = "201202svn";

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
	 * Test method for {@link thirdstage.exercise.svnkit.case1.SvnUtil#listNonJavaSourceFilesUnderUrl(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testListEntriesUnderUrl() throws Exception{
		String url = "http://203.235.212.49/svn2/framework-j2ee-6/main/trunk/nexcore.framework.core/src/main/java";

		List<SVNDirEntry> entries = SvnUtil.listEntriesUnderUrl(url, this.USERNAME, this.PASSWD);
		
		int cnt = 1;
		for(SVNDirEntry entry : entries){
			System.out.printf("%1$5d, %2$s\n", cnt++, entry.getURL().toString());
		}
	}

	
	@Test
	public void testListJavaSourceEntriesUnderUrl() throws Exception{

		String url = "http://203.235.212.49/svn2/framework-j2ee-6/main/trunk/nexcore.framework.core/src/main/java";

		List<SVNDirEntry> entries = SvnUtil.listJavaSourceEntriesUnderUrl(url, this.USERNAME, this.PASSWD);
		
		int cnt = 1; 
		for(SVNDirEntry entry : entries){
			System.out.printf("%1$5d, %2$s\n", cnt++, entry.getURL().toString());
		}
	}
	
	@Test
	public void testListNonJavaSourceFileEntriesUnderUrl() throws Exception{

		String url = "http://203.235.212.49/svn2/framework-j2ee-6/main/trunk/nexcore.framework.core/src/main/java";

		List<SVNDirEntry> entries = SvnUtil.listNonJavaSourceFileEntriesUnderUrl(url, this.USERNAME, this.PASSWD);
		
		int cnt = 1; 
		for(SVNDirEntry entry : entries){
			System.out.printf("%1$5d, %2$s\n", cnt++, entry.getURL().toString());
		}
		
	}
	
	@Test
	public void testGenerateScriptToRelocateResources() throws Exception{
		
		String mainUrl = "http://203.235.212.49/svn2/framework-j2ee-6/main/trunk/nexcore.framework.core/src/main";
		String javaUrl = mainUrl + "/java";
		String resourcesUrl = mainUrl + "/resources";
		
		String script = SvnUtil.generateScriptToRelocateResources(javaUrl, resourcesUrl, this.USERNAME, this.PASSWD);
		
		System.out.println(script);
	}
	
	@Test
	public void testGenerateScriptToRelocateResources2() throws Exception{
		
		String mainUrl = "http://203.235.212.49/svn2/framework-j2ee-6/main/trunk/nexcore.framework.release/src/main";
		String javaUrl = mainUrl + "/java";
		String resourcesUrl = mainUrl + "/resources";
		
		String script = SvnUtil.generateScriptToRelocateResources(javaUrl, resourcesUrl, this.USERNAME, this.PASSWD);
		
		System.out.println(script);
	}
	
}
