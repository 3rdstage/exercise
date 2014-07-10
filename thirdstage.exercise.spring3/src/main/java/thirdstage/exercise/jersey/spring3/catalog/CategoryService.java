package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;

import javax.annotation.Nonnull;

public interface CategoryService {
	
	@Nonnull
	List<CategoryValue> findAllCategories();

}
