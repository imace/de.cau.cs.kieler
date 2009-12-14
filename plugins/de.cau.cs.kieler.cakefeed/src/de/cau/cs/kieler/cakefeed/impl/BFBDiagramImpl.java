/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.BFBDiagram;
import de.cau.cs.kieler.cakefeed.BFBType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BFB Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BFBDiagramImpl#getBFBType <em>BFB Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BFBDiagramImpl extends EObjectImpl implements BFBDiagram {
	/**
	 * The cached value of the '{@link #getBFBType() <em>BFB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBFBType()
	 * @generated
	 * @ordered
	 */
	protected BFBType bfbType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BFBDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.BFB_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BFBType getBFBType() {
		return bfbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBFBType(BFBType newBFBType, NotificationChain msgs) {
		BFBType oldBFBType = bfbType;
		bfbType = newBFBType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.BFB_DIAGRAM__BFB_TYPE, oldBFBType, newBFBType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBFBType(BFBType newBFBType) {
		if (newBFBType != bfbType) {
			NotificationChain msgs = null;
			if (bfbType != null)
				msgs = ((InternalEObject)bfbType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BFB_DIAGRAM__BFB_TYPE, null, msgs);
			if (newBFBType != null)
				msgs = ((InternalEObject)newBFBType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BFB_DIAGRAM__BFB_TYPE, null, msgs);
			msgs = basicSetBFBType(newBFBType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BFB_DIAGRAM__BFB_TYPE, newBFBType, newBFBType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.BFB_DIAGRAM__BFB_TYPE:
				return basicSetBFBType(null, msgs);
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
			case CakefeedPackage.BFB_DIAGRAM__BFB_TYPE:
				return getBFBType();
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
			case CakefeedPackage.BFB_DIAGRAM__BFB_TYPE:
				setBFBType((BFBType)newValue);
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
			case CakefeedPackage.BFB_DIAGRAM__BFB_TYPE:
				setBFBType((BFBType)null);
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
			case CakefeedPackage.BFB_DIAGRAM__BFB_TYPE:
				return bfbType != null;
		}
		return super.eIsSet(featureID);
	}

} //BFBDiagramImpl
