package ssm.diagram.providers;

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

import ssm.diagram.edit.parts.StateName2EditPart;
import ssm.diagram.edit.parts.StateNameEditPart;
import ssm.diagram.edit.parts.StateStateFlag2EditPart;
import ssm.diagram.edit.parts.StateStateFlagEditPart;
import ssm.diagram.edit.parts.StateStateKind2EditPart;
import ssm.diagram.edit.parts.StateStateKindEditPart;
import ssm.diagram.edit.parts.TransitionDelayEditPart;
import ssm.diagram.edit.parts.TransitionImmediateEditPart;
import ssm.diagram.edit.parts.TransitionPriorityEditPart;
import ssm.diagram.edit.parts.TransitionTransitionKindEditPart;
import ssm.diagram.edit.parts.TransitionTriggersAndEffectsEditPart;
import ssm.diagram.parsers.MessageFormatParser;
import ssm.diagram.part.SsmVisualIDRegistry;

/**
 * @generated
 */
public class SsmParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser stateName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5001Parser() {
		if (stateName_5001Parser == null) {
			stateName_5001Parser = createStateName_5001Parser();
		}
		return stateName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_5001Parser() {
		EAttribute[] features = new EAttribute[] { ssm.ssmPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5004Parser() {
		if (stateName_5004Parser == null) {
			stateName_5004Parser = createStateName_5004Parser();
		}
		return stateName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_5004Parser() {
		EAttribute[] features = new EAttribute[] { ssm.ssmPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionDelay_6005Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionDelay_6005Parser() {
		if (transitionDelay_6005Parser == null) {
			transitionDelay_6005Parser = createTransitionDelay_6005Parser();
		}
		return transitionDelay_6005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionDelay_6005Parser() {
		EAttribute[] features = new EAttribute[] { ssm.ssmPackage.eINSTANCE
				.getTransition_Delay(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionImmediate_6006Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionImmediate_6006Parser() {
		if (transitionImmediate_6006Parser == null) {
			transitionImmediate_6006Parser = createTransitionImmediate_6006Parser();
		}
		return transitionImmediate_6006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionImmediate_6006Parser() {
		EAttribute[] features = new EAttribute[] { ssm.ssmPackage.eINSTANCE
				.getTransition_Immediate(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionPriority_6007Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionPriority_6007Parser() {
		if (transitionPriority_6007Parser == null) {
			transitionPriority_6007Parser = createTransitionPriority_6007Parser();
		}
		return transitionPriority_6007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionPriority_6007Parser() {
		EAttribute[] features = new EAttribute[] { ssm.ssmPackage.eINSTANCE
				.getTransition_Priority(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionTransitionKind_6008Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionTransitionKind_6008Parser() {
		if (transitionTransitionKind_6008Parser == null) {
			transitionTransitionKind_6008Parser = createTransitionTransitionKind_6008Parser();
		}
		return transitionTransitionKind_6008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionTransitionKind_6008Parser() {
		EAttribute[] features = new EAttribute[] { ssm.ssmPackage.eINSTANCE
				.getTransition_TransitionKind(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionTriggersAndEffects_6009Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionTriggersAndEffects_6009Parser() {
		if (transitionTriggersAndEffects_6009Parser == null) {
			transitionTriggersAndEffects_6009Parser = createTransitionTriggersAndEffects_6009Parser();
		}
		return transitionTriggersAndEffects_6009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTransitionTriggersAndEffects_6009Parser() {
		EAttribute[] features = new EAttribute[] { ssm.ssmPackage.eINSTANCE
				.getTransition_TriggersAndEffects(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case StateNameEditPart.VISUAL_ID:
			return getStateName_5001Parser();
		case StateName2EditPart.VISUAL_ID:
			return getStateName_5004Parser();
		case TransitionDelayEditPart.VISUAL_ID:
			return getTransitionDelay_6005Parser();
		case TransitionImmediateEditPart.VISUAL_ID:
			return getTransitionImmediate_6006Parser();
		case TransitionPriorityEditPart.VISUAL_ID:
			return getTransitionPriority_6007Parser();
		case TransitionTransitionKindEditPart.VISUAL_ID:
			return getTransitionTransitionKind_6008Parser();
		case TransitionTriggersAndEffectsEditPart.VISUAL_ID:
			return getTransitionTriggersAndEffects_6009Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(SsmVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(SsmVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (SsmElementTypes.getElement(hint) == null) {
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
