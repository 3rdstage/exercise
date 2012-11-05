package thirdstage.petstore1.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Product")
@org.hibernate.annotations.Entity(dynamicInsert=false, dynamicUpdate=true)
@org.hibernate.annotations.AccessType("field")
public class Product implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="productId")
	private String id;
	

	@Basic
	@Column(name="name", unique=false, nullable=false)
	private String name;
	
	@Basic
	@Column(name="descn", unique=false, nullable=false)
	private String description;
	
	@ManyToOne(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private Category category;
	

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

	public Category getCategory(){
		return category;
	}

	public void setCategory(Category category){
		this.category = category;
	}
	
	
	
}
