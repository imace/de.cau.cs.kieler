package de.cau.cs.kieler.cakefeed.cfbtype.diagram.part;

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

import de.cau.cs.kieler.cakefeed.CFBDiagram;
import de.cau.cs.kieler.cakefeed.CFBType;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.FBFBEventConnection;
import de.cau.cs.kieler.cakefeed.FBIFDataConnection;
import de.cau.cs.kieler.cakefeed.FBIFEventConnection;
import de.cau.cs.kieler.cakefeed.FBInputEvent;
import de.cau.cs.kieler.cakefeed.FBInputVar;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.FBOutputEvent;
import de.cau.cs.kieler.cakefeed.FBOutputVar;
import de.cau.cs.kieler.cakefeed.IFFBDataConnection;
import de.cau.cs.kieler.cakefeed.IFFBEventConnection;
import de.cau.cs.kieler.cakefeed.IFIFDataConnection;
import de.cau.cs.kieler.cakefeed.IFIFEventConnection;
import de.cau.cs.kieler.cakefeed.IFInputEvent;
import de.cau.cs.kieler.cakefeed.IFInputVar;
import de.cau.cs.kieler.cakefeed.IFOutputEvent;
import de.cau.cs.kieler.cakefeed.IFOutputVar;
import de.cau.cs.kieler.cakefeed.InputWith;
import de.cau.cs.kieler.cakefeed.OutputWith;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeCFBTypeCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;

/**
 * @generated
 */
