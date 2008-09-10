/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.Trigger;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TriggerImpl#getCounter <em>Counter</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TriggerImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TriggerImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TriggerImpl extends EObjectImpl implements Trigger {
    /**
     * The default value of the '{@link #getCounter() <em>Counter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCounter()
     * @generated
     * @ordered
     */
    protected static final int COUNTER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getCounter() <em>Counter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCounter()
     * @generated
     * @ordered
     */
    protected int counter = COUNTER_EDEFAULT;

    /**
     * The default value of the '{@link #getEvent() <em>Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvent()
     * @generated
     * @ordered
     */
    protected static final String EVENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEvent() <em>Event</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvent()
     * @generated
     * @ordered
     */
    protected String event = EVENT_EDEFAULT;

    /**
     * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected static final String CONDITION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
    protected String condition = CONDITION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TriggerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.TRIGGER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getCounter() {
        return counter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCounter(int newCounter) {
        int oldCounter = counter;
        counter = newCounter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRIGGER__COUNTER, oldCounter, counter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEvent() {
        return event;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEvent(String newEvent) {
        String oldEvent = event;
        event = newEvent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRIGGER__EVENT, oldEvent, event));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCondition() {
        return condition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCondition(String newCondition) {
        String oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRIGGER__CONDITION, oldCondition, condition));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ssmPackage.TRIGGER__COUNTER:
                return new Integer(getCounter());
            case ssmPackage.TRIGGER__EVENT:
                return getEvent();
            case ssmPackage.TRIGGER__CONDITION:
                return getCondition();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ssmPackage.TRIGGER__COUNTER:
                setCounter(((Integer)newValue).intValue());
                return;
            case ssmPackage.TRIGGER__EVENT:
                setEvent((String)newValue);
                return;
            case ssmPackage.TRIGGER__CONDITION:
                setCondition((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ssmPackage.TRIGGER__COUNTER:
                setCounter(COUNTER_EDEFAULT);
                return;
            case ssmPackage.TRIGGER__EVENT:
                setEvent(EVENT_EDEFAULT);
                return;
            case ssmPackage.TRIGGER__CONDITION:
                setCondition(CONDITION_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ssmPackage.TRIGGER__COUNTER:
                return counter != COUNTER_EDEFAULT;
            case ssmPackage.TRIGGER__EVENT:
                return EVENT_EDEFAULT == null ? event != null : !EVENT_EDEFAULT.equals(event);
            case ssmPackage.TRIGGER__CONDITION:
                return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (counter: ");
        result.append(counter);
        result.append(", event: ");
        result.append(event);
        result.append(", condition: ");
        result.append(condition);
        result.append(')');
        return result.toString();
    }

} //TriggerImpl
