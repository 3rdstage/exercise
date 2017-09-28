
package thirdstage.exercise.axis.case1;

import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-07-22, 3rdstage
 * @since 2006-07-22
 */
public class ComplexAddServiceClient {
	
	private String endpoint = null;
	
	/**
	 * Creates a new instance of ComplexAddServiceClient
	 */
	public ComplexAddServiceClient(String endpoint){
		this.endpoint = endpoint;
	}
	
	public Complex add(Complex c1, Complex c2) throws Exception{
		Service service = null;
		Call call = null;
		Complex c = null;
		
		try{
			service = new Service();
			call = (Call)(service.createCall());
			
			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName(new QName(endpoint, "addComplex"));
			
			c = (Complex)(call.invoke(new Object[]{c1, c2}));
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
		
		return c;
	}
	
	
}
