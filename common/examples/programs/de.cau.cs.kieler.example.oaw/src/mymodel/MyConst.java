/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Const</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mymodel.MyConst#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see mymodel.MymodelPackage#getMyConst()
 * @model
 * @generated
 */
public interface MyConst extends MyData {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link mymodel.myConstValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see mymodel.myConstValue
	 * @see #setValue(myConstValue)
	 * @see mymodel.MymodelPackage#getMyConst_Value()
	 * @model
	 * @generated
	 */
	myConstValue getValue();

	/**
	 * Sets the value of the '{@link mymodel.MyConst#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see mymodel.myConstValue
	 * @see #getValue()
	 * @generated
	 */
	void setValue(myConstValue value);

} // MyConst
