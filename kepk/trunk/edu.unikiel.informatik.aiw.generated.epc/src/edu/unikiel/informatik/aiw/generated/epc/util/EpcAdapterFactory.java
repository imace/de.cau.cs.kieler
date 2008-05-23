/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.unikiel.informatik.aiw.generated.epc.util;

import edu.unikiel.informatik.aiw.generated.epc.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.unikiel.informatik.aiw.generated.epc.EpcPackage
 * @generated
 */
public class EpcAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EpcPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpcAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EpcPackage.eINSTANCE;
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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EpcSwitch modelSwitch =
		new EpcSwitch() {
			public Object caseEPC(EPC object) {
				return createEPCAdapter();
			}
			public Object caseEvent(Event object) {
				return createEventAdapter();
			}
			public Object caseFunction(Function object) {
				return createFunctionAdapter();
			}
			public Object caseTriggersEvent(TriggersEvent object) {
				return createTriggersEventAdapter();
			}
			public Object caseLogicalOperator(LogicalOperator object) {
				return createLogicalOperatorAdapter();
			}
			public Object caseXOR(XOR object) {
				return createXORAdapter();
			}
			public Object caseOR(OR object) {
				return createORAdapter();
			}
			public Object caseAND(AND object) {
				return createANDAdapter();
			}
			public Object caseInformation(Information object) {
				return createInformationAdapter();
			}
			public Object caseNode(Node object) {
				return createNodeAdapter();
			}
			public Object caseEPCObject(EPCObject object) {
				return createEPCObjectAdapter();
			}
			public Object caseRelationship(Relationship object) {
				return createRelationshipAdapter();
			}
			public Object caseActivatesFunction(ActivatesFunction object) {
				return createActivatesFunctionAdapter();
			}
			public Object caseSuccessorOf(SuccessorOf object) {
				return createSuccessorOfAdapter();
			}
			public Object caseProvidesDataTo(ProvidesDataTo object) {
				return createProvidesDataToAdapter();
			}
			public Object caseWritesDataTo(WritesDataTo object) {
				return createWritesDataToAdapter();
			}
			public Object caseFunctionToOperatorConnection(FunctionToOperatorConnection object) {
				return createFunctionToOperatorConnectionAdapter();
			}
			public Object caseEventToOperatorConnection(EventToOperatorConnection object) {
				return createEventToOperatorConnectionAdapter();
			}
			public Object caseOperatorToFunctionConnection(OperatorToFunctionConnection object) {
				return createOperatorToFunctionConnectionAdapter();
			}
			public Object caseOperatorToEventConnection(OperatorToEventConnection object) {
				return createOperatorToEventConnectionAdapter();
			}
			public Object caseGCTLconnector(GCTLconnector object) {
				return createGCTLconnectorAdapter();
			}
			public Object caseImplication(Implication object) {
				return createImplicationAdapter();
			}
			public Object defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.EPC <em>EPC</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPC
	 * @generated
	 */
	public Adapter createEPCAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.TriggersEvent <em>Triggers Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.TriggersEvent
	 * @generated
	 */
	public Adapter createTriggersEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.LogicalOperator <em>Logical Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.LogicalOperator
	 * @generated
	 */
	public Adapter createLogicalOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.XOR <em>XOR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.XOR
	 * @generated
	 */
	public Adapter createXORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OR
	 * @generated
	 */
	public Adapter createORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.AND
	 * @generated
	 */
	public Adapter createANDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.Information <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Information
	 * @generated
	 */
	public Adapter createInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.EPCObject <em>EPC Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EPCObject
	 * @generated
	 */
	public Adapter createEPCObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Relationship
	 * @generated
	 */
	public Adapter createRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction <em>Activates Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction
	 * @generated
	 */
	public Adapter createActivatesFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.SuccessorOf <em>Successor Of</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.SuccessorOf
	 * @generated
	 */
	public Adapter createSuccessorOfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo <em>Provides Data To</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo
	 * @generated
	 */
	public Adapter createProvidesDataToAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.WritesDataTo <em>Writes Data To</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.WritesDataTo
	 * @generated
	 */
	public Adapter createWritesDataToAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection <em>Function To Operator Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection
	 * @generated
	 */
	public Adapter createFunctionToOperatorConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection <em>Event To Operator Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection
	 * @generated
	 */
	public Adapter createEventToOperatorConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection <em>Operator To Function Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection
	 * @generated
	 */
	public Adapter createOperatorToFunctionConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection <em>Operator To Event Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection
	 * @generated
	 */
	public Adapter createOperatorToEventConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.GCTLconnector <em>GCT Lconnector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.GCTLconnector
	 * @generated
	 */
	public Adapter createGCTLconnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.unikiel.informatik.aiw.generated.epc.Implication <em>Implication</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.unikiel.informatik.aiw.generated.epc.Implication
	 * @generated
	 */
	public Adapter createImplicationAdapter() {
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

} //EpcAdapterFactory
