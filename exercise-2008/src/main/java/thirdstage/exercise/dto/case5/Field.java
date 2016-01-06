/**
 * 
 */
package thirdstage.exercise.dto.case5;

/**
 * @author 3rdstage
 *
 */
public class Field {

	private String name;
	
	private FieldType<?> type;
	
	private Object value;
	
	public Field(String name, FieldType<?> type, Object value){
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public String getName(){
		return this.name;
	}
	
	public FieldType<?> getType(){
		return this.type;
	}
	
	public Object getValue(){
		return this.value;
	}
	
	public <T> T getValue(FieldType<T> type){
		
		return null;
	}
}
