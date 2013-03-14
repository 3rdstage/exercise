package thirdstage.exercise.spring3.wiring;

import java.util.List;

public interface ProductDao {
	
	List<Product> findProductsByCategory(String categoryId);

}
