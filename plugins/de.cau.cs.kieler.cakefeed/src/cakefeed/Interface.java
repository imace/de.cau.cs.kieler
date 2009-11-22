/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.Interface#getFunctionBlock <em>Function Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends EObject {
	/**
	 * Returns the value of the '<em><b>Function Block</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.FunctionBlock#getParentInterface <em>Parent Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Block</em>' containment reference.
	 * @see #setFunctionBlock(FunctionBlock)
	 * @see cakefeed.CakefeedPackage#getInterface_FunctionBlock()
	 * @see cakefeed.FunctionBlock#getParentInterface
	 * @model opposite="parentInterface" containment="true" required="true"
	 * @generated
	 */
	FunctionBlock getFunctionBlock();

	/**
	 * Sets the value of the '{@link cakefeed.Interface#getFunctionBlock <em>Function Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Block</em>' containment reference.
	 * @see #getFunctionBlock()
	 * @generated
	 */
	void setFunctionBlock(FunctionBlock value);

} // Interface
