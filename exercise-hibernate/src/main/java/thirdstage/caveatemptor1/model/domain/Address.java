package thirdstage.caveatemptor1.model.domain;


public class Address {

	/**
	 * @uml.property  name="street"
	 */
	private String street = "";

	/**
	 * Getter of the property <tt>street</tt>
	 * @return  Returns the street.
	 * @uml.property  name="street"
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Setter of the property <tt>street</tt>
	 * @param street  The street to set.
	 * @uml.property  name="street"
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @uml.property  name="zipCode"
	 */
	private String zipCode = "";

	/**
	 * Getter of the property <tt>zipCode</tt>
	 * @return  Returns the zipCode.
	 * @uml.property  name="zipCode"
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Setter of the property <tt>zipCode</tt>
	 * @param zipCode  The zipCode to set.
	 * @uml.property  name="zipCode"
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @uml.property  name="city"
	 */
	private String city = "";

	/**
	 * Getter of the property <tt>city</tt>
	 * @return  Returns the city.
	 * @uml.property  name="city"
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter of the property <tt>city</tt>
	 * @param city  The city to set.
	 * @uml.property  name="city"
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
