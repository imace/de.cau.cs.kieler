package edu.unikiel.informatik.aiw.generated.epc.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

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
import edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.ANDViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.ActivatesFunctionViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.EPC2ViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.EPCNameViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.EPCViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.EventNameViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.EventToOperatorConnectionViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.EventViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.FunctionNameViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.FunctionToOperatorConnectionViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.FunctionViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.InformationNameViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.InformationViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.ORViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.OperatorToEventConnectionViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.OperatorToFunctionConnectionViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.ProvidesDataToViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.TriggersEventViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.WritesDataToViewFactory;
import edu.unikiel.informatik.aiw.generated.epc.diagram.view.factories.XORViewFactory;

/**
 * @generated
 */
public class EpcViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (EPCEditPart.MODEL_ID.equals(diagramKind)
				&& EpcVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return EPCViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = EpcVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = EpcVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!EpcElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != EpcVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!EPCEditPart.MODEL_ID.equals(EpcVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case ANDEditPart.VISUAL_ID:
				case OREditPart.VISUAL_ID:
				case InformationEditPart.VISUAL_ID:
				case XOREditPart.VISUAL_ID:
				case EventEditPart.VISUAL_ID:
				case FunctionEditPart.VISUAL_ID:
				case EPC2EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != EpcVisualIDRegistry.getNodeVisualID(
									containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case InformationNameEditPart.VISUAL_ID:
					if (InformationEditPart.VISUAL_ID != EpcVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EventNameEditPart.VISUAL_ID:
					if (EventEditPart.VISUAL_ID != EpcVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EPCNameEditPart.VISUAL_ID:
					if (EPC2EditPart.VISUAL_ID != EpcVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case FunctionNameEditPart.VISUAL_ID:
					if (FunctionEditPart.VISUAL_ID != EpcVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !EpcVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case ANDEditPart.VISUAL_ID:
			return ANDViewFactory.class;
		case OREditPart.VISUAL_ID:
			return ORViewFactory.class;
		case InformationEditPart.VISUAL_ID:
			return InformationViewFactory.class;
		case InformationNameEditPart.VISUAL_ID:
			return InformationNameViewFactory.class;
		case XOREditPart.VISUAL_ID:
			return XORViewFactory.class;
		case EventEditPart.VISUAL_ID:
			return EventViewFactory.class;
		case EventNameEditPart.VISUAL_ID:
			return EventNameViewFactory.class;
		case EPC2EditPart.VISUAL_ID:
			return EPC2ViewFactory.class;
		case EPCNameEditPart.VISUAL_ID:
			return EPCNameViewFactory.class;
		case FunctionEditPart.VISUAL_ID:
			return FunctionViewFactory.class;
		case FunctionNameEditPart.VISUAL_ID:
			return FunctionNameViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!EpcElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = EpcVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != EpcVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case TriggersEventEditPart.VISUAL_ID:
			return TriggersEventViewFactory.class;
		case ProvidesDataToEditPart.VISUAL_ID:
			return ProvidesDataToViewFactory.class;
		case WritesDataToEditPart.VISUAL_ID:
			return WritesDataToViewFactory.class;
		case ActivatesFunctionEditPart.VISUAL_ID:
			return ActivatesFunctionViewFactory.class;
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return EventToOperatorConnectionViewFactory.class;
		case FunctionToOperatorConnectionEditPart.VISUAL_ID:
			return FunctionToOperatorConnectionViewFactory.class;
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return OperatorToEventConnectionViewFactory.class;
		case OperatorToFunctionConnectionEditPart.VISUAL_ID:
			return OperatorToFunctionConnectionViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
