package thirdstage.exercise.spring.case2;

import java.math.BigDecimal;

/**
 *
 * @author 3rdstage
 */
public class CashRegisterImpl {

	private PriceMatrix priceMatrix = null;
	
	public CashRegisterImpl(PriceMatrix priceMatrix){
		this.priceMatrix = priceMatrix;
		
	}
	
	public BigDecimal calculateTotalPrice(ShoppingCart cart){
		BigDecimal total = new BigDecimal("0.0");
		
		for(Item item : cart.getItems()){
			total.add(priceMatrix.getPrice(item));
		}
		
		return total;
	} 
	
	
}
