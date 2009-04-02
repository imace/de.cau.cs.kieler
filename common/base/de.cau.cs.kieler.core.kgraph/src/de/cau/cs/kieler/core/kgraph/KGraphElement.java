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
package de.cau.cs.kieler.core.kgraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.core.kgraph.KGraphElement#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.core.kgraph.KGraphPackage#getKGraphElement()
 * @model abstract="true"
 * @generated
 */
public interface KGraphElement extends EModelElement {
    /**
     * Returns the value of the '<em><b>Data</b></em>' containment reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.kgraph.KGraphData}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data</em>' containment reference list.
     * @see de.cau.cs.kieler.core.kgraph.KGraphPackage#getKGraphElement_Data()
     * @model containment="true"
     * @generated
     */
    EList<KGraphData> getData();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    KGraphData getData(EClass type);

} // KGraphElement
