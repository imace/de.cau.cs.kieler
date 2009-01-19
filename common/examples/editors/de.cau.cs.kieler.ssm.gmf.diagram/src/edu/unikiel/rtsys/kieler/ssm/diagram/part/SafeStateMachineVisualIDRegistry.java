package edu.unikiel.rtsys.kieler.ssm.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.rtsys.kieler.ssm.InitialState;
import edu.unikiel.rtsys.kieler.ssm.SafeStateMachine;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartment2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartmentEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateName2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateNameEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.InitialStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationEffectStringEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationPriorityEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionRegionCompartmentEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SafeStateMachineEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateNameEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionIsImmediateStringTriggeEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionPriorityEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.WeakAbortionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.WeakAbortionIsImmediateStringTriggeEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.WeakAbortionPriorityEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.expressions.SafeStateMachineAbstractExpression;
import edu.unikiel.rtsys.kieler.ssm.diagram.expressions.SafeStateMachineOCLFactory;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class SafeStateMachineVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.unikiel.rtsys.kieler.ssm.gmf.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static SafeStateMachineAbstractExpression SimpleState_3003_Constraint;

	/**
	 * @generated
	 */
	private static SafeStateMachineAbstractExpression InitialState_3004_Constraint;

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (SafeStateMachineEditPart.MODEL_ID.equals(view.getType())) {
				return SafeStateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry
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
				SafeStateMachineDiagramEditorPlugin.getInstance().logError(
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
		if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getSafeStateMachine().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((SafeStateMachine) domainElement)) {
			return SafeStateMachineEditPart.VISUAL_ID;
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
		String containerModelID = edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry
				.getModelID(containerView);
		if (!SafeStateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (SafeStateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SafeStateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
			if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE.getRegion()
					.isSuperTypeOf(domainElement.eClass())) {
				return RegionEditPart.VISUAL_ID;
			}
			break;
		case RegionRegionCompartmentEditPart.VISUAL_ID:
			if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
					.getCompositeState().isSuperTypeOf(domainElement.eClass())) {
				return CompositeState2EditPart.VISUAL_ID;
			}
			if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
					.getSimpleState().isSuperTypeOf(domainElement.eClass())
					&& isSimpleState_3003((SimpleState) domainElement)) {
				return SimpleStateEditPart.VISUAL_ID;
			}
			if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
					.getInitialState().isSuperTypeOf(domainElement.eClass())
					&& isInitialState_3004((InitialState) domainElement)) {
				return InitialStateEditPart.VISUAL_ID;
			}
			break;
		case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
			if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE.getRegion()
					.isSuperTypeOf(domainElement.eClass())) {
				return RegionEditPart.VISUAL_ID;
			}
			break;
		case SafeStateMachineEditPart.VISUAL_ID:
			if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
					.getCompositeState().isSuperTypeOf(domainElement.eClass())) {
				return CompositeStateEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry
				.getModelID(containerView);
		if (!SafeStateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (SafeStateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SafeStateMachineEditPart.VISUAL_ID;
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
		case RegionEditPart.VISUAL_ID:
			if (RegionRegionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompositeState2EditPart.VISUAL_ID:
			if (CompositeStateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SimpleStateEditPart.VISUAL_ID:
			if (SimpleStateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionRegionCompartmentEditPart.VISUAL_ID:
			if (CompositeState2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SimpleStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InitialStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SafeStateMachineEditPart.VISUAL_ID:
			if (CompositeStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StrongAbortionEditPart.VISUAL_ID:
			if (StrongAbortionIsImmediateStringTriggeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StrongAbortionPriorityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NormalTerminationEditPart.VISUAL_ID:
			if (NormalTerminationEffectStringEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NormalTerminationPriorityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case WeakAbortionEditPart.VISUAL_ID:
			if (WeakAbortionIsImmediateStringTriggeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WeakAbortionPriorityEditPart.VISUAL_ID == nodeVisualID) {
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
		if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getStrongAbortion().isSuperTypeOf(domainElement.eClass())) {
			return StrongAbortionEditPart.VISUAL_ID;
		}
		if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
				.getNormalTermination().isSuperTypeOf(domainElement.eClass())) {
			return NormalTerminationEditPart.VISUAL_ID;
		}
		if (edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE.getWeakAbortion()
				.isSuperTypeOf(domainElement.eClass())) {
			return WeakAbortionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(SafeStateMachine element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isSimpleState_3003(SimpleState domainElement) {
		if (SimpleState_3003_Constraint == null) { // lazy initialization
			SimpleState_3003_Constraint = SafeStateMachineOCLFactory
					.getExpression(
							"not self.oclIsTypeOf(ssm::CompositeState)", edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE.getSimpleState()); //$NON-NLS-1$
		}
		Object result = SimpleState_3003_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isInitialState_3004(InitialState domainElement) {
		if (InitialState_3004_Constraint == null) { // lazy initialization
			InitialState_3004_Constraint = SafeStateMachineOCLFactory
					.getExpression(
							"not self.oclIsTypeOf(ssm::CompositeState)", edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE.getInitialState()); //$NON-NLS-1$
		}
		Object result = InitialState_3004_Constraint.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
