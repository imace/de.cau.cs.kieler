package de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part;

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

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.FBFBEventConnection;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNetworkEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class CakefeedDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case FBEditPart.VISUAL_ID:
			return getFB_2001SemanticChildren(view);
		case FBNetworkEditPart.VISUAL_ID:
			return getFBNetwork_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFB_2001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		de.cau.cs.kieler.cakefeed.FB modelElement = (de.cau.cs.kieler.cakefeed.FB) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getInputEvents().iterator(); it
				.hasNext();) {
			FBInputEvent childElement = (FBInputEvent) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FBInputEventEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOutputEvents().iterator(); it
				.hasNext();) {
			FBOutputEvent childElement = (FBOutputEvent) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FBOutputEventEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getInputVars().iterator(); it.hasNext();) {
			FBInputVar childElement = (FBInputVar) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FBInputVarEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOutputVars().iterator(); it
				.hasNext();) {
			FBOutputVar childElement = (FBOutputVar) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FBOutputVarEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBNetwork_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		FBNetwork modelElement = (FBNetwork) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getFBs().iterator(); it.hasNext();) {
			de.cau.cs.kieler.cakefeed.FB childElement = (de.cau.cs.kieler.cakefeed.FB) it
					.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FBEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case FBNetworkEditPart.VISUAL_ID:
			return getFBNetwork_1000ContainedLinks(view);
		case FBEditPart.VISUAL_ID:
			return getFB_2001ContainedLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3001ContainedLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3002ContainedLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3003ContainedLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3004ContainedLinks(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4001ContainedLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case FBEditPart.VISUAL_ID:
			return getFB_2001IncomingLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3001IncomingLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3002IncomingLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3003IncomingLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3004IncomingLinks(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4001IncomingLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case FBEditPart.VISUAL_ID:
			return getFB_2001OutgoingLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3001OutgoingLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3002OutgoingLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3003OutgoingLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3004OutgoingLinks(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4001OutgoingLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBNetwork_1000ContainedLinks(View view) {
		FBNetwork modelElement = (FBNetwork) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_FBFBEventConnection_4001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_FBFBDataConnection_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFB_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBEventConnection_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFB_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3001IncomingLinks(View view) {
		FBInputEvent modelElement = (FBInputEvent) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_FBFBEventConnection_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3003IncomingLinks(View view) {
		FBInputVar modelElement = (FBInputVar) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_FBFBDataConnection_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBEventConnection_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFB_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3002OutgoingLinks(View view) {
		FBOutputEvent modelElement = (FBOutputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_FBFBEventConnection_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3004OutgoingLinks(View view) {
		FBOutputVar modelElement = (FBOutputVar) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_FBFBDataConnection_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBFBEventConnection_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FBFBEventConnection_4001(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEventConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FBFBEventConnection) {
				continue;
			}
			FBFBEventConnection link = (FBFBEventConnection) linkObject;
			if (FBFBEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputEvent dst = link.getDestination();
			FBOutputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBFBEventConnection_4001,
					FBFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FBFBDataConnection_4002(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getDataConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FBFBDataConnection) {
				continue;
			}
			FBFBDataConnection link = (FBFBDataConnection) linkObject;
			if (FBFBDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputVar dst = link.getDestination();
			FBOutputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBFBDataConnection_4002,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FBFBEventConnection_4001(
			FBInputEvent target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getFBFBEventConnection_Destination()
					|| false == setting.getEObject() instanceof FBFBEventConnection) {
				continue;
			}
			FBFBEventConnection link = (FBFBEventConnection) setting
					.getEObject();
			if (FBFBEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBOutputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.FBFBEventConnection_4001,
					FBFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FBFBDataConnection_4002(
			FBInputVar target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getFBFBDataConnection_Destination()
					|| false == setting.getEObject() instanceof FBFBDataConnection) {
				continue;
			}
			FBFBDataConnection link = (FBFBDataConnection) setting.getEObject();
			if (FBFBDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBOutputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.FBFBDataConnection_4002,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FBFBEventConnection_4001(
			FBOutputEvent source) {
		FBNetwork container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof FBNetwork) {
				container = (FBNetwork) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getEventConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FBFBEventConnection) {
				continue;
			}
			FBFBEventConnection link = (FBFBEventConnection) linkObject;
			if (FBFBEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputEvent dst = link.getDestination();
			FBOutputEvent src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBFBEventConnection_4001,
					FBFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FBFBDataConnection_4002(
			FBOutputVar source) {
		FBNetwork container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof FBNetwork) {
				container = (FBNetwork) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getDataConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FBFBDataConnection) {
				continue;
			}
			FBFBDataConnection link = (FBFBDataConnection) linkObject;
			if (FBFBDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputVar dst = link.getDestination();
			FBOutputVar src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBFBDataConnection_4002,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

}
