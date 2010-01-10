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
 * A representation of the model object '<em><b>HCECC Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getDestination <em>Destination</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getRelation <em>Relation</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getHCECCRelation()
 * @model extendedMetaData="name='HCECCRelation_._type' kind='empty'"
 * @generated
 */
public interface HCECCRelation extends EObject {
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getHCECCRelation_Comment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Comment' namespace='##targetNamespace'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getComment <em>Comment</em>}' attribute.
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getHCECCRelation_Destination()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Destination' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDestination();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(String value);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' attribute.
	 * @see #setRelation(String)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getHCECCRelation_Relation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Relation' namespace='##targetNamespace'"
	 * @generated
	 */
	String getRelation();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getRelation <em>Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' attribute.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(String value);

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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getHCECCRelation_Source()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Source' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.HCECCRelation#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // HCECCRelation
