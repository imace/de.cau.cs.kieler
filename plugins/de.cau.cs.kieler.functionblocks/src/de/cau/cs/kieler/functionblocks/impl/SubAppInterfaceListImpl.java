/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.InputVars;
import de.cau.cs.kieler.functionblocks.OutputVars;
import de.cau.cs.kieler.functionblocks.SubAppEventInputs;
import de.cau.cs.kieler.functionblocks.SubAppEventOutputs;
import de.cau.cs.kieler.functionblocks.SubAppInterfaceList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub App Interface List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppInterfaceListImpl#getSubAppEventInputs <em>Sub App Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppInterfaceListImpl#getSubAppEventOutputs <em>Sub App Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppInterfaceListImpl#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.SubAppInterfaceListImpl#getOutputVars <em>Output Vars</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubAppInterfaceListImpl extends EObjectImpl implements SubAppInterfaceList {
	/**
	 * The cached value of the '{@link #getSubAppEventInputs() <em>Sub App Event Inputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubAppEventInputs()
	 * @generated
	 * @ordered
	 */
	protected SubAppEventInputs subAppEventInputs;

	/**
	 * The cached value of the '{@link #getSubAppEventOutputs() <em>Sub App Event Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubAppEventOutputs()
	 * @generated
	 * @ordered
	 */
	protected SubAppEventOutputs subAppEventOutputs;

	/**
	 * The cached value of the '{@link #getInputVars() <em>Input Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVars()
	 * @generated
	 * @ordered
	 */
	protected InputVars inputVars;

	/**
	 * The cached value of the '{@link #getOutputVars() <em>Output Vars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVars()
	 * @generated
	 * @ordered
	 */
	protected OutputVars outputVars;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubAppInterfaceListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.SUB_APP_INTERFACE_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEventInputs getSubAppEventInputs() {
		return subAppEventInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppEventInputs(SubAppEventInputs newSubAppEventInputs, NotificationChain msgs) {
		SubAppEventInputs oldSubAppEventInputs = subAppEventInputs;
		subAppEventInputs = newSubAppEventInputs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS, oldSubAppEventInputs, newSubAppEventInputs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppEventInputs(SubAppEventInputs newSubAppEventInputs) {
		if (newSubAppEventInputs != subAppEventInputs) {
			NotificationChain msgs = null;
			if (subAppEventInputs != null)
				msgs = ((InternalEObject)subAppEventInputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS, null, msgs);
			if (newSubAppEventInputs != null)
				msgs = ((InternalEObject)newSubAppEventInputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS, null, msgs);
			msgs = basicSetSubAppEventInputs(newSubAppEventInputs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS, newSubAppEventInputs, newSubAppEventInputs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubAppEventOutputs getSubAppEventOutputs() {
		return subAppEventOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubAppEventOutputs(SubAppEventOutputs newSubAppEventOutputs, NotificationChain msgs) {
		SubAppEventOutputs oldSubAppEventOutputs = subAppEventOutputs;
		subAppEventOutputs = newSubAppEventOutputs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS, oldSubAppEventOutputs, newSubAppEventOutputs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAppEventOutputs(SubAppEventOutputs newSubAppEventOutputs) {
		if (newSubAppEventOutputs != subAppEventOutputs) {
			NotificationChain msgs = null;
			if (subAppEventOutputs != null)
				msgs = ((InternalEObject)subAppEventOutputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS, null, msgs);
			if (newSubAppEventOutputs != null)
				msgs = ((InternalEObject)newSubAppEventOutputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS, null, msgs);
			msgs = basicSetSubAppEventOutputs(newSubAppEventOutputs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS, newSubAppEventOutputs, newSubAppEventOutputs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVars getInputVars() {
		return inputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputVars(InputVars newInputVars, NotificationChain msgs) {
		InputVars oldInputVars = inputVars;
		inputVars = newInputVars;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS, oldInputVars, newInputVars);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVars(InputVars newInputVars) {
		if (newInputVars != inputVars) {
			NotificationChain msgs = null;
			if (inputVars != null)
				msgs = ((InternalEObject)inputVars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS, null, msgs);
			if (newInputVars != null)
				msgs = ((InternalEObject)newInputVars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS, null, msgs);
			msgs = basicSetInputVars(newInputVars, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS, newInputVars, newInputVars));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVars getOutputVars() {
		return outputVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputVars(OutputVars newOutputVars, NotificationChain msgs) {
		OutputVars oldOutputVars = outputVars;
		outputVars = newOutputVars;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS, oldOutputVars, newOutputVars);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputVars(OutputVars newOutputVars) {
		if (newOutputVars != outputVars) {
			NotificationChain msgs = null;
			if (outputVars != null)
				msgs = ((InternalEObject)outputVars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS, null, msgs);
			if (newOutputVars != null)
				msgs = ((InternalEObject)newOutputVars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS, null, msgs);
			msgs = basicSetOutputVars(newOutputVars, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS, newOutputVars, newOutputVars));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS:
				return basicSetSubAppEventInputs(null, msgs);
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS:
				return basicSetSubAppEventOutputs(null, msgs);
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS:
				return basicSetInputVars(null, msgs);
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS:
				return basicSetOutputVars(null, msgs);
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
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS:
				return getSubAppEventInputs();
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS:
				return getSubAppEventOutputs();
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS:
				return getInputVars();
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS:
				return getOutputVars();
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
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS:
				setSubAppEventInputs((SubAppEventInputs)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS:
				setSubAppEventOutputs((SubAppEventOutputs)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS:
				setInputVars((InputVars)newValue);
				return;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS:
				setOutputVars((OutputVars)newValue);
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
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS:
				setSubAppEventInputs((SubAppEventInputs)null);
				return;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS:
				setSubAppEventOutputs((SubAppEventOutputs)null);
				return;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS:
				setInputVars((InputVars)null);
				return;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS:
				setOutputVars((OutputVars)null);
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
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_INPUTS:
				return subAppEventInputs != null;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__SUB_APP_EVENT_OUTPUTS:
				return subAppEventOutputs != null;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__INPUT_VARS:
				return inputVars != null;
			case FunctionblocksPackage.SUB_APP_INTERFACE_LIST__OUTPUT_VARS:
				return outputVars != null;
		}
		return super.eIsSet(featureID);
	}

} //SubAppInterfaceListImpl
