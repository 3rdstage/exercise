/**
 * 
 */
package thirdstage.exercise.svnclient.case1;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tigris.subversion.svnclientadapter.ISVNClientAdapter;
import org.tigris.subversion.svnclientadapter.ISVNDirEntry;
import org.tigris.subversion.svnclientadapter.SVNClientAdapterFactory;
import org.tigris.subversion.svnclientadapter.SVNRevision;
import org.tigris.subversion.svnclientadapter.SVNUrl;
//import org.tigris.subversion.svnclientadapter.commandline.CmdLineClientAdapterFactory;
import org.tigris.subversion.svnclientadapter.javahl.JhlClientAdapterFactory;

/**
 * @author 3rdstage
 *
 */
public class SvnClientAdapterConcurrencyTest{
	
	public static void main(String[] arg) throws Exception{
		
		String url1 = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		String url2 = "http://jetlang.googlecode.com/svn/trunk/";
		
		List<String> collector = new Vector<String>();
		
		SvnUrlListingTask runner1 = new SvnUrlListingTask(url1, null, null, collector);
		SvnUrlListingTask runner2 = new SvnUrlListingTask(url2, null, null, collector);
		
		List<SvnUrlListingTask> tasks = new ArrayList<SvnUrlListingTask>();
		tasks.add(runner1);
		tasks.add(runner2);

		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.invokeAll(tasks);
		executor.shutdown();
		
		for(String str : collector){
			System.out.println(str);
		}

		Assert.assertTrue(true); //success if arrived here.
		
	}
	
	private static class SvnUrlListingTask implements Callable<Void>{
		
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
		
		public SvnUrlListingTask(String url, 
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
				//System.out.printf("%1$s %2$s %3$d\n", url, entry.getPath(), entry.getLastChangedRevision().getNumber());
				//Thread.currentThread().sleep(1000);
			}
			return null;
		}
	}
	

}
