/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.ConditionalTransition;
import edu.unikiel.rtsys.kieler.ssm.TransitionTriggerable;
import edu.unikiel.rtsys.kieler.ssm.Trigger;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.ConditionalTransitionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.ConditionalTransitionImpl#getTriggerString <em>Trigger String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalTransitionImpl extends TransitionImpl implements ConditionalTransition {
    /**
     * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTrigger()
     * @generated
     * @ordered
     */
    protected Trigger trigger;

    /**
     * The default value of the '{@link #getTriggerString() <em>Trigger String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTriggerString()
     * @generated
     * @ordered
     */
    protected static final String TRIGGER_STRING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTriggerString() <em>Trigger String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTriggerString()
     * @generated
     * @ordered
     */
    protected String triggerString = TRIGGER_STRING_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConditionalTransitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.CONDITIONAL_TRANSITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Trigger getTrigger() {
        return trigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTrigger(Trigger newTrigger, NotificationChain msgs) {
        Trigger oldTrigger = trigger;
        trigger = newTrigger;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.CONDITIONAL_TRANSITION__TRIGGER, oldTrigger, newTrigger);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTrigger(Trigger newTrigger) {
        if (newTrigger != trigger) {
            NotificationChain msgs = null;
            if (trigger != null)
                msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.CONDITIONAL_TRANSITION__TRIGGER, null, msgs);
            if (newTrigger != null)
                msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ssmPackage.CONDITIONAL_TRANSITION__TRIGGER, null, msgs);
            msgs = basicSetTrigger(newTrigger, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.CONDITIONAL_TRANSITION__TRIGGER, newTrigger, newTrigger));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTriggerString() {
        return triggerString;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTriggerString(String newTriggerString) {
        String oldTriggerString = triggerString;
        triggerString = newTriggerString;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.CONDITIONAL_TRANSITION__TRIGGER_STRING, oldTriggerString, triggerString));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER:
                return basicSetTrigger(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER:
                return getTrigger();
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER_STRING:
                return getTriggerString();
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
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER:
                setTrigger((Trigger)newValue);
                return;
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER_STRING:
                setTriggerString((String)newValue);
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
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER:
                setTrigger((Trigger)null);
                return;
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER_STRING:
                setTriggerString(TRIGGER_STRING_EDEFAULT);
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
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER:
                return trigger != null;
            case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER_STRING:
                return TRIGGER_STRING_EDEFAULT == null ? triggerString != null : !TRIGGER_STRING_EDEFAULT.equals(triggerString);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == TransitionTriggerable.class) {
            switch (derivedFeatureID) {
                case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER: return ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER;
                case ssmPackage.CONDITIONAL_TRANSITION__TRIGGER_STRING: return ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER_STRING;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == TransitionTriggerable.class) {
            switch (baseFeatureID) {
                case ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER: return ssmPackage.CONDITIONAL_TRANSITION__TRIGGER;
                case ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER_STRING: return ssmPackage.CONDITIONAL_TRANSITION__TRIGGER_STRING;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (triggerString: ");
        result.append(triggerString);
        result.append(')');
        return result.toString();
    }

} //ConditionalTransitionImpl
