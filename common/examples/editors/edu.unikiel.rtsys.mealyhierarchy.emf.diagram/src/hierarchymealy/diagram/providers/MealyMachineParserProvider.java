package hierarchymealy.diagram.providers;

import hierarchymealy.MealyPackage;
import hierarchymealy.diagram.edit.parts.CompositeStateName2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateNameEditPart;
import hierarchymealy.diagram.edit.parts.EdgeTriggerActionEditPart;
import hierarchymealy.diagram.edit.parts.StateName2EditPart;
import hierarchymealy.diagram.edit.parts.StateNameEditPart;
import hierarchymealy.diagram.parsers.MessageFormatParser;
import hierarchymealy.diagram.part.MealyMachineVisualIDRegistry;

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

/**
 * @generated
 */
public class MealyMachineParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser compositeStateName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getCompositeStateName_4003Parser() {
		if (compositeStateName_4003Parser == null) {
			compositeStateName_4003Parser = createCompositeStateName_4003Parser();
		}
		return compositeStateName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompositeStateName_4003Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4004Parser() {
		if (stateName_4004Parser == null) {
			stateName_4004Parser = createStateName_4004Parser();
		}
		return stateName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4004Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_4001Parser() {
		if (stateName_4001Parser == null) {
			stateName_4001Parser = createStateName_4001Parser();
		}
		return stateName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_4001Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser compositeStateName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getCompositeStateName_4002Parser() {
		if (compositeStateName_4002Parser == null) {
			compositeStateName_4002Parser = createCompositeStateName_4002Parser();
		}
		return compositeStateName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompositeStateName_4002Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser edgeTriggerAction_4005Parser;

	/**
	 * @generated
	 */
	private IParser getEdgeTriggerAction_4005Parser() {
		if (edgeTriggerAction_4005Parser == null) {
			edgeTriggerAction_4005Parser = createEdgeTriggerAction_4005Parser();
		}
		return edgeTriggerAction_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEdgeTriggerAction_4005Parser() {
		EAttribute[] features = new EAttribute[] {
				MealyPackage.eINSTANCE.getEdge_Trigger(),
				MealyPackage.eINSTANCE.getEdge_Action(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		parser.setViewPattern("{0}/{1}");
		parser.setEditorPattern("{0}/{1}");
		parser.setEditPattern("{0}/{1}");
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case CompositeStateNameEditPart.VISUAL_ID:
			return getCompositeStateName_4003Parser();
		case StateNameEditPart.VISUAL_ID:
			return getStateName_4004Parser();
		case StateName2EditPart.VISUAL_ID:
			return getStateName_4001Parser();
		case CompositeStateName2EditPart.VISUAL_ID:
			return getCompositeStateName_4002Parser();
		case EdgeTriggerActionEditPart.VISUAL_ID:
			return getEdgeTriggerAction_4005Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(MealyMachineVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(MealyMachineVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (MealyMachineElementTypes.getElement(hint) == null) {
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
