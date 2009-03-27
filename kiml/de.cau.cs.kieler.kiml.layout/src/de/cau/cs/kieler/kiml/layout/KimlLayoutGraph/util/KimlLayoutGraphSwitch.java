/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.util;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;

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
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage
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
                if (result == null) result = caseKLayoutNode(kLayoutGraph);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KSHAPE_LAYOUT: {
                KShapeLayout kShapeLayout = (KShapeLayout)theEObject;
                T result = caseKShapeLayout(kShapeLayout);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KLAYOUT_EDGE: {
                KLayoutEdge kLayoutEdge = (KLayoutEdge)theEObject;
                T result = caseKLayoutEdge(kLayoutEdge);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KEDGE_LAYOUT: {
                KEdgeLayout kEdgeLayout = (KEdgeLayout)theEObject;
                T result = caseKEdgeLayout(kEdgeLayout);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KLAYOUT_NODE: {
                KLayoutNode kLayoutNode = (KLayoutNode)theEObject;
                T result = caseKLayoutNode(kLayoutNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KNODE_LAYOUT: {
                KNodeLayout kNodeLayout = (KNodeLayout)theEObject;
                T result = caseKNodeLayout(kNodeLayout);
                if (result == null) result = caseKShapeLayout(kNodeLayout);
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
            case KimlLayoutGraphPackage.KNODE_LABEL: {
                KNodeLabel kNodeLabel = (KNodeLabel)theEObject;
                T result = caseKNodeLabel(kNodeLabel);
                if (result == null) result = caseKLabel(kNodeLabel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KNODE_LABEL_LAYOUT: {
                KNodeLabelLayout kNodeLabelLayout = (KNodeLabelLayout)theEObject;
                T result = caseKNodeLabelLayout(kNodeLabelLayout);
                if (result == null) result = caseKShapeLayout(kNodeLabelLayout);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KLAYOUTER_INFO: {
                KLayouterInfo kLayouterInfo = (KLayouterInfo)theEObject;
                T result = caseKLayouterInfo(kLayouterInfo);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KLAYOUT_PORT: {
                KLayoutPort kLayoutPort = (KLayoutPort)theEObject;
                T result = caseKLayoutPort(kLayoutPort);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KPORT_LAYOUT: {
                KPortLayout kPortLayout = (KPortLayout)theEObject;
                T result = caseKPortLayout(kPortLayout);
                if (result == null) result = caseKShapeLayout(kPortLayout);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KPORT_LABEL: {
                KPortLabel kPortLabel = (KPortLabel)theEObject;
                T result = caseKPortLabel(kPortLabel);
                if (result == null) result = caseKLabel(kPortLabel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case KimlLayoutGraphPackage.KPORT_LABEL_LAYOUT: {
                KPortLabelLayout kPortLabelLayout = (KPortLabelLayout)theEObject;
                T result = caseKPortLabelLayout(kPortLabelLayout);
                if (result == null) result = caseKShapeLayout(kPortLabelLayout);
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
     * Returns the result of interpreting the object as an instance of '<em>KLayout Edge</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KLayout Edge</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKLayoutEdge(KLayoutEdge object) {
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
     * Returns the result of interpreting the object as an instance of '<em>KLayout Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KLayout Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKLayoutNode(KLayoutNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>KNode Layout</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KNode Layout</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKNodeLayout(KNodeLayout object) {
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
     * Returns the result of interpreting the object as an instance of '<em>KNode Label</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KNode Label</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKNodeLabel(KNodeLabel object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>KNode Label Layout</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KNode Label Layout</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKNodeLabelLayout(KNodeLabelLayout object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>KLayouter Info</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KLayouter Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKLayouterInfo(KLayouterInfo object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>KLayout Port</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KLayout Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKLayoutPort(KLayoutPort object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>KPort Layout</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KPort Layout</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKPortLayout(KPortLayout object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>KPort Label</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KPort Label</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKPortLabel(KPortLabel object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>KPort Label Layout</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>KPort Label Layout</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseKPortLabelLayout(KPortLabelLayout object) {
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
