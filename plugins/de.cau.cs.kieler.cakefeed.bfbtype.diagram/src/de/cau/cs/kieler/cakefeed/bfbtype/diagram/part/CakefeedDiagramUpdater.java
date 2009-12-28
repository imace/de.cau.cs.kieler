package de.cau.cs.kieler.cakefeed.bfbtype.diagram.part;

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

import de.cau.cs.kieler.cakefeed.BFBDiagram;
import de.cau.cs.kieler.cakefeed.BFBType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.InputWith;
import de.cau.cs.kieler.cakefeed.InternalVar;
import de.cau.cs.kieler.cakefeed.Other;
import de.cau.cs.kieler.cakefeed.OutputWith;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeBFBTypeCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDFBDCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBFBCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class CakefeedDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case BFBTypeBFBTypeCompartmentEditPart.VISUAL_ID:
			return getBFBTypeBFBTypeCompartment_7001SemanticChildren(view);
		case FBDFBDCompartmentEditPart.VISUAL_ID:
			return getFBDFBDCompartment_7002SemanticChildren(view);
		case FBFBCompartmentEditPart.VISUAL_ID:
			return getFBFBCompartment_7004SemanticChildren(view);
		case BFBDiagramEditPart.VISUAL_ID:
			return getBFBDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBFBTypeBFBTypeCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BFBType modelElement = (BFBType) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getInputEvents().iterator(); it
				.hasNext();) {
			IFInputEvent childElement = (IFInputEvent) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == IFInputEventEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOutputEvents().iterator(); it
				.hasNext();) {
			IFOutputEvent childElement = (IFOutputEvent) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == IFOutputEventEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getInputVars().iterator(); it.hasNext();) {
			IFInputVar childElement = (IFInputVar) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == IFInputVarEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOutputVars().iterator(); it
				.hasNext();) {
			IFOutputVar childElement = (IFOutputVar) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == IFOutputVarEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getInternalVars().iterator(); it
				.hasNext();) {
			InternalVar childElement = (InternalVar) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == InternalVarEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getFBDs().iterator(); it.hasNext();) {
			de.cau.cs.kieler.cakefeed.FBD childElement = (de.cau.cs.kieler.cakefeed.FBD) it
					.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == FBDEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getSTs().iterator(); it.hasNext();) {
			de.cau.cs.kieler.cakefeed.ST childElement = (de.cau.cs.kieler.cakefeed.ST) it
					.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == STEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getLDs().iterator(); it.hasNext();) {
			de.cau.cs.kieler.cakefeed.LD childElement = (de.cau.cs.kieler.cakefeed.LD) it
					.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == LDEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getOtherAlgorithms().iterator(); it
				.hasNext();) {
			Other childElement = (Other) it.next();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OtherEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBDFBDCompartment_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		de.cau.cs.kieler.cakefeed.FBD modelElement = (de.cau.cs.kieler.cakefeed.FBD) containerView
				.getElement();
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
	public static List getFBFBCompartment_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		de.cau.cs.kieler.cakefeed.FB modelElement = (de.cau.cs.kieler.cakefeed.FB) containerView
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
	public static List getBFBDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BFBDiagram modelElement = (BFBDiagram) view.getElement();
		List result = new LinkedList();
		{
			BFBType childElement = modelElement.getBFBType();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == BFBTypeEditPart.VISUAL_ID) {
				result.add(new CakefeedNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case BFBDiagramEditPart.VISUAL_ID:
			return getBFBDiagram_1000ContainedLinks(view);
		case BFBTypeEditPart.VISUAL_ID:
			return getBFBType_2001ContainedLinks(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3015ContainedLinks(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3016ContainedLinks(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3017ContainedLinks(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3018ContainedLinks(view);
		case InternalVarEditPart.VISUAL_ID:
			return getInternalVar_3005ContainedLinks(view);
		case FBDEditPart.VISUAL_ID:
			return getFBD_3006ContainedLinks(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3019ContainedLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3020ContainedLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3021ContainedLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3022ContainedLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3023ContainedLinks(view);
		case STEditPart.VISUAL_ID:
			return getST_3008ContainedLinks(view);
		case LDEditPart.VISUAL_ID:
			return getLD_3009ContainedLinks(view);
		case OtherEditPart.VISUAL_ID:
			return getOther_3010ContainedLinks(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001ContainedLinks(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002ContainedLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4005ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case BFBTypeEditPart.VISUAL_ID:
			return getBFBType_2001IncomingLinks(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3015IncomingLinks(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3016IncomingLinks(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3017IncomingLinks(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3018IncomingLinks(view);
		case InternalVarEditPart.VISUAL_ID:
			return getInternalVar_3005IncomingLinks(view);
		case FBDEditPart.VISUAL_ID:
			return getFBD_3006IncomingLinks(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3019IncomingLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3020IncomingLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3021IncomingLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3022IncomingLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3023IncomingLinks(view);
		case STEditPart.VISUAL_ID:
			return getST_3008IncomingLinks(view);
		case LDEditPart.VISUAL_ID:
			return getLD_3009IncomingLinks(view);
		case OtherEditPart.VISUAL_ID:
			return getOther_3010IncomingLinks(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001IncomingLinks(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002IncomingLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4005IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case BFBTypeEditPart.VISUAL_ID:
			return getBFBType_2001OutgoingLinks(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3015OutgoingLinks(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3016OutgoingLinks(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3017OutgoingLinks(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3018OutgoingLinks(view);
		case InternalVarEditPart.VISUAL_ID:
			return getInternalVar_3005OutgoingLinks(view);
		case FBDEditPart.VISUAL_ID:
			return getFBD_3006OutgoingLinks(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3019OutgoingLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3020OutgoingLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3021OutgoingLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3022OutgoingLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3023OutgoingLinks(view);
		case STEditPart.VISUAL_ID:
			return getST_3008OutgoingLinks(view);
		case LDEditPart.VISUAL_ID:
			return getLD_3009OutgoingLinks(view);
		case OtherEditPart.VISUAL_ID:
			return getOther_3010OutgoingLinks(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001OutgoingLinks(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002OutgoingLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4005OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBFBDiagram_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBFBType_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFInputEvent_3015ContainedLinks(View view) {
		IFInputEvent modelElement = (IFInputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_InputWith_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputEvent_3016ContainedLinks(View view) {
		IFOutputEvent modelElement = (IFOutputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_OutputWith_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFInputVar_3017ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputVar_3018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInternalVar_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBD_3006ContainedLinks(View view) {
		de.cau.cs.kieler.cakefeed.FBD modelElement = (de.cau.cs.kieler.cakefeed.FBD) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_FBFBDataConnection_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFB_3019ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3020ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3021ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3022ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3023ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getST_3008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLD_3009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOther_3010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInputWith_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutputWith_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBFBType_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFInputEvent_3015IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputEvent_3016IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFInputVar_3017IncomingLinks(View view) {
		IFInputVar modelElement = (IFInputVar) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_InputWith_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputVar_3018IncomingLinks(View view) {
		IFOutputVar modelElement = (IFOutputVar) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_OutputWith_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getInternalVar_3005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBD_3006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFB_3019IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3020IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3021IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3022IncomingLinks(View view) {
		FBInputVar modelElement = (FBInputVar) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_FBFBDataConnection_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3023IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getST_3008IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLD_3009IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOther_3010IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInputWith_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutputWith_4002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBFBType_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFInputEvent_3015OutgoingLinks(View view) {
		IFInputEvent modelElement = (IFInputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_InputWith_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputEvent_3016OutgoingLinks(View view) {
		IFOutputEvent modelElement = (IFOutputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_OutputWith_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFInputVar_3017OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputVar_3018OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInternalVar_3005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBD_3006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFB_3019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3020OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3021OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3022OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3023OutgoingLinks(View view) {
		FBOutputVar modelElement = (FBOutputVar) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_FBFBDataConnection_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getST_3008OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLD_3009OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOther_3010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInputWith_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutputWith_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_InputWith_4001(
			IFInputEvent container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getWith().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof InputWith) {
				continue;
			}
			InputWith link = (InputWith) linkObject;
			if (InputWithEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFInputVar dst = link.getWith();
			IFInputEvent src = link.getParentInputEvent();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.InputWith_4001,
					InputWithEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_OutputWith_4002(
			IFOutputEvent container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getWith().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof OutputWith) {
				continue;
			}
			OutputWith link = (OutputWith) linkObject;
			if (OutputWithEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputVar dst = link.getWith();
			IFOutputEvent src = link.getParentOutputEvent();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.OutputWith_4002,
					OutputWithEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FBFBDataConnection_4005(
			de.cau.cs.kieler.cakefeed.FBD container) {
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
					CakefeedElementTypes.FBFBDataConnection_4005,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_InputWith_4001(
			IFInputVar target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getInputWith_With()
					|| false == setting.getEObject() instanceof InputWith) {
				continue;
			}
			InputWith link = (InputWith) setting.getEObject();
			if (InputWithEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFInputEvent src = link.getParentInputEvent();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.InputWith_4001,
					InputWithEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_OutputWith_4002(
			IFOutputVar target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getOutputWith_With()
					|| false == setting.getEObject() instanceof OutputWith) {
				continue;
			}
			OutputWith link = (OutputWith) setting.getEObject();
			if (OutputWithEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputEvent src = link.getParentOutputEvent();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.OutputWith_4002,
					OutputWithEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FBFBDataConnection_4005(
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
					CakefeedElementTypes.FBFBDataConnection_4005,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_InputWith_4001(
			IFInputEvent source) {
		IFInputEvent container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof IFInputEvent) {
				container = (IFInputEvent) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getWith().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof InputWith) {
				continue;
			}
			InputWith link = (InputWith) linkObject;
			if (InputWithEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFInputVar dst = link.getWith();
			IFInputEvent src = link.getParentInputEvent();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.InputWith_4001,
					InputWithEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_OutputWith_4002(
			IFOutputEvent source) {
		IFOutputEvent container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof IFOutputEvent) {
				container = (IFOutputEvent) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getWith().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof OutputWith) {
				continue;
			}
			OutputWith link = (OutputWith) linkObject;
			if (OutputWithEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputVar dst = link.getWith();
			IFOutputEvent src = link.getParentOutputEvent();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.OutputWith_4002,
					OutputWithEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FBFBDataConnection_4005(
			FBOutputVar source) {
		de.cau.cs.kieler.cakefeed.FBD container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof de.cau.cs.kieler.cakefeed.FBD) {
				container = (de.cau.cs.kieler.cakefeed.FBD) element;
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
					CakefeedElementTypes.FBFBDataConnection_4005,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

}
