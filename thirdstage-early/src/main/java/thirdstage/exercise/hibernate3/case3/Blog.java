package thirdstage.exercise.hibernate3.case3;

import java.util.List;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-30, 3rdstage
 * @since 2005-12-30
 *
 * @hibernate.class table="Blog3"
 */
public class Blog {
	
	private Long id = null;
	private String name = null;
	private List items = null;
	
	/**
	 * Creates a new instance of Blog
	 */
	public Blog() {
	}

	/**
	 * @hibernate.id column="id" generator-class="native"
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @hibernate.property column="name" type="string" length="60" not-null="false"
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @hibernate.bag inverse="true"
	 *                lazy="true"
	 *                cascade="all"
	 *                order-by="dateTime"
	 * @hibernate.collection-one-to-many class="thirdstage.exercise.hibernate3.case3.BlogItem"
	 * @hibernate.collection-key column="bolgId"
	 */
	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}
	
}
