package de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers;

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
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.parsers.MessageFormatParser;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry;

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
	private IParser internalVarName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getInternalVarName_5005Parser() {
		if (internalVarName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			internalVarName_5005Parser = parser;
		}
		return internalVarName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputEventName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputEventName_5006Parser() {
		if (fBInputEventName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputEventName_5006Parser = parser;
		}
		return fBInputEventName_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputEventName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputEventName_5007Parser() {
		if (fBOutputEventName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputEventName_5007Parser = parser;
		}
		return fBOutputEventName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputVarName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputVarName_5008Parser() {
		if (fBInputVarName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputVarName_5008Parser = parser;
		}
		return fBInputVarName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputVarName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputVarName_5009Parser() {
		if (fBOutputVarName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getVar_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputVarName_5009Parser = parser;
		}
		return fBOutputVarName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser sTName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getSTName_5010Parser() {
		if (sTName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getST_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getST_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			sTName_5010Parser = parser;
		}
		return sTName_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser lDName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getLDName_5011Parser() {
		if (lDName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getLD_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getLD_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			lDName_5011Parser = parser;
		}
		return lDName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser otherName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getOtherName_5012Parser() {
		if (otherName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getOther_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getOther_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			otherName_5012Parser = parser;
		}
		return otherName_5012Parser;
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
		case InternalVarNameEditPart.VISUAL_ID:
			return getInternalVarName_5005Parser();
		case FBInputEventNameEditPart.VISUAL_ID:
			return getFBInputEventName_5006Parser();
		case FBOutputEventNameEditPart.VISUAL_ID:
			return getFBOutputEventName_5007Parser();
		case FBInputVarNameEditPart.VISUAL_ID:
			return getFBInputVarName_5008Parser();
		case FBOutputVarNameEditPart.VISUAL_ID:
			return getFBOutputVarName_5009Parser();
		case STNameEditPart.VISUAL_ID:
			return getSTName_5010Parser();
		case LDNameEditPart.VISUAL_ID:
			return getLDName_5011Parser();
		case OtherNameEditPart.VISUAL_ID:
			return getOtherName_5012Parser();
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
