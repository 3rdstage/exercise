package thirdstage.exercise.spring.case13;

/**
 * @author   3rdstage
 */
public class Person {

	private Name name = new Name();
	/**
	 * @uml.property  name="bornOn"
	 */
	private java.util.Date bornOn = null;
	/**
	 * @uml.property  name="favoriteProgrammingLanguage"
	 */
	private String favoriteProgrammingLanguage = null;
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public Name getName() {
		return name;
	}
	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(Name name) {
		this.name = name;
	}
	/**
	 * @return
	 * @uml.property  name="bornOn"
	 */
	public java.util.Date getBornOn() {
		return bornOn;
	}
	/**
	 * @param bornOn
	 * @uml.property  name="bornOn"
	 */
	public void setBornOn(java.util.Date bornOn) {
		this.bornOn = bornOn;
	}
	/**
	 * @return
	 * @uml.property  name="favoriteProgrammingLanguage"
	 */
	public String getFavoriteProgrammingLanguage() {
		return favoriteProgrammingLanguage;
	}
	/**
	 * @param favoriteProgrammingLanguage
	 * @uml.property  name="favoriteProgrammingLanguage"
	 */
	public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
		this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer(200);
		sb.append("Name : [").append(name.toString()).append("], ");
		sb.append("Born On : [").append(bornOn).append("], ");
		sb.append("Favorite Programming Language : [").append(favoriteProgrammingLanguage).append("]");
		return sb.toString();
		
	}

}
