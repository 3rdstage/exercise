/**
 * 
 */
package thirdstage.exercise.tree.adjacancy.entities;

/**
 * @author 3rdstage
 * 
 */
public class Category{

	String id;

	String name;

	Category parent;

	int sequence;

	String description;

	int level;

	String idPath;

	String namePath;

	// constructors
	public Category(){

	}

	/**
	 * @return the id
	 */
	public String getId(){
		return id;
	}

	/**
	 * @param id
	 *           the id to set
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
	 * @param name
	 *           the name to set
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * @return the parent
	 */
	public Category getParent(){
		return parent;
	}

	/**
	 * @param parent
	 *           the parent to set
	 */
	public void setParent(Category parent){
		this.parent = parent;
	}

	/**
	 * @return the sequence
	 */
	public int getSequence(){
		return sequence;
	}

	/**
	 * @param sequence
	 *           the sequence to set
	 */
	public void setSequence(int sequence){
		this.sequence = sequence;
	}

	/**
	 * @return the description
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * @param description
	 *           the description to set
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * @return the level
	 */
	public int getLevel(){
		return level;
	}

	/**
	 * @param level
	 *           the level to set
	 */
	public void setLevel(int level){
		this.level = level;
	}

	/**
	 * @return the idPath
	 */
	public String getIdPath(){
		return idPath;
	}

	/**
	 * @param idPath
	 *           the idPath to set
	 */
	public void setIdPath(String idPath){
		this.idPath = idPath;
	}

	/**
	 * @return the namePath
	 */
	public String getNamePath(){
		return namePath;
	}

	/**
	 * @param namePath
	 *           the namePath to set
	 */
	public void setNamePath(String namePath){
		this.namePath = namePath;
	}

	@Override
	public String toString(){
		if(this.namePath != null) return this.namePath;
		else return "ID : " + id + ", Name : " + name;
	}

}
