package thirdstage.message.meta;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import java.util.List;

/**
 * @author 3rdstage
 *
 * @model
 */
public interface MessageHeader extends EObject {
	
	/**
	 * @model
	 */
	String getId();
	
	
	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeader#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);


	/**
	 * @model
	 */
	boolean hasSinglePart();
	
	
	/**
	 * @model containment="true"
	 */
	EList<MessageHeaderPart> getParts();

}
