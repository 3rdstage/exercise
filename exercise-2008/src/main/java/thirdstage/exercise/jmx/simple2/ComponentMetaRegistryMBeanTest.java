/**
 * 
 */
package thirdstage.exercise.jmx.simple2;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * @author 3rdstage
 *
 */
public class ComponentMetaRegistryMBeanTest {
	
	public static void main(String[] args) throws Exception{
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		ObjectName name = new ObjectName("thirdstage.exercie:type=ComponentMetaRegistry");
		ComponentMetaRegistry registry = new ComponentMetaRegistry();
		  
		ComponentMeta meta1 = new SimpleComponentMeta("주문 처리 서비스 ", "OrderService", "order", "Service", "thirdstage.shop.order", "...");
		ComponentMeta meta2 = new SimpleComponentMeta("주문 정보", "Order", "order", "Domain", "thirdstage.shop.order", "...");
		ComponentMeta meta3 = new SimpleComponentMeta("결제 처리 서비스 ", "PaymentService", "order", "Service", "thirdstage.shop.order", "...");
		ComponentMeta meta4 = new SimpleComponentMeta("고객 정보 서비스 ", "CustomerService", "customer", "Service", "thirdstage.shop.customer", "...");
		ComponentMeta meta5 = new SimpleComponentMeta("고객 정보", "Customer", "customer", "Domain", "thirdstage.shop.customer", "...");
		
		registry.boundComponentMeta(meta1.getNamespace() + "." + meta1.getName(), meta1);
		registry.boundComponentMeta(meta2.getNamespace() + "." + meta2.getName(), meta2);
		registry.boundComponentMeta(meta3.getNamespace() + "." + meta3.getName(), meta3);
		registry.boundComponentMeta(meta4.getNamespace() + "." + meta4.getName(), meta4);
		registry.boundComponentMeta(meta5.getNamespace() + "." + meta5.getName(), meta5);
		  
		mbs.registerMBean(registry, name);
		
		System.out.println("Sleeping... Press Ctrl+C to quit.");
		Thread.sleep(Long.MAX_VALUE); 
	}

}
