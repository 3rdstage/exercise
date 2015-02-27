package thirdstage.message.meta;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 *
 */
public interface MessageHeaderItem extends EObject {
	
	/**
	 * @model
	 */
	String getName();
	
	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getName <em>Name</em>}' attribute.
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
	String getTitle();
	
	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * @model
	 */
	int getOrder();
	
	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

	/**
	 * @model
	 */
	int getItemLength();

	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getItemLength <em>Item Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Length</em>' attribute.
	 * @see #getItemLength()
	 * @generated
	 */
	void setItemLength(int value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link thirdstage.message.meta.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see thirdstage.message.meta.DataType
	 * @see #setDataType(DataType)
	 * @see thirdstage.message.meta.MetaPackage#getMessageHeaderItem_DataType()
	 * @model
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see thirdstage.message.meta.DataType
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Data Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Length</em>' attribute.
	 * @see #setDataLength(int)
	 * @see thirdstage.message.meta.MetaPackage#getMessageHeaderItem_DataLength()
	 * @model
	 * @generated
	 */
	int getDataLength();

	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getDataLength <em>Data Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Length</em>' attribute.
	 * @see #getDataLength()
	 * @generated
	 */
	void setDataLength(int value);

	/**
	 * Returns the value of the '<em><b>Data Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Scale</em>' attribute.
	 * @see #setDataScale(int)
	 * @see thirdstage.message.meta.MetaPackage#getMessageHeaderItem_DataScale()
	 * @model
	 * @generated
	 */
	int getDataScale();

	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getDataScale <em>Data Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Scale</em>' attribute.
	 * @see #getDataScale()
	 * @generated
	 */
	void setDataScale(int value);

	/**
	 * Returns the value of the '<em><b>Data Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Pattern</em>' attribute.
	 * @see #setDataPattern(String)
	 * @see thirdstage.message.meta.MetaPackage#getMessageHeaderItem_DataPattern()
	 * @model
	 * @generated
	 */
	String getDataPattern();

	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getDataPattern <em>Data Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Pattern</em>' attribute.
	 * @see #getDataPattern()
	 * @generated
	 */
	void setDataPattern(String value);

	/**
	 * Returns the value of the '<em><b>Is Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Mandatory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Mandatory</em>' attribute.
	 * @see #setIsMandatory(boolean)
	 * @see thirdstage.message.meta.MetaPackage#getMessageHeaderItem_IsMandatory()
	 * @model
	 * @generated
	 */
	boolean isIsMandatory();

	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#isIsMandatory <em>Is Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Mandatory</em>' attribute.
	 * @see #isIsMandatory()
	 * @generated
	 */
	void setIsMandatory(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see thirdstage.message.meta.MetaPackage#getMessageHeaderItem_DefaultValue()
	 * @model
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link thirdstage.message.meta.MessageHeaderItem#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);
	
	

}
