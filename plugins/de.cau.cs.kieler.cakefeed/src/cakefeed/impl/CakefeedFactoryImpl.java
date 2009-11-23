/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class CakefeedFactoryImpl extends EFactoryImpl implements CakefeedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CakefeedFactory init() {
		try {
			CakefeedFactory theCakefeedFactory = (CakefeedFactory)EPackage.Registry.INSTANCE.getEFactory("http://kieler.cs.cau.de/cakefeed"); 
			if (theCakefeedFactory != null) {
				return theCakefeedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CakefeedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedFactoryImpl() {
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
			case CakefeedPackage.APPLICATION: return createApplication();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK: return createBasicFunctionBlock();
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK: return createCompositeFunctionBlock();
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK: return createServiceInterfaceFunctionBlock();
			case CakefeedPackage.BASIC_FUNCTION_BLOCK_INSTANCE: return createBasicFunctionBlockInstance();
			case CakefeedPackage.COMPOSITE_FUNCTION_BLOCK_INSTANCE: return createCompositeFunctionBlockInstance();
			case CakefeedPackage.SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE: return createServiceInterfaceFunctionBlockInstance();
			case CakefeedPackage.CONNECTION: return createConnection();
			case CakefeedPackage.EVENT_CONNECTION: return createEventConnection();
			case CakefeedPackage.DATA_CONNECTION: return createDataConnection();
			case CakefeedPackage.INPUT_EVENT_PORT: return createInputEventPort();
			case CakefeedPackage.OUTPUT_EVENT_PORT: return createOutputEventPort();
			case CakefeedPackage.INPUT_DATA_PORT: return createInputDataPort();
			case CakefeedPackage.OUTPUT_DATA_PORT: return createOutputDataPort();
			case CakefeedPackage.ALGORITHM: return createAlgorithm();
			case CakefeedPackage.COMPOSITE_NETWORK: return createCompositeNetwork();
			case CakefeedPackage.SERVICE_SEQUENCE: return createServiceSequence();
			case CakefeedPackage.ASSOCIATION: return createAssociation();
			case CakefeedPackage.INPUT_ASSOCIATION: return createInputAssociation();
			case CakefeedPackage.OUTPUT_ASSOCIATION: return createOutputAssociation();
			case CakefeedPackage.INTERFACE: return createInterface();
			case CakefeedPackage.LIBRARY: return createLibrary();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CakefeedPackage.PORT_TYPE:
				return createPortTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CakefeedPackage.PORT_TYPE:
				return convertPortTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application createApplication() {
		ApplicationImpl application = new ApplicationImpl();
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionBlock createBasicFunctionBlock() {
		BasicFunctionBlockImpl basicFunctionBlock = new BasicFunctionBlockImpl();
		return basicFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeFunctionBlock createCompositeFunctionBlock() {
		CompositeFunctionBlockImpl compositeFunctionBlock = new CompositeFunctionBlockImpl();
		return compositeFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInterfaceFunctionBlock createServiceInterfaceFunctionBlock() {
		ServiceInterfaceFunctionBlockImpl serviceInterfaceFunctionBlock = new ServiceInterfaceFunctionBlockImpl();
		return serviceInterfaceFunctionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionBlockInstance createBasicFunctionBlockInstance() {
		BasicFunctionBlockInstanceImpl basicFunctionBlockInstance = new BasicFunctionBlockInstanceImpl();
		return basicFunctionBlockInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeFunctionBlockInstance createCompositeFunctionBlockInstance() {
		CompositeFunctionBlockInstanceImpl compositeFunctionBlockInstance = new CompositeFunctionBlockInstanceImpl();
		return compositeFunctionBlockInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInterfaceFunctionBlockInstance createServiceInterfaceFunctionBlockInstance() {
		ServiceInterfaceFunctionBlockInstanceImpl serviceInterfaceFunctionBlockInstance = new ServiceInterfaceFunctionBlockInstanceImpl();
		return serviceInterfaceFunctionBlockInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventConnection createEventConnection() {
		EventConnectionImpl eventConnection = new EventConnectionImpl();
		return eventConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataConnection createDataConnection() {
		DataConnectionImpl dataConnection = new DataConnectionImpl();
		return dataConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEventPort createInputEventPort() {
		InputEventPortImpl inputEventPort = new InputEventPortImpl();
		return inputEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputEventPort createOutputEventPort() {
		OutputEventPortImpl outputEventPort = new OutputEventPortImpl();
		return outputEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDataPort createInputDataPort() {
		InputDataPortImpl inputDataPort = new InputDataPortImpl();
		return inputDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDataPort createOutputDataPort() {
		OutputDataPortImpl outputDataPort = new OutputDataPortImpl();
		return outputDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Algorithm createAlgorithm() {
		AlgorithmImpl algorithm = new AlgorithmImpl();
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeNetwork createCompositeNetwork() {
		CompositeNetworkImpl compositeNetwork = new CompositeNetworkImpl();
		return compositeNetwork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceSequence createServiceSequence() {
		ServiceSequenceImpl serviceSequence = new ServiceSequenceImpl();
		return serviceSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputAssociation createInputAssociation() {
		InputAssociationImpl inputAssociation = new InputAssociationImpl();
		return inputAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputAssociation createOutputAssociation() {
		OutputAssociationImpl outputAssociation = new OutputAssociationImpl();
		return outputAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface createInterface() {
		InterfaceImpl interface_ = new InterfaceImpl();
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortType createPortTypeFromString(EDataType eDataType, String initialValue) {
		PortType result = PortType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedPackage getCakefeedPackage() {
		return (CakefeedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CakefeedPackage getPackage() {
		return CakefeedPackage.eINSTANCE;
	}

} //CakefeedFactoryImpl
