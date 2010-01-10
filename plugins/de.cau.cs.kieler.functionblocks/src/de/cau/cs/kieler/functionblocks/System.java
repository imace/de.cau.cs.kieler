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
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getApplication <em>Application</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getDevice <em>Device</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getMapping <em>Mapping</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getSegment <em>Segment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getLink <em>Link</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.System#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem()
 * @model extendedMetaData="name='System_._type' kind='elementOnly'"
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identification</em>' containment reference.
	 * @see #setIdentification(Identification)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Identification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Identification' namespace='##targetNamespace'"
	 * @generated
	 */
	Identification getIdentification();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.System#getIdentification <em>Identification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identification</em>' containment reference.
	 * @see #getIdentification()
	 * @generated
	 */
	void setIdentification(Identification value);

	/**
	 * Returns the value of the '<em><b>Version Info</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.VersionInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Version Info</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_VersionInfo()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='VersionInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<VersionInfo> getVersionInfo();

	/**
	 * Returns the value of the '<em><b>Application</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.Application}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * System element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Application()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Application' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Application> getApplication();

	/**
	 * Returns the value of the '<em><b>Device</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.Device}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * System element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Device</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Device()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Device' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Device> getDevice();

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * System element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Mapping()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Mapping' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Mapping> getMapping();

	/**
	 * Returns the value of the '<em><b>Segment</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.Segment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Network element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Segment</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Segment()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Segment' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Segment> getSegment();

	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.functionblocks.Link}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Network element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link</em>' containment reference list.
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Link()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Link' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Link> getLink();

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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Comment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Comment' namespace='##targetNamespace'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.System#getComment <em>Comment</em>}' attribute.
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSystem_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.System#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // System
