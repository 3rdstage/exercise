package thirdstage.caveatemptor1.domain.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "category")
@org.hibernate.annotations.AccessType("field")
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private Long id = null;

	@Version
	@Column(name = "ver")
	private Long version = null;
	
	@Basic
	@Column(name = "name")
	private String name = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentCategoryId")
	private Category parentCategory = null;
	
	@OneToMany(mappedBy = "parentCategory", 
			     cascade = CascadeType.PERSIST,
			     fetch = FetchType.LAZY)
	private Set<Category> childCategories = new HashSet<Category>();
	
	public Category(){}

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Long getVersion(){
		return this.version;
	}
	
	public void setVersion(Long ver){
		this.version = ver;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public Category getParentCategory(){
		return this.parentCategory;
	}
	
	public void setParentCategory(Category parent){
		this.parentCategory = parent;
	}
	
	public Set<Category> getChildCategories(){
		return this.childCategories;
	}
	
	public void setChildCategories(Set<Category> categories){
		this.childCategories = categories;
	}
	
	public void addChildCateogy(Category category){
		this.childCategories.add(category);
		
		category.setParentCategory(this);
	}
}

