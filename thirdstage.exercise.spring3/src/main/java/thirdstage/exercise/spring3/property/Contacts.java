/**
 * 
 */
package thirdstage.exercise.spring3.property;

/**
 * @author 3rdstage
 *
 */
public class Contacts {
	
	private String telephoneNo;
	
	private String address;
	
	private String email;

	/**
	 * @return the telephoneNo
	 */
	public String getTelephoneNo() {
		return telephoneNo;
	}

	/**
	 * @param telephoneNo the telephoneNo to set
	 */
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString(){
		
		return String.format("Telephone : %1$s, Address : %2$s, email : %3$s", this.telephoneNo, this.address, this.email);
	}
	
}
