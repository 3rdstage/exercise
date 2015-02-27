package thirdstage.petstore1.domain.entities;

import java.io.Serializable;

public class LineItem implements Serializable{

	private int orderId;
	private int lineNumber;
	private int quantity;
	private Item item;
	private double unitPrice;

	/* Constructors */
	public LineItem(){}

	public LineItem(int lineNumber, CartItem cartItem){
		this.lineNumber = lineNumber;
		this.quantity = cartItem.getQuantity();
		this.item = cartItem.getItem();
		this.unitPrice = cartItem.getItem().getListPrice();
	}

	/* Getter/Setter */
	public int getOrderId(){
		return orderId;
	}

	public void setOrderId(int orderId){
		this.orderId = orderId;
	}

	public int getLineNumber(){
		return lineNumber;
	}

	public void setLineNumber(int lineNumber){
		this.lineNumber = lineNumber;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public Item getItem(){
		return item;
	}

	public void setItem(Item item){
		this.item = item;
	}

	public double getUnitPrice(){
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice){
		this.unitPrice = unitPrice;
	}

	/* Business Logic Methods */
	public double getTotalPrice(){
		return (this.unitPrice * this.quantity);
	}
}


