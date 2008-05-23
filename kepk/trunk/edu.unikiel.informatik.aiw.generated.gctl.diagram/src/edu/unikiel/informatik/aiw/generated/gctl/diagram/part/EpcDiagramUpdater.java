package edu.unikiel.informatik.aiw.generated.gctl.diagram.part;

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

import edu.unikiel.informatik.aiw.generated.epc.EPCObject;
import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.Event;
import edu.unikiel.informatik.aiw.generated.epc.Function;
import edu.unikiel.informatik.aiw.generated.epc.GCTLconnector;
import edu.unikiel.informatik.aiw.generated.epc.Implication;
import edu.unikiel.informatik.aiw.generated.epc.Information;
import edu.unikiel.informatik.aiw.generated.epc.Node;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLconnectorEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.ImplicationEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.InformationEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.providers.EpcElementTypes;

/**
 * @generated
 */
public class EpcDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case GCTLEditPart.VISUAL_ID:
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
			if (visualID == FunctionEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EventEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InformationEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EPCEditPart.VISUAL_ID) {
				result.add(new EpcNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ImplicationEditPart.VISUAL_ID) {
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
		case GCTLEditPart.VISUAL_ID:
			return getEPC_79ContainedLinks(view);
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1001ContainedLinks(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1002ContainedLinks(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003ContainedLinks(view);
		case EPCEditPart.VISUAL_ID:
			return getEPC_1004ContainedLinks(view);
		case ImplicationEditPart.VISUAL_ID:
			return getImplication_1005ContainedLinks(view);
		case GCTLconnectorEditPart.VISUAL_ID:
			return getGCTLconnector_3001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1001IncomingLinks(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1002IncomingLinks(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003IncomingLinks(view);
		case EPCEditPart.VISUAL_ID:
			return getEPC_1004IncomingLinks(view);
		case ImplicationEditPart.VISUAL_ID:
			return getImplication_1005IncomingLinks(view);
		case GCTLconnectorEditPart.VISUAL_ID:
			return getGCTLconnector_3001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1001OutgoingLinks(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1002OutgoingLinks(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003OutgoingLinks(view);
		case EPCEditPart.VISUAL_ID:
			return getEPC_1004OutgoingLinks(view);
		case ImplicationEditPart.VISUAL_ID:
			return getImplication_1005OutgoingLinks(view);
		case GCTLconnectorEditPart.VISUAL_ID:
			return getGCTLconnector_3001OutgoingLinks(view);
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
				.addAll(getContainedTypeModelFacetLinks_GCTLconnector_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFunction_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEvent_1002ContainedLinks(View view) {
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
	public static List getEPC_1004ContainedLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_GCTLconnector_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getImplication_1005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGCTLconnector_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFunction_1001IncomingLinks(View view) {
		Function modelElement = (Function) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_GCTLconnector_3001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEvent_1002IncomingLinks(View view) {
		Event modelElement = (Event) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_GCTLconnector_3001(
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
		result.addAll(getIncomingTypeModelFacetLinks_GCTLconnector_3001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPC_1004IncomingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_GCTLconnector_3001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getImplication_1005IncomingLinks(View view) {
		Implication modelElement = (Implication) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_GCTLconnector_3001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGCTLconnector_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFunction_1001OutgoingLinks(View view) {
		Function modelElement = (Function) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_GCTLconnector_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEvent_1002OutgoingLinks(View view) {
		Event modelElement = (Event) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_GCTLconnector_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInformation_1003OutgoingLinks(View view) {
		Information modelElement = (Information) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_GCTLconnector_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEPC_1004OutgoingLinks(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC modelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_GCTLconnector_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getImplication_1005OutgoingLinks(View view) {
		Implication modelElement = (Implication) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_GCTLconnector_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGCTLconnector_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_GCTLconnector_3001(
			edu.unikiel.informatik.aiw.generated.epc.EPC container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnectors().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof GCTLconnector) {
				continue;
			}
			GCTLconnector link = (GCTLconnector) linkObject;
			if (GCTLconnectorEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.GCTLconnector_3001,
					GCTLconnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_GCTLconnector_3001(
			Node target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != EpcPackage.eINSTANCE
					.getGCTLconnector_Target()
					|| false == setting.getEObject() instanceof GCTLconnector) {
				continue;
			}
			GCTLconnector link = (GCTLconnector) setting.getEObject();
			if (GCTLconnectorEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getSource();
			result.add(new EpcLinkDescriptor(src, target, link,
					EpcElementTypes.GCTLconnector_3001,
					GCTLconnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_GCTLconnector_3001(
			Node source) {
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
			if (false == linkObject instanceof GCTLconnector) {
				continue;
			}
			GCTLconnector link = (GCTLconnector) linkObject;
			if (GCTLconnectorEditPart.VISUAL_ID != EpcVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new EpcLinkDescriptor(src, dst, link,
					EpcElementTypes.GCTLconnector_3001,
					GCTLconnectorEditPart.VISUAL_ID));
		}
		return result;
	}

}
