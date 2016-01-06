package thirdstage.exercise.jersey.spring3.catalog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("categoryService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CategoryServiceImpl implements CategoryService {
	
	private static List<CategoryValue> categories = new LinkedList<CategoryValue>();
	
	static{
		categories.add(new CategoryValue("CAT0001", "Electronics"));
		categories.add(new CategoryValue("CAT0002", "Cell Phones"));
		categories.add(new CategoryValue("CAT0003", "Smartphones"));
		categories.add(new CategoryValue("CAT0004", "Digital Camera"));
		categories.add(new CategoryValue("CAT0005", "Fashion"));
	}
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="categoryMapper")
	CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryValue> findAllCategories() {
		logger.info("executing findAllCategories on {}/{}", this.toString(), this.hashCode());
		
		return this.categoryMapper.selectAllCategories();
	}

}
