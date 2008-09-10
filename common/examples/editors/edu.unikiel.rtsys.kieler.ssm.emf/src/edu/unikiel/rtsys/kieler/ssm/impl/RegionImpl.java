/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.AbstractState;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.Transition;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.RegionImpl#getStates <em>States</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.RegionImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegionImpl extends EObjectImpl implements Region {
    /**
     * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStates()
     * @generated
     * @ordered
     */
    protected EList<AbstractState> states;

    /**
     * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTransitions()
     * @generated
     * @ordered
     */
    protected EList<Transition> transitions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ssmPackage.Literals.REGION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AbstractState> getStates() {
        if (states == null) {
            states = new EObjectContainmentEList<AbstractState>(AbstractState.class, this, ssmPackage.REGION__STATES);
        }
        return states;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transition> getTransitions() {
        if (transitions == null) {
            transitions = new EObjectContainmentEList<Transition>(Transition.class, this, ssmPackage.REGION__TRANSITIONS);
        }
        return transitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ssmPackage.REGION__STATES:
                return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
            case ssmPackage.REGION__TRANSITIONS:
                return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
            case ssmPackage.REGION__STATES:
                return getStates();
            case ssmPackage.REGION__TRANSITIONS:
                return getTransitions();
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
            case ssmPackage.REGION__STATES:
                getStates().clear();
                getStates().addAll((Collection<? extends AbstractState>)newValue);
                return;
            case ssmPackage.REGION__TRANSITIONS:
                getTransitions().clear();
                getTransitions().addAll((Collection<? extends Transition>)newValue);
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
            case ssmPackage.REGION__STATES:
                getStates().clear();
                return;
            case ssmPackage.REGION__TRANSITIONS:
                getTransitions().clear();
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
            case ssmPackage.REGION__STATES:
                return states != null && !states.isEmpty();
            case ssmPackage.REGION__TRANSITIONS:
                return transitions != null && !transitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RegionImpl
