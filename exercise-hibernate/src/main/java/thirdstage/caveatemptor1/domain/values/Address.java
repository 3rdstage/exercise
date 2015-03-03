package thirdstage.caveatemptor1.domain.values;

import javax.persistence.Embeddable;

@Embeddable
public class Address{

	private String street;

	private String city;

	private String zipcode;

	public String getStreet(){
		return this.street;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getZipcode(){
		return this.zipcode;
	}

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

}
