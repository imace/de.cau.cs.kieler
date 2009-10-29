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
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.Application#getApplicationName <em>Application Name</em>}</li>
 *   <li>{@link cakefeed.Application#getFunctionBlocksInstances <em>Function Blocks Instances</em>}</li>
 *   <li>{@link cakefeed.Application#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends EObject {
	/**
	 * Returns the value of the '<em><b>Application Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Name</em>' attribute.
	 * @see #setApplicationName(String)
	 * @see cakefeed.CakefeedPackage#getApplication_ApplicationName()
	 * @model required="true"
	 * @generated
	 */
	String getApplicationName();

	/**
	 * Sets the value of the '{@link cakefeed.Application#getApplicationName <em>Application Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Name</em>' attribute.
	 * @see #getApplicationName()
	 * @generated
	 */
	void setApplicationName(String value);

	/**
	 * Returns the value of the '<em><b>Function Blocks Instances</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.FunctionBlockInstance}.
	 * It is bidirectional and its opposite is '{@link cakefeed.FunctionBlockInstance#getParentApplication <em>Parent Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Blocks Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Blocks Instances</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getApplication_FunctionBlocksInstances()
	 * @see cakefeed.FunctionBlockInstance#getParentApplication
	 * @model opposite="parentApplication" containment="true"
	 * @generated
	 */
	EList<FunctionBlockInstance> getFunctionBlocksInstances();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link cakefeed.Connection}.
	 * It is bidirectional and its opposite is '{@link cakefeed.Connection#getParentApplication <em>Parent Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see cakefeed.CakefeedPackage#getApplication_Connections()
	 * @see cakefeed.Connection#getParentApplication
	 * @model opposite="parentApplication" containment="true"
	 * @generated
	 */
	EList<Connection> getConnections();

} // Application
