/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hierarchymealy.impl;

import hierarchymealy.Edge;
import hierarchymealy.MealyPackage;
import hierarchymealy.State;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link hierarchymealy.impl.EdgeImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link hierarchymealy.impl.EdgeImpl#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link hierarchymealy.impl.EdgeImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link hierarchymealy.impl.EdgeImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends EObjectImpl implements Edge {
	/**
	 * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceNode()
	 * @generated
	 * @ordered
	 */
	protected State sourceNode;

	/**
	 * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNode()
	 * @generated
	 * @ordered
	 */
	protected State targetNode;

	/**
	 * The default value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIGGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected String trigger = TRIGGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected String action = ACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MealyPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSourceNode() {
		if (sourceNode != null && sourceNode.eIsProxy()) {
			InternalEObject oldSourceNode = (InternalEObject)sourceNode;
			sourceNode = (State)eResolveProxy(oldSourceNode);
			if (sourceNode != oldSourceNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MealyPackage.EDGE__SOURCE_NODE, oldSourceNode, sourceNode));
			}
		}
		return sourceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSourceNode() {
		return sourceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceNode(State newSourceNode, NotificationChain msgs) {
		State oldSourceNode = sourceNode;
		sourceNode = newSourceNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MealyPackage.EDGE__SOURCE_NODE, oldSourceNode, newSourceNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceNode(State newSourceNode) {
		if (newSourceNode != sourceNode) {
			NotificationChain msgs = null;
			if (sourceNode != null)
				msgs = ((InternalEObject)sourceNode).eInverseRemove(this, MealyPackage.STATE__OUTGOING_EDGES, State.class, msgs);
			if (newSourceNode != null)
				msgs = ((InternalEObject)newSourceNode).eInverseAdd(this, MealyPackage.STATE__OUTGOING_EDGES, State.class, msgs);
			msgs = basicSetSourceNode(newSourceNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MealyPackage.EDGE__SOURCE_NODE, newSourceNode, newSourceNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTargetNode() {
		if (targetNode != null && targetNode.eIsProxy()) {
			InternalEObject oldTargetNode = (InternalEObject)targetNode;
			targetNode = (State)eResolveProxy(oldTargetNode);
			if (targetNode != oldTargetNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MealyPackage.EDGE__TARGET_NODE, oldTargetNode, targetNode));
			}
		}
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTargetNode() {
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetNode(State newTargetNode, NotificationChain msgs) {
		State oldTargetNode = targetNode;
		targetNode = newTargetNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MealyPackage.EDGE__TARGET_NODE, oldTargetNode, newTargetNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetNode(State newTargetNode) {
		if (newTargetNode != targetNode) {
			NotificationChain msgs = null;
			if (targetNode != null)
				msgs = ((InternalEObject)targetNode).eInverseRemove(this, MealyPackage.STATE__INCOMING_EDGES, State.class, msgs);
			if (newTargetNode != null)
				msgs = ((InternalEObject)newTargetNode).eInverseAdd(this, MealyPackage.STATE__INCOMING_EDGES, State.class, msgs);
			msgs = basicSetTargetNode(newTargetNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MealyPackage.EDGE__TARGET_NODE, newTargetNode, newTargetNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(String newTrigger) {
		String oldTrigger = trigger;
		trigger = newTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MealyPackage.EDGE__TRIGGER, oldTrigger, trigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MealyPackage.EDGE__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MealyPackage.EDGE__SOURCE_NODE:
				if (sourceNode != null)
					msgs = ((InternalEObject)sourceNode).eInverseRemove(this, MealyPackage.STATE__OUTGOING_EDGES, State.class, msgs);
				return basicSetSourceNode((State)otherEnd, msgs);
			case MealyPackage.EDGE__TARGET_NODE:
				if (targetNode != null)
					msgs = ((InternalEObject)targetNode).eInverseRemove(this, MealyPackage.STATE__INCOMING_EDGES, State.class, msgs);
				return basicSetTargetNode((State)otherEnd, msgs);
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
			case MealyPackage.EDGE__SOURCE_NODE:
				return basicSetSourceNode(null, msgs);
			case MealyPackage.EDGE__TARGET_NODE:
				return basicSetTargetNode(null, msgs);
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
			case MealyPackage.EDGE__SOURCE_NODE:
				if (resolve) return getSourceNode();
				return basicGetSourceNode();
			case MealyPackage.EDGE__TARGET_NODE:
				if (resolve) return getTargetNode();
				return basicGetTargetNode();
			case MealyPackage.EDGE__TRIGGER:
				return getTrigger();
			case MealyPackage.EDGE__ACTION:
				return getAction();
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
			case MealyPackage.EDGE__SOURCE_NODE:
				setSourceNode((State)newValue);
				return;
			case MealyPackage.EDGE__TARGET_NODE:
				setTargetNode((State)newValue);
				return;
			case MealyPackage.EDGE__TRIGGER:
				setTrigger((String)newValue);
				return;
			case MealyPackage.EDGE__ACTION:
				setAction((String)newValue);
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
			case MealyPackage.EDGE__SOURCE_NODE:
				setSourceNode((State)null);
				return;
			case MealyPackage.EDGE__TARGET_NODE:
				setTargetNode((State)null);
				return;
			case MealyPackage.EDGE__TRIGGER:
				setTrigger(TRIGGER_EDEFAULT);
				return;
			case MealyPackage.EDGE__ACTION:
				setAction(ACTION_EDEFAULT);
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
			case MealyPackage.EDGE__SOURCE_NODE:
				return sourceNode != null;
			case MealyPackage.EDGE__TARGET_NODE:
				return targetNode != null;
			case MealyPackage.EDGE__TRIGGER:
				return TRIGGER_EDEFAULT == null ? trigger != null : !TRIGGER_EDEFAULT.equals(trigger);
			case MealyPackage.EDGE__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (trigger: ");
		result.append(trigger);
		result.append(", action: ");
		result.append(action);
		result.append(')');
		return result.toString();
	}

} //EdgeImpl
