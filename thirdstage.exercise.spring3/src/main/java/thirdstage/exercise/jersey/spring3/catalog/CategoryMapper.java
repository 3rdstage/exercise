package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Repository("categoryMapper")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@ParametersAreNonnullByDefault
public interface CategoryMapper {
	
	@Nonnull
	List<CategoryValue> selectAllCategories();

}
