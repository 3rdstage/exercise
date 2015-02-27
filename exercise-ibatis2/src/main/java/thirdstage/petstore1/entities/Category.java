package thirdstage.petstore1.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
@org.hibernate.annotations.AccessType("field")
@org.hibernate.annotations.Entity(dynamicInsert=false, dynamicUpdate=false)
public class Category implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="categoryId")
	String id;
	
	@Basic
	@Column(name="name", unique=false, nullable=false)
	String name;
	
	@Basic
	@Column(name="descn", unique=false, nullable=true)
	String description;

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
	
	
	

	
	
}
