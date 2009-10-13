/**
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
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
 * A representation of the model object '<em><b>Graph Element</b></em>'. This
 * is the superclass of all elements of a graph such as nodes, edges, ports,
 * and labels. A graph element may contain an arbitrary number of additional
 * data instances.
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
     * Each element of this list may contain additional data for the model element.
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
     * Returns the first data instance that matches the given class. Classes
     * can be obtained using the static package methods of the corresponding
     * EMF model.
     * @return graph data for the given type, or null if there is none
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    KGraphData getData(EClass type);

} // KGraphElement
