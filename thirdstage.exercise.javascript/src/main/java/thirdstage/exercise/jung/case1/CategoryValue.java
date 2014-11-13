package thirdstage.exercise.jung.case1;

public class CategoryValue {

	String id;

	String name;

	Category parent;

	int order;

	String desc;
	
	public CategoryValue(String id, String name, Category parent, int order, String desc){
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.order = order;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getParent(){
		return parent;
	}
	
	public int getOrder() {
		return order;
	}

	public String getDesc() {
		return desc;
	}
	
	
}
