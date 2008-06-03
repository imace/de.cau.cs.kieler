/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hierarchymealy.impl;

import hierarchymealy.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MealyFactoryImpl extends EFactoryImpl implements MealyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MealyFactory init() {
		try {
			MealyFactory theMealyFactory = (MealyFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.informatik.uni-kiel.de/rtsys/hmealy"); 
			if (theMealyFactory != null) {
				return theMealyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MealyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MealyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MealyPackage.HIERARCHY_MEALY_MACHINE: return createHierarchyMealyMachine();
			case MealyPackage.STATE: return createState();
			case MealyPackage.EDGE: return createEdge();
			case MealyPackage.COMPOSITE_STATE: return createCompositeState();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HierarchyMealyMachine createHierarchyMealyMachine() {
		HierarchyMealyMachineImpl hierarchyMealyMachine = new HierarchyMealyMachineImpl();
		return hierarchyMealyMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState createCompositeState() {
		CompositeStateImpl compositeState = new CompositeStateImpl();
		return compositeState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MealyPackage getMealyPackage() {
		return (MealyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MealyPackage getPackage() {
		return MealyPackage.eINSTANCE;
	}

} //MealyFactoryImpl
