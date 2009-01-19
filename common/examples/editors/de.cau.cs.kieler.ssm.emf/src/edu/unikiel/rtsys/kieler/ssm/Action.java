/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Action#getSignals <em>Signals</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends EObject {
    /**
	 * Returns the value of the '<em><b>Signals</b></em>' reference list.
	 * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Signal}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signals</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Signals</em>' reference list.
	 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getAction_Signals()
	 * @model
	 * @generated
	 */
    EList<Signal> getSignals();

} // Action
