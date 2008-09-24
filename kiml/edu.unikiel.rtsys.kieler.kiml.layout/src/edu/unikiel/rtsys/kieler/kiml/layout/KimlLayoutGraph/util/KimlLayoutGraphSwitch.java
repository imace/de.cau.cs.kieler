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
				KPoint kPoint = (KPoint)theEObject;
				T result = caseKPoint(kPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KDIMENSION: {
				KDimension kDimension = (KDimension)theEObject;
				T result = caseKDimension(kDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KINSETS: {
				KInsets kInsets = (KInsets)theEObject;
				T result = caseKInsets(kInsets);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KLAYOUT_GRAPH: {
				KLayoutGraph kLayoutGraph = (KLayoutGraph)theEObject;
				T result = caseKLayoutGraph(kLayoutGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KSHAPE_LAYOUT: {
				KShapeLayout kShapeLayout = (KShapeLayout)theEObject;
				T result = caseKShapeLayout(kShapeLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE: {
				KEdge kEdge = (KEdge)theEObject;
				T result = caseKEdge(kEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE_LAYOUT: {
				KEdgeLayout kEdgeLayout = (KEdgeLayout)theEObject;
				T result = caseKEdgeLayout(kEdgeLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KNODE_GROUP: {
				KNodeGroup kNodeGroup = (KNodeGroup)theEObject;
				T result = caseKNodeGroup(kNodeGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KNODE_GROUP_LAYOUT: {
				KNodeGroupLayout kNodeGroupLayout = (KNodeGroupLayout)theEObject;
				T result = caseKNodeGroupLayout(kNodeGroupLayout);
				if (result == null) result = caseKShapeLayout(kNodeGroupLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KLABEL: {
				KLabel kLabel = (KLabel)theEObject;
				T result = caseKLabel(kLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE_LABEL: {
				KEdgeLabel kEdgeLabel = (KEdgeLabel)theEObject;
				T result = caseKEdgeLabel(kEdgeLabel);
				if (result == null) result = caseKLabel(kEdgeLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KEDGE_LABEL_LAYOUT: {
				KEdgeLabelLayout kEdgeLabelLayout = (KEdgeLabelLayout)theEObject;
				T result = caseKEdgeLabelLayout(kEdgeLabelLayout);
				if (result == null) result = caseKShapeLayout(kEdgeLabelLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL: {
				KNodeGroupLabel kNodeGroupLabel = (KNodeGroupLabel)theEObject;
				T result = caseKNodeGroupLabel(kNodeGroupLabel);
				if (result == null) result = caseKLabel(kNodeGroupLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.KNODE_GROUP_LABEL_LAYOUT: {
				KNodeGroupLabelLayout kNodeGroupLabelLayout = (KNodeGroupLabelLayout)theEObject;
				T result = caseKNodeGroupLabelLayout(kNodeGroupLabelLayout);
				if (result == null) result = caseKShapeLayout(kNodeGroupLabelLayout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KimlLayoutGraphPackage.LAYOUTER_INFO: {
				LAYOUTER_INFO layouteR_INFO = (LAYOUTER_INFO)theEObject;
				T result = caseLAYOUTER_INFO(layouteR_INFO);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KPoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KPoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKPoint(KPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KDimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KDimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKDimension(KDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KInsets</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KInsets</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKInsets(KInsets object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KLayout Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KLayout Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKLayoutGraph(KLayoutGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KShape Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KShape Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKShapeLayout(KShapeLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KEdge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KEdge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKEdge(KEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KEdge Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KEdge Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKEdgeLayout(KEdgeLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KNode Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KNode Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKNodeGroup(KNodeGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KNode Group Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KNode Group Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKNodeGroupLayout(KNodeGroupLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KLabel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KLabel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKLabel(KLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KEdge Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KEdge Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKEdgeLabel(KEdgeLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KEdge Label Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KEdge Label Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKEdgeLabelLayout(KEdgeLabelLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KNode Group Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KNode Group Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKNodeGroupLabel(KNodeGroupLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KNode Group Label Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KNode Group Label Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKNodeGroupLabelLayout(KNodeGroupLabelLayout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LAYOUTER INFO</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LAYOUTER INFO</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLAYOUTER_INFO(LAYOUTER_INFO object) {
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
