/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ssm2.Assignment;
import ssm2.Expression;
import ssm2.Ssm2Package;
import ssm2.Variable;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm2.impl.AssignmentImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link ssm2.impl.AssignmentImpl#getParentExpression <em>Parent Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentImpl extends EObjectImpl implements Assignment {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * The cached value of the '{@link #getParentExpression() <em>Parent Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression parentExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ssm2Package.Literals.ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (Variable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ssm2Package.ASSIGNMENT__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.ASSIGNMENT__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getParentExpression() {
		if (parentExpression != null && parentExpression.eIsProxy()) {
			InternalEObject oldParentExpression = (InternalEObject)parentExpression;
			parentExpression = (Expression)eResolveProxy(oldParentExpression);
			if (parentExpression != oldParentExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION, oldParentExpression, parentExpression));
			}
		}
		return parentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetParentExpression() {
		return parentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentExpression(Expression newParentExpression, NotificationChain msgs) {
		Expression oldParentExpression = parentExpression;
		parentExpression = newParentExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION, oldParentExpression, newParentExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentExpression(Expression newParentExpression) {
		if (newParentExpression != parentExpression) {
			NotificationChain msgs = null;
			if (parentExpression != null)
				msgs = ((InternalEObject)parentExpression).eInverseRemove(this, Ssm2Package.EXPRESSION__ASSIGNMENT, Expression.class, msgs);
			if (newParentExpression != null)
				msgs = ((InternalEObject)newParentExpression).eInverseAdd(this, Ssm2Package.EXPRESSION__ASSIGNMENT, Expression.class, msgs);
			msgs = basicSetParentExpression(newParentExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION, newParentExpression, newParentExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION:
				if (parentExpression != null)
					msgs = ((InternalEObject)parentExpression).eInverseRemove(this, Ssm2Package.EXPRESSION__ASSIGNMENT, Expression.class, msgs);
				return basicSetParentExpression((Expression)otherEnd, msgs);
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
			case Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION:
				return basicSetParentExpression(null, msgs);
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
			case Ssm2Package.ASSIGNMENT__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION:
				if (resolve) return getParentExpression();
				return basicGetParentExpression();
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
			case Ssm2Package.ASSIGNMENT__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION:
				setParentExpression((Expression)newValue);
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
			case Ssm2Package.ASSIGNMENT__VARIABLE:
				setVariable((Variable)null);
				return;
			case Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION:
				setParentExpression((Expression)null);
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
			case Ssm2Package.ASSIGNMENT__VARIABLE:
				return variable != null;
			case Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION:
				return parentExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //AssignmentImpl
