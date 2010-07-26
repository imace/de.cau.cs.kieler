/**
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 * 
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.core.expressions.impl;

import de.cau.cs.kieler.core.expressions.CombineOperator;
import de.cau.cs.kieler.core.expressions.ExpressionsPackage;
import de.cau.cs.kieler.core.expressions.Signal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.core.expressions.impl.SignalImpl#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.expressions.impl.SignalImpl#isIsOutput <em>Is Output</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.expressions.impl.SignalImpl#getCombineOperator <em>Combine Operator</em>}</li>
 *   <li>{@link de.cau.cs.kieler.core.expressions.impl.SignalImpl#getHostCombineOperator <em>Host Combine Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalImpl extends ValuedObjectImpl implements Signal {
    /**
     * The default value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsInput()
     * @generated
     * @ordered
     */
    protected static final boolean IS_INPUT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsInput()
     * @generated
     * @ordered
     */
    protected boolean isInput = IS_INPUT_EDEFAULT;

    /**
     * The default value of the '{@link #isIsOutput() <em>Is Output</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsOutput()
     * @generated
     * @ordered
     */
    protected static final boolean IS_OUTPUT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsOutput() <em>Is Output</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsOutput()
     * @generated
     * @ordered
     */
    protected boolean isOutput = IS_OUTPUT_EDEFAULT;

    /**
     * The default value of the '{@link #getCombineOperator() <em>Combine Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCombineOperator()
     * @generated
     * @ordered
     */
    protected static final CombineOperator COMBINE_OPERATOR_EDEFAULT = CombineOperator.NONE;

    /**
     * The cached value of the '{@link #getCombineOperator() <em>Combine Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCombineOperator()
     * @generated
     * @ordered
     */
    protected CombineOperator combineOperator = COMBINE_OPERATOR_EDEFAULT;

    /**
     * The default value of the '{@link #getHostCombineOperator() <em>Host Combine Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHostCombineOperator()
     * @generated
     * @ordered
     */
    protected static final String HOST_COMBINE_OPERATOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHostCombineOperator() <em>Host Combine Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHostCombineOperator()
     * @generated
     * @ordered
     */
    protected String hostCombineOperator = HOST_COMBINE_OPERATOR_EDEFAULT;

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
        return ExpressionsPackage.Literals.SIGNAL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsInput() {
        return isInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsInput(boolean newIsInput) {
        boolean oldIsInput = isInput;
        isInput = newIsInput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SIGNAL__IS_INPUT, oldIsInput, isInput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsOutput() {
        return isOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsOutput(boolean newIsOutput) {
        boolean oldIsOutput = isOutput;
        isOutput = newIsOutput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SIGNAL__IS_OUTPUT, oldIsOutput, isOutput));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CombineOperator getCombineOperator() {
        return combineOperator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCombineOperator(CombineOperator newCombineOperator) {
        CombineOperator oldCombineOperator = combineOperator;
        combineOperator = newCombineOperator == null ? COMBINE_OPERATOR_EDEFAULT : newCombineOperator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SIGNAL__COMBINE_OPERATOR, oldCombineOperator, combineOperator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHostCombineOperator() {
        return hostCombineOperator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHostCombineOperator(String newHostCombineOperator) {
        String oldHostCombineOperator = hostCombineOperator;
        hostCombineOperator = newHostCombineOperator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SIGNAL__HOST_COMBINE_OPERATOR, oldHostCombineOperator, hostCombineOperator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.SIGNAL__IS_INPUT:
                return isIsInput();
            case ExpressionsPackage.SIGNAL__IS_OUTPUT:
                return isIsOutput();
            case ExpressionsPackage.SIGNAL__COMBINE_OPERATOR:
                return getCombineOperator();
            case ExpressionsPackage.SIGNAL__HOST_COMBINE_OPERATOR:
                return getHostCombineOperator();
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
            case ExpressionsPackage.SIGNAL__IS_INPUT:
                setIsInput((Boolean)newValue);
                return;
            case ExpressionsPackage.SIGNAL__IS_OUTPUT:
                setIsOutput((Boolean)newValue);
                return;
            case ExpressionsPackage.SIGNAL__COMBINE_OPERATOR:
                setCombineOperator((CombineOperator)newValue);
                return;
            case ExpressionsPackage.SIGNAL__HOST_COMBINE_OPERATOR:
                setHostCombineOperator((String)newValue);
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
            case ExpressionsPackage.SIGNAL__IS_INPUT:
                setIsInput(IS_INPUT_EDEFAULT);
                return;
            case ExpressionsPackage.SIGNAL__IS_OUTPUT:
                setIsOutput(IS_OUTPUT_EDEFAULT);
                return;
            case ExpressionsPackage.SIGNAL__COMBINE_OPERATOR:
                setCombineOperator(COMBINE_OPERATOR_EDEFAULT);
                return;
            case ExpressionsPackage.SIGNAL__HOST_COMBINE_OPERATOR:
                setHostCombineOperator(HOST_COMBINE_OPERATOR_EDEFAULT);
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
            case ExpressionsPackage.SIGNAL__IS_INPUT:
                return isInput != IS_INPUT_EDEFAULT;
            case ExpressionsPackage.SIGNAL__IS_OUTPUT:
                return isOutput != IS_OUTPUT_EDEFAULT;
            case ExpressionsPackage.SIGNAL__COMBINE_OPERATOR:
                return combineOperator != COMBINE_OPERATOR_EDEFAULT;
            case ExpressionsPackage.SIGNAL__HOST_COMBINE_OPERATOR:
                return HOST_COMBINE_OPERATOR_EDEFAULT == null ? hostCombineOperator != null : !HOST_COMBINE_OPERATOR_EDEFAULT.equals(hostCombineOperator);
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
        result.append(" (isInput: ");
        result.append(isInput);
        result.append(", isOutput: ");
        result.append(isOutput);
        result.append(", combineOperator: ");
        result.append(combineOperator);
        result.append(", hostCombineOperator: ");
        result.append(hostCombineOperator);
        result.append(')');
        return result.toString();
    }

} //SignalImpl
