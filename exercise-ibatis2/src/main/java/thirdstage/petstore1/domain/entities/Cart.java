package thirdstage.petstore1.domain.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

public class Cart implements Serializable{
	
	private final Map<String, CartItem> items = Collections.synchronizedMap(new HashMap<String, CartItem>());
	private final PagedListHolder itemsHolder = new PagedListHolder();
	
	public Cart(){
		this.itemsHolder.setPage(4);
	}
	
	/* Getter/Setter */
	public Iterator<CartItem> getAllCartItems(){ return itemsHolder.getSource().iterator(); }
	public PagedListHolder getItemsHolder(){ return itemsHolder; }
	public int getNumberOfItems(){ return itemsHolder.getSource().size(); }
	
	/* Business Logic Methods */
	public boolean containsItem(String itemId){
		return items.containsKey(itemId);
	}
	

	public void addItem(Item item, boolean isInStock){
		if(containsItem(item.getId())){
			(items.get(item.getId())).incrementQuantity();
		}
		else{
			CartItem cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setQuantity(1);
			cartItem.setInStock(isInStock);
			items.put(item.getId(), cartItem);
			itemsHolder.getSource().add(cartItem);
		}
	}
	
	public Item removeItem(String itemId){
		if(containsItem(itemId)){
			CartItem cartItem = items.remove(itemId);
			itemsHolder.getSource().remove(cartItem);
			return cartItem.getItem();
		}
		else{ return null; }
	}

	public void incrementQuantityOfItem(String itemId){
		if(containsItem(itemId)){
			CartItem cartItem = items.get(itemId);
			cartItem.incrementQuantity();
		}
		else{}
	}

	public void setQuantityOfItem(String itemId, int quantity){
		if(containsItem(itemId)){
			CartItem cartItem = items.get(itemId);
			cartItem.setQuantity(quantity);
		}
		else{}
	}
	
	public double getSubTotal(){
		double subTotal = 0.0;
		Iterator<CartItem> itr = this.getAllCartItems();
		CartItem cartItem = null;
		while(itr.hasNext()){
			cartItem = itr.next();
			subTotal += cartItem.getItem().getListPrice() * cartItem.getQuantity();
		}
		
		return subTotal;
	}
}
