package thirdstage.caveatemptor1.model.domain;


public class BillingDetail {

	/**
	 * @uml.property  name="ownerName"
	 */
	private String ownerName = "";

	/**
	 * Getter of the property <tt>ownerName</tt>
	 * @return  Returns the ownerName.
	 * @uml.property  name="ownerName"
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Setter of the property <tt>ownerName</tt>
	 * @param ownerName  The ownerName to set.
	 * @uml.property  name="ownerName"
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/** 
	 * @uml.property name="user"
	 * @uml.associationEnd inverse="billingDetails:thirdstage.caveatemptor1.model.domain.User"
	 */
	private User user;

	/** 
	 * Getter of the property <tt>user</tt>
	 * @return  Returns the user.
	 * @uml.property  name="user"
	 */
	public User getUser() {
		return user;
	}

	/** 
	 * Setter of the property <tt>user</tt>
	 * @param user  The user to set.
	 * @uml.property  name="user"
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
