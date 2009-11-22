/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.CakefeedPackage;
import cakefeed.FunctionBlock;
import cakefeed.Interface;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.InterfaceImpl#getFunctionBlock <em>Function Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceImpl extends EObjectImpl implements Interface {
	/**
	 * The cached value of the '{@link #getFunctionBlock() <em>Function Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionBlock()
	 * @generated
	 * @ordered
	 */
	protected FunctionBlock functionBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionBlock getFunctionBlock() {
		return functionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctionBlock(FunctionBlock newFunctionBlock, NotificationChain msgs) {
		FunctionBlock oldFunctionBlock = functionBlock;
		functionBlock = newFunctionBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.INTERFACE__FUNCTION_BLOCK, oldFunctionBlock, newFunctionBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionBlock(FunctionBlock newFunctionBlock) {
		if (newFunctionBlock != functionBlock) {
			NotificationChain msgs = null;
			if (functionBlock != null)
				msgs = ((InternalEObject)functionBlock).eInverseRemove(this, CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE, FunctionBlock.class, msgs);
			if (newFunctionBlock != null)
				msgs = ((InternalEObject)newFunctionBlock).eInverseAdd(this, CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE, FunctionBlock.class, msgs);
			msgs = basicSetFunctionBlock(newFunctionBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.INTERFACE__FUNCTION_BLOCK, newFunctionBlock, newFunctionBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.INTERFACE__FUNCTION_BLOCK:
				if (functionBlock != null)
					msgs = ((InternalEObject)functionBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.INTERFACE__FUNCTION_BLOCK, null, msgs);
				return basicSetFunctionBlock((FunctionBlock)otherEnd, msgs);
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
			case CakefeedPackage.INTERFACE__FUNCTION_BLOCK:
				return basicSetFunctionBlock(null, msgs);
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
			case CakefeedPackage.INTERFACE__FUNCTION_BLOCK:
				return getFunctionBlock();
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
			case CakefeedPackage.INTERFACE__FUNCTION_BLOCK:
				setFunctionBlock((FunctionBlock)newValue);
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
			case CakefeedPackage.INTERFACE__FUNCTION_BLOCK:
				setFunctionBlock((FunctionBlock)null);
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
			case CakefeedPackage.INTERFACE__FUNCTION_BLOCK:
				return functionBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //InterfaceImpl
