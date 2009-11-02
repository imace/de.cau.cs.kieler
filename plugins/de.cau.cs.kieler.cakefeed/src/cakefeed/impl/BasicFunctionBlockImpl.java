/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.Algorithm;
import cakefeed.BasicFunctionBlock;
import cakefeed.CakefeedPackage;

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
 * An implementation of the model object '<em><b>Basic Function Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.BasicFunctionBlockImpl#getExecutionControlChart <em>Execution Control Chart</em>}</li>
 *   <li>{@link cakefeed.impl.BasicFunctionBlockImpl#getAlgorithms <em>Algorithms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicFunctionBlockImpl extends FunctionBlockImpl implements BasicFunctionBlock {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicFunctionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.BASIC_FUNCTION_BLOCK;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART, oldExecutionControlChart, executionControlChart));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART, oldExecutionControlChart, executionControlChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Algorithm> getAlgorithms() {
		if (algorithms == null) {
			algorithms = new EObjectResolvingEList<Algorithm>(Algorithm.class, this, CakefeedPackage.BASIC_FUNCTION_BLOCK__ALGORITHMS);
		}
		return algorithms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART:
				if (resolve) return getExecutionControlChart();
				return basicGetExecutionControlChart();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__ALGORITHMS:
				return getAlgorithms();
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART:
				setExecutionControlChart((State)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__ALGORITHMS:
				getAlgorithms().clear();
				getAlgorithms().addAll((Collection<? extends Algorithm>)newValue);
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART:
				setExecutionControlChart((State)null);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__ALGORITHMS:
				getAlgorithms().clear();
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART:
				return executionControlChart != null;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK__ALGORITHMS:
				return algorithms != null && !algorithms.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BasicFunctionBlockImpl
