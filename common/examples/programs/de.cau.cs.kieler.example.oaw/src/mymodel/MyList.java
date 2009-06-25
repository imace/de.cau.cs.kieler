/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mymodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mymodel.MyList#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see mymodel.MymodelPackage#getMyList()
 * @model
 * @generated
 */
public interface MyList extends MyData {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link mymodel.MyData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see mymodel.MymodelPackage#getMyList_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<MyData> getItems();

} // MyList
