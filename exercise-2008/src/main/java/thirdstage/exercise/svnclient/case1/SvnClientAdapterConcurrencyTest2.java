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
import org.tigris.subversion.svnclientadapter.ISVNClientAdapter;
import org.tigris.subversion.svnclientadapter.ISVNDirEntry;
import org.tigris.subversion.svnclientadapter.SVNClientAdapterFactory;
import org.tigris.subversion.svnclientadapter.SVNRevision;
import org.tigris.subversion.svnclientadapter.SVNUrl;
import org.tigris.subversion.svnclientadapter.javahl.JhlClientAdapterFactory;

/**
 *
 */
public class SvnClientAdapterConcurrencyTest2{
	
	/**
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception{
		
		String url1 = "http://javaparser.googlecode.com/svn/trunk/JavaParser/";
		String url2 = "http://jetlang.googlecode.com/svn/trunk/";
		
		List<String> collector = new Vector<String>();
		
		SvnUrlListingTask task1 = new SvnUrlListingTask(url1, null, null, collector);
		SvnUrlListingTask task2 = new SvnUrlListingTask(url2, null, null, collector);
		List<SvnUrlListingTask> tasks = new ArrayList<SvnUrlListingTask>();
		tasks.add(task1);
		tasks.add(task2);

		ExecutorService executor = null;
		try{
			executor = Executors.newCachedThreadPool();
			executor.invokeAll(tasks);
		
			//The ouput from the two tasks are expected be mixed in order. 
			for(String str : collector){
				System.out.println(str);
			}
		}catch(Exception ex){
			ex.printStackTrace(System.err);
		}finally{
			if(executor != null){
				try{ executor.shutdown(); }
				catch(Exception ex){}
			}
		}
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
			if(this.username != null) adp.setUsername(this.username);
			if(this.passwd != null) adp.setPassword(this.passwd);
	
			ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
			for(ISVNDirEntry entry : entries){
				collector.add(String.format("%1$s %2$s %3$d", url, entry.getPath(), entry.getLastChangedRevision().getNumber()));
				
				//intentionall sleep to demonstrate the concurrency more clearly.
				Thread.currentThread().sleep(500);
			}
			return null;
		}
	}
}
