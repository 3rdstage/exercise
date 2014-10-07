/**
 * 
 */
package thirdstage.exercise.jmx.simple;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * @author 3rdstage
 *
 */
public class CounterMBeanTest {

	public static void main(String[] args) throws Exception{
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		ObjectName name = new ObjectName("thirdstage.exercise:name=Counter");
		Counter counter = new Counter();
		
		mbs.registerMBean(counter, name);
		
		System.out.println("Sleeping... Press Ctrl+C to quit.");
		Thread.sleep(Long.MAX_VALUE);
		
	}	
	
}
