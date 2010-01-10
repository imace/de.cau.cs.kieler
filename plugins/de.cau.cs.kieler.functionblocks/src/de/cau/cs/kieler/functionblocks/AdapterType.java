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
 * A representation of the model object '<em><b>Adapter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.AdapterType#getIdentification <em>Identification</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.AdapterType#getVersionInfo <em>Version Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.AdapterType#getCompilerInfo <em>Compiler Info</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.AdapterType#getInterfaceList <em>Interface List</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.AdapterType#getService <em>Service</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.AdapterType#getComment <em>Comment</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.AdapterType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType()
 * @model extendedMetaData="name='AdapterType_._type' kind='elementOnly'"
 * @generated
 */
public interface AdapterType extends EObject {
	/**
	 * Returns the value of the '<em><b>Identification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Comment element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identification</em>' containment reference.
	 * @see #setIdentification(Identification)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType_Identification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Identification' namespace='##targetNamespace'"
	 * @generated
	 */
	Identification getIdentification();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.AdapterType#getIdentification <em>Identification</em>}' containment reference.
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType_VersionInfo()
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType_CompilerInfo()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='CompilerInfo' namespace='##targetNamespace'"
	 * @generated
	 */
	CompilerInfo getCompilerInfo();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.AdapterType#getCompilerInfo <em>Compiler Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compiler Info</em>' containment reference.
	 * @see #getCompilerInfo()
	 * @generated
	 */
	void setCompilerInfo(CompilerInfo value);

	/**
	 * Returns the value of the '<em><b>Interface List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface List</em>' containment reference.
	 * @see #setInterfaceList(InterfaceList)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType_InterfaceList()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='InterfaceList' namespace='##targetNamespace'"
	 * @generated
	 */
	InterfaceList getInterfaceList();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.AdapterType#getInterfaceList <em>Interface List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface List</em>' containment reference.
	 * @see #getInterfaceList()
	 * @generated
	 */
	void setInterfaceList(InterfaceList value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FBType element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Service</em>' containment reference.
	 * @see #setService(Service)
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType_Service()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Service' namespace='##targetNamespace'"
	 * @generated
	 */
	Service getService();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.AdapterType#getService <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' containment reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(Service value);

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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType_Comment()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Comment' namespace='##targetNamespace'"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.AdapterType#getComment <em>Comment</em>}' attribute.
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
	 * @see de.cau.cs.kieler.functionblocks.FunctionblocksPackage#getAdapterType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='Name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.functionblocks.AdapterType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // AdapterType
