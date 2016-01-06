/**
 * 
 */
package thirdstage.exercise.svnkit.case1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tmatesoft.svn.core.ISVNDirEntryHandler;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;


/**
 * @author 3rdstage
 *
 */
public class SvnUtil {
	
	protected final Logger logger = LoggerFactory.getLogger(SvnUtil.class);
	
	private static final SvnUtil singleton = new SvnUtil();  
	
	private SvnUtil(){
		
	}

	public static List<SVNDirEntry> listEntriesUnderUrl(String url, String username, String passwd) throws Exception{
		
		DAVRepositoryFactory.setup();
		
		SVNRepository repos = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
		repos.setAuthenticationManager(SVNWCUtil.createDefaultAuthenticationManager(username, passwd));
		
		final List<SVNDirEntry> entries = new ArrayList<SVNDirEntry>();
		
		listDirRecursive(repos, repos.getLatestRevision(), ".", true, null, null, entries);
		
		return entries;
	}
	
	public static List<SVNDirEntry> listJavaSourceEntriesUnderUrl(String url, String username, String passwd) throws Exception{
		
		DAVRepositoryFactory.setup();
		
		SVNRepository repos = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
		repos.setAuthenticationManager(SVNWCUtil.createDefaultAuthenticationManager(username, passwd));
		
		final List<SVNDirEntry> entries = new ArrayList<SVNDirEntry>();
		
		listDirRecursive(repos, repos.getLatestRevision(), ".", false, "^.*\\.java$", null, entries);
		
		return entries;
	}
	
	public static List<SVNDirEntry> listNonJavaSourceFileEntriesUnderUrl(String url, String username, String passwd) throws Exception{
		
		DAVRepositoryFactory.setup();
		
		SVNRepository repos = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
		repos.setAuthenticationManager(SVNWCUtil.createDefaultAuthenticationManager(username, passwd));
		
		final List<SVNDirEntry> entries = new ArrayList<SVNDirEntry>();
		
		listDirRecursive(repos, repos.getLatestRevision(), ".", false, null, "^.*\\.java$", entries);
		
		return entries;
	}	
	
	
	private static void listDirRecursive(final SVNRepository repos, final long rev, final String path, 
			final boolean includesDir, final String includeRegex, final String excludeRegex, 
			final List<SVNDirEntry> collector) throws Exception{
		
		Collection<SVNDirEntry> entries = repos.getDir(path, rev, null, (Collection)null);
		String str = null;
		
		boolean includes = false;
		boolean excludes = false;
		
		for(SVNDirEntry entry : entries){
			includes = false;
			excludes = false;
			
			str = entry.getURL().toString();
			
			if(entry.getKind().compareTo(SVNNodeKind.DIR) == 0 && !includesDir){
				includes = false;
			}else{
				if(includeRegex == null || Pattern.matches(includeRegex, str)) includes = true;
				if(excludeRegex != null && Pattern.matches(excludeRegex, str)) excludes = true;
			}
			if(includes && !excludes) collector.add(entry);
			
			if(entry.getKind().compareTo(SVNNodeKind.DIR) == 0){
				listDirRecursive(repos, rev, path + "/" + entry.getRelativePath(), 
						includesDir, includeRegex, excludeRegex, collector);
			}
		}
	}
	
	/**
	 * Two URLs, both <code>javaUrl</code> and <code>resourceUrl</code> should be on the same repository
	 * and have the same leading part corresponding to the URL of repository. 
	 * Don't append ending slash for <code>javaUrl</code> and <code>resourcesUrl</code>.
	 * 
	 * @param javaUrl
	 * @param resourcesUrl
	 * @param username
	 * @param passwd
	 * @return
	 * @throws Exception
	 */
	public static String generateScriptToRelocateResources(String javaUrl, String resourcesUrl, String username, String passwd)
		throws Exception{
		
		if(javaUrl == null || javaUrl.trim().length() == 0 || javaUrl.endsWith("/"))
			throw new IllegalArgumentException("The value for javaUrl should be non-empty and shoundn't end with slash '/'");
		if(resourcesUrl == null || resourcesUrl.trim().length() == 0 || resourcesUrl.endsWith("/"))
			throw new IllegalArgumentException("The value for resourcesUrl should be non-empty and shoundn't end with slash '/'");
		
		StringBuilder script = new StringBuilder(); 
		Collection<SVNDirEntry> entries = listNonJavaSourceFileEntriesUnderUrl(javaUrl, username, passwd);
		
		DAVRepositoryFactory.setup();
		SVNRepository repos = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(javaUrl));
		repos.setAuthenticationManager(SVNWCUtil.createDefaultAuthenticationManager(username, passwd));
		
		String rootUrl = repos.getRepositoryRoot(false).toString();
		String srcUrl = null; //soruce URL to move
		String trgUrl = null; //target URL to move
		String trgRelPath = null;
		String tmpUrl = null;
		SVNNodeKind tmpKind = null;
		Set<String> dirs = new HashSet<String>(); //set for directories to create newly.
		
		int num = entries.size();
		int cnt = 1;
		int len0 = rootUrl.length();
		int len1 = javaUrl.length();
		long rev = repos.getLatestRevision();
		
		singleton.logger.info("Found " + num + " entries to move for " + javaUrl);
		
		for(SVNDirEntry entry : entries){
			//singleton.logger.info("Working with entry %1$d of %2$d.", cnt, num); //What's problem with this.
			singleton.logger.info("Working with entry " + cnt++ + " of " + num);
			
			srcUrl = entry.getURL().toString();
			trgRelPath = srcUrl.substring(len1);

			if(!trgRelPath.startsWith("/"))
				throw new IllegalStateException("Unexpected state. You need to inspect this program or the program call this.");

			if(srcUrl.endsWith(".emptyDir")){
				singleton.logger.info("Skipping empty directory marking file('.emptyDir').");
				continue;
			}
			
			int n = trgRelPath.indexOf("/", 1); 
			while(n > 0){
				tmpUrl = resourcesUrl + trgRelPath.substring(0, n);
				
				singleton.logger.info("Before checking : " + tmpUrl.substring(tmpUrl.length() - n));
				
				//if the directory corresponding to tmpUrl doesn't exist, append a command to make the directory
				//checkPath doesn't work with full URL as is documented .
				tmpKind = repos.checkPath(tmpUrl.substring(len0), rev);
				if(!dirs.contains(tmpUrl) && (tmpKind == SVNNodeKind.NONE)){
					script.append("svn mkdir -m \"create single dir.\" --username ").append(username)
						.append(" \"").append(tmpUrl).append("\"\n");
					dirs.add(tmpUrl);
				}
				
				//loop with the next directory in the target path
				n = trgRelPath.indexOf("/", n + 1);
			}
			
			trgUrl = resourcesUrl + srcUrl.substring(len1);
			script.append("svn move -m \"move a single file.\" --username ").append(username)
				.append(" \"").append(srcUrl).append("\" \"").append(trgUrl).append("\"\n");
		}

		return script.toString();
	}
	
}
