/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package cakefeed.impl;

import cakefeed.Algorithm;
import cakefeed.Application;
import cakefeed.Association;
import cakefeed.BasicFunctionBlock;
import cakefeed.BasicFunctionBlockInstance;
import cakefeed.CakefeedFactory;
import cakefeed.CakefeedPackage;
import cakefeed.CompositeFunctionBlock;
import cakefeed.CompositeFunctionBlockInstance;
import cakefeed.CompositeNetwork;
import cakefeed.Connection;
import cakefeed.DataConnection;
import cakefeed.DataPort;
import cakefeed.EventConnection;
import cakefeed.EventPort;
import cakefeed.FunctionBlock;
import cakefeed.FunctionBlockInstance;
import cakefeed.InputAssociation;
import cakefeed.InputDataPort;
import cakefeed.InputEventPort;
import cakefeed.Interface;
import cakefeed.Library;
import cakefeed.OutputAssociation;
import cakefeed.OutputDataPort;
import cakefeed.OutputEventPort;
import cakefeed.Port;
import cakefeed.PortType;
import cakefeed.ServiceInterfaceFunctionBlock;
import cakefeed.ServiceInterfaceFunctionBlockInstance;
import cakefeed.ServiceSequence;

import de.cau.cs.kieler.synccharts.SyncchartsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CakefeedPackageImpl extends EPackageImpl implements CakefeedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicFunctionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeFunctionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceInterfaceFunctionBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionBlockInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicFunctionBlockInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeFunctionBlockInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceInterfaceFunctionBlockInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEventPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEventPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputDataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputDataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass algorithmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeNetworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see cakefeed.CakefeedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CakefeedPackageImpl() {
		super(eNS_URI, CakefeedFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CakefeedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CakefeedPackage init() {
		if (isInited) return (CakefeedPackage)EPackage.Registry.INSTANCE.getEPackage(CakefeedPackage.eNS_URI);

		// Obtain or create and register package
		CakefeedPackageImpl theCakefeedPackage = (CakefeedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CakefeedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CakefeedPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SyncchartsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCakefeedPackage.createPackageContents();

		// Initialize created meta-data
		theCakefeedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCakefeedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CakefeedPackage.eNS_URI, theCakefeedPackage);
		return theCakefeedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplication() {
		return applicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplication_ApplicationName() {
		return (EAttribute)applicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_FunctionBlocksInstances() {
		return (EReference)applicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_Connections() {
		return (EReference)applicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionBlock() {
		return functionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_ParentInterface() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionBlock_TypeName() {
		return (EAttribute)functionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_InputEventPorts() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_OutputEventPorts() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_InputDataPorts() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlock_OutputDataPorts() {
		return (EReference)functionBlockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicFunctionBlock() {
		return basicFunctionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlock_ExecutionControlChart() {
		return (EReference)basicFunctionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlock_Algorithms() {
		return (EReference)basicFunctionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeFunctionBlock() {
		return compositeFunctionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeFunctionBlock_CompositeNetwork() {
		return (EReference)compositeFunctionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeFunctionBlock_ServiceSequence() {
		return (EReference)compositeFunctionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceInterfaceFunctionBlock() {
		return serviceInterfaceFunctionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceInterfaceFunctionBlock_ServiceSequence() {
		return (EReference)serviceInterfaceFunctionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionBlockInstance() {
		return functionBlockInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionBlockInstance_ParentApplication() {
		return (EReference)functionBlockInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionBlockInstance_InstanceName() {
		return (EAttribute)functionBlockInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicFunctionBlockInstance() {
		return basicFunctionBlockInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunctionBlockInstance_Type() {
		return (EReference)basicFunctionBlockInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeFunctionBlockInstance() {
		return compositeFunctionBlockInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeFunctionBlockInstance_Type() {
		return (EReference)compositeFunctionBlockInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceInterfaceFunctionBlockInstance() {
		return serviceInterfaceFunctionBlockInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceInterfaceFunctionBlockInstance_Type() {
		return (EReference)serviceInterfaceFunctionBlockInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_ParentApplication() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventConnection() {
		return eventConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventConnection_SourceEventPort() {
		return (EReference)eventConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventConnection_TargetEventPort() {
		return (EReference)eventConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataConnection() {
		return dataConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataConnection_SourceDataPort() {
		return (EReference)dataConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataConnection_TargetDataPort() {
		return (EReference)dataConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_PortName() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventPort() {
		return eventPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataPort() {
		return dataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_PortType() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputEventPort() {
		return inputEventPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputEventPort_ParentFunctionBlock() {
		return (EReference)inputEventPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputEventPort_EventConnections() {
		return (EReference)inputEventPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputEventPort_InputAssociations() {
		return (EReference)inputEventPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputEventPort() {
		return outputEventPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputEventPort_ParentFunctionBlock() {
		return (EReference)outputEventPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputEventPort_EventConnections() {
		return (EReference)outputEventPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputEventPort_OutputAssociations() {
		return (EReference)outputEventPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputDataPort() {
		return inputDataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputDataPort_ParentFunctionBlock() {
		return (EReference)inputDataPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputDataPort_EventConnections() {
		return (EReference)inputDataPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputDataPort_InputAssociations() {
		return (EReference)inputDataPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputDataPort() {
		return outputDataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputDataPort_ParentFunctionBlock() {
		return (EReference)outputDataPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputDataPort_EventConnections() {
		return (EReference)outputDataPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputDataPort_OutputAssociations() {
		return (EReference)outputDataPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlgorithm() {
		return algorithmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlgorithm_AlgorithmName() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlgorithm_AlgorithmLanguage() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlgorithm_AlgorithmSourceCode() {
		return (EAttribute)algorithmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeNetwork() {
		return compositeNetworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNetwork_ParentCompositeFunctionBlock() {
		return (EReference)compositeNetworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNetwork_InputEvents() {
		return (EReference)compositeNetworkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNetwork_OutputEvents() {
		return (EReference)compositeNetworkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNetwork_InputData() {
		return (EReference)compositeNetworkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNetwork_OutputData() {
		return (EReference)compositeNetworkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceSequence() {
		return serviceSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputAssociation() {
		return inputAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputAssociation_SourceInputEventPort() {
		return (EReference)inputAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputAssociation_TargetInputDataPort() {
		return (EReference)inputAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputAssociation() {
		return outputAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputAssociation_SourceOutputEventPort() {
		return (EReference)outputAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputAssociation_TargetOutputDataPort() {
		return (EReference)outputAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_FunctionBlock() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Interfaces() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Algorithms() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Applications() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_CompositeNetworks() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_SyncCharts() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_ServiceSequences() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPortType() {
		return portTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CakefeedFactory getCakefeedFactory() {
		return (CakefeedFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		applicationEClass = createEClass(APPLICATION);
		createEAttribute(applicationEClass, APPLICATION__APPLICATION_NAME);
		createEReference(applicationEClass, APPLICATION__FUNCTION_BLOCKS_INSTANCES);
		createEReference(applicationEClass, APPLICATION__CONNECTIONS);

		functionBlockEClass = createEClass(FUNCTION_BLOCK);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__PARENT_INTERFACE);
		createEAttribute(functionBlockEClass, FUNCTION_BLOCK__TYPE_NAME);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__INPUT_EVENT_PORTS);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__OUTPUT_EVENT_PORTS);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__INPUT_DATA_PORTS);
		createEReference(functionBlockEClass, FUNCTION_BLOCK__OUTPUT_DATA_PORTS);

		basicFunctionBlockEClass = createEClass(BASIC_FUNCTION_BLOCK);
		createEReference(basicFunctionBlockEClass, BASIC_FUNCTION_BLOCK__EXECUTION_CONTROL_CHART);
		createEReference(basicFunctionBlockEClass, BASIC_FUNCTION_BLOCK__ALGORITHMS);

		compositeFunctionBlockEClass = createEClass(COMPOSITE_FUNCTION_BLOCK);
		createEReference(compositeFunctionBlockEClass, COMPOSITE_FUNCTION_BLOCK__COMPOSITE_NETWORK);
		createEReference(compositeFunctionBlockEClass, COMPOSITE_FUNCTION_BLOCK__SERVICE_SEQUENCE);

		serviceInterfaceFunctionBlockEClass = createEClass(SERVICE_INTERFACE_FUNCTION_BLOCK);
		createEReference(serviceInterfaceFunctionBlockEClass, SERVICE_INTERFACE_FUNCTION_BLOCK__SERVICE_SEQUENCE);

		functionBlockInstanceEClass = createEClass(FUNCTION_BLOCK_INSTANCE);
		createEReference(functionBlockInstanceEClass, FUNCTION_BLOCK_INSTANCE__PARENT_APPLICATION);
		createEAttribute(functionBlockInstanceEClass, FUNCTION_BLOCK_INSTANCE__INSTANCE_NAME);

		basicFunctionBlockInstanceEClass = createEClass(BASIC_FUNCTION_BLOCK_INSTANCE);
		createEReference(basicFunctionBlockInstanceEClass, BASIC_FUNCTION_BLOCK_INSTANCE__TYPE);

		compositeFunctionBlockInstanceEClass = createEClass(COMPOSITE_FUNCTION_BLOCK_INSTANCE);
		createEReference(compositeFunctionBlockInstanceEClass, COMPOSITE_FUNCTION_BLOCK_INSTANCE__TYPE);

		serviceInterfaceFunctionBlockInstanceEClass = createEClass(SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE);
		createEReference(serviceInterfaceFunctionBlockInstanceEClass, SERVICE_INTERFACE_FUNCTION_BLOCK_INSTANCE__TYPE);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__PARENT_APPLICATION);

		eventConnectionEClass = createEClass(EVENT_CONNECTION);
		createEReference(eventConnectionEClass, EVENT_CONNECTION__SOURCE_EVENT_PORT);
		createEReference(eventConnectionEClass, EVENT_CONNECTION__TARGET_EVENT_PORT);

		dataConnectionEClass = createEClass(DATA_CONNECTION);
		createEReference(dataConnectionEClass, DATA_CONNECTION__SOURCE_DATA_PORT);
		createEReference(dataConnectionEClass, DATA_CONNECTION__TARGET_DATA_PORT);

		portEClass = createEClass(PORT);
		createEAttribute(portEClass, PORT__PORT_NAME);

		eventPortEClass = createEClass(EVENT_PORT);

		dataPortEClass = createEClass(DATA_PORT);
		createEAttribute(dataPortEClass, DATA_PORT__PORT_TYPE);

		inputEventPortEClass = createEClass(INPUT_EVENT_PORT);
		createEReference(inputEventPortEClass, INPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK);
		createEReference(inputEventPortEClass, INPUT_EVENT_PORT__EVENT_CONNECTIONS);
		createEReference(inputEventPortEClass, INPUT_EVENT_PORT__INPUT_ASSOCIATIONS);

		outputEventPortEClass = createEClass(OUTPUT_EVENT_PORT);
		createEReference(outputEventPortEClass, OUTPUT_EVENT_PORT__PARENT_FUNCTION_BLOCK);
		createEReference(outputEventPortEClass, OUTPUT_EVENT_PORT__EVENT_CONNECTIONS);
		createEReference(outputEventPortEClass, OUTPUT_EVENT_PORT__OUTPUT_ASSOCIATIONS);

		inputDataPortEClass = createEClass(INPUT_DATA_PORT);
		createEReference(inputDataPortEClass, INPUT_DATA_PORT__PARENT_FUNCTION_BLOCK);
		createEReference(inputDataPortEClass, INPUT_DATA_PORT__EVENT_CONNECTIONS);
		createEReference(inputDataPortEClass, INPUT_DATA_PORT__INPUT_ASSOCIATIONS);

		outputDataPortEClass = createEClass(OUTPUT_DATA_PORT);
		createEReference(outputDataPortEClass, OUTPUT_DATA_PORT__PARENT_FUNCTION_BLOCK);
		createEReference(outputDataPortEClass, OUTPUT_DATA_PORT__EVENT_CONNECTIONS);
		createEReference(outputDataPortEClass, OUTPUT_DATA_PORT__OUTPUT_ASSOCIATIONS);

		algorithmEClass = createEClass(ALGORITHM);
		createEAttribute(algorithmEClass, ALGORITHM__ALGORITHM_NAME);
		createEAttribute(algorithmEClass, ALGORITHM__ALGORITHM_LANGUAGE);
		createEAttribute(algorithmEClass, ALGORITHM__ALGORITHM_SOURCE_CODE);

		compositeNetworkEClass = createEClass(COMPOSITE_NETWORK);
		createEReference(compositeNetworkEClass, COMPOSITE_NETWORK__PARENT_COMPOSITE_FUNCTION_BLOCK);
		createEReference(compositeNetworkEClass, COMPOSITE_NETWORK__INPUT_EVENTS);
		createEReference(compositeNetworkEClass, COMPOSITE_NETWORK__OUTPUT_EVENTS);
		createEReference(compositeNetworkEClass, COMPOSITE_NETWORK__INPUT_DATA);
		createEReference(compositeNetworkEClass, COMPOSITE_NETWORK__OUTPUT_DATA);

		serviceSequenceEClass = createEClass(SERVICE_SEQUENCE);

		associationEClass = createEClass(ASSOCIATION);

		inputAssociationEClass = createEClass(INPUT_ASSOCIATION);
		createEReference(inputAssociationEClass, INPUT_ASSOCIATION__SOURCE_INPUT_EVENT_PORT);
		createEReference(inputAssociationEClass, INPUT_ASSOCIATION__TARGET_INPUT_DATA_PORT);

		outputAssociationEClass = createEClass(OUTPUT_ASSOCIATION);
		createEReference(outputAssociationEClass, OUTPUT_ASSOCIATION__SOURCE_OUTPUT_EVENT_PORT);
		createEReference(outputAssociationEClass, OUTPUT_ASSOCIATION__TARGET_OUTPUT_DATA_PORT);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__FUNCTION_BLOCK);

		libraryEClass = createEClass(LIBRARY);
		createEReference(libraryEClass, LIBRARY__INTERFACES);
		createEReference(libraryEClass, LIBRARY__ALGORITHMS);
		createEReference(libraryEClass, LIBRARY__APPLICATIONS);
		createEReference(libraryEClass, LIBRARY__COMPOSITE_NETWORKS);
		createEReference(libraryEClass, LIBRARY__SYNC_CHARTS);
		createEReference(libraryEClass, LIBRARY__SERVICE_SEQUENCES);

		// Create enums
		portTypeEEnum = createEEnum(PORT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SyncchartsPackage theSyncchartsPackage = (SyncchartsPackage)EPackage.Registry.INSTANCE.getEPackage(SyncchartsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		basicFunctionBlockEClass.getESuperTypes().add(this.getFunctionBlock());
		compositeFunctionBlockEClass.getESuperTypes().add(this.getFunctionBlock());
		serviceInterfaceFunctionBlockEClass.getESuperTypes().add(this.getFunctionBlock());
		functionBlockInstanceEClass.getESuperTypes().add(this.getFunctionBlock());
		basicFunctionBlockInstanceEClass.getESuperTypes().add(this.getFunctionBlockInstance());
		basicFunctionBlockInstanceEClass.getESuperTypes().add(this.getBasicFunctionBlock());
		compositeFunctionBlockInstanceEClass.getESuperTypes().add(this.getFunctionBlockInstance());
		compositeFunctionBlockInstanceEClass.getESuperTypes().add(this.getCompositeFunctionBlock());
		serviceInterfaceFunctionBlockInstanceEClass.getESuperTypes().add(this.getFunctionBlockInstance());
		serviceInterfaceFunctionBlockInstanceEClass.getESuperTypes().add(this.getServiceInterfaceFunctionBlock());
		eventConnectionEClass.getESuperTypes().add(this.getConnection());
		dataConnectionEClass.getESuperTypes().add(this.getConnection());
		eventPortEClass.getESuperTypes().add(this.getPort());
		dataPortEClass.getESuperTypes().add(this.getPort());
		inputEventPortEClass.getESuperTypes().add(this.getEventPort());
		outputEventPortEClass.getESuperTypes().add(this.getEventPort());
		inputDataPortEClass.getESuperTypes().add(this.getDataPort());
		outputDataPortEClass.getESuperTypes().add(this.getDataPort());
		compositeNetworkEClass.getESuperTypes().add(this.getApplication());
		inputAssociationEClass.getESuperTypes().add(this.getAssociation());
		outputAssociationEClass.getESuperTypes().add(this.getAssociation());

		// Initialize classes and features; add operations and parameters
		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplication_ApplicationName(), ecorePackage.getEString(), "applicationName", null, 1, 1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_FunctionBlocksInstances(), this.getFunctionBlockInstance(), this.getFunctionBlockInstance_ParentApplication(), "functionBlocksInstances", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_Connections(), this.getConnection(), this.getConnection_ParentApplication(), "connections", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionBlockEClass, FunctionBlock.class, "FunctionBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionBlock_ParentInterface(), this.getInterface(), this.getInterface_FunctionBlock(), "parentInterface", null, 1, 1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionBlock_TypeName(), ecorePackage.getEString(), "typeName", "", 1, 1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_InputEventPorts(), this.getInputEventPort(), this.getInputEventPort_ParentFunctionBlock(), "inputEventPorts", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_OutputEventPorts(), this.getOutputEventPort(), this.getOutputEventPort_ParentFunctionBlock(), "outputEventPorts", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_InputDataPorts(), this.getInputDataPort(), this.getInputDataPort_ParentFunctionBlock(), "inputDataPorts", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionBlock_OutputDataPorts(), this.getOutputDataPort(), this.getOutputDataPort_ParentFunctionBlock(), "outputDataPorts", null, 0, -1, FunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicFunctionBlockEClass, BasicFunctionBlock.class, "BasicFunctionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicFunctionBlock_ExecutionControlChart(), theSyncchartsPackage.getState(), null, "executionControlChart", null, 0, 1, BasicFunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicFunctionBlock_Algorithms(), this.getAlgorithm(), null, "algorithms", null, 0, -1, BasicFunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFunctionBlockEClass, CompositeFunctionBlock.class, "CompositeFunctionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFunctionBlock_CompositeNetwork(), this.getCompositeNetwork(), this.getCompositeNetwork_ParentCompositeFunctionBlock(), "compositeNetwork", null, 1, 1, CompositeFunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeFunctionBlock_ServiceSequence(), this.getServiceSequence(), null, "serviceSequence", null, 0, 1, CompositeFunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceInterfaceFunctionBlockEClass, ServiceInterfaceFunctionBlock.class, "ServiceInterfaceFunctionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceInterfaceFunctionBlock_ServiceSequence(), this.getServiceSequence(), null, "serviceSequence", null, 0, 1, ServiceInterfaceFunctionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionBlockInstanceEClass, FunctionBlockInstance.class, "FunctionBlockInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionBlockInstance_ParentApplication(), this.getApplication(), this.getApplication_FunctionBlocksInstances(), "parentApplication", null, 1, 1, FunctionBlockInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionBlockInstance_InstanceName(), ecorePackage.getEString(), "instanceName", null, 1, 1, FunctionBlockInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicFunctionBlockInstanceEClass, BasicFunctionBlockInstance.class, "BasicFunctionBlockInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicFunctionBlockInstance_Type(), this.getBasicFunctionBlock(), null, "type", null, 1, 1, BasicFunctionBlockInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFunctionBlockInstanceEClass, CompositeFunctionBlockInstance.class, "CompositeFunctionBlockInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFunctionBlockInstance_Type(), this.getCompositeFunctionBlock(), null, "type", null, 1, 1, CompositeFunctionBlockInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceInterfaceFunctionBlockInstanceEClass, ServiceInterfaceFunctionBlockInstance.class, "ServiceInterfaceFunctionBlockInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceInterfaceFunctionBlockInstance_Type(), this.getServiceInterfaceFunctionBlock(), null, "type", null, 1, 1, ServiceInterfaceFunctionBlockInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_ParentApplication(), this.getApplication(), this.getApplication_Connections(), "parentApplication", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventConnectionEClass, EventConnection.class, "EventConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventConnection_SourceEventPort(), this.getOutputEventPort(), this.getOutputEventPort_EventConnections(), "sourceEventPort", null, 1, 1, EventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventConnection_TargetEventPort(), this.getInputEventPort(), this.getInputEventPort_EventConnections(), "targetEventPort", null, 1, 1, EventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataConnectionEClass, DataConnection.class, "DataConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataConnection_SourceDataPort(), this.getOutputDataPort(), this.getOutputDataPort_EventConnections(), "sourceDataPort", null, 1, 1, DataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataConnection_TargetDataPort(), this.getInputDataPort(), this.getInputDataPort_EventConnections(), "targetDataPort", null, 1, 1, DataConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPort_PortName(), ecorePackage.getEString(), "portName", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventPortEClass, EventPort.class, "EventPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataPortEClass, DataPort.class, "DataPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataPort_PortType(), this.getPortType(), "portType", null, 1, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputEventPortEClass, InputEventPort.class, "InputEventPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputEventPort_ParentFunctionBlock(), this.getFunctionBlock(), this.getFunctionBlock_InputEventPorts(), "parentFunctionBlock", null, 1, 1, InputEventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputEventPort_EventConnections(), this.getEventConnection(), this.getEventConnection_TargetEventPort(), "eventConnections", null, 0, -1, InputEventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputEventPort_InputAssociations(), this.getInputAssociation(), this.getInputAssociation_SourceInputEventPort(), "inputAssociations", null, 0, -1, InputEventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputEventPortEClass, OutputEventPort.class, "OutputEventPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputEventPort_ParentFunctionBlock(), this.getFunctionBlock(), this.getFunctionBlock_OutputEventPorts(), "parentFunctionBlock", null, 1, 1, OutputEventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputEventPort_EventConnections(), this.getEventConnection(), this.getEventConnection_SourceEventPort(), "eventConnections", null, 0, -1, OutputEventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputEventPort_OutputAssociations(), this.getOutputAssociation(), this.getOutputAssociation_SourceOutputEventPort(), "outputAssociations", null, 0, -1, OutputEventPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputDataPortEClass, InputDataPort.class, "InputDataPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputDataPort_ParentFunctionBlock(), this.getFunctionBlock(), this.getFunctionBlock_InputDataPorts(), "parentFunctionBlock", null, 1, 1, InputDataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputDataPort_EventConnections(), this.getDataConnection(), this.getDataConnection_TargetDataPort(), "eventConnections", null, 0, -1, InputDataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputDataPort_InputAssociations(), this.getInputAssociation(), this.getInputAssociation_TargetInputDataPort(), "inputAssociations", null, 0, -1, InputDataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputDataPortEClass, OutputDataPort.class, "OutputDataPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputDataPort_ParentFunctionBlock(), this.getFunctionBlock(), this.getFunctionBlock_OutputDataPorts(), "parentFunctionBlock", null, 1, 1, OutputDataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputDataPort_EventConnections(), this.getDataConnection(), this.getDataConnection_SourceDataPort(), "eventConnections", null, 0, -1, OutputDataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputDataPort_OutputAssociations(), this.getOutputAssociation(), this.getOutputAssociation_TargetOutputDataPort(), "outputAssociations", null, 0, -1, OutputDataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(algorithmEClass, Algorithm.class, "Algorithm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAlgorithm_AlgorithmName(), ecorePackage.getEString(), "algorithmName", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlgorithm_AlgorithmLanguage(), ecorePackage.getEString(), "algorithmLanguage", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlgorithm_AlgorithmSourceCode(), ecorePackage.getEString(), "algorithmSourceCode", null, 1, 1, Algorithm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeNetworkEClass, CompositeNetwork.class, "CompositeNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeNetwork_ParentCompositeFunctionBlock(), this.getCompositeFunctionBlock(), this.getCompositeFunctionBlock_CompositeNetwork(), "parentCompositeFunctionBlock", null, 1, 1, CompositeNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeNetwork_InputEvents(), this.getOutputEventPort(), null, "inputEvents", null, 0, -1, CompositeNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeNetwork_OutputEvents(), this.getInputEventPort(), null, "outputEvents", null, 0, -1, CompositeNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeNetwork_InputData(), this.getOutputDataPort(), null, "inputData", null, 0, -1, CompositeNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeNetwork_OutputData(), this.getInputDataPort(), null, "outputData", null, 0, -1, CompositeNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceSequenceEClass, ServiceSequence.class, "ServiceSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputAssociationEClass, InputAssociation.class, "InputAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputAssociation_SourceInputEventPort(), this.getInputEventPort(), this.getInputEventPort_InputAssociations(), "sourceInputEventPort", null, 1, 1, InputAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputAssociation_TargetInputDataPort(), this.getInputDataPort(), this.getInputDataPort_InputAssociations(), "targetInputDataPort", null, 1, 1, InputAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputAssociationEClass, OutputAssociation.class, "OutputAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputAssociation_SourceOutputEventPort(), this.getOutputEventPort(), this.getOutputEventPort_OutputAssociations(), "sourceOutputEventPort", null, 1, 1, OutputAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputAssociation_TargetOutputDataPort(), this.getOutputDataPort(), this.getOutputDataPort_OutputAssociations(), "targetOutputDataPort", null, 1, 1, OutputAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_FunctionBlock(), this.getFunctionBlock(), this.getFunctionBlock_ParentInterface(), "functionBlock", null, 1, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibrary_Interfaces(), this.getInterface(), null, "interfaces", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Algorithms(), this.getAlgorithm(), null, "algorithms", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Applications(), this.getApplication(), null, "applications", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_CompositeNetworks(), this.getCompositeNetwork(), null, "compositeNetworks", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_SyncCharts(), theSyncchartsPackage.getState(), null, "syncCharts", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_ServiceSequences(), this.getServiceSequence(), null, "serviceSequences", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(portTypeEEnum, PortType.class, "PortType");
		addEEnumLiteral(portTypeEEnum, PortType.BYTE);
		addEEnumLiteral(portTypeEEnum, PortType.DT);
		addEEnumLiteral(portTypeEEnum, PortType.LREAL);
		addEEnumLiteral(portTypeEEnum, PortType.UINT);
		addEEnumLiteral(portTypeEEnum, PortType.LINT);
		addEEnumLiteral(portTypeEEnum, PortType.BOOL);
		addEEnumLiteral(portTypeEEnum, PortType.DATE_AND_TIME);
		addEEnumLiteral(portTypeEEnum, PortType.INT);
		addEEnumLiteral(portTypeEEnum, PortType.SINT);
		addEEnumLiteral(portTypeEEnum, PortType.LWORD);
		addEEnumLiteral(portTypeEEnum, PortType.COLOR);
		addEEnumLiteral(portTypeEEnum, PortType.WORD);
		addEEnumLiteral(portTypeEEnum, PortType.REAL);
		addEEnumLiteral(portTypeEEnum, PortType.TIME);
		addEEnumLiteral(portTypeEEnum, PortType.TOD);
		addEEnumLiteral(portTypeEEnum, PortType.ANY);
		addEEnumLiteral(portTypeEEnum, PortType.DWORD);
		addEEnumLiteral(portTypeEEnum, PortType.UDINT);
		addEEnumLiteral(portTypeEEnum, PortType.USINT);
		addEEnumLiteral(portTypeEEnum, PortType.TIME_OF_DAY);
		addEEnumLiteral(portTypeEEnum, PortType.WSTRING);
		addEEnumLiteral(portTypeEEnum, PortType.DINT);
		addEEnumLiteral(portTypeEEnum, PortType.DATE);
		addEEnumLiteral(portTypeEEnum, PortType.ULINT);
		addEEnumLiteral(portTypeEEnum, PortType.VSTYLE);
		addEEnumLiteral(portTypeEEnum, PortType.ARRAY);
		addEEnumLiteral(portTypeEEnum, PortType.STRING);

		// Create resource
		createResource(eNS_URI);
	}

} //CakefeedPackageImpl
