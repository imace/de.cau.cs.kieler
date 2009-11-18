/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Block Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Cakefeed.FunctionBlockInstance#getParentApplication <em>Parent Application</em>}</li>
 *   <li>{@link Cakefeed.FunctionBlockInstance#getInstanceName <em>Instance Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getFunctionBlockInstance()
 * @model abstract="true"
 * @generated
 */
public interface FunctionBlockInstance extends FunctionBlock {
	/**
	 * Returns the value of the '<em><b>Parent Application</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Cakefeed.Application#getFunctionBlocksInstances <em>Function Blocks Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Application</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Application</em>' container reference.
	 * @see #setParentApplication(Application)
	 * @see Cakefeed.CakefeedPackage#getFunctionBlockInstance_ParentApplication()
	 * @see Cakefeed.Application#getFunctionBlocksInstances
	 * @model opposite="functionBlocksInstances" required="true" transient="false"
	 * @generated
	 */
	Application getParentApplication();

	/**
	 * Sets the value of the '{@link Cakefeed.FunctionBlockInstance#getParentApplication <em>Parent Application</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Application</em>' container reference.
	 * @see #getParentApplication()
	 * @generated
	 */
	void setParentApplication(Application value);

	/**
	 * Returns the value of the '<em><b>Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Name</em>' attribute.
	 * @see #setInstanceName(String)
	 * @see Cakefeed.CakefeedPackage#getFunctionBlockInstance_InstanceName()
	 * @model required="true"
	 * @generated
	 */
	String getInstanceName();

	/**
	 * Sets the value of the '{@link Cakefeed.FunctionBlockInstance#getInstanceName <em>Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Name</em>' attribute.
	 * @see #getInstanceName()
	 * @generated
	 */
	void setInstanceName(String value);

} // FunctionBlockInstance
