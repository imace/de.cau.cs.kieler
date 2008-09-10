/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.Named;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;
import edu.unikiel.rtsys.kieler.ssm.StateFlag;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.SimpleStateImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.SimpleStateImpl#getStateFlag <em>State Flag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleStateImpl extends AbstractStateImpl implements SimpleState {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getStateFlag() <em>State Flag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStateFlag()
     * @generated
     * @ordered
     */
    protected static final StateFlag STATE_FLAG_EDEFAULT = StateFlag.NORMAL;

    /**
     * The cached value of the '{@link #getStateFlag() <em>State Flag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStateFlag()
     * @generated
     * @ordered
     */
    protected StateFlag stateFlag = STATE_FLAG_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SimpleStateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.SIMPLE_STATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIMPLE_STATE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StateFlag getStateFlag() {
        return stateFlag;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStateFlag(StateFlag newStateFlag) {
        StateFlag oldStateFlag = stateFlag;
        stateFlag = newStateFlag == null ? STATE_FLAG_EDEFAULT : newStateFlag;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIMPLE_STATE__STATE_FLAG, oldStateFlag, stateFlag));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ssmPackage.SIMPLE_STATE__NAME:
                return getName();
            case ssmPackage.SIMPLE_STATE__STATE_FLAG:
                return getStateFlag();
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
            case ssmPackage.SIMPLE_STATE__NAME:
                setName((String)newValue);
                return;
            case ssmPackage.SIMPLE_STATE__STATE_FLAG:
                setStateFlag((StateFlag)newValue);
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
            case ssmPackage.SIMPLE_STATE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ssmPackage.SIMPLE_STATE__STATE_FLAG:
                setStateFlag(STATE_FLAG_EDEFAULT);
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
            case ssmPackage.SIMPLE_STATE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ssmPackage.SIMPLE_STATE__STATE_FLAG:
                return stateFlag != STATE_FLAG_EDEFAULT;
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
        if (baseClass == Named.class) {
            switch (derivedFeatureID) {
                case ssmPackage.SIMPLE_STATE__NAME: return ssmPackage.NAMED__NAME;
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
        if (baseClass == Named.class) {
            switch (baseFeatureID) {
                case ssmPackage.NAMED__NAME: return ssmPackage.SIMPLE_STATE__NAME;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", stateFlag: ");
        result.append(stateFlag);
        result.append(')');
        return result.toString();
    }

} //SimpleStateImpl
