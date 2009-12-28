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
 * A representation of the model object '<em><b>BFB Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBType#getService <em>Service</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBType#getSyncChart <em>Sync Chart</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBType#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBType#getFBDs <em>FB Ds</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBType#getSTs <em>STs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBType#getLDs <em>LDs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.BFBType#getOtherAlgorithms <em>Other Algorithms</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType()
 * @model
 * @generated
 */
public interface BFBType extends FBType {
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType_Service()
	 * @model containment="true"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.BFBType#getService <em>Service</em>}' containment reference.
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType_SyncChart()
	 * @model
	 * @generated
	 */
	State getSyncChart();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.cakefeed.BFBType#getSyncChart <em>Sync Chart</em>}' reference.
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
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType_InternalVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<InternalVar> getInternalVars();

	/**
	 * Returns the value of the '<em><b>FB Ds</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.FBD}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FB Ds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FB Ds</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType_FBDs()
	 * @model containment="true"
	 * @generated
	 */
	EList<FBD> getFBDs();

	/**
	 * Returns the value of the '<em><b>STs</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.ST}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STs</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType_STs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ST> getSTs();

	/**
	 * Returns the value of the '<em><b>LDs</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.LD}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LDs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LDs</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType_LDs()
	 * @model containment="true"
	 * @generated
	 */
	EList<LD> getLDs();

	/**
	 * Returns the value of the '<em><b>Other Algorithms</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.Other}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Algorithms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Algorithms</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getBFBType_OtherAlgorithms()
	 * @model containment="true"
	 * @generated
	 */
	EList<Other> getOtherAlgorithms();

} // BFBType
