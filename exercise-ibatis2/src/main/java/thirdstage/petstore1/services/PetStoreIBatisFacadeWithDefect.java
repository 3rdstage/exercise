/**
 * 
 */
package thirdstage.petstore1.services;

import java.sql.SQLException;
import thirdstage.petstore1.domain.entities.Order;

/**
 * @author 3rdstage
 *
 */
public class PetStoreIBatisFacadeWithDefect extends PetStoreIBatisFacade{

	@Override
	public void makeOrder(Order order){
		try{
			this.getOrderDao().makeOrder(order);
			this.getItemDao().updateQuantity(order);

			throw  new UnsupportedOperationException();
		}catch(SQLException ex){
			throw this.getSQLExceptionTranslator().translate("Add a new order", null, ex);
		}
	}
}
