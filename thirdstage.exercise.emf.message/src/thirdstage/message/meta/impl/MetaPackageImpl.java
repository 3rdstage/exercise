/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package thirdstage.message.meta.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import thirdstage.message.meta.DataType;
import thirdstage.message.meta.MessageHeader;
import thirdstage.message.meta.MessageHeaderItem;
import thirdstage.message.meta.MessageHeaderPart;
import thirdstage.message.meta.MetaFactory;
import thirdstage.message.meta.MetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetaPackageImpl extends EPackageImpl implements MetaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageHeaderItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageHeaderPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see thirdstage.message.meta.MetaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetaPackageImpl() {
		super(eNS_URI, MetaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MetaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetaPackage init() {
		if (isInited) return (MetaPackage)EPackage.Registry.INSTANCE.getEPackage(MetaPackage.eNS_URI);

		// Obtain or create and register package
		MetaPackageImpl theMetaPackage = (MetaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetaPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMetaPackage.createPackageContents();

		// Initialize created meta-data
		theMetaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetaPackage.eNS_URI, theMetaPackage);
		return theMetaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageHeader() {
		return messageHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeader_Id() {
		return (EAttribute)messageHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageHeader_Parts() {
		return (EReference)messageHeaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageHeaderItem() {
		return messageHeaderItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_Name() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_Title() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_Order() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_ItemLength() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_DataType() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_DataLength() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_DataScale() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_DataPattern() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_IsMandatory() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderItem_DefaultValue() {
		return (EAttribute)messageHeaderItemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageHeaderPart() {
		return messageHeaderPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderPart_Name() {
		return (EAttribute)messageHeaderPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageHeaderPart_Order() {
		return (EAttribute)messageHeaderPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageHeaderPart_Items() {
		return (EReference)messageHeaderPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataType() {
		return dataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaFactory getMetaFactory() {
		return (MetaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		messageHeaderEClass = createEClass(MESSAGE_HEADER);
		createEAttribute(messageHeaderEClass, MESSAGE_HEADER__ID);
		createEReference(messageHeaderEClass, MESSAGE_HEADER__PARTS);

		messageHeaderItemEClass = createEClass(MESSAGE_HEADER_ITEM);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__NAME);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__TITLE);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__ORDER);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__ITEM_LENGTH);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__DATA_TYPE);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__DATA_LENGTH);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__DATA_SCALE);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__DATA_PATTERN);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__IS_MANDATORY);
		createEAttribute(messageHeaderItemEClass, MESSAGE_HEADER_ITEM__DEFAULT_VALUE);

		messageHeaderPartEClass = createEClass(MESSAGE_HEADER_PART);
		createEAttribute(messageHeaderPartEClass, MESSAGE_HEADER_PART__NAME);
		createEAttribute(messageHeaderPartEClass, MESSAGE_HEADER_PART__ORDER);
		createEReference(messageHeaderPartEClass, MESSAGE_HEADER_PART__ITEMS);

		// Create enums
		dataTypeEEnum = createEEnum(DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(messageHeaderEClass, MessageHeader.class, "MessageHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageHeader_Id(), ecorePackage.getEString(), "id", null, 0, 1, MessageHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageHeader_Parts(), this.getMessageHeaderPart(), null, "parts", null, 0, -1, MessageHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(messageHeaderEClass, ecorePackage.getEBoolean(), "hasSinglePart", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(messageHeaderItemEClass, MessageHeaderItem.class, "MessageHeaderItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageHeaderItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_Title(), ecorePackage.getEString(), "title", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_Order(), ecorePackage.getEInt(), "order", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_ItemLength(), ecorePackage.getEInt(), "itemLength", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_DataType(), this.getDataType(), "dataType", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_DataLength(), ecorePackage.getEInt(), "dataLength", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_DataScale(), ecorePackage.getEInt(), "dataScale", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_DataPattern(), ecorePackage.getEString(), "dataPattern", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_IsMandatory(), ecorePackage.getEBoolean(), "isMandatory", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderItem_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, MessageHeaderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageHeaderPartEClass, MessageHeaderPart.class, "MessageHeaderPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageHeaderPart_Name(), ecorePackage.getEString(), "name", null, 0, 1, MessageHeaderPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageHeaderPart_Order(), ecorePackage.getEInt(), "order", null, 0, 1, MessageHeaderPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageHeaderPart_Items(), this.getMessageHeaderItem(), null, "items", null, 0, -1, MessageHeaderPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(dataTypeEEnum, DataType.class, "DataType");
		addEEnumLiteral(dataTypeEEnum, DataType.BOOLEAN);
		addEEnumLiteral(dataTypeEEnum, DataType.INT32);
		addEEnumLiteral(dataTypeEEnum, DataType.INT64);
		addEEnumLiteral(dataTypeEEnum, DataType.STRING);

		// Create resource
		createResource(eNS_URI);
	}

} //MetaPackageImpl
