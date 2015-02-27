package thirdstage.exercise.spring.case1;

/**
 *
 * @author 3rdstage
 */
public interface OrderItem {
	
	public Product getProduct();
	public void setProduct(Product product);
	
	public double getQuantity();
	public void setQuantity(double quantity);
	
	public double getAmount();
	public void setAmount(double amount);
	
	public boolean isDiscreteItem();
	
	
}
