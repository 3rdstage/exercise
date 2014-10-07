/**
 * 
 */
package thirdstage.exercise.xml.relaxng;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Required;
import org.xml.sax.SAXException;

/**
 * @author 3rdstage
 *
 */
/**
 * @author 3rdstage
 *
 */
public class ComponentMetaValidator {
	
	/**
	 * The fully qualified name for resources corresponding to RELAX NG' compact schema (*.rnc)
	 */
	private String resourceNameOfSchema;
	
	private Schema schema = null;
	
	public ComponentMetaValidator(){
		System.setProperty("javax.xml.validation.SchemaFactory:" + XMLConstants.RELAXNG_NS_URI, "com.thaiopensource.relaxng.jaxp.CompactSyntaxSchemaFactory");
	}
	 
	
	protected String getResourceNameOfSchema(){
		return this.resourceNameOfSchema;
	}
	
	@Required
	public void setResourceNameOfSchema(String name) throws SAXException{
		this.resourceNameOfSchema = name;

		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
		
		// @notes Not working as is expected. 
		//factory.setProperty("javax.xml.validation.SchemaFactory:" + XMLConstants.RELAXNG_NS_URI, "com.thaiopensource.relaxng.jaxp.CompactSyntaxSchemaFactory");
		this.schema = factory.newSchema(ClassLoader.getSystemResource(name));
	}
	
	
	
	/**
	 * Validates the given XML document with current schema and throws
	 * exception if the document dosen't follow the schema or do nothing
	 * if the document follows the schema.
	 * 
	 * @param meta
	 * @throws Exception
	 * @deprecated Jing support only SAX2 parsers and doesn't support DOM. Use
	 */
	public void isValidComponentMeta(Source meta) throws Exception{
		// javax.xml.validation.Validator is not thread-safe
		Validator validator = schema.newValidator();
		Result result = null;
		if(meta instanceof DOMSource) result = new DOMResult();
		validator.validate(meta, result);
	}
	
	/**
	 * Validates the given XML document with current schema and throws
	 * exception if the document dosen't follow the schema or do nothing
	 * if the document follows the schema.
	 * 
	 * @param meta
	 * @throws IllegalStateException when the schema for this validator is not set correctly.
	*/
	public void isValidComponentMeta(SAXSource meta) throws IOException, SAXException{
		if(this.schema == null){
			throw new IllegalStateException("The schema for this validator is not set correctly.");
		}
		Validator validator = schema.newValidator();
		validator.validate(meta);
	}
	

}
