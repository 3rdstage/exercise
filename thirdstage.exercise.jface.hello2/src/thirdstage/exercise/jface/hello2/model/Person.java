package thirdstage.exercise.jface.hello2.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person implements PropertyChangeListener {
	
	
	private String firstName;
	private String lastName;
	private boolean married;
	private String gender;
	private Integer age;
	private Address address;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public Person(){
	}

	public void addPropertyChangeListener(String propName, PropertyChangeListener listener){
		this.propertyChangeSupport.addPropertyChangeListener(propName, listener);
		
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener){
		this.propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.propertyChangeSupport.firePropertyChange("firstName", this.firstName, this.firstName = firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.propertyChangeSupport.firePropertyChange("lastName", this.lastName, this.lastName = lastName);
	}

	/**
	 * @return the married
	 */
	public boolean isMarried() {
		return married;
	}

	/**
	 * @param married the married to set
	 */
	public void setMarried(boolean married) {
		this.propertyChangeSupport.firePropertyChange("married", this.married, this.married = married);
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.propertyChangeSupport.firePropertyChange("gender", this.gender, this.gender = gender);
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.propertyChangeSupport.firePropertyChange("gender", this.gender, this.gender = gender);
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		address.addPropertyChangeListener("country", this);
		this.propertyChangeSupport.firePropertyChange("address", this.address, this.address = address);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		//@TODO unclear, difficult to understand
		this.propertyChangeSupport.firePropertyChange("address", null, address);

	}

}
