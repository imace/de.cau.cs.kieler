/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.InputAssociation#getSourceInputEventPort <em>Source Input Event Port</em>}</li>
 *   <li>{@link Cakefeed.InputAssociation#getTargetInputDataPort <em>Target Input Data Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getInputAssociation()
 * @model
 * @generated
 */
public interface InputAssociation extends Association {
	/**
	 * Returns the value of the '<em><b>Source Input Event Port</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputEventPort#getInputAssociations <em>Input Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Input Event Port</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Input Event Port</em>' container reference.
	 * @see #setSourceInputEventPort(InputEventPort)
	 * @see Cakefeed.CakefeedPackage#getInputAssociation_SourceInputEventPort()
	 * @see Cakefeed.InputEventPort#getInputAssociations
	 * @model opposite="inputAssociations" required="true" transient="false"
	 * @generated
	 */
	InputEventPort getSourceInputEventPort();

	/**
	 * Sets the value of the '{@link Cakefeed.InputAssociation#getSourceInputEventPort <em>Source Input Event Port</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Input Event Port</em>' container reference.
	 * @see #getSourceInputEventPort()
	 * @generated
	 */
	void setSourceInputEventPort(InputEventPort value);

	/**
	 * Returns the value of the '<em><b>Target Input Data Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.InputDataPort#getInputAssociations <em>Input Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Input Data Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Input Data Port</em>' reference.
	 * @see #setTargetInputDataPort(InputDataPort)
	 * @see Cakefeed.CakefeedPackage#getInputAssociation_TargetInputDataPort()
	 * @see Cakefeed.InputDataPort#getInputAssociations
	 * @model opposite="inputAssociations" required="true"
	 * @generated
	 */
	InputDataPort getTargetInputDataPort();

	/**
	 * Sets the value of the '{@link Cakefeed.InputAssociation#getTargetInputDataPort <em>Target Input Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Input Data Port</em>' reference.
	 * @see #getTargetInputDataPort()
	 * @generated
	 */
	void setTargetInputDataPort(InputDataPort value);

} // InputAssociation
