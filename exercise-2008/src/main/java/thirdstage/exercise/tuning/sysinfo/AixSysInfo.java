/**
 * 
 */
package thirdstage.exercise.tuning.sysinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * For details on the AIX command which appears on this program, refer the following page.
 * 
 * http://pic.dhe.ibm.com/infocenter/aix/v7r1/topic/com.ibm.aix.cmds/alphabeticallistofcommands.htm
 *
 */
public class AixSysInfo {

	public static void main(String[] args) throws Exception{
		AixSysInfo info = new AixSysInfo();

		info.printCurrentUser(System.out, 3);
		System.out.println("");
		info.printSystemModel(System.out, 3);
		System.out.println("");
		info.printOsLevel(System.out, 3);
		System.out.println("");
		info.printProcessorList(System.out, 3);
		System.out.println("");
		info.printProcessorCoreList(System.out, 3);
		System.out.println("");
		info.printProcessorSpec(System.out, 3);
		System.out.println("");
		info.printPhysicalMemory(System.out, 3);
		System.out.println("");
		info.printLparStat(System.out, 3);
		System.out.println("");
		info.printUlimit(System.out, 3);
		System.out.println("");
		info.printTcpIpSettings(System.out, 3);
		System.out.println("");
		info.printJvmVersion(System.out, 3);
		System.out.println("");
		info.printEnv(System.out, 3);
		System.out.println("");
		info.printSystemProperties(System.out, 3);
	}
	
