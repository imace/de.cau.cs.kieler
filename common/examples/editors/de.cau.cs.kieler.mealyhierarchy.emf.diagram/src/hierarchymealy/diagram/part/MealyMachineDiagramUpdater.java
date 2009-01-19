package hierarchymealy.diagram.part;

import hierarchymealy.CompositeState;
import hierarchymealy.Edge;
import hierarchymealy.HierarchyMealyMachine;
import hierarchymealy.MealyPackage;
import hierarchymealy.State;
import hierarchymealy.diagram.edit.parts.CompositeState2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateCompositeStateCompartment2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateCompositeStateCompartmentEditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateEditPart;
import hierarchymealy.diagram.edit.parts.EdgeEditPart;
import hierarchymealy.diagram.edit.parts.HierarchyMealyMachineEditPart;
import hierarchymealy.diagram.edit.parts.State2EditPart;
import hierarchymealy.diagram.edit.parts.StateEditPart;
import hierarchymealy.diagram.providers.MealyMachineElementTypes;

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

/**
 * @generated
 */
public class MealyMachineDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (MealyMachineVisualIDRegistry.getVisualID(view)) {
		case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
			return getCompositeStateCompositeStateCompartment_5001SemanticChildren(view);
		case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
			return getCompositeStateCompositeStateCompartment_5002SemanticChildren(view);
		case HierarchyMealyMachineEditPart.VISUAL_ID:
			return getHierarchyMealyMachine_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompositeStateCompositeStateCompartment_5001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CompositeState modelElement = (CompositeState) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = MealyMachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == State2EditPart.VISUAL_ID) {
				result.add(new MealyMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == CompositeState2EditPart.VISUAL_ID) {
				result.add(new MealyMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompositeStateCompositeStateCompartment_5002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		CompositeState modelElement = (CompositeState) containerView
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = MealyMachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == State2EditPart.VISUAL_ID) {
				result.add(new MealyMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == CompositeState2EditPart.VISUAL_ID) {
				result.add(new MealyMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getHierarchyMealyMachine_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		HierarchyMealyMachine modelElement = (HierarchyMealyMachine) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = MealyMachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CompositeStateEditPart.VISUAL_ID) {
				result.add(new MealyMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new MealyMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (MealyMachineVisualIDRegistry.getVisualID(view)) {
		case HierarchyMealyMachineEditPart.VISUAL_ID:
			return getHierarchyMealyMachine_79ContainedLinks(view);
		case CompositeStateEditPart.VISUAL_ID:
			return getCompositeState_1001ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_1002ContainedLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_2001ContainedLinks(view);
		case CompositeState2EditPart.VISUAL_ID:
			return getCompositeState_2002ContainedLinks(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_3001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (MealyMachineVisualIDRegistry.getVisualID(view)) {
		case CompositeStateEditPart.VISUAL_ID:
			return getCompositeState_1001IncomingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_1002IncomingLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_2001IncomingLinks(view);
		case CompositeState2EditPart.VISUAL_ID:
			return getCompositeState_2002IncomingLinks(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_3001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (MealyMachineVisualIDRegistry.getVisualID(view)) {
		case CompositeStateEditPart.VISUAL_ID:
			return getCompositeState_1001OutgoingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_1002OutgoingLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_2001OutgoingLinks(view);
		case CompositeState2EditPart.VISUAL_ID:
			return getCompositeState_2002OutgoingLinks(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_3001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getHierarchyMealyMachine_79ContainedLinks(View view) {
		HierarchyMealyMachine modelElement = (HierarchyMealyMachine) view
				.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompositeState_1001ContainedLinks(View view) {
		CompositeState modelElement = (CompositeState) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_1002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompositeState_2002ContainedLinks(View view) {
		CompositeState modelElement = (CompositeState) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEdge_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompositeState_1001IncomingLinks(View view) {
		CompositeState modelElement = (CompositeState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Edge_3001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_1002IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Edge_3001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2001IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Edge_3001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompositeState_2002IncomingLinks(View view) {
		CompositeState modelElement = (CompositeState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Edge_3001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEdge_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompositeState_1001OutgoingLinks(View view) {
		CompositeState modelElement = (CompositeState) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_1002OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2001OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCompositeState_2002OutgoingLinks(View view) {
		CompositeState modelElement = (CompositeState) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Edge_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEdge_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Edge_3001(
			CompositeState container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Edge) {
				continue;
			}
			Edge link = (Edge) linkObject;
			if (EdgeEditPart.VISUAL_ID != MealyMachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTargetNode();
			State src = link.getSourceNode();
			result
					.add(new MealyMachineLinkDescriptor(src, dst, link,
							MealyMachineElementTypes.Edge_3001,
							EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Edge_3001(
			State target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != MealyPackage.eINSTANCE
					.getEdge_TargetNode()
					|| false == setting.getEObject() instanceof Edge) {
				continue;
			}
			Edge link = (Edge) setting.getEObject();
			if (EdgeEditPart.VISUAL_ID != MealyMachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State src = link.getSourceNode();
			result
					.add(new MealyMachineLinkDescriptor(src, target, link,
							MealyMachineElementTypes.Edge_3001,
							EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Edge_3001(
			State source) {
		CompositeState container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof CompositeState) {
				container = (CompositeState) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Edge) {
				continue;
			}
			Edge link = (Edge) linkObject;
			if (EdgeEditPart.VISUAL_ID != MealyMachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getTargetNode();
			State src = link.getSourceNode();
			if (src != source) {
				continue;
			}
			result
					.add(new MealyMachineLinkDescriptor(src, dst, link,
							MealyMachineElementTypes.Edge_3001,
							EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

}
