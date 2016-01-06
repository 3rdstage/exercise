package thirdstage.exercise.spring3.wiring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("categoryDao1")
public class DummyCategoryDao1 implements CategoryDao {

	public List<Category> findAllCategories() {

		List<Category> result = new ArrayList<Category>();
		result.add(new Category());
		
		return result;
	}

}
