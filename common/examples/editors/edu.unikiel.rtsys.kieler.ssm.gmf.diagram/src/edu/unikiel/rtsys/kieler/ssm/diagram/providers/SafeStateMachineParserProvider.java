package edu.unikiel.rtsys.kieler.ssm.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateName2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.CompositeStateNameEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationEffectStringEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.NormalTerminationPriorityEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.SimpleStateNameEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionIsImmediateStringTrigge2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionIsImmediateStringTriggeEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionPriority2EditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.edit.parts.StrongAbortionPriorityEditPart;
import edu.unikiel.rtsys.kieler.ssm.diagram.parsers.MessageFormatParser;
import edu.unikiel.rtsys.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;

/**
 * @generated
 */
public class SafeStateMachineParserProvider extends AbstractProvider implements
        IParserProvider {

    /**
     * @generated
     */
    private IParser compositeStateName_5003Parser;

    /**
     * @generated
     */
    private IParser getCompositeStateName_5003Parser() {
        if (compositeStateName_5003Parser == null) {
            compositeStateName_5003Parser = createCompositeStateName_5003Parser();
        }
        return compositeStateName_5003Parser;
    }

    /**
     * @generated
     */
    protected IParser createCompositeStateName_5003Parser() {
        EAttribute[] features = new EAttribute[] { edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                .getNamed_Name(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        return parser;
    }

    /**
     * @generated
     */
    private IParser compositeStateName_5001Parser;

    /**
     * @generated
     */
    private IParser getCompositeStateName_5001Parser() {
        if (compositeStateName_5001Parser == null) {
            compositeStateName_5001Parser = createCompositeStateName_5001Parser();
        }
        return compositeStateName_5001Parser;
    }

    /**
     * @generated
     */
    protected IParser createCompositeStateName_5001Parser() {
        EAttribute[] features = new EAttribute[] { edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                .getNamed_Name(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        return parser;
    }

    /**
     * @generated
     */
    private IParser simpleStateName_5002Parser;

    /**
     * @generated
     */
    private IParser getSimpleStateName_5002Parser() {
        if (simpleStateName_5002Parser == null) {
            simpleStateName_5002Parser = createSimpleStateName_5002Parser();
        }
        return simpleStateName_5002Parser;
    }

    /**
     * @generated
     */
    protected IParser createSimpleStateName_5002Parser() {
        EAttribute[] features = new EAttribute[] { edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                .getNamed_Name(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        return parser;
    }

    /**
     * @generated
     */
    private IParser strongAbortionPriority_6001Parser;

    /**
     * @generated
     */
    private IParser getStrongAbortionPriority_6001Parser() {
        if (strongAbortionPriority_6001Parser == null) {
            strongAbortionPriority_6001Parser = createStrongAbortionPriority_6001Parser();
        }
        return strongAbortionPriority_6001Parser;
    }

    /**
     * @generated
     */
    protected IParser createStrongAbortionPriority_6001Parser() {
        EAttribute[] features = new EAttribute[] { edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                .getTransition_Priority(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        return parser;
    }

    /**
     * @generated
     */
    private IParser strongAbortionIsImmediateStringTriggerStringEffectString_6002Parser;

    /**
     * @generated
     */
    private IParser getStrongAbortionIsImmediateStringTriggerStringEffectString_6002Parser() {
        if (strongAbortionIsImmediateStringTriggerStringEffectString_6002Parser == null) {
            strongAbortionIsImmediateStringTriggerStringEffectString_6002Parser = createStrongAbortionIsImmediateStringTriggerStringEffectString_6002Parser();
        }
        return strongAbortionIsImmediateStringTriggerStringEffectString_6002Parser;
    }

    /**
     * @generated
     */
    protected IParser createStrongAbortionIsImmediateStringTriggerStringEffectString_6002Parser() {
        EAttribute[] features = new EAttribute[] {
                edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                        .getTransitionImmediateable_IsImmediateString(),
                edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                        .getTransitionTriggerable_TriggerString(),
                edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                        .getTransition_EffectString(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        parser.setViewPattern("{0} {1}/{2}");
        parser.setEditorPattern("{0} {1}/{2}");
        parser.setEditPattern("{0} {1}/{2}");
        return parser;
    }

    /**
     * @generated
     */
    private IParser normalTerminationPriority_6003Parser;

    /**
     * @generated
     */
    private IParser getNormalTerminationPriority_6003Parser() {
        if (normalTerminationPriority_6003Parser == null) {
            normalTerminationPriority_6003Parser = createNormalTerminationPriority_6003Parser();
        }
        return normalTerminationPriority_6003Parser;
    }

    /**
     * @generated
     */
    protected IParser createNormalTerminationPriority_6003Parser() {
        EAttribute[] features = new EAttribute[] { edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                .getTransition_Priority(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        return parser;
    }

    /**
     * @generated
     */
    private IParser normalTerminationEffectString_6004Parser;

    /**
     * @generated
     */
    private IParser getNormalTerminationEffectString_6004Parser() {
        if (normalTerminationEffectString_6004Parser == null) {
            normalTerminationEffectString_6004Parser = createNormalTerminationEffectString_6004Parser();
        }
        return normalTerminationEffectString_6004Parser;
    }

    /**
     * @generated
     */
    protected IParser createNormalTerminationEffectString_6004Parser() {
        EAttribute[] features = new EAttribute[] { edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                .getTransition_EffectString(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        parser.setViewPattern("/{0}");
        parser.setEditorPattern("/{0}");
        parser.setEditPattern("/{0}");
        return parser;
    }

    /**
     * @generated
     */
    private IParser weakAbortionPriority_6005Parser;

    /**
     * @generated
     */
    private IParser getWeakAbortionPriority_6005Parser() {
        if (weakAbortionPriority_6005Parser == null) {
            weakAbortionPriority_6005Parser = createWeakAbortionPriority_6005Parser();
        }
        return weakAbortionPriority_6005Parser;
    }

    /**
     * @generated
     */
    protected IParser createWeakAbortionPriority_6005Parser() {
        EAttribute[] features = new EAttribute[] { edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                .getTransition_Priority(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        return parser;
    }

    /**
     * @generated
     */
    private IParser weakAbortionIsImmediateStringTriggerStringEffectString_6006Parser;

    /**
     * @generated
     */
    private IParser getWeakAbortionIsImmediateStringTriggerStringEffectString_6006Parser() {
        if (weakAbortionIsImmediateStringTriggerStringEffectString_6006Parser == null) {
            weakAbortionIsImmediateStringTriggerStringEffectString_6006Parser = createWeakAbortionIsImmediateStringTriggerStringEffectString_6006Parser();
        }
        return weakAbortionIsImmediateStringTriggerStringEffectString_6006Parser;
    }

    /**
     * @generated
     */
    protected IParser createWeakAbortionIsImmediateStringTriggerStringEffectString_6006Parser() {
        EAttribute[] features = new EAttribute[] {
                edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                        .getTransitionImmediateable_IsImmediateString(),
                edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                        .getTransitionTriggerable_TriggerString(),
                edu.unikiel.rtsys.kieler.ssm.ssmPackage.eINSTANCE
                        .getTransition_EffectString(), };
        MessageFormatParser parser = new MessageFormatParser(features);
        parser.setViewPattern("{0} {1}/{2}");
        parser.setEditorPattern("{0} {1}/{2}");
        parser.setEditPattern("{0} {1}/{2}");
        return parser;
    }

    /**
     * @generated
     */
    protected IParser getParser(int visualID) {
        switch (visualID) {
        case CompositeStateNameEditPart.VISUAL_ID:
            return getCompositeStateName_5003Parser();
        case CompositeStateName2EditPart.VISUAL_ID:
            return getCompositeStateName_5001Parser();
        case SimpleStateNameEditPart.VISUAL_ID:
            return getSimpleStateName_5002Parser();
        case StrongAbortionPriority2EditPart.VISUAL_ID:
            return getStrongAbortionPriority_6001Parser();
        case StrongAbortionIsImmediateStringTrigge2EditPart.VISUAL_ID:
            return getStrongAbortionIsImmediateStringTriggerStringEffectString_6002Parser();
        case StrongAbortionPriorityEditPart.VISUAL_ID:
            return getNormalTerminationPriority_6003Parser();
        case StrongAbortionIsImmediateStringTriggeEditPart.VISUAL_ID:
            return getNormalTerminationEffectString_6004Parser();
        case NormalTerminationPriorityEditPart.VISUAL_ID:
            return getWeakAbortionPriority_6005Parser();
        case NormalTerminationEffectStringEditPart.VISUAL_ID:
            return getWeakAbortionIsImmediateStringTriggerStringEffectString_6006Parser();
        }
        return null;
    }

    /**
     * @generated
     */
    public IParser getParser(IAdaptable hint) {
        String vid = (String) hint.getAdapter(String.class);
        if (vid != null) {
            return getParser(SafeStateMachineVisualIDRegistry.getVisualID(vid));
        }
        View view = (View) hint.getAdapter(View.class);
        if (view != null) {
            return getParser(SafeStateMachineVisualIDRegistry.getVisualID(view));
        }
        return null;
    }

    /**
     * @generated
     */
    public boolean provides(IOperation operation) {
        if (operation instanceof GetParserOperation) {
            IAdaptable hint = ((GetParserOperation) operation).getHint();
            if (SafeStateMachineElementTypes.getElement(hint) == null) {
                return false;
            }
            return getParser(hint) != null;
        }
        return false;
    }

    /**
     * @generated
     */
    public static class HintAdapter extends ParserHintAdapter {

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
