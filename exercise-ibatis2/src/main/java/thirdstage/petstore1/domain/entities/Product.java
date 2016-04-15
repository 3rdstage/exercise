package thirdstage.petstore1.domain.entities;

import java.io.Serializable;

public class Product implements Serializable{

	private String id;
	private String categoryId;
	private String name;
	private String description;

	public Product(){}
	
	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
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
		return getName();
	}
	
}
