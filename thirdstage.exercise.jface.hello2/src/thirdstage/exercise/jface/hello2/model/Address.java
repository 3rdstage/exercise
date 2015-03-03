package thirdstage.exercise.jface.hello2.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Address {
	
	private String street;
	private String number;
	private String postalCode;
	private String city;
	private String country;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(String propName, PropertyChangeListener listener){
		this.propertyChangeSupport.addPropertyChangeListener(propName, listener);
			
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener){
		this.propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	
	public Address(){}
	
	public Address(String postalCode, String city, String country){
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.propertyChangeSupport.firePropertyChange("street", this.street, this.street = street);
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.propertyChangeSupport.firePropertyChange("number", this.number, this.number = number);
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.propertyChangeSupport.firePropertyChange("postalCode", this.postalCode, this.postalCode = postalCode);
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.propertyChangeSupport.firePropertyChange("city", this.city, this.city = city);
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.propertyChangeSupport.firePropertyChange("country", this.country, this.country = country);
	}
	
	@Override
	public String toString(){
		
		String s = "";
		s += street != null ? street + " " : "";
		s += number != null ? number + " " : "";
		s += postalCode != null ? postalCode + " " : "";
		s += city != null ? city + " " : "";
		s += country != null ? country + " " : "";
		
		return s;
	}

}
