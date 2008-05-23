package edu.unikiel.informatik.aiw.generated.gctl.diagram.part;

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

import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLconnectorEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.ImplicationEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.InformationEditPart;

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
		if (!GCTLEditPart.MODEL_ID.equals(diagram.getType())) {
			GctlDiagramEditorPlugin.getInstance().logError(
					"Incorrect diagram passed as a parameter: "
							+ diagram.getType());
			return;
		}
		if (false == diagram.getElement() instanceof edu.unikiel.informatik.aiw.generated.epc.EPC) {
			GctlDiagramEditorPlugin
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
	private void createFunction_1001Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getFunction_1001OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createEvent_1002Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getEvent_1002OutgoingLinks(view));

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
	private void createEPC_1004Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getEPC_1004OutgoingLinks(view));

	}

	/**
	 * @generated
	 */
	private void createImplication_1005Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(EpcDiagramUpdater
				.getImplication_1005OutgoingLinks(view));

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
				GctlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		switch (nodeDescriptor.getVisualID()) {
		case FunctionEditPart.VISUAL_ID:
			createFunction_1001Children(node);
			return;
		case EventEditPart.VISUAL_ID:
			createEvent_1002Children(node);
			return;
		case InformationEditPart.VISUAL_ID:
			createInformation_1003Children(node);
			return;
		case EPCEditPart.VISUAL_ID:
			createEPC_1004Children(node);
			return;
		case ImplicationEditPart.VISUAL_ID:
			createImplication_1005Children(node);
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
						GctlDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
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
					case GCTLconnectorEditPart.VISUAL_ID:
						additionalDescriptors.addAll(EpcDiagramUpdater
								.getGCTLconnector_3001OutgoingLinks(edge));
						break;
					}
				}
			}
			myLinkDescriptors.addAll(additionalDescriptors);
		}
	}

}
