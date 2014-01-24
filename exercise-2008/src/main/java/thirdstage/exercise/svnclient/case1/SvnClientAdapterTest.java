/**
 * 
 */
package thirdstage.exercise.svnclient.case1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import org.apache.subversion.javahl.ISVNClient;
import org.apache.subversion.javahl.SVNClient;
import org.apache.subversion.javahl.types.Version;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tigris.subversion.svnclientadapter.ISVNClientAdapter;
import org.tigris.subversion.svnclientadapter.ISVNDirEntry;
import org.tigris.subversion.svnclientadapter.ISVNStatus;
import org.tigris.subversion.svnclientadapter.SVNClientAdapterFactory;
import org.tigris.subversion.svnclientadapter.SVNNodeKind;
import org.tigris.subversion.svnclientadapter.SVNRevision;
import org.tigris.subversion.svnclientadapter.SVNUrl;
//import org.tigris.subversion.svnclientadapter.commandline.JhlClientAdapterFactory;
import org.tigris.subversion.svnclientadapter.javahl.JhlClientAdapterFactory;



public class SvnClientAdapterTest{
	
	@BeforeClass
	public void beforeClass(){
		
		
	}
	
	@Test
	public void testList1() throws Exception{
		
		/* JhlClientAdapterFactory : thread-safe
		 * JhlClientAdapter : NOT thread-safe
		 */
		String url = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		String username = null;
		String passwd = null;		
		
		//Just one time call of setup method is required in the same application (within A JVM instance).
		//Actually both of SVNClientAdapterFactory.isSVNClientAvailable() and JhlClientAdapterFactory.setup()
		//are NOT synchronized at all. So, you need to apply synchronization over the next
		//sample code when high contention is expected.
		if(!SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT)){
			JhlClientAdapterFactory.setup();
		} 
		
		//Aquire ISVNClientAdapter instance everywhere you need 
		//by calling SVNClientAdapterFactory.createSVNClient. 
		//ISVNClientAdapter is NOT thread-safe, so do NOT reuse an instance among threads.
		//Of cource, it is okay to reuse an object in the same thread (so in the same method local).
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		
		//adp.setUsername(username); //dosen't accept null
		//adp.setPassword(passwd); //dosen't accept null
		
		ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		Assert.assertTrue(entries.length > 0);
		System.out.printf("\n%1$s\n", url);
		for(ISVNDirEntry entry : entries) System.out.printf("  %1$s\n", entry.getPath());

		
		url = "http://jetlang.googlecode.com/svn/trunk/";
		
