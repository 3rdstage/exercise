package thirdstage.sample.spring.shop1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * The order header contains the basic information for the data.<br/><br/>
 * Typically the order consists of one order header and several line items.
 * The terminology 'order header' follows that of SAP ERP. 
 * 
 * @since 1.0 2010-03-23 Initial revision
 * @author 3rdstage
 * @since 2010-03-23
 */

public class OrderHeader{
	
	private String orderId;
	
	private String customerId;
	
	private String poNo;
	
	private Date orderedDate;
	
	private String shipToAddres; 
	
	private double totalAmount;
	
	/**
	 * @return the orderId
	 */
	public String getOrderId(){
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId(){
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId){
		this.customerId = customerId;
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

	/**
	 * @return the shipToAddres
	 */
	public String getShipToAddres(){
		return shipToAddres;
	}

	/**
	 * @param shipToAddres the shipToAddres to set
	 */
	public void setShipToAddres(String shipToAddres){
		this.shipToAddres = shipToAddres;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount(){
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount){
		this.totalAmount = totalAmount;
	}

}
