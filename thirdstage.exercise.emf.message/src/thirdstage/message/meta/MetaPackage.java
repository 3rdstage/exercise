/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package thirdstage.message.meta;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see thirdstage.message.meta.MetaFactory
 * @model kind="package"
 * @generated
 */
public interface MetaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "meta";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///thirdstage/message/meta.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "thirdstage.message.meta";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetaPackage eINSTANCE = thirdstage.message.meta.impl.MetaPackageImpl.init();

	/**
	 * The meta object id for the '{@link thirdstage.message.meta.impl.MessageHeaderImpl <em>Message Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see thirdstage.message.meta.impl.MessageHeaderImpl
	 * @see thirdstage.message.meta.impl.MetaPackageImpl#getMessageHeader()
	 * @generated
	 */
	int MESSAGE_HEADER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER__ID = 0;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER__PARTS = 1;

	/**
	 * The number of structural features of the '<em>Message Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link thirdstage.message.meta.impl.MessageHeaderItemImpl <em>Message Header Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see thirdstage.message.meta.impl.MessageHeaderItemImpl
	 * @see thirdstage.message.meta.impl.MetaPackageImpl#getMessageHeaderItem()
	 * @generated
	 */
	int MESSAGE_HEADER_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__ORDER = 2;

	/**
	 * The feature id for the '<em><b>Item Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__ITEM_LENGTH = 3;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__DATA_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Data Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__DATA_LENGTH = 5;

	/**
	 * The feature id for the '<em><b>Data Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__DATA_SCALE = 6;

	/**
	 * The feature id for the '<em><b>Data Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__DATA_PATTERN = 7;

	/**
	 * The feature id for the '<em><b>Is Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__IS_MANDATORY = 8;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM__DEFAULT_VALUE = 9;

	/**
	 * The number of structural features of the '<em>Message Header Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_ITEM_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link thirdstage.message.meta.impl.MessageHeaderPartImpl <em>Message Header Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see thirdstage.message.meta.impl.MessageHeaderPartImpl
	 * @see thirdstage.message.meta.impl.MetaPackageImpl#getMessageHeaderPart()
	 * @generated
	 */
	int MESSAGE_HEADER_PART = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_PART__NAME = 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_PART__ORDER = 1;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_PART__ITEMS = 2;

	/**
	 * The number of structural features of the '<em>Message Header Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_HEADER_PART_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link thirdstage.message.meta.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see thirdstage.message.meta.DataType
	 * @see thirdstage.message.meta.impl.MetaPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 3;


	/**
	 * Returns the meta object for class '{@link thirdstage.message.meta.MessageHeader <em>Message Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Header</em>'.
	 * @see thirdstage.message.meta.MessageHeader
	 * @generated
	 */
	EClass getMessageHeader();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeader#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see thirdstage.message.meta.MessageHeader#getId()
	 * @see #getMessageHeader()
	 * @generated
	 */
	EAttribute getMessageHeader_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link thirdstage.message.meta.MessageHeader#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see thirdstage.message.meta.MessageHeader#getParts()
	 * @see #getMessageHeader()
	 * @generated
	 */
	EReference getMessageHeader_Parts();

	/**
	 * Returns the meta object for class '{@link thirdstage.message.meta.MessageHeaderItem <em>Message Header Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Header Item</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem
	 * @generated
	 */
	EClass getMessageHeaderItem();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getName()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_Name();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getTitle()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_Title();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getOrder()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_Order();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getItemLength <em>Item Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Length</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getItemLength()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_ItemLength();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getDataType()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_DataType();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getDataLength <em>Data Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Length</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getDataLength()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_DataLength();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getDataScale <em>Data Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Scale</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getDataScale()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_DataScale();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getDataPattern <em>Data Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Pattern</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getDataPattern()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_DataPattern();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#isIsMandatory <em>Is Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Mandatory</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#isIsMandatory()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_IsMandatory();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderItem#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see thirdstage.message.meta.MessageHeaderItem#getDefaultValue()
	 * @see #getMessageHeaderItem()
	 * @generated
	 */
	EAttribute getMessageHeaderItem_DefaultValue();

	/**
	 * Returns the meta object for class '{@link thirdstage.message.meta.MessageHeaderPart <em>Message Header Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Header Part</em>'.
	 * @see thirdstage.message.meta.MessageHeaderPart
	 * @generated
	 */
	EClass getMessageHeaderPart();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see thirdstage.message.meta.MessageHeaderPart#getName()
	 * @see #getMessageHeaderPart()
	 * @generated
	 */
	EAttribute getMessageHeaderPart_Name();

	/**
	 * Returns the meta object for the attribute '{@link thirdstage.message.meta.MessageHeaderPart#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see thirdstage.message.meta.MessageHeaderPart#getOrder()
	 * @see #getMessageHeaderPart()
	 * @generated
	 */
	EAttribute getMessageHeaderPart_Order();

	/**
	 * Returns the meta object for the containment reference list '{@link thirdstage.message.meta.MessageHeaderPart#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see thirdstage.message.meta.MessageHeaderPart#getItems()
	 * @see #getMessageHeaderPart()
	 * @generated
	 */
	EReference getMessageHeaderPart_Items();

	/**
	 * Returns the meta object for enum '{@link thirdstage.message.meta.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see thirdstage.message.meta.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetaFactory getMetaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link thirdstage.message.meta.impl.MessageHeaderImpl <em>Message Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see thirdstage.message.meta.impl.MessageHeaderImpl
		 * @see thirdstage.message.meta.impl.MetaPackageImpl#getMessageHeader()
		 * @generated
		 */
		EClass MESSAGE_HEADER = eINSTANCE.getMessageHeader();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER__ID = eINSTANCE.getMessageHeader_Id();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_HEADER__PARTS = eINSTANCE.getMessageHeader_Parts();

		/**
		 * The meta object literal for the '{@link thirdstage.message.meta.impl.MessageHeaderItemImpl <em>Message Header Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see thirdstage.message.meta.impl.MessageHeaderItemImpl
		 * @see thirdstage.message.meta.impl.MetaPackageImpl#getMessageHeaderItem()
		 * @generated
		 */
		EClass MESSAGE_HEADER_ITEM = eINSTANCE.getMessageHeaderItem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__NAME = eINSTANCE.getMessageHeaderItem_Name();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__TITLE = eINSTANCE.getMessageHeaderItem_Title();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__ORDER = eINSTANCE.getMessageHeaderItem_Order();

		/**
		 * The meta object literal for the '<em><b>Item Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__ITEM_LENGTH = eINSTANCE.getMessageHeaderItem_ItemLength();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__DATA_TYPE = eINSTANCE.getMessageHeaderItem_DataType();

		/**
		 * The meta object literal for the '<em><b>Data Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__DATA_LENGTH = eINSTANCE.getMessageHeaderItem_DataLength();

		/**
		 * The meta object literal for the '<em><b>Data Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__DATA_SCALE = eINSTANCE.getMessageHeaderItem_DataScale();

		/**
		 * The meta object literal for the '<em><b>Data Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__DATA_PATTERN = eINSTANCE.getMessageHeaderItem_DataPattern();

		/**
		 * The meta object literal for the '<em><b>Is Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__IS_MANDATORY = eINSTANCE.getMessageHeaderItem_IsMandatory();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_ITEM__DEFAULT_VALUE = eINSTANCE.getMessageHeaderItem_DefaultValue();

		/**
		 * The meta object literal for the '{@link thirdstage.message.meta.impl.MessageHeaderPartImpl <em>Message Header Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see thirdstage.message.meta.impl.MessageHeaderPartImpl
		 * @see thirdstage.message.meta.impl.MetaPackageImpl#getMessageHeaderPart()
		 * @generated
		 */
		EClass MESSAGE_HEADER_PART = eINSTANCE.getMessageHeaderPart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_PART__NAME = eINSTANCE.getMessageHeaderPart_Name();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_HEADER_PART__ORDER = eINSTANCE.getMessageHeaderPart_Order();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_HEADER_PART__ITEMS = eINSTANCE.getMessageHeaderPart_Items();

		/**
		 * The meta object literal for the '{@link thirdstage.message.meta.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see thirdstage.message.meta.DataType
		 * @see thirdstage.message.meta.impl.MetaPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

	}

} //MetaPackage
