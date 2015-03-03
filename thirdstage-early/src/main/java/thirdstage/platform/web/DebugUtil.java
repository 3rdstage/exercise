/*
 * DebugUtil.java
 *
 * Created on 2005-03-04
 */

package thirdstage.platform.web;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
/**
 *
 * @author 3rdstage
 */
public class DebugUtil {
 
   private boolean isVerboseOn = false;
   
   /** Creates a new instance of DebugUtil */
   public DebugUtil() {
   }
   
   public DebugUtil(boolean isVerboseOn){
      this.isVerboseOn = isVerboseOn;
   }
   
   public boolean isVerboseOn(){
      return this.isVerboseOn;
   }
   
   public void setVerboseOn(boolean isVerboseOn){
      this.isVerboseOn = isVerboseOn;
   }
   
   /**
    * Write information about parameters and attributes of the given request
    * on the given page in HTML format, if verbose is on</p>
    * If verbose off, write nothing 
    */
   public void verboseRequestInfoOnPage(HttpServletRequest req, JspWriter out) throws java.io.IOException{
      
      if(!this.isVerboseOn()) return;
	    
      Enumeration names = null;
      String name = null;
      String[] values = null;
      
      out.println("<h5>Request Parameters</h5>");
      out.println("<table border='0' width='600' cellspacing='1' cellpadding='1'>");
      out.println("<tr>");
      out.println("<th width='30%'>Name</th>");
      out.println("<th>Value</th>");
      out.println("</tr>");
      
      names = req.getParameterNames();
      while(names.hasMoreElements()){
	 name = (String)names.nextElement();
	 out.println("<tr>");
	 out.print("<td valign='top' nowrap>");
	 out.print(name);
	 out.println("</td>");
	 out.println("<td valign='top'>");
	 
	 values = req.getParameterValues(name);
	 for(int i = 0, n = values.length; i < n; i++){
	    out.print((String)values[i]);
	    out.println("<br>");
	 }
	 out.println("</td>");
	 out.println("</tr>");
      }
      
      out.println("</table>");
      out.println("<br><br>");
      
      out.println("<h5>Request Attributes</h5>");
      out.println("<table border='0' width='600' cellspacing='1' cellpadding='1'>");
      out.println("<tr>");
      out.println("<th width='30%'>Name</th>");
      out.println("<th>Value</th>");
      out.println("</tr>");
      
      names = req.getAttributeNames();
      
      while(names.hasMoreElements()){
	 name = (String)names.nextElement();
	 
	 out.println("<tr>");
	 out.print("<td valign='top' nowrap>");
	 out.print(name);
	 out.println("/td>");
	 out.print("<td valign='top'>");
	 out.print(req.getAttribute(name).toString());
	 out.println("</td>");
	 out.println("</tr>");
      }
      out.println("</table>");
      out.println("<br><br>");
   }
 
}
