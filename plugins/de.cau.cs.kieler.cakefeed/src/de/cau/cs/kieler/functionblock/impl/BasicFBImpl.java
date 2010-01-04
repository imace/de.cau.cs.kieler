/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblock.impl;

import de.cau.cs.kieler.functionblock.Algorithm;
import de.cau.cs.kieler.functionblock.BasicFB;
import de.cau.cs.kieler.functionblock.ECC;
import de.cau.cs.kieler.functionblock.FunctionblockPackage;
import de.cau.cs.kieler.functionblock.HCECC;
import de.cau.cs.kieler.functionblock.InternalVars;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic FB</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.BasicFBImpl#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.BasicFBImpl#getECC <em>ECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.BasicFBImpl#getHCECC <em>HCECC</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblock.impl.BasicFBImpl#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicFBImpl extends EObjectImpl implements BasicFB {
	/**
	 * The cached value of the '{@link #getInternalVars() <em>Internal Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalVars()
	 * @generated
	 * @ordered
	 */
	protected InternalVars internalVars;

	/**
	 * The cached value of the '{@link #getECC() <em>ECC</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getECC()
	 * @generated
	 * @ordered
	 */
	protected ECC eCC;

	/**
	 * The cached value of the '{@link #getHCECC() <em>HCECC</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHCECC()
	 * @generated
	 * @ordered
	 */
	protected HCECC hCECC;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected EList<Algorithm> algorithm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicFBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblockPackage.Literals.BASIC_FB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalVars getInternalVars() {
		return internalVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalVars(InternalVars newInternalVars, NotificationChain msgs) {
		InternalVars oldInternalVars = internalVars;
		internalVars = newInternalVars;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblockPackage.BASIC_FB__INTERNAL_VARS, oldInternalVars, newInternalVars);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalVars(InternalVars newInternalVars) {
		if (newInternalVars != internalVars) {
			NotificationChain msgs = null;
			if (internalVars != null)
				msgs = ((InternalEObject)internalVars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.BASIC_FB__INTERNAL_VARS, null, msgs);
			if (newInternalVars != null)
				msgs = ((InternalEObject)newInternalVars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.BASIC_FB__INTERNAL_VARS, null, msgs);
			msgs = basicSetInternalVars(newInternalVars, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.BASIC_FB__INTERNAL_VARS, newInternalVars, newInternalVars));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECC getECC() {
		return eCC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetECC(ECC newECC, NotificationChain msgs) {
		ECC oldECC = eCC;
		eCC = newECC;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblockPackage.BASIC_FB__ECC, oldECC, newECC);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setECC(ECC newECC) {
		if (newECC != eCC) {
			NotificationChain msgs = null;
			if (eCC != null)
				msgs = ((InternalEObject)eCC).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.BASIC_FB__ECC, null, msgs);
			if (newECC != null)
				msgs = ((InternalEObject)newECC).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.BASIC_FB__ECC, null, msgs);
			msgs = basicSetECC(newECC, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.BASIC_FB__ECC, newECC, newECC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HCECC getHCECC() {
		return hCECC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHCECC(HCECC newHCECC, NotificationChain msgs) {
		HCECC oldHCECC = hCECC;
		hCECC = newHCECC;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblockPackage.BASIC_FB__HCECC, oldHCECC, newHCECC);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHCECC(HCECC newHCECC) {
		if (newHCECC != hCECC) {
			NotificationChain msgs = null;
			if (hCECC != null)
				msgs = ((InternalEObject)hCECC).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.BASIC_FB__HCECC, null, msgs);
			if (newHCECC != null)
				msgs = ((InternalEObject)newHCECC).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblockPackage.BASIC_FB__HCECC, null, msgs);
			msgs = basicSetHCECC(newHCECC, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblockPackage.BASIC_FB__HCECC, newHCECC, newHCECC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Algorithm> getAlgorithm() {
		if (algorithm == null) {
			algorithm = new EObjectContainmentEList<Algorithm>(Algorithm.class, this, FunctionblockPackage.BASIC_FB__ALGORITHM);
		}
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblockPackage.BASIC_FB__INTERNAL_VARS:
				return basicSetInternalVars(null, msgs);
			case FunctionblockPackage.BASIC_FB__ECC:
				return basicSetECC(null, msgs);
			case FunctionblockPackage.BASIC_FB__HCECC:
				return basicSetHCECC(null, msgs);
			case FunctionblockPackage.BASIC_FB__ALGORITHM:
				return ((InternalEList<?>)getAlgorithm()).basicRemove(otherEnd, msgs);
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
			case FunctionblockPackage.BASIC_FB__INTERNAL_VARS:
				return getInternalVars();
			case FunctionblockPackage.BASIC_FB__ECC:
				return getECC();
			case FunctionblockPackage.BASIC_FB__HCECC:
				return getHCECC();
			case FunctionblockPackage.BASIC_FB__ALGORITHM:
				return getAlgorithm();
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
			case FunctionblockPackage.BASIC_FB__INTERNAL_VARS:
				setInternalVars((InternalVars)newValue);
				return;
			case FunctionblockPackage.BASIC_FB__ECC:
				setECC((ECC)newValue);
				return;
			case FunctionblockPackage.BASIC_FB__HCECC:
				setHCECC((HCECC)newValue);
				return;
			case FunctionblockPackage.BASIC_FB__ALGORITHM:
				getAlgorithm().clear();
				getAlgorithm().addAll((Collection<? extends Algorithm>)newValue);
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
			case FunctionblockPackage.BASIC_FB__INTERNAL_VARS:
				setInternalVars((InternalVars)null);
				return;
			case FunctionblockPackage.BASIC_FB__ECC:
				setECC((ECC)null);
				return;
			case FunctionblockPackage.BASIC_FB__HCECC:
				setHCECC((HCECC)null);
				return;
			case FunctionblockPackage.BASIC_FB__ALGORITHM:
				getAlgorithm().clear();
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
			case FunctionblockPackage.BASIC_FB__INTERNAL_VARS:
				return internalVars != null;
			case FunctionblockPackage.BASIC_FB__ECC:
				return eCC != null;
			case FunctionblockPackage.BASIC_FB__HCECC:
				return hCECC != null;
			case FunctionblockPackage.BASIC_FB__ALGORITHM:
				return algorithm != null && !algorithm.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BasicFBImpl
