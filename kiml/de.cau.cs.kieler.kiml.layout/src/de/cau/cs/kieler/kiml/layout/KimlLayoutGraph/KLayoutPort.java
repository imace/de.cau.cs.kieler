/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KLayoutPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLayout <em>Layout</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLabel <em>Label</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getNode <em>Node</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getType <em>Type</em>}</li>
 *   <li>{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutPort()
 * @model
 * @generated
 */
public interface KLayoutPort extends EObject {
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
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutPort_Layout()
	 * @model required="true"
	 * @generated
	 */
	KPortLayout getLayout();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLayout <em>Layout</em>}' reference.
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
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutPort_Label()
	 * @model
	 * @generated
	 */
	KPortLabel getLabel();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getLabel <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(KPortLabel value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(KLayoutNode)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutPort_Node()
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode#getPorts
	 * @model opposite="ports" required="true"
	 * @generated
	 */
	KLayoutNode getNode();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(KLayoutNode value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * The literals are from the enumeration {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType
	 * @see #setType(KPortType)
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutPort_Type()
	 * @model default="0" required="true"
	 * @generated
	 */
	KPortType getType();

	/**
	 * Sets the value of the '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortType
	 * @see #getType()
	 * @generated
	 */
	void setType(KPortType value);

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference list.
	 * The list contents are of type {@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference list.
	 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKLayoutPort_Edges()
	 * @model
	 * @generated
	 */
	EList<KLayoutEdge> getEdges();

} // KLayoutPort
