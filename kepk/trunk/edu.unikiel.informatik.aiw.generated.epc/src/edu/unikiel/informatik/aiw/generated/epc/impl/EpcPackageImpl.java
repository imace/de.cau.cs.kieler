/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.impl;

import edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction;
import edu.unikiel.informatik.aiw.generated.epc.EPCObject;
import edu.unikiel.informatik.aiw.generated.epc.EpcFactory;
import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.Equivalence;
import edu.unikiel.informatik.aiw.generated.epc.Event;
import edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection;
import edu.unikiel.informatik.aiw.generated.epc.Function;
import edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection;
import edu.unikiel.informatik.aiw.generated.epc.GCTLconnector;
import edu.unikiel.informatik.aiw.generated.epc.Implication;
import edu.unikiel.informatik.aiw.generated.epc.Information;
import edu.unikiel.informatik.aiw.generated.epc.LogicalOperator;
import edu.unikiel.informatik.aiw.generated.epc.Node;
import edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection;
import edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection;
import edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo;
import edu.unikiel.informatik.aiw.generated.epc.Relationship;
import edu.unikiel.informatik.aiw.generated.epc.SuccessorOf;
import edu.unikiel.informatik.aiw.generated.epc.TriggersEvent;
import edu.unikiel.informatik.aiw.generated.epc.WritesDataTo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EpcPackageImpl extends EPackageImpl implements EpcPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass epcEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggersEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass epcObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activatesFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass successorOfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providesDataToEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writesDataToEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionToOperatorConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventToOperatorConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorToFunctionConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorToEventConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gctLconnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalenceEClass = null;

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
	 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EpcPackageImpl() {
		super(eNS_URI, EpcFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EpcPackage init() {
		if (isInited) return (EpcPackage)EPackage.Registry.INSTANCE.getEPackage(EpcPackage.eNS_URI);

		// Obtain or create and register package
		EpcPackageImpl theEpcPackage = (EpcPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EpcPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EpcPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEpcPackage.createPackageContents();

		// Initialize created meta-data
		theEpcPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEpcPackage.freeze();

		return theEpcPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPC() {
		return epcEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPC_Connectors() {
		return (EReference)epcEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEPC_Objects() {
		return (EReference)epcEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTriggersEvent() {
		return triggersEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTriggersEvent_Source() {
		return (EReference)triggersEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTriggersEvent_Target() {
		return (EReference)triggersEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalOperator() {
		return logicalOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXOR() {
		return xorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOR() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAND() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInformation() {
		return informationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Name() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEPCObject() {
		return epcObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEPCObject_ShowInEPCEditor() {
		return (EAttribute)epcObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship() {
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivatesFunction() {
		return activatesFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivatesFunction_Source() {
		return (EReference)activatesFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivatesFunction_Target() {
		return (EReference)activatesFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSuccessorOf() {
		return successorOfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidesDataTo() {
		return providesDataToEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidesDataTo_Source() {
		return (EReference)providesDataToEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidesDataTo_Target() {
		return (EReference)providesDataToEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWritesDataTo() {
		return writesDataToEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWritesDataTo_Source() {
		return (EReference)writesDataToEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWritesDataTo_Target() {
		return (EReference)writesDataToEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionToOperatorConnection() {
		return functionToOperatorConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionToOperatorConnection_Function() {
		return (EReference)functionToOperatorConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionToOperatorConnection_Operator() {
		return (EReference)functionToOperatorConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventToOperatorConnection() {
		return eventToOperatorConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventToOperatorConnection_Event() {
		return (EReference)eventToOperatorConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventToOperatorConnection_Operator() {
		return (EReference)eventToOperatorConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorToFunctionConnection() {
		return operatorToFunctionConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorToFunctionConnection_Function() {
		return (EReference)operatorToFunctionConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorToFunctionConnection_Operator() {
		return (EReference)operatorToFunctionConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorToEventConnection() {
		return operatorToEventConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorToEventConnection_Event() {
		return (EReference)operatorToEventConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorToEventConnection_Operator() {
		return (EReference)operatorToEventConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGCTLconnector() {
		return gctLconnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGCTLconnector_Source() {
		return (EReference)gctLconnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGCTLconnector_Target() {
		return (EReference)gctLconnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplication() {
		return implicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquivalence() {
		return equivalenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpcFactory getEpcFactory() {
		return (EpcFactory)getEFactoryInstance();
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
		epcEClass = createEClass(EPC);
		createEReference(epcEClass, EPC__CONNECTORS);
		createEReference(epcEClass, EPC__OBJECTS);

		eventEClass = createEClass(EVENT);

		functionEClass = createEClass(FUNCTION);

		triggersEventEClass = createEClass(TRIGGERS_EVENT);
		createEReference(triggersEventEClass, TRIGGERS_EVENT__SOURCE);
		createEReference(triggersEventEClass, TRIGGERS_EVENT__TARGET);

		logicalOperatorEClass = createEClass(LOGICAL_OPERATOR);

		xorEClass = createEClass(XOR);

		orEClass = createEClass(OR);

		andEClass = createEClass(AND);

		informationEClass = createEClass(INFORMATION);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__NAME);

		epcObjectEClass = createEClass(EPC_OBJECT);
		createEAttribute(epcObjectEClass, EPC_OBJECT__SHOW_IN_EPC_EDITOR);

		relationshipEClass = createEClass(RELATIONSHIP);

		activatesFunctionEClass = createEClass(ACTIVATES_FUNCTION);
		createEReference(activatesFunctionEClass, ACTIVATES_FUNCTION__SOURCE);
		createEReference(activatesFunctionEClass, ACTIVATES_FUNCTION__TARGET);

		successorOfEClass = createEClass(SUCCESSOR_OF);

		providesDataToEClass = createEClass(PROVIDES_DATA_TO);
		createEReference(providesDataToEClass, PROVIDES_DATA_TO__SOURCE);
		createEReference(providesDataToEClass, PROVIDES_DATA_TO__TARGET);

		writesDataToEClass = createEClass(WRITES_DATA_TO);
		createEReference(writesDataToEClass, WRITES_DATA_TO__SOURCE);
		createEReference(writesDataToEClass, WRITES_DATA_TO__TARGET);

		functionToOperatorConnectionEClass = createEClass(FUNCTION_TO_OPERATOR_CONNECTION);
		createEReference(functionToOperatorConnectionEClass, FUNCTION_TO_OPERATOR_CONNECTION__FUNCTION);
		createEReference(functionToOperatorConnectionEClass, FUNCTION_TO_OPERATOR_CONNECTION__OPERATOR);

		eventToOperatorConnectionEClass = createEClass(EVENT_TO_OPERATOR_CONNECTION);
		createEReference(eventToOperatorConnectionEClass, EVENT_TO_OPERATOR_CONNECTION__EVENT);
		createEReference(eventToOperatorConnectionEClass, EVENT_TO_OPERATOR_CONNECTION__OPERATOR);

		operatorToFunctionConnectionEClass = createEClass(OPERATOR_TO_FUNCTION_CONNECTION);
		createEReference(operatorToFunctionConnectionEClass, OPERATOR_TO_FUNCTION_CONNECTION__FUNCTION);
		createEReference(operatorToFunctionConnectionEClass, OPERATOR_TO_FUNCTION_CONNECTION__OPERATOR);

		operatorToEventConnectionEClass = createEClass(OPERATOR_TO_EVENT_CONNECTION);
		createEReference(operatorToEventConnectionEClass, OPERATOR_TO_EVENT_CONNECTION__EVENT);
		createEReference(operatorToEventConnectionEClass, OPERATOR_TO_EVENT_CONNECTION__OPERATOR);

		gctLconnectorEClass = createEClass(GCT_LCONNECTOR);
		createEReference(gctLconnectorEClass, GCT_LCONNECTOR__SOURCE);
		createEReference(gctLconnectorEClass, GCT_LCONNECTOR__TARGET);

		implicationEClass = createEClass(IMPLICATION);

		equivalenceEClass = createEClass(EQUIVALENCE);
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

		// Add supertypes to classes
		epcEClass.getESuperTypes().add(this.getFunction());
		eventEClass.getESuperTypes().add(this.getNode());
		functionEClass.getESuperTypes().add(this.getNode());
		triggersEventEClass.getESuperTypes().add(this.getSuccessorOf());
		logicalOperatorEClass.getESuperTypes().add(this.getEPCObject());
		xorEClass.getESuperTypes().add(this.getLogicalOperator());
		orEClass.getESuperTypes().add(this.getLogicalOperator());
		andEClass.getESuperTypes().add(this.getLogicalOperator());
		informationEClass.getESuperTypes().add(this.getNode());
		nodeEClass.getESuperTypes().add(this.getEPCObject());
		activatesFunctionEClass.getESuperTypes().add(this.getSuccessorOf());
		successorOfEClass.getESuperTypes().add(this.getRelationship());
		providesDataToEClass.getESuperTypes().add(this.getRelationship());
		writesDataToEClass.getESuperTypes().add(this.getRelationship());
		functionToOperatorConnectionEClass.getESuperTypes().add(this.getSuccessorOf());
		eventToOperatorConnectionEClass.getESuperTypes().add(this.getSuccessorOf());
		operatorToFunctionConnectionEClass.getESuperTypes().add(this.getSuccessorOf());
		operatorToEventConnectionEClass.getESuperTypes().add(this.getSuccessorOf());
		gctLconnectorEClass.getESuperTypes().add(this.getRelationship());
		implicationEClass.getESuperTypes().add(this.getNode());
		equivalenceEClass.getESuperTypes().add(this.getNode());

		// Initialize classes and features; add operations and parameters
		initEClass(epcEClass, edu.unikiel.informatik.aiw.generated.epc.EPC.class, "EPC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEPC_Connectors(), this.getRelationship(), null, "connectors", null, 0, -1, edu.unikiel.informatik.aiw.generated.epc.EPC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEPC_Objects(), this.getEPCObject(), null, "objects", null, 0, -1, edu.unikiel.informatik.aiw.generated.epc.EPC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(triggersEventEClass, TriggersEvent.class, "TriggersEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTriggersEvent_Source(), this.getFunction(), null, "source", null, 1, 1, TriggersEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTriggersEvent_Target(), this.getEvent(), null, "target", null, 1, 1, TriggersEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logicalOperatorEClass, LogicalOperator.class, "LogicalOperator", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xorEClass, edu.unikiel.informatik.aiw.generated.epc.XOR.class, "XOR", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, edu.unikiel.informatik.aiw.generated.epc.OR.class, "OR", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andEClass, edu.unikiel.informatik.aiw.generated.epc.AND.class, "AND", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(informationEClass, Information.class, "Information", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(epcObjectEClass, EPCObject.class, "EPCObject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEPCObject_ShowInEPCEditor(), ecorePackage.getEBoolean(), "showInEPCEditor", null, 0, 1, EPCObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activatesFunctionEClass, ActivatesFunction.class, "ActivatesFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivatesFunction_Source(), this.getEvent(), null, "source", null, 1, 1, ActivatesFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivatesFunction_Target(), this.getFunction(), null, "target", null, 1, 1, ActivatesFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(successorOfEClass, SuccessorOf.class, "SuccessorOf", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(providesDataToEClass, ProvidesDataTo.class, "ProvidesDataTo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidesDataTo_Source(), this.getInformation(), null, "source", null, 1, 1, ProvidesDataTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProvidesDataTo_Target(), this.getFunction(), null, "target", null, 1, 1, ProvidesDataTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(writesDataToEClass, WritesDataTo.class, "WritesDataTo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWritesDataTo_Source(), this.getFunction(), null, "source", null, 1, 1, WritesDataTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWritesDataTo_Target(), this.getInformation(), null, "target", null, 1, 1, WritesDataTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionToOperatorConnectionEClass, FunctionToOperatorConnection.class, "FunctionToOperatorConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionToOperatorConnection_Function(), this.getFunction(), null, "function", null, 0, 1, FunctionToOperatorConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionToOperatorConnection_Operator(), this.getLogicalOperator(), null, "operator", null, 0, 1, FunctionToOperatorConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventToOperatorConnectionEClass, EventToOperatorConnection.class, "EventToOperatorConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventToOperatorConnection_Event(), this.getEvent(), null, "event", null, 0, 1, EventToOperatorConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventToOperatorConnection_Operator(), this.getLogicalOperator(), null, "operator", null, 0, 1, EventToOperatorConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorToFunctionConnectionEClass, OperatorToFunctionConnection.class, "OperatorToFunctionConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorToFunctionConnection_Function(), this.getFunction(), null, "function", null, 0, 1, OperatorToFunctionConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperatorToFunctionConnection_Operator(), this.getLogicalOperator(), null, "operator", null, 0, 1, OperatorToFunctionConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorToEventConnectionEClass, OperatorToEventConnection.class, "OperatorToEventConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorToEventConnection_Event(), this.getEvent(), null, "event", null, 0, 1, OperatorToEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperatorToEventConnection_Operator(), this.getLogicalOperator(), null, "operator", null, 0, 1, OperatorToEventConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gctLconnectorEClass, GCTLconnector.class, "GCTLconnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGCTLconnector_Source(), this.getNode(), null, "source", null, 0, 1, GCTLconnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGCTLconnector_Target(), this.getNode(), null, "target", null, 0, 1, GCTLconnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implicationEClass, Implication.class, "Implication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equivalenceEClass, Equivalence.class, "Equivalence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EpcPackageImpl
