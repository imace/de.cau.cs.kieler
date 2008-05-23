package edu.unikiel.informatik.aiw.generated.epc.diagram.part;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

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

/**
 * @generated
 */
public class EpcDiagramContentInitializer {

	/**
	 * @generated
	 */
	private Map myDomain2NotationMap = new HashMap();

	/**
	 * @generated
	 */
	private Collection myLinkDescriptors = new LinkedList();

	/**
	 * @generated
	 */
	public void initDiagramContent(Diagram diagram) {
		if (!EPCEditPart.MODEL_ID.equals(diagram.getType())) {
			EpcDiagramEditorPlugin.getInstance().logError(
					"Incorrect diagram passed as a parameter: "
							+ diagram.getType());
			return;
		}
		if (false == diagram.getElement() instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
			EpcDiagramEditorPlugin
					.getInstance()
					.logError(
							"Incorrect diagram element specified: "
									+ diagram.getElement()
									+ " instead of edu.unikiel.informatik.aiw.generated.epc.EPC");
			return;
		}
		createEPC_79Children(diagram);
		createLinks(diagram);
	}

	/**
	 * @generated
	 */
	private void createAND_1001Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getAND_1001OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createOR_1002Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getOR_1002OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createInformation_1003Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getInformation_1003OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createXOR_1004Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getXOR_1004OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEvent_1005Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getEvent_1005OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEPC_1006Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getEPC_1006OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createFunction_1007Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getFunction_1007OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEPC_79Children(View view) {
		Collection childNodeDescriptors = EpcDiagramUpdater
				.getEPC_79SemanticChildren(view);
		for (Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (EpcNodeDescriptor) it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createNode(View parentView, EpcNodeDescriptor nodeDescriptor) {
		Node node = ViewService.createNode(parentView, nodeDescriptor
				.getModelElement(), nodeDescriptor.getType(),
				EpcDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		switch (nodeDescriptor.getVisualID()) {
		case ANDEditPart.VISUAL_ID:
			createAND_1001Children(node);
			return;
		case OREditPart.VISUAL_ID:
			createOR_1002Children(node);
			return;
		case InformationEditPart.VISUAL_ID:
			createInformation_1003Children(node);
			return;
		case XOREditPart.VISUAL_ID:
			createXOR_1004Children(node);
			return;
		case EventEditPart.VISUAL_ID:
			createEvent_1005Children(node);
			return;
		case EPC2EditPart.VISUAL_ID:
			createEPC_1006Children(node);
			return;
		case FunctionEditPart.VISUAL_ID:
			createFunction_1007Children(node);
			return;
		}
	}

	/**
	 * @generated
	 */
	private void createLinks(Diagram diagram) {
		for (boolean continueLinkCreation = true; continueLinkCreation;) {
			continueLinkCreation = false;
			Collection additionalDescriptors = new LinkedList();
			for (Iterator it = myLinkDescriptors.iterator(); it.hasNext();) {
				EpcLinkDescriptor nextLinkDescriptor = (EpcLinkDescriptor) it
						.next();
				if (!myDomain2NotationMap.containsKey(nextLinkDescriptor
						.getSource())
						|| !myDomain2NotationMap.containsKey(nextLinkDescriptor
								.getDestination())) {
					continue;
				}
				Edge edge = (Edge) ViewService.getInstance().createEdge(
						nextLinkDescriptor.getSemanticAdapter(), diagram,
						nextLinkDescriptor.getType(), ViewUtil.APPEND,
						EpcDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (edge != null) {
					edge.setSource((View) myDomain2NotationMap
							.get(nextLinkDescriptor.getSource()));
					edge.setTarget((View) myDomain2NotationMap
							.get(nextLinkDescriptor.getDestination()));
					it.remove();
					if (nextLinkDescriptor.getModelElement() != null) {
						myDomain2NotationMap.put(nextLinkDescriptor
								.getModelElement(), edge);
					}
					continueLinkCreation = true;
					switch (nextLinkDescriptor.getVisualID()) {
					case TriggersEventEditPart.VISUAL_ID:
						additionalDescriptors.addAll(EpcDiagramUpdater
								.getTriggersEvent_3001OutgoingLinks(edge));
						break;
					case ProvidesDataToEditPart.VISUAL_ID:
						additionalDescriptors.addAll(EpcDiagramUpdater
								.getProvidesDataTo_3002OutgoingLinks(edge));
						break;
					case WritesDataToEditPart.VISUAL_ID:
						additionalDescriptors.addAll(EpcDiagramUpdater
								.getWritesDataTo_3003OutgoingLinks(edge));
						break;
					case ActivatesFunctionEditPart.VISUAL_ID:
						additionalDescriptors.addAll(EpcDiagramUpdater
								.getActivatesFunction_3004OutgoingLinks(edge));
						break;
					case EventToOperatorConnectionEditPart.VISUAL_ID:
						additionalDescriptors
								.addAll(EpcDiagramUpdater
										.getEventToOperatorConnection_3005OutgoingLinks(edge));
						break;
					case FunctionToOperatorConnectionEditPart.VISUAL_ID:
						additionalDescriptors
								.addAll(EpcDiagramUpdater
										.getFunctionToOperatorConnection_3006OutgoingLinks(edge));
						break;
					case OperatorToEventConnectionEditPart.VISUAL_ID:
						additionalDescriptors
								.addAll(EpcDiagramUpdater
										.getOperatorToEventConnection_3007OutgoingLinks(edge));
						break;
					case OperatorToFunctionConnectionEditPart.VISUAL_ID:
						additionalDescriptors
								.addAll(EpcDiagramUpdater
										.getOperatorToFunctionConnection_3008OutgoingLinks(edge));
						break;
					}
				}
			}
			myLinkDescriptors.addAll(additionalDescriptors);
		}
	}

}
