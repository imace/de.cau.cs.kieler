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
 * A representation of the model object '<em><b>Sub App Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppType#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppType#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppType#getCompilerInfo <em>Compiler Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppType#getSubAppInterfaceList <em>Sub App Interface List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppType#getSubAppNetwork <em>Sub App Network</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppType#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.SubAppType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType()
 * @model extendedMetaData="name='SubAppType_._type' kind='elementOnly'"
 * @generated
 */
public interface SubAppType extends EObject {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identification</em>' containment reference.
	 * @see #setIdentification(Identification)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType_Identification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Identification' namespace='##targetNamespace'"
	 * @generated
	 */
	Identification getIdentification();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppType#getIdentification <em>Identification</em>}' containment reference.
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType_VersionInfo()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='VersionInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<VersionInfo> getVersionInfo();

	/**
	 * Returns the value of the '<em><b>Compiler Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Compiler Info</em>' containment reference.
	 * @see #setCompilerInfo(CompilerInfo)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType_CompilerInfo()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='CompilerInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	CompilerInfo getCompilerInfo();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppType#getCompilerInfo <em>Compiler Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compiler Info</em>' containment reference.
	 * @see #getCompilerInfo()
	 * @generated
	 */
	void setCompilerInfo(CompilerInfo value);

	/**
	 * Returns the value of the '<em><b>Sub App Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Interface List</em>' containment reference.
	 * @see #setSubAppInterfaceList(SubAppInterfaceList)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType_SubAppInterfaceList()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='SubAppInterfaceList' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppInterfaceList getSubAppInterfaceList();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppType#getSubAppInterfaceList <em>Sub App Interface List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Interface List</em>' containment reference.
	 * @see #getSubAppInterfaceList()
	 * @generated
	 */
	void setSubAppInterfaceList(SubAppInterfaceList value);

	/**
	 * Returns the value of the '<em><b>Sub App Network</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubAppType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub App Network</em>' containment reference.
	 * @see #setSubAppNetwork(SubAppNetwork)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType_SubAppNetwork()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SubAppNetwork' namespace='##targetNamespace'"
	 * @generated
	 */
	SubAppNetwork getSubAppNetwork();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppType#getSubAppNetwork <em>Sub App Network</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub App Network</em>' containment reference.
	 * @see #getSubAppNetwork()
	 * @generated
	 */
	void setSubAppNetwork(SubAppNetwork value);

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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType_Comment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Comment' namespace='##targetNamespace'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppType#getComment <em>Comment</em>}' attribute.
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getSubAppType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.SubAppType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SubAppType
