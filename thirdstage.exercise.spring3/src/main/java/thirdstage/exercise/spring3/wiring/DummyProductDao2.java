package thirdstage.exercise.spring3.wiring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("productDao2")
public class DummyProductDao2 implements ProductDao {

	public List<Product> findProductsByCategory(String categoryId) {

		List<Product> result = new ArrayList<Product>();
		result.add(new Product());
		result.add(new Product());
		
		return result;
	
	}

}
