package de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.FBNetwork;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNetworkEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.WrappingLabelEditPart;

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
	private static final String DEBUG_KEY = "de.cau.cs.kieler.cakefeed.fbnetwork.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (FBNetworkEditPart.MODEL_ID.equals(view.getType())) {
				return FBNetworkEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry
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
		if (CakefeedPackage.eINSTANCE.getFBNetwork().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((FBNetwork) domainElement)) {
			return FBNetworkEditPart.VISUAL_ID;
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
		String containerModelID = de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry
				.getModelID(containerView);
		if (!FBNetworkEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (FBNetworkEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FBNetworkEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
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
		case FBNetworkEditPart.VISUAL_ID:
			if (CakefeedPackage.eINSTANCE.getFB().isSuperTypeOf(
					domainElement.eClass())) {
				return FBEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry
				.getModelID(containerView);
		if (!FBNetworkEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (FBNetworkEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FBNetworkEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
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
		case FBNetworkEditPart.VISUAL_ID:
			if (FBEditPart.VISUAL_ID == nodeVisualID) {
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
		if (CakefeedPackage.eINSTANCE.getFBFBEventConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return FBFBEventConnectionEditPart.VISUAL_ID;
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
	private static boolean isDiagram(FBNetwork element) {
		return true;
	}

}
