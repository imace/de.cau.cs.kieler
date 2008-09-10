/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.Signal;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.SignalImpl#getSignalName <em>Signal Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalImpl extends EObjectImpl implements Signal {
    /**
     * The default value of the '{@link #getSignalName() <em>Signal Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSignalName()
     * @generated
     * @ordered
     */
    protected static final String SIGNAL_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSignalName() <em>Signal Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSignalName()
     * @generated
     * @ordered
     */
    protected String signalName = SIGNAL_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SignalImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.SIGNAL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSignalName() {
        return signalName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSignalName(String newSignalName) {
        String oldSignalName = signalName;
        signalName = newSignalName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__SIGNAL_NAME, oldSignalName, signalName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ssmPackage.SIGNAL__SIGNAL_NAME:
                return getSignalName();
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
            case ssmPackage.SIGNAL__SIGNAL_NAME:
                setSignalName((String)newValue);
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
            case ssmPackage.SIGNAL__SIGNAL_NAME:
                setSignalName(SIGNAL_NAME_EDEFAULT);
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
            case ssmPackage.SIGNAL__SIGNAL_NAME:
                return SIGNAL_NAME_EDEFAULT == null ? signalName != null : !SIGNAL_NAME_EDEFAULT.equals(signalName);
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
        result.append(" (signalName: ");
        result.append(signalName);
        result.append(')');
        return result.toString();
    }

} //SignalImpl
