/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CFBDiagram;
import de.cau.cs.kieler.cakefeed.CFBType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CFB Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CFBDiagramImpl#getCFBType <em>CFB Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CFBDiagramImpl extends EObjectImpl implements CFBDiagram {
	/**
	 * The cached value of the '{@link #getCFBType() <em>CFB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCFBType()
	 * @generated
	 * @ordered
	 */
	protected CFBType cfbType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CFBDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.CFB_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CFBType getCFBType() {
		return cfbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCFBType(CFBType newCFBType, NotificationChain msgs) {
		CFBType oldCFBType = cfbType;
		cfbType = newCFBType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.CFB_DIAGRAM__CFB_TYPE, oldCFBType, newCFBType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCFBType(CFBType newCFBType) {
		if (newCFBType != cfbType) {
			NotificationChain msgs = null;
			if (cfbType != null)
				msgs = ((InternalEObject)cfbType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.CFB_DIAGRAM__CFB_TYPE, null, msgs);
			if (newCFBType != null)
				msgs = ((InternalEObject)newCFBType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.CFB_DIAGRAM__CFB_TYPE, null, msgs);
			msgs = basicSetCFBType(newCFBType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.CFB_DIAGRAM__CFB_TYPE, newCFBType, newCFBType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.CFB_DIAGRAM__CFB_TYPE:
				return basicSetCFBType(null, msgs);
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
			case CakefeedPackage.CFB_DIAGRAM__CFB_TYPE:
				return getCFBType();
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
			case CakefeedPackage.CFB_DIAGRAM__CFB_TYPE:
				setCFBType((CFBType)newValue);
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
			case CakefeedPackage.CFB_DIAGRAM__CFB_TYPE:
				setCFBType((CFBType)null);
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
			case CakefeedPackage.CFB_DIAGRAM__CFB_TYPE:
				return cfbType != null;
		}
		return super.eIsSet(featureID);
	}

} //CFBDiagramImpl
