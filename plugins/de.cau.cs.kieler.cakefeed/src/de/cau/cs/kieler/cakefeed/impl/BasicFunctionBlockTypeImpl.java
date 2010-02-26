/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed.impl;

import de.cau.cs.kieler.cakefeed.BasicFunctionBlockType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FunctionBlockDiagram;
import de.cau.cs.kieler.cakefeed.InternalVar;
import de.cau.cs.kieler.cakefeed.LadderDiagram;
import de.cau.cs.kieler.cakefeed.OtherAlgorithm;
import de.cau.cs.kieler.cakefeed.Service;
import de.cau.cs.kieler.cakefeed.StructuredText;

import de.cau.cs.kieler.synccharts.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Function Block Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockTypeImpl#getService <em>Service</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockTypeImpl#getSyncChart <em>Sync Chart</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockTypeImpl#getInternalVars <em>Internal Vars</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockTypeImpl#getFunctionBlockDiagrams <em>Function Block Diagrams</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockTypeImpl#getStructuredTexts <em>Structured Texts</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockTypeImpl#getLadderDiagrams <em>Ladder Diagrams</em>}</li>
 *   <li>{@link de.cau.cs.kieler.cakefeed.impl.BasicFunctionBlockTypeImpl#getOtherAlgorithms <em>Other Algorithms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicFunctionBlockTypeImpl extends FunctionBlockTypeImpl implements BasicFunctionBlockType {
	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected Service service;

	/**
	 * The cached value of the '{@link #getSyncChart() <em>Sync Chart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncChart()
	 * @generated
	 * @ordered
	 */
	protected State syncChart;

	/**
	 * The cached value of the '{@link #getInternalVars() <em>Internal Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalVars()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalVar> internalVars;

	/**
	 * The cached value of the '{@link #getFunctionBlockDiagrams() <em>Function Block Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionBlockDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionBlockDiagram> functionBlockDiagrams;

	/**
	 * The cached value of the '{@link #getStructuredTexts() <em>Structured Texts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuredTexts()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuredText> structuredTexts;

	/**
	 * The cached value of the '{@link #getLadderDiagrams() <em>Ladder Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLadderDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<LadderDiagram> ladderDiagrams;

	/**
	 * The cached value of the '{@link #getOtherAlgorithms() <em>Other Algorithms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherAlgorithms()
	 * @generated
	 * @ordered
	 */
	protected EList<OtherAlgorithm> otherAlgorithms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicFunctionBlockTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CakefeedPackage.Literals.BASIC_FUNCTION_BLOCK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(Service newService, NotificationChain msgs) {
		Service oldService = service;
		service = newService;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE, oldService, newService);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService) {
		if (newService != service) {
			NotificationChain msgs = null;
			if (service != null)
				msgs = ((InternalEObject)service).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE, null, msgs);
			if (newService != null)
				msgs = ((InternalEObject)newService).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE, null, msgs);
			msgs = basicSetService(newService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE, newService, newService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSyncChart() {
		if (syncChart != null && syncChart.eIsProxy()) {
			InternalEObject oldSyncChart = (InternalEObject)syncChart;
			syncChart = (State)eResolveProxy(oldSyncChart);
			if (syncChart != oldSyncChart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SYNC_CHART, oldSyncChart, syncChart));
			}
		}
		return syncChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSyncChart() {
		return syncChart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSyncChart(State newSyncChart) {
		State oldSyncChart = syncChart;
		syncChart = newSyncChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SYNC_CHART, oldSyncChart, syncChart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalVar> getInternalVars() {
		if (internalVars == null) {
			internalVars = new EObjectContainmentEList<InternalVar>(InternalVar.class, this, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__INTERNAL_VARS);
		}
		return internalVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionBlockDiagram> getFunctionBlockDiagrams() {
		if (functionBlockDiagrams == null) {
			functionBlockDiagrams = new EObjectContainmentEList<FunctionBlockDiagram>(FunctionBlockDiagram.class, this, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__FUNCTION_BLOCK_DIAGRAMS);
		}
		return functionBlockDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuredText> getStructuredTexts() {
		if (structuredTexts == null) {
			structuredTexts = new EObjectContainmentEList<StructuredText>(StructuredText.class, this, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__STRUCTURED_TEXTS);
		}
		return structuredTexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LadderDiagram> getLadderDiagrams() {
		if (ladderDiagrams == null) {
			ladderDiagrams = new EObjectContainmentEList<LadderDiagram>(LadderDiagram.class, this, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__LADDER_DIAGRAMS);
		}
		return ladderDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OtherAlgorithm> getOtherAlgorithms() {
		if (otherAlgorithms == null) {
			otherAlgorithms = new EObjectContainmentEList<OtherAlgorithm>(OtherAlgorithm.class, this, CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__OTHER_ALGORITHMS);
		}
		return otherAlgorithms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE:
				return basicSetService(null, msgs);
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__INTERNAL_VARS:
				return ((InternalEList<?>)getInternalVars()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__FUNCTION_BLOCK_DIAGRAMS:
				return ((InternalEList<?>)getFunctionBlockDiagrams()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__STRUCTURED_TEXTS:
				return ((InternalEList<?>)getStructuredTexts()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__LADDER_DIAGRAMS:
				return ((InternalEList<?>)getLadderDiagrams()).basicRemove(otherEnd, msgs);
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__OTHER_ALGORITHMS:
				return ((InternalEList<?>)getOtherAlgorithms()).basicRemove(otherEnd, msgs);
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE:
				return getService();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SYNC_CHART:
				if (resolve) return getSyncChart();
				return basicGetSyncChart();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__INTERNAL_VARS:
				return getInternalVars();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__FUNCTION_BLOCK_DIAGRAMS:
				return getFunctionBlockDiagrams();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__STRUCTURED_TEXTS:
				return getStructuredTexts();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__LADDER_DIAGRAMS:
				return getLadderDiagrams();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__OTHER_ALGORITHMS:
				return getOtherAlgorithms();
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE:
				setService((Service)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SYNC_CHART:
				setSyncChart((State)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__INTERNAL_VARS:
				getInternalVars().clear();
				getInternalVars().addAll((Collection<? extends InternalVar>)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__FUNCTION_BLOCK_DIAGRAMS:
				getFunctionBlockDiagrams().clear();
				getFunctionBlockDiagrams().addAll((Collection<? extends FunctionBlockDiagram>)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__STRUCTURED_TEXTS:
				getStructuredTexts().clear();
				getStructuredTexts().addAll((Collection<? extends StructuredText>)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__LADDER_DIAGRAMS:
				getLadderDiagrams().clear();
				getLadderDiagrams().addAll((Collection<? extends LadderDiagram>)newValue);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__OTHER_ALGORITHMS:
				getOtherAlgorithms().clear();
				getOtherAlgorithms().addAll((Collection<? extends OtherAlgorithm>)newValue);
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE:
				setService((Service)null);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SYNC_CHART:
				setSyncChart((State)null);
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__INTERNAL_VARS:
				getInternalVars().clear();
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__FUNCTION_BLOCK_DIAGRAMS:
				getFunctionBlockDiagrams().clear();
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__STRUCTURED_TEXTS:
				getStructuredTexts().clear();
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__LADDER_DIAGRAMS:
				getLadderDiagrams().clear();
				return;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__OTHER_ALGORITHMS:
				getOtherAlgorithms().clear();
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
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SERVICE:
				return service != null;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__SYNC_CHART:
				return syncChart != null;
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__INTERNAL_VARS:
				return internalVars != null && !internalVars.isEmpty();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__FUNCTION_BLOCK_DIAGRAMS:
				return functionBlockDiagrams != null && !functionBlockDiagrams.isEmpty();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__STRUCTURED_TEXTS:
				return structuredTexts != null && !structuredTexts.isEmpty();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__LADDER_DIAGRAMS:
				return ladderDiagrams != null && !ladderDiagrams.isEmpty();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_TYPE__OTHER_ALGORITHMS:
				return otherAlgorithms != null && !otherAlgorithms.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BasicFunctionBlockTypeImpl
