/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.CakefeedPackage;
import cakefeed.FunctionBlock;
import cakefeed.InputDataPort;
import cakefeed.InputEventPort;
import cakefeed.Interface;
import cakefeed.OutputDataPort;
import cakefeed.OutputEventPort;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.FunctionBlockImpl#getParentInterface <em>Parent Interface</em>}</li>
 *   <li>{@link cakefeed.impl.FunctionBlockImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link cakefeed.impl.FunctionBlockImpl#getInputEventPorts <em>Input Event Ports</em>}</li>
 *   <li>{@link cakefeed.impl.FunctionBlockImpl#getOutputEventPorts <em>Output Event Ports</em>}</li>
 *   <li>{@link cakefeed.impl.FunctionBlockImpl#getInputDataPorts <em>Input Data Ports</em>}</li>
 *   <li>{@link cakefeed.impl.FunctionBlockImpl#getOutputDataPorts <em>Output Data Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FunctionBlockImpl extends EObjectImpl implements FunctionBlock {
	/**
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputEventPorts() <em>Input Event Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputEventPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<InputEventPort> inputEventPorts;

	/**
	 * The cached value of the '{@link #getOutputEventPorts() <em>Output Event Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputEventPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputEventPort> outputEventPorts;

	/**
	 * The cached value of the '{@link #getInputDataPorts() <em>Input Data Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputDataPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<InputDataPort> inputDataPorts;

	/**
	 * The cached value of the '{@link #getOutputDataPorts() <em>Output Data Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDataPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputDataPort> outputDataPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.FUNCTION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getParentInterface() {
		if (eContainerFeatureID() != CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE) return null;
		return (Interface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentInterface(Interface newParentInterface, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentInterface, CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentInterface(Interface newParentInterface) {
		if (newParentInterface != eInternalContainer() || (eContainerFeatureID() != CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE && newParentInterface != null)) {
			if (EcoreUtil.isAncestor(this, newParentInterface))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentInterface != null)
				msgs = ((InternalEObject)newParentInterface).eInverseAdd(this, CakefeedPackage.INTERFACE__FUNCTION_BLOCK, Interface.class, msgs);
			msgs = basicSetParentInterface(newParentInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE, newParentInterface, newParentInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(String newTypeName) {
		String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.FUNCTION_BLOCK__TYPE_NAME, oldTypeName, typeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputEventPort> getInputEventPorts() {
		if (inputEventPorts == null) {
			inputEventPorts = new EObjectContainmentWithInverseEList<InputEventPort>(InputEventPort.class, this, CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENT_PORTS, CakefeedPackage.INPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK);
		}
		return inputEventPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputEventPort> getOutputEventPorts() {
		if (outputEventPorts == null) {
			outputEventPorts = new EObjectContainmentWithInverseEList<OutputEventPort>(OutputEventPort.class, this, CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENT_PORTS, CakefeedPackage.OUTPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK);
		}
		return outputEventPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputDataPort> getInputDataPorts() {
		if (inputDataPorts == null) {
			inputDataPorts = new EObjectContainmentWithInverseEList<InputDataPort>(InputDataPort.class, this, CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS, CakefeedPackage.INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK);
		}
		return inputDataPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputDataPort> getOutputDataPorts() {
		if (outputDataPorts == null) {
			outputDataPorts = new EObjectContainmentWithInverseEList<OutputDataPort>(OutputDataPort.class, this, CakefeedPackage.FUNCTION_BLOCK__OUTPUT_DATA_PORTS, CakefeedPackage.OUTPUT_DATA_PORT__PARENT_FUNCTION_BLOCK);
		}
		return outputDataPorts;
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
			case CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentInterface((Interface)otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENT_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputEventPorts()).basicAdd(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENT_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputEventPorts()).basicAdd(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputDataPorts()).basicAdd(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_DATA_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputDataPorts()).basicAdd(otherEnd, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE:
				return basicSetParentInterface(null, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENT_PORTS:
				return ((InternalEList<?>)getInputEventPorts()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENT_PORTS:
				return ((InternalEList<?>)getOutputEventPorts()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS:
				return ((InternalEList<?>)getInputDataPorts()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_DATA_PORTS:
				return ((InternalEList<?>)getOutputDataPorts()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE:
				return eInternalContainer().eInverseRemove(this, CakefeedPackage.INTERFACE__FUNCTION_BLOCK, Interface.class, msgs);
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
			case CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE:
				return getParentInterface();
			case CakefeedPackage.FUNCTION_BLOCK__TYPE_NAME:
				return getTypeName();
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENT_PORTS:
				return getInputEventPorts();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENT_PORTS:
				return getOutputEventPorts();
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS:
				return getInputDataPorts();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_DATA_PORTS:
				return getOutputDataPorts();
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
			case CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE:
				setParentInterface((Interface)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__TYPE_NAME:
				setTypeName((String)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENT_PORTS:
				getInputEventPorts().clear();
				getInputEventPorts().addAll((Collection<? extends InputEventPort>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENT_PORTS:
				getOutputEventPorts().clear();
				getOutputEventPorts().addAll((Collection<? extends OutputEventPort>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS:
				getInputDataPorts().clear();
				getInputDataPorts().addAll((Collection<? extends InputDataPort>)newValue);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_DATA_PORTS:
				getOutputDataPorts().clear();
				getOutputDataPorts().addAll((Collection<? extends OutputDataPort>)newValue);
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
			case CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE:
				setParentInterface((Interface)null);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__TYPE_NAME:
				setTypeName(TYPE_NAME_EDEFAULT);
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENT_PORTS:
				getInputEventPorts().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENT_PORTS:
				getOutputEventPorts().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS:
				getInputDataPorts().clear();
				return;
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_DATA_PORTS:
				getOutputDataPorts().clear();
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
			case CakefeedPackage.FUNCTION_BLOCK__PARENT_INTERFACE:
				return getParentInterface() != null;
			case CakefeedPackage.FUNCTION_BLOCK__TYPE_NAME:
				return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_EVENT_PORTS:
				return inputEventPorts != null && !inputEventPorts.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_EVENT_PORTS:
				return outputEventPorts != null && !outputEventPorts.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK__INPUT_DATA_PORTS:
				return inputDataPorts != null && !inputDataPorts.isEmpty();
			case CakefeedPackage.FUNCTION_BLOCK__OUTPUT_DATA_PORTS:
				return outputDataPorts != null && !outputDataPorts.isEmpty();
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
		result.append(" (typeName: ");
		result.append(typeName);
		result.append(')');
		return result.toString();
	}

} //FunctionBlockImpl
