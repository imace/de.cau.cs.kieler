/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.SafeStateMachine;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safe State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.SafeStateMachineImpl#getTop <em>Top</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SafeStateMachineImpl extends NamedImpl implements SafeStateMachine {
    /**
     * The cached value of the '{@link #getTop() <em>Top</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTop()
     * @generated
     * @ordered
     */
    protected CompositeState top;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SafeStateMachineImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.SAFE_STATE_MACHINE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositeState getTop() {
        return top;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTop(CompositeState newTop, NotificationChain msgs) {
        CompositeState oldTop = top;
        top = newTop;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.SAFE_STATE_MACHINE__TOP, oldTop, newTop);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTop(CompositeState newTop) {
        if (newTop != top) {
            NotificationChain msgs = null;
            if (top != null)
                msgs = ((InternalEObject)top).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.SAFE_STATE_MACHINE__TOP, null, msgs);
            if (newTop != null)
                msgs = ((InternalEObject)newTop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ssmPackage.SAFE_STATE_MACHINE__TOP, null, msgs);
            msgs = basicSetTop(newTop, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SAFE_STATE_MACHINE__TOP, newTop, newTop));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ssmPackage.SAFE_STATE_MACHINE__TOP:
                return basicSetTop(null, msgs);
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
            case ssmPackage.SAFE_STATE_MACHINE__TOP:
                return getTop();
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
            case ssmPackage.SAFE_STATE_MACHINE__TOP:
                setTop((CompositeState)newValue);
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
            case ssmPackage.SAFE_STATE_MACHINE__TOP:
                setTop((CompositeState)null);
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
            case ssmPackage.SAFE_STATE_MACHINE__TOP:
                return top != null;
        }
        return super.eIsSet(featureID);
    }

} //SafeStateMachineImpl
