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
 * A representation of the model object '<em><b>KEdge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getSource <em>Source</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getTarget <em>Target</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getTargetPort <em>Target Port</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getLabels <em>Labels</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKEdge()
 * @model
 * @generated
 */
public interface KEdge extends KGraphElement {
    /**
     * Returns the value of the '<em><b>Source</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getOutgoingEdges <em>Outgoing Edges</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' container reference.
     * @see #setSource(KNode)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKEdge_Source()
     * @see de.cau.cs.kieler.core.graph.kgraph.KNode#getOutgoingEdges
     * @model opposite="outgoingEdges" required="true" transient="false"
     * @generated
     */
    KNode getSource();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getSource <em>Source</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' container reference.
     * @see #getSource()
     * @generated
     */
    void setSource(KNode value);

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link de.cau.cs.kieler.core.graph.kgraph.KNode#getIncomingEdges <em>Incoming Edges</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(KNode)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKEdge_Target()
     * @see de.cau.cs.kieler.core.graph.kgraph.KNode#getIncomingEdges
     * @model opposite="incomingEdges" required="true"
     * @generated
     */
    KNode getTarget();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(KNode value);

    /**
     * Returns the value of the '<em><b>Source Port</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Port</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Port</em>' reference.
     * @see #setSourcePort(KPort)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKEdge_SourcePort()
     * @model
     * @generated
     */
    KPort getSourcePort();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getSourcePort <em>Source Port</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Port</em>' reference.
     * @see #getSourcePort()
     * @generated
     */
    void setSourcePort(KPort value);

    /**
     * Returns the value of the '<em><b>Target Port</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Port</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Port</em>' reference.
     * @see #setTargetPort(KPort)
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKEdge_TargetPort()
     * @model
     * @generated
     */
    KPort getTargetPort();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.core.graph.kgraph.KEdge#getTargetPort <em>Target Port</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Port</em>' reference.
     * @see #getTargetPort()
     * @generated
     */
    void setTargetPort(KPort value);

    /**
     * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.graph.kgraph.KLabel}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Labels</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Labels</em>' containment reference list.
     * @see de.cau.cs.kieler.core.graph.kgraph.KGraphPackage#getKEdge_Labels()
     * @model containment="true"
     * @generated
     */
    EList<KLabel> getLabels();

} // KEdge
