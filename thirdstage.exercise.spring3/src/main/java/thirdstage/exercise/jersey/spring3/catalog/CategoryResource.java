package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.Resource;
import javax.annotation.concurrent.ThreadSafe;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.sun.jersey.api.core.ResourceContext;

@Component("categoryResource")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryResource{
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Context
	private ResourceContext resourceContext;
	
	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllCategories(){
		logger.info("executing getAllCategories on {}/{}", this.toString(), this.hashCode());
		
		StringBuilder result = new StringBuilder();
		
		List<CategoryValue> categories = this.categoryService.findAllCategories();
		
		for(CategoryValue category: categories){
			result.append(category.toString()).append("\n");
		}
		
		return result.toString();
	}

}
