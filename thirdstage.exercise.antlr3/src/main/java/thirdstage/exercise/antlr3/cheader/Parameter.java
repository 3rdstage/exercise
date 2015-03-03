package thirdstage.exercise.antlr3.cheader;

public class Parameter {
	
	private String type;
	
	private String name;
	
	private boolean isRestrict;
	
	public Parameter(String type, String name, boolean isRestrict){
		this.type = type;
		this.name = name;
		this.isRestrict = isRestrict;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isRestrict(){
		return this.isRestrict;
	}

	public String toString(){
		StringBuilder str = new StringBuilder().append(this.getType());
		if(this.isRestrict()) str.append(" restrict");
		if(this.getName() != null && this.getName().length() > 0) str.append(" ").append(this.getName());
		
		return str.toString();
	}
}
