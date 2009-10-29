/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Function Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.BasicFunctionBlock#getExecutionControlChart <em>Execution Control Chart</em>}</li>
 *   <li>{@link cakefeed.BasicFunctionBlock#getAlgorithms <em>Algorithms</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getBasicFunctionBlock()
 * @model
 * @generated
 */
public interface BasicFunctionBlock extends FunctionBlock {
	/**
	 * Returns the value of the '<em><b>Execution Control Chart</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.ExecutionControlChart#getParentBasicFunctionBlock <em>Parent Basic Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Control Chart</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Control Chart</em>' containment reference.
	 * @see #setExecutionControlChart(ExecutionControlChart)
	 * @see cakefeed.CakefeedPackage#getBasicFunctionBlock_ExecutionControlChart()
	 * @see cakefeed.ExecutionControlChart#getParentBasicFunctionBlock
	 * @model opposite="parentBasicFunctionBlock" containment="true"
	 * @generated
	 */
	ExecutionControlChart getExecutionControlChart();

	/**
	 * Sets the value of the '{@link cakefeed.BasicFunctionBlock#getExecutionControlChart <em>Execution Control Chart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Control Chart</em>' containment reference.
	 * @see #getExecutionControlChart()
	 * @generated
	 */
	void setExecutionControlChart(ExecutionControlChart value);

	/**
	 * Returns the value of the '<em><b>Algorithms</b></em>' reference list.
	 * The list contents are of type {@link cakefeed.Algorithm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithms</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithms</em>' reference list.
	 * @see cakefeed.CakefeedPackage#getBasicFunctionBlock_Algorithms()
	 * @model
	 * @generated
	 */
	EList<Algorithm> getAlgorithms();

} // BasicFunctionBlock
