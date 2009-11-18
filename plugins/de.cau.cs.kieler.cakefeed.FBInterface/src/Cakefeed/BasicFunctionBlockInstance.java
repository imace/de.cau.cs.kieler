/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Function Block Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.BasicFunctionBlockInstance#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getBasicFunctionBlockInstance()
 * @model
 * @generated
 */
public interface BasicFunctionBlockInstance extends FunctionBlockInstance, BasicFunctionBlock {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(BasicFunctionBlock)
	 * @see Cakefeed.CakefeedPackage#getBasicFunctionBlockInstance_Type()
	 * @model required="true"
	 * @generated
	 */
	BasicFunctionBlock getType();

	/**
	 * Sets the value of the '{@link Cakefeed.BasicFunctionBlockInstance#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(BasicFunctionBlock value);

} // BasicFunctionBlockInstance
