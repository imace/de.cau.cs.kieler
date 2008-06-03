package hierarchymealy.diagram.part;

import hierarchymealy.HierarchyMealyMachine;
import hierarchymealy.MealyPackage;
import hierarchymealy.diagram.edit.parts.CompositeState2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateCompositeStateCompartmentEditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateEditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateName2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateNameEditPart;
import hierarchymealy.diagram.edit.parts.EdgeEditPart;
import hierarchymealy.diagram.edit.parts.EdgeTriggerActionEditPart;
import hierarchymealy.diagram.edit.parts.HierarchyMealyMachineEditPart;
import hierarchymealy.diagram.edit.parts.State2EditPart;
import hierarchymealy.diagram.edit.parts.StateEditPart;
import hierarchymealy.diagram.edit.parts.StateName2EditPart;
import hierarchymealy.diagram.edit.parts.StateNameEditPart;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class MealyMachineVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.unikiel.rtsys.mealyhierarchy.emf.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (HierarchyMealyMachineEditPart.MODEL_ID.equals(view.getType())) {
				return HierarchyMealyMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return hierarchymealy.diagram.part.MealyMachineVisualIDRegistry
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
				MealyMachineDiagramEditorPlugin.getInstance().logError(
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
		if (MealyPackage.eINSTANCE.getHierarchyMealyMachine().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((HierarchyMealyMachine) domainElement)) {
			return HierarchyMealyMachineEditPart.VISUAL_ID;
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
		String containerModelID = hierarchymealy.diagram.part.MealyMachineVisualIDRegistry
				.getModelID(containerView);
		if (!HierarchyMealyMachineEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (HierarchyMealyMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = hierarchymealy.diagram.part.MealyMachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = HierarchyMealyMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
			if (MealyPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			if (MealyPackage.eINSTANCE.getCompositeState().isSuperTypeOf(
					domainElement.eClass())) {
				return CompositeState2EditPart.VISUAL_ID;
			}
			break;
		case HierarchyMealyMachineEditPart.VISUAL_ID:
			if (MealyPackage.eINSTANCE.getCompositeState().isSuperTypeOf(
					domainElement.eClass())) {
				return CompositeStateEditPart.VISUAL_ID;
			}
			if (MealyPackage.eINSTANCE.getState().isSuperTypeOf(
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
		String containerModelID = hierarchymealy.diagram.part.MealyMachineVisualIDRegistry
				.getModelID(containerView);
		if (!HierarchyMealyMachineEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (HierarchyMealyMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = hierarchymealy.diagram.part.MealyMachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = HierarchyMealyMachineEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case CompositeStateEditPart.VISUAL_ID:
			if (CompositeStateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State2EditPart.VISUAL_ID:
			if (StateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompositeState2EditPart.VISUAL_ID:
			if (CompositeStateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompositeState2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case HierarchyMealyMachineEditPart.VISUAL_ID:
			if (CompositeStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EdgeEditPart.VISUAL_ID:
			if (EdgeTriggerActionEditPart.VISUAL_ID == nodeVisualID) {
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
		if (MealyPackage.eINSTANCE.getEdge().isSuperTypeOf(
				domainElement.eClass())) {
			return EdgeEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(HierarchyMealyMachine element) {
		return true;
	}

}
