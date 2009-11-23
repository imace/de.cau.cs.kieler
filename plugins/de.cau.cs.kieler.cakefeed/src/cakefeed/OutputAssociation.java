/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.OutputAssociation#getSourceOutputEventPort <em>Source Output Event Port</em>}</li>
 *   <li>{@link cakefeed.OutputAssociation#getTargetOutputDataPort <em>Target Output Data Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getOutputAssociation()
 * @model
 * @generated
 */
public interface OutputAssociation extends Association {
	/**
	 * Returns the value of the '<em><b>Source Output Event Port</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.OutputEventPort#getOutputAssociations <em>Output Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Output Event Port</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Output Event Port</em>' container reference.
	 * @see #setSourceOutputEventPort(OutputEventPort)
	 * @see cakefeed.CakefeedPackage#getOutputAssociation_SourceOutputEventPort()
	 * @see cakefeed.OutputEventPort#getOutputAssociations
	 * @model opposite="outputAssociations" required="true" transient="false"
	 * @generated
	 */
	OutputEventPort getSourceOutputEventPort();

	/**
	 * Sets the value of the '{@link cakefeed.OutputAssociation#getSourceOutputEventPort <em>Source Output Event Port</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Output Event Port</em>' container reference.
	 * @see #getSourceOutputEventPort()
	 * @generated
	 */
	void setSourceOutputEventPort(OutputEventPort value);

	/**
	 * Returns the value of the '<em><b>Target Output Data Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link cakefeed.OutputDataPort#getOutputAssociations <em>Output Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Output Data Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Output Data Port</em>' reference.
	 * @see #setTargetOutputDataPort(OutputDataPort)
	 * @see cakefeed.CakefeedPackage#getOutputAssociation_TargetOutputDataPort()
	 * @see cakefeed.OutputDataPort#getOutputAssociations
	 * @model opposite="outputAssociations" required="true"
	 * @generated
	 */
	OutputDataPort getTargetOutputDataPort();

	/**
	 * Sets the value of the '{@link cakefeed.OutputAssociation#getTargetOutputDataPort <em>Target Output Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Output Data Port</em>' reference.
	 * @see #getTargetOutputDataPort()
	 * @generated
	 */
	void setTargetOutputDataPort(OutputDataPort value);

} // OutputAssociation
