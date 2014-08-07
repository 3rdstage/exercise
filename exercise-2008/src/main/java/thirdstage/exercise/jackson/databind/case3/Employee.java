/**
 * 
 */
package thirdstage.exercise.jackson.databind.case3;

/**
 * @author 3rdstage
 *
 */
public class Employee{
	
	private String id;
	
	private String name;
	
	private double height;
	
	public Employee(){
		
	}
	
	public String getId(){ return this.id;	}

	public Employee setId(String id){ 
		this.id = id;
		return this;
	}
	
	
}
