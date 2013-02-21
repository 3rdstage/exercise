/**
 * 
 */
package thirdstage.exercise.restful.case1;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author 3rdstage
 *
 */
@Path("/customers")
public class CustomerRestfulService {
	
	private Map<Integer, Customer> customerStorage = new ConcurrentHashMap<Integer, Customer>();
	
	private AtomicInteger idCounter = new AtomicInteger();
	
	
	@POST
	@Consumes("application/xml")
	public Response addCustomer(InputStream is){
		Customer cust = this.parseCustomer(is);
		cust.setId(this.idCounter.incrementAndGet());
		this.customerStorage.put(cust.getId(), cust);
		
		System.out.println("Created customer " + cust.getId());
		return Response.created(URI.create("/customers/" + cust.getId())).build();
		
		
	}
	
	protected Customer parseCustomer(InputStream is){
		
		
		return null;
	}
	
	
	

}
