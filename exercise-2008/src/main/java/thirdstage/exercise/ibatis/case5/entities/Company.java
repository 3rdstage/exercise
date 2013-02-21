package thirdstage.exercise.ibatis.case5.entities;

public class Company{
	
	private Long id;
	
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	private String name;
	
	public Company(){}
	
	
	

}
