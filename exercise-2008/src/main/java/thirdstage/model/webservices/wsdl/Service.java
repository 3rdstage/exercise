/**
 * 
 */
package thirdstage.model.webservices.wsdl;

import java.util.Collection;

/** 
 * @author 3rdstage
 */
public class Service {

	/** 
	 * @uml.property name="ports"
	 * @uml.associationEnd multiplicity="(1 -1)" inverse="service:thirdstage.model.webservices.wsdl.Port"
	 */
	private Collection port;

	/**
	 * Getter of the property <tt>ports</tt>
	 * @return  Returns the port.
	 * @uml.property  name="ports"
	 */
	public Collection getPorts() {
		return port;
	}

	/**
	 * Setter of the property <tt>ports</tt>
	 * @param ports  The port to set.
	 * @uml.property  name="ports"
	 */
	public void setPorts(Collection ports) {
		port = ports;
	}

}
