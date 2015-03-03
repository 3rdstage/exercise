package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@ParametersAreNonnullByDefault
public interface CategoryService {
	
	@Nonnull
	List<CategoryValue> findAllCategories();

}
