/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package simple;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simple.SimpleModel#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see simple.SimplePackage#getSimpleModel()
 * @model
 * @generated
 */
public interface SimpleModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link simple.Data}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see simple.SimplePackage#getSimpleModel_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<Data> getItems();

} // SimpleModel
