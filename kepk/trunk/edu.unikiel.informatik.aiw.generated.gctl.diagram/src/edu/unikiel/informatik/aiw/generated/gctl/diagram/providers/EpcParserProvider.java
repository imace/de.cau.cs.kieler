package edu.unikiel.informatik.aiw.generated.gctl.diagram.providers;

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

import edu.unikiel.informatik.aiw.generated.epc.EpcPackage;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EPCNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EventNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.FunctionNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.InformationNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.parsers.MessageFormatParser;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry;

/**
 * @generated
 */
public class EpcParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser functionName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getFunctionName_4001Parser() {
		if (functionName_4001Parser == null) {
			functionName_4001Parser = createFunctionName_4001Parser();
		}
		return functionName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createFunctionName_4001Parser() {
		EAttribute[] features = new EAttribute[] { EpcPackage.eINSTANCE
				.getNode_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser eventName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getEventName_4002Parser() {
		if (eventName_4002Parser == null) {
			eventName_4002Parser = createEventName_4002Parser();
		}
		return eventName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEventName_4002Parser() {
		EAttribute[] features = new EAttribute[] { EpcPackage.eINSTANCE
				.getNode_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser informationName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getInformationName_4003Parser() {
		if (informationName_4003Parser == null) {
			informationName_4003Parser = createInformationName_4003Parser();
		}
		return informationName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createInformationName_4003Parser() {
		EAttribute[] features = new EAttribute[] { EpcPackage.eINSTANCE
				.getNode_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser ePCName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getEPCName_4004Parser() {
		if (ePCName_4004Parser == null) {
			ePCName_4004Parser = createEPCName_4004Parser();
		}
		return ePCName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEPCName_4004Parser() {
		EAttribute[] features = new EAttribute[] { EpcPackage.eINSTANCE
				.getNode_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case FunctionNameEditPart.VISUAL_ID:
			return getFunctionName_4001Parser();
		case EventNameEditPart.VISUAL_ID:
			return getEventName_4002Parser();
		case InformationNameEditPart.VISUAL_ID:
			return getInformationName_4003Parser();
		case EPCNameEditPart.VISUAL_ID:
			return getEPCName_4004Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(EpcVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(EpcVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (EpcElementTypes.getElement(hint) == null) {
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