public class CakefeedDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case CFBTypeEditPart.VISUAL_ID:
			return getCFBType_2002SemanticChildren(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3025SemanticChildren(view);
		case CFBTypeCFBTypeCompartmentEditPart.VISUAL_ID:
			return getCFBTypeCFBTypeCompartment_7005SemanticChildren(view);
		case CFBDiagramEditPart.VISUAL_ID:
			return getCFBDiagram_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCFBType_2002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CFBType modelElement = (CFBType) view.getElement();
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
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFB_3025SemanticChildren(View view) {
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
	public static List getCFBTypeCFBTypeCompartment_7005SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CFBType modelElement = (CFBType) containerView.getElement();
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
	public static List getCFBDiagram_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CFBDiagram modelElement = (CFBDiagram) view.getElement();
		List result = new LinkedList();
		{
			CFBType childElement = modelElement.getCFBType();
			int visualID = CakefeedVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CFBTypeEditPart.VISUAL_ID) {
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
		case CFBDiagramEditPart.VISUAL_ID:
			return getCFBDiagram_1000ContainedLinks(view);
		case CFBTypeEditPart.VISUAL_ID:
			return getCFBType_2002ContainedLinks(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3021ContainedLinks(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3022ContainedLinks(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3023ContainedLinks(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3024ContainedLinks(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3025ContainedLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3026ContainedLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3027ContainedLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3028ContainedLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3029ContainedLinks(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001ContainedLinks(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002ContainedLinks(view);
		case IFIFEventConnectionEditPart.VISUAL_ID:
			return getIFIFEventConnection_4007ContainedLinks(view);
		case IFFBEventConnectionEditPart.VISUAL_ID:
			return getIFFBEventConnection_4008ContainedLinks(view);
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return getFBIFEventConnection_4009ContainedLinks(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4010ContainedLinks(view);
		case IFIFDataConnectionEditPart.VISUAL_ID:
			return getIFIFDataConnection_4011ContainedLinks(view);
		case IFFBDataConnectionEditPart.VISUAL_ID:
			return getIFFBDataConnection_4012ContainedLinks(view);
		case FBIFDataConnectionEditPart.VISUAL_ID:
			return getFBIFDataConnection_4013ContainedLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4014ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case CFBTypeEditPart.VISUAL_ID:
			return getCFBType_2002IncomingLinks(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3021IncomingLinks(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3022IncomingLinks(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3023IncomingLinks(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3024IncomingLinks(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3025IncomingLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3026IncomingLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3027IncomingLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3028IncomingLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3029IncomingLinks(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001IncomingLinks(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002IncomingLinks(view);
		case IFIFEventConnectionEditPart.VISUAL_ID:
			return getIFIFEventConnection_4007IncomingLinks(view);
		case IFFBEventConnectionEditPart.VISUAL_ID:
			return getIFFBEventConnection_4008IncomingLinks(view);
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return getFBIFEventConnection_4009IncomingLinks(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4010IncomingLinks(view);
		case IFIFDataConnectionEditPart.VISUAL_ID:
			return getIFIFDataConnection_4011IncomingLinks(view);
		case IFFBDataConnectionEditPart.VISUAL_ID:
			return getIFFBDataConnection_4012IncomingLinks(view);
		case FBIFDataConnectionEditPart.VISUAL_ID:
			return getFBIFDataConnection_4013IncomingLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4014IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case CFBTypeEditPart.VISUAL_ID:
			return getCFBType_2002OutgoingLinks(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3021OutgoingLinks(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3022OutgoingLinks(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3023OutgoingLinks(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3024OutgoingLinks(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3025OutgoingLinks(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3026OutgoingLinks(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3027OutgoingLinks(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3028OutgoingLinks(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3029OutgoingLinks(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001OutgoingLinks(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002OutgoingLinks(view);
		case IFIFEventConnectionEditPart.VISUAL_ID:
			return getIFIFEventConnection_4007OutgoingLinks(view);
		case IFFBEventConnectionEditPart.VISUAL_ID:
			return getIFFBEventConnection_4008OutgoingLinks(view);
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return getFBIFEventConnection_4009OutgoingLinks(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4010OutgoingLinks(view);
		case IFIFDataConnectionEditPart.VISUAL_ID:
			return getIFIFDataConnection_4011OutgoingLinks(view);
		case IFFBDataConnectionEditPart.VISUAL_ID:
			return getIFFBDataConnection_4012OutgoingLinks(view);
		case FBIFDataConnectionEditPart.VISUAL_ID:
			return getFBIFDataConnection_4013OutgoingLinks(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4014OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCFBDiagram_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCFBType_2002ContainedLinks(View view) {
		CFBType modelElement = (CFBType) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_IFIFEventConnection_4007(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_IFFBEventConnection_4008(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_FBIFEventConnection_4009(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_FBFBEventConnection_4010(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_IFIFDataConnection_4011(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_IFFBDataConnection_4012(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_FBIFDataConnection_4013(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_FBFBDataConnection_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFInputEvent_3021ContainedLinks(View view) {
		IFInputEvent modelElement = (IFInputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_InputWith_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputEvent_3022ContainedLinks(View view) {
		IFOutputEvent modelElement = (IFOutputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_OutputWith_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFInputVar_3023ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputVar_3024ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFB_3025ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3026ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3027ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3028ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3029ContainedLinks(View view) {
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
	public static List getIFIFEventConnection_4007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFFBEventConnection_4008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBIFEventConnection_4009ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBEventConnection_4010ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFIFDataConnection_4011ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFFBDataConnection_4012ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBIFDataConnection_4013ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCFBType_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFInputEvent_3021IncomingLinks(View view) {
		IFInputEvent modelElement = (IFInputEvent) view.getElement();
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
	public static List getIFOutputEvent_3022IncomingLinks(View view) {
		IFOutputEvent modelElement = (IFOutputEvent) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_IFIFEventConnection_4007(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FBIFEventConnection_4009(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFInputVar_3023IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputVar_3024IncomingLinks(View view) {
		IFOutputVar modelElement = (IFOutputVar) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_OutputWith_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_IFIFDataConnection_4011(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FBIFDataConnection_4013(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFB_3025IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3026IncomingLinks(View view) {
		FBInputEvent modelElement = (FBInputEvent) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_IFFBEventConnection_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FBFBEventConnection_4010(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3027IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3028IncomingLinks(View view) {
		FBInputVar modelElement = (FBInputVar) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_IFFBDataConnection_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FBFBDataConnection_4014(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3029IncomingLinks(View view) {
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
	public static List getIFIFEventConnection_4007IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFFBEventConnection_4008IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBIFEventConnection_4009IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBEventConnection_4010IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFIFDataConnection_4011IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFFBDataConnection_4012IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBIFDataConnection_4013IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4014IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCFBType_2002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFInputEvent_3021OutgoingLinks(View view) {
		IFInputEvent modelElement = (IFInputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_InputWith_4001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_IFIFEventConnection_4007(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_IFFBEventConnection_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputEvent_3022OutgoingLinks(View view) {
		IFOutputEvent modelElement = (IFOutputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_OutputWith_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFInputVar_3023OutgoingLinks(View view) {
		IFInputVar modelElement = (IFInputVar) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_IFIFDataConnection_4011(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_IFFBDataConnection_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIFOutputVar_3024OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFB_3025OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBInputEvent_3026OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputEvent_3027OutgoingLinks(View view) {
		FBOutputEvent modelElement = (FBOutputEvent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_FBIFEventConnection_4009(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_FBFBEventConnection_4010(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFBInputVar_3028OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBOutputVar_3029OutgoingLinks(View view) {
		FBOutputVar modelElement = (FBOutputVar) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_FBIFDataConnection_4013(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_FBFBDataConnection_4014(modelElement));
		return result;
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
	public static List getIFIFEventConnection_4007OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFFBEventConnection_4008OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBIFEventConnection_4009OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBEventConnection_4010OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFIFDataConnection_4011OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIFFBDataConnection_4012OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBIFDataConnection_4013OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFBFBDataConnection_4014OutgoingLinks(View view) {
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
			IFInputEvent dst = link.getParentInputEvent();
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
	private static Collection getContainedTypeModelFacetLinks_IFIFEventConnection_4007(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEventConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof IFIFEventConnection) {
				continue;
			}
			IFIFEventConnection link = (IFIFEventConnection) linkObject;
			if (IFIFEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputEvent dst = link.getDestination();
			IFInputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFIFEventConnection_4007,
					IFIFEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_IFFBEventConnection_4008(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEventConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof IFFBEventConnection) {
				continue;
			}
			IFFBEventConnection link = (IFFBEventConnection) linkObject;
			if (IFFBEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputEvent dst = link.getDestination();
			IFInputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFFBEventConnection_4008,
					IFFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FBIFEventConnection_4009(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEventConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FBIFEventConnection) {
				continue;
			}
			FBIFEventConnection link = (FBIFEventConnection) linkObject;
			if (FBIFEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputEvent dst = link.getDestination();
			FBOutputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBIFEventConnection_4009,
					FBIFEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FBFBEventConnection_4010(
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
					CakefeedElementTypes.FBFBEventConnection_4010,
					FBFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_IFIFDataConnection_4011(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getDataConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof IFIFDataConnection) {
				continue;
			}
			IFIFDataConnection link = (IFIFDataConnection) linkObject;
			if (IFIFDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputVar dst = link.getDestination();
			IFInputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFIFDataConnection_4011,
					IFIFDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_IFFBDataConnection_4012(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getDataConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof IFFBDataConnection) {
				continue;
			}
			IFFBDataConnection link = (IFFBDataConnection) linkObject;
			if (IFFBDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputVar dst = link.getDestination();
			IFInputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFFBDataConnection_4012,
					IFFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FBIFDataConnection_4013(
			FBNetwork container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getDataConnections().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FBIFDataConnection) {
				continue;
			}
			FBIFDataConnection link = (FBIFDataConnection) linkObject;
			if (FBIFDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputVar dst = link.getDestination();
			FBOutputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBIFDataConnection_4013,
					FBIFDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_FBFBDataConnection_4014(
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
					CakefeedElementTypes.FBFBDataConnection_4014,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_InputWith_4001(
			IFInputEvent target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getInputWith_ParentInputEvent()
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
	private static Collection getIncomingTypeModelFacetLinks_IFIFEventConnection_4007(
			IFOutputEvent target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getIFIFEventConnection_Destination()
					|| false == setting.getEObject() instanceof IFIFEventConnection) {
				continue;
			}
			IFIFEventConnection link = (IFIFEventConnection) setting
					.getEObject();
			if (IFIFEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFInputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.IFIFEventConnection_4007,
					IFIFEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_IFFBEventConnection_4008(
			FBInputEvent target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getIFFBEventConnection_Destination()
					|| false == setting.getEObject() instanceof IFFBEventConnection) {
				continue;
			}
			IFFBEventConnection link = (IFFBEventConnection) setting
					.getEObject();
			if (IFFBEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFInputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.IFFBEventConnection_4008,
					IFFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FBIFEventConnection_4009(
			IFOutputEvent target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getFBIFEventConnection_Destination()
					|| false == setting.getEObject() instanceof FBIFEventConnection) {
				continue;
			}
			FBIFEventConnection link = (FBIFEventConnection) setting
					.getEObject();
			if (FBIFEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBOutputEvent src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.FBIFEventConnection_4009,
					FBIFEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FBFBEventConnection_4010(
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
					CakefeedElementTypes.FBFBEventConnection_4010,
					FBFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_IFIFDataConnection_4011(
			IFOutputVar target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getIFIFDataConnection_Destination()
					|| false == setting.getEObject() instanceof IFIFDataConnection) {
				continue;
			}
			IFIFDataConnection link = (IFIFDataConnection) setting.getEObject();
			if (IFIFDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFInputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.IFIFDataConnection_4011,
					IFIFDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_IFFBDataConnection_4012(
			FBInputVar target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getIFFBDataConnection_Destination()
					|| false == setting.getEObject() instanceof IFFBDataConnection) {
				continue;
			}
			IFFBDataConnection link = (IFFBDataConnection) setting.getEObject();
			if (IFFBDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFInputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.IFFBDataConnection_4012,
					IFFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FBIFDataConnection_4013(
			IFOutputVar target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != CakefeedPackage.eINSTANCE
					.getFBIFDataConnection_Destination()
					|| false == setting.getEObject() instanceof FBIFDataConnection) {
				continue;
			}
			FBIFDataConnection link = (FBIFDataConnection) setting.getEObject();
			if (FBIFDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBOutputVar src = link.getSource();
			result.add(new CakefeedLinkDescriptor(src, target, link,
					CakefeedElementTypes.FBIFDataConnection_4013,
					FBIFDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_FBFBDataConnection_4014(
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
					CakefeedElementTypes.FBFBDataConnection_4014,
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
			IFInputEvent dst = link.getParentInputEvent();
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
	private static Collection getOutgoingTypeModelFacetLinks_IFIFEventConnection_4007(
			IFInputEvent source) {
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
			if (false == linkObject instanceof IFIFEventConnection) {
				continue;
			}
			IFIFEventConnection link = (IFIFEventConnection) linkObject;
			if (IFIFEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputEvent dst = link.getDestination();
			IFInputEvent src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFIFEventConnection_4007,
					IFIFEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_IFFBEventConnection_4008(
			IFInputEvent source) {
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
			if (false == linkObject instanceof IFFBEventConnection) {
				continue;
			}
			IFFBEventConnection link = (IFFBEventConnection) linkObject;
			if (IFFBEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputEvent dst = link.getDestination();
			IFInputEvent src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFFBEventConnection_4008,
					IFFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FBIFEventConnection_4009(
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
			if (false == linkObject instanceof FBIFEventConnection) {
				continue;
			}
			FBIFEventConnection link = (FBIFEventConnection) linkObject;
			if (FBIFEventConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputEvent dst = link.getDestination();
			FBOutputEvent src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBIFEventConnection_4009,
					FBIFEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FBFBEventConnection_4010(
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
					CakefeedElementTypes.FBFBEventConnection_4010,
					FBFBEventConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_IFIFDataConnection_4011(
			IFInputVar source) {
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
			if (false == linkObject instanceof IFIFDataConnection) {
				continue;
			}
			IFIFDataConnection link = (IFIFDataConnection) linkObject;
			if (IFIFDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputVar dst = link.getDestination();
			IFInputVar src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFIFDataConnection_4011,
					IFIFDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_IFFBDataConnection_4012(
			IFInputVar source) {
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
			if (false == linkObject instanceof IFFBDataConnection) {
				continue;
			}
			IFFBDataConnection link = (IFFBDataConnection) linkObject;
			if (IFFBDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FBInputVar dst = link.getDestination();
			IFInputVar src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.IFFBDataConnection_4012,
					IFFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FBIFDataConnection_4013(
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
			if (false == linkObject instanceof FBIFDataConnection) {
				continue;
			}
			FBIFDataConnection link = (FBIFDataConnection) linkObject;
			if (FBIFDataConnectionEditPart.VISUAL_ID != CakefeedVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			IFOutputVar dst = link.getDestination();
			FBOutputVar src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new CakefeedLinkDescriptor(src, dst, link,
					CakefeedElementTypes.FBIFDataConnection_4013,
					FBIFDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_FBFBDataConnection_4014(
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
					CakefeedElementTypes.FBFBDataConnection_4014,
					FBFBDataConnectionEditPart.VISUAL_ID));
		}
		return result;
	}

}
