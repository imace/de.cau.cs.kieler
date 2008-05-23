package edu.unikiel.informatik.aiw.generated.epc.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ANDEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ActivatesFunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPC2EditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPCNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.InformationEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.InformationNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OREditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToEventConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToFunctionConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ProvidesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.TriggersEventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.WritesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.XOREditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.expressions.EpcAbstractExpression;

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
	private static final String DEBUG_KEY = EpcDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (EPCEditPart.MODEL_ID.equals(view.getType())) {
				return EPCEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry
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
				EpcDiagramEditorPlugin.getInstance().logError(
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
			return EPCEditPart.VISUAL_ID;
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
		String containerModelID = edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry
				.getModelID(containerView);
		if (!EPCEditPart.MODEL_ID.equals(containerModelID)
				&& !"Epc".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (EPCEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EPCEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case EPCEditPart.VISUAL_ID:
			if (EpcPackage.eINSTANCE.getAND().isSuperTypeOf(
					domainElement.eClass())) {
				return ANDEditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getOR().isSuperTypeOf(
					domainElement.eClass())) {
				return OREditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getInformation().isSuperTypeOf(
					domainElement.eClass())) {
				return InformationEditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getXOR().isSuperTypeOf(
					domainElement.eClass())) {
				return XOREditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getEvent().isSuperTypeOf(
					domainElement.eClass())) {
				return EventEditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getEPC().isSuperTypeOf(
					domainElement.eClass())) {
				return EPC2EditPart.VISUAL_ID;
			}
			if (EpcPackage.eINSTANCE.getFunction().isSuperTypeOf(
					domainElement.eClass())) {
				return FunctionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry
				.getModelID(containerView);
		if (!EPCEditPart.MODEL_ID.equals(containerModelID)
				&& !"Epc".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (EPCEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EPCEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case InformationEditPart.VISUAL_ID:
			if (InformationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EventEditPart.VISUAL_ID:
			if (EventNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EPC2EditPart.VISUAL_ID:
			if (EPCNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FunctionEditPart.VISUAL_ID:
			if (FunctionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EPCEditPart.VISUAL_ID:
			if (ANDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InformationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XOREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EPC2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FunctionEditPart.VISUAL_ID == nodeVisualID) {
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
		if (EpcPackage.eINSTANCE.getTriggersEvent().isSuperTypeOf(
				domainElement.eClass())) {
			return TriggersEventEditPart.VISUAL_ID;
		}
		if (EpcPackage.eINSTANCE.getProvidesDataTo().isSuperTypeOf(
				domainElement.eClass())) {
			return ProvidesDataToEditPart.VISUAL_ID;
		}
		if (EpcPackage.eINSTANCE.getWritesDataTo().isSuperTypeOf(
				domainElement.eClass())) {
			return WritesDataToEditPart.VISUAL_ID;
		}
		if (EpcPackage.eINSTANCE.getActivatesFunction().isSuperTypeOf(
				domainElement.eClass())) {
			return ActivatesFunctionEditPart.VISUAL_ID;
		}
		if (EpcPackage.eINSTANCE.getEventToOperatorConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return EventToOperatorConnectionEditPart.VISUAL_ID;
		}
		if (EpcPackage.eINSTANCE.getFunctionToOperatorConnection()
				.isSuperTypeOf(domainElement.eClass())) {
			return FunctionToOperatorConnectionEditPart.VISUAL_ID;
		}
		if (EpcPackage.eINSTANCE.getOperatorToEventConnection().isSuperTypeOf(
				domainElement.eClass())) {
			return OperatorToEventConnectionEditPart.VISUAL_ID;
		}
		if (EpcPackage.eINSTANCE.getOperatorToFunctionConnection()
				.isSuperTypeOf(domainElement.eClass())) {
			return OperatorToFunctionConnectionEditPart.VISUAL_ID;
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

	/**
	 * @generated
	 */
	private static boolean evaluate(EpcAbstractExpression expression,
			Object element) {
		Object result = expression.evaluate(element);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
