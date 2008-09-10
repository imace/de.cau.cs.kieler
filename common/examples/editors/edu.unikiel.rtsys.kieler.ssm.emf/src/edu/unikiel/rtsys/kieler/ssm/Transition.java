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
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Transition#getPriority <em>Priority</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Transition#getEffect <em>Effect</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Transition#getEffectString <em>Effect String</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState#getIncomingTransitions <em>Incoming Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(AbstractState)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTransition_Target()
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState#getIncomingTransitions
     * @model opposite="incomingTransitions" required="true"
     * @generated
     */
    AbstractState getTarget();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(AbstractState value);

    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * It is bidirectional and its opposite is '{@link edu.unikiel.rtsys.kieler.ssm.AbstractState#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(AbstractState)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTransition_Source()
     * @see edu.unikiel.rtsys.kieler.ssm.AbstractState#getOutgoingTransitions
     * @model opposite="outgoingTransitions" required="true"
     * @generated
     */
    AbstractState getSource();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource(AbstractState value);

    /**
     * Returns the value of the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Priority</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Priority</em>' attribute.
     * @see #setPriority(int)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTransition_Priority()
     * @model
     * @generated
     */
    int getPriority();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getPriority <em>Priority</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Priority</em>' attribute.
     * @see #getPriority()
     * @generated
     */
    void setPriority(int value);

    /**
     * Returns the value of the '<em><b>Effect</b></em>' reference list.
     * The list contents are of type {@link edu.unikiel.rtsys.kieler.ssm.Action}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Effect</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Effect</em>' reference list.
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTransition_Effect()
     * @model
     * @generated
     */
    EList<Action> getEffect();

    /**
     * Returns the value of the '<em><b>Effect String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Effect String</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Effect String</em>' attribute.
     * @see #setEffectString(String)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTransition_EffectString()
     * @model
     * @generated
     */
    String getEffectString();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Transition#getEffectString <em>Effect String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Effect String</em>' attribute.
     * @see #getEffectString()
     * @generated
     */
    void setEffectString(String value);

} // Transition
