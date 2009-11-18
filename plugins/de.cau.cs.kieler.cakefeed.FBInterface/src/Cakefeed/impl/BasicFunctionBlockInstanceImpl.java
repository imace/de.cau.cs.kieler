/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Cakefeed.impl;

import Cakefeed.Algorithm;
import Cakefeed.BasicFunctionBlock;
import Cakefeed.BasicFunctionBlockInstance;
import Cakefeed.CakefeedPackage;

import de.cau.cs.kieler.synccharts.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Function Block Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cakefeed.impl.BasicFunctionBlockInstanceImpl#getExecutionControlChart <em>Execution Control Chart</em>}</li>
 *   <li>{@link Cakefeed.impl.BasicFunctionBlockInstanceImpl#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link Cakefeed.impl.BasicFunctionBlockInstanceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicFunctionBlockInstanceImpl extends FunctionBlockInstanceImpl implements BasicFunctionBlockInstance {
	/**
	 * The cached value of the '{@link #getExecutionControlChart() <em>Execution Control Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionControlChart()
	 * @generated
	 * @ordered
	 */
	protected State executionControlChart;

	/**
	 * The cached value of the '{@link #getAlgorithms() <em>Algorithms</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithms()
	 * @generated
	 * @ordered
	 */
	protected EList<Algorithm> algorithms;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected BasicFunctionBlock type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicFunctionBlockInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.BASIC_FUNCTION_BLOCK_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getExecutionControlChart() {
		if (executionControlChart != null && executionControlChart.eIsProxy()) {
			InternalEObject oldExecutionControlChart = (InternalEObject)executionControlChart;
			executionControlChart = (State)eResolveProxy(oldExecutionControlChart);
			if (executionControlChart != oldExecutionControlChart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART, oldExecutionControlChart, executionControlChart));
			}
		}
		return executionControlChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetExecutionControlChart() {
		return executionControlChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionControlChart(State newExecutionControlChart) {
		State oldExecutionControlChart = executionControlChart;
		executionControlChart = newExecutionControlChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART, oldExecutionControlChart, executionControlChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Algorithm> getAlgorithms() {
		if (algorithms == null) {
			algorithms = new EObjectResolvingEList<Algorithm>(Algorithm.class, this, CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS);
		}
		return algorithms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionBlock getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (BasicFunctionBlock)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionBlock basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(BasicFunctionBlock newType) {
		BasicFunctionBlock oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART:
				if (resolve) return getExecutionControlChart();
				return basicGetExecutionControlChart();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS:
				return getAlgorithms();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART:
				setExecutionControlChart((State)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS:
				getAlgorithms().clear();
				getAlgorithms().addAll((Collection<? extends Algorithm>)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__TYPE:
				setType((BasicFunctionBlock)newValue);
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART:
				setExecutionControlChart((State)null);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS:
				getAlgorithms().clear();
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__TYPE:
				setType((BasicFunctionBlock)null);
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART:
				return executionControlChart != null;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS:
				return algorithms != null && !algorithms.isEmpty();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BasicFunctionBlock.class) {
			switch (derivedFeatureID) {
				case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART: return CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART;
				case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS: return CakefeedPackage.BASIC_FUNCTION_BLOCK__ALGORITHMS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BasicFunctionBlock.class) {
			switch (baseFeatureID) {
				case CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART: return CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__EXECUTION_CONTROL_CHART;
				case CakefeedPackage.BASIC_FUNCTION_BLOCK__ALGORITHMS: return CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE__ALGORITHMS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //BasicFunctionBlockInstanceImpl
