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
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Region#getStates <em>States</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Region#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getRegion()
 * @model annotation="http://rtsys.informatik.uni-kiel.de/trac/kieler documentation='Region corresponds to a STG (state-transition-graph) in the SSM syntax. It is named Region here for understandabilty reasons.'"
 * @generated
 */
public interface Region extends EObject {
    /**
     * Returns the value of the '<em><b>States</b></em>' containment reference list.
     * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.AbstractState}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>States</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>States</em>' containment reference list.
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getRegion_States()
     * @model containment="true" required="true"
     * @generated
     */
    EList<AbstractState> getStates();

    /**
     * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
     * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Transition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transitions</em>' containment reference list.
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getRegion_Transitions()
     * @model containment="true"
     * @generated
     */
    EList<Transition> getTransitions();

} // Region
