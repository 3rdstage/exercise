/**
 * 
 */
package thirdstage.exercise.reflection;

/**
 * @author 3rdstage
 *
 */
public class Category {

	private String id;
	
	private String name;
	
	private String nameInCapital; //for internal use only
	
	public Category(String id, String name){ 
		this.id = id; 
		this.name = name;
		this.nameInCapital = (name != null) ? name.toUpperCase() : null;
	}
	
	public String getId(){ return this.id; }
	
	public String getName(){ return this.name; }
	
	
	
}
