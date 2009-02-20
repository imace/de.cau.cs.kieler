package ssm.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import ssm.State;
import ssm.diagram.edit.parts.State2EditPart;
import ssm.diagram.edit.parts.State3EditPart;
import ssm.diagram.edit.parts.StateEditPart;
import ssm.diagram.edit.parts.StateName2EditPart;
import ssm.diagram.edit.parts.StateNameEditPart;
import ssm.diagram.edit.parts.StateStateCompartment2EditPart;
import ssm.diagram.edit.parts.StateStateCompartmentEditPart;
import ssm.diagram.edit.parts.StateStateFlag2EditPart;
import ssm.diagram.edit.parts.StateStateFlagEditPart;
import ssm.diagram.edit.parts.StateStateKind2EditPart;
import ssm.diagram.edit.parts.StateStateKindEditPart;
import ssm.diagram.edit.parts.TransitionDelayEditPart;
import ssm.diagram.edit.parts.TransitionEditPart;
import ssm.diagram.edit.parts.TransitionImmediateEditPart;
import ssm.diagram.edit.parts.TransitionPriorityEditPart;
import ssm.diagram.edit.parts.TransitionTransitionKindEditPart;
import ssm.diagram.edit.parts.TransitionTriggersAndEffectsEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class SsmVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "de.cau.cs.kieler.ssm2.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (StateEditPart.MODEL_ID.equals(view.getType())) {
				return StateEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return ssm.diagram.part.SsmVisualIDRegistry.getVisualID(view.getType());
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
				SsmDiagramEditorPlugin.getInstance().logError(
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
		if (ssm.ssmPackage.eINSTANCE.getState().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((State) domainElement)) {
			return StateEditPart.VISUAL_ID;
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
		String containerModelID = ssm.diagram.part.SsmVisualIDRegistry
				.getModelID(containerView);
		if (!StateEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (StateEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ssm.diagram.part.SsmVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case StateStateCompartmentEditPart.VISUAL_ID:
			if (ssm.ssmPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return State3EditPart.VISUAL_ID;
			}
			break;
		case StateStateCompartment2EditPart.VISUAL_ID:
			if (ssm.ssmPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return State3EditPart.VISUAL_ID;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (ssm.ssmPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return State2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = ssm.diagram.part.SsmVisualIDRegistry
				.getModelID(containerView);
		if (!StateEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (StateEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ssm.diagram.part.SsmVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case State2EditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateStateCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State3EditPart.VISUAL_ID:
			if (StateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateStateCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateStateCompartmentEditPart.VISUAL_ID:
			if (State3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateStateCompartment2EditPart.VISUAL_ID:
			if (State3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionDelayEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionImmediateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionPriorityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionTransitionKindEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionTriggersAndEffectsEditPart.VISUAL_ID == nodeVisualID) {
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
		if (ssm.ssmPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())) {
			return TransitionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(State element) {
		return true;
	}

}
