/**
 * 
 */
package thirdstage.exercise.jmx.case4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.management.openmbean.SimpleType;

import org.junit.Test;


/**
 * @author 3rdstage
 *
 */
public class OpenMBeanTest {
	
	@Test
	public void testSimpleType() throws Exception{
		
		Class<SimpleType> clazz = SimpleType.class;
		
		Field[] fields = clazz.getDeclaredFields();
		List<Field> targetFields = new ArrayList<Field>();
		for(Field field : fields){
			if(field.getType().isAssignableFrom(SimpleType.class)){
				targetFields.add(field);
			}
		}
		
		List<SimpleType> instances = new ArrayList<SimpleType>();
		for(Field field2 : targetFields){
			field2.setAccessible(true);
			instances.add((SimpleType)(field2.get(clazz)));
		}
		
		Method m1 = clazz.getMethod("getClassName");
		Method m2 = clazz.getMethod("getTypeName");
		String className = null;
		String typeName = null;
		for(SimpleType<?> inst : instances){
			className = (String)m1.invoke(inst);
			typeName = (String)m2.invoke(inst);
			
			System.out.printf("Instance : %1$s, Class Name : %2$s, Type Name : %3$s%n", inst.toString(), className, typeName);
		}
		System.out.println("");
	}

}
