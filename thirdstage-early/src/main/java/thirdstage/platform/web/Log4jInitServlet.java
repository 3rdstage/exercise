/*
 * Log4jInitServlet.java
 *
 * Created on 2005-02-01
 */

package thirdstage.platform.web;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author 3rdstage
 */
public class Log4jInitServlet extends HttpServlet {
	
	public void init(){
		
		String path = null;
		String relativePath = this.getInitParameter("configProps");
		if(relativePath != null) path = this.getServletContext().getRealPath(relativePath);
		if(path != null){
			PropertyConfigurator.configure(path);
			this.getServletContext().log("[Info] log4j type logger is initialized properly.");
		} else{
			this.getServletContext().log("[Error] can't find property file to initialize Log4j");
		}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req, res);
	}
	
}
