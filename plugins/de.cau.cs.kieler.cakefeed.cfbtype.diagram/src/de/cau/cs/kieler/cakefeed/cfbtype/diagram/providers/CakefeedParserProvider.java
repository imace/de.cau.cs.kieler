package de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers;

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

import de.cau.cs.kieler.cakefeed.CakefeedPackage;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.parsers.MessageFormatParser;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class CakefeedParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser iFInputEventName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getIFInputEventName_5001Parser() {
		if (iFInputEventName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFInputEventName_5001Parser = parser;
		}
		return iFInputEventName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFOutputEventName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getIFOutputEventName_5002Parser() {
		if (iFOutputEventName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFOutputEventName_5002Parser = parser;
		}
		return iFOutputEventName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFInputVarName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getIFInputVarName_5003Parser() {
		if (iFInputVarName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFInputVarName_5003Parser = parser;
		}
		return iFInputVarName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFOutputVarName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getIFOutputVarName_5004Parser() {
		if (iFOutputVarName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFOutputVarName_5004Parser = parser;
		}
		return iFOutputVarName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputEventName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputEventName_5005Parser() {
		if (fBInputEventName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputEventName_5005Parser = parser;
		}
		return fBInputEventName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputEventName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputEventName_5006Parser() {
		if (fBOutputEventName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputEventName_5006Parser = parser;
		}
		return fBOutputEventName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputVarName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputVarName_5007Parser() {
		if (fBInputVarName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputVarName_5007Parser = parser;
		}
		return fBInputVarName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputVarName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputVarName_5008Parser() {
		if (fBOutputVarName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputVarName_5008Parser = parser;
		}
		return fBOutputVarName_5008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case IFInputEventNameEditPart.VISUAL_ID:
			return getIFInputEventName_5001Parser();
		case IFOutputEventNameEditPart.VISUAL_ID:
			return getIFOutputEventName_5002Parser();
		case IFInputVarNameEditPart.VISUAL_ID:
			return getIFInputVarName_5003Parser();
		case IFOutputVarNameEditPart.VISUAL_ID:
			return getIFOutputVarName_5004Parser();
		case FBInputEventNameEditPart.VISUAL_ID:
			return getFBInputEventName_5005Parser();
		case FBOutputEventNameEditPart.VISUAL_ID:
			return getFBOutputEventName_5006Parser();
		case FBInputVarNameEditPart.VISUAL_ID:
			return getFBInputVarName_5007Parser();
		case FBOutputVarNameEditPart.VISUAL_ID:
			return getFBOutputVarName_5008Parser();
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
			return getParser(CakefeedVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(CakefeedVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (CakefeedElementTypes.getElement(hint) == null) {
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
