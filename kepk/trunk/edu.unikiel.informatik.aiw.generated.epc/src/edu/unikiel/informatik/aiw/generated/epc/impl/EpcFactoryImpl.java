/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.impl;

import edu.unikiel.informatik.aiw.generated.epc.*;

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
public class EpcFactoryImpl extends EFactoryImpl implements EpcFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EpcFactory init() {
		try {
			EpcFactory theEpcFactory = (EpcFactory)EPackage.Registry.INSTANCE.getEFactory("http://informatik.uni-kiel.de/aiw/epcmodel"); 
			if (theEpcFactory != null) {
				return theEpcFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EpcFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpcFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EpcPackage.EPC: return createEPC();
			case EpcPackage.EVENT: return createEvent();
			case EpcPackage.FUNCTION: return createFunction();
			case EpcPackage.TRIGGERS_EVENT: return createTriggersEvent();
			case EpcPackage.XOR: return createXOR();
			case EpcPackage.OR: return createOR();
			case EpcPackage.AND: return createAND();
			case EpcPackage.INFORMATION: return createInformation();
			case EpcPackage.ACTIVATES_FUNCTION: return createActivatesFunction();
			case EpcPackage.PROVIDES_DATA_TO: return createProvidesDataTo();
			case EpcPackage.WRITES_DATA_TO: return createWritesDataTo();
			case EpcPackage.FUNCTION_TO_OPERATOR_CONNECTION: return createFunctionToOperatorConnection();
			case EpcPackage.EVENT_TO_OPERATOR_CONNECTION: return createEventToOperatorConnection();
			case EpcPackage.OPERATOR_TO_FUNCTION_CONNECTION: return createOperatorToFunctionConnection();
			case EpcPackage.OPERATOR_TO_EVENT_CONNECTION: return createOperatorToEventConnection();
			case EpcPackage.GCT_LCONNECTOR: return createGCTLconnector();
			case EpcPackage.IMPLICATION: return createImplication();
			case EpcPackage.EQUIVALENCE: return createEquivalence();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPC createEPC() {
		EPCImpl epc = new EPCImpl();
		return epc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TriggersEvent createTriggersEvent() {
		TriggersEventImpl triggersEvent = new TriggersEventImpl();
		return triggersEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XOR createXOR() {
		XORImpl xor = new XORImpl();
		return xor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OR createOR() {
		ORImpl or = new ORImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AND createAND() {
		ANDImpl and = new ANDImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Information createInformation() {
		InformationImpl information = new InformationImpl();
		return information;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivatesFunction createActivatesFunction() {
		ActivatesFunctionImpl activatesFunction = new ActivatesFunctionImpl();
		return activatesFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesDataTo createProvidesDataTo() {
		ProvidesDataToImpl providesDataTo = new ProvidesDataToImpl();
		return providesDataTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WritesDataTo createWritesDataTo() {
		WritesDataToImpl writesDataTo = new WritesDataToImpl();
		return writesDataTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionToOperatorConnection createFunctionToOperatorConnection() {
		FunctionToOperatorConnectionImpl functionToOperatorConnection = new FunctionToOperatorConnectionImpl();
		return functionToOperatorConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventToOperatorConnection createEventToOperatorConnection() {
		EventToOperatorConnectionImpl eventToOperatorConnection = new EventToOperatorConnectionImpl();
		return eventToOperatorConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorToFunctionConnection createOperatorToFunctionConnection() {
		OperatorToFunctionConnectionImpl operatorToFunctionConnection = new OperatorToFunctionConnectionImpl();
		return operatorToFunctionConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorToEventConnection createOperatorToEventConnection() {
		OperatorToEventConnectionImpl operatorToEventConnection = new OperatorToEventConnectionImpl();
		return operatorToEventConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GCTLconnector createGCTLconnector() {
		GCTLconnectorImpl gctLconnector = new GCTLconnectorImpl();
		return gctLconnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implication createImplication() {
		ImplicationImpl implication = new ImplicationImpl();
		return implication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equivalence createEquivalence() {
		EquivalenceImpl equivalence = new EquivalenceImpl();
		return equivalence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpcPackage getEpcPackage() {
		return (EpcPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static EpcPackage getPackage() {
		return EpcPackage.eINSTANCE;
	}

} //EpcFactoryImpl
