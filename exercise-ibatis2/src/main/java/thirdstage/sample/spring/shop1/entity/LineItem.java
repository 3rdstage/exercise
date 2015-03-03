package thirdstage.sample.spring.shop1.entity;

public class LineItem{
	
	private int itemNo;

	private String productId;
	
	private String productName;
	
	private int orderedCount;

	public LineItem(){
		super();
	}

	/**
	 * @return the itemNo
	 */
	public int getItemNo(){
		return itemNo;
	}

	/**
	 * @param itemNo the itemNo to set
	 */
	public void setItemNo(int itemNo){
		this.itemNo = itemNo;
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
	 * @return the productName
	 */
	public String getProductName(){
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName){
		this.productName = productName;
	}

	/**
	 * @return the orderedCount
	 */
	public int getOrderedCount(){
		return orderedCount;
	}

	/**
	 * @param orderedCount the orderedCount to set
	 */
	public void setOrderedCount(int orderedCount){
		this.orderedCount = orderedCount;
	}
	
	
	
}
