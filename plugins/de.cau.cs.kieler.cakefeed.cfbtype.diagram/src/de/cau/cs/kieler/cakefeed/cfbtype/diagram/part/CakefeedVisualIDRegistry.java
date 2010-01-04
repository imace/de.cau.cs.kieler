package de.cau.cs.kieler.cakefeed.cfbtype.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.CFBDiagram;
import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeCFBTypeCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBCompartmentEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.OutputWithEditPart;

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
	private static final String DEBUG_KEY = "de.cau.cs.kieler.cakefeed.cfbtype.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (CFBDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return CFBDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry
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
		if (CakefeedPackage.eINSTANCE.getCFBDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((CFBDiagram) domainElement)) {
			return CFBDiagramEditPart.VISUAL_ID;
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
		String containerModelID = de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry
				.getModelID(containerView);
		if (!CFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (CFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CFBDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case CFBTypeCFBTypeCompartmentEditPart.VISUAL_ID:
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
			if (CakefeedPackage.eINSTANCE.getFB().isSuperTypeOf(
					domainElement.eClass())) {
				return FBEditPart.VISUAL_ID;
			}
			break;
		case FBFBCompartmentEditPart.VISUAL_ID:
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
		case CFBDiagramEditPart.VISUAL_ID:
			if (CakefeedPackage.eINSTANCE.getCFBType().isSuperTypeOf(
					domainElement.eClass())) {
				return CFBTypeEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry
				.getModelID(containerView);
		if (!CFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (CFBDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CFBDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case CFBTypeEditPart.VISUAL_ID:
			if (CFBTypeCFBTypeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
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
		case FBEditPart.VISUAL_ID:
			if (FBFBCompartmentEditPart.VISUAL_ID == nodeVisualID) {
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
		case CFBTypeCFBTypeCompartmentEditPart.VISUAL_ID:
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
			if (FBEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FBFBCompartmentEditPart.VISUAL_ID:
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
		case CFBDiagramEditPart.VISUAL_ID:
			if (CFBTypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if (CakefeedPackage.eINSTANCE.getIFIFEventConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return IFIFEventConnectionEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getIFFBEventConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return IFFBEventConnectionEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getFBIFEventConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return FBIFEventConnectionEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getFBFBEventConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return FBFBEventConnectionEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getIFIFDataConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return IFIFDataConnectionEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getIFFBDataConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return IFFBDataConnectionEditPart.VISUAL_ID;
		}
		if (CakefeedPackage.eINSTANCE.getFBIFDataConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return FBIFDataConnectionEditPart.VISUAL_ID;
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
	private static boolean isDiagram(CFBDiagram element) {
		return true;
	}

}
