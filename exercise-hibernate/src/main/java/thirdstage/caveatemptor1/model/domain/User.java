package thirdstage.caveatemptor1.model.domain;

import java.util.List;


public class User {

	/**
	 * @uml.property  name="firstName"
	 */
	private String firstName = "";

	/**
	 * Getter of the property <tt>firstName</tt>
	 * @return  Returns the firstName.
	 * @uml.property  name="firstName"
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter of the property <tt>firstName</tt>
	 * @param firstName  The firstName to set.
	 * @uml.property  name="firstName"
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @uml.property  name="lastName"
	 */
	private String lastName = "";

	/**
	 * Getter of the property <tt>lastName</tt>
	 * @return  Returns the lastName.
	 * @uml.property  name="lastName"
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter of the property <tt>lastName</tt>
	 * @param lastName  The lastName to set.
	 * @uml.property  name="lastName"
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @uml.property  name="userName"
	 */
	private String userName = "";

	/**
	 * Getter of the property <tt>userName</tt>
	 * @return  Returns the userName.
	 * @uml.property  name="userName"
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter of the property <tt>userName</tt>
	 * @param userName  The userName to set.
	 * @uml.property  name="userName"
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @uml.property  name="password"
	 */
	private String password = "";

	/**
	 * Getter of the property <tt>password</tt>
	 * @return  Returns the password.
	 * @uml.property  name="password"
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the property <tt>password</tt>
	 * @param password  The password to set.
	 * @uml.property  name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @uml.property  name="email"
	 */
	private String email = "";

	/**
	 * Getter of the property <tt>email</tt>
	 * @return  Returns the email.
	 * @uml.property  name="email"
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter of the property <tt>email</tt>
	 * @param email  The email to set.
	 * @uml.property  name="email"
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @uml.property  name="ranking"
	 */
	private int ranking;

	/**
	 * Getter of the property <tt>ranking</tt>
	 * @return  Returns the ranking.
	 * @uml.property  name="ranking"
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * Setter of the property <tt>ranking</tt>
	 * @param ranking  The ranking to set.
	 * @uml.property  name="ranking"
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	/**
	 * @uml.property  name="admin"
	 */
	private boolean admin;

	/**
	 * Getter of the property <tt>admin</tt>
	 * @return  Returns the admin.
	 * @uml.property  name="admin"
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Setter of the property <tt>admin</tt>
	 * @param admin  The admin to set.
	 * @uml.property  name="admin"
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/** 
	 * @uml.property name="billingDetails"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="user:thirdstage.caveatemptor1.model.domain.BillingDetail"
	 */
	private List billingDetails;

	/** 
	 * Getter of the property <tt>billingDetails</tt>
	 * @return  Returns the billingDetails.
	 * @uml.property  name="billingDetails"
	 */
	public List getBillingDetails() {
		return billingDetails;
	}

	/** 
	 * Setter of the property <tt>billingDetails</tt>
	 * @param billingDetails  The billingDetails to set.
	 * @uml.property  name="billingDetails"
	 */
	public void setBillingDetails(List billingDetails) {
		this.billingDetails = billingDetails;
	}

	/** 
	 * @uml.property name="defaultBillingDetail"
	 * @uml.associationEnd inverse="user1:thirdstage.caveatemptor1.model.domain.BillingDetail"
	 */
	private BillingDetail defaultBillingDetail;

	/** 
	 * Getter of the property <tt>defaultBillingDetail</tt>
	 * @return  Returns the defaultBillingDetail.
	 * @uml.property  name="defaultBillingDetail"
	 */
	public BillingDetail getDefaultBillingDetail() {
		return defaultBillingDetail;
	}

	/** 
	 * Setter of the property <tt>defaultBillingDetail</tt>
	 * @param defaultBillingDetail  The defaultBillingDetail to set.
	 * @uml.property  name="defaultBillingDetail"
	 */
	public void setDefaultBillingDetail(BillingDetail defaultBillingDetail) {
		this.defaultBillingDetail = defaultBillingDetail;
	}

	/**
	 * @uml.property  name="homeAddress"
	 * @uml.associationEnd  inverse="user:thirdstage.caveatemptor1.model.domain.Address"
	 * @uml.association  name="has"
	 */
	private Address homeAddress;

	/**
	 * Getter of the property <tt>homeAddress</tt>
	 * @return  Returns the homeAddress.
	 * @uml.property  name="homeAddress"
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}

	/**
	 * Setter of the property <tt>homeAddress</tt>
	 * @param homeAddress  The homeAddress to set.
	 * @uml.property  name="homeAddress"
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	/** 
	 * @uml.property name="billingAddress"
	 * @uml.associationEnd inverse="user:thirdstage.caveatemptor1.model.domain.Address"
	 */
	private Address billingAddress;

	/** 
	 * Getter of the property <tt>billingAddress</tt>
	 * @return  Returns the billingAddress.
	 * @uml.property  name="billingAddress"
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/** 
	 * Setter of the property <tt>billingAddress</tt>
	 * @param billingAddress  The billingAddress to set.
	 * @uml.property  name="billingAddress"
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	/** 
	 * @uml.property name="shippingAddress"
	 * @uml.associationEnd inverse="user:thirdstage.caveatemptor1.model.domain.Address"
	 */
	private Address shippingAddress;

	/** 
	 * Getter of the property <tt>shippingAddress</tt>
	 * @return  Returns the shippingAddress.
	 * @uml.property  name="shippingAddress"
	 */
	public Address getShippingAddress() {
		return shippingAddress;
	}

	/** 
	 * Setter of the property <tt>shippingAddress</tt>
	 * @param shippingAddress  The shippingAddress to set.
	 * @uml.property  name="shippingAddress"
	 */
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
