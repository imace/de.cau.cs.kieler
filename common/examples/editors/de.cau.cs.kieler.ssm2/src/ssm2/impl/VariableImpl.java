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

import org.eclipse.emf.ecore.util.EcoreUtil;

import ssm2.Ssm2Package;
import ssm2.State;
import ssm2.Value;
import ssm2.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm2.impl.VariableImpl#getVname <em>Vname</em>}</li>
 *   <li>{@link ssm2.impl.VariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link ssm2.impl.VariableImpl#getParentState <em>Parent State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends EObjectImpl implements Variable {
	/**
	 * The default value of the '{@link #getVname() <em>Vname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVname()
	 * @generated
	 * @ordered
	 */
	protected static final String VNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVname() <em>Vname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVname()
	 * @generated
	 * @ordered
	 */
	protected String vname = VNAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Value value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ssm2Package.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVname() {
		return vname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVname(String newVname) {
		String oldVname = vname;
		vname = newVname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.VARIABLE__VNAME, oldVname, vname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Value newValue, NotificationChain msgs) {
		Value oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ssm2Package.VARIABLE__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Value newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, Ssm2Package.VALUE__PARENT_VARIABLE, Value.class, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, Ssm2Package.VALUE__PARENT_VARIABLE, Value.class, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.VARIABLE__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentState() {
		if (eContainerFeatureID != Ssm2Package.VARIABLE__PARENT_STATE) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentState(State newParentState, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentState, Ssm2Package.VARIABLE__PARENT_STATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentState(State newParentState) {
		if (newParentState != eInternalContainer() || (eContainerFeatureID != Ssm2Package.VARIABLE__PARENT_STATE && newParentState != null)) {
			if (EcoreUtil.isAncestor(this, newParentState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentState != null)
				msgs = ((InternalEObject)newParentState).eInverseAdd(this, Ssm2Package.STATE__VARIABLES, State.class, msgs);
			msgs = basicSetParentState(newParentState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ssm2Package.VARIABLE__PARENT_STATE, newParentState, newParentState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ssm2Package.VARIABLE__VALUE:
				if (value != null)
					msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Ssm2Package.VARIABLE__VALUE, null, msgs);
				return basicSetValue((Value)otherEnd, msgs);
			case Ssm2Package.VARIABLE__PARENT_STATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentState((State)otherEnd, msgs);
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
			case Ssm2Package.VARIABLE__VALUE:
				return basicSetValue(null, msgs);
			case Ssm2Package.VARIABLE__PARENT_STATE:
				return basicSetParentState(null, msgs);
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
			case Ssm2Package.VARIABLE__PARENT_STATE:
				return eInternalContainer().eInverseRemove(this, Ssm2Package.STATE__VARIABLES, State.class, msgs);
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
			case Ssm2Package.VARIABLE__VNAME:
				return getVname();
			case Ssm2Package.VARIABLE__VALUE:
				return getValue();
			case Ssm2Package.VARIABLE__PARENT_STATE:
				return getParentState();
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
			case Ssm2Package.VARIABLE__VNAME:
				setVname((String)newValue);
				return;
			case Ssm2Package.VARIABLE__VALUE:
				setValue((Value)newValue);
				return;
			case Ssm2Package.VARIABLE__PARENT_STATE:
				setParentState((State)newValue);
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
			case Ssm2Package.VARIABLE__VNAME:
				setVname(VNAME_EDEFAULT);
				return;
			case Ssm2Package.VARIABLE__VALUE:
				setValue((Value)null);
				return;
			case Ssm2Package.VARIABLE__PARENT_STATE:
				setParentState((State)null);
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
			case Ssm2Package.VARIABLE__VNAME:
				return VNAME_EDEFAULT == null ? vname != null : !VNAME_EDEFAULT.equals(vname);
			case Ssm2Package.VARIABLE__VALUE:
				return value != null;
			case Ssm2Package.VARIABLE__PARENT_STATE:
				return getParentState() != null;
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
		result.append(" (vname: ");
		result.append(vname);
		result.append(')');
		return result.toString();
	}

} //VariableImpl
