/**
 * 
 */
package thirdstage.exercise.xml.schema;

import java.io.PrintStream;
import java.util.List;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author 3rdstage
 *
 */
public class NormalCollectiveErrorHandler extends DefaultHandler {

	private List<SAXParseException> fatalErrors = new java.util.ArrayList<SAXParseException>();
	
	private List<SAXParseException> errors = new java.util.ArrayList<SAXParseException>();
	
	public List<SAXParseException> getFatalErrors(){
		return this.fatalErrors;
	}
	
	public List<SAXParseException> getErrors(){
		return this.errors;
	}
	
	public boolean hasError(){
		return !(this.fatalErrors.isEmpty() && this.errors.isEmpty());
	}
	

	@Override
	public void warning(SAXParseException ex){
		//do nothing
	}
	
	@Override
	public void error(SAXParseException ex){
		this.errors.add(ex);
	}
	
	@Override
	public void fatalError(SAXParseException ex){
		this.fatalErrors.add(ex);
	}
	
	
	public void printErrors(PrintStream ps){
		
		if(ps == null) return;
		
		ps.println(">> Fatal Errors : " + this.fatalErrors.size());
		for(SAXParseException ex: this.fatalErrors){
			this.printSAXParseException(ps, ex);
		}
		ps.println("");
		
		ps.println(">> Errors : " + this.errors.size());
		for(SAXParseException ex: this.errors){
			this.printSAXParseException(ps, ex);
		}
		ps.println("");
		
	}
	
	private void printSAXParseException(PrintStream ps, SAXParseException ex){
		
//		ps.println("Line : " + ex.getLineNumber() 
//				+ ", Column : " + ex.getColumnNumber() 
//				+ ", Public ID : " + ex.getPublicId()
//				+ ", System ID : " + ex.getSystemId()
//				+ ", Message : " + ex.getMessage());
		
		ps.println("Line : " + ex.getLineNumber() 
				+ ", Column : " + ex.getColumnNumber() 
				+ " ; " + ex.getMessage());
	}
	
	
}
