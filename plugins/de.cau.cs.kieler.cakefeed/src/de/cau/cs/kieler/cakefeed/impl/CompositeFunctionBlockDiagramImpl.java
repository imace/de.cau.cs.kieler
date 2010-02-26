/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.CompositeFunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.CompositeFunctionBlockType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Function Block Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.CompositeFunctionBlockDiagramImpl#getCFBType <em>CFB Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeFunctionBlockDiagramImpl extends EObjectImpl implements CompositeFunctionBlockDiagram {
	/**
	 * The cached value of the '{@link #getCFBType() <em>CFB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCFBType()
	 * @generated
	 * @ordered
	 */
	protected CompositeFunctionBlockType cFBType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeFunctionBlockDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.COMPOSITE_FUNCTION_BLOCK_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeFunctionBlockType getCFBType() {
		return cFBType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCFBType(CompositeFunctionBlockType newCFBType, NotificationChain msgs) {
		CompositeFunctionBlockType oldCFBType = cFBType;
		cFBType = newCFBType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE, oldCFBType, newCFBType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCFBType(CompositeFunctionBlockType newCFBType) {
		if (newCFBType != cFBType) {
			NotificationChain msgs = null;
			if (cFBType != null)
				msgs = ((InternalEObject)cFBType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE, null, msgs);
			if (newCFBType != null)
				msgs = ((InternalEObject)newCFBType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE, null, msgs);
			msgs = basicSetCFBType(newCFBType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE, newCFBType, newCFBType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE:
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE:
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE:
				setCFBType((CompositeFunctionBlockType)newValue);
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE:
				setCFBType((CompositeFunctionBlockType)null);
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
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_DIAGRAM__CFB_TYPE:
				return cFBType != null;
		}
		return super.eIsSet(featureID);
	}

} //CompositeFunctionBlockDiagramImpl