		//It's okay to reuse ISVNClientAdapter object in the same method local.
		ISVNDirEntry[] entries2 = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		Assert.assertTrue(entries2.length > 0);
		System.out.printf("\n%1$s\n", url);
		for(ISVNDirEntry entry : entries2) System.out.printf("  %1$s\n", entry.getPath());
	}
	@Test
	public void testSvnClientVersion() {
		ISVNClient svnClient = new SVNClient();
      Version version = svnClient.getVersion();
      System.out.println(version);

	}
	
	@Test
	public void testList2() throws Exception{
		
		/* JhlClientAdapterFactory : thread-safe
		 * JhlClientAdapter : NOT thread-safe
		 */
		String url = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		String username = null;
		String passwd = null;		
		
		//Just one time call of setup method is required in the same application (within A JVM instance).
		if(!SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT)){
			JhlClientAdapterFactory.setup();
		}
		
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		//adp.setUsername(username);
		//adp.setPassword(passwd);
		
		ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		Assert.assertTrue(entries.length > 0);
		System.out.printf("\n%1$s\n", url);
		for(ISVNDirEntry entry : entries) System.out.printf("  %1$s\n", entry.getPath());

		
		url = "http://jetlang.googlecode.com/svn/trunk/";
		
		ISVNClientAdapter adp2 = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		ISVNDirEntry[] entries2 = adp2.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		Assert.assertTrue(entries2.length > 0);
		System.out.printf("\n%1$s\n", url);
		for(ISVNDirEntry entry : entries2) System.out.printf("  %1$s\n", entry.getPath());
	}
	
	
	@Test
	public void testListAndGetRevision() throws Exception{
		
		if(!SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT)){
			JhlClientAdapterFactory.setup();
		}	

		String url = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		String username = null;
		String passwd = null;	
		
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		//adp.setUsername(username);
		//adp.setPassword(passwd);
		
		ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		ISVNStatus status = null;
		System.out.printf("\n%1$s\n", url);
		for(ISVNDirEntry entry : entries){
			if(SVNNodeKind.FILE.equals(entry.getNodeKind())){
				status = adp.getSingleStatus(new java.io.File(entry.getPath()));
				System.out.printf("  %1$s file %2$d\n", entry.getPath(), status.getRevision());
			}
		}
	}

	@Test
	public void testListAndGetRevision2() throws Exception{
		
		if(!SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT)){
			JhlClientAdapterFactory.setup();
		}

		String url = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		String username = null;
		String passwd = null;	
		
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		//adp.setUsername(username);
		//adp.setPassword(passwd);
		
		ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		System.out.printf("\n%1$s\n", url);
		for(ISVNDirEntry entry : entries){
			if(SVNNodeKind.FILE.equals(entry.getNodeKind())){
				System.out.printf("  %1$s file %2$d\n", entry.getPath(), 
					entry.getLastChangedRevision().getNumber());
			}
		}
	}
	

	@Test
	public void testGetRevision() throws Exception{
		
		if(!SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT)){
			JhlClientAdapterFactory.setup();
		}

		String url = "http://javaparser.googlecode.com/svn/trunk/JavaParser/pom.xml";
		String username = null;
		String passwd = null;	
		
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		//adp.setUsername(username);
		//adp.setPassword(passwd);

		ISVNStatus status = adp.getSingleStatus(new java.io.File(url));
		
		System.out.printf("\n%1$s file %2$d\n", url, status.getRevision());
	}
	
	@Test
	public void testGetRevision2() throws Exception{
		
		if(!SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT)){
			JhlClientAdapterFactory.setup();
		}

		String url = "http://javaparser.googlecode.com/svn/trunk/JavaParser/pom.xml";
		String username = null;
		String passwd = null;	
		
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		//adp.setUsername(username);
		//adp.setPassword(passwd);

		ISVNDirEntry entry = adp.getDirEntry(new SVNUrl(url), SVNRevision.HEAD);
		
		System.out.printf("\n%1$s file %2$d\n", url, entry.getLastChangedRevision().getNumber());
		
	}

	
	@Test
	public void testListWithRevisionConcurrently() throws Exception{
		
		String url1 = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		String url2 = "http://jetlang.googlecode.com/svn/trunk/";
		
		List<String> collector = new Vector<String>();
		
		SvnUrlListingRunner runner1 = new SvnUrlListingRunner(url1, null, null, collector);
		SvnUrlListingRunner runner2 = new SvnUrlListingRunner(url2, null, null, collector);
		
		List<SvnUrlListingRunner> runners = new ArrayList<SvnUrlListingRunner>();
		runners.add(runner1);
		runners.add(runner2);

		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.invokeAll(runners);
		
		for(String str : collector){
			System.out.println(str);
		}

		Assert.assertTrue(true); //success if arrived here.
		
	}
	
	private static class SvnUrlListingRunner implements Callable<Void>{
		
		private String url;
		private String username;
		private String passwd;
		List<String> collector;

		static{
			if(!SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT)){
				try{
					JhlClientAdapterFactory.setup();
				}catch(Exception ex){
					System.err.println("JhlClientAdapterFactory isn't setup correctly.");
				}
			}			
		}
		
		public SvnUrlListingRunner(String url, 
			@Nullable String username, @Nullable String passwd, List<String> collector){
			super();
			
			this.url = url;
			this.username = username;
			this.passwd = passwd;
			this.collector = collector;
		}
		
		@Override
		public Void call() throws Exception{
			ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
	
			ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
			for(ISVNDirEntry entry : entries){
				collector.add(String.format("%1$s %2$s %3$d", url, entry.getPath(), entry.getLastChangedRevision().getNumber()));
				//System.err.printf("%1$s %2$s %3$d\n", url, entry.getPath(), entry.getLastChangedRevision().getNumber());
				//Thread.currentThread().sleep(1000);
			}
			return null;
		}
	}
	
	
	
	
	
}
