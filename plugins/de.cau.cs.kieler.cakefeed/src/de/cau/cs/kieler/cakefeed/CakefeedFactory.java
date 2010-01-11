/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.cau.cs.kieler.cakefeed;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.cau.cs.kieler.cakefeed.CakefeedPackage
 * @generated
 */
public interface CakefeedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CakefeedFactory eINSTANCE = de.cau.cs.kieler.cakefeed.impl.CakefeedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Identification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identification</em>'.
	 * @generated
	 */
	Identification createIdentification();

	/**
	 * Returns a new object of class '<em>Version Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version Info</em>'.
	 * @generated
	 */
	VersionInfo createVersionInfo();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	Application createApplication();

	/**
	 * Returns a new object of class '<em>FB Network</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Network</em>'.
	 * @generated
	 */
	FBNetwork createFBNetwork();

	/**
	 * Returns a new object of class '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device</em>'.
	 * @generated
	 */
	Device createDevice();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Segment</em>'.
	 * @generated
	 */
	Segment createSegment();

	/**
	 * Returns a new object of class '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link</em>'.
	 * @generated
	 */
	Link createLink();

	/**
	 * Returns a new object of class '<em>FB</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB</em>'.
	 * @generated
	 */
	FB createFB();

	/**
	 * Returns a new object of class '<em>FB Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Interface</em>'.
	 * @generated
	 */
	FBInterface createFBInterface();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	Resource createResource();

	/**
	 * Returns a new object of class '<em>Compiler Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compiler Info</em>'.
	 * @generated
	 */
	CompilerInfo createCompilerInfo();

	/**
	 * Returns a new object of class '<em>IFIF Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IFIF Event Connection</em>'.
	 * @generated
	 */
	IFIFEventConnection createIFIFEventConnection();

	/**
	 * Returns a new object of class '<em>IFIF Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IFIF Data Connection</em>'.
	 * @generated
	 */
	IFIFDataConnection createIFIFDataConnection();

	/**
	 * Returns a new object of class '<em>IFFB Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IFFB Event Connection</em>'.
	 * @generated
	 */
	IFFBEventConnection createIFFBEventConnection();

	/**
	 * Returns a new object of class '<em>IFFB Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IFFB Data Connection</em>'.
	 * @generated
	 */
	IFFBDataConnection createIFFBDataConnection();

	/**
	 * Returns a new object of class '<em>FBIF Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FBIF Event Connection</em>'.
	 * @generated
	 */
	FBIFEventConnection createFBIFEventConnection();

	/**
	 * Returns a new object of class '<em>FBIF Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FBIF Data Connection</em>'.
	 * @generated
	 */
	FBIFDataConnection createFBIFDataConnection();

	/**
	 * Returns a new object of class '<em>FBFB Event Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FBFB Event Connection</em>'.
	 * @generated
	 */
	FBFBEventConnection createFBFBEventConnection();

	/**
	 * Returns a new object of class '<em>FBFB Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FBFB Data Connection</em>'.
	 * @generated
	 */
	FBFBDataConnection createFBFBDataConnection();

	/**
	 * Returns a new object of class '<em>IFIV Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IFIV Data Connection</em>'.
	 * @generated
	 */
	IFIVDataConnection createIFIVDataConnection();

	/**
	 * Returns a new object of class '<em>IVIF Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IVIF Data Connection</em>'.
	 * @generated
	 */
	IVIFDataConnection createIVIFDataConnection();

	/**
	 * Returns a new object of class '<em>FBIV Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FBIV Data Connection</em>'.
	 * @generated
	 */
	FBIVDataConnection createFBIVDataConnection();

	/**
	 * Returns a new object of class '<em>IVFB Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IVFB Data Connection</em>'.
	 * @generated
	 */
	IVFBDataConnection createIVFBDataConnection();

	/**
	 * Returns a new object of class '<em>IVIV Data Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IVIV Data Connection</em>'.
	 * @generated
	 */
	IVIVDataConnection createIVIVDataConnection();

	/**
	 * Returns a new object of class '<em>Adapter Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Connection</em>'.
	 * @generated
	 */
	AdapterConnection createAdapterConnection();

	/**
	 * Returns a new object of class '<em>IF Input Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IF Input Event</em>'.
	 * @generated
	 */
	IFInputEvent createIFInputEvent();

	/**
	 * Returns a new object of class '<em>FB Input Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Input Event</em>'.
	 * @generated
	 */
	FBInputEvent createFBInputEvent();

	/**
	 * Returns a new object of class '<em>IF Output Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IF Output Event</em>'.
	 * @generated
	 */
	IFOutputEvent createIFOutputEvent();

	/**
	 * Returns a new object of class '<em>FB Output Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Output Event</em>'.
	 * @generated
	 */
	FBOutputEvent createFBOutputEvent();

	/**
	 * Returns a new object of class '<em>IF Input Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IF Input Var</em>'.
	 * @generated
	 */
	IFInputVar createIFInputVar();

	/**
	 * Returns a new object of class '<em>FB Input Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Input Var</em>'.
	 * @generated
	 */
	FBInputVar createFBInputVar();

	/**
	 * Returns a new object of class '<em>IF Output Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IF Output Var</em>'.
	 * @generated
	 */
	IFOutputVar createIFOutputVar();

	/**
	 * Returns a new object of class '<em>FB Output Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FB Output Var</em>'.
	 * @generated
	 */
	FBOutputVar createFBOutputVar();

	/**
	 * Returns a new object of class '<em>Internal Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Var</em>'.
	 * @generated
	 */
	InternalVar createInternalVar();

	/**
	 * Returns a new object of class '<em>Compiler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compiler</em>'.
	 * @generated
	 */
	Compiler createCompiler();

	/**
	 * Returns a new object of class '<em>Input With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input With</em>'.
	 * @generated
	 */
	InputWith createInputWith();

	/**
	 * Returns a new object of class '<em>Output With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output With</em>'.
	 * @generated
	 */
	OutputWith createOutputWith();

	/**
	 * Returns a new object of class '<em>Socket</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Socket</em>'.
	 * @generated
	 */
	Socket createSocket();

	/**
	 * Returns a new object of class '<em>Plug</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plug</em>'.
	 * @generated
	 */
	Plug createPlug();

	/**
	 * Returns a new object of class '<em>Adapter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Type</em>'.
	 * @generated
	 */
	AdapterType createAdapterType();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	Service createService();

	/**
	 * Returns a new object of class '<em>Service Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Sequence</em>'.
	 * @generated
	 */
	ServiceSequence createServiceSequence();

	/**
	 * Returns a new object of class '<em>Service Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Transaction</em>'.
	 * @generated
	 */
	ServiceTransaction createServiceTransaction();

	/**
	 * Returns a new object of class '<em>Input Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Primitive</em>'.
	 * @generated
	 */
	InputPrimitive createInputPrimitive();

	/**
	 * Returns a new object of class '<em>Output Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Primitive</em>'.
	 * @generated
	 */
	OutputPrimitive createOutputPrimitive();

	/**
	 * Returns a new object of class '<em>BFB Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BFB Type</em>'.
	 * @generated
	 */
	BFBType createBFBType();

	/**
	 * Returns a new object of class '<em>FBD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FBD</em>'.
	 * @generated
	 */
	FBD createFBD();

	/**
	 * Returns a new object of class '<em>ST</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ST</em>'.
	 * @generated
	 */
	ST createST();

	/**
	 * Returns a new object of class '<em>LD</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LD</em>'.
	 * @generated
	 */
	LD createLD();

	/**
	 * Returns a new object of class '<em>Other</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Other</em>'.
	 * @generated
	 */
	Other createOther();

	/**
	 * Returns a new object of class '<em>Rung</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rung</em>'.
	 * @generated
	 */
	Rung createRung();

	/**
	 * Returns a new object of class '<em>CFB Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CFB Type</em>'.
	 * @generated
	 */
	CFBType createCFBType();

	/**
	 * Returns a new object of class '<em>Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Type</em>'.
	 * @generated
	 */
	DeviceType createDeviceType();

	/**
	 * Returns a new object of class '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Type</em>'.
	 * @generated
	 */
	ResourceType createResourceType();

	/**
	 * Returns a new object of class '<em>BFB Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BFB Diagram</em>'.
	 * @generated
	 */
	BFBDiagram createBFBDiagram();

	/**
	 * Returns a new object of class '<em>CFB Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CFB Diagram</em>'.
	 * @generated
	 */
	CFBDiagram createCFBDiagram();

	/**
	 * Returns a new object of class '<em>Named And Commented</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named And Commented</em>'.
	 * @generated
	 */
	NamedAndCommented createNamedAndCommented();

	/**
	 * Returns a new object of class '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifiable</em>'.
	 * @generated
	 */
	Identifiable createIdentifiable();

	/**
	 * Returns a new object of class '<em>Compilable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compilable</em>'.
	 * @generated
	 */
	Compilable createCompilable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CakefeedPackage getCakefeedPackage();

} //CakefeedFactory
