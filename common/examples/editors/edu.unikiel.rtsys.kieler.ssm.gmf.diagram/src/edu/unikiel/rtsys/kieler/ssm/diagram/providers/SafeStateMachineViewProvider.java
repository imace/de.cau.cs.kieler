package edu.unikiel.rtsys.kieler.ssm.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

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
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.CompositeState2ViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.CompositeStateCompositeStateCompartment2ViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.CompositeStateCompositeStateCompartmentViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.CompositeStateName2ViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.CompositeStateNameViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.CompositeStateViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.InitialStateViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.NormalTerminationEffectStringViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.NormalTerminationPriorityViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.NormalTerminationViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.RegionRegionCompartmentViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.RegionViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.SafeStateMachineViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.SimpleStateNameViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.SimpleStateViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.StrongAbortionIsImmediateStringTriggeViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.StrongAbortionPriorityViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.StrongAbortionViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.WeakAbortionIsImmediateStringTriggeViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.WeakAbortionPriorityViewFactory;
import edu.unikiel.rtsys.kieler.ssm.diagram.view.factories.WeakAbortionViewFactory;

/**
 * @generated
 */
public class SafeStateMachineViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (SafeStateMachineEditPart.MODEL_ID.equals(diagramKind)
				&& SafeStateMachineVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return SafeStateMachineViewFactory.class;
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
			visualID = SafeStateMachineVisualIDRegistry.getNodeVisualID(
					containerView, domainElement);
		} else {
			visualID = SafeStateMachineVisualIDRegistry
					.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!SafeStateMachineElementTypes
						.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != SafeStateMachineVisualIDRegistry
								.getNodeVisualID(containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!SafeStateMachineEditPart.MODEL_ID
						.equals(SafeStateMachineVisualIDRegistry
								.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case CompositeStateEditPart.VISUAL_ID:
				case RegionEditPart.VISUAL_ID:
				case SimpleStateEditPart.VISUAL_ID:
				case InitialStateEditPart.VISUAL_ID:
				case CompositeState2EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != SafeStateMachineVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case CompositeStateNameEditPart.VISUAL_ID:
				case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
					if (CompositeStateEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case RegionRegionCompartmentEditPart.VISUAL_ID:
					if (RegionEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CompositeStateName2EditPart.VISUAL_ID:
				case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
					if (CompositeState2EditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SimpleStateNameEditPart.VISUAL_ID:
					if (SimpleStateEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StrongAbortionIsImmediateStringTriggeEditPart.VISUAL_ID:
				case StrongAbortionPriorityEditPart.VISUAL_ID:
					if (StrongAbortionEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case NormalTerminationEffectStringEditPart.VISUAL_ID:
				case NormalTerminationPriorityEditPart.VISUAL_ID:
					if (NormalTerminationEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case WeakAbortionIsImmediateStringTriggeEditPart.VISUAL_ID:
				case WeakAbortionPriorityEditPart.VISUAL_ID:
					if (WeakAbortionEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
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
				|| !SafeStateMachineVisualIDRegistry.canCreateNode(
						containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case CompositeStateEditPart.VISUAL_ID:
			return CompositeStateViewFactory.class;
		case CompositeStateNameEditPart.VISUAL_ID:
			return CompositeStateNameViewFactory.class;
		case RegionEditPart.VISUAL_ID:
			return RegionViewFactory.class;
		case CompositeState2EditPart.VISUAL_ID:
			return CompositeState2ViewFactory.class;
		case CompositeStateName2EditPart.VISUAL_ID:
			return CompositeStateName2ViewFactory.class;
		case SimpleStateEditPart.VISUAL_ID:
			return SimpleStateViewFactory.class;
		case SimpleStateNameEditPart.VISUAL_ID:
			return SimpleStateNameViewFactory.class;
		case InitialStateEditPart.VISUAL_ID:
			return InitialStateViewFactory.class;
		case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
			return CompositeStateCompositeStateCompartmentViewFactory.class;
		case RegionRegionCompartmentEditPart.VISUAL_ID:
			return RegionRegionCompartmentViewFactory.class;
		case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
			return CompositeStateCompositeStateCompartment2ViewFactory.class;
		case StrongAbortionIsImmediateStringTriggeEditPart.VISUAL_ID:
			return StrongAbortionIsImmediateStringTriggeViewFactory.class;
		case StrongAbortionPriorityEditPart.VISUAL_ID:
			return StrongAbortionPriorityViewFactory.class;
		case NormalTerminationEffectStringEditPart.VISUAL_ID:
			return NormalTerminationEffectStringViewFactory.class;
		case NormalTerminationPriorityEditPart.VISUAL_ID:
			return NormalTerminationPriorityViewFactory.class;
		case WeakAbortionIsImmediateStringTriggeEditPart.VISUAL_ID:
			return WeakAbortionIsImmediateStringTriggeViewFactory.class;
		case WeakAbortionPriorityEditPart.VISUAL_ID:
			return WeakAbortionPriorityViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!SafeStateMachineElementTypes.isKnownElementType(elementType)
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
		int visualID = SafeStateMachineVisualIDRegistry
				.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != SafeStateMachineVisualIDRegistry
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
		case StrongAbortionEditPart.VISUAL_ID:
			return StrongAbortionViewFactory.class;
		case NormalTerminationEditPart.VISUAL_ID:
			return NormalTerminationViewFactory.class;
		case WeakAbortionEditPart.VISUAL_ID:
			return WeakAbortionViewFactory.class;
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
