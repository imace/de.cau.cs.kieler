/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.ssm.impl;

import edu.unikiel.rtsys.kieler.ssm.AbstractState;
import edu.unikiel.rtsys.kieler.ssm.Action;
import edu.unikiel.rtsys.kieler.ssm.Transition;
import edu.unikiel.rtsys.kieler.ssm.ssmPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl#getEffect <em>Effect</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.ssm.impl.TransitionImpl#getEffectString <em>Effect String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EObjectImpl implements Transition {
    /**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
    protected AbstractState target;

    /**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
    protected AbstractState source;

    /**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
    protected static final int PRIORITY_EDEFAULT = 0;

    /**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
    protected int priority = PRIORITY_EDEFAULT;

    /**
	 * The cached value of the '{@link #getEffect() <em>Effect</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getEffect()
	 * @generated
	 * @ordered
	 */
    protected EList<Action> effect;

    /**
	 * The default value of the '{@link #getEffectString() <em>Effect String</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getEffectString()
	 * @generated
	 * @ordered
	 */
    protected static final String EFFECT_STRING_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getEffectString() <em>Effect String</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getEffectString()
	 * @generated
	 * @ordered
	 */
    protected String effectString = EFFECT_STRING_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TransitionImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return ssmPackage.Literals.TRANSITION;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public AbstractState getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (AbstractState)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ssmPackage.TRANSITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public AbstractState basicGetTarget() {
		return target;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetTarget(AbstractState newTarget, NotificationChain msgs) {
		AbstractState oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTarget(AbstractState newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS, AbstractState.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS, AbstractState.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__TARGET, newTarget, newTarget));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public AbstractState getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (AbstractState)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ssmPackage.TRANSITION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public AbstractState basicGetSource() {
		return source;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetSource(AbstractState newSource, NotificationChain msgs) {
		AbstractState oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSource(AbstractState newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS, AbstractState.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS, AbstractState.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__SOURCE, newSource, newSource));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getPriority() {
		return priority;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__PRIORITY, oldPriority, priority));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Action> getEffect() {
		if (effect == null) {
			effect = new EObjectResolvingEList<Action>(Action.class, this, ssmPackage.TRANSITION__EFFECT);
		}
		return effect;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getEffectString() {
		return effectString;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setEffectString(String newEffectString) {
		String oldEffectString = effectString;
		effectString = newEffectString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.TRANSITION__EFFECT_STRING, oldEffectString, effectString));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.TRANSITION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, ssmPackage.ABSTRACT_STATE__INCOMING_TRANSITIONS, AbstractState.class, msgs);
				return basicSetTarget((AbstractState)otherEnd, msgs);
			case ssmPackage.TRANSITION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, ssmPackage.ABSTRACT_STATE__OUTGOING_TRANSITIONS, AbstractState.class, msgs);
				return basicSetSource((AbstractState)otherEnd, msgs);
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
			case ssmPackage.TRANSITION__TARGET:
				return basicSetTarget(null, msgs);
			case ssmPackage.TRANSITION__SOURCE:
				return basicSetSource(null, msgs);
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
			case ssmPackage.TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ssmPackage.TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ssmPackage.TRANSITION__PRIORITY:
				return new Integer(getPriority());
			case ssmPackage.TRANSITION__EFFECT:
				return getEffect();
			case ssmPackage.TRANSITION__EFFECT_STRING:
				return getEffectString();
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
			case ssmPackage.TRANSITION__TARGET:
				setTarget((AbstractState)newValue);
				return;
			case ssmPackage.TRANSITION__SOURCE:
				setSource((AbstractState)newValue);
				return;
			case ssmPackage.TRANSITION__PRIORITY:
				setPriority(((Integer)newValue).intValue());
				return;
			case ssmPackage.TRANSITION__EFFECT:
				getEffect().clear();
				getEffect().addAll((Collection<? extends Action>)newValue);
				return;
			case ssmPackage.TRANSITION__EFFECT_STRING:
				setEffectString((String)newValue);
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
			case ssmPackage.TRANSITION__TARGET:
				setTarget((AbstractState)null);
				return;
			case ssmPackage.TRANSITION__SOURCE:
				setSource((AbstractState)null);
				return;
			case ssmPackage.TRANSITION__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case ssmPackage.TRANSITION__EFFECT:
				getEffect().clear();
				return;
			case ssmPackage.TRANSITION__EFFECT_STRING:
				setEffectString(EFFECT_STRING_EDEFAULT);
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
			case ssmPackage.TRANSITION__TARGET:
				return target != null;
			case ssmPackage.TRANSITION__SOURCE:
				return source != null;
			case ssmPackage.TRANSITION__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case ssmPackage.TRANSITION__EFFECT:
				return effect != null && !effect.isEmpty();
			case ssmPackage.TRANSITION__EFFECT_STRING:
				return EFFECT_STRING_EDEFAULT == null ? effectString != null : !EFFECT_STRING_EDEFAULT.equals(effectString);
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
		result.append(" (priority: ");
		result.append(priority);
		result.append(", effectString: ");
		result.append(effectString);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
