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
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getCounter <em>Counter</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getEvent <em>Event</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends EObject {
    /**
     * Returns the value of the '<em><b>Counter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Counter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Counter</em>' attribute.
     * @see #setCounter(int)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTrigger_Counter()
     * @model
     * @generated
     */
    int getCounter();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getCounter <em>Counter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Counter</em>' attribute.
     * @see #getCounter()
     * @generated
     */
    void setCounter(int value);

    /**
     * Returns the value of the '<em><b>Event</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event</em>' attribute.
     * @see #setEvent(String)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTrigger_Event()
     * @model
     * @generated
     */
    String getEvent();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getEvent <em>Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event</em>' attribute.
     * @see #getEvent()
     * @generated
     */
    void setEvent(String value);

    /**
     * Returns the value of the '<em><b>Condition</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Condition</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' attribute.
     * @see #setCondition(String)
     * @see edu.unikiel.rtsys.kieler.ssm.ssmPackage#getTrigger_Condition()
     * @model
     * @generated
     */
    String getCondition();

    /**
     * Sets the value of the '{@link edu.unikiel.rtsys.kieler.ssm.Trigger#getCondition <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' attribute.
     * @see #getCondition()
     * @generated
     */
    void setCondition(String value);

} // Trigger
