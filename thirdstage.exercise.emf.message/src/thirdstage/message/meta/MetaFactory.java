/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package thirdstage.message.meta;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see thirdstage.message.meta.MetaPackage
 * @generated
 */
public interface MetaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetaFactory eINSTANCE = thirdstage.message.meta.impl.MetaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Message Header</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Header</em>'.
	 * @generated
	 */
	MessageHeader createMessageHeader();

	/**
	 * Returns a new object of class '<em>Message Header Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Header Item</em>'.
	 * @generated
	 */
	MessageHeaderItem createMessageHeaderItem();

	/**
	 * Returns a new object of class '<em>Message Header Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Header Part</em>'.
	 * @generated
	 */
	MessageHeaderPart createMessageHeaderPart();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetaPackage getMetaPackage();

} //MetaFactory
