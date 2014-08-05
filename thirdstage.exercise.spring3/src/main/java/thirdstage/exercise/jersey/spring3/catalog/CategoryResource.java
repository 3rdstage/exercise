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
import org.springframework.stereotype.Controller;

import com.sun.jersey.api.core.ResourceContext;

@Controller("categoryResource")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryResource{
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Context
	protected ResourceContext resourceContext;
	
	@Resource(name="categoryService")
	protected CategoryService categoryService;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<CategoryValue> getAllCategories(){
		logger.info("executing getAllCategories on {}/{}", this.toString(), this.hashCode());

		return this.categoryService.findAllCategories();
	}
	
	

}
