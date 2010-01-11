package de.cau.cs.kieler.cakefeed.bfbtype.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.BFBDiagram;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeBFBTypeCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDFBDCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class CakefeedVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "de.cau.cs.kieler.cakefeed.bfbtype.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (BFBDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return BFBDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				CakefeedDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (CakefeedPackage.eINSTANCE.getBFBDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((BFBDiagram) domainElement)) {
			return BFBDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry
				.getModelID(containerView);
		if (!BFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (BFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = BFBDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case BFBTypeEditPart.VISUAL_ID:
			if (CakefeedPackage.eINSTANCE.getIFInputEvent().isSuperTypeOf(
					domainElement.eClass())) {
				return IFInputEventEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getIFOutputEvent().isSuperTypeOf(
					domainElement.eClass())) {
				return IFOutputEventEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getIFInputVar().isSuperTypeOf(
					domainElement.eClass())) {
				return IFInputVarEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getIFOutputVar().isSuperTypeOf(
					domainElement.eClass())) {
				return IFOutputVarEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getInternalVar().isSuperTypeOf(
					domainElement.eClass())) {
				return InternalVarEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getFBD().isSuperTypeOf(
					domainElement.eClass())) {
				return FBDEditPart.VISUAL_ID;
			}
			break;
		case FBEditPart.VISUAL_ID:
			if (CakefeedPackage.eINSTANCE.getFBInputEvent().isSuperTypeOf(
					domainElement.eClass())) {
				return FBInputEventEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getFBOutputEvent().isSuperTypeOf(
					domainElement.eClass())) {
				return FBOutputEventEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getFBInputVar().isSuperTypeOf(
					domainElement.eClass())) {
				return FBInputVarEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getFBOutputVar().isSuperTypeOf(
					domainElement.eClass())) {
				return FBOutputVarEditPart.VISUAL_ID;
			}
			break;
		case BFBTypeBFBTypeCompartmentEditPart.VISUAL_ID:
			if (CakefeedPackage.eINSTANCE.getST().isSuperTypeOf(
					domainElement.eClass())) {
				return STEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getLD().isSuperTypeOf(
					domainElement.eClass())) {
				return LDEditPart.VISUAL_ID;
			}
			if (CakefeedPackage.eINSTANCE.getOther().isSuperTypeOf(
					domainElement.eClass())) {
				return OtherEditPart.VISUAL_ID;
			}
			break;
		case FBDFBDCompartmentEditPart.VISUAL_ID:
			if (CakefeedPackage.eINSTANCE.getFB().isSuperTypeOf(
					domainElement.eClass())) {
				return FBEditPart.VISUAL_ID;
			}
			break;
		case BFBDiagramEditPart.VISUAL_ID:
			if (CakefeedPackage.eINSTANCE.getBFBType().isSuperTypeOf(
					domainElement.eClass())) {
				return BFBTypeEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry
				.getModelID(containerView);
		if (!BFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (BFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = BFBDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case BFBTypeEditPart.VISUAL_ID:
			if (BFBTypeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BFBTypeBFBTypeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IFInputEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IFOutputEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IFInputVarEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IFOutputVarEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InternalVarEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FBDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IFInputEventEditPart.VISUAL_ID:
			if (IFInputEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IFOutputEventEditPart.VISUAL_ID:
			if (IFOutputEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IFInputVarEditPart.VISUAL_ID:
			if (IFInputVarNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IFOutputVarEditPart.VISUAL_ID:
			if (IFOutputVarNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InternalVarEditPart.VISUAL_ID:
			if (InternalVarNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBDEditPart.VISUAL_ID:
			if (FBDFBDCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBEditPart.VISUAL_ID:
			if (FBNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FBInputEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FBOutputEventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FBInputVarEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FBOutputVarEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBInputEventEditPart.VISUAL_ID:
			if (FBInputEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBOutputEventEditPart.VISUAL_ID:
			if (FBOutputEventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBInputVarEditPart.VISUAL_ID:
			if (FBInputVarNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBOutputVarEditPart.VISUAL_ID:
			if (FBOutputVarNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case STEditPart.VISUAL_ID:
			if (STNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LDEditPart.VISUAL_ID:
			if (LDNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OtherEditPart.VISUAL_ID:
			if (OtherNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BFBTypeBFBTypeCompartmentEditPart.VISUAL_ID:
			if (STEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OtherEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBDFBDCompartmentEditPart.VISUAL_ID:
			if (FBEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BFBDiagramEditPart.VISUAL_ID:
			if (BFBTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (CakefeedPackage.eINSTANCE.getInputWith().isSuperTypeOf(
				domainElement.eClass())) {
			return InputWithEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getOutputWith().isSuperTypeOf(
				domainElement.eClass())) {
			return OutputWithEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getFBFBDataConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return FBFBDataConnectionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(BFBDiagram element) {
		return true;
	}

}
