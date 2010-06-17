package de.cau.cs.kieler.synccharts.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.expressions.ExpressionsPackage;
import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.Action2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.Action3EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.Action4EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionLabel2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionLabel3EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionLabel4EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionLabelEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.Region2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionLabelEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionStateCompartmentEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.SignalEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.SignalNameEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.State2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateInterfaceDeclaration2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateInterfaceDeclarationEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateLabel2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateLabelEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateRegionCompartment2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateRegionCompartmentEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState10EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState3EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState4EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState5EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState6EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState7EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState8EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateState9EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateStateEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TextualCodeEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TransitionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TransitionLabelEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TransitionPriorityEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class SyncchartsVisualIDRegistry {

    /**
     * @generated
     */
    private static final String DEBUG_KEY = "de.cau.cs.kieler.synccharts.diagram/debug/visualID"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static int getVisualID(View view) {
        if (view instanceof Diagram) {
            if (RegionEditPart.MODEL_ID.equals(view.getType())) {
                return RegionEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        return de.cau.cs.kieler.synccharts.diagram.part.SyncchartsVisualIDRegistry.getVisualID(view
                .getType());
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
            if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
                SyncchartsDiagramEditorPlugin.getInstance().logError(
                        "Unable to parse view type as a visualID number: " + type);
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
        if (SyncchartsPackage.eINSTANCE.getRegion().isSuperTypeOf(domainElement.eClass())
                && isDiagram((Region) domainElement)) {
            return RegionEditPart.VISUAL_ID;
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
        String containerModelID = de.cau.cs.kieler.synccharts.diagram.part.SyncchartsVisualIDRegistry
                .getModelID(containerView);
        if (!RegionEditPart.MODEL_ID.equals(containerModelID)) {
            return -1;
        }
        int containerVisualID;
        if (RegionEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.cau.cs.kieler.synccharts.diagram.part.SyncchartsVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = RegionEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        switch (containerVisualID) {
        case StateEditPart.VISUAL_ID:
            if (ExpressionsPackage.eINSTANCE.getTextualCode().isSuperTypeOf(domainElement.eClass())) {
                return TextualCodeEditPart.VISUAL_ID;
            }
            break;
        case State2EditPart.VISUAL_ID:
            if (ExpressionsPackage.eINSTANCE.getTextualCode().isSuperTypeOf(domainElement.eClass())) {
                return TextualCodeEditPart.VISUAL_ID;
            }
            break;
        case StateStateEditPart.VISUAL_ID:
            if (ExpressionsPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
                return SignalEditPart.VISUAL_ID;
            }
            break;
        case StateState2EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return ActionEditPart.VISUAL_ID;
            }
            break;
        case StateState3EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return Action2EditPart.VISUAL_ID;
            }
            break;
        case StateState4EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return Action3EditPart.VISUAL_ID;
            }
            break;
        case StateState5EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return Action4EditPart.VISUAL_ID;
            }
            break;
        case StateRegionCompartmentEditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getRegion().isSuperTypeOf(domainElement.eClass())) {
                return Region2EditPart.VISUAL_ID;
            }
            break;
        case RegionStateCompartmentEditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass())) {
                return State2EditPart.VISUAL_ID;
            }
            break;
        case StateState6EditPart.VISUAL_ID:
            if (ExpressionsPackage.eINSTANCE.getSignal().isSuperTypeOf(domainElement.eClass())) {
                return SignalEditPart.VISUAL_ID;
            }
            break;
        case StateState7EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return ActionEditPart.VISUAL_ID;
            }
            break;
        case StateState8EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return Action2EditPart.VISUAL_ID;
            }
            break;
        case StateState9EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return Action3EditPart.VISUAL_ID;
            }
            break;
        case StateState10EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getAction().isSuperTypeOf(domainElement.eClass())) {
                return Action4EditPart.VISUAL_ID;
            }
            break;
        case StateRegionCompartment2EditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getRegion().isSuperTypeOf(domainElement.eClass())) {
                return Region2EditPart.VISUAL_ID;
            }
            break;
        case RegionEditPart.VISUAL_ID:
            if (SyncchartsPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass())) {
                return StateEditPart.VISUAL_ID;
            }
            break;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static boolean canCreateNode(View containerView, int nodeVisualID) {
        String containerModelID = de.cau.cs.kieler.synccharts.diagram.part.SyncchartsVisualIDRegistry
                .getModelID(containerView);
        if (!RegionEditPart.MODEL_ID.equals(containerModelID)) {
            return false;
        }
        int containerVisualID;
        if (RegionEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.cau.cs.kieler.synccharts.diagram.part.SyncchartsVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = RegionEditPart.VISUAL_ID;
            } else {
                return false;
            }
        }
        switch (containerVisualID) {
        case StateEditPart.VISUAL_ID:
            if (StateLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateInterfaceDeclarationEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateStateEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState5EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateRegionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (TextualCodeEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case Region2EditPart.VISUAL_ID:
            if (RegionLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RegionStateCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case State2EditPart.VISUAL_ID:
            if (StateLabel2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateInterfaceDeclaration2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState6EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState7EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState8EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState9EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateState10EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StateRegionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (TextualCodeEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SignalEditPart.VISUAL_ID:
            if (SignalNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ActionEditPart.VISUAL_ID:
            if (ActionLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case Action2EditPart.VISUAL_ID:
            if (ActionLabel2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case Action3EditPart.VISUAL_ID:
            if (ActionLabel3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case Action4EditPart.VISUAL_ID:
            if (ActionLabel4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateStateEditPart.VISUAL_ID:
            if (SignalEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState2EditPart.VISUAL_ID:
            if (ActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState3EditPart.VISUAL_ID:
            if (Action2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState4EditPart.VISUAL_ID:
            if (Action3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState5EditPart.VISUAL_ID:
            if (Action4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateRegionCompartmentEditPart.VISUAL_ID:
            if (Region2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RegionStateCompartmentEditPart.VISUAL_ID:
            if (State2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState6EditPart.VISUAL_ID:
            if (SignalEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState7EditPart.VISUAL_ID:
            if (ActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState8EditPart.VISUAL_ID:
            if (Action2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState9EditPart.VISUAL_ID:
            if (Action3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateState10EditPart.VISUAL_ID:
            if (Action4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case StateRegionCompartment2EditPart.VISUAL_ID:
            if (Region2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RegionEditPart.VISUAL_ID:
            if (StateEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case TransitionEditPart.VISUAL_ID:
            if (TransitionLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (TransitionPriorityEditPart.VISUAL_ID == nodeVisualID) {
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
        if (SyncchartsPackage.eINSTANCE.getTransition().isSuperTypeOf(domainElement.eClass())) {
            return TransitionEditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * User can change implementation of this method to handle some specific
     * situations not covered by default logic.
     * 
     * @generated
     */
    private static boolean isDiagram(Region element) {
        return true;
    }

}
