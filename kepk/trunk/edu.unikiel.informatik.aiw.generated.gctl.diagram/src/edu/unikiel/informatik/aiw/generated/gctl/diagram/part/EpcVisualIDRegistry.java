package edu.unikiel.informatik.aiw.generated.gctl.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EPCNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EventNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.FunctionNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLconnectorEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.ImplicationEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.InformationEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.InformationNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class EpcVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = GctlDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (GCTLEditPart.MODEL_ID.equals(view.getType())) {
				return GCTLEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry
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
				GctlDiagramEditorPlugin.getInstance().logError(
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
		if (EpcPackage.eINSTANCE.getEPC().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((edu.unikiel.informatik.aiw.generated.epc.EPC) domainElement)) {
			return GCTLEditPart.VISUAL_ID;
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
		String containerModelID = edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry
				.getModelID(containerView);
		if (!GCTLEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (GCTLEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = GCTLEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case GCTLEditPart.VISUAL_ID:
			if (EpcPackage.eINSTANCE.getFunction().isSuperTypeOf(
					domainElement.eClass())) {
				return FunctionEditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getEvent().isSuperTypeOf(
					domainElement.eClass())) {
				return EventEditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getInformation().isSuperTypeOf(
					domainElement.eClass())) {
				return InformationEditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getEPC().isSuperTypeOf(
					domainElement.eClass())) {
				return EPCEditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getImplication().isSuperTypeOf(
					domainElement.eClass())) {
				return ImplicationEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry
				.getModelID(containerView);
		if (!GCTLEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (GCTLEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = GCTLEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case FunctionEditPart.VISUAL_ID:
			if (FunctionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EventEditPart.VISUAL_ID:
			if (EventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InformationEditPart.VISUAL_ID:
			if (InformationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EPCEditPart.VISUAL_ID:
			if (EPCNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GCTLEditPart.VISUAL_ID:
			if (FunctionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InformationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EPCEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ImplicationEditPart.VISUAL_ID == nodeVisualID) {
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
		if (EpcPackage.eINSTANCE.getGCTLconnector().isSuperTypeOf(
				domainElement.eClass())) {
			return GCTLconnectorEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(
			edu.unikiel.informatik.aiw.generated.epc.EPC element) {
		return true;
	}

}
