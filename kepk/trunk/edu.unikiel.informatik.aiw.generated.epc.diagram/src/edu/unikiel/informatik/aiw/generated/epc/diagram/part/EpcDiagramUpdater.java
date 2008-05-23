package edu.unikiel.informatik.aiw.generated.epc.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.informatik.aiw.generated.epc.ActivatesFunction;
import edu.unikiel.informatik.aiw.generated.epc.EPCObject;
import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.Event;
import edu.unikiel.informatik.aiw.generated.epc.EventToOperatorConnection;
import edu.unikiel.informatik.aiw.generated.epc.Function;
import edu.unikiel.informatik.aiw.generated.epc.FunctionToOperatorConnection;
import edu.unikiel.informatik.aiw.generated.epc.Information;
import edu.unikiel.informatik.aiw.generated.epc.LogicalOperator;
import edu.unikiel.informatik.aiw.generated.epc.OperatorToEventConnection;
import edu.unikiel.informatik.aiw.generated.epc.OperatorToFunctionConnection;
import edu.unikiel.informatik.aiw.generated.epc.ProvidesDataTo;
import edu.unikiel.informatik.aiw.generated.epc.TriggersEvent;
import edu.unikiel.informatik.aiw.generated.epc.WritesDataTo;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ANDEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ActivatesFunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPC2EditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.InformationEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OREditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToEventConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToFunctionConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ProvidesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.TriggersEventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.WritesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.XOREditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class EpcDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case EPCEditPart.VISUAL_ID:
			return getEPC_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEPC_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getObjects().iterator(); it.hasNext();) {
			EPCObject childElement = (EPCObject) it.next();
			int visualID = EpcVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ANDEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == OREditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InformationEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == XOREditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EPC2EditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FunctionEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case EPCEditPart.VISUAL_ID:
			return getEPC_79ContainedLinks(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_1001ContainedLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_1002ContainedLinks(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003ContainedLinks(view);
		case XOREditPart.VISUAL_ID:
			return getXOR_1004ContainedLinks(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1005ContainedLinks(view);
		case EPC2EditPart.VISUAL_ID:
			return getEPC_1006ContainedLinks(view);
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1007ContainedLinks(view);
		case TriggersEventEditPart.VISUAL_ID:
			return getTriggersEvent_3001ContainedLinks(view);
		case ProvidesDataToEditPart.VISUAL_ID:
			return getProvidesDataTo_3002ContainedLinks(view);
		case WritesDataToEditPart.VISUAL_ID:
			return getWritesDataTo_3003ContainedLinks(view);
		case ActivatesFunctionEditPart.VISUAL_ID:
			return getActivatesFunction_3004ContainedLinks(view);
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return getEventToOperatorConnection_3005ContainedLinks(view);
		case FunctionToOperatorConnectionEditPart.VISUAL_ID:
			return getFunctionToOperatorConnection_3006ContainedLinks(view);
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return getOperatorToEventConnection_3007ContainedLinks(view);
		case OperatorToFunctionConnectionEditPart.VISUAL_ID:
			return getOperatorToFunctionConnection_3008ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case ANDEditPart.VISUAL_ID:
			return getAND_1001IncomingLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_1002IncomingLinks(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003IncomingLinks(view);
		case XOREditPart.VISUAL_ID:
			return getXOR_1004IncomingLinks(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1005IncomingLinks(view);
		case EPC2EditPart.VISUAL_ID:
			return getEPC_1006IncomingLinks(view);
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1007IncomingLinks(view);
		case TriggersEventEditPart.VISUAL_ID:
			return getTriggersEvent_3001IncomingLinks(view);
		case ProvidesDataToEditPart.VISUAL_ID:
			return getProvidesDataTo_3002IncomingLinks(view);
		case WritesDataToEditPart.VISUAL_ID:
			return getWritesDataTo_3003IncomingLinks(view);
		case ActivatesFunctionEditPart.VISUAL_ID:
			return getActivatesFunction_3004IncomingLinks(view);
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return getEventToOperatorConnection_3005IncomingLinks(view);
		case FunctionToOperatorConnectionEditPart.VISUAL_ID:
			return getFunctionToOperatorConnection_3006IncomingLinks(view);
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return getOperatorToEventConnection_3007IncomingLinks(view);
		case OperatorToFunctionConnectionEditPart.VISUAL_ID:
			return getOperatorToFunctionConnection_3008IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case ANDEditPart.VISUAL_ID:
			return getAND_1001OutgoingLinks(view);
		case OREditPart.VISUAL_ID:
			return getOR_1002OutgoingLinks(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003OutgoingLinks(view);
		case XOREditPart.VISUAL_ID:
			return getXOR_1004OutgoingLinks(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1005OutgoingLinks(view);
		case EPC2EditPart.VISUAL_ID:
			return getEPC_1006OutgoingLinks(view);
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1007OutgoingLinks(view);
		case TriggersEventEditPart.VISUAL_ID:
			return getTriggersEvent_3001OutgoingLinks(view);
		case ProvidesDataToEditPart.VISUAL_ID:
			return getProvidesDataTo_3002OutgoingLinks(view);
		case WritesDataToEditPart.VISUAL_ID:
			return getWritesDataTo_3003OutgoingLinks(view);
		case ActivatesFunctionEditPart.VISUAL_ID:
			return getActivatesFunction_3004OutgoingLinks(view);
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return getEventToOperatorConnection_3005OutgoingLinks(view);
		case FunctionToOperatorConnectionEditPart.VISUAL_ID:
			return getFunctionToOperatorConnection_3006OutgoingLinks(view);
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return getOperatorToEventConnection_3007OutgoingLinks(view);
		case OperatorToFunctionConnectionEditPart.VISUAL_ID:
			return getOperatorToFunctionConnection_3008OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEPC_79ContainedLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_TriggersEvent_3001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidesDataTo_3002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_WritesDataTo_3003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ActivatesFunction_3004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_EventToOperatorConnection_3005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_FunctionToOperatorConnection_3006(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_OperatorToEventConnection_3007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_OperatorToFunctionConnection_3008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAND_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOR_1002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInformation_1003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getXOR_1004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEvent_1005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEPC_1006ContainedLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_TriggersEvent_3001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ProvidesDataTo_3002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_WritesDataTo_3003(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_ActivatesFunction_3004(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_EventToOperatorConnection_3005(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_FunctionToOperatorConnection_3006(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_OperatorToEventConnection_3007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_OperatorToFunctionConnection_3008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunction_1007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTriggersEvent_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProvidesDataTo_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getWritesDataTo_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivatesFunction_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventToOperatorConnection_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFunctionToOperatorConnection_3006ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperatorToEventConnection_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperatorToFunctionConnection_3008ContainedLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAND_1001IncomingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.AND modelElement = (edu.unikiel.informatik.aiw.generated.epc.AND) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_EventToOperatorConnection_3005(
						modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_FunctionToOperatorConnection_3006(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOR_1002IncomingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.OR modelElement = (edu.unikiel.informatik.aiw.generated.epc.OR) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_EventToOperatorConnection_3005(
						modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_FunctionToOperatorConnection_3006(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInformation_1003IncomingLinks(View view) {
		Information modelElement = (Information) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_WritesDataTo_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getXOR_1004IncomingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.XOR modelElement = (edu.unikiel.informatik.aiw.generated.epc.XOR) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingTypeModelFacetLinks_EventToOperatorConnection_3005(
						modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_FunctionToOperatorConnection_3006(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEvent_1005IncomingLinks(View view) {
		Event modelElement = (Event) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_TriggersEvent_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_OperatorToEventConnection_3007(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPC_1006IncomingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ProvidesDataTo_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ActivatesFunction_3004(
				modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_OperatorToFunctionConnection_3008(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunction_1007IncomingLinks(View view) {
		Function modelElement = (Function) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ProvidesDataTo_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ActivatesFunction_3004(
				modelElement, crossReferences));
		result
				.addAll(getIncomingTypeModelFacetLinks_OperatorToFunctionConnection_3008(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTriggersEvent_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProvidesDataTo_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getWritesDataTo_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivatesFunction_3004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventToOperatorConnection_3005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFunctionToOperatorConnection_3006IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperatorToEventConnection_3007IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperatorToFunctionConnection_3008IncomingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAND_1001OutgoingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.AND modelElement = (edu.unikiel.informatik.aiw.generated.epc.AND) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_OperatorToEventConnection_3007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_OperatorToFunctionConnection_3008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOR_1002OutgoingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.OR modelElement = (edu.unikiel.informatik.aiw.generated.epc.OR) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_OperatorToEventConnection_3007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_OperatorToFunctionConnection_3008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInformation_1003OutgoingLinks(View view) {
		Information modelElement = (Information) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_ProvidesDataTo_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getXOR_1004OutgoingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.XOR modelElement = (edu.unikiel.informatik.aiw.generated.epc.XOR) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_OperatorToEventConnection_3007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_OperatorToFunctionConnection_3008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEvent_1005OutgoingLinks(View view) {
		Event modelElement = (Event) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_ActivatesFunction_3004(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_EventToOperatorConnection_3005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPC_1006OutgoingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_TriggersEvent_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_WritesDataTo_3003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_FunctionToOperatorConnection_3006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunction_1007OutgoingLinks(View view) {
		Function modelElement = (Function) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_TriggersEvent_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_WritesDataTo_3003(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_FunctionToOperatorConnection_3006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTriggersEvent_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProvidesDataTo_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getWritesDataTo_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivatesFunction_3004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEventToOperatorConnection_3005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFunctionToOperatorConnection_3006OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperatorToEventConnection_3007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperatorToFunctionConnection_3008OutgoingLinks(
			View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_TriggersEvent_3001(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof TriggersEvent) {
				continue;
			}
			TriggersEvent link = (TriggersEvent) linkObject;
			if (TriggersEventEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Event dst = link.getTarget();
			Function src = link.getSource();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.TriggersEvent_3001,
					TriggersEventEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ProvidesDataTo_3002(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof ProvidesDataTo) {
				continue;
			}
			ProvidesDataTo link = (ProvidesDataTo) linkObject;
			if (ProvidesDataToEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function dst = link.getTarget();
			Information src = link.getSource();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.ProvidesDataTo_3002,
					ProvidesDataToEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_WritesDataTo_3003(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof WritesDataTo) {
				continue;
			}
			WritesDataTo link = (WritesDataTo) linkObject;
			if (WritesDataToEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Information dst = link.getTarget();
			Function src = link.getSource();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.WritesDataTo_3003,
					WritesDataToEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ActivatesFunction_3004(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof ActivatesFunction) {
				continue;
			}
			ActivatesFunction link = (ActivatesFunction) linkObject;
			if (ActivatesFunctionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function dst = link.getTarget();
			Event src = link.getSource();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.ActivatesFunction_3004,
					ActivatesFunctionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_EventToOperatorConnection_3005(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof EventToOperatorConnection) {
				continue;
			}
			EventToOperatorConnection link = (EventToOperatorConnection) linkObject;
			if (EventToOperatorConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			LogicalOperator dst = link.getOperator();
			Event src = link.getEvent();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.EventToOperatorConnection_3005,
					EventToOperatorConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FunctionToOperatorConnection_3006(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof FunctionToOperatorConnection) {
				continue;
			}
			FunctionToOperatorConnection link = (FunctionToOperatorConnection) linkObject;
			if (FunctionToOperatorConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			LogicalOperator dst = link.getOperator();
			Function src = link.getFunction();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.FunctionToOperatorConnection_3006,
					FunctionToOperatorConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_OperatorToEventConnection_3007(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof OperatorToEventConnection) {
				continue;
			}
			OperatorToEventConnection link = (OperatorToEventConnection) linkObject;
			if (OperatorToEventConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Event dst = link.getEvent();
			LogicalOperator src = link.getOperator();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.OperatorToEventConnection_3007,
					OperatorToEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_OperatorToFunctionConnection_3008(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof OperatorToFunctionConnection) {
				continue;
			}
			OperatorToFunctionConnection link = (OperatorToFunctionConnection) linkObject;
			if (OperatorToFunctionConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function dst = link.getFunction();
			LogicalOperator src = link.getOperator();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.OperatorToFunctionConnection_3008,
					OperatorToFunctionConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_TriggersEvent_3001(
			Event target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getTriggersEvent_Target()
					|| false == setting.getEObject() instanceof TriggersEvent) {
				continue;
			}
			TriggersEvent link = (TriggersEvent) setting.getEObject();
			if (TriggersEventEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function src = link.getSource();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.TriggersEvent_3001,
					TriggersEventEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ProvidesDataTo_3002(
			Function target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getProvidesDataTo_Target()
					|| false == setting.getEObject() instanceof ProvidesDataTo) {
				continue;
			}
			ProvidesDataTo link = (ProvidesDataTo) setting.getEObject();
			if (ProvidesDataToEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Information src = link.getSource();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.ProvidesDataTo_3002,
					ProvidesDataToEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_WritesDataTo_3003(
			Information target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getWritesDataTo_Target()
					|| false == setting.getEObject() instanceof WritesDataTo) {
				continue;
			}
			WritesDataTo link = (WritesDataTo) setting.getEObject();
			if (WritesDataToEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function src = link.getSource();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.WritesDataTo_3003,
					WritesDataToEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ActivatesFunction_3004(
			Function target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getActivatesFunction_Target()
					|| false == setting.getEObject() instanceof ActivatesFunction) {
				continue;
			}
			ActivatesFunction link = (ActivatesFunction) setting.getEObject();
			if (ActivatesFunctionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Event src = link.getSource();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.ActivatesFunction_3004,
					ActivatesFunctionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_EventToOperatorConnection_3005(
			LogicalOperator target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getEventToOperatorConnection_Operator()
					|| false == setting.getEObject() instanceof EventToOperatorConnection) {
				continue;
			}
			EventToOperatorConnection link = (EventToOperatorConnection) setting
					.getEObject();
			if (EventToOperatorConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Event src = link.getEvent();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.EventToOperatorConnection_3005,
					EventToOperatorConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FunctionToOperatorConnection_3006(
			LogicalOperator target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getFunctionToOperatorConnection_Operator()
					|| false == setting.getEObject() instanceof FunctionToOperatorConnection) {
				continue;
			}
			FunctionToOperatorConnection link = (FunctionToOperatorConnection) setting
					.getEObject();
			if (FunctionToOperatorConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function src = link.getFunction();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.FunctionToOperatorConnection_3006,
					FunctionToOperatorConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_OperatorToEventConnection_3007(
			Event target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getOperatorToEventConnection_Event()
					|| false == setting.getEObject() instanceof OperatorToEventConnection) {
				continue;
			}
			OperatorToEventConnection link = (OperatorToEventConnection) setting
					.getEObject();
			if (OperatorToEventConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			LogicalOperator src = link.getOperator();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.OperatorToEventConnection_3007,
					OperatorToEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_OperatorToFunctionConnection_3008(
			Function target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getOperatorToFunctionConnection_Function()
					|| false == setting.getEObject() instanceof OperatorToFunctionConnection) {
				continue;
			}
			OperatorToFunctionConnection link = (OperatorToFunctionConnection) setting
					.getEObject();
			if (OperatorToFunctionConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			LogicalOperator src = link.getOperator();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.OperatorToFunctionConnection_3008,
					OperatorToFunctionConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_TriggersEvent_3001(
			Function source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof TriggersEvent) {
				continue;
			}
			TriggersEvent link = (TriggersEvent) linkObject;
			if (TriggersEventEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Event dst = link.getTarget();
			Function src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.TriggersEvent_3001,
					TriggersEventEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ProvidesDataTo_3002(
			Information source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof ProvidesDataTo) {
				continue;
			}
			ProvidesDataTo link = (ProvidesDataTo) linkObject;
			if (ProvidesDataToEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function dst = link.getTarget();
			Information src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.ProvidesDataTo_3002,
					ProvidesDataToEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_WritesDataTo_3003(
			Function source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof WritesDataTo) {
				continue;
			}
			WritesDataTo link = (WritesDataTo) linkObject;
			if (WritesDataToEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Information dst = link.getTarget();
			Function src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.WritesDataTo_3003,
					WritesDataToEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ActivatesFunction_3004(
			Event source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof ActivatesFunction) {
				continue;
			}
			ActivatesFunction link = (ActivatesFunction) linkObject;
			if (ActivatesFunctionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function dst = link.getTarget();
			Event src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.ActivatesFunction_3004,
					ActivatesFunctionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_EventToOperatorConnection_3005(
			Event source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof EventToOperatorConnection) {
				continue;
			}
			EventToOperatorConnection link = (EventToOperatorConnection) linkObject;
			if (EventToOperatorConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			LogicalOperator dst = link.getOperator();
			Event src = link.getEvent();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.EventToOperatorConnection_3005,
					EventToOperatorConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FunctionToOperatorConnection_3006(
			Function source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof FunctionToOperatorConnection) {
				continue;
			}
			FunctionToOperatorConnection link = (FunctionToOperatorConnection) linkObject;
			if (FunctionToOperatorConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			LogicalOperator dst = link.getOperator();
			Function src = link.getFunction();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.FunctionToOperatorConnection_3006,
					FunctionToOperatorConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_OperatorToEventConnection_3007(
			LogicalOperator source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof OperatorToEventConnection) {
				continue;
			}
			OperatorToEventConnection link = (OperatorToEventConnection) linkObject;
			if (OperatorToEventConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Event dst = link.getEvent();
			LogicalOperator src = link.getOperator();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.OperatorToEventConnection_3007,
					OperatorToEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_OperatorToFunctionConnection_3008(
			LogicalOperator source) {
		edu.unikiel.informatik.aiw.generated.epc.EPC container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
				container = (edu.unikiel.informatik.aiw.generated.epc.EPC) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof OperatorToFunctionConnection) {
				continue;
			}
			OperatorToFunctionConnection link = (OperatorToFunctionConnection) linkObject;
			if (OperatorToFunctionConnectionEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Function dst = link.getFunction();
			LogicalOperator src = link.getOperator();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.OperatorToFunctionConnection_3008,
					OperatorToFunctionConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

}
