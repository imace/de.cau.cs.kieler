/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.ServiceSequence#getServiceTransactions <em>Service Transactions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getServiceSequence()
 * @model
 * @generated
 */
public interface ServiceSequence extends NamedAndCommented {
	/**
	 * Returns the value of the '<em><b>Service Transactions</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.cakefeed.ServiceTransaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Transactions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Transactions</em>' containment reference list.
	 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage#getServiceSequence_ServiceTransactions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ServiceTransaction> getServiceTransactions();

} // ServiceSequence
