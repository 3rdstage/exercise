package thirdstage.shop3.catalog.value;

public class Product {
	
	
	private String id = null;
	
	private String name = null;
	
	private String categoryId = null;
	
	private String description = null;

	public Product(String id, String name, String categoryId, String description) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getDescription() {
		return description;
	}
	


}
