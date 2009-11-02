/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.Algorithm;
import cakefeed.CakefeedPackage;
import cakefeed.FunctionBlock;
import cakefeed.Library;
import cakefeed.ServiceSequence;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cakefeed.impl.LibraryImpl#getFunctionBlocks <em>Function Blocks</em>}</li>
 *   <li>{@link cakefeed.impl.LibraryImpl#getAlgorithms <em>Algorithms</em>}</li>
 *   <li>{@link cakefeed.impl.LibraryImpl#getServiceSequences <em>Service Sequences</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends EObjectImpl implements Library {
	/**
	 * The cached value of the '{@link #getFunctionBlocks() <em>Function Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionBlock> functionBlocks;

	/**
	 * The cached value of the '{@link #getAlgorithms() <em>Algorithms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithms()
	 * @generated
	 * @ordered
	 */
	protected EList<Algorithm> algorithms;

	/**
	 * The cached value of the '{@link #getServiceSequences() <em>Service Sequences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceSequence> serviceSequences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionBlock> getFunctionBlocks() {
		if (functionBlocks == null) {
			functionBlocks = new EObjectContainmentWithInverseEList<FunctionBlock>(FunctionBlock.class, this, CakefeedPackage.LIBRARY__FUNCTION_BLOCKS, CakefeedPackage.FUNCTION_BLOCK__PARENT_LIBRARY);
		}
		return functionBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Algorithm> getAlgorithms() {
		if (algorithms == null) {
			algorithms = new EObjectContainmentWithInverseEList<Algorithm>(Algorithm.class, this, CakefeedPackage.LIBRARY__ALGORITHMS, CakefeedPackage.ALGORITHM__PARENT_LIBRARY);
		}
		return algorithms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceSequence> getServiceSequences() {
		if (serviceSequences == null) {
			serviceSequences = new EObjectContainmentWithInverseEList<ServiceSequence>(ServiceSequence.class, this, CakefeedPackage.LIBRARY__SERVICE_SEQUENCES, CakefeedPackage.SERVICE_SEQUENCE__PARENT_LIBRARY);
		}
		return serviceSequences;
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
			case CakefeedPackage.LIBRARY__FUNCTION_BLOCKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctionBlocks()).basicAdd(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAlgorithms()).basicAdd(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getServiceSequences()).basicAdd(otherEnd, msgs);
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
			case CakefeedPackage.LIBRARY__FUNCTION_BLOCKS:
				return ((InternalEList<?>)getFunctionBlocks()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				return ((InternalEList<?>)getAlgorithms()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				return ((InternalEList<?>)getServiceSequences()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.LIBRARY__FUNCTION_BLOCKS:
				return getFunctionBlocks();
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				return getAlgorithms();
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				return getServiceSequences();
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
			case CakefeedPackage.LIBRARY__FUNCTION_BLOCKS:
				getFunctionBlocks().clear();
				getFunctionBlocks().addAll((Collection<? extends FunctionBlock>)newValue);
				return;
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				getAlgorithms().clear();
				getAlgorithms().addAll((Collection<? extends Algorithm>)newValue);
				return;
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				getServiceSequences().clear();
				getServiceSequences().addAll((Collection<? extends ServiceSequence>)newValue);
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
			case CakefeedPackage.LIBRARY__FUNCTION_BLOCKS:
				getFunctionBlocks().clear();
				return;
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				getAlgorithms().clear();
				return;
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				getServiceSequences().clear();
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
			case CakefeedPackage.LIBRARY__FUNCTION_BLOCKS:
				return functionBlocks != null && !functionBlocks.isEmpty();
			case CakefeedPackage.LIBRARY__ALGORITHMS:
				return algorithms != null && !algorithms.isEmpty();
			case CakefeedPackage.LIBRARY__SERVICE_SEQUENCES:
				return serviceSequences != null && !serviceSequences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LibraryImpl
