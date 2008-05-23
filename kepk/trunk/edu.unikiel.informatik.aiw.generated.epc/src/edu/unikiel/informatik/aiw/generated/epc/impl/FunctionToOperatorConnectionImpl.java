/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.impl;

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.Function;
import edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection;
import edu.unikiel.informatik.aiw.generated.epc.LogicalOperator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function To Operator Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.impl.FunctionToOperatorConnectionImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.unikiel.informatik.aiw.generated.epc.impl.FunctionToOperatorConnectionImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionToOperatorConnectionImpl extends EObjectImpl implements FunctionToOperatorConnection {
	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected Function function;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected LogicalOperator operator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionToOperatorConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EpcPackage.Literals.FUNCTION_TO_OPERATOR_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject)function;
			function = (Function)eResolveProxy(oldFunction);
			if (function != oldFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION, oldFunction, function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		Function oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOperator getOperator() {
		if (operator != null && operator.eIsProxy()) {
			InternalEObject oldOperator = (InternalEObject)operator;
			operator = (LogicalOperator)eResolveProxy(oldOperator);
			if (operator != oldOperator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR, oldOperator, operator));
			}
		}
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOperator basicGetOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(LogicalOperator newOperator) {
		LogicalOperator oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION:
				if (resolve) return getFunction();
				return basicGetFunction();
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR:
				if (resolve) return getOperator();
				return basicGetOperator();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION:
				setFunction((Function)newValue);
				return;
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR:
				setOperator((LogicalOperator)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION:
				setFunction((Function)null);
				return;
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR:
				setOperator((LogicalOperator)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION:
				return function != null;
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR:
				return operator != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionToOperatorConnectionImpl
