package ssm.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import ssm.State;
import ssm.Transition;
import ssm.diagram.edit.parts.State2EditPart;
import ssm.diagram.edit.parts.State3EditPart;
import ssm.diagram.edit.parts.StateEditPart;
import ssm.diagram.edit.parts.StateStateCompartment2EditPart;
import ssm.diagram.edit.parts.StateStateCompartmentEditPart;
import ssm.diagram.edit.parts.TransitionEditPart;
import ssm.diagram.providers.SsmElementTypes;

/**
 * @generated
 */
public class SsmDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (SsmVisualIDRegistry.getVisualID(view)) {
		case StateStateCompartmentEditPart.VISUAL_ID:
			return getStateStateCompartment_7001SemanticChildren(view);
		case StateStateCompartment2EditPart.VISUAL_ID:
			return getStateStateCompartment_7002SemanticChildren(view);
		case StateEditPart.VISUAL_ID:
			return getState_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStateStateCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getInnerStates().iterator(); it
				.hasNext();) {
			State childElement = (State) it.next();
			int visualID = SsmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == State3EditPart.VISUAL_ID) {
				result.add(new SsmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateStateCompartment_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getInnerStates().iterator(); it
				.hasNext();) {
			State childElement = (State) it.next();
			int visualID = SsmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == State3EditPart.VISUAL_ID) {
				result.add(new SsmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getInnerStates().iterator(); it
				.hasNext();) {
			State childElement = (State) it.next();
			int visualID = SsmVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == State2EditPart.VISUAL_ID) {
				result.add(new SsmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (SsmVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_1000ContainedLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_2002ContainedLinks(view);
		case State3EditPart.VISUAL_ID:
			return getState_3001ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4006ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (SsmVisualIDRegistry.getVisualID(view)) {
		case State2EditPart.VISUAL_ID:
			return getState_2002IncomingLinks(view);
		case State3EditPart.VISUAL_ID:
			return getState_3001IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4006IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (SsmVisualIDRegistry.getVisualID(view)) {
		case State2EditPart.VISUAL_ID:
			return getState_2002OutgoingLinks(view);
		case State3EditPart.VISUAL_ID:
			return getState_3001OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4006OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_1000ContainedLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2002ContainedLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_3001ContainedLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_2002IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4006(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_3001IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4006(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_2002OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_3001OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Transition_4006(
			State container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getOutgoingTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != SsmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTargetState();
			State src = link.getSourceState();
			result.add(new SsmLinkDescriptor(src, dst, link,
					SsmElementTypes.Transition_4006,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Transition_4006(
			State target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != ssm.ssmPackage.eINSTANCE
					.getTransition_TargetState()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != SsmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State src = link.getSourceState();
			result.add(new SsmLinkDescriptor(src, target, link,
					SsmElementTypes.Transition_4006,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Transition_4006(
			State source) {
		State container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof State) {
				container = (State) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getOutgoingTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != SsmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTargetState();
			State src = link.getSourceState();
			if (src != source) {
				continue;
			}
			result.add(new SsmLinkDescriptor(src, dst, link,
					SsmElementTypes.Transition_4006,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

}
