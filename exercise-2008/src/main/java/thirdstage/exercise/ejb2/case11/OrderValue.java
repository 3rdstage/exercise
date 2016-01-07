/**
 * 
 */
package thirdstage.exercise.ejb2.case11;

import java.util.Date;

/**
 * @author 3rdstage
 *
 */
public class OrderValue implements java.io.Serializable{
	
	
	private String customerId;
	
	private String poNo;
	
	private String productId;
	
	private int qty;
	
	private String orderNo;
	
	private String orderedDate;
	
	private String deliveryNo;
	
	private String deliverableDate;
	
	private String deliveredDate;
	
	private String receiptNo;
	
	private String receiptDate;
	
	private String message;

	
	public OrderValue(){}
	
	
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
	 * @return the productId
	 */
	public String getProductId(){
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId){
		this.productId = productId;
	}

	/**
	 * @return the qty
	 */
	public int getQty(){
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty){
		this.qty = qty;
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo(){
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}

	/**
	 * @return the orderedDate
	 */
	public String getOrderedDate(){
		return orderedDate;
	}

	/**
	 * @param orderedDate the orderedDate to set
	 */
	public void setOrderedDate(String orderedDate){
		this.orderedDate = orderedDate;
	}

	/**
	 * @return the deliveryNo
	 */
	public String getDeliveryNo(){
		return deliveryNo;
	}

	/**
	 * @param deliveryNo the deliveryNo to set
	 */
	public void setDeliveryNo(String deliveryNo){
		this.deliveryNo = deliveryNo;
	}

	/**
	 * @return the deliverableDate
	 */
	public String getDeliverableDate(){
		return deliverableDate;
	}

	/**
	 * @param deliverableDate the deliverableDate to set
	 */
	public void setDeliverableDate(String deliverableDate){
		this.deliverableDate = deliverableDate;
	}

	/**
	 * @return the deliveredDate
	 */
	public String getDeliveredDate(){
		return deliveredDate;
	}

	/**
	 * @param deliveredDate the deliveredDate to set
	 */
	public void setDeliveredDate(String deliveredDate){
		this.deliveredDate = deliveredDate;
	}

	/**
	 * @return the receiptNo
	 */
	public String getReceiptNo(){
		return receiptNo;
	}

	/**
	 * @param receiptNo the receiptNo to set
	 */
	public void setReceiptNo(String receiptNo){
		this.receiptNo = receiptNo;
	}

	/**
	 * @return the receiptDate
	 */
	public String getReceiptDate(){
		return receiptDate;
	}

	/**
	 * @param receiptDate the receiptDate to set
	 */
	public void setReceiptDate(String receiptDate){
		this.receiptDate = receiptDate;
	}

	/**
	 * @return the message
	 */
	public String getMessage(){
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message){
		this.message = message;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Customer ID : ").append(this.getCustomerId()).append("\n")
		  .append("Product ID : ").append(this.getProductId()).append("\n")
		  .append("Quantity : ").append(this.getQty()).append("\n")
		  .append("Order No : ").append(this.getOrderNo()).append("\n")
		  .append("Ordered Date : ").append(this.getOrderedDate()).append("\n")
		  .append("Delivery No : ").append(this.getDeliveryNo()).append("\n")
		  .append("Deliverable Date : ").append(this.getDeliverableDate()).append("\n")
		  .append("Receipt No : ").append(this.getReceiptNo()).append("\n")
		  .append("Receipt Date : ").append(this.getReceiptDate()).append("\n");

		return sb.toString();
	}
	
	
	
	

}
