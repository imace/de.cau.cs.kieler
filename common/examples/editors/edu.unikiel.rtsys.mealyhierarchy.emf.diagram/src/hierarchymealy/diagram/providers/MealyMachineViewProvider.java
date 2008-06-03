package hierarchymealy.diagram.providers;

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
import hierarchymealy.diagram.part.MealyMachineVisualIDRegistry;
import hierarchymealy.diagram.view.factories.CompositeState2ViewFactory;
import hierarchymealy.diagram.view.factories.CompositeStateCompositeStateCompartmentViewFactory;
import hierarchymealy.diagram.view.factories.CompositeStateName2ViewFactory;
import hierarchymealy.diagram.view.factories.CompositeStateNameViewFactory;
import hierarchymealy.diagram.view.factories.CompositeStateViewFactory;
import hierarchymealy.diagram.view.factories.EdgeTriggerActionViewFactory;
import hierarchymealy.diagram.view.factories.EdgeViewFactory;
import hierarchymealy.diagram.view.factories.HierarchyMealyMachineViewFactory;
import hierarchymealy.diagram.view.factories.State2ViewFactory;
import hierarchymealy.diagram.view.factories.StateName2ViewFactory;
import hierarchymealy.diagram.view.factories.StateNameViewFactory;
import hierarchymealy.diagram.view.factories.StateViewFactory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MealyMachineViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (HierarchyMealyMachineEditPart.MODEL_ID.equals(diagramKind)
				&& MealyMachineVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return HierarchyMealyMachineViewFactory.class;
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
			visualID = MealyMachineVisualIDRegistry.getNodeVisualID(
					containerView, domainElement);
		} else {
			visualID = MealyMachineVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!MealyMachineElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != MealyMachineVisualIDRegistry
								.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!HierarchyMealyMachineEditPart.MODEL_ID
						.equals(MealyMachineVisualIDRegistry
								.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case CompositeStateEditPart.VISUAL_ID:
				case StateEditPart.VISUAL_ID:
				case State2EditPart.VISUAL_ID:
				case CompositeState2EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != MealyMachineVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case CompositeStateNameEditPart.VISUAL_ID:
				case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
					if (CompositeStateEditPart.VISUAL_ID != MealyMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StateName2EditPart.VISUAL_ID:
					if (State2EditPart.VISUAL_ID != MealyMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StateNameEditPart.VISUAL_ID:
					if (StateEditPart.VISUAL_ID != MealyMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CompositeStateName2EditPart.VISUAL_ID:
					if (CompositeState2EditPart.VISUAL_ID != MealyMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EdgeTriggerActionEditPart.VISUAL_ID:
					if (EdgeEditPart.VISUAL_ID != MealyMachineVisualIDRegistry
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
				|| !MealyMachineVisualIDRegistry.canCreateNode(containerView,
						visualID)) {
			return null;
		}
		switch (visualID) {
		case CompositeStateEditPart.VISUAL_ID:
			return CompositeStateViewFactory.class;
		case CompositeStateNameEditPart.VISUAL_ID:
			return CompositeStateNameViewFactory.class;
		case State2EditPart.VISUAL_ID:
			return State2ViewFactory.class;
		case StateName2EditPart.VISUAL_ID:
			return StateName2ViewFactory.class;
		case StateEditPart.VISUAL_ID:
			return StateViewFactory.class;
		case StateNameEditPart.VISUAL_ID:
			return StateNameViewFactory.class;
		case CompositeState2EditPart.VISUAL_ID:
			return CompositeState2ViewFactory.class;
		case CompositeStateName2EditPart.VISUAL_ID:
			return CompositeStateName2ViewFactory.class;
		case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
			return CompositeStateCompositeStateCompartmentViewFactory.class;
		case EdgeTriggerActionEditPart.VISUAL_ID:
			return EdgeTriggerActionViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!MealyMachineElementTypes.isKnownElementType(elementType)
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
		int visualID = MealyMachineVisualIDRegistry
				.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != MealyMachineVisualIDRegistry
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
		case EdgeEditPart.VISUAL_ID:
			return EdgeViewFactory.class;
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
