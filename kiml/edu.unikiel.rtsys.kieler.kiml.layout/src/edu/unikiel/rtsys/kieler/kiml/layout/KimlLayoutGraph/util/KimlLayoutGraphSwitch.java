/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.util;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage
 * @generated
 */
public class KimlLayoutGraphSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KimlLayoutGraphPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KimlLayoutGraphSwitch() {
		if (modelPackage == null) {
			modelPackage = KimlLayoutGraphPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case KimlLayoutGraphPackage.KPOINT: {
				kPoint kPoint = (kPoint)theEObject;
				T result = casekPoint(kPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KDIMENSION: {
				kDimension kDimension = (kDimension)theEObject;
				T result = casekDimension(kDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KINSETS: {
				kInsets kInsets = (kInsets)theEObject;
				T result = casekInsets(kInsets);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE: {
				kEdge kEdge = (kEdge)theEObject;
				T result = casekEdge(kEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KLAYOUT_GRAPH: {
				kLayoutGraph kLayoutGraph = (kLayoutGraph)theEObject;
				T result = casekLayoutGraph(kLayoutGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KSHAPE_LAYOUT: {
				kShapeLayout kShapeLayout = (kShapeLayout)theEObject;
				T result = casekShapeLayout(kShapeLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE_LAYOUT: {
				kEdgeLayout kEdgeLayout = (kEdgeLayout)theEObject;
				T result = casekEdgeLayout(kEdgeLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KNODE_GROUP: {
				kNodeGroup kNodeGroup = (kNodeGroup)theEObject;
				T result = casekNodeGroup(kNodeGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE_LABEL: {
				kEdgeLabel kEdgeLabel = (kEdgeLabel)theEObject;
				T result = casekEdgeLabel(kEdgeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT: {
				kNodeGroupLayout kNodeGroupLayout = (kNodeGroupLayout)theEObject;
				T result = casekNodeGroupLayout(kNodeGroupLayout);
				if (result == null) result = casekShapeLayout(kNodeGroupLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT: {
				kEdgeLabelLayout kEdgeLabelLayout = (kEdgeLabelLayout)theEObject;
				T result = casekEdgeLabelLayout(kEdgeLabelLayout);
				if (result == null) result = casekShapeLayout(kEdgeLabelLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kPoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kPoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekPoint(kPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kDimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kDimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekDimension(kDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kInsets</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kInsets</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekInsets(kInsets object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kEdge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kEdge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekEdge(kEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kLayout Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kLayout Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekLayoutGraph(kLayoutGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kShape Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kShape Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekShapeLayout(kShapeLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kEdge Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kEdge Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekEdgeLayout(kEdgeLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kNode Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kNode Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekNodeGroup(kNodeGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kEdge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kEdge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekEdgeLabel(kEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kNode Group Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kNode Group Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekNodeGroupLayout(kNodeGroupLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>kEdge Label Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>kEdge Label Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casekEdgeLabelLayout(kEdgeLabelLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //KimlLayoutGraphSwitch
