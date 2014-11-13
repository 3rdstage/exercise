package thirdstage.exercise.jung.case1;

public class Category extends CategoryValue{
	

	public Category(){
		super(null, null, null, 0, null);
	}
	
	public void setId(String id){ this.id = id; }
	
	public void setName(String name){ this.name = name; }
	
	public void setParent(Category parent){ this.parent = parent; }
	
	public void setOrder(int n){ this.order = n; }
	
	public void setDesc(String desc){ this.desc = desc; }
	

}
