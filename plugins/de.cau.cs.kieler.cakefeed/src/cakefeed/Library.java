/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

import de.cau.cs.kieler.synccharts.State;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.Library#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link cakefeed.Library#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link cakefeed.Library#getApplications <em>Applications</em>}</li>
 *   <li>{@link cakefeed.Library#getCompositeNetworks <em>Composite Networks</em>}</li>
 *   <li>{@link cakefeed.Library#getSyncCharts <em>Sync Charts</em>}</li>
 *   <li>{@link cakefeed.Library#getServiceSequences <em>Service Sequences</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends EObject {
	/**
	 * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_Interfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Interface> getInterfaces();

	/**
	 * Returns the value of the '<em><b>Algorithms</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.Algorithm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithms</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_Algorithms()
	 * @model containment="true"
	 * @generated
	 */
	EList<Algorithm> getAlgorithms();

	/**
	 * Returns the value of the '<em><b>Applications</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.Application}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applications</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_Applications()
	 * @model containment="true"
	 * @generated
	 */
	EList<Application> getApplications();

	/**
	 * Returns the value of the '<em><b>Composite Networks</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.CompositeNetwork}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Networks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Networks</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_CompositeNetworks()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompositeNetwork> getCompositeNetworks();

	/**
	 * Returns the value of the '<em><b>Sync Charts</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.synccharts.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync Charts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Charts</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_SyncCharts()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getSyncCharts();

	/**
	 * Returns the value of the '<em><b>Service Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.ServiceSequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Sequences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Sequences</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_ServiceSequences()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServiceSequence> getServiceSequences();

} // Library
