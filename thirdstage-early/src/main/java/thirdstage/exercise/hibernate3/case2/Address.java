
package thirdstage.exercise.hibernate3.case2;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2005-11-02
 * @since 2005-11-02
 */
public class Address {
	
	private String country;
	private String city;
	private String street;
	private int number;
	
	/** Creates a new instance of Address */
	public Address() {
	}
	
	public Address(String country, String city, String street, int num){
		this.country = country;
		this.city = city;
		this.street = street;
		this.number = num;
	}
	
	/**
	 * @hibernate.property column="country" length="50"
	 */
	public String getCountry() {
		return country;
	}
	
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @hibernate.property column="city" length="50"
	 */
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @hibernate.property column="street" length="50"
	 */
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @hibernate.property column="number" length="10"
	 */
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
