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
 * A representation of the model object '<em><b>kNode Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getSubNodeGroups <em>Sub Node Groups</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getNodeGroupLayout <em>Node Group Layout</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getkNodeGroup()
 * @model
 * @generated
 */
public interface kNodeGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Node Groups</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Node Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Node Groups</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getkNodeGroup_SubNodeGroups()
	 * @model
	 * @generated
	 */
	EList<kNodeGroup> getSubNodeGroups();

	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getkNodeGroup_OutgoingEdges()
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<kEdge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge}.
	 * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getkNodeGroup_IncomingEdges()
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<kEdge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Parent Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' reference.
	 * @see #setParentGroup(kNodeGroup)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getkNodeGroup_ParentGroup()
	 * @model required="true"
	 * @generated
	 */
	kNodeGroup getParentGroup();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getParentGroup <em>Parent Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Group</em>' reference.
	 * @see #getParentGroup()
	 * @generated
	 */
	void setParentGroup(kNodeGroup value);

	/**
	 * Returns the value of the '<em><b>Node Group Layout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Group Layout</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Group Layout</em>' reference.
	 * @see #setNodeGroupLayout(kNodeGroupLayout)
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage#getkNodeGroup_NodeGroupLayout()
	 * @model required="true"
	 * @generated
	 */
	kNodeGroupLayout getNodeGroupLayout();

	/**
	 * Sets the value of the '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup#getNodeGroupLayout <em>Node Group Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Group Layout</em>' reference.
	 * @see #getNodeGroupLayout()
	 * @generated
	 */
	void setNodeGroupLayout(kNodeGroupLayout value);

} // kNodeGroup
