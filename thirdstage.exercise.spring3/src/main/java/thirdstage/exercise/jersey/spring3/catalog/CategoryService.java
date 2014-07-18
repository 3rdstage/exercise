package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface CategoryService {
	
	@Nonnull
	List<CategoryValue> findAllCategories();

}
