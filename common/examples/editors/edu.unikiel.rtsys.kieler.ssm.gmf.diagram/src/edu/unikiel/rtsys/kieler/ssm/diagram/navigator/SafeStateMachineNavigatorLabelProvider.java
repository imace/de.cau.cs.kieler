package edu.unikiel.rtsys.kieler.ssm.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import edu.unikiel.rtsys.kieler.ssm.SafeStateMachine;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeState3EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateName2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateNameEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationPriorityEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.RegionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SafeStateMachineEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateNameEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortion2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionPriority2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionPriorityEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineDiagramEditorPlugin;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;
import edu.unikiel.rtsys.kieler.ssm.diagram.providers.SafeStateMachineElementTypes;
import edu.unikiel.rtsys.kieler.ssm.diagram.providers.SafeStateMachineParserProvider;

/**
 * @generated
 */
public class SafeStateMachineNavigatorLabelProvider extends LabelProvider
        implements ICommonLabelProvider, ITreePathLabelProvider {

    /**
     * @generated
     */
    static {
        SafeStateMachineDiagramEditorPlugin
                .getInstance()
                .getImageRegistry()
                .put(
                        "Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
        SafeStateMachineDiagramEditorPlugin
                .getInstance()
                .getImageRegistry()
                .put(
                        "Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    public void updateLabel(ViewerLabel label, TreePath elementPath) {
        Object element = elementPath.getLastSegment();
        if (element instanceof SafeStateMachineNavigatorItem
                && !isOwnView(((SafeStateMachineNavigatorItem) element)
                        .getView())) {
            return;
        }
        label.setText(getText(element));
        label.setImage(getImage(element));
    }

    /**
     * @generated
     */
    public Image getImage(Object element) {
        if (element instanceof SafeStateMachineNavigatorGroup) {
            SafeStateMachineNavigatorGroup group = (SafeStateMachineNavigatorGroup) element;
            return SafeStateMachineDiagramEditorPlugin.getInstance()
                    .getBundledImage(group.getIcon());
        }

        if (element instanceof SafeStateMachineNavigatorItem) {
            SafeStateMachineNavigatorItem navigatorItem = (SafeStateMachineNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return super.getImage(element);
            }
            return getImage(navigatorItem.getView());
        }

        return super.getImage(element);
    }

    /**
     * @generated
     */
    public Image getImage(View view) {
        switch (SafeStateMachineVisualIDRegistry.getVisualID(view)) {
        case SafeStateMachineEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Diagram?http://www.informatik.uni-kiel.de/rtsys/ssm?SafeStateMachine", SafeStateMachineElementTypes.SafeStateMachine_1000); //$NON-NLS-1$
        case CompositeStateEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://www.informatik.uni-kiel.de/rtsys/ssm?CompositeState", SafeStateMachineElementTypes.CompositeState_2001); //$NON-NLS-1$
        case RegionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://www.informatik.uni-kiel.de/rtsys/ssm?Region", SafeStateMachineElementTypes.Region_3001); //$NON-NLS-1$
        case CompositeState3EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://www.informatik.uni-kiel.de/rtsys/ssm?CompositeState", SafeStateMachineElementTypes.CompositeState_3002); //$NON-NLS-1$
        case SimpleStateEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://www.informatik.uni-kiel.de/rtsys/ssm?SimpleState", SafeStateMachineElementTypes.SimpleState_3003); //$NON-NLS-1$
        case CompositeState2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://www.informatik.uni-kiel.de/rtsys/ssm?InitialState", SafeStateMachineElementTypes.InitialState_3004); //$NON-NLS-1$
        case StrongAbortion2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://www.informatik.uni-kiel.de/rtsys/ssm?StrongAbortion", SafeStateMachineElementTypes.StrongAbortion_4001); //$NON-NLS-1$
        case StrongAbortionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://www.informatik.uni-kiel.de/rtsys/ssm?NormalTermination", SafeStateMachineElementTypes.NormalTermination_4002); //$NON-NLS-1$
        case NormalTerminationEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://www.informatik.uni-kiel.de/rtsys/ssm?WeakAbortion", SafeStateMachineElementTypes.WeakAbortion_4003); //$NON-NLS-1$
        }
        return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private Image getImage(String key, IElementType elementType) {
        ImageRegistry imageRegistry = SafeStateMachineDiagramEditorPlugin
                .getInstance().getImageRegistry();
        Image image = imageRegistry.get(key);
        if (image == null && elementType != null
                && SafeStateMachineElementTypes.isKnownElementType(elementType)) {
            image = SafeStateMachineElementTypes.getImage(elementType);
            imageRegistry.put(key, image);
        }

        if (image == null) {
            image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
            imageRegistry.put(key, image);
        }
        return image;
    }

    /**
     * @generated
     */
    public String getText(Object element) {
        if (element instanceof SafeStateMachineNavigatorGroup) {
            SafeStateMachineNavigatorGroup group = (SafeStateMachineNavigatorGroup) element;
            return group.getGroupName();
        }

        if (element instanceof SafeStateMachineNavigatorItem) {
            SafeStateMachineNavigatorItem navigatorItem = (SafeStateMachineNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return null;
            }
            return getText(navigatorItem.getView());
        }

        return super.getText(element);
    }

    /**
     * @generated
     */
    public String getText(View view) {
        if (view.getElement() != null && view.getElement().eIsProxy()) {
            return getUnresolvedDomainElementProxyText(view);
        }
        switch (SafeStateMachineVisualIDRegistry.getVisualID(view)) {
        case SafeStateMachineEditPart.VISUAL_ID:
            return getSafeStateMachine_1000Text(view);
        case CompositeStateEditPart.VISUAL_ID:
            return getCompositeState_2001Text(view);
        case RegionEditPart.VISUAL_ID:
            return getRegion_3001Text(view);
        case CompositeState3EditPart.VISUAL_ID:
            return getCompositeState_3002Text(view);
        case SimpleStateEditPart.VISUAL_ID:
            return getSimpleState_3003Text(view);
        case CompositeState2EditPart.VISUAL_ID:
            return getInitialState_3004Text(view);
        case StrongAbortion2EditPart.VISUAL_ID:
            return getStrongAbortion_4001Text(view);
        case StrongAbortionEditPart.VISUAL_ID:
            return getNormalTermination_4002Text(view);
        case NormalTerminationEditPart.VISUAL_ID:
            return getWeakAbortion_4003Text(view);
        }
        return getUnknownElementText(view);
    }

    /**
     * @generated
     */
    private String getSafeStateMachine_1000Text(View view) {
        SafeStateMachine domainModelElement = (SafeStateMachine) view
                .getElement();
        if (domainModelElement != null) {
            return domainModelElement.getName();
        } else {
            SafeStateMachineDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 1000); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * @generated
     */
    private String getCompositeState_2001Text(View view) {
        IAdaptable hintAdapter = new SafeStateMachineParserProvider.HintAdapter(
                SafeStateMachineElementTypes.CompositeState_2001, (view
                        .getElement() != null ? view.getElement() : view),
                SafeStateMachineVisualIDRegistry
                        .getType(CompositeStateNameEditPart.VISUAL_ID));
        IParser parser = ParserService.getInstance().getParser(hintAdapter);

        if (parser != null) {
            return parser.getPrintString(hintAdapter, ParserOptions.NONE
                    .intValue());
        } else {
            SafeStateMachineDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5003); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }

    }

    /**
     * @generated
     */
    private String getRegion_3001Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private String getCompositeState_3002Text(View view) {
        IAdaptable hintAdapter = new SafeStateMachineParserProvider.HintAdapter(
                SafeStateMachineElementTypes.CompositeState_3002, (view
                        .getElement() != null ? view.getElement() : view),
                SafeStateMachineVisualIDRegistry
                        .getType(CompositeStateName2EditPart.VISUAL_ID));
        IParser parser = ParserService.getInstance().getParser(hintAdapter);

        if (parser != null) {
            return parser.getPrintString(hintAdapter, ParserOptions.NONE
                    .intValue());
        } else {
            SafeStateMachineDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5001); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }

    }

    /**
     * @generated
     */
    private String getSimpleState_3003Text(View view) {
        IAdaptable hintAdapter = new SafeStateMachineParserProvider.HintAdapter(
                SafeStateMachineElementTypes.SimpleState_3003, (view
                        .getElement() != null ? view.getElement() : view),
                SafeStateMachineVisualIDRegistry
                        .getType(SimpleStateNameEditPart.VISUAL_ID));
        IParser parser = ParserService.getInstance().getParser(hintAdapter);

        if (parser != null) {
            return parser.getPrintString(hintAdapter, ParserOptions.NONE
                    .intValue());
        } else {
            SafeStateMachineDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5002); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }

    }

    /**
     * @generated
     */
    private String getInitialState_3004Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
     * @generated
     */
    private String getStrongAbortion_4001Text(View view) {
        IAdaptable hintAdapter = new SafeStateMachineParserProvider.HintAdapter(
                SafeStateMachineElementTypes.StrongAbortion_4001, (view
                        .getElement() != null ? view.getElement() : view),
                SafeStateMachineVisualIDRegistry
                        .getType(StrongAbortionPriority2EditPart.VISUAL_ID));
        IParser parser = ParserService.getInstance().getParser(hintAdapter);

        if (parser != null) {
            return parser.getPrintString(hintAdapter, ParserOptions.NONE
                    .intValue());
        } else {
            SafeStateMachineDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6001); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }

    }

    /**
     * @generated
     */
    private String getNormalTermination_4002Text(View view) {
        IAdaptable hintAdapter = new SafeStateMachineParserProvider.HintAdapter(
                SafeStateMachineElementTypes.NormalTermination_4002, (view
                        .getElement() != null ? view.getElement() : view),
                SafeStateMachineVisualIDRegistry
                        .getType(StrongAbortionPriorityEditPart.VISUAL_ID));
        IParser parser = ParserService.getInstance().getParser(hintAdapter);

        if (parser != null) {
            return parser.getPrintString(hintAdapter, ParserOptions.NONE
                    .intValue());
        } else {
            SafeStateMachineDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6003); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }

    }

    /**
     * @generated
     */
    private String getWeakAbortion_4003Text(View view) {
        IAdaptable hintAdapter = new SafeStateMachineParserProvider.HintAdapter(
                SafeStateMachineElementTypes.WeakAbortion_4003, (view
                        .getElement() != null ? view.getElement() : view),
                SafeStateMachineVisualIDRegistry
                        .getType(NormalTerminationPriorityEditPart.VISUAL_ID));
        IParser parser = ParserService.getInstance().getParser(hintAdapter);

        if (parser != null) {
            return parser.getPrintString(hintAdapter, ParserOptions.NONE
                    .intValue());
        } else {
            SafeStateMachineDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 6005); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }

    }

    /**
     * @generated
     */
    private String getUnknownElementText(View view) {
        return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * @generated
     */
    private String getUnresolvedDomainElementProxyText(View view) {
        return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * @generated
     */
    public void init(ICommonContentExtensionSite aConfig) {
    }

    /**
     * @generated
     */
    public void restoreState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public void saveState(IMemento aMemento) {
    }

    /**
     * @generated
     */
    public String getDescription(Object anElement) {
        return null;
    }

    /**
     * @generated
     */
    private boolean isOwnView(View view) {
        return SafeStateMachineEditPart.MODEL_ID
                .equals(SafeStateMachineVisualIDRegistry.getModelID(view));
    }

}
