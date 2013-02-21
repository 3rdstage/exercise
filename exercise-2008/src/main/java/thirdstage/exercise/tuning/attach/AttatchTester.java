/**
 * 
 */
package thirdstage.exercise.tuning.attach;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import bsh.Console;

import com.sun.tools.attach.VirtualMachine;

/**
 * @author 3rdstage
 *
 */
public class AttatchTester {
	
	public static void main(String[] args){
		
		try{
		
		String home = System.getProperty("java.home");
		System.out.println("Java Home : " + home);
		
		System.out.println("Type the PID of the VM to attach.\n");
		System.out.println("");
		String pid = new BufferedReader(new InputStreamReader(System.in)).readLine();

		VirtualMachine vm = VirtualMachine.attach(pid);
		String agent = home + File.separator + "lib" + File.separator + "management-agent.jar";
		
		vm.loadAgent(agent, "com.sun.management.jmxremote.port=3337,com.sun.management.jmxremote.authenticate=false,com.sun.management.jmxremote.ssl=false");
		
		//mark break-point here
		System.out.println("Remote JMX access is enabled.");
		
		
		System.out.println("Press any key to finish this program.");
		new BufferedReader(new InputStreamReader(System.in)).readLine();

		
		vm.detach();
		
		}catch(Exception ex){
			ex.printStackTrace(System.err);
		}
	}

}
