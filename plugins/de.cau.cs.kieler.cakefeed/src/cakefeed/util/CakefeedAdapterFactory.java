/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.util;

import cakefeed.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cakefeed.CakefeedPackage
 * @generated
 */
public class CakefeedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CakefeedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CakefeedPackage.eINSTANCE;
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
	protected CakefeedSwitch<Adapter> modelSwitch =
		new CakefeedSwitch<Adapter>() {
			@Override
			public Adapter caseApplication(Application object) {
				return createApplicationAdapter();
			}
			@Override
			public Adapter caseFunctionBlock(FunctionBlock object) {
				return createFunctionBlockAdapter();
			}
			@Override
			public Adapter caseBasicFunctionBlock(BasicFunctionBlock object) {
				return createBasicFunctionBlockAdapter();
			}
			@Override
			public Adapter caseCompositeFunctionBlock(CompositeFunctionBlock object) {
				return createCompositeFunctionBlockAdapter();
			}
			@Override
			public Adapter caseServiceInterfaceFunctionBlock(ServiceInterfaceFunctionBlock object) {
				return createServiceInterfaceFunctionBlockAdapter();
			}
			@Override
			public Adapter caseFunctionBlockInstance(FunctionBlockInstance object) {
				return createFunctionBlockInstanceAdapter();
			}
			@Override
			public Adapter caseBasicFunctionBlockInstance(BasicFunctionBlockInstance object) {
				return createBasicFunctionBlockInstanceAdapter();
			}
			@Override
			public Adapter caseCompositeFunctionBlockInstance(CompositeFunctionBlockInstance object) {
				return createCompositeFunctionBlockInstanceAdapter();
			}
			@Override
			public Adapter caseServiceInterfaceFunctionBlockInstance(ServiceInterfaceFunctionBlockInstance object) {
				return createServiceInterfaceFunctionBlockInstanceAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseEventConnection(EventConnection object) {
				return createEventConnectionAdapter();
			}
			@Override
			public Adapter caseDataConnection(DataConnection object) {
				return createDataConnectionAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseEventPort(EventPort object) {
				return createEventPortAdapter();
			}
			@Override
			public Adapter caseDataPort(DataPort object) {
				return createDataPortAdapter();
			}
			@Override
			public Adapter caseInputEventPort(InputEventPort object) {
				return createInputEventPortAdapter();
			}
			@Override
			public Adapter caseOutputEventPort(OutputEventPort object) {
				return createOutputEventPortAdapter();
			}
			@Override
			public Adapter caseInputDataPort(InputDataPort object) {
				return createInputDataPortAdapter();
			}
			@Override
			public Adapter caseOutputDataPort(OutputDataPort object) {
				return createOutputDataPortAdapter();
			}
			@Override
			public Adapter caseAlgorithm(Algorithm object) {
				return createAlgorithmAdapter();
			}
			@Override
			public Adapter caseCompositeNetwork(CompositeNetwork object) {
				return createCompositeNetworkAdapter();
			}
			@Override
			public Adapter caseServiceSequence(ServiceSequence object) {
				return createServiceSequenceAdapter();
			}
			@Override
			public Adapter caseAssociation(Association object) {
				return createAssociationAdapter();
			}
			@Override
			public Adapter caseInputAssociation(InputAssociation object) {
				return createInputAssociationAdapter();
			}
			@Override
			public Adapter caseOutputAssociation(OutputAssociation object) {
				return createOutputAssociationAdapter();
			}
			@Override
			public Adapter caseInterface(Interface object) {
				return createInterfaceAdapter();
			}
			@Override
			public Adapter caseLibrary(Library object) {
				return createLibraryAdapter();
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
	 * Creates a new adapter for an object of class '{@link cakefeed.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.Application
	 * @generated
	 */
	public Adapter createApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.FunctionBlock <em>Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.FunctionBlock
	 * @generated
	 */
	public Adapter createFunctionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.BasicFunctionBlock <em>Basic Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.BasicFunctionBlock
	 * @generated
	 */
	public Adapter createBasicFunctionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.CompositeFunctionBlock <em>Composite Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.CompositeFunctionBlock
	 * @generated
	 */
	public Adapter createCompositeFunctionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.ServiceInterfaceFunctionBlock <em>Service Interface Function Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.ServiceInterfaceFunctionBlock
	 * @generated
	 */
	public Adapter createServiceInterfaceFunctionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.FunctionBlockInstance <em>Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.FunctionBlockInstance
	 * @generated
	 */
	public Adapter createFunctionBlockInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.BasicFunctionBlockInstance <em>Basic Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.BasicFunctionBlockInstance
	 * @generated
	 */
	public Adapter createBasicFunctionBlockInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.CompositeFunctionBlockInstance <em>Composite Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.CompositeFunctionBlockInstance
	 * @generated
	 */
	public Adapter createCompositeFunctionBlockInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.ServiceInterfaceFunctionBlockInstance <em>Service Interface Function Block Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.ServiceInterfaceFunctionBlockInstance
	 * @generated
	 */
	public Adapter createServiceInterfaceFunctionBlockInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.EventConnection <em>Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.EventConnection
	 * @generated
	 */
	public Adapter createEventConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.DataConnection <em>Data Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.DataConnection
	 * @generated
	 */
	public Adapter createDataConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.EventPort <em>Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.EventPort
	 * @generated
	 */
	public Adapter createEventPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.DataPort <em>Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.DataPort
	 * @generated
	 */
	public Adapter createDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.InputEventPort <em>Input Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.InputEventPort
	 * @generated
	 */
	public Adapter createInputEventPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.OutputEventPort <em>Output Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.OutputEventPort
	 * @generated
	 */
	public Adapter createOutputEventPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.InputDataPort <em>Input Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.InputDataPort
	 * @generated
	 */
	public Adapter createInputDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.OutputDataPort <em>Output Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.OutputDataPort
	 * @generated
	 */
	public Adapter createOutputDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.Algorithm
	 * @generated
	 */
	public Adapter createAlgorithmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.CompositeNetwork <em>Composite Network</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.CompositeNetwork
	 * @generated
	 */
	public Adapter createCompositeNetworkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.ServiceSequence <em>Service Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.ServiceSequence
	 * @generated
	 */
	public Adapter createServiceSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.Association
	 * @generated
	 */
	public Adapter createAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.InputAssociation <em>Input Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.InputAssociation
	 * @generated
	 */
	public Adapter createInputAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.OutputAssociation <em>Output Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.OutputAssociation
	 * @generated
	 */
	public Adapter createOutputAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link cakefeed.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see cakefeed.Library
	 * @generated
	 */
	public Adapter createLibraryAdapter() {
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

} //CakefeedAdapterFactory
