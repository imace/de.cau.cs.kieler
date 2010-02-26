/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.BasicFunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.BasicFunctionBlockType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Function Block Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockDiagramImpl#getBFBType <em>BFB Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicFunctionBlockDiagramImpl extends EObjectImpl implements BasicFunctionBlockDiagram {
	/**
	 * The cached value of the '{@link #getBFBType() <em>BFB Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBFBType()
	 * @generated
	 * @ordered
	 */
	protected BasicFunctionBlockType bFBType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicFunctionBlockDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.BASIC_FUNCTION_BLOCK_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionBlockType getBFBType() {
		return bFBType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBFBType(BasicFunctionBlockType newBFBType, NotificationChain msgs) {
		BasicFunctionBlockType oldBFBType = bFBType;
		bFBType = newBFBType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE, oldBFBType, newBFBType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBFBType(BasicFunctionBlockType newBFBType) {
		if (newBFBType != bFBType) {
			NotificationChain msgs = null;
			if (bFBType != null)
				msgs = ((InternalEObject)bFBType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE, null, msgs);
			if (newBFBType != null)
				msgs = ((InternalEObject)newBFBType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE, null, msgs);
			msgs = basicSetBFBType(newBFBType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE, newBFBType, newBFBType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE:
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE:
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE:
				setBFBType((BasicFunctionBlockType)newValue);
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE:
				setBFBType((BasicFunctionBlockType)null);
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_DIAGRAM__BFB_TYPE:
				return bFBType != null;
		}
		return super.eIsSet(featureID);
	}

} //BasicFunctionBlockDiagramImpl
