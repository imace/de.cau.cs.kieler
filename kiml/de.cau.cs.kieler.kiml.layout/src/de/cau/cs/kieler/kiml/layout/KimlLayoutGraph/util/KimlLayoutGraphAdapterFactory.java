/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.util;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage
 * @generated
 */
public class KimlLayoutGraphAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static KimlLayoutGraphPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public KimlLayoutGraphAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = KimlLayoutGraphPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected KimlLayoutGraphSwitch<Adapter> modelSwitch =
		new KimlLayoutGraphSwitch<Adapter>() {
            @Override
            public Adapter caseKPoint(KPoint object) {
                return createKPointAdapter();
            }
            @Override
            public Adapter caseKDimension(KDimension object) {
                return createKDimensionAdapter();
            }
            @Override
            public Adapter caseKInsets(KInsets object) {
                return createKInsetsAdapter();
            }
            @Override
            public Adapter caseKLayoutGraph(KLayoutGraph object) {
                return createKLayoutGraphAdapter();
            }
            @Override
            public Adapter caseKShapeLayout(KShapeLayout object) {
                return createKShapeLayoutAdapter();
            }
            @Override
            public Adapter caseKLayoutEdge(KLayoutEdge object) {
                return createKLayoutEdgeAdapter();
            }
            @Override
            public Adapter caseKEdgeLayout(KEdgeLayout object) {
                return createKEdgeLayoutAdapter();
            }
            @Override
            public Adapter caseKLayoutNode(KLayoutNode object) {
                return createKLayoutNodeAdapter();
            }
            @Override
            public Adapter caseKNodeLayout(KNodeLayout object) {
                return createKNodeLayoutAdapter();
            }
            @Override
            public Adapter caseKLabel(KLabel object) {
                return createKLabelAdapter();
            }
            @Override
            public Adapter caseKEdgeLabel(KEdgeLabel object) {
                return createKEdgeLabelAdapter();
            }
            @Override
            public Adapter caseKEdgeLabelLayout(KEdgeLabelLayout object) {
                return createKEdgeLabelLayoutAdapter();
            }
            @Override
            public Adapter caseKNodeLabel(KNodeLabel object) {
                return createKNodeLabelAdapter();
            }
            @Override
            public Adapter caseKNodeLabelLayout(KNodeLabelLayout object) {
                return createKNodeLabelLayoutAdapter();
            }
            @Override
            public Adapter caseKLayouterInfo(KLayouterInfo object) {
                return createKLayouterInfoAdapter();
            }
            @Override
            public Adapter caseKLayoutPort(KLayoutPort object) {
                return createKLayoutPortAdapter();
            }
            @Override
            public Adapter caseKPortLayout(KPortLayout object) {
                return createKPortLayoutAdapter();
            }
            @Override
            public Adapter caseKPortLabel(KPortLabel object) {
                return createKPortLabelAdapter();
            }
            @Override
            public Adapter caseKPortLabelLayout(KPortLabelLayout object) {
                return createKPortLabelLayoutAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint <em>KPoint</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint
     * @generated
     */
	public Adapter createKPointAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension <em>KDimension</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension
     * @generated
     */
	public Adapter createKDimensionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets <em>KInsets</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets
     * @generated
     */
	public Adapter createKInsetsAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph <em>KLayout Graph</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph
     * @generated
     */
	public Adapter createKLayoutGraphAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout <em>KShape Layout</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout
     * @generated
     */
	public Adapter createKShapeLayoutAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge <em>KLayout Edge</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutEdge
     * @generated
     */
	public Adapter createKLayoutEdgeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout <em>KEdge Layout</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout
     * @generated
     */
	public Adapter createKEdgeLayoutAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode <em>KLayout Node</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutNode
     * @generated
     */
	public Adapter createKLayoutNodeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout <em>KNode Layout</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLayout
     * @generated
     */
	public Adapter createKNodeLayoutAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel <em>KLabel</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLabel
     * @generated
     */
	public Adapter createKLabelAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel <em>KEdge Label</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel
     * @generated
     */
	public Adapter createKEdgeLabelAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout <em>KEdge Label Layout</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout
     * @generated
     */
	public Adapter createKEdgeLabelLayoutAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel <em>KNode Label</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabel
     * @generated
     */
	public Adapter createKNodeLabelAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout <em>KNode Label Layout</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KNodeLabelLayout
     * @generated
     */
	public Adapter createKNodeLabelLayoutAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo <em>KLayouter Info</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayouterInfo
     * @generated
     */
	public Adapter createKLayouterInfoAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort <em>KLayout Port</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutPort
     * @generated
     */
	public Adapter createKLayoutPortAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout <em>KPort Layout</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLayout
     * @generated
     */
	public Adapter createKPortLayoutAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel <em>KPort Label</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabel
     * @generated
     */
	public Adapter createKPortLabelAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout <em>KPort Label Layout</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPortLabelLayout
     * @generated
     */
	public Adapter createKPortLabelLayoutAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //KimlLayoutGraphAdapterFactory
