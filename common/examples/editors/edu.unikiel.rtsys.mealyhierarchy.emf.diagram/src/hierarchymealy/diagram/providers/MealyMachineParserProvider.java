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
	private IParser compositeStateName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getCompositeStateName_5007Parser() {
		if (compositeStateName_5007Parser == null) {
			compositeStateName_5007Parser = createCompositeStateName_5007Parser();
		}
		return compositeStateName_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompositeStateName_5007Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5005Parser() {
		if (stateName_5005Parser == null) {
			stateName_5005Parser = createStateName_5005Parser();
		}
		return stateName_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_5005Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5002Parser() {
		if (stateName_5002Parser == null) {
			stateName_5002Parser = createStateName_5002Parser();
		}
		return stateName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStateName_5002Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser compositeStateName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getCompositeStateName_5006Parser() {
		if (compositeStateName_5006Parser == null) {
			compositeStateName_5006Parser = createCompositeStateName_5006Parser();
		}
		return compositeStateName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCompositeStateName_5006Parser() {
		EAttribute[] features = new EAttribute[] { MealyPackage.eINSTANCE
				.getState_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser edgeTriggerAction_6001Parser;

	/**
	 * @generated
	 */
	private IParser getEdgeTriggerAction_6001Parser() {
		if (edgeTriggerAction_6001Parser == null) {
			edgeTriggerAction_6001Parser = createEdgeTriggerAction_6001Parser();
		}
		return edgeTriggerAction_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEdgeTriggerAction_6001Parser() {
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
			return getCompositeStateName_5007Parser();
		case StateName2EditPart.VISUAL_ID:
			return getStateName_5005Parser();
		case StateNameEditPart.VISUAL_ID:
			return getStateName_5002Parser();
		case CompositeStateName2EditPart.VISUAL_ID:
			return getCompositeStateName_5006Parser();
		case EdgeTriggerActionEditPart.VISUAL_ID:
			return getEdgeTriggerAction_6001Parser();
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
