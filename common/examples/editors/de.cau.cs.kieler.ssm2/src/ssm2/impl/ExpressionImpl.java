/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import ssm2.Action;
import ssm2.Assignment;
import ssm2.Emission;
import ssm2.Expression;
import ssm2.Operator;
import ssm2.Signal;
import ssm2.Ssm2Package;
import ssm2.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm2.impl.ExpressionImpl#getSubExpressions <em>Sub Expressions</em>}</li>
 *   <li>{@link ssm2.impl.ExpressionImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link ssm2.impl.ExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link ssm2.impl.ExpressionImpl#getParentExpression <em>Parent Expression</em>}</li>
 *   <li>{@link ssm2.impl.ExpressionImpl#getParentAction <em>Parent Action</em>}</li>
 *   <li>{@link ssm2.impl.ExpressionImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link ssm2.impl.ExpressionImpl#getParentEmisson <em>Parent Emisson</em>}</li>
 *   <li>{@link ssm2.impl.ExpressionImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends EObjectImpl implements Expression {
	/**
	 * The cached value of the '{@link #getSubExpressions() <em>Sub Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> subExpressions;

	/**
	 * The cached value of the '{@link #getSignal() <em>Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected Signal signal;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected Operator operator;

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
	 * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignment()
	 * @generated
	 * @ordered
	 */
	protected Assignment assignment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ssm2Package.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getSubExpressions() {
		if (subExpressions == null) {
			subExpressions = new EObjectContainmentWithInverseEList<Expression>(Expression.class, this, Ssm2Package.EXPRESSION__SUB_EXPRESSIONS, Ssm2Package.EXPRESSION__PARENT_EXPRESSION);
		}
		return subExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getSignal() {
		if (signal != null && signal.eIsProxy()) {
			InternalEObject oldSignal = (InternalEObject)signal;
			signal = (Signal)eResolveProxy(oldSignal);
			if (signal != oldSignal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ssm2Package.EXPRESSION__SIGNAL, oldSignal, signal));
			}
		}
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal basicGetSignal() {
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignal(Signal newSignal) {
		Signal oldSignal = signal;
		signal = newSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__SIGNAL, oldSignal, signal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperator(Operator newOperator, NotificationChain msgs) {
		Operator oldOperator = operator;
		operator = newOperator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__OPERATOR, oldOperator, newOperator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(Operator newOperator) {
		if (newOperator != operator) {
			NotificationChain msgs = null;
			if (operator != null)
				msgs = ((InternalEObject)operator).eInverseRemove(this, Ssm2Package.OPERATOR__PARENT_EXPRESSION, Operator.class, msgs);
			if (newOperator != null)
				msgs = ((InternalEObject)newOperator).eInverseAdd(this, Ssm2Package.OPERATOR__PARENT_EXPRESSION, Operator.class, msgs);
			msgs = basicSetOperator(newOperator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__OPERATOR, newOperator, newOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getParentExpression() {
		if (eContainerFeatureID != Ssm2Package.EXPRESSION__PARENT_EXPRESSION) return null;
		return (Expression)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentExpression(Expression newParentExpression, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentExpression, Ssm2Package.EXPRESSION__PARENT_EXPRESSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentExpression(Expression newParentExpression) {
		if (newParentExpression != eInternalContainer() || (eContainerFeatureID != Ssm2Package.EXPRESSION__PARENT_EXPRESSION && newParentExpression != null)) {
			if (EcoreUtil.isAncestor(this, newParentExpression))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentExpression != null)
				msgs = ((InternalEObject)newParentExpression).eInverseAdd(this, Ssm2Package.EXPRESSION__SUB_EXPRESSIONS, Expression.class, msgs);
			msgs = basicSetParentExpression(newParentExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__PARENT_EXPRESSION, newParentExpression, newParentExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getParentAction() {
		if (eContainerFeatureID != Ssm2Package.EXPRESSION__PARENT_ACTION) return null;
		return (Action)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentAction(Action newParentAction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentAction, Ssm2Package.EXPRESSION__PARENT_ACTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAction(Action newParentAction) {
		if (newParentAction != eInternalContainer() || (eContainerFeatureID != Ssm2Package.EXPRESSION__PARENT_ACTION && newParentAction != null)) {
			if (EcoreUtil.isAncestor(this, newParentAction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentAction != null)
				msgs = ((InternalEObject)newParentAction).eInverseAdd(this, Ssm2Package.ACTION__TRIGGER, Action.class, msgs);
			msgs = basicSetParentAction(newParentAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__PARENT_ACTION, newParentAction, newParentAction));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ssm2Package.EXPRESSION__VARIABLE, oldVariable, variable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Emission getParentEmisson() {
		if (eContainerFeatureID != Ssm2Package.EXPRESSION__PARENT_EMISSON) return null;
		return (Emission)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentEmisson(Emission newParentEmisson, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentEmisson, Ssm2Package.EXPRESSION__PARENT_EMISSON, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentEmisson(Emission newParentEmisson) {
		if (newParentEmisson != eInternalContainer() || (eContainerFeatureID != Ssm2Package.EXPRESSION__PARENT_EMISSON && newParentEmisson != null)) {
			if (EcoreUtil.isAncestor(this, newParentEmisson))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentEmisson != null)
				msgs = ((InternalEObject)newParentEmisson).eInverseAdd(this, Ssm2Package.EMISSION__NEW_VALUE, Emission.class, msgs);
			msgs = basicSetParentEmisson(newParentEmisson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__PARENT_EMISSON, newParentEmisson, newParentEmisson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment getAssignment() {
		if (assignment != null && assignment.eIsProxy()) {
			InternalEObject oldAssignment = (InternalEObject)assignment;
			assignment = (Assignment)eResolveProxy(oldAssignment);
			if (assignment != oldAssignment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ssm2Package.EXPRESSION__ASSIGNMENT, oldAssignment, assignment));
			}
		}
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment basicGetAssignment() {
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignment(Assignment newAssignment, NotificationChain msgs) {
		Assignment oldAssignment = assignment;
		assignment = newAssignment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__ASSIGNMENT, oldAssignment, newAssignment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignment(Assignment newAssignment) {
		if (newAssignment != assignment) {
			NotificationChain msgs = null;
			if (assignment != null)
				msgs = ((InternalEObject)assignment).eInverseRemove(this, Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION, Assignment.class, msgs);
			if (newAssignment != null)
				msgs = ((InternalEObject)newAssignment).eInverseAdd(this, Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION, Assignment.class, msgs);
			msgs = basicSetAssignment(newAssignment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.EXPRESSION__ASSIGNMENT, newAssignment, newAssignment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ssm2Package.EXPRESSION__SUB_EXPRESSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubExpressions()).basicAdd(otherEnd, msgs);
			case Ssm2Package.EXPRESSION__OPERATOR:
				if (operator != null)
					msgs = ((InternalEObject)operator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Ssm2Package.EXPRESSION__OPERATOR, null, msgs);
				return basicSetOperator((Operator)otherEnd, msgs);
			case Ssm2Package.EXPRESSION__PARENT_EXPRESSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentExpression((Expression)otherEnd, msgs);
			case Ssm2Package.EXPRESSION__PARENT_ACTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentAction((Action)otherEnd, msgs);
			case Ssm2Package.EXPRESSION__PARENT_EMISSON:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentEmisson((Emission)otherEnd, msgs);
			case Ssm2Package.EXPRESSION__ASSIGNMENT:
				if (assignment != null)
					msgs = ((InternalEObject)assignment).eInverseRemove(this, Ssm2Package.ASSIGNMENT__PARENT_EXPRESSION, Assignment.class, msgs);
				return basicSetAssignment((Assignment)otherEnd, msgs);
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
			case Ssm2Package.EXPRESSION__SUB_EXPRESSIONS:
				return ((InternalEList<?>)getSubExpressions()).basicRemove(otherEnd, msgs);
			case Ssm2Package.EXPRESSION__OPERATOR:
				return basicSetOperator(null, msgs);
			case Ssm2Package.EXPRESSION__PARENT_EXPRESSION:
				return basicSetParentExpression(null, msgs);
			case Ssm2Package.EXPRESSION__PARENT_ACTION:
				return basicSetParentAction(null, msgs);
			case Ssm2Package.EXPRESSION__PARENT_EMISSON:
				return basicSetParentEmisson(null, msgs);
			case Ssm2Package.EXPRESSION__ASSIGNMENT:
				return basicSetAssignment(null, msgs);
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
		switch (eContainerFeatureID) {
			case Ssm2Package.EXPRESSION__PARENT_EXPRESSION:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.EXPRESSION__SUB_EXPRESSIONS, Expression.class, msgs);
			case Ssm2Package.EXPRESSION__PARENT_ACTION:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.ACTION__TRIGGER, Action.class, msgs);
			case Ssm2Package.EXPRESSION__PARENT_EMISSON:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.EMISSION__NEW_VALUE, Emission.class, msgs);
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
			case Ssm2Package.EXPRESSION__SUB_EXPRESSIONS:
				return getSubExpressions();
			case Ssm2Package.EXPRESSION__SIGNAL:
				if (resolve) return getSignal();
				return basicGetSignal();
			case Ssm2Package.EXPRESSION__OPERATOR:
				return getOperator();
			case Ssm2Package.EXPRESSION__PARENT_EXPRESSION:
				return getParentExpression();
			case Ssm2Package.EXPRESSION__PARENT_ACTION:
				return getParentAction();
			case Ssm2Package.EXPRESSION__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case Ssm2Package.EXPRESSION__PARENT_EMISSON:
				return getParentEmisson();
			case Ssm2Package.EXPRESSION__ASSIGNMENT:
				if (resolve) return getAssignment();
				return basicGetAssignment();
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
			case Ssm2Package.EXPRESSION__SUB_EXPRESSIONS:
				getSubExpressions().clear();
				getSubExpressions().addAll((Collection<? extends Expression>)newValue);
				return;
			case Ssm2Package.EXPRESSION__SIGNAL:
				setSignal((Signal)newValue);
				return;
			case Ssm2Package.EXPRESSION__OPERATOR:
				setOperator((Operator)newValue);
				return;
			case Ssm2Package.EXPRESSION__PARENT_EXPRESSION:
				setParentExpression((Expression)newValue);
				return;
			case Ssm2Package.EXPRESSION__PARENT_ACTION:
				setParentAction((Action)newValue);
				return;
			case Ssm2Package.EXPRESSION__VARIABLE:
				setVariable((Variable)newValue);
				return;
			case Ssm2Package.EXPRESSION__PARENT_EMISSON:
				setParentEmisson((Emission)newValue);
				return;
			case Ssm2Package.EXPRESSION__ASSIGNMENT:
				setAssignment((Assignment)newValue);
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
			case Ssm2Package.EXPRESSION__SUB_EXPRESSIONS:
				getSubExpressions().clear();
				return;
			case Ssm2Package.EXPRESSION__SIGNAL:
				setSignal((Signal)null);
				return;
			case Ssm2Package.EXPRESSION__OPERATOR:
				setOperator((Operator)null);
				return;
			case Ssm2Package.EXPRESSION__PARENT_EXPRESSION:
				setParentExpression((Expression)null);
				return;
			case Ssm2Package.EXPRESSION__PARENT_ACTION:
				setParentAction((Action)null);
				return;
			case Ssm2Package.EXPRESSION__VARIABLE:
				setVariable((Variable)null);
				return;
			case Ssm2Package.EXPRESSION__PARENT_EMISSON:
				setParentEmisson((Emission)null);
				return;
			case Ssm2Package.EXPRESSION__ASSIGNMENT:
				setAssignment((Assignment)null);
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
			case Ssm2Package.EXPRESSION__SUB_EXPRESSIONS:
				return subExpressions != null && !subExpressions.isEmpty();
			case Ssm2Package.EXPRESSION__SIGNAL:
				return signal != null;
			case Ssm2Package.EXPRESSION__OPERATOR:
				return operator != null;
			case Ssm2Package.EXPRESSION__PARENT_EXPRESSION:
				return getParentExpression() != null;
			case Ssm2Package.EXPRESSION__PARENT_ACTION:
				return getParentAction() != null;
			case Ssm2Package.EXPRESSION__VARIABLE:
				return variable != null;
			case Ssm2Package.EXPRESSION__PARENT_EMISSON:
				return getParentEmisson() != null;
			case Ssm2Package.EXPRESSION__ASSIGNMENT:
				return assignment != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpressionImpl
