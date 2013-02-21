package thirdstage.exercise.sql.tree.case1.entities;

public class Menu{
	
	private String id;
	
	private String name;
	
	private String description;
	
	private Menu parentMenu;
	
	private int sequence;
	
	private int level;
	
	private String namePath;

	/**
	 * @return the id
	 */
	public String getId(){
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id){
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
	 * @return the description
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * @return the parentMenu
	 */
	public Menu getParentMenu(){
		return parentMenu;
	}

	/**
	 * @param parentMenu the parentMenu to set
	 */
	public void setParentMenu(Menu parentMenu){
		this.parentMenu = parentMenu;
	}

	/**
	 * @return the sequence
	 */
	public int getSequence(){
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(int sequence){
		this.sequence = sequence;
	}

	/**
	 * @return the level
	 */
	public int getLevel(){
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level){
		this.level = level;
	}

	/**
	 * @return the namePath
	 */
	public String getNamePath(){
		return namePath;
	}

	/**
	 * @param namePath the namePath to set
	 */
	public void setNamePath(String namePath){
		this.namePath = namePath;
	}
	
	
	

}
