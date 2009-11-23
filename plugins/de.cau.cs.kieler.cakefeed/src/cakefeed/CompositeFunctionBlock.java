/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Function Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.CompositeFunctionBlock#getCompositeNetwork <em>Composite Network</em>}</li>
 *   <li>{@link cakefeed.CompositeFunctionBlock#getServiceSequence <em>Service Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getCompositeFunctionBlock()
 * @model
 * @generated
 */
public interface CompositeFunctionBlock extends FunctionBlock {
	/**
	 * Returns the value of the '<em><b>Composite Network</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.CompositeNetwork#getParentCompositeFunctionBlock <em>Parent Composite Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Network</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Network</em>' reference.
	 * @see #setCompositeNetwork(CompositeNetwork)
	 * @see cakefeed.CakefeedPackage#getCompositeFunctionBlock_CompositeNetwork()
	 * @see cakefeed.CompositeNetwork#getParentCompositeFunctionBlock
	 * @model opposite="parentCompositeFunctionBlock" required="true"
	 * @generated
	 */
	CompositeNetwork getCompositeNetwork();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeFunctionBlock#getCompositeNetwork <em>Composite Network</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Network</em>' reference.
	 * @see #getCompositeNetwork()
	 * @generated
	 */
	void setCompositeNetwork(CompositeNetwork value);

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
	 * @see cakefeed.CakefeedPackage#getCompositeFunctionBlock_ServiceSequence()
	 * @model
	 * @generated
	 */
	ServiceSequence getServiceSequence();

	/**
	 * Sets the value of the '{@link cakefeed.CompositeFunctionBlock#getServiceSequence <em>Service Sequence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Sequence</em>' reference.
	 * @see #getServiceSequence()
	 * @generated
	 */
	void setServiceSequence(ServiceSequence value);

} // CompositeFunctionBlock
