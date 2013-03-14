package thirdstage.exercise.spring3.wiring;

import java.util.List;

public interface CatalogServices {
	
	
	List<Category> findAllCategories();
	
	
	List<Product> findProductsByCategory(String categoryId);
	

}
