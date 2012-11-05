package thirdstage.petstore1.domain.entities;

import java.io.Serializable;

public class Category implements Serializable{

	private String id;
	private String name;
	private String description;

	public Category(){}
	
	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	@Override
	public String toString(){
		return this.getId();
	}

}
