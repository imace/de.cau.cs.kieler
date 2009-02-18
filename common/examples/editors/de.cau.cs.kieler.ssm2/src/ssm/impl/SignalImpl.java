/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ssm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import ssm.Signal;
import ssm.State;
import ssm.Value;
import ssm.ssmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ssm.impl.SignalImpl#getValue <em>Value</em>}</li>
 *   <li>{@link ssm.impl.SignalImpl#getName <em>Name</em>}</li>
 *   <li>{@link ssm.impl.SignalImpl#getParentState <em>Parent State</em>}</li>
 *   <li>{@link ssm.impl.SignalImpl#isIsLocal <em>Is Local</em>}</li>
 *   <li>{@link ssm.impl.SignalImpl#isIsInput <em>Is Input</em>}</li>
 *   <li>{@link ssm.impl.SignalImpl#isIsOutput <em>Is Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignalImpl extends EObjectImpl implements Signal {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsLocal() <em>Is Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLocal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LOCAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLocal() <em>Is Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLocal()
	 * @generated
	 * @ordered
	 */
	protected boolean isLocal = IS_LOCAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INPUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInput() <em>Is Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInput()
	 * @generated
	 * @ordered
	 */
	protected boolean isInput = IS_INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOutput() <em>Is Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOutput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OUTPUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOutput() <em>Is Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOutput()
	 * @generated
	 * @ordered
	 */
	protected boolean isOutput = IS_OUTPUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SignalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ssmPackage.Literals.SIGNAL;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__VALUE, oldValue, newValue);
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
				msgs = ((InternalEObject)value).eInverseRemove(this, ssmPackage.VALUE__PARENT_SIGNAL, Value.class, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, ssmPackage.VALUE__PARENT_SIGNAL, Value.class, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getParentState() {
		if (eContainerFeatureID != ssmPackage.SIGNAL__PARENT_STATE) return null;
		return (State)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentState(State newParentState, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentState, ssmPackage.SIGNAL__PARENT_STATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentState(State newParentState) {
		if (newParentState != eInternalContainer() || (eContainerFeatureID != ssmPackage.SIGNAL__PARENT_STATE && newParentState != null)) {
			if (EcoreUtil.isAncestor(this, newParentState))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentState != null)
				msgs = ((InternalEObject)newParentState).eInverseAdd(this, ssmPackage.STATE__SIGNALS, State.class, msgs);
			msgs = basicSetParentState(newParentState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__PARENT_STATE, newParentState, newParentState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsLocal() {
		return isLocal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLocal(boolean newIsLocal) {
		boolean oldIsLocal = isLocal;
		isLocal = newIsLocal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__IS_LOCAL, oldIsLocal, isLocal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInput() {
		return isInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInput(boolean newIsInput) {
		boolean oldIsInput = isInput;
		isInput = newIsInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__IS_INPUT, oldIsInput, isInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOutput() {
		return isOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOutput(boolean newIsOutput) {
		boolean oldIsOutput = isOutput;
		isOutput = newIsOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ssmPackage.SIGNAL__IS_OUTPUT, oldIsOutput, isOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ssmPackage.SIGNAL__VALUE:
				if (value != null)
					msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ssmPackage.SIGNAL__VALUE, null, msgs);
				return basicSetValue((Value)otherEnd, msgs);
			case ssmPackage.SIGNAL__PARENT_STATE:
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
			case ssmPackage.SIGNAL__VALUE:
				return basicSetValue(null, msgs);
			case ssmPackage.SIGNAL__PARENT_STATE:
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
			case ssmPackage.SIGNAL__PARENT_STATE:
				return eInternalContainer().eInverseRemove(this, ssmPackage.STATE__SIGNALS, State.class, msgs);
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
			case ssmPackage.SIGNAL__VALUE:
				return getValue();
			case ssmPackage.SIGNAL__NAME:
				return getName();
			case ssmPackage.SIGNAL__PARENT_STATE:
				return getParentState();
			case ssmPackage.SIGNAL__IS_LOCAL:
				return isIsLocal() ? Boolean.TRUE : Boolean.FALSE;
			case ssmPackage.SIGNAL__IS_INPUT:
				return isIsInput() ? Boolean.TRUE : Boolean.FALSE;
			case ssmPackage.SIGNAL__IS_OUTPUT:
				return isIsOutput() ? Boolean.TRUE : Boolean.FALSE;
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
			case ssmPackage.SIGNAL__VALUE:
				setValue((Value)newValue);
				return;
			case ssmPackage.SIGNAL__NAME:
				setName((String)newValue);
				return;
			case ssmPackage.SIGNAL__PARENT_STATE:
				setParentState((State)newValue);
				return;
			case ssmPackage.SIGNAL__IS_LOCAL:
				setIsLocal(((Boolean)newValue).booleanValue());
				return;
			case ssmPackage.SIGNAL__IS_INPUT:
				setIsInput(((Boolean)newValue).booleanValue());
				return;
			case ssmPackage.SIGNAL__IS_OUTPUT:
				setIsOutput(((Boolean)newValue).booleanValue());
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
			case ssmPackage.SIGNAL__VALUE:
				setValue((Value)null);
				return;
			case ssmPackage.SIGNAL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ssmPackage.SIGNAL__PARENT_STATE:
				setParentState((State)null);
				return;
			case ssmPackage.SIGNAL__IS_LOCAL:
				setIsLocal(IS_LOCAL_EDEFAULT);
				return;
			case ssmPackage.SIGNAL__IS_INPUT:
				setIsInput(IS_INPUT_EDEFAULT);
				return;
			case ssmPackage.SIGNAL__IS_OUTPUT:
				setIsOutput(IS_OUTPUT_EDEFAULT);
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
			case ssmPackage.SIGNAL__VALUE:
				return value != null;
			case ssmPackage.SIGNAL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ssmPackage.SIGNAL__PARENT_STATE:
				return getParentState() != null;
			case ssmPackage.SIGNAL__IS_LOCAL:
				return isLocal != IS_LOCAL_EDEFAULT;
			case ssmPackage.SIGNAL__IS_INPUT:
				return isInput != IS_INPUT_EDEFAULT;
			case ssmPackage.SIGNAL__IS_OUTPUT:
				return isOutput != IS_OUTPUT_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", isLocal: ");
		result.append(isLocal);
		result.append(", isInput: ");
		result.append(isInput);
		result.append(", isOutput: ");
		result.append(isOutput);
		result.append(')');
		return result.toString();
	}

} //SignalImpl
