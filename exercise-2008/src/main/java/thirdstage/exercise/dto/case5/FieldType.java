/**
 * 
 */
package thirdstage.exercise.dto.case5;

/**
 * @author 3rdstage
 *
 */
public class FieldType<T> {
	
	public final static FieldType<Integer> INTEGER = new FieldType<Integer>(Integer.class); 
	
	private Class<T> clazz = null;
	
	protected FieldType(Class<T> clazz){
		this.clazz = clazz;
	}
	
	public String getName(){
		return this.clazz.getName();
	}
	
	public String getSimpleName(){
		return this.clazz.getSimpleName();
	}
	
	

}
