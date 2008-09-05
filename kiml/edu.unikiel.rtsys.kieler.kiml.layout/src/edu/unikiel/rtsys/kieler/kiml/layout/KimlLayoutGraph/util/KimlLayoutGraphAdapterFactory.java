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
			public Adapter casekPoint(kPoint object) {
				return createkPointAdapter();
			}
			@Override
			public Adapter casekDimension(kDimension object) {
				return createkDimensionAdapter();
			}
			@Override
			public Adapter casekInsets(kInsets object) {
				return createkInsetsAdapter();
			}
			@Override
			public Adapter casekEdge(kEdge object) {
				return createkEdgeAdapter();
			}
			@Override
			public Adapter casekLayoutGraph(kLayoutGraph object) {
				return createkLayoutGraphAdapter();
			}
			@Override
			public Adapter casekShapeLayout(kShapeLayout object) {
				return createkShapeLayoutAdapter();
			}
			@Override
			public Adapter casekEdgeLayout(kEdgeLayout object) {
				return createkEdgeLayoutAdapter();
			}
			@Override
			public Adapter casekNodeGroup(kNodeGroup object) {
				return createkNodeGroupAdapter();
			}
			@Override
			public Adapter casekEdgeLabel(kEdgeLabel object) {
				return createkEdgeLabelAdapter();
			}
			@Override
			public Adapter casekNodeGroupLayout(kNodeGroupLayout object) {
				return createkNodeGroupLayoutAdapter();
			}
			@Override
			public Adapter casekEdgeLabelLayout(kEdgeLabelLayout object) {
				return createkEdgeLabelLayoutAdapter();
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
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint <em>kPoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kPoint
	 * @generated
	 */
	public Adapter createkPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension <em>kDimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kDimension
	 * @generated
	 */
	public Adapter createkDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets <em>kInsets</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kInsets
	 * @generated
	 */
	public Adapter createkInsetsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge <em>kEdge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdge
	 * @generated
	 */
	public Adapter createkEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph <em>kLayout Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kLayoutGraph
	 * @generated
	 */
	public Adapter createkLayoutGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout <em>kShape Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kShapeLayout
	 * @generated
	 */
	public Adapter createkShapeLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout <em>kEdge Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLayout
	 * @generated
	 */
	public Adapter createkEdgeLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup <em>kNode Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroup
	 * @generated
	 */
	public Adapter createkNodeGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel <em>kEdge Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabel
	 * @generated
	 */
	public Adapter createkEdgeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout <em>kNode Group Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kNodeGroupLayout
	 * @generated
	 */
	public Adapter createkNodeGroupLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout <em>kEdge Label Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.kEdgeLabelLayout
	 * @generated
	 */
	public Adapter createkEdgeLabelLayoutAdapter() {
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
