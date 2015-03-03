/**
 * 
 */
package thirdstage.model.webservices.wsdl;

import java.util.Collection;

/** 
 * @author 3rdstage
 */
public class PortType {

	/**
	 * @uml.property  name="operations"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="portType:thirdstage.model.webservices.wsdl.Operation"
	 */
	private Collection operations;

	/**
	 * Getter of the property <tt>operations</tt>
	 * @return  Returns the operations.
	 * @uml.property  name="operations"
	 */
	public Collection getOperations() {
		return operations;
	}

	/**
	 * Setter of the property <tt>operations</tt>
	 * @param operations  The operations to set.
	 * @uml.property  name="operations"
	 */
	public void setOperations(Collection operations) {
		this.operations = operations;
	}

}
