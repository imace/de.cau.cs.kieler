/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;

import de.cau.cs.kieler.synccharts.State;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Function Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.BasicFunctionBlock#getExecutionControlChart <em>Execution Control Chart</em>}</li>
 *   <li>{@link Cakefeed.BasicFunctionBlock#getAlgorithms <em>Algorithms</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getBasicFunctionBlock()
 * @model
 * @generated
 */
public interface BasicFunctionBlock extends FunctionBlock {
	/**
	 * Returns the value of the '<em><b>Execution Control Chart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Control Chart</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Control Chart</em>' reference.
	 * @see #setExecutionControlChart(State)
	 * @see Cakefeed.CakefeedPackage#getBasicFunctionBlock_ExecutionControlChart()
	 * @model
	 * @generated
	 */
	State getExecutionControlChart();

	/**
	 * Sets the value of the '{@link Cakefeed.BasicFunctionBlock#getExecutionControlChart <em>Execution Control Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Control Chart</em>' reference.
	 * @see #getExecutionControlChart()
	 * @generated
	 */
	void setExecutionControlChart(State value);

	/**
	 * Returns the value of the '<em><b>Algorithms</b></em>' reference list.
	 * The list contents are of type {@link Cakefeed.Algorithm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithms</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithms</em>' reference list.
	 * @see Cakefeed.CakefeedPackage#getBasicFunctionBlock_Algorithms()
	 * @model
	 * @generated
	 */
	EList<Algorithm> getAlgorithms();

} // BasicFunctionBlock
