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
 * A representation of the model object '<em><b>KPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getNode <em>Node</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getEdges <em>Edges</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getLabel <em>Label</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKPort()
 * @model
 * @generated
 */
public interface KPort extends KGraphElement {
    /**
     * Returns the value of the '<em><b>Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getPorts <em>Ports</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Node</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Node</em>' container reference.
     * @see #setNode(KNode)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKPort_Node()
     * @see de.cau.cs.kieler.core.graph.kgraph.KNode#getPorts
     * @model opposite="ports" required="true" transient="false"
     * @generated
     */
    KNode getNode();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getNode <em>Node</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Node</em>' container reference.
     * @see #getNode()
     * @generated
     */
    void setNode(KNode value);

    /**
     * Returns the value of the '<em><b>Edges</b></em>' reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.graph.kgraph.KEdge}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Edges</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Edges</em>' reference list.
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKPort_Edges()
     * @model
     * @generated
     */
    EList<KEdge> getEdges();

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
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKPort_Label()
     * @model containment="true"
     * @generated
     */
    KLabel getLabel();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getLabel <em>Label</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' containment reference.
     * @see #getLabel()
     * @generated
     */
    void setLabel(KLabel value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.cau.cs.kieler.core.graph.kgraph.KPortType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.cau.cs.kieler.core.graph.kgraph.KPortType
     * @see #setType(KPortType)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKPort_Type()
     * @model
     * @generated
     */
    KPortType getType();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KPort#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see de.cau.cs.kieler.core.graph.kgraph.KPortType
     * @see #getType()
     * @generated
     */
    void setType(KPortType value);

} // KPort
