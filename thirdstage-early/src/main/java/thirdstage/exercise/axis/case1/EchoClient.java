
package thirdstage.exercise.axis.case1;

import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.namespace.QName;
/**
 *
 * @author 3rdstage
 * @version 1.0, 2006년 7월 19일 (수), 3rdstage
 * @since 2006년 7월 19일 (수)
 */
public class EchoClient {
	
	public static void main(String [] args){
		try{
			String endpoint = "http://ws.apache.org:5049/axis/services/echo";
			
			Service service = new Service();
			Call call = (Call)(service.createCall());
			
			call.setTargetEndpointAddress(new java.net.URL(endpoint));
			call.setOperationName(new QName("http://soapinterop.org", "echoString"));
			
			String ret = (String)(call.invoke(new Object[]{"Hello!"}));
			
			System.out.println("Sent 'Hello!', got '" + ret + "'");
		}
		catch(Exception ex){
			ex.printStackTrace(System.err);
		}
		
	}
}
