/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.Signal;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl#getLocalSignals <em>Local Signals</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl#getInputSignals <em>Input Signals</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.CompositeStateImpl#getOutputSignals <em>Output Signals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeStateImpl extends SimpleStateImpl implements CompositeState {
    /**
     * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRegions()
     * @generated
     * @ordered
     */
    protected EList<Region> regions;

    /**
     * The cached value of the '{@link #getLocalSignals() <em>Local Signals</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalSignals()
     * @generated
     * @ordered
     */
    protected EList<Signal> localSignals;

    /**
     * The cached value of the '{@link #getInputSignals() <em>Input Signals</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputSignals()
     * @generated
     * @ordered
     */
    protected EList<Signal> inputSignals;

    /**
     * The cached value of the '{@link #getOutputSignals() <em>Output Signals</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputSignals()
     * @generated
     * @ordered
     */
    protected EList<Signal> outputSignals;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CompositeStateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.COMPOSITE_STATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Region> getRegions() {
        if (regions == null) {
            regions = new EObjectContainmentEList<Region>(Region.class, this, ssmPackage.COMPOSITE_STATE__REGIONS);
        }
        return regions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Signal> getLocalSignals() {
        if (localSignals == null) {
            localSignals = new EObjectContainmentEList<Signal>(Signal.class, this, ssmPackage.COMPOSITE_STATE__LOCAL_SIGNALS);
        }
        return localSignals;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Signal> getInputSignals() {
        if (inputSignals == null) {
            inputSignals = new EObjectContainmentEList<Signal>(Signal.class, this, ssmPackage.COMPOSITE_STATE__INPUT_SIGNALS);
        }
        return inputSignals;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Signal> getOutputSignals() {
        if (outputSignals == null) {
            outputSignals = new EObjectContainmentEList<Signal>(Signal.class, this, ssmPackage.COMPOSITE_STATE__OUTPUT_SIGNALS);
        }
        return outputSignals;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ssmPackage.COMPOSITE_STATE__REGIONS:
                return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
            case ssmPackage.COMPOSITE_STATE__LOCAL_SIGNALS:
                return ((InternalEList<?>)getLocalSignals()).basicRemove(otherEnd, msgs);
            case ssmPackage.COMPOSITE_STATE__INPUT_SIGNALS:
                return ((InternalEList<?>)getInputSignals()).basicRemove(otherEnd, msgs);
            case ssmPackage.COMPOSITE_STATE__OUTPUT_SIGNALS:
                return ((InternalEList<?>)getOutputSignals()).basicRemove(otherEnd, msgs);
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
            case ssmPackage.COMPOSITE_STATE__REGIONS:
                return getRegions();
            case ssmPackage.COMPOSITE_STATE__LOCAL_SIGNALS:
                return getLocalSignals();
            case ssmPackage.COMPOSITE_STATE__INPUT_SIGNALS:
                return getInputSignals();
            case ssmPackage.COMPOSITE_STATE__OUTPUT_SIGNALS:
                return getOutputSignals();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ssmPackage.COMPOSITE_STATE__REGIONS:
                getRegions().clear();
                getRegions().addAll((Collection<? extends Region>)newValue);
                return;
            case ssmPackage.COMPOSITE_STATE__LOCAL_SIGNALS:
                getLocalSignals().clear();
                getLocalSignals().addAll((Collection<? extends Signal>)newValue);
                return;
            case ssmPackage.COMPOSITE_STATE__INPUT_SIGNALS:
                getInputSignals().clear();
                getInputSignals().addAll((Collection<? extends Signal>)newValue);
                return;
            case ssmPackage.COMPOSITE_STATE__OUTPUT_SIGNALS:
                getOutputSignals().clear();
                getOutputSignals().addAll((Collection<? extends Signal>)newValue);
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
            case ssmPackage.COMPOSITE_STATE__REGIONS:
                getRegions().clear();
                return;
            case ssmPackage.COMPOSITE_STATE__LOCAL_SIGNALS:
                getLocalSignals().clear();
                return;
            case ssmPackage.COMPOSITE_STATE__INPUT_SIGNALS:
                getInputSignals().clear();
                return;
            case ssmPackage.COMPOSITE_STATE__OUTPUT_SIGNALS:
                getOutputSignals().clear();
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
            case ssmPackage.COMPOSITE_STATE__REGIONS:
                return regions != null && !regions.isEmpty();
            case ssmPackage.COMPOSITE_STATE__LOCAL_SIGNALS:
                return localSignals != null && !localSignals.isEmpty();
            case ssmPackage.COMPOSITE_STATE__INPUT_SIGNALS:
                return inputSignals != null && !inputSignals.isEmpty();
            case ssmPackage.COMPOSITE_STATE__OUTPUT_SIGNALS:
                return outputSignals != null && !outputSignals.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //CompositeStateImpl
