/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.BasicFunctionBlock;
import cakefeed.CakefeedPackage;
import cakefeed.ExecutionControlChart;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Control Chart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.ExecutionControlChartImpl#getParentBasicFunctionBlock <em>Parent Basic Function Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionControlChartImpl extends EObjectImpl implements ExecutionControlChart {
	/**
	 * The cached value of the '{@link #getParentBasicFunctionBlock() <em>Parent Basic Function Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentBasicFunctionBlock()
	 * @generated
	 * @ordered
	 */
	protected BasicFunctionBlock parentBasicFunctionBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionControlChartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.EXECUTION_CONTROL_CHART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionBlock getParentBasicFunctionBlock() {
		if (parentBasicFunctionBlock != null && parentBasicFunctionBlock.eIsProxy()) {
			InternalEObject oldParentBasicFunctionBlock = (InternalEObject)parentBasicFunctionBlock;
			parentBasicFunctionBlock = (BasicFunctionBlock)eResolveProxy(oldParentBasicFunctionBlock);
			if (parentBasicFunctionBlock != oldParentBasicFunctionBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK, oldParentBasicFunctionBlock, parentBasicFunctionBlock));
			}
		}
		return parentBasicFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionBlock basicGetParentBasicFunctionBlock() {
		return parentBasicFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentBasicFunctionBlock(BasicFunctionBlock newParentBasicFunctionBlock) {
		BasicFunctionBlock oldParentBasicFunctionBlock = parentBasicFunctionBlock;
		parentBasicFunctionBlock = newParentBasicFunctionBlock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK, oldParentBasicFunctionBlock, parentBasicFunctionBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				if (resolve) return getParentBasicFunctionBlock();
				return basicGetParentBasicFunctionBlock();
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
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				setParentBasicFunctionBlock((BasicFunctionBlock)newValue);
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
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				setParentBasicFunctionBlock((BasicFunctionBlock)null);
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
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				return parentBasicFunctionBlock != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionControlChartImpl
