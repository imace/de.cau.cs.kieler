/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.InputEvent;
import de.cau.cs.kieler.cakefeed.InputVar;
import de.cau.cs.kieler.cakefeed.InputWith;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input With</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.InputWithImpl#getParentInputEvent <em>Parent Input Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.InputWithImpl#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputWithImpl extends WithImpl implements InputWith {
	/**
	 * The cached value of the '{@link #getWith() <em>With</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWith()
	 * @generated
	 * @ordered
	 */
	protected InputVar with;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputWithImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.INPUT_WITH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEvent getParentInputEvent() {
		if (eContainerFeatureID() != CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT) return null;
		return (InputEvent)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentInputEvent(InputEvent newParentInputEvent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentInputEvent, CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentInputEvent(InputEvent newParentInputEvent) {
		if (newParentInputEvent != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT && newParentInputEvent != null)) {
			if (EcoreUtil.isAncestor(this, newParentInputEvent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentInputEvent != null)
				msgs = ((InternalEObject)newParentInputEvent).eInverseAdd(this, CakefeedPackage.INPUT_EVENT__WITH, InputEvent.class, msgs);
			msgs = basicSetParentInputEvent(newParentInputEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT, newParentInputEvent, newParentInputEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVar getWith() {
		if (with != null && with.eIsProxy()) {
			InternalEObject oldWith = (InternalEObject)with;
			with = (InputVar)eResolveProxy(oldWith);
			if (with != oldWith) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.INPUT_WITH__WITH, oldWith, with));
			}
		}
		return with;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVar basicGetWith() {
		return with;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWith(InputVar newWith) {
		InputVar oldWith = with;
		with = newWith;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.INPUT_WITH__WITH, oldWith, with));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentInputEvent((InputEvent)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT:
				return basicSetParentInputEvent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.INPUT_EVENT__WITH, InputEvent.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT:
				return getParentInputEvent();
			case CakefeedPackage.INPUT_WITH__WITH:
				if (resolve) return getWith();
				return basicGetWith();
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
			case CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT:
				setParentInputEvent((InputEvent)newValue);
				return;
			case CakefeedPackage.INPUT_WITH__WITH:
				setWith((InputVar)newValue);
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
			case CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT:
				setParentInputEvent((InputEvent)null);
				return;
			case CakefeedPackage.INPUT_WITH__WITH:
				setWith((InputVar)null);
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
			case CakefeedPackage.INPUT_WITH__PARENT_INPUT_EVENT:
				return getParentInputEvent() != null;
			case CakefeedPackage.INPUT_WITH__WITH:
				return with != null;
		}
		return super.eIsSet(featureID);
	}

} //InputWithImpl
