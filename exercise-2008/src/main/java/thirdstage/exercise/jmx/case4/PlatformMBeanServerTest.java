/**
 * 
 */
package thirdstage.exercise.jmx.case4;

import java.lang.management.ManagementFactory;
import java.util.Set;

import javassist.bytecode.AttributeInfo;

import javax.management.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 3rdstage
 *
 */
public class PlatformMBeanServerTest {
	
	@Test
	public void testSimple() throws Exception{
		
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		//query all mbeans
		Set<ObjectInstance> mbeans = mbs.queryMBeans(null, null);
		
		System.out.printf("The number of MBeans registered at platform mbean server : %1$d%n%n", mbeans.size());
		
		ObjectName oname = null;
		String cname = null;
		MBeanInfo info = null;
		MBeanAttributeInfo[] attrInfos = null;
		MBeanOperationInfo[] operInfos = null;
		Object attr = null;
		int cnt = 1;
		for(ObjectInstance oi : mbeans){
			oname = oi.getObjectName(); 
			cname = oi.getClassName();
			info = mbs.getMBeanInfo(oname);
			attrInfos = info.getAttributes();
			operInfos = info.getOperations();
			
			System.out.printf("%3$2d. Object Name : %1$s, Class Name : %2$s%n", oname, cname, cnt++);
			System.out.printf("  Description : %1$s%n", info.getDescription());
			
			System.out.println("  Attributes : ");
			for(MBeanAttributeInfo attrInfo : attrInfos){
				try{
					attr = mbs.getAttribute(oname, attrInfo.getName());
				}catch(Exception ex){
					attr = "[Unsupported]";
				}
				
				System.out.printf("    Name : %1$-30s, Value : %2$s%n", 
						attrInfo.getName(), attr);
				
			}
			System.out.println("  Operations : ");
			for(MBeanOperationInfo operInfo : operInfos){
				System.out.printf("    Name : %1$-30s, Return Type : %2$s%n",
						operInfo.getName(), operInfo.getReturnType());
			}
			
			System.out.println();
		}
		
		Assert.assertEquals(mbeans.size(), cnt);
		
	}

}
