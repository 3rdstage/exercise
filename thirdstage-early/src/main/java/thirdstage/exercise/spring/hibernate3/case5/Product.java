

package thirdstage.exercise.spring.hibernate3.case5;

/**
 *
 * @author 3rdstage
 * @since 2006-07-07
 * 
 * @hibernate.class table="Product5"
 *
 * @hibernate.query name="findProductsByCategory" query="from Product as product where product.category = :category"
 */
public class Product {
	
	private Long id = null;
	private String name = null;
	private String description = null;
	private String category = null;
	
	/** Creates a new instance of Product */
	public Product() {
	}

	public Product(String name, String category, String desc){
		this.setName(name);
		this.setCategory(category);
		this.setDescription(desc);
	}
	
	/**
	 * @hibernate.id column="id" unsaved-value="null" generator-class="native"
	 */
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	/**
	 * @hibernate.property column="name" type="string" length="50"
	 *                     unique="false" not-null="true"
	 * @hibernate.column name="name" type="string" length="50" unique="false" not-null="true" comment="제품명"
	 */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	/**
	 * @hibernate.property column="description" type="string" length="200"
	 *                     unique="false" not-null="false"
	 */
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description;	}

	/**
	 * @hibernate.property column="category" type="string" length="50"
	 *                     unique="false" not-null="false"
	 */
	public String getCategory(){ return this.category; }
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
