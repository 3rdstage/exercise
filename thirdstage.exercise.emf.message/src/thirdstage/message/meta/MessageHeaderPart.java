package thirdstage.message.meta;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import java.util.List;

/**
 * @author 3rdstage
 * 
 * @model
 */
public interface MessageHeaderPart extends EObject {
	
	/**
	 * @model
	 */
	String getName();
	
	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderPart#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * @model
	 */
	int getOrder();
	
	
	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderPart#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

	/**
	 * @model containment="true"
	 */
	EList<MessageHeaderItem> getItems();

}
