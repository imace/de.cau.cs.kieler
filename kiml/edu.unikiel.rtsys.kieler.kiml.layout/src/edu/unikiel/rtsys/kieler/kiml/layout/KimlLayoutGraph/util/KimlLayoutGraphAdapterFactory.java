/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.util;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphPackage
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
			public Adapter caseKEdge(KEdge object) {
				return createKEdgeAdapter();
			}
			@Override
			public Adapter caseKEdgeLayout(KEdgeLayout object) {
				return createKEdgeLayoutAdapter();
			}
			@Override
			public Adapter caseKNodeGroup(KNodeGroup object) {
				return createKNodeGroupAdapter();
			}
			@Override
			public Adapter caseKNodeGroupLayout(KNodeGroupLayout object) {
				return createKNodeGroupLayoutAdapter();
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
			public Adapter caseKNodeGroupLabel(KNodeGroupLabel object) {
				return createKNodeGroupLabelAdapter();
			}
			@Override
			public Adapter caseKNodeGroupLabelLayout(KNodeGroupLabelLayout object) {
				return createKNodeGroupLabelLayoutAdapter();
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
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint <em>KPoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint
	 * @generated
	 */
	public Adapter createKPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension <em>KDimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension
	 * @generated
	 */
	public Adapter createKDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets <em>KInsets</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KInsets
	 * @generated
	 */
	public Adapter createKInsetsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph <em>KLayout Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph
	 * @generated
	 */
	public Adapter createKLayoutGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout <em>KShape Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KShapeLayout
	 * @generated
	 */
	public Adapter createKShapeLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge <em>KEdge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdge
	 * @generated
	 */
	public Adapter createKEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout <em>KEdge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLayout
	 * @generated
	 */
	public Adapter createKEdgeLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup <em>KNode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup
	 * @generated
	 */
	public Adapter createKNodeGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout <em>KNode Group Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLayout
	 * @generated
	 */
	public Adapter createKNodeGroupLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel <em>KLabel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KLabel
	 * @generated
	 */
	public Adapter createKLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel <em>KEdge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabel
	 * @generated
	 */
	public Adapter createKEdgeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout <em>KEdge Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KEdgeLabelLayout
	 * @generated
	 */
	public Adapter createKEdgeLabelLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel <em>KNode Group Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabel
	 * @generated
	 */
	public Adapter createKNodeGroupLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout <em>KNode Group Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroupLabelLayout
	 * @generated
	 */
	public Adapter createKNodeGroupLabelLayoutAdapter() {
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
