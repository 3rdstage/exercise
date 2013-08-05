/**
 * 
 */
package thirdstage.util.config.json;

import javax.annotation.Nonnull;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

/**
 * @version 0.7, Sangmoon Oh, 2013-08-05, Initial
 * @since 2013-08-05
 */
public class PropertyMetaFactory {
	
	private static Logger logger = LoggerFactory.getLogger(PropertyMetaFactory.class);
	
	/**
	 * @param name
	 * @param type
	 * @param title
	 * @param desc
	 * @param required
	 * @param max
	 * @param exclusiveMax
	 * @param min
	 * @param exclusiveMin
	 * @param maxLen
	 * @param minLen
	 * @param enums
	 * @param pattern
	 * @param defaultValue
	 * @return
	 * @throws IllegalArgumentException when the {@code type} is not supported.
	 */
	public static <T> PropertyMeta<T> getPropertyMeta(
		@Nonnull String name, @Nonnull PropertyType type,
		String title, String desc, Boolean required,
		Double max, Boolean exclusiveMax, Double min, 
		Boolean exclusiveMin, Integer maxLen, inInteger minLen, 
		T[] enums, String pattern, T defaultValue){
		
		PropertyMea<?> meta = null;
		switch(type){
		
		// TODO(Sangmoon Oh, 2013-08-05) : need to check downcasting when
		//	the value is null.
		
		case BOOLEAN : 
			meta = new PropertyMeta<Boolean>(
				name, PropertyType.BOOLEAN, title, desc,
				required, max, exclusiveMax, min, exclusiveMin,
				maxLen, minLen, (Boolean[])enums, pattern, 
				(Boolean)defaultValue);
			break;
		
		case STRING :
			meta = new PropertyMeta<String>(
					name, PropertyType.STRING, title, desc,
					required, max, exclusiveMax, min, exclusiveMin,
					maxLen, minLen, (String[])enums, pattern,
					(String)defaultValue);
			break;
		case INTEGER :
			meta = new PropertyMeta<Integer>(
					name, PropertyType.INTEGER, title, desc,
					required, max, exclusiveMax, min, exclusiveMin,
					maxLen, minLen, (Integer[])enums, pattern,
					(Integer)defaultValue);
			break;
		case NUMBER :
			meta = new PropertyMeta<Double>(
					name, PropertyType.NUMBER, title, desc,
					required, max, exclusiveMax, min, exclusiveMin,
					maxLen, minLen, (Double[])enums, pattern,
					(Double)defaultValue);
			break;	
		case ANY : 
			meta = new PropertyMeta<Object>(
					name, PropertyType.ANY, title, desc,
					required, max, exclusiveMax, min, exclusiveMin,
					maxLen, minLen, (Object[])enums, pattern,
					(Object)defaultValue);
			break;
			
		default : //error situation
			logger.error("The given {} is not supported type.", (type != null) ? type.toString() : type);
			throw new IllegalArgumentException(String.format(
					"The given %1$s is not supported type", (type != null) ? type.toString() : type));
		}
		
		return meta;
	}

}
