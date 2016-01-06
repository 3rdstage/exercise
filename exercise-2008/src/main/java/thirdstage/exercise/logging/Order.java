/**
 * 
 */
package thirdstage.exercise.logging;

import java.util.Date;

/**
 * @author 3rdstage
 *
 */
public class Order{
	
	private String id;
	
	private String poNo;
	
	private String customer;
	
	private double totalPrice;
	
	private Date orderedDate;

	/**
	 * @return the id
	 */
	public String getId(){
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * @return the poNo
	 */
	public String getPoNo(){
		return poNo;
	}

	/**
	 * @param poNo the poNo to set
	 */
	public void setPoNo(String poNo){
		this.poNo = poNo;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer(){
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer){
		this.customer = customer;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice(){
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice){
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderedDate
	 */
	public Date getOrderedDate(){
		return orderedDate;
	}

	/**
	 * @param orderedDate the orderedDate to set
	 */
	public void setOrderedDate(Date orderedDate){
		this.orderedDate = orderedDate;
	}

}
