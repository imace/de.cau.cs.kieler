/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.SubAppEvent;
import de.cau.cs.kieler.functionblocks.SubAppEventInputs;

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
 * An implementation of the model object '<em><b>Sub App Event Inputs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppEventInputsImpl#getSubAppEvent <em>Sub App Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubAppEventInputsImpl extends EObjectImpl implements SubAppEventInputs {
	/**
	 * The cached value of the '{@link #getSubAppEvent() <em>Sub App Event</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubAppEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<SubAppEvent> subAppEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubAppEventInputsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.SUB_APP_EVENT_INPUTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubAppEvent> getSubAppEvent() {
		if (subAppEvent == null) {
			subAppEvent = new EObjectContainmentEList<SubAppEvent>(SubAppEvent.class, this, FunctionblocksPackage.SUB_APP_EVENT_INPUTS__SUB_APP_EVENT);
		}
		return subAppEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.SUB_APP_EVENT_INPUTS__SUB_APP_EVENT:
				return ((InternalEList<?>)getSubAppEvent()).basicRemove(otherEnd, msgs);
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
			case FunctionblocksPackage.SUB_APP_EVENT_INPUTS__SUB_APP_EVENT:
				return getSubAppEvent();
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
			case FunctionblocksPackage.SUB_APP_EVENT_INPUTS__SUB_APP_EVENT:
				getSubAppEvent().clear();
				getSubAppEvent().addAll((Collection<? extends SubAppEvent>)newValue);
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
			case FunctionblocksPackage.SUB_APP_EVENT_INPUTS__SUB_APP_EVENT:
				getSubAppEvent().clear();
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
			case FunctionblocksPackage.SUB_APP_EVENT_INPUTS__SUB_APP_EVENT:
				return subAppEvent != null && !subAppEvent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubAppEventInputsImpl
