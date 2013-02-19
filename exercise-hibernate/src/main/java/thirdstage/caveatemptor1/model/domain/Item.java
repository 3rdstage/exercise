package thirdstage.caveatemptor1.model.domain;

import java.util.List;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @uml.dependency   supplier="thirdstage.caveatemptor1.model.domain.Category"
 * @uml.dependency   supplier="thirdstage.caveatemptor1.model.domain.User"
 */
public class Item {

	/**
	 * @uml.property  name="name"
	 */
	private String name = "";

	/**
	 * @uml.property  name="description"
	 */
	private String description = "";

	/**
	 * @uml.property   name="buyer"
	 * @uml.associationEnd   inverse="item:thirdstage.caveatemptor1.model.domain.User"
	 * @uml.association   name="bought by"
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
	 * Getter of the property <tt>description</tt>
	 * @return  Returns the description.
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name."contributions.viewCategory.name"
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
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
	 * Setter of the property <tt>description</tt>
	 * @param description  The description to set.
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @uml.property   name="categories"
	 * @uml.associationEnd   multiplicity="(0 -1)" ordering="true" inverse="items:thirdstage.caveatemptor1.model.domain.Category"
	 */
	private List categories;

	/** 
	 * Getter of the property <tt>categories</tt>
	 * @return  Returns the categories.
	 * @uml.property  name="categories"
	 */
	public List getCategories() {
		return categories;
	}

	/** 
	 * Setter of the property <tt>categories</tt>
	 * @param categories  The categories to set.
	 * @uml.property  name="categories"
	 */
	public void setCategories(List categories) {
		this.categories = categories;
	}

	/**
	 * @uml.property   name="bids"
	 * @uml.associationEnd   multiplicity="(0 -1)" ordering="true" inverse="item:thirdstage.caveatemptor1.model.domain.Bid"
	 */
	private List bids;

	/** 
	 * Getter of the property <tt>bids</tt>
	 * @return  Returns the bids.
	 * @uml.property  name="bids"
	 */
	public List getBids() {
		return bids;
	}

	/** 
	 * Setter of the property <tt>bids</tt>
	 * @param bids  The bids to set.
	 * @uml.property  name="bids"
	 */
	public void setBids(List bids) {
		this.bids = bids;
	}

	/**
	 * @uml.property   name="winningBid"
	 * @uml.associationEnd   inverse="item1:thirdstage.caveatemptor1.model.domain.Bid"
	 */
	private Bid winningBid;

	/** 
	 * Getter of the property <tt>winningBid</tt>
	 * @return  Returns the winningBid.
	 * @uml.property  name="winningBid"
	 */
	public Bid getWinningBid() {
		return winningBid;
	}

	/** 
	 * Setter of the property <tt>winningBid</tt>
	 * @param winningBid  The winningBid to set.
	 * @uml.property  name="winningBid"
	 */
	public void setWinningBid(Bid winningBid) {
		this.winningBid = winningBid;
	}

	/**
	 * @uml.property  name="initialPrice"
	 */
	private BigDecimal initialPrice;

	/**
	 * Getter of the property <tt>initialPrice</tt>
	 * @return  Returns the initialPrice.
	 * @uml.property  name="initialPrice"
	 */
	public BigDecimal getInitialPrice() {
		return initialPrice;
	}

	/**
	 * Setter of the property <tt>initialPrice</tt>
	 * @param initialPrice  The initialPrice to set.
	 * @uml.property  name="initialPrice"
	 */
	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}

	/**
	 * @uml.property  name="reservePrice"
	 */
	private BigDecimal reservePrice;

	/**
	 * Getter of the property <tt>reservePrice</tt>
	 * @return  Returns the reservePrice.
	 * @uml.property  name="reservePrice"
	 */
	public BigDecimal getReservePrice() {
		return reservePrice;
	}

	/**
	 * Setter of the property <tt>reservePrice</tt>
	 * @param reservePrice  The reservePrice to set.
	 * @uml.property  name="reservePrice"
	 */
	public void setReservePrice(BigDecimal reservePrice) {
		this.reservePrice = reservePrice;
	}

	/**
	 * @uml.property  name="startDate"
	 */
	private Date startDate;

	/**
	 * Getter of the property <tt>startDate</tt>
	 * @return  Returns the startDate.
	 * @uml.property  name="startDate"
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Setter of the property <tt>startDate</tt>
	 * @param startDate  The startDate to set.
	 * @uml.property  name="startDate"
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @uml.property  name="endDate"
	 */
	private Date endDate;

	/**
	 * Getter of the property <tt>endDate</tt>
	 * @return  Returns the endDate.
	 * @uml.property  name="endDate"
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Setter of the property <tt>endDate</tt>
	 * @param endDate  The endDate to set.
	 * @uml.property  name="endDate"
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @uml.property   name="state"
	 */
	private ItemState state;

	/** 
	 * Getter of the property <tt>state</tt>
	 * @return  Returns the state.
	 * @uml.property  name="state"
	 */
	public ItemState getState() {
		return state;
	}

	/** 
	 * Setter of the property <tt>state</tt>
	 * @param state  The state to set.
	 * @uml.property  name="state"
	 */
	public void setState(ItemState state) {
		this.state = state;
	}

	/**
	 * @uml.property  name="approvalDatetime"
	 */
	private Date approvalDatetime;

	/** 
	 * Getter of the property <tt>approvalDate</tt>
	 * @return  Returns the approvalDate.
	 * @uml.property  name="approvalDatetime"
	 */
	public Date getApprovalDatetime() {
		return approvalDatetime;
	}

	/** 
	 * Setter of the property <tt>approvalDate</tt>
	 * @param approvalDate  The approvalDate to set.
	 * @uml.property  name="approvalDatetime"
	 */
	public void setApprovalDatetime(Date approvalDatetime) {
		this.approvalDatetime = approvalDatetime;
	}

	/**
	 * @uml.property   name="seller"
	 * @uml.associationEnd   inverse="item:thirdstage.caveatemptor1.model.domain.User"
	 * @uml.association   name="sold by"
	 */
	private User seller;

	/** 
	 * Getter of the property <tt>seller</tt>
	 * @return  Returns the seller.
	 * @uml.property  name="seller"
	 */
	public User getSeller() {
		return seller;
	}

	/** 
	 * Setter of the property <tt>seller</tt>
	 * @param seller  The seller to set.
	 * @uml.property  name="seller"
	 */
	public void setSeller(User seller) {
		this.seller = seller;
	}


}
