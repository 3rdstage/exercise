/**
 * 
 */
package thirdstage.exercise.varargs;

/**
 * This class is stuff for testing variable arguments.
 *
 */
public class Product{
	
	protected String name;
	
	protected String id;
	
	protected String[] features;
	
	public Product(String id, String name){
		this.name = name;
		this.id = id;
	}
	
	public Product(String id, String name, String[] features){
		this(name, id);
		this.features = features;
	}
	
	public void setFeatures(String[] features){
		this.features = features;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("ID : ").append(id).append("\n")
			.append("Name : ").append(name).append("\n")
			.append("Features : ").append("\n");
		
		for(String feature : features){
			sb.append("   ").append(feature).append("\n");
		}
		
		return sb.toString();
	}

}


