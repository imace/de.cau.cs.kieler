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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

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
		if (eContainerFeatureID() != CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK) return null;
		return (BasicFunctionBlock)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentBasicFunctionBlock(BasicFunctionBlock newParentBasicFunctionBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentBasicFunctionBlock, CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentBasicFunctionBlock(BasicFunctionBlock newParentBasicFunctionBlock) {
		if (newParentBasicFunctionBlock != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK && newParentBasicFunctionBlock != null)) {
			if (EcoreUtil.isAncestor(this, newParentBasicFunctionBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentBasicFunctionBlock != null)
				msgs = ((InternalEObject)newParentBasicFunctionBlock).eInverseAdd(this, CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART, BasicFunctionBlock.class, msgs);
			msgs = basicSetParentBasicFunctionBlock(newParentBasicFunctionBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK, newParentBasicFunctionBlock, newParentBasicFunctionBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentBasicFunctionBlock((BasicFunctionBlock)otherEnd, msgs);
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
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				return basicSetParentBasicFunctionBlock(null, msgs);
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
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART, BasicFunctionBlock.class, msgs);
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
			case CakefeedPackage.EXECUTION_CONTROL_CHART__PARENT_BASIC_FUNCTION_BLOCK:
				return getParentBasicFunctionBlock();
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
				return getParentBasicFunctionBlock() != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionControlChartImpl
