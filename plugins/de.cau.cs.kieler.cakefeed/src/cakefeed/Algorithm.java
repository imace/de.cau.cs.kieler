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
 * A representation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cakefeed.Algorithm#getAlgorithmName <em>Algorithm Name</em>}</li>
 *   <li>{@link cakefeed.Algorithm#getAlgorithmLanguage <em>Algorithm Language</em>}</li>
 *   <li>{@link cakefeed.Algorithm#getAlgorithmSourceCode <em>Algorithm Source Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see cakefeed.CakefeedPackage#getAlgorithm()
 * @model
 * @generated
 */
public interface Algorithm extends EObject {
	/**
	 * Returns the value of the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm Name</em>' attribute.
	 * @see #setAlgorithmName(String)
	 * @see cakefeed.CakefeedPackage#getAlgorithm_AlgorithmName()
	 * @model required="true"
	 * @generated
	 */
	String getAlgorithmName();

	/**
	 * Sets the value of the '{@link cakefeed.Algorithm#getAlgorithmName <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Name</em>' attribute.
	 * @see #getAlgorithmName()
	 * @generated
	 */
	void setAlgorithmName(String value);

	/**
	 * Returns the value of the '<em><b>Algorithm Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm Language</em>' attribute.
	 * @see #setAlgorithmLanguage(String)
	 * @see cakefeed.CakefeedPackage#getAlgorithm_AlgorithmLanguage()
	 * @model required="true"
	 * @generated
	 */
	String getAlgorithmLanguage();

	/**
	 * Sets the value of the '{@link cakefeed.Algorithm#getAlgorithmLanguage <em>Algorithm Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Language</em>' attribute.
	 * @see #getAlgorithmLanguage()
	 * @generated
	 */
	void setAlgorithmLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Algorithm Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm Source Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm Source Code</em>' attribute.
	 * @see #setAlgorithmSourceCode(String)
	 * @see cakefeed.CakefeedPackage#getAlgorithm_AlgorithmSourceCode()
	 * @model required="true"
	 * @generated
	 */
	String getAlgorithmSourceCode();

	/**
	 * Sets the value of the '{@link cakefeed.Algorithm#getAlgorithmSourceCode <em>Algorithm Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Source Code</em>' attribute.
	 * @see #getAlgorithmSourceCode()
	 * @generated
	 */
	void setAlgorithmSourceCode(String value);

} // Algorithm
