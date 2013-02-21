/**
 * 
 */
package thirdstage.exercise.jvm.case1;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/**
 * <p>
 * Run this program in debug mode after marking break points where the 
 * comments requires to mark.
 * </p>
 * 
 * @author 3rdstage
 *
 */
public class StartAndShutdownRmiRegistryTest{
	
	public static int port = 9997;
	
	public static void main(String[] args) throws Exception{
		
		System.out.println(args);
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		Registry reg = LocateRegistry.createRegistry(port);
		
		System.out.println(reg.toString());
		
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" 
				+ InetAddress.getLocalHost().getHostAddress() + ":" + port + "/server");
		JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
		cs.start();
		
		System.out.println("RMI registry is created and JMX connector server is started.");
		System.out.println("The URL for the JMX connector server : " + url.toString());
		//mark break-point here.
		System.out.println("");
		
		
		cs.stop();
		System.out.println("JXM connector server is stoped.");
		//mark break-point here.
		System.out.println("");
		
		
		UnicastRemoteObject.unexportObject(reg,true);
		System.out.println("RMI registry is destroyed.");
		//mark break-point here.
		System.out.println("");
		
		
	}
	

}
