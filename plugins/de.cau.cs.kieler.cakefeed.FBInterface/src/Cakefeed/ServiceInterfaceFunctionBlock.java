/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Interface Function Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.ServiceInterfaceFunctionBlock#getServiceSequence <em>Service Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getServiceInterfaceFunctionBlock()
 * @model
 * @generated
 */
public interface ServiceInterfaceFunctionBlock extends FunctionBlock {
	/**
	 * Returns the value of the '<em><b>Service Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Sequence</em>' reference.
	 * @see #setServiceSequence(ServiceSequence)
	 * @see Cakefeed.CakefeedPackage#getServiceInterfaceFunctionBlock_ServiceSequence()
	 * @model
	 * @generated
	 */
	ServiceSequence getServiceSequence();

	/**
	 * Sets the value of the '{@link Cakefeed.ServiceInterfaceFunctionBlock#getServiceSequence <em>Service Sequence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Sequence</em>' reference.
	 * @see #getServiceSequence()
	 * @generated
	 */
	void setServiceSequence(ServiceSequence value);

} // ServiceInterfaceFunctionBlock
