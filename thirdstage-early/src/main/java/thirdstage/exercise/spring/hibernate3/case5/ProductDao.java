
package thirdstage.exercise.spring.hibernate3.case5;

import org.springframework.dao.DataAccessException;

/**
 *
 * @author 3rdstage
 */
public interface ProductDao {
	
	public java.util.Collection getProductsByCategory(final String category) throws Exception;
	
	public java.util.List<Product> getProductsByCategory2(String category) throws Exception;
	
}
