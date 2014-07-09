package thirdstage.exercise.jersey.spring3;

import java.util.List;

import javax.annotation.Nonnull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Required;

import com.sun.jersey.spi.resource.Singleton;

/**
 * @author 3rdstage
 *
 */
@Singleton
@Path("/categories")
public class CatalogResource {
	
	private CatalogService catalogService;
	
	protected CatalogService getCatalogService(){
		return this.catalogService;
	}
	
	@Required
	public void setCatalogService(@Nonnull CatalogService service){
		this.catalogService = service;
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllCategories(){
		StringBuilder result = new StringBuilder();
		
		List<CategoryValue> categories = this.getCatalogService().findAllCategories();
		
		for(CategoryValue category : categories){
			result.append(category.toString()).append("\n");
		}
		
		return result.toString();
	}
	
	

}
