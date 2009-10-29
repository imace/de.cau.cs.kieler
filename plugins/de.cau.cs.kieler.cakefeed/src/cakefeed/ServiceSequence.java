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
 * A representation of the model object '<em><b>Service Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.ServiceSequence#getParentLibrary <em>Parent Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getServiceSequence()
 * @model
 * @generated
 */
public interface ServiceSequence extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Library</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.Library#getServiceSequences <em>Service Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Library</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Library</em>' container reference.
	 * @see #setParentLibrary(Library)
	 * @see cakefeed.CakefeedPackage#getServiceSequence_ParentLibrary()
	 * @see cakefeed.Library#getServiceSequences
	 * @model opposite="serviceSequences" required="true" transient="false"
	 * @generated
	 */
	Library getParentLibrary();

	/**
	 * Sets the value of the '{@link cakefeed.ServiceSequence#getParentLibrary <em>Parent Library</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Library</em>' container reference.
	 * @see #getParentLibrary()
	 * @generated
	 */
	void setParentLibrary(Library value);

} // ServiceSequence
