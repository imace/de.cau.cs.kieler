/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import de.cau.cs.kieler.synccharts.State;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Function Block Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getService <em>Service</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getSyncChart <em>Sync Chart</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getFunctionBlockDiagrams <em>Function Block Diagrams</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getStructuredTexts <em>Structured Texts</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getLadderDiagrams <em>Ladder Diagrams</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getOtherAlgorithms <em>Other Algorithms</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType()
 * @model
 * @generated
 */
public interface BasicFunctionBlockType extends FunctionBlockType {
	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' containment reference.
	 * @see #setService(Service)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType_Service()
	 * @model containment="true"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getService <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' containment reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

	/**
	 * Returns the value of the '<em><b>Sync Chart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync Chart</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Chart</em>' reference.
	 * @see #setSyncChart(State)
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType_SyncChart()
	 * @model
	 * @generated
	 */
	State getSyncChart();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.BasicFunctionBlockType#getSyncChart <em>Sync Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync Chart</em>' reference.
	 * @see #getSyncChart()
	 * @generated
	 */
	void setSyncChart(State value);

	/**
	 * Returns the value of the '<em><b>Internal Vars</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.InternalVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Vars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Vars</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType_InternalVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<InternalVar> getInternalVars();

	/**
	 * Returns the value of the '<em><b>Function Block Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FunctionBlockDiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Block Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Block Diagrams</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType_FunctionBlockDiagrams()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionBlockDiagram> getFunctionBlockDiagrams();

	/**
	 * Returns the value of the '<em><b>Structured Texts</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.StructuredText}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structured Texts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structured Texts</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType_StructuredTexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<StructuredText> getStructuredTexts();

	/**
	 * Returns the value of the '<em><b>Ladder Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.LadderDiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ladder Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ladder Diagrams</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType_LadderDiagrams()
	 * @model containment="true"
	 * @generated
	 */
	EList<LadderDiagram> getLadderDiagrams();

	/**
	 * Returns the value of the '<em><b>Other Algorithms</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.OtherAlgorithm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Algorithms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Algorithms</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBasicFunctionBlockType_OtherAlgorithms()
	 * @model containment="true"
	 * @generated
	 */
	EList<OtherAlgorithm> getOtherAlgorithms();

} // BasicFunctionBlockType
