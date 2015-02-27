package thirdstage.exercise.spring.case2;

import java.math.BigDecimal;

/**
 * 
 * @author 3rdstage
 * @since 2008-02-18
 */
public class CashRegisterImpl2 implements CashRegister {

	private PriceMatrix priceMatrix;
	
	public void setPriceMatrix(PriceMatrix priceMatrix){
		this.priceMatrix = priceMatrix;
		
	}
	
	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring.case2.CashRegister#calculateTotalPrice(thirdstage.exercise.spring.case2.ShoppingCart)
	 */
	public BigDecimal calculateTotalPrice(ShoppingCart cart) {
		BigDecimal total = new BigDecimal("0.0");
		for(Item item : cart.getItems()) total.add(priceMatrix.getPrice(item));
			
		return null;
	}

}
