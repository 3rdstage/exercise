/**
 * 
 */
package thirdstage.exercise.varargs;

/**
 * This class is stuff for testing variable arguments.
 *
 */
public class Appliance extends Product{
	
	public Appliance(String id, String name, String... features){
		super(id, name);
		this.features = features;
		
	}
	

}
