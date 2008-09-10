/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Signal#getSignalName <em>Signal Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getSignal()
 * @model
 * @generated
 */
public interface Signal extends EObject {
    /**
     * Returns the value of the '<em><b>Signal Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signal Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signal Name</em>' attribute.
     * @see #setSignalName(String)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getSignal_SignalName()
     * @model
     * @generated
     */
    String getSignalName();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Signal#getSignalName <em>Signal Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signal Name</em>' attribute.
     * @see #getSignalName()
     * @generated
     */
    void setSignalName(String value);

} // Signal
