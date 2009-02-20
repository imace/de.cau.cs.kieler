package ssm.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

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
import ssm.diagram.part.SsmVisualIDRegistry;
import ssm.diagram.view.factories.State2ViewFactory;
import ssm.diagram.view.factories.State3ViewFactory;
import ssm.diagram.view.factories.StateName2ViewFactory;
import ssm.diagram.view.factories.StateNameViewFactory;
import ssm.diagram.view.factories.StateStateCompartment2ViewFactory;
import ssm.diagram.view.factories.StateStateCompartmentViewFactory;
import ssm.diagram.view.factories.StateStateFlag2ViewFactory;
import ssm.diagram.view.factories.StateStateFlagViewFactory;
import ssm.diagram.view.factories.StateStateKind2ViewFactory;
import ssm.diagram.view.factories.StateStateKindViewFactory;
import ssm.diagram.view.factories.StateViewFactory;
import ssm.diagram.view.factories.TransitionDelayViewFactory;
import ssm.diagram.view.factories.TransitionImmediateViewFactory;
import ssm.diagram.view.factories.TransitionPriorityViewFactory;
import ssm.diagram.view.factories.TransitionTransitionKindViewFactory;
import ssm.diagram.view.factories.TransitionTriggersAndEffectsViewFactory;
import ssm.diagram.view.factories.TransitionViewFactory;

/**
 * @generated
 */
public class SsmViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (StateEditPart.MODEL_ID.equals(diagramKind)
				&& SsmVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return StateViewFactory.class;
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
			visualID = SsmVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = SsmVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!SsmElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != SsmVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!StateEditPart.MODEL_ID.equals(SsmVisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case State2EditPart.VISUAL_ID:
				case State3EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != SsmVisualIDRegistry.getNodeVisualID(
									containerView, domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case StateNameEditPart.VISUAL_ID:
				case StateStateCompartmentEditPart.VISUAL_ID:
					if (State2EditPart.VISUAL_ID != SsmVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StateName2EditPart.VISUAL_ID:
				case StateStateCompartment2EditPart.VISUAL_ID:
					if (State3EditPart.VISUAL_ID != SsmVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case TransitionDelayEditPart.VISUAL_ID:
				case TransitionImmediateEditPart.VISUAL_ID:
				case TransitionPriorityEditPart.VISUAL_ID:
				case TransitionTransitionKindEditPart.VISUAL_ID:
				case TransitionTriggersAndEffectsEditPart.VISUAL_ID:
					if (TransitionEditPart.VISUAL_ID != SsmVisualIDRegistry
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
				|| !SsmVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case State2EditPart.VISUAL_ID:
			return State2ViewFactory.class;
		case StateNameEditPart.VISUAL_ID:
			return StateNameViewFactory.class;
		case State3EditPart.VISUAL_ID:
			return State3ViewFactory.class;
		case StateName2EditPart.VISUAL_ID:
			return StateName2ViewFactory.class;
		case StateStateCompartmentEditPart.VISUAL_ID:
			return StateStateCompartmentViewFactory.class;
		case StateStateCompartment2EditPart.VISUAL_ID:
			return StateStateCompartment2ViewFactory.class;
		case TransitionDelayEditPart.VISUAL_ID:
			return TransitionDelayViewFactory.class;
		case TransitionImmediateEditPart.VISUAL_ID:
			return TransitionImmediateViewFactory.class;
		case TransitionPriorityEditPart.VISUAL_ID:
			return TransitionPriorityViewFactory.class;
		case TransitionTransitionKindEditPart.VISUAL_ID:
			return TransitionTransitionKindViewFactory.class;
		case TransitionTriggersAndEffectsEditPart.VISUAL_ID:
			return TransitionTriggersAndEffectsViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!SsmElementTypes.isKnownElementType(elementType)
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
		int visualID = SsmVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != SsmVisualIDRegistry
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
		case TransitionEditPart.VISUAL_ID:
			return TransitionViewFactory.class;
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
