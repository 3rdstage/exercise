/**
 * 
 */
package thirdstage.model.webservices.wsdl;

import java.util.Collection;

/** 
 * @author 3rdstage
 */
public class Types {

	/** 
	 * @uml.property name="schemas"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="types:thirdstage.model.webservices.wsdl.Schema"
	 */
	private Collection schema;

	/**
	 * Getter of the property <tt>schemas</tt>
	 * @return  Returns the schema.
	 * @uml.property  name="schemas"
	 */
	public Collection getSchemas() {
		return schema;
	}

	/**
	 * Setter of the property <tt>schemas</tt>
	 * @param schemas  The schema to set.
	 * @uml.property  name="schemas"
	 */
	public void setSchemas(Collection schemas) {
		schema = schemas;
	}

}
