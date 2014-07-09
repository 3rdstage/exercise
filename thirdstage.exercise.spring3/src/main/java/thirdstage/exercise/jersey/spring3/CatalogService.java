package thirdstage.exercise.jersey.spring3;

import java.util.List;

import javax.annotation.Nonnull;

public interface CatalogService {
	
	@Nonnull
	List<CategoryValue> findAllCategories();

}
