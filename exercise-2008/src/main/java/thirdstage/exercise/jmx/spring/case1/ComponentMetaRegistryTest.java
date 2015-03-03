/**
 * 
 */
package thirdstage.exercise.jmx.spring.case1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author 3rdstage
 *
 */
public class ComponentMetaRegistryTest {
	
	public static void main(String[] args) throws Exception{
		
		ApplicationContext springCtx = new ClassPathXmlApplicationContext("thirdstage/exercise/jmx/spring/case1/spring.xml");
		
		ComponentMetaRegistry registry = (ComponentMetaRegistry)springCtx.getBean("componentRegistry");
		
		ComponentMeta meta1 = new ComponentMetaImpl("주문 처리 서비스 ", "OrderService", "order", "Service", "thirdstage.shop.order", "...");
		ComponentMeta meta2 = new ComponentMetaImpl("주문 정보", "Order", "order", "Domain", "thirdstage.shop.order", "...");
		ComponentMeta meta3 = new ComponentMetaImpl("결제 처리 서비스 ", "PaymentService", "order", "Service", "thirdstage.shop.order", "...");
		ComponentMeta meta4 = new ComponentMetaImpl("고객 정보 서비스 ", "CustomerService", "customer", "Service", "thirdstage.shop.customer", "...");
		ComponentMeta meta5 = new ComponentMetaImpl("고객 정보", "Customer", "customer", "Domain", "thirdstage.shop.customer", "...");
		
		registry.boundComponentMeta(meta1.getNamespace() + "." + meta1.getName(), meta1);
		registry.boundComponentMeta(meta2.getNamespace() + "." + meta2.getName(), meta2);
		registry.boundComponentMeta(meta3.getNamespace() + "." + meta3.getName(), meta3);
		registry.boundComponentMeta(meta4.getNamespace() + "." + meta4.getName(), meta4);
		registry.boundComponentMeta(meta5.getNamespace() + "." + meta5.getName(), meta5);
		  
		
		System.out.println("Sleeping... Press Ctrl+C to quit.");
		Thread.sleep(Long.MAX_VALUE); 
	}
	

}
