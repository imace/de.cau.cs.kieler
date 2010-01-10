/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Algorithm#getFBD <em>FBD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Algorithm#getST <em>ST</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Algorithm#getLD <em>LD</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Algorithm#getOther <em>Other</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Algorithm#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.Algorithm#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAlgorithm()
 * @model extendedMetaData="name='Algorithm_._type' kind='elementOnly'"
 * @generated
 */
public interface Algorithm extends EObject {
	/**
	 * Returns the value of the '<em><b>FBD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>FBD</em>' containment reference.
	 * @see #setFBD(FBD)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAlgorithm_FBD()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='FBD' namespace='##targetNamespace'"
	 * @generated
	 */
	FBD getFBD();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Algorithm#getFBD <em>FBD</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>FBD</em>' containment reference.
	 * @see #getFBD()
	 * @generated
	 */
	void setFBD(FBD value);

	/**
	 * Returns the value of the '<em><b>ST</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>ST</em>' containment reference.
	 * @see #setST(ST)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAlgorithm_ST()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ST' namespace='##targetNamespace'"
	 * @generated
	 */
	ST getST();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Algorithm#getST <em>ST</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ST</em>' containment reference.
	 * @see #getST()
	 * @generated
	 */
	void setST(ST value);

	/**
	 * Returns the value of the '<em><b>LD</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>LD</em>' containment reference.
	 * @see #setLD(LD)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAlgorithm_LD()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='LD' namespace='##targetNamespace'"
	 * @generated
	 */
	LD getLD();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Algorithm#getLD <em>LD</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>LD</em>' containment reference.
	 * @see #getLD()
	 * @generated
	 */
	void setLD(LD value);

	/**
	 * Returns the value of the '<em><b>Other</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Other</em>' containment reference.
	 * @see #setOther(Other)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAlgorithm_Other()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Other' namespace='##targetNamespace'"
	 * @generated
	 */
	Other getOther();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Algorithm#getOther <em>Other</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other</em>' containment reference.
	 * @see #getOther()
	 * @generated
	 */
	void setOther(Other value);

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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAlgorithm_Comment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Comment' namespace='##targetNamespace'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Algorithm#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAlgorithm_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.Algorithm#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Algorithm
