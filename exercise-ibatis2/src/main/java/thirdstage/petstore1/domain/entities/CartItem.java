package thirdstage.petstore1.domain.entities;

import java.io.Serializable;

public class CartItem implements Serializable{

	private Item item;
	private int quantity;
	private boolean inStock;

	/* Getter/Setter */
	public Item getItem(){ return item; }

	public void setItem(Item item){	this.item = item; }

	public int getQuantity(){
		return quantity;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public boolean isInStock(){
		return inStock;
	}

	public void setInStock(boolean inStock){
		this.inStock = inStock;
	}

	
	/* Logic Methods */
	public double getTotalPrice(){
		if(item != null){
			return item.getListPrice() * quantity;
		}
		else{ return 0; }
	}
	
	public void incrementQuantity(){ quantity++; }
}
