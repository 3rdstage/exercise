package thirdstage.caveatemptor1.model.domain;

import java.math.BigDecimal;
import java.util.Date;


public class Bid {

	/** 
	 * @uml.property name="item"
	 * @uml.associationEnd inverse="bids:thirdstage.caveatemptor1.model.domain.Item"
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
	 * @uml.property name="owner"
	 * @uml.associationEnd inverse="bid:thirdstage.caveatemptor1.model.domain.User"
	 */
	private User owner;

	/** 
	 * Getter of the property <tt>owner</tt>
	 * @return  Returns the owner.
	 * @uml.property  name="owner"
	 */
	public User getOwner() {
		return owner;
	}

	/** 
	 * Setter of the property <tt>owner</tt>
	 * @param owner  The owner to set.
	 * @uml.property  name="owner"
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @uml.property  name="amount"
	 */
	private BigDecimal amount;

	/**
	 * Getter of the property <tt>amount</tt>
	 * @return  Returns the amount.
	 * @uml.property  name="amount"
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Setter of the property <tt>amount</tt>
	 * @param amount  The amount to set.
	 * @uml.property  name="amount"
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

}
