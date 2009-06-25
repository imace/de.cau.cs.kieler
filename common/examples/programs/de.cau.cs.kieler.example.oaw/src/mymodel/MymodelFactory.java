/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see mymodel.MymodelPackage
 * @generated
 */
public interface MymodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MymodelFactory eINSTANCE = mymodel.impl.MymodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>My String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My String</em>'.
	 * @generated
	 */
	MyString createMyString();

	/**
	 * Returns a new object of class '<em>My Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My Int</em>'.
	 * @generated
	 */
	MyInt createMyInt();

	/**
	 * Returns a new object of class '<em>My Const</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My Const</em>'.
	 * @generated
	 */
	MyConst createMyConst();

	/**
	 * Returns a new object of class '<em>My List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My List</em>'.
	 * @generated
	 */
	MyList createMyList();

	/**
	 * Returns a new object of class '<em>My Data Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>My Data Model</em>'.
	 * @generated
	 */
	MyDataModel createMyDataModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MymodelPackage getMymodelPackage();

} //MymodelFactory
