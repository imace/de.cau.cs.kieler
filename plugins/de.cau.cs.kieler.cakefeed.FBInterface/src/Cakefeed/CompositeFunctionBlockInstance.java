/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Function Block Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.CompositeFunctionBlockInstance#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getCompositeFunctionBlockInstance()
 * @model
 * @generated
 */
public interface CompositeFunctionBlockInstance extends FunctionBlockInstance, CompositeFunctionBlock {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(CompositeFunctionBlock)
	 * @see Cakefeed.CakefeedPackage#getCompositeFunctionBlockInstance_Type()
	 * @model required="true"
	 * @generated
	 */
	CompositeFunctionBlock getType();

	/**
	 * Sets the value of the '{@link Cakefeed.CompositeFunctionBlockInstance#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(CompositeFunctionBlock value);

} // CompositeFunctionBlockInstance