	public void printCurrentUser(OutputStream os, int leadingSpaces) throws Exception{
		String title = "Current User : ";
		String[] command = {"whoami"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}

	public void printSystemModel(OutputStream os, int leadingSpaces) throws Exception{
		String title = "System Model : ";
		String[] command = {"uname", "-M"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}
	
	public void printOsLevel(OutputStream os, int leadingSpaces) throws Exception{
		String title = "AIX Level (format : baseLevel-technolotyLevel-servicePack-buildDate) : ";
		String[] command = {"oslevel", "-s"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}
	
	public void printProcessorList(OutputStream os, int leadingSpaces) throws Exception{
		String title = "List of Processors : ";
		String[] command = {"lsdev", "-Cc", "processor"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}
	

	public void printProcessorCoreList(OutputStream os, int leadingSpaces) throws Exception{
		String title = "List of Processor Cores : ";
		String[] command = {"bindprocessor", "-q"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}	

	public void printProcessorSpec(OutputStream os, int leadingSpaces) throws Exception{
		String title = "Processor Spec : ";
		String[] command = {"prtconf", "-cs"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}
	
	public void printPhysicalMemory(OutputStream os, int leadingSpaces) throws Exception{
		String title = "Physicla Memory Capacity : ";
		String[] command = {"prtconf", "-m"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}	
	
	public void printLparStat(OutputStream os, int leadingSpaces) throws Exception{
		String title = "LPAR(Logical Partition) Information";
		String[] command = {"lparstat"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}
	
	public void printUlimit(OutputStream os, int leadingSpaces) throws Exception{
		String title ="User Resource Limits (ulimit) : ";
		String[] command = {"ulimit", "-a"};
		this.printCommand(title, os, leadingSpaces, command, null);		
	}
	
	/**
	 * For more on this, refer the following pages
	 * 
	 * http://pic.dhe.ibm.com/infocenter/wasinfo/v7r0/topic/com.ibm.websphere.base.doc/info/aes/ae/tprf_tunetcpip.html
	 * http://www.redbooks.ibm.com/redbooks/SG247347/wwhelp/wwhimpl/js/html/wwhelp.htm
	 * http://pic.dhe.ibm.com/infocenter/wasinfo/v7r0/topic/com.ibm.websphere.base.doc/info/aes/ae/tprf_tuneaix.html
	 * http://publib.boulder.ibm.com/infocenter/pseries/v5r3/index.jsp?topic=/com.ibm.aix.prftungd/doc/prftungd/tcp_streaming_workload_tuning.htm
	 * 
	 * @param os
	 * @param leadingSpaces
	 * @throws Exception
	 */
	public void printTcpIpSettings(OutputStream os, int leadingSpaces) throws Exception{
		String title ="TCP/IP Settings : ";
		String[] command = {"no",
				"-o", "tcp_timewait",
				"-o", "tcp_keepidle",
				"-o", "tcp_keepinit",
				"-o", "tcp_keepintvl",
				"-o", "tcp_recvspace", 
				"-o", "tcp_sendspace", 
				"-o", "rfc1323", 
				"-o", "sack",
				"-o", "tcp_pmtu_discover", 
				"-o", "tcp_nodelayack", 
				"-o", "sb_max",
				"-o", "tcp_mssdflt"};
		this.printCommand(title, os, leadingSpaces, command, null);		
	}
	
	
	public void printJvmVersion(OutputStream os, int leadingSpaces) throws Exception{
		String title = "Java Version :";
		String[] command = {"java", "-version"};
		this.printCommand(title, os, leadingSpaces, command, null);
	}
		
	private void printCommand(String title, OutputStream os, int leadingSpaces, String[] command, Map<String, String> envExtra) throws Exception{
		
		Process process = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		String leading = "";
		for(int i = 0; i < leadingSpaces; i++) leading += " ";

		List<String> lines = new ArrayList<String>();
		String line = null;
		try{
			ProcessBuilder pb = new ProcessBuilder(command);
			if(envExtra != null) pb.environment().putAll(envExtra);
			pb.redirectErrorStream(true);
			process = pb.start(); 
			br = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while((line = br.readLine()) != null) lines.add(line);
			
			pw = new PrintWriter(os, true);
			pw.println("> " + title);
			for(String str : lines) pw.println(leading + str);
			pw.flush();
			
		}catch(Exception ex){
			throw ex;
		}finally{
			if(br != null){
				try{ br.close(); }
				catch(Exception ex){}
			}
			if(process != null){
				try{ process.destroy(); }
				catch(Exception ex){}
			}
			if(pw != null && this.allowsClose(os)){
				try{ pw.close(); }
				catch(Exception ex){}
			}
		}
	}


	public void printEnv(OutputStream os, int leadingSpaces) throws Exception{

		Map<String, String> map = System.getenv();
		Set<String> keys = map.keySet();
		List keyList = new ArrayList(keys);
		Collections.sort(keyList);
		PrintWriter pw = null;

		String leading = "";
		for(int i = 0; i < leadingSpaces; i++) leading += " ";

		try{
			pw = new PrintWriter(os, true);
			
			pw.println("> Environment Variables : ");
			String key = null;
			for(Iterator itr = keyList.iterator(); itr.hasNext();){ // for JDK 1.4
				key = (String) (itr.next());
				pw.println(leading + "" + key + "=" + map.get(key));
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(pw != null && this.allowsClose(os)){
				try{ pw.close(); }
				catch(Exception ex){}
			}
		}
	}	


	public void printSystemProperties(OutputStream os, int leadingSpaces) throws Exception{
		Map props = System.getProperties();


		Set keys = props.keySet();
		List keyList = new ArrayList(keys);
		Collections.sort(keyList);
		PrintWriter pw = null;

		String leading = "";
		for(int i = 0; i < leadingSpaces; i++) leading += " ";

		try{
			pw = new PrintWriter(os, true);

			pw.println("> System Properties of JVM : ");
			String key = null;
			for(Iterator itr = keyList.iterator(); itr.hasNext();){ // for JDK 1.4
				key = (String) (itr.next());
				pw.println(leading + "" + key + "=" + props.get(key));
			}
		}catch(Exception ex){
			throw ex;
		}finally{
			if(pw != null && this.allowsClose(os)){
				try{ pw.close(); }
				catch(Exception ex){}
			}
		}
	}
	
	private boolean allowsClose(OutputStream os){
		if(os == null) return false;
		else if(os == System.out) return false;
		else if(os == System.err) return false;
		else return true;
	}
}
