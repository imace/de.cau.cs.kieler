/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Service#getServiceSequence <em>Service Sequence</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Service#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Service#getLeftInterface <em>Left Interface</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Service#getRightInterface <em>Right Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getService()
 * @model extendedMetaData="name='Service_._type' kind='elementOnly'"
 * @generated
 */
public interface Service extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.ServiceSequence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service Sequence</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getService_ServiceSequence()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='ServiceSequence' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ServiceSequence> getServiceSequence();

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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getService_Comment()
	 * @model extendedMetaData="kind='attribute' name='Comment' namespace='##targetNamespace'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Service#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Left Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Interface</em>' attribute.
	 * @see #setLeftInterface(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getService_LeftInterface()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='LeftInterface' namespace='##targetNamespace'"
	 * @generated
	 */
	String getLeftInterface();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Service#getLeftInterface <em>Left Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Interface</em>' attribute.
	 * @see #getLeftInterface()
	 * @generated
	 */
	void setLeftInterface(String value);

	/**
	 * Returns the value of the '<em><b>Right Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Interface</em>' attribute.
	 * @see #setRightInterface(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getService_RightInterface()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='RightInterface' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRightInterface();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Service#getRightInterface <em>Right Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Interface</em>' attribute.
	 * @see #getRightInterface()
	 * @generated
	 */
	void setRightInterface(String value);

} // Service
