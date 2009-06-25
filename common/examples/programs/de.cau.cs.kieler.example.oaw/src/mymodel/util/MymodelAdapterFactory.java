/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mymodel.util;

import mymodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see mymodel.MymodelPackage
 * @generated
 */
public class MymodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MymodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MymodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MymodelPackage.eINSTANCE;
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
	protected MymodelSwitch<Adapter> modelSwitch =
		new MymodelSwitch<Adapter>() {
			@Override
			public Adapter caseMyString(MyString object) {
				return createMyStringAdapter();
			}
			@Override
			public Adapter caseMyInt(MyInt object) {
				return createMyIntAdapter();
			}
			@Override
			public Adapter caseMyData(MyData object) {
				return createMyDataAdapter();
			}
			@Override
			public Adapter caseMyConst(MyConst object) {
				return createMyConstAdapter();
			}
			@Override
			public Adapter caseMyList(MyList object) {
				return createMyListAdapter();
			}
			@Override
			public Adapter caseMyDataModel(MyDataModel object) {
				return createMyDataModelAdapter();
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
	 * Creates a new adapter for an object of class '{@link mymodel.MyString <em>My String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mymodel.MyString
	 * @generated
	 */
	public Adapter createMyStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mymodel.MyInt <em>My Int</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mymodel.MyInt
	 * @generated
	 */
	public Adapter createMyIntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mymodel.MyData <em>My Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mymodel.MyData
	 * @generated
	 */
	public Adapter createMyDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mymodel.MyConst <em>My Const</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mymodel.MyConst
	 * @generated
	 */
	public Adapter createMyConstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mymodel.MyList <em>My List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mymodel.MyList
	 * @generated
	 */
	public Adapter createMyListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mymodel.MyDataModel <em>My Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mymodel.MyDataModel
	 * @generated
	 */
	public Adapter createMyDataModelAdapter() {
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

} //MymodelAdapterFactory
