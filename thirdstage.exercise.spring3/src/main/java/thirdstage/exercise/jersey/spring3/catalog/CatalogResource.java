package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import javax.validation.groups.Default;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.sun.jersey.api.core.ResourceContext;
import com.sun.jersey.spi.resource.Singleton;

/**
 * @author 3rdstage
 *
 */
@Path("/catalog")
@Controller("catalogResource")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CatalogResource {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Context
	private ResourceContext resourceContext;
	
	@Resource(name="categoryService")
	CategoryService categoryService;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCatalog(){
		
		return "This is Catalog";
	}
	
	@GET
	@Path("categories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoryValue> getCategories(@Context HttpHeaders headers){
		
		return this.categoryService.findAllCategories();
	}
	
	@GET
	@Path("categories/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryValue getCategory(@Context HttpHeaders headers,
			@PathParam("id") String id){

		return null;
	}
	
	@GET
	@Path("categories-by-parent/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoryValue> getCategoriesByParent(@Context HttpHeaders headers,
			@PathParam("parentId") String parentId){
		return null;
	}
	
	@POST
	@Path("categories")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryValue postCategory(@Context HttpHeaders headers,
			@QueryParam("id") @Nonnull String id,
			@QueryParam("name") @Nonnull String name,
			@QueryParam("parentId") String parentId,
			@QueryParam("desc") String desc){
		return null;
	}
	
	@DELETE
	@Path("categories/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryValue deleteCategory(@Context HttpHeaders headers,
			@PathParam("id") String id,
			@QueryParam("cascaded") @DefaultValue("false") boolean cascaded){
		return null;
	}
	
	@GET
	@Path("categories/{id}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductValue> getProductsOfCategory(@Context HttpHeaders headers,
			@PathParam("id") String categoryId){
		return null;
	}
	
	
	
	
	
}
