/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.InputPrimitive;
import de.cau.cs.kieler.cakefeed.OutputPrimitive;
import de.cau.cs.kieler.cakefeed.ServiceTransaction;

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
 * An implementation of the model object '<em><b>Service Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl#getInputPrimitive <em>Input Primitive</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.ServiceTransactionImpl#getOutputPrimitive <em>Output Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceTransactionImpl extends EObjectImpl implements ServiceTransaction {
	/**
	 * The cached value of the '{@link #getInputPrimitive() <em>Input Primitive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPrimitive()
	 * @generated
	 * @ordered
	 */
	protected InputPrimitive inputPrimitive;

	/**
	 * The cached value of the '{@link #getOutputPrimitive() <em>Output Primitive</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPrimitive()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputPrimitive> outputPrimitive;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.SERVICE_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPrimitive getInputPrimitive() {
		return inputPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputPrimitive(InputPrimitive newInputPrimitive, NotificationChain msgs) {
		InputPrimitive oldInputPrimitive = inputPrimitive;
		inputPrimitive = newInputPrimitive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, oldInputPrimitive, newInputPrimitive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputPrimitive(InputPrimitive newInputPrimitive) {
		if (newInputPrimitive != inputPrimitive) {
			NotificationChain msgs = null;
			if (inputPrimitive != null)
				msgs = ((InternalEObject)inputPrimitive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, null, msgs);
			if (newInputPrimitive != null)
				msgs = ((InternalEObject)newInputPrimitive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, null, msgs);
			msgs = basicSetInputPrimitive(newInputPrimitive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, newInputPrimitive, newInputPrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputPrimitive> getOutputPrimitive() {
		if (outputPrimitive == null) {
			outputPrimitive = new EObjectContainmentEList<OutputPrimitive>(OutputPrimitive.class, this, CakefeedPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE);
		}
		return outputPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return basicSetInputPrimitive(null, msgs);
			case CakefeedPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return ((InternalEList<?>)getOutputPrimitive()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return getInputPrimitive();
			case CakefeedPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return getOutputPrimitive();
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
			case CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)newValue);
				return;
			case CakefeedPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				getOutputPrimitive().clear();
				getOutputPrimitive().addAll((Collection<? extends OutputPrimitive>)newValue);
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
			case CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)null);
				return;
			case CakefeedPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				getOutputPrimitive().clear();
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
			case CakefeedPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return inputPrimitive != null;
			case CakefeedPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return outputPrimitive != null && !outputPrimitive.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceTransactionImpl
