/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup;

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
 * An implementation of the model object '<em><b>kEdge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl#getEdgeLayout <em>Edge Layout</em>}</li>
 *   <li>{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.impl.kEdgeImpl#getEdgeLabel <em>Edge Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class kEdgeImpl extends EObjectImpl implements kEdge {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected kNodeGroup source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected kNodeGroup target;

	/**
	 * The cached value of the '{@link #getEdgeLayout() <em>Edge Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeLayout()
	 * @generated
	 * @ordered
	 */
	protected kEdgeLayout edgeLayout;

	/**
	 * The cached value of the '{@link #getEdgeLabel() <em>Edge Label</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<kEdgeLabel> edgeLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected kEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KimlLayoutGraphPackage.Literals.KEDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroup getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (kNodeGroup)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KEDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroup basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(kNodeGroup newSource, NotificationChain msgs) {
		kNodeGroup oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(kNodeGroup newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES, kNodeGroup.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES, kNodeGroup.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroup getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (kNodeGroup)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KEDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kNodeGroup basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(kNodeGroup newTarget, NotificationChain msgs) {
		kNodeGroup oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(kNodeGroup newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES, kNodeGroup.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES, kNodeGroup.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kEdgeLayout getEdgeLayout() {
		if (edgeLayout != null && edgeLayout.eIsProxy()) {
			InternalEObject oldEdgeLayout = (InternalEObject)edgeLayout;
			edgeLayout = (kEdgeLayout)eResolveProxy(oldEdgeLayout);
			if (edgeLayout != oldEdgeLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KimlLayoutGraphPackage.KEDGE__EDGE_LAYOUT, oldEdgeLayout, edgeLayout));
			}
		}
		return edgeLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kEdgeLayout basicGetEdgeLayout() {
		return edgeLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeLayout(kEdgeLayout newEdgeLayout) {
		kEdgeLayout oldEdgeLayout = edgeLayout;
		edgeLayout = newEdgeLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KimlLayoutGraphPackage.KEDGE__EDGE_LAYOUT, oldEdgeLayout, edgeLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<kEdgeLabel> getEdgeLabel() {
		if (edgeLabel == null) {
			edgeLabel = new EObjectResolvingEList<kEdgeLabel>(kEdgeLabel.class, this, KimlLayoutGraphPackage.KEDGE__EDGE_LABEL);
		}
		return edgeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KimlLayoutGraphPackage.KEDGE__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, KimlLayoutGraphPackage.KNODE_GROUP__OUTGOING_EDGES, kNodeGroup.class, msgs);
				return basicSetSource((kNodeGroup)otherEnd, msgs);
			case KimlLayoutGraphPackage.KEDGE__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, KimlLayoutGraphPackage.KNODE_GROUP__INCOMING_EDGES, kNodeGroup.class, msgs);
				return basicSetTarget((kNodeGroup)otherEnd, msgs);
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
			case KimlLayoutGraphPackage.KEDGE__SOURCE:
				return basicSetSource(null, msgs);
			case KimlLayoutGraphPackage.KEDGE__TARGET:
				return basicSetTarget(null, msgs);
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
			case KimlLayoutGraphPackage.KEDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case KimlLayoutGraphPackage.KEDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case KimlLayoutGraphPackage.KEDGE__EDGE_LAYOUT:
				if (resolve) return getEdgeLayout();
				return basicGetEdgeLayout();
			case KimlLayoutGraphPackage.KEDGE__EDGE_LABEL:
				return getEdgeLabel();
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
			case KimlLayoutGraphPackage.KEDGE__SOURCE:
				setSource((kNodeGroup)newValue);
				return;
			case KimlLayoutGraphPackage.KEDGE__TARGET:
				setTarget((kNodeGroup)newValue);
				return;
			case KimlLayoutGraphPackage.KEDGE__EDGE_LAYOUT:
				setEdgeLayout((kEdgeLayout)newValue);
				return;
			case KimlLayoutGraphPackage.KEDGE__EDGE_LABEL:
				getEdgeLabel().clear();
				getEdgeLabel().addAll((Collection<? extends kEdgeLabel>)newValue);
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
			case KimlLayoutGraphPackage.KEDGE__SOURCE:
				setSource((kNodeGroup)null);
				return;
			case KimlLayoutGraphPackage.KEDGE__TARGET:
				setTarget((kNodeGroup)null);
				return;
			case KimlLayoutGraphPackage.KEDGE__EDGE_LAYOUT:
				setEdgeLayout((kEdgeLayout)null);
				return;
			case KimlLayoutGraphPackage.KEDGE__EDGE_LABEL:
				getEdgeLabel().clear();
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
			case KimlLayoutGraphPackage.KEDGE__SOURCE:
				return source != null;
			case KimlLayoutGraphPackage.KEDGE__TARGET:
				return target != null;
			case KimlLayoutGraphPackage.KEDGE__EDGE_LAYOUT:
				return edgeLayout != null;
			case KimlLayoutGraphPackage.KEDGE__EDGE_LABEL:
				return edgeLabel != null && !edgeLabel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //kEdgeImpl
