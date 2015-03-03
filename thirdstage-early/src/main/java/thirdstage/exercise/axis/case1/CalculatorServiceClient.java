
package thirdstage.exercise.axis.case1;

import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 *
 * @author 3rdstage
 * @version 1.0, 2006-07-21, 3rdstage
 * @since 2006-07-21
 */
public class CalculatorServiceClient {
	
	private String endpoint = null;
	
	/**
	 * Creates a new instance of CalculatorServiceClient
	 */
	public CalculatorServiceClient(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public int add(int i1, int i2) throws Exception{
		
		Service service = null;
		Call call = null;
		Integer ret = null;
				
		try{
			service = new Service();
			call = (Call)service.createCall();
			
			call.setTargetEndpointAddress(new java.net.URL(this.endpoint));
			call.setOperationName(new QName(endpoint, "add"));
			
			ret = (Integer)call.invoke(new Object[]{new Integer(i1), new Integer(i2)});
		}
		catch(Exception ex){
			throw ex;
		}
		
		return ret.intValue();
	}
	
	
}
