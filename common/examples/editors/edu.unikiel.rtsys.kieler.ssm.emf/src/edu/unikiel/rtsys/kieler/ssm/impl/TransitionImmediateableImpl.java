/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.TransitionImmediateable;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Immediateable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImmediateableImpl#isIsImmediate <em>Is Immediate</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImmediateableImpl#getIsImmediateString <em>Is Immediate String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImmediateableImpl extends EObjectImpl implements TransitionImmediateable {
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
    protected TransitionImmediateableImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.TRANSITION_IMMEDIATEABLE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE, oldIsImmediate, isImmediate));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING, oldIsImmediateString, isImmediateString));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE:
                return isIsImmediate() ? Boolean.TRUE : Boolean.FALSE;
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING:
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
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE:
                setIsImmediate(((Boolean)newValue).booleanValue());
                return;
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING:
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
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE:
                setIsImmediate(IS_IMMEDIATE_EDEFAULT);
                return;
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING:
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
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE:
                return isImmediate != IS_IMMEDIATE_EDEFAULT;
            case ssmPackage.TRANSITION_IMMEDIATEABLE__IS_IMMEDIATE_STRING:
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
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (isImmediate: ");
        result.append(isImmediate);
        result.append(", isImmediateString: ");
        result.append(isImmediateString);
        result.append(')');
        return result.toString();
    }

} //TransitionImmediateableImpl
