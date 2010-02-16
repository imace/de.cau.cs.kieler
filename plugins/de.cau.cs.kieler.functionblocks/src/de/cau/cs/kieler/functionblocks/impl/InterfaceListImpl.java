/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.functionblocks.impl;

import de.cau.cs.kieler.functionblocks.EventInputs;
import de.cau.cs.kieler.functionblocks.EventOutputs;
import de.cau.cs.kieler.functionblocks.FunctionblocksPackage;
import de.cau.cs.kieler.functionblocks.InputVars;
import de.cau.cs.kieler.functionblocks.InterfaceList;
import de.cau.cs.kieler.functionblocks.OutputVars;
import de.cau.cs.kieler.functionblocks.Plugs;
import de.cau.cs.kieler.functionblocks.Sockets;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.InterfaceListImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.InterfaceListImpl#getEventInputs <em>Event Inputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.InterfaceListImpl#getEventOutputs <em>Event Outputs</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.InterfaceListImpl#getInputVars <em>Input Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.InterfaceListImpl#getOutputVars <em>Output Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.InterfaceListImpl#getSockets <em>Sockets</em>}</li>
 *   <li>{@link de.cau.cs.kieler.functionblocks.impl.InterfaceListImpl#getPlugs <em>Plugs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceListImpl extends EObjectImpl implements InterfaceList {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionblocksPackage.Literals.INTERFACE_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, FunctionblocksPackage.INTERFACE_LIST__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventInputs getEventInputs() {
		return (EventInputs)getMixed().get(FunctionblocksPackage.Literals.INTERFACE_LIST__EVENT_INPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventInputs(EventInputs newEventInputs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.INTERFACE_LIST__EVENT_INPUTS, newEventInputs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventInputs(EventInputs newEventInputs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.INTERFACE_LIST__EVENT_INPUTS, newEventInputs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventOutputs getEventOutputs() {
		return (EventOutputs)getMixed().get(FunctionblocksPackage.Literals.INTERFACE_LIST__EVENT_OUTPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventOutputs(EventOutputs newEventOutputs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.INTERFACE_LIST__EVENT_OUTPUTS, newEventOutputs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventOutputs(EventOutputs newEventOutputs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.INTERFACE_LIST__EVENT_OUTPUTS, newEventOutputs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVars getInputVars() {
		return (InputVars)getMixed().get(FunctionblocksPackage.Literals.INTERFACE_LIST__INPUT_VARS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputVars(InputVars newInputVars, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.INTERFACE_LIST__INPUT_VARS, newInputVars, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputVars(InputVars newInputVars) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.INTERFACE_LIST__INPUT_VARS, newInputVars);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVars getOutputVars() {
		return (OutputVars)getMixed().get(FunctionblocksPackage.Literals.INTERFACE_LIST__OUTPUT_VARS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputVars(OutputVars newOutputVars, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.INTERFACE_LIST__OUTPUT_VARS, newOutputVars, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputVars(OutputVars newOutputVars) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.INTERFACE_LIST__OUTPUT_VARS, newOutputVars);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sockets getSockets() {
		return (Sockets)getMixed().get(FunctionblocksPackage.Literals.INTERFACE_LIST__SOCKETS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSockets(Sockets newSockets, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.INTERFACE_LIST__SOCKETS, newSockets, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSockets(Sockets newSockets) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.INTERFACE_LIST__SOCKETS, newSockets);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plugs getPlugs() {
		return (Plugs)getMixed().get(FunctionblocksPackage.Literals.INTERFACE_LIST__PLUGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlugs(Plugs newPlugs, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FunctionblocksPackage.Literals.INTERFACE_LIST__PLUGS, newPlugs, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlugs(Plugs newPlugs) {
		((FeatureMap.Internal)getMixed()).set(FunctionblocksPackage.Literals.INTERFACE_LIST__PLUGS, newPlugs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionblocksPackage.INTERFACE_LIST__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_INPUTS:
				return basicSetEventInputs(null, msgs);
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_OUTPUTS:
				return basicSetEventOutputs(null, msgs);
			case FunctionblocksPackage.INTERFACE_LIST__INPUT_VARS:
				return basicSetInputVars(null, msgs);
			case FunctionblocksPackage.INTERFACE_LIST__OUTPUT_VARS:
				return basicSetOutputVars(null, msgs);
			case FunctionblocksPackage.INTERFACE_LIST__SOCKETS:
				return basicSetSockets(null, msgs);
			case FunctionblocksPackage.INTERFACE_LIST__PLUGS:
				return basicSetPlugs(null, msgs);
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
			case FunctionblocksPackage.INTERFACE_LIST__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_INPUTS:
				return getEventInputs();
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_OUTPUTS:
				return getEventOutputs();
			case FunctionblocksPackage.INTERFACE_LIST__INPUT_VARS:
				return getInputVars();
			case FunctionblocksPackage.INTERFACE_LIST__OUTPUT_VARS:
				return getOutputVars();
			case FunctionblocksPackage.INTERFACE_LIST__SOCKETS:
				return getSockets();
			case FunctionblocksPackage.INTERFACE_LIST__PLUGS:
				return getPlugs();
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
			case FunctionblocksPackage.INTERFACE_LIST__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_INPUTS:
				setEventInputs((EventInputs)newValue);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_OUTPUTS:
				setEventOutputs((EventOutputs)newValue);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__INPUT_VARS:
				setInputVars((InputVars)newValue);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__OUTPUT_VARS:
				setOutputVars((OutputVars)newValue);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__SOCKETS:
				setSockets((Sockets)newValue);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__PLUGS:
				setPlugs((Plugs)newValue);
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
			case FunctionblocksPackage.INTERFACE_LIST__MIXED:
				getMixed().clear();
				return;
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_INPUTS:
				setEventInputs((EventInputs)null);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_OUTPUTS:
				setEventOutputs((EventOutputs)null);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__INPUT_VARS:
				setInputVars((InputVars)null);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__OUTPUT_VARS:
				setOutputVars((OutputVars)null);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__SOCKETS:
				setSockets((Sockets)null);
				return;
			case FunctionblocksPackage.INTERFACE_LIST__PLUGS:
				setPlugs((Plugs)null);
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
			case FunctionblocksPackage.INTERFACE_LIST__MIXED:
				return mixed != null && !mixed.isEmpty();
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_INPUTS:
				return getEventInputs() != null;
			case FunctionblocksPackage.INTERFACE_LIST__EVENT_OUTPUTS:
				return getEventOutputs() != null;
			case FunctionblocksPackage.INTERFACE_LIST__INPUT_VARS:
				return getInputVars() != null;
			case FunctionblocksPackage.INTERFACE_LIST__OUTPUT_VARS:
				return getOutputVars() != null;
			case FunctionblocksPackage.INTERFACE_LIST__SOCKETS:
				return getSockets() != null;
			case FunctionblocksPackage.INTERFACE_LIST__PLUGS:
				return getPlugs() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //InterfaceListImpl
