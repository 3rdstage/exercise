package thirdstage.exercise.jersey.spring3;

import javax.annotation.Nonnull;

public class CategoryValue {
	
	private String id;
	
	private String name;
	
	public CategoryValue(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getId(){ return this.id; }
	
	public String getName(){ return this.name; }
	
	@Override
	public String toString(){
		
		return new StringBuilder().append("ID : ").append(this.id)
				.append(", Name : ").append(this.name).toString();
	}

}
