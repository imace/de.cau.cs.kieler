/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.Connection#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.Connection#getDestination <em>Destination</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.Connection#getDx1 <em>Dx1</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.Connection#getDx2 <em>Dx2</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.Connection#getDy <em>Dy</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.Connection#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getConnection()
 * @model extendedMetaData="name='Connection_._type' kind='empty'"
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getConnection_Comment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Comment' namespace='##targetNamespace'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.Connection#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' attribute.
	 * @see #setDestination(String)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getConnection_Destination()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Destination' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDestination();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.Connection#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(String value);

	/**
	 * Returns the value of the '<em><b>Dx1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dx1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dx1</em>' attribute.
	 * @see #setDx1(String)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getConnection_Dx1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dx1' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDx1();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.Connection#getDx1 <em>Dx1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dx1</em>' attribute.
	 * @see #getDx1()
	 * @generated
	 */
	void setDx1(String value);

	/**
	 * Returns the value of the '<em><b>Dx2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dx2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dx2</em>' attribute.
	 * @see #setDx2(String)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getConnection_Dx2()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dx2' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDx2();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.Connection#getDx2 <em>Dx2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dx2</em>' attribute.
	 * @see #getDx2()
	 * @generated
	 */
	void setDx2(String value);

	/**
	 * Returns the value of the '<em><b>Dy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dy</em>' attribute.
	 * @see #setDy(String)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getConnection_Dy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dy' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDy();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.Connection#getDy <em>Dy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dy</em>' attribute.
	 * @see #getDy()
	 * @generated
	 */
	void setDy(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see de.cau.cs.kieler.functionblock.FunctionblockPackage#getConnection_Source()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Source' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblock.Connection#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // Connection
