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
public class ComponentMetaMBeanTest {
	
	
	public static void main(String[] args) throws Exception{
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		ObjectName name = new ObjectName("thirdstage.exercise:type=ComponentMeta,component=Order");
		ComponentMeta orderMeta = new ComponentMeta("주문처리 서비스 ", "OrderService", "order", "Service", "thirdstage.shop3.order");
		
		mbs.registerMBean(orderMeta, name);
		
		System.out.println("Sleeping... Press Ctrl+C to quit.");
		Thread.sleep(Long.MAX_VALUE);
		
	}

}
