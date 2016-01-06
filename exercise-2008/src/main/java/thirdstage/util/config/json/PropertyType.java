/**
 * 
 */
package thirdstage.util.config.json;

/**
 * @author 3rdstage
 *
 */
public enum PropertyType {

	BOOLEAN,
	INTEGER,
	NUMBER,
	STRING,
	ANY,
	UNKNOWN;
	
	public static PropertyType valueOfJsonType(String type){
		PropertyType result = null;
		try{
			result = valueOf(type.toUpperCase());
		}catch(IllegalArgumentException ex){
			result = UNKNOWN;
		}
		
		return result; 
	}
	
	public static Class<?> toJavaClass(PropertyType type){
		
		Class<?> clazz = null;
		
		switch(type){
		
		case BOOLEAN :
			clazz = Boolean.class;
			break;
		case INTEGER :
			clazz = Long.class;
			break;
		case NUMBER :
			clazz = Double.class;
			break;
		case STRING :
			clazz = String.class;
			break;
		case ANY :
		case UNKNOWN :
			clazz = Object.class;
			break;
		
		default :
			clazz = Object.class;
		}
		
		return clazz;
	}
	
}
