/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package thirdstage.message.meta.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import thirdstage.message.meta.DataType;
import thirdstage.message.meta.MessageHeaderItem;
import thirdstage.message.meta.MetaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Header Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getItemLength <em>Item Length</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getDataLength <em>Data Length</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getDataScale <em>Data Scale</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getDataPattern <em>Data Pattern</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#isIsMandatory <em>Is Mandatory</em>}</li>
 *   <li>{@link thirdstage.message.meta.impl.MessageHeaderItemImpl#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageHeaderItemImpl extends EObjectImpl implements MessageHeaderItem {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getItemLength() <em>Item Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemLength()
	 * @generated
	 * @ordered
	 */
	protected static final int ITEM_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getItemLength() <em>Item Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemLength()
	 * @generated
	 * @ordered
	 */
	protected int itemLength = ITEM_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected static final DataType DATA_TYPE_EDEFAULT = DataType.BOOLEAN;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType = DATA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataLength() <em>Data Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataLength()
	 * @generated
	 * @ordered
	 */
	protected static final int DATA_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDataLength() <em>Data Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataLength()
	 * @generated
	 * @ordered
	 */
	protected int dataLength = DATA_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataScale() <em>Data Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataScale()
	 * @generated
	 * @ordered
	 */
	protected static final int DATA_SCALE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDataScale() <em>Data Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataScale()
	 * @generated
	 * @ordered
	 */
	protected int dataScale = DATA_SCALE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataPattern() <em>Data Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataPattern() <em>Data Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataPattern()
	 * @generated
	 * @ordered
	 */
	protected String dataPattern = DATA_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsMandatory() <em>Is Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMandatory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MANDATORY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMandatory() <em>Is Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMandatory()
	 * @generated
	 * @ordered
	 */
	protected boolean isMandatory = IS_MANDATORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageHeaderItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaPackage.Literals.MESSAGE_HEADER_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getItemLength() {
		return itemLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemLength(int newItemLength) {
		int oldItemLength = itemLength;
		itemLength = newItemLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__ITEM_LENGTH, oldItemLength, itemLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataType newDataType) {
		DataType oldDataType = dataType;
		dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__DATA_TYPE, oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDataLength() {
		return dataLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataLength(int newDataLength) {
		int oldDataLength = dataLength;
		dataLength = newDataLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__DATA_LENGTH, oldDataLength, dataLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDataScale() {
		return dataScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataScale(int newDataScale) {
		int oldDataScale = dataScale;
		dataScale = newDataScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__DATA_SCALE, oldDataScale, dataScale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataPattern() {
		return dataPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataPattern(String newDataPattern) {
		String oldDataPattern = dataPattern;
		dataPattern = newDataPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__DATA_PATTERN, oldDataPattern, dataPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMandatory() {
		return isMandatory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMandatory(boolean newIsMandatory) {
		boolean oldIsMandatory = isMandatory;
		isMandatory = newIsMandatory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__IS_MANDATORY, oldIsMandatory, isMandatory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaPackage.MESSAGE_HEADER_ITEM__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaPackage.MESSAGE_HEADER_ITEM__NAME:
				return getName();
			case MetaPackage.MESSAGE_HEADER_ITEM__TITLE:
				return getTitle();
			case MetaPackage.MESSAGE_HEADER_ITEM__ORDER:
				return getOrder();
			case MetaPackage.MESSAGE_HEADER_ITEM__ITEM_LENGTH:
				return getItemLength();
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_TYPE:
				return getDataType();
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_LENGTH:
				return getDataLength();
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_SCALE:
				return getDataScale();
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_PATTERN:
				return getDataPattern();
			case MetaPackage.MESSAGE_HEADER_ITEM__IS_MANDATORY:
				return isIsMandatory();
			case MetaPackage.MESSAGE_HEADER_ITEM__DEFAULT_VALUE:
				return getDefaultValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetaPackage.MESSAGE_HEADER_ITEM__NAME:
				setName((String)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__TITLE:
				setTitle((String)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__ORDER:
				setOrder((Integer)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__ITEM_LENGTH:
				setItemLength((Integer)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_TYPE:
				setDataType((DataType)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_LENGTH:
				setDataLength((Integer)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_SCALE:
				setDataScale((Integer)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_PATTERN:
				setDataPattern((String)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__IS_MANDATORY:
				setIsMandatory((Boolean)newValue);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetaPackage.MESSAGE_HEADER_ITEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__ITEM_LENGTH:
				setItemLength(ITEM_LENGTH_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_TYPE:
				setDataType(DATA_TYPE_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_LENGTH:
				setDataLength(DATA_LENGTH_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_SCALE:
				setDataScale(DATA_SCALE_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_PATTERN:
				setDataPattern(DATA_PATTERN_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__IS_MANDATORY:
				setIsMandatory(IS_MANDATORY_EDEFAULT);
				return;
			case MetaPackage.MESSAGE_HEADER_ITEM__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetaPackage.MESSAGE_HEADER_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetaPackage.MESSAGE_HEADER_ITEM__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case MetaPackage.MESSAGE_HEADER_ITEM__ORDER:
				return order != ORDER_EDEFAULT;
			case MetaPackage.MESSAGE_HEADER_ITEM__ITEM_LENGTH:
				return itemLength != ITEM_LENGTH_EDEFAULT;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_TYPE:
				return dataType != DATA_TYPE_EDEFAULT;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_LENGTH:
				return dataLength != DATA_LENGTH_EDEFAULT;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_SCALE:
				return dataScale != DATA_SCALE_EDEFAULT;
			case MetaPackage.MESSAGE_HEADER_ITEM__DATA_PATTERN:
				return DATA_PATTERN_EDEFAULT == null ? dataPattern != null : !DATA_PATTERN_EDEFAULT.equals(dataPattern);
			case MetaPackage.MESSAGE_HEADER_ITEM__IS_MANDATORY:
				return isMandatory != IS_MANDATORY_EDEFAULT;
			case MetaPackage.MESSAGE_HEADER_ITEM__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", title: ");
		result.append(title);
		result.append(", order: ");
		result.append(order);
		result.append(", itemLength: ");
		result.append(itemLength);
		result.append(", dataType: ");
		result.append(dataType);
		result.append(", dataLength: ");
		result.append(dataLength);
		result.append(", dataScale: ");
		result.append(dataScale);
		result.append(", dataPattern: ");
		result.append(dataPattern);
		result.append(", isMandatory: ");
		result.append(isMandatory);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(')');
		return result.toString();
	}

} //MessageHeaderItemImpl
