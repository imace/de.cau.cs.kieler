package edu.unikiel.rtsys.kieler.ssm.diagram.part;

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

import edu.unikiel.rtsys.kieler.ssm.AbstractState;
import edu.unikiel.rtsys.kieler.ssm.CompositeState;
import edu.unikiel.rtsys.kieler.ssm.InitialState;
import edu.unikiel.rtsys.kieler.ssm.NormalTermination;
import edu.unikiel.rtsys.kieler.ssm.Region;
import edu.unikiel.rtsys.kieler.ssm.SafeStateMachine;
import edu.unikiel.rtsys.kieler.ssm.SimpleState;
import edu.unikiel.rtsys.kieler.ssm.StrongAbortion;
import edu.unikiel.rtsys.kieler.ssm.WeakAbortion;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState3EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartment2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateCompositeStateCompartmentEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionRegionCompartmentEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SafeStateMachineEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortion2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;

/**
 * @generated
 */
public class SafeStateMachineDiagramUpdater {

    /**
     * @generated
     */
    public static List getSemanticChildren(View view) {
        switch (SafeStateMachineVisualIDRegistry.getVisualID(view)) {
        case CompositeStateCompositeStateCompartmentEditPart.VISUAL_ID:
            return getCompositeStateCompositeStateCompartment_7001SemanticChildren(view);
        case RegionRegionCompartmentEditPart.VISUAL_ID:
            return getRegionRegionCompartment_7002SemanticChildren(view);
        case CompositeStateCompositeStateCompartment2EditPart.VISUAL_ID:
            return getCompositeStateCompositeStateCompartment_7003SemanticChildren(view);
        case SafeStateMachineEditPart.VISUAL_ID:
            return getSafeStateMachine_1000SemanticChildren(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getCompositeStateCompositeStateCompartment_7001SemanticChildren(
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
        for (Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
            Region childElement = (Region) it.next();
            int visualID = SafeStateMachineVisualIDRegistry.getNodeVisualID(
                    view, childElement);
            if (visualID == RegionEditPart.VISUAL_ID) {
                result.add(new SafeStateMachineNodeDescriptor(childElement,
                        visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getRegionRegionCompartment_7002SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        Region modelElement = (Region) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getStates().iterator(); it.hasNext();) {
            AbstractState childElement = (AbstractState) it.next();
            int visualID = SafeStateMachineVisualIDRegistry.getNodeVisualID(
                    view, childElement);
            if (visualID == CompositeState3EditPart.VISUAL_ID) {
                result.add(new SafeStateMachineNodeDescriptor(childElement,
                        visualID));
                continue;
            }
            if (visualID == SimpleStateEditPart.VISUAL_ID) {
                result.add(new SafeStateMachineNodeDescriptor(childElement,
                        visualID));
                continue;
            }
            if (visualID == CompositeState2EditPart.VISUAL_ID) {
                result.add(new SafeStateMachineNodeDescriptor(childElement,
                        visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getCompositeStateCompositeStateCompartment_7003SemanticChildren(
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
        for (Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
            Region childElement = (Region) it.next();
            int visualID = SafeStateMachineVisualIDRegistry.getNodeVisualID(
                    view, childElement);
            if (visualID == RegionEditPart.VISUAL_ID) {
                result.add(new SafeStateMachineNodeDescriptor(childElement,
                        visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getSafeStateMachine_1000SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        SafeStateMachine modelElement = (SafeStateMachine) view.getElement();
        List result = new LinkedList();
        {
            CompositeState childElement = modelElement.getTop();
            int visualID = SafeStateMachineVisualIDRegistry.getNodeVisualID(
                    view, childElement);
            if (visualID == CompositeStateEditPart.VISUAL_ID) {
                result.add(new SafeStateMachineNodeDescriptor(childElement,
                        visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getContainedLinks(View view) {
        switch (SafeStateMachineVisualIDRegistry.getVisualID(view)) {
        case SafeStateMachineEditPart.VISUAL_ID:
            return getSafeStateMachine_1000ContainedLinks(view);
        case CompositeStateEditPart.VISUAL_ID:
            return getCompositeState_2001ContainedLinks(view);
        case RegionEditPart.VISUAL_ID:
            return getRegion_3001ContainedLinks(view);
        case CompositeState3EditPart.VISUAL_ID:
            return getCompositeState_3002ContainedLinks(view);
        case SimpleStateEditPart.VISUAL_ID:
            return getSimpleState_3003ContainedLinks(view);
        case CompositeState2EditPart.VISUAL_ID:
            return getInitialState_3004ContainedLinks(view);
        case StrongAbortion2EditPart.VISUAL_ID:
            return getStrongAbortion_4001ContainedLinks(view);
        case StrongAbortionEditPart.VISUAL_ID:
            return getNormalTermination_4002ContainedLinks(view);
        case NormalTerminationEditPart.VISUAL_ID:
            return getWeakAbortion_4003ContainedLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getIncomingLinks(View view) {
        switch (SafeStateMachineVisualIDRegistry.getVisualID(view)) {
        case CompositeStateEditPart.VISUAL_ID:
            return getCompositeState_2001IncomingLinks(view);
        case RegionEditPart.VISUAL_ID:
            return getRegion_3001IncomingLinks(view);
        case CompositeState3EditPart.VISUAL_ID:
            return getCompositeState_3002IncomingLinks(view);
        case SimpleStateEditPart.VISUAL_ID:
            return getSimpleState_3003IncomingLinks(view);
        case CompositeState2EditPart.VISUAL_ID:
            return getInitialState_3004IncomingLinks(view);
        case StrongAbortion2EditPart.VISUAL_ID:
            return getStrongAbortion_4001IncomingLinks(view);
        case StrongAbortionEditPart.VISUAL_ID:
            return getNormalTermination_4002IncomingLinks(view);
        case NormalTerminationEditPart.VISUAL_ID:
            return getWeakAbortion_4003IncomingLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getOutgoingLinks(View view) {
        switch (SafeStateMachineVisualIDRegistry.getVisualID(view)) {
        case CompositeStateEditPart.VISUAL_ID:
            return getCompositeState_2001OutgoingLinks(view);
        case RegionEditPart.VISUAL_ID:
            return getRegion_3001OutgoingLinks(view);
        case CompositeState3EditPart.VISUAL_ID:
            return getCompositeState_3002OutgoingLinks(view);
        case SimpleStateEditPart.VISUAL_ID:
            return getSimpleState_3003OutgoingLinks(view);
        case CompositeState2EditPart.VISUAL_ID:
            return getInitialState_3004OutgoingLinks(view);
        case StrongAbortion2EditPart.VISUAL_ID:
            return getStrongAbortion_4001OutgoingLinks(view);
        case StrongAbortionEditPart.VISUAL_ID:
            return getNormalTermination_4002OutgoingLinks(view);
        case NormalTerminationEditPart.VISUAL_ID:
            return getWeakAbortion_4003OutgoingLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getSafeStateMachine_1000ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getCompositeState_2001ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getRegion_3001ContainedLinks(View view) {
        Region modelElement = (Region) view.getElement();
        List result = new LinkedList();
        result
                .addAll(getContainedTypeModelFacetLinks_StrongAbortion_4001(modelElement));
        result
                .addAll(getContainedTypeModelFacetLinks_NormalTermination_4002(modelElement));
        result
                .addAll(getContainedTypeModelFacetLinks_WeakAbortion_4003(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getCompositeState_3002ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getSimpleState_3003ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getInitialState_3004ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getStrongAbortion_4001ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getNormalTermination_4002ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getWeakAbortion_4003ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getCompositeState_2001IncomingLinks(View view) {
        CompositeState modelElement = (CompositeState) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
                .getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingTypeModelFacetLinks_StrongAbortion_4001(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_NormalTermination_4002(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_WeakAbortion_4003(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getRegion_3001IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getCompositeState_3002IncomingLinks(View view) {
        CompositeState modelElement = (CompositeState) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
                .getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingTypeModelFacetLinks_StrongAbortion_4001(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_NormalTermination_4002(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_WeakAbortion_4003(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getSimpleState_3003IncomingLinks(View view) {
        SimpleState modelElement = (SimpleState) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
                .getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingTypeModelFacetLinks_StrongAbortion_4001(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_NormalTermination_4002(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_WeakAbortion_4003(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getInitialState_3004IncomingLinks(View view) {
        InitialState modelElement = (InitialState) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
                .getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingTypeModelFacetLinks_StrongAbortion_4001(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_NormalTermination_4002(
                modelElement, crossReferences));
        result.addAll(getIncomingTypeModelFacetLinks_WeakAbortion_4003(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getStrongAbortion_4001IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getNormalTermination_4002IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getWeakAbortion_4003IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getCompositeState_2001OutgoingLinks(View view) {
        CompositeState modelElement = (CompositeState) view.getElement();
        List result = new LinkedList();
        result
                .addAll(getOutgoingTypeModelFacetLinks_StrongAbortion_4001(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_NormalTermination_4002(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_WeakAbortion_4003(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getRegion_3001OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getCompositeState_3002OutgoingLinks(View view) {
        CompositeState modelElement = (CompositeState) view.getElement();
        List result = new LinkedList();
        result
                .addAll(getOutgoingTypeModelFacetLinks_StrongAbortion_4001(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_NormalTermination_4002(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_WeakAbortion_4003(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getSimpleState_3003OutgoingLinks(View view) {
        SimpleState modelElement = (SimpleState) view.getElement();
        List result = new LinkedList();
        result
                .addAll(getOutgoingTypeModelFacetLinks_StrongAbortion_4001(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_NormalTermination_4002(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_WeakAbortion_4003(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getInitialState_3004OutgoingLinks(View view) {
        InitialState modelElement = (InitialState) view.getElement();
        List result = new LinkedList();
        result
                .addAll(getOutgoingTypeModelFacetLinks_StrongAbortion_4001(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_NormalTermination_4002(modelElement));
        result
                .addAll(getOutgoingTypeModelFacetLinks_WeakAbortion_4003(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getStrongAbortion_4001OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getNormalTermination_4002OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getWeakAbortion_4003OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    private static Collection getContainedTypeModelFacetLinks_StrongAbortion_4001(
            Region container) {
        Collection result = new LinkedList();
        for (Iterator links = container.getTransitions().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof StrongAbortion) {
                continue;
            }
            StrongAbortion link = (StrongAbortion) linkObject;
            if (StrongAbortion2EditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState dst = link.getTarget();
            AbstractState src = link.getSource();
            result.add(new SafeStateMachineLinkDescriptor(src, dst, link,
                    SafeStateMachineElementTypes.StrongAbortion_4001,
                    StrongAbortion2EditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getContainedTypeModelFacetLinks_NormalTermination_4002(
            Region container) {
        Collection result = new LinkedList();
        for (Iterator links = container.getTransitions().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof NormalTermination) {
                continue;
            }
            NormalTermination link = (NormalTermination) linkObject;
            if (StrongAbortionEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState dst = link.getTarget();
            AbstractState src = link.getSource();
            result.add(new SafeStateMachineLinkDescriptor(src, dst, link,
                    SafeStateMachineElementTypes.NormalTermination_4002,
                    StrongAbortionEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getContainedTypeModelFacetLinks_WeakAbortion_4003(
            Region container) {
        Collection result = new LinkedList();
        for (Iterator links = container.getTransitions().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof WeakAbortion) {
                continue;
            }
            WeakAbortion link = (WeakAbortion) linkObject;
            if (NormalTerminationEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState dst = link.getTarget();
            AbstractState src = link.getSource();
            result.add(new SafeStateMachineLinkDescriptor(src, dst, link,
                    SafeStateMachineElementTypes.WeakAbortion_4003,
                    NormalTerminationEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getIncomingTypeModelFacetLinks_StrongAbortion_4001(
            AbstractState target, Map crossReferences) {
        Collection result = new LinkedList();
        Collection settings = (Collection) crossReferences.get(target);
        for (Iterator it = settings.iterator(); it.hasNext();) {
            EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
                    .next();
            if (setting.getEStructuralFeature() != edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                    .getTransition_Target()
                    || false == setting.getEObject() instanceof StrongAbortion) {
                continue;
            }
            StrongAbortion link = (StrongAbortion) setting.getEObject();
            if (StrongAbortion2EditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState src = link.getSource();
            result.add(new SafeStateMachineLinkDescriptor(src, target, link,
                    SafeStateMachineElementTypes.StrongAbortion_4001,
                    StrongAbortion2EditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getIncomingTypeModelFacetLinks_NormalTermination_4002(
            AbstractState target, Map crossReferences) {
        Collection result = new LinkedList();
        Collection settings = (Collection) crossReferences.get(target);
        for (Iterator it = settings.iterator(); it.hasNext();) {
            EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
                    .next();
            if (setting.getEStructuralFeature() != edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                    .getTransition_Target()
                    || false == setting.getEObject() instanceof NormalTermination) {
                continue;
            }
            NormalTermination link = (NormalTermination) setting.getEObject();
            if (StrongAbortionEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState src = link.getSource();
            result.add(new SafeStateMachineLinkDescriptor(src, target, link,
                    SafeStateMachineElementTypes.NormalTermination_4002,
                    StrongAbortionEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getIncomingTypeModelFacetLinks_WeakAbortion_4003(
            AbstractState target, Map crossReferences) {
        Collection result = new LinkedList();
        Collection settings = (Collection) crossReferences.get(target);
        for (Iterator it = settings.iterator(); it.hasNext();) {
            EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
                    .next();
            if (setting.getEStructuralFeature() != edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                    .getTransition_Target()
                    || false == setting.getEObject() instanceof WeakAbortion) {
                continue;
            }
            WeakAbortion link = (WeakAbortion) setting.getEObject();
            if (NormalTerminationEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState src = link.getSource();
            result.add(new SafeStateMachineLinkDescriptor(src, target, link,
                    SafeStateMachineElementTypes.WeakAbortion_4003,
                    NormalTerminationEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getOutgoingTypeModelFacetLinks_StrongAbortion_4001(
            AbstractState source) {
        Region container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element
                .eContainer()) {
            if (element instanceof Region) {
                container = (Region) element;
            }
        }
        if (container == null) {
            return Collections.EMPTY_LIST;
        }
        Collection result = new LinkedList();
        for (Iterator links = container.getTransitions().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof StrongAbortion) {
                continue;
            }
            StrongAbortion link = (StrongAbortion) linkObject;
            if (StrongAbortion2EditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState dst = link.getTarget();
            AbstractState src = link.getSource();
            if (src != source) {
                continue;
            }
            result.add(new SafeStateMachineLinkDescriptor(src, dst, link,
                    SafeStateMachineElementTypes.StrongAbortion_4001,
                    StrongAbortion2EditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getOutgoingTypeModelFacetLinks_NormalTermination_4002(
            AbstractState source) {
        Region container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element
                .eContainer()) {
            if (element instanceof Region) {
                container = (Region) element;
            }
        }
        if (container == null) {
            return Collections.EMPTY_LIST;
        }
        Collection result = new LinkedList();
        for (Iterator links = container.getTransitions().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof NormalTermination) {
                continue;
            }
            NormalTermination link = (NormalTermination) linkObject;
            if (StrongAbortionEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState dst = link.getTarget();
            AbstractState src = link.getSource();
            if (src != source) {
                continue;
            }
            result.add(new SafeStateMachineLinkDescriptor(src, dst, link,
                    SafeStateMachineElementTypes.NormalTermination_4002,
                    StrongAbortionEditPart.VISUAL_ID));
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getOutgoingTypeModelFacetLinks_WeakAbortion_4003(
            AbstractState source) {
        Region container = null;
        // Find container element for the link.
        // Climb up by containment hierarchy starting from the source
        // and return the first element that is instance of the container class.
        for (EObject element = source; element != null && container == null; element = element
                .eContainer()) {
            if (element instanceof Region) {
                container = (Region) element;
            }
        }
        if (container == null) {
            return Collections.EMPTY_LIST;
        }
        Collection result = new LinkedList();
        for (Iterator links = container.getTransitions().iterator(); links
                .hasNext();) {
            EObject linkObject = (EObject) links.next();
            if (false == linkObject instanceof WeakAbortion) {
                continue;
            }
            WeakAbortion link = (WeakAbortion) linkObject;
            if (NormalTerminationEditPart.VISUAL_ID != SafeStateMachineVisualIDRegistry
                    .getLinkWithClassVisualID(link)) {
                continue;
            }
            AbstractState dst = link.getTarget();
            AbstractState src = link.getSource();
            if (src != source) {
                continue;
            }
            result.add(new SafeStateMachineLinkDescriptor(src, dst, link,
                    SafeStateMachineElementTypes.WeakAbortion_4003,
                    NormalTerminationEditPart.VISUAL_ID));
        }
        return result;
    }

}
