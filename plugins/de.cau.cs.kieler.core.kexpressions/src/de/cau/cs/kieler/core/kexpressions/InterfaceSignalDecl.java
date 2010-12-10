/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.core.kexpressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Signal Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.core.kexpressions.InterfaceSignalDecl#getSignals <em>Signals</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.cau.cs.kieler.core.kexpressions.KExpressionsPackage#getInterfaceSignalDecl()
 * @model
 * @generated
 */
public interface InterfaceSignalDecl extends InterfaceDeclaration {
    /**
     * Returns the value of the '<em><b>Signals</b></em>' containment reference list.
     * The list contents are of type {@link de.cau.cs.kieler.core.kexpressions.ISignal}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signals</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signals</em>' containment reference list.
     * @see de.cau.cs.kieler.core.kexpressions.KExpressionsPackage#getInterfaceSignalDecl_Signals()
     * @model containment="true"
     * @generated
     */
    EList<ISignal> getSignals();

} // InterfaceSignalDecl
