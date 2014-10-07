/**
 * 
 */
package thirdstage.model.webservices.wsdl;

import java.util.Collection;

/** 
 * @author 3rdstage
 */
public class Message {

	/**
	 * @uml.property  name="parts"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="message:thirdstage.model.webservices.wsdl.Part"
	 */
	private Collection parts;

	/**
	 * Getter of the property <tt>parts</tt>
	 * @return  Returns the parts.
	 * @uml.property  name="parts"
	 */
	public Collection getParts() {
		return parts;
	}

	/**
	 * Setter of the property <tt>parts</tt>
	 * @param parts  The parts to set.
	 * @uml.property  name="parts"
	 */
	public void setParts(Collection parts) {
		this.parts = parts;
	}

}
