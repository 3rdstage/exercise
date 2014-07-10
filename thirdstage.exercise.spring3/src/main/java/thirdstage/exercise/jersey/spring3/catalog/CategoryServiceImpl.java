package thirdstage.exercise.jersey.spring3.catalog;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CategoryServiceImpl implements CategoryService {
	
	private static List<CategoryValue> categories = new ArrayList<CategoryValue>();
	
	static{
		categories.add(new CategoryValue("CAT0001", "Electronics"));
		categories.add(new CategoryValue("CAT0002", "Cell Phones"));
		categories.add(new CategoryValue("CAT0003", "Smartphones"));
		categories.add(new CategoryValue("CAT0004", "Digital Camera"));
		categories.add(new CategoryValue("CAT0005", "Fashion"));
	}
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<CategoryValue> findAllCategories() {
		logger.info("executing findAllCategories on {}/{}", this.toString(), this.hashCode());
		return categories;
	}

}
