package thirdstage.exercise.jersey.spring3.order;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/orders")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OrderResources{
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getOrders(){
		
		return "This is Orders";
	}
	
	
}
