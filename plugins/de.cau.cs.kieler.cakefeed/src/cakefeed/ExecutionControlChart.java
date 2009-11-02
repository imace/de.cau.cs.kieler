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
 * A representation of the model object '<em><b>Execution Control Chart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.ExecutionControlChart#getParentBasicFunctionBlock <em>Parent Basic Function Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getExecutionControlChart()
 * @model
 * @generated
 */
public interface ExecutionControlChart extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Basic Function Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Basic Function Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Basic Function Block</em>' reference.
	 * @see #setParentBasicFunctionBlock(BasicFunctionBlock)
	 * @see cakefeed.CakefeedPackage#getExecutionControlChart_ParentBasicFunctionBlock()
	 * @model required="true"
	 * @generated
	 */
	BasicFunctionBlock getParentBasicFunctionBlock();

	/**
	 * Sets the value of the '{@link cakefeed.ExecutionControlChart#getParentBasicFunctionBlock <em>Parent Basic Function Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Basic Function Block</em>' reference.
	 * @see #getParentBasicFunctionBlock()
	 * @generated
	 */
	void setParentBasicFunctionBlock(BasicFunctionBlock value);

} // ExecutionControlChart
