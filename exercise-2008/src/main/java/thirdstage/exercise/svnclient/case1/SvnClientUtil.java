/**
 * 
 */
package thirdstage.exercise.svnclient.case1;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

import org.tigris.subversion.svnclientadapter.ISVNClientAdapter;
import org.tigris.subversion.svnclientadapter.ISVNDirEntry;
import org.tigris.subversion.svnclientadapter.SVNClientAdapterFactory;
import org.tigris.subversion.svnclientadapter.SVNRevision;
import org.tigris.subversion.svnclientadapter.SVNUrl;
import org.tigris.subversion.svnclientadapter.javahl.JhlClientAdapterFactory;

/**
 * @author 3rdstage
 *
 */
public class SvnClientUtil {
	
	
	
	public static List<String> listNonJavaSourceFilesUnderUrl(String url, String username, String passwd) throws Exception{

		//int bestClientType = SVNClientAdapterFactory.COMMANDLINE_CLIENT;
		//boolean b1 = SVNClientAdapterFactory.isSVNClientAvailable(CmdLineClientAdapterFactory.COMMANDLINE_CLIENT);
		boolean b2 = SVNClientAdapterFactory.isSVNClientAvailable(JhlClientAdapterFactory.JAVAHL_CLIENT);
		
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		
		adp.setUsername(username);
		if(passwd != null) adp.setPassword(passwd);
		
		ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		
		List<String> paths = new ArrayList<String>();
		
		for(ISVNDirEntry entry : entries) paths.add(entry.getPath());
		
		return paths;
		
	}
	
	public static List<String> listNonJavaSourceFilesUnderUrl2(String url, @Nullable String username, @Nullable String passwd) throws Exception{

		JhlClientAdapterFactory.setup();
		
		ISVNClientAdapter adp = SVNClientAdapterFactory.createSVNClient(JhlClientAdapterFactory.JAVAHL_CLIENT);
		
		if(username != null) adp.setUsername(username);
		if(passwd != null) adp.setPassword(passwd);
		
		ISVNDirEntry[] entries = adp.getList(new SVNUrl(url), SVNRevision.HEAD, false);
		
		List<String> paths = new ArrayList<String>();
		
		for(ISVNDirEntry entry : entries) paths.add(entry.getPath());
		
		return paths;
		
	}
	

}
