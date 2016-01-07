/**
 * 
 */
package thirdstage.exercise.dto.case3;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 3rdstage
 *
 */
public abstract class DefaultSimpleType implements SimpleType{
	
	protected static Set<Class> allowedTypes;
	
	{
		allowedTypes = new HashSet<Class>();
		allowedTypes.add(boolean.class);
		//allowedTypes.add(byte.class);
		//allowedTypes.add(char.class);
		//allowedTypes.add(short.class);
		allowedTypes.add(int.class);
		allowedTypes.add(long.class);
		//allowedTypes.add(float.class);
		allowedTypes.add(double.class);
		allowedTypes.add(String.class);
		
		//allowedTypes.add(boolean[].class);
		//allowedTypes.add(int[].class);
		//allowedTypes.add(long[].class);
		//allowedTypes.add(double[].class);
		//allowedTypes.add(String[].class);
		
		//TODO How to represent the meta object for List<T> 
		//allowedTypes.add(List<Boolean>.class);
	}
	
	
	public Set<Class> getAllowedTypesForFields(){
		
		return allowedTypes;
	}
	
	public boolean isSimpleType(Class<? extends SimpleType> clazz){
		Set<Class> allowedTypes = this.getAllowedTypesForFields();
		Set<Class> declaredTypes = new HashSet<Class>();
		
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields){
			declaredTypes.add(field.getType());
			
			System.out.println(field.toString());
			System.out.println(field.toGenericString());
			
		}
		
		System.out.println("# of allowed types : " + allowedTypes.size());
		System.out.println("# of declared types : " + declaredTypes.size());
		
		System.out.println("allowed types : " + allowedTypes.toString());
		System.out.println("declared types : " + declaredTypes.toString());
		
		
		if(allowedTypes.containsAll(declaredTypes)){ return true; }
		else{ return false; }
	}
	

}
