/**
 * 
 */
package thirdstage.exercise.ibatis.case6;

import java.util.List;
import java.util.Map;

/**
 * @author 3rdstage
 *
 */
public interface ProductDao {
	
	Map<String, Object> getProduct(String id);
	
	List<Map<String, Object>> getProductsByCategory(String categoryId);
	
	
	

}
