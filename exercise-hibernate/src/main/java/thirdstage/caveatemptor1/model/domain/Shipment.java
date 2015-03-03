package thirdstage.caveatemptor1.model.domain;

import java.util.Date;


public class Shipment {

	/**
	 * @uml.property  name="inspectionPeriodDays"
	 */
	private int inspectionPeriodDays;

	/**
	 * Getter of the property <tt>inspectionPeriodDays</tt>
	 * @return  Returns the inspectionPeriodDays.
	 * @uml.property  name="inspectionPeriodDays"
	 */
	public int getInspectionPeriodDays() {
		return inspectionPeriodDays;
	}

	/**
	 * Setter of the property <tt>inspectionPeriodDays</tt>
	 * @param inspectionPeriodDays  The inspectionPeriodDays to set.
	 * @uml.property  name="inspectionPeriodDays"
	 */
	public void setInspectionPeriodDays(int inspectionPeriodDays) {
		this.inspectionPeriodDays = inspectionPeriodDays;
	}

	/**
	 * @uml.property  name="state"
	 */
	private ShipmentState state;

	/**
	 * Getter of the property <tt>state</tt>
	 * @return  Returns the state.
	 * @uml.property  name="state"
	 */
	public ShipmentState getState() {
		return state;
	}

	/**
	 * Setter of the property <tt>state</tt>
	 * @param state  The state to set.
	 * @uml.property  name="state"
	 */
	public void setState(ShipmentState state) {
		this.state = state;
	}

	/**
	 * @uml.property  name="created"
	 */
	private Date created;

	/**
	 * Getter of the property <tt>created</tt>
	 * @return  Returns the created.
	 * @uml.property  name="created"
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Setter of the property <tt>created</tt>
	 * @param created  The created to set.
	 * @uml.property  name="created"
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/** 
	 * @uml.property name="item"
	 * @uml.associationEnd inverse="shipment:thirdstage.caveatemptor1.model.domain.Item"
	 */
	private Item item;

	/** 
	 * Getter of the property <tt>item</tt>
	 * @return  Returns the item.
	 * @uml.property  name="item"
	 */
	public Item getItem() {
		return item;
	}

	/** 
	 * Setter of the property <tt>item</tt>
	 * @param item  The item to set.
	 * @uml.property  name="item"
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/** 
	 * @uml.property name="address"
	 * @uml.associationEnd inverse="shipment:thirdstage.caveatemptor1.model.domain.Address"
	 * @uml.association name="delivered to"
	 */
	private Address address;

	/** 
	 * Getter of the property <tt>address</tt>
	 * @return  Returns the address.
	 * @uml.property  name="address"
	 */
	public Address getAddress() {
		return address;
	}

	/** 
	 * Setter of the property <tt>address</tt>
	 * @param address  The address to set.
	 * @uml.property  name="address"
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/** 
	 * @uml.property name="buyer"
	 * @uml.associationEnd inverse="shipment:thirdstage.caveatemptor1.model.domain.User"
	 * @uml.association name="to"
	 */
	private User user;

	/**
	 * Getter of the property <tt>buyer</tt>
	 * @return  Returns the user.
	 * @uml.property  name="buyer"
	 */
	public User getBuyer() {
		return user;
	}

	/**
	 * Setter of the property <tt>buyer</tt>
	 * @param buyer  The user to set.
	 * @uml.property  name="buyer"
	 */
	public void setBuyer(User buyer) {
		user = buyer;
	}

	/** 
	 * @uml.property name="seller"
	 * @uml.associationEnd inverse="shipment:thirdstage.caveatemptor1.model.domain.User"
	 * @uml.association name="from"
	 */
	private User user1;

	/**
	 * Getter of the property <tt>seller</tt>
	 * @return  Returns the user1.
	 * @uml.property  name="seller"
	 */
	public User getSeller() {
		return user1;
	}

	/**
	 * Setter of the property <tt>seller</tt>
	 * @param seller  The user1 to set.
	 * @uml.property  name="seller"
	 */
	public void setSeller(User seller) {
		user1 = seller;
	}

}
