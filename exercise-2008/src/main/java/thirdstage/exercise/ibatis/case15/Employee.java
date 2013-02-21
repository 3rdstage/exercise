/**
 * 
 */
package thirdstage.exercise.ibatis.case15;

/**
 * @author 3rdstage
 *
 */
public class Employee{
	
	private Long id;
	
	private String name;
	
	private Employee manager;
	
	public Employee(){}

	/**
	 * @return the id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id){
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName(){
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * @return the manager
	 */
	public Employee getManager(){
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Employee manager){
		this.manager = manager;
	}
	
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("ID : ").append(this.id).append(", Name : ").append(this.name);
		if(this.manager != null) sb.append(", Manager ID : ").append(this.manager.getId());
		
		return sb.toString();
	}
}
