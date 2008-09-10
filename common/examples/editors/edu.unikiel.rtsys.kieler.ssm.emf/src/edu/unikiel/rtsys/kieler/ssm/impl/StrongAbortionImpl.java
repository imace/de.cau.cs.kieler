/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.StrongAbortion;
import edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable;
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
 * An implementation of the model object '<em><b>Strong Abortion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl#getTriggerString <em>Trigger String</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl#isIsImmediate <em>Is Immediate</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.StrongAbortionImpl#getIsImmediateString <em>Is Immediate String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StrongAbortionImpl extends TransitionImpl implements StrongAbortion {
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
     * The default value of the '{@link #isIsImmediate() <em>Is Immediate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsImmediate()
     * @generated
     * @ordered
     */
    protected static final boolean IS_IMMEDIATE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsImmediate() <em>Is Immediate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsImmediate()
     * @generated
     * @ordered
     */
    protected boolean isImmediate = IS_IMMEDIATE_EDEFAULT;

    /**
     * The default value of the '{@link #getIsImmediateString() <em>Is Immediate String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIsImmediateString()
     * @generated
     * @ordered
     */
    protected static final String IS_IMMEDIATE_STRING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIsImmediateString() <em>Is Immediate String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIsImmediateString()
     * @generated
     * @ordered
     */
    protected String isImmediateString = IS_IMMEDIATE_STRING_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StrongAbortionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.STRONG_ABORTION;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.STRONG_ABORTION__TRIGGER, oldTrigger, newTrigger);
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
                msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.STRONG_ABORTION__TRIGGER, null, msgs);
            if (newTrigger != null)
                msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ssmPackage.STRONG_ABORTION__TRIGGER, null, msgs);
            msgs = basicSetTrigger(newTrigger, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STRONG_ABORTION__TRIGGER, newTrigger, newTrigger));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STRONG_ABORTION__TRIGGER_STRING, oldTriggerString, triggerString));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsImmediate() {
        return isImmediate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsImmediate(boolean newIsImmediate) {
        boolean oldIsImmediate = isImmediate;
        isImmediate = newIsImmediate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STRONG_ABORTION__IS_IMMEDIATE, oldIsImmediate, isImmediate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getIsImmediateString() {
        return isImmediateString;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsImmediateString(String newIsImmediateString) {
        String oldIsImmediateString = isImmediateString;
        isImmediateString = newIsImmediateString;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.STRONG_ABORTION__IS_IMMEDIATE_STRING, oldIsImmediateString, isImmediateString));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ssmPackage.STRONG_ABORTION__TRIGGER:
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
            case ssmPackage.STRONG_ABORTION__TRIGGER:
                return getTrigger();
            case ssmPackage.STRONG_ABORTION__TRIGGER_STRING:
                return getTriggerString();
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE:
                return isIsImmediate() ? Boolean.TRUE : Boolean.FALSE;
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE_STRING:
                return getIsImmediateString();
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
            case ssmPackage.STRONG_ABORTION__TRIGGER:
                setTrigger((Trigger)newValue);
                return;
            case ssmPackage.STRONG_ABORTION__TRIGGER_STRING:
                setTriggerString((String)newValue);
                return;
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE:
                setIsImmediate(((Boolean)newValue).booleanValue());
                return;
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE_STRING:
                setIsImmediateString((String)newValue);
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
            case ssmPackage.STRONG_ABORTION__TRIGGER:
                setTrigger((Trigger)null);
                return;
            case ssmPackage.STRONG_ABORTION__TRIGGER_STRING:
                setTriggerString(TRIGGER_STRING_EDEFAULT);
                return;
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE:
                setIsImmediate(IS_IMMEDIATE_EDEFAULT);
                return;
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE_STRING:
                setIsImmediateString(IS_IMMEDIATE_STRING_EDEFAULT);
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
            case ssmPackage.STRONG_ABORTION__TRIGGER:
                return trigger != null;
            case ssmPackage.STRONG_ABORTION__TRIGGER_STRING:
                return TRIGGER_STRING_EDEFAULT == null ? triggerString != null : !TRIGGER_STRING_EDEFAULT.equals(triggerString);
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE:
                return isImmediate != IS_IMMEDIATE_EDEFAULT;
            case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE_STRING:
                return IS_IMMEDIATE_STRING_EDEFAULT == null ? isImmediateString != null : !IS_IMMEDIATE_STRING_EDEFAULT.equals(isImmediateString);
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
                case ssmPackage.STRONG_ABORTION__TRIGGER: return ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER;
                case ssmPackage.STRONG_ABORTION__TRIGGER_STRING: return ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER_STRING;
                default: return -1;
            }
        }
        if (baseClass == TransitionImmediateable.class) {
            switch (derivedFeatureID) {
                case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE: return ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE;
                case ssmPackage.STRONG_ABORTION__IS_IMMEDIATE_STRING: return ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING;
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
                case ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER: return ssmPackage.STRONG_ABORTION__TRIGGER;
                case ssmPackage.TRANSITION_TRIGGERABLE__TRIGGER_STRING: return ssmPackage.STRONG_ABORTION__TRIGGER_STRING;
                default: return -1;
            }
        }
        if (baseClass == TransitionImmediateable.class) {
            switch (baseFeatureID) {
                case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE: return ssmPackage.STRONG_ABORTION__IS_IMMEDIATE;
                case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING: return ssmPackage.STRONG_ABORTION__IS_IMMEDIATE_STRING;
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
        result.append(", isImmediate: ");
        result.append(isImmediate);
        result.append(", isImmediateString: ");
        result.append(isImmediateString);
        result.append(')');
        return result.toString();
    }

} //StrongAbortionImpl
