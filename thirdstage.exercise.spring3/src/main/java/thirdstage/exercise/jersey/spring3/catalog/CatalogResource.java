package thirdstage.exercise.jersey.spring3.catalog;

import java.util.List;

import javax.annotation.Nonnull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCatalog(){
		
		return "This is Catalog";
	}
	
	@Path("categories")
	public CategoryResource getCategoryResource(@Context HttpHeaders headers){
		logger.info("executing getCategoryResource on {}/{}", this.toString(), this.hashCode());
		
		CategoryResource rsrc = this.resourceContext.getResource(CategoryResource.class);
		return rsrc;
	}
}
