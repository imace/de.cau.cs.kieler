/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed;

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
 *   <li>{@link Cakefeed.Application#getApplicationName <em>Application Name</em>}</li>
 *   <li>{@link Cakefeed.Application#getFunctionBlocksInstances <em>Function Blocks Instances</em>}</li>
 *   <li>{@link Cakefeed.Application#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see Cakefeed.CakefeedPackage#getApplication()
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
	 * @see Cakefeed.CakefeedPackage#getApplication_ApplicationName()
	 * @model required="true"
	 * @generated
	 */
	String getApplicationName();

	/**
	 * Sets the value of the '{@link Cakefeed.Application#getApplicationName <em>Application Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Name</em>' attribute.
	 * @see #getApplicationName()
	 * @generated
	 */
	void setApplicationName(String value);

	/**
	 * Returns the value of the '<em><b>Function Blocks Instances</b></em>' containment reference list.
	 * The list contents are of type {@link Cakefeed.FunctionBlockInstance}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.FunctionBlockInstance#getParentApplication <em>Parent Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Blocks Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Blocks Instances</em>' containment reference list.
	 * @see Cakefeed.CakefeedPackage#getApplication_FunctionBlocksInstances()
	 * @see Cakefeed.FunctionBlockInstance#getParentApplication
	 * @model opposite="parentApplication" containment="true"
	 * @generated
	 */
	EList<FunctionBlockInstance> getFunctionBlocksInstances();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link Cakefeed.Connection}.
	 * It is bidirectional and its opposite is '{@link Cakefeed.Connection#getParentApplication <em>Parent Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see Cakefeed.CakefeedPackage#getApplication_Connections()
	 * @see Cakefeed.Connection#getParentApplication
	 * @model opposite="parentApplication" containment="true"
	 * @generated
	 */
	EList<Connection> getConnections();

} // Application
