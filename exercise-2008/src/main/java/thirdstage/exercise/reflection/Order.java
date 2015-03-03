/**
 * 
 */
package thirdstage.exercise.reflection;

/**
 * @author 3rdstage
 *
 */
public class Order{
	
	private String id;
	
	private String poNo;
	
	public Order(String poNo){
		this(poNo, (new java.util.Date()).toString());
	}
	
	private Order(String poNo, String id){
		this.poNo = poNo;
		this.id = id;
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append("This order has PO number of ")
		.append(this.poNo).append(" and ID of ").append(this.id).append(".").toString();
	}
	
	

}
