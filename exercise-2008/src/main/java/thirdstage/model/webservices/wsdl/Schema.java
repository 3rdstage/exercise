/**
 * 
 */
package thirdstage.model.webservices.wsdl;

import java.util.Collection;

/** 
 * @author 3rdstage
 */
public class Schema {

	/**
	 * @uml.property  name="elements"
	 * @uml.associationEnd  multiplicity="(1 -1)" inverse="schema:thirdstage.model.webservices.wsdl.Element"
	 */
	private Collection elements;

	/**
	 * Getter of the property <tt>elements</tt>
	 * @return  Returns the elements.
	 * @uml.property  name="elements"
	 */
	public Collection getElements() {
		return elements;
	}

	/**
	 * Setter of the property <tt>elements</tt>
	 * @param elements  The elements to set.
	 * @uml.property  name="elements"
	 */
	public void setElements(Collection elements) {
		this.elements = elements;
	}

}
