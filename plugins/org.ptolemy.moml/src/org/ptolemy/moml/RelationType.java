/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.ptolemy.moml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.ptolemy.moml.RelationType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.ptolemy.moml.RelationType#getConfigure <em>Configure</em>}</li>
 *   <li>{@link org.ptolemy.moml.RelationType#getDoc <em>Doc</em>}</li>
 *   <li>{@link org.ptolemy.moml.RelationType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.ptolemy.moml.RelationType#getRename <em>Rename</em>}</li>
 *   <li>{@link org.ptolemy.moml.RelationType#getVertex <em>Vertex</em>}</li>
 *   <li>{@link org.ptolemy.moml.RelationType#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.ptolemy.moml.RelationType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.ptolemy.moml.MomlPackage#getRelationType()
 * @model extendedMetaData="name='relation_._type' kind='elementOnly'"
 * @generated
 */
public interface RelationType extends EObject {
    /**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
    FeatureMap getGroup();

    /**
	 * Returns the value of the '<em><b>Configure</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.moml.ConfigureType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configure</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Configure</em>' containment reference list.
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Configure()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='configure' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
    EList<ConfigureType> getConfigure();

    /**
	 * Returns the value of the '<em><b>Doc</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.moml.DocType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Doc</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Doc</em>' containment reference list.
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Doc()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='doc' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
    EList<DocType> getDoc();

    /**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.moml.PropertyType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Property()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
    EList<PropertyType> getProperty();

    /**
	 * Returns the value of the '<em><b>Rename</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.moml.RenameType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rename</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Rename</em>' containment reference list.
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Rename()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='rename' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
    EList<RenameType> getRename();

    /**
	 * Returns the value of the '<em><b>Vertex</b></em>' containment reference list.
	 * The list contents are of type {@link org.ptolemy.moml.VertexType}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vertex</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex</em>' containment reference list.
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Vertex()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='vertex' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
    EList<VertexType> getVertex();

    /**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Class()
	 * @model extendedMetaData="kind='attribute' name='class' namespace='##targetNamespace'"
	 * @generated
	 */
    String getClass_();

    /**
	 * Sets the value of the '{@link org.ptolemy.moml.RelationType#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

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
	 * @see org.ptolemy.moml.MomlPackage#getRelationType_Name()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link org.ptolemy.moml.RelationType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // RelationType
