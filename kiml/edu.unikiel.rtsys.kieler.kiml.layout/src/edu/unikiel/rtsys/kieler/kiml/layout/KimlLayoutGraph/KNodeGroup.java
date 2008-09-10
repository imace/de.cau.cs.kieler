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
 * A representation of the model object '<em><b>KNode Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getSubNodeGroups <em>Sub Node Groups</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLayout <em>Layout</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroup()
 * @model
 * @generated
 */
public interface KNodeGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Node Groups</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Node Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Node Groups</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroup_SubNodeGroups()
	 * @model
	 * @generated
	 */
	EList<KNodeGroup> getSubNodeGroups();

	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroup_OutgoingEdges()
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<KEdge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroup_IncomingEdges()
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<KEdge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' reference.
	 * @see #setParentGroup(KNodeGroup)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroup_ParentGroup()
	 * @model required="true"
	 * @generated
	 */
	KNodeGroup getParentGroup();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getParentGroup <em>Parent Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Group</em>' reference.
	 * @see #getParentGroup()
	 * @generated
	 */
	void setParentGroup(KNodeGroup value);

	/**
	 * Returns the value of the '<em><b>Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout</em>' reference.
	 * @see #setLayout(KNodeGroupLayout)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroup_Layout()
	 * @model required="true"
	 * @generated
	 */
	KNodeGroupLayout getLayout();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLayout <em>Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout</em>' reference.
	 * @see #getLayout()
	 * @generated
	 */
	void setLayout(KNodeGroupLayout value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference.
	 * @see #setLabel(KNodeGroupLabel)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getKNodeGroup_Label()
	 * @model required="true"
	 * @generated
	 */
	KNodeGroupLabel getLabel();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup#getLabel <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(KNodeGroupLabel value);

} // KNodeGroup
