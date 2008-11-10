/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getLayout <em>Layout</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getLabel <em>Label</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getNodeGroup <em>Node Group</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getType <em>Type</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPort()
 * @model
 * @generated
 */
public interface KPort extends EObject {
	/**
	 * Returns the value of the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' reference.
	 * @see #setLayout(KPortLayout)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPort_Layout()
	 * @model required="true"
	 * @generated
	 */
	KPortLayout getLayout();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getLayout <em>Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' reference.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(KPortLayout value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference.
	 * @see #setLabel(KPortLabel)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPort_Label()
	 * @model
	 * @generated
	 */
	KPortLabel getLabel();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getLabel <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(KPortLabel value);

	/**
	 * Returns the value of the '<em><b>Node Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Group</em>' reference.
	 * @see #setNodeGroup(KNodeGroup)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPort_NodeGroup()
	 * @model required="true"
	 * @generated
	 */
	KNodeGroup getNodeGroup();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getNodeGroup <em>Node Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Group</em>' reference.
	 * @see #getNodeGroup()
	 * @generated
	 */
	void setNodeGroup(KNodeGroup value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * The literals are from the enumeration {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE
	 * @see #setType(PORT_TYPE)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPort_Type()
	 * @model default="0" required="true"
	 * @generated
	 */
	PORT_TYPE getType();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPort#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.PORT_TYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(PORT_TYPE value);

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKPort_Edges()
	 * @model
	 * @generated
	 */
	EList<KEdge> getEdges();

} // KPort
