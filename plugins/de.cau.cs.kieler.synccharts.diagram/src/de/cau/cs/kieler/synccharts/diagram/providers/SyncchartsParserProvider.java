package de.cau.cs.kieler.synccharts.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionTriggersAndEffects2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionTriggersAndEffects3EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionTriggersAndEffects4EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.ActionTriggersAndEffectsEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionIdEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.SignalNameEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateBodyText2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateBodyTextEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateInterfaceDeclaration2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateInterfaceDeclarationEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateLabel2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateLabelEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TransitionPriorityEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.TransitionTriggersAndEffectsEditPart;
import de.cau.cs.kieler.synccharts.diagram.parsers.MessageFormatParser;
import de.cau.cs.kieler.synccharts.diagram.part.SyncchartsVisualIDRegistry;

/**
 * @generated
 */
public class SyncchartsParserProvider extends AbstractProvider implements
        IParserProvider {

    /**
     * @generated
     */
    private IParser stateLabel_5008Parser;

    /**
     * @generated
     */
    private IParser getStateLabel_5008Parser() {
        if (stateLabel_5008Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getState_Label() };
            MessageFormatParser parser = new MessageFormatParser(features);
            stateLabel_5008Parser = parser;
        }
        return stateLabel_5008Parser;
    }

    /**
     * @generated
     */
    private IParser stateBodyText_5011Parser;

    /**
     * @generated
     */
    private IParser getStateBodyText_5011Parser() {
        if (stateBodyText_5011Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getState_BodyText() };
            MessageFormatParser parser = new MessageFormatParser(features);
            stateBodyText_5011Parser = parser;
        }
        return stateBodyText_5011Parser;
    }

    /**
     * @generated
     */
    private IParser stateInterfaceDeclaration_5013Parser;

    /**
     * @generated
     */
    private IParser getStateInterfaceDeclaration_5013Parser() {
        if (stateInterfaceDeclaration_5013Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getState_InterfaceDeclaration() };
            MessageFormatParser parser = new MessageFormatParser(features);
            stateInterfaceDeclaration_5013Parser = parser;
        }
        return stateInterfaceDeclaration_5013Parser;
    }

    /**
     * @generated
     */
    private IParser regionId_5009Parser;

    /**
     * @generated
     */
    private IParser getRegionId_5009Parser() {
        if (regionId_5009Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getRegion_Id() };
            EAttribute[] editableFeatures = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getRegion_Id() };
            MessageFormatParser parser = new MessageFormatParser(features,
                    editableFeatures);
            regionId_5009Parser = parser;
        }
        return regionId_5009Parser;
    }

    /**
     * @generated
     */
    private IParser stateLabel_5007Parser;

    /**
     * @generated
     */
    private IParser getStateLabel_5007Parser() {
        if (stateLabel_5007Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getState_Label() };
            MessageFormatParser parser = new MessageFormatParser(features);
            stateLabel_5007Parser = parser;
        }
        return stateLabel_5007Parser;
    }

    /**
     * @generated
     */
    private IParser stateBodyText_5010Parser;

    /**
     * @generated
     */
    private IParser getStateBodyText_5010Parser() {
        if (stateBodyText_5010Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getState_BodyText() };
            MessageFormatParser parser = new MessageFormatParser(features);
            stateBodyText_5010Parser = parser;
        }
        return stateBodyText_5010Parser;
    }

    /**
     * @generated
     */
    private IParser stateInterfaceDeclaration_5012Parser;

    /**
     * @generated
     */
    private IParser getStateInterfaceDeclaration_5012Parser() {
        if (stateInterfaceDeclaration_5012Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getState_InterfaceDeclaration() };
            MessageFormatParser parser = new MessageFormatParser(features);
            stateInterfaceDeclaration_5012Parser = parser;
        }
        return stateInterfaceDeclaration_5012Parser;
    }

    /**
     * @generated
     */
    private IParser signalName_5001Parser;

    /**
     * @generated
     */
    private IParser getSignalName_5001Parser() {
        if (signalName_5001Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getValuedObject_Name() };
            MessageFormatParser parser = new MessageFormatParser(features);
            parser.setViewPattern("{0},"); //$NON-NLS-1$
            parser.setEditorPattern("{0}"); //$NON-NLS-1$
            parser.setEditPattern("{0}"); //$NON-NLS-1$
            signalName_5001Parser = parser;
        }
        return signalName_5001Parser;
    }

    /**
     * @generated
     */
    private IParser actionTriggersAndEffects_5002Parser;

    /**
     * @generated
     */
    private IParser getActionTriggersAndEffects_5002Parser() {
        if (actionTriggersAndEffects_5002Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getAction_TriggersAndEffects() };
            MessageFormatParser parser = new MessageFormatParser(features);
            actionTriggersAndEffects_5002Parser = parser;
        }
        return actionTriggersAndEffects_5002Parser;
    }

    /**
     * @generated
     */
    private IParser actionTriggersAndEffects_5003Parser;

    /**
     * @generated
     */
    private IParser getActionTriggersAndEffects_5003Parser() {
        if (actionTriggersAndEffects_5003Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getAction_TriggersAndEffects() };
            MessageFormatParser parser = new MessageFormatParser(features);
            actionTriggersAndEffects_5003Parser = parser;
        }
        return actionTriggersAndEffects_5003Parser;
    }

    /**
     * @generated
     */
    private IParser actionTriggersAndEffects_5004Parser;

    /**
     * @generated
     */
    private IParser getActionTriggersAndEffects_5004Parser() {
        if (actionTriggersAndEffects_5004Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getAction_TriggersAndEffects() };
            MessageFormatParser parser = new MessageFormatParser(features);
            actionTriggersAndEffects_5004Parser = parser;
        }
        return actionTriggersAndEffects_5004Parser;
    }

    /**
     * @generated
     */
    private IParser actionTriggersAndEffects_5006Parser;

    /**
     * @generated
     */
    private IParser getActionTriggersAndEffects_5006Parser() {
        if (actionTriggersAndEffects_5006Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getAction_TriggersAndEffects() };
            MessageFormatParser parser = new MessageFormatParser(features);
            actionTriggersAndEffects_5006Parser = parser;
        }
        return actionTriggersAndEffects_5006Parser;
    }

    /**
     * @generated
     */
    private IParser transitionTriggersAndEffects_6001Parser;

    /**
     * @generated
     */
    private IParser getTransitionTriggersAndEffects_6001Parser() {
        if (transitionTriggersAndEffects_6001Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getAction_TriggersAndEffects() };
            MessageFormatParser parser = new MessageFormatParser(features);
            transitionTriggersAndEffects_6001Parser = parser;
        }
        return transitionTriggersAndEffects_6001Parser;
    }

    /**
     * @generated
     */
    private IParser transitionPriority_6002Parser;

    /**
     * @generated
     */
    private IParser getTransitionPriority_6002Parser() {
        if (transitionPriority_6002Parser == null) {
            EAttribute[] features = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getTransition_Priority() };
            EAttribute[] editableFeatures = new EAttribute[] { SyncchartsPackage.eINSTANCE
                    .getTransition_Priority() };
            MessageFormatParser parser = new MessageFormatParser(features,
                    editableFeatures);
            transitionPriority_6002Parser = parser;
        }
        return transitionPriority_6002Parser;
    }

    /**
     * @generated
     */
    protected IParser getParser(int visualID) {
        switch (visualID) {
        case StateLabelEditPart.VISUAL_ID:
            return getStateLabel_5008Parser();
        case StateBodyTextEditPart.VISUAL_ID:
            return getStateBodyText_5011Parser();
        case StateInterfaceDeclarationEditPart.VISUAL_ID:
            return getStateInterfaceDeclaration_5013Parser();
        case RegionIdEditPart.VISUAL_ID:
            return getRegionId_5009Parser();
        case StateLabel2EditPart.VISUAL_ID:
            return getStateLabel_5007Parser();
        case StateBodyText2EditPart.VISUAL_ID:
            return getStateBodyText_5010Parser();
        case StateInterfaceDeclaration2EditPart.VISUAL_ID:
            return getStateInterfaceDeclaration_5012Parser();
        case SignalNameEditPart.VISUAL_ID:
            return getSignalName_5001Parser();
        case ActionTriggersAndEffectsEditPart.VISUAL_ID:
            return getActionTriggersAndEffects_5002Parser();
        case ActionTriggersAndEffects2EditPart.VISUAL_ID:
            return getActionTriggersAndEffects_5003Parser();
        case ActionTriggersAndEffects3EditPart.VISUAL_ID:
            return getActionTriggersAndEffects_5004Parser();
        case ActionTriggersAndEffects4EditPart.VISUAL_ID:
            return getActionTriggersAndEffects_5006Parser();
        case TransitionTriggersAndEffectsEditPart.VISUAL_ID:
            return getTransitionTriggersAndEffects_6001Parser();
        case TransitionPriorityEditPart.VISUAL_ID:
            return getTransitionPriority_6002Parser();
        }
        return null;
    }

    /**
     * Utility method that consults ParserService
     * @generated
     */
    public static IParser getParser(IElementType type, EObject object,
            String parserHint) {
        return ParserService.getInstance().getParser(
                new HintAdapter(type, object, parserHint));
    }

    /**
     * @generated
     */
    public IParser getParser(IAdaptable hint) {
        String vid = (String) hint.getAdapter(String.class);
        if (vid != null) {
            return getParser(SyncchartsVisualIDRegistry.getVisualID(vid));
        }
        View view = (View) hint.getAdapter(View.class);
        if (view != null) {
            return getParser(SyncchartsVisualIDRegistry.getVisualID(view));
        }
        return null;
    }

    /**
     * @generated
     */
    public boolean provides(IOperation operation) {
        if (operation instanceof GetParserOperation) {
            IAdaptable hint = ((GetParserOperation) operation).getHint();
            if (SyncchartsElementTypes.getElement(hint) == null) {
                return false;
            }
            return getParser(hint) != null;
        }
        return false;
    }

    /**
     * @generated
     */
    private static class HintAdapter extends ParserHintAdapter {

        /**
         * @generated
         */
        private final IElementType elementType;

        /**
         * @generated
         */
        public HintAdapter(IElementType type, EObject object, String parserHint) {
            super(object, parserHint);
            assert type != null;
            elementType = type;
        }

        /**
         * @generated
         */
        public Object getAdapter(Class adapter) {
            if (IElementType.class.equals(adapter)) {
                return elementType;
            }
            return super.getAdapter(adapter);
        }
    }

}
