/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.OutputWith;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output With</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.OutputWithImpl#getParentOutputEvent <em>Parent Output Event</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.OutputWithImpl#getWith <em>With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputWithImpl extends WithImpl implements OutputWith {
	/**
	 * The cached value of the '{@link #getWith() <em>With</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWith()
	 * @generated
	 * @ordered
	 */
	protected IFOutputVar with;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputWithImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.OUTPUT_WITH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFOutputEvent getParentOutputEvent() {
		if (eContainerFeatureID() != CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT) return null;
		return (IFOutputEvent)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentOutputEvent(IFOutputEvent newParentOutputEvent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentOutputEvent, CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentOutputEvent(IFOutputEvent newParentOutputEvent) {
		if (newParentOutputEvent != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT && newParentOutputEvent != null)) {
			if (EcoreUtil.isAncestor(this, newParentOutputEvent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentOutputEvent != null)
				msgs = ((InternalEObject)newParentOutputEvent).eInverseAdd(this, CakefeedPackage.IF_OUTPUT_EVENT__WITH, IFOutputEvent.class, msgs);
			msgs = basicSetParentOutputEvent(newParentOutputEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT, newParentOutputEvent, newParentOutputEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFOutputVar getWith() {
		if (with != null && with.eIsProxy()) {
			InternalEObject oldWith = (InternalEObject)with;
			with = (IFOutputVar)eResolveProxy(oldWith);
			if (with != oldWith) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.OUTPUT_WITH__WITH, oldWith, with));
			}
		}
		return with;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFOutputVar basicGetWith() {
		return with;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWith(IFOutputVar newWith) {
		IFOutputVar oldWith = with;
		with = newWith;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.OUTPUT_WITH__WITH, oldWith, with));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentOutputEvent((IFOutputEvent)otherEnd, msgs);
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
			case CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT:
				return basicSetParentOutputEvent(null, msgs);
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
			case CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.IF_OUTPUT_EVENT__WITH, IFOutputEvent.class, msgs);
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
			case CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT:
				return getParentOutputEvent();
			case CakefeedPackage.OUTPUT_WITH__WITH:
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
			case CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT:
				setParentOutputEvent((IFOutputEvent)newValue);
				return;
			case CakefeedPackage.OUTPUT_WITH__WITH:
				setWith((IFOutputVar)newValue);
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
			case CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT:
				setParentOutputEvent((IFOutputEvent)null);
				return;
			case CakefeedPackage.OUTPUT_WITH__WITH:
				setWith((IFOutputVar)null);
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
			case CakefeedPackage.OUTPUT_WITH__PARENT_OUTPUT_EVENT:
				return getParentOutputEvent() != null;
			case CakefeedPackage.OUTPUT_WITH__WITH:
				return with != null;
		}
		return super.eIsSet(featureID);
	}

} //OutputWithImpl
