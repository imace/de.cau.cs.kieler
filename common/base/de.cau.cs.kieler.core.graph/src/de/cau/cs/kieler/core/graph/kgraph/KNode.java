/**
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright ${year} by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 *
 * $Id$
 */
package de.cau.cs.kieler.core.graph.kgraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getChildren <em>Children</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getParent <em>Parent</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getPorts <em>Ports</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKNode()
 * @model
 * @generated
 */
public interface KNode extends KGraphElement {
    /**
     * Returns the value of the '<em><b>Children</b></em>' containment reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.graph.kgraph.KNode}.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' containment reference list.
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKNode_Children()
     * @see de.cau.cs.kieler.core.graph.kgraph.KNode#getParent
     * @model opposite="parent" containment="true"
     * @generated
     */
    EList<KNode> getChildren();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(KNode)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKNode_Parent()
     * @see de.cau.cs.kieler.core.graph.kgraph.KNode#getChildren
     * @model opposite="children" transient="false"
     * @generated
     */
    KNode getParent();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent(KNode value);

    /**
     * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.graph.kgraph.KPort}.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ports</em>' containment reference list.
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKNode_Ports()
     * @see de.cau.cs.kieler.core.graph.kgraph.KPort#getNode
     * @model opposite="node" containment="true"
     * @generated
     */
    EList<KPort> getPorts();

    /**
     * Returns the value of the '<em><b>Outgoing Edges</b></em>' containment reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.graph.kgraph.KEdge}.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outgoing Edges</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outgoing Edges</em>' containment reference list.
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKNode_OutgoingEdges()
     * @see de.cau.cs.kieler.core.graph.kgraph.KEdge#getSource
     * @model opposite="source" containment="true"
     * @generated
     */
    EList<KEdge> getOutgoingEdges();

    /**
     * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.graph.kgraph.KEdge}.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Incoming Edges</em>' reference list.
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKNode_IncomingEdges()
     * @see de.cau.cs.kieler.core.graph.kgraph.KEdge#getTarget
     * @model opposite="target"
     * @generated
     */
    EList<KEdge> getIncomingEdges();

    /**
     * Returns the value of the '<em><b>Label</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' containment reference.
     * @see #setLabel(KLabel)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKNode_Label()
     * @model containment="true"
     * @generated
     */
    KLabel getLabel();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getLabel <em>Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' containment reference.
     * @see #getLabel()
     * @generated
     */
    void setLabel(KLabel value);

} // KNode
