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
package de.cau.cs.kieler.kaom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.kaom.BooleanAnnotation#isValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.kaom.KaomPackage#getBooleanAnnotation()
 * @model
 * @generated
 */
public interface BooleanAnnotation extends Annotation {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(boolean)
     * @see de.cau.cs.kieler.kaom.KaomPackage#getBooleanAnnotation_Value()
     * @model required="true"
     * @generated
     */
    boolean isValue();

    /**
     * Sets the value of the '{@link de.cau.cs.kieler.kaom.BooleanAnnotation#isValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #isValue()
     * @generated
     */
    void setValue(boolean value);

} // BooleanAnnotation
