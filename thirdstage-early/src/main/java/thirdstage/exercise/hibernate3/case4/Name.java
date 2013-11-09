package thirdstage.exercise.hibernate3.case4;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-12-30, 3rdstage
 * @since 2005-12-30
 */
public class Name {
	
	private char initial;
	private String firstName = null;
	private String lastName = null;
	
	/**
	 * Creates a new instance of Name
	 */
	public Name() {
	}

	/**
	 * @hibernate.property type="string" length="60"
	 * @hibernate.column name="firstName"
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @hibernate.property type="string" length="1"
	 * @hibernate.column name="initial"
	 */
	public char getInitial() {
		return initial;
	}

	public void setInitial(char initial) {
		this.initial = initial;
	}
	
	/**
	 * @hibernate.property type="string" length="60"
	 * @hibernate.column name="lastName"
	 */
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	public String getFullName(){
		return this.firstName + " " + this.initial + ". " + this.lastName;
	
	}
	*/
	
}
