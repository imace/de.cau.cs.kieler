/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;

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
 *   <li>{@link cakefeed.Library#getFunctionBlocks <em>Function Blocks</em>}</li>
 *   <li>{@link cakefeed.Library#getAlgorithms <em>Algorithms</em>}</li>
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
	 * Returns the value of the '<em><b>Function Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.FunctionBlock}.
	 * It is bidirectional and its opposite is '{@link cakefeed.FunctionBlock#getParentLibrary <em>Parent Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Blocks</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_FunctionBlocks()
	 * @see cakefeed.FunctionBlock#getParentLibrary
	 * @model opposite="parentLibrary" containment="true"
	 * @generated
	 */
	EList<FunctionBlock> getFunctionBlocks();

	/**
	 * Returns the value of the '<em><b>Algorithms</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.Algorithm}.
	 * It is bidirectional and its opposite is '{@link cakefeed.Algorithm#getParentLibrary <em>Parent Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithms</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_Algorithms()
	 * @see cakefeed.Algorithm#getParentLibrary
	 * @model opposite="parentLibrary" containment="true"
	 * @generated
	 */
	EList<Algorithm> getAlgorithms();

	/**
	 * Returns the value of the '<em><b>Service Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.ServiceSequence}.
	 * It is bidirectional and its opposite is '{@link cakefeed.ServiceSequence#getParentLibrary <em>Parent Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Sequences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Sequences</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getLibrary_ServiceSequences()
	 * @see cakefeed.ServiceSequence#getParentLibrary
	 * @model opposite="parentLibrary" containment="true"
	 * @generated
	 */
	EList<ServiceSequence> getServiceSequences();

} // Library
