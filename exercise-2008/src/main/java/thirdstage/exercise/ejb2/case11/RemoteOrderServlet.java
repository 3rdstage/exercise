/**
 * 
 */
package thirdstage.exercise.ejb2.case11;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thirdstage.exercise.ejb2.case11.order.OrderRemoteService;
import thirdstage.exercise.ejb2.case11.order.OrderRemoteServiceHome;

/**
 * @author 3rdstage
 *
 */
public class RemoteOrderServlet extends HttpServlet{
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException{
		
		PrintWriter out = resp.getWriter();

		OrderValue order = new OrderValue();
		try{
			Context jndiCtx = new InitialContext();
			
			Object obj = jndiCtx.lookup("ejb/simple/remote/OrderService");
			OrderRemoteServiceHome home = (OrderRemoteServiceHome)PortableRemoteObject.narrow(obj, OrderRemoteServiceHome.class);
						
			OrderRemoteService orderService = home.create();
			order.setCustomerId("CST00031");
			order.setProductId("PRD23074");
			order.setQty(3);
	
			order = orderService.makeOrder(order);
		}catch(Exception ex){
			throw new ServletException(ex);
		}
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.println("<p>The order is registered like followings.</p>");
		out.println("<pre>");
		out.println(order.toString());
		
		out.println("</pre>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
