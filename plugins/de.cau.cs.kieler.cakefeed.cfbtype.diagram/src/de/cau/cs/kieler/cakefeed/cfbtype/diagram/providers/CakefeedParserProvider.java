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
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBNameEditPart;
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
	private IParser cFBTypeName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getCFBTypeName_5019Parser() {
		if (cFBTypeName_5019Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			cFBTypeName_5019Parser = parser;
		}
		return cFBTypeName_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFInputEventName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getIFInputEventName_5009Parser() {
		if (iFInputEventName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFInputEventName_5009Parser = parser;
		}
		return iFInputEventName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFOutputEventName_5010Parser;

	/**
	 * @generated
	 */
	private IParser getIFOutputEventName_5010Parser() {
		if (iFOutputEventName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFOutputEventName_5010Parser = parser;
		}
		return iFOutputEventName_5010Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFInputVarName_5011Parser;

	/**
	 * @generated
	 */
	private IParser getIFInputVarName_5011Parser() {
		if (iFInputVarName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFInputVarName_5011Parser = parser;
		}
		return iFInputVarName_5011Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFOutputVarName_5012Parser;

	/**
	 * @generated
	 */
	private IParser getIFOutputVarName_5012Parser() {
		if (iFOutputVarName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFOutputVarName_5012Parser = parser;
		}
		return iFOutputVarName_5012Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getFBName_5017Parser() {
		if (fBName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBName_5017Parser = parser;
		}
		return fBName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputEventName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputEventName_5013Parser() {
		if (fBInputEventName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputEventName_5013Parser = parser;
		}
		return fBInputEventName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputEventName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputEventName_5014Parser() {
		if (fBOutputEventName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputEventName_5014Parser = parser;
		}
		return fBOutputEventName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputVarName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputVarName_5015Parser() {
		if (fBInputVarName_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputVarName_5015Parser = parser;
		}
		return fBInputVarName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputVarName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputVarName_5016Parser() {
		if (fBOutputVarName_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputVarName_5016Parser = parser;
		}
		return fBOutputVarName_5016Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case CFBTypeNameEditPart.VISUAL_ID:
			return getCFBTypeName_5019Parser();
		case IFInputEventNameEditPart.VISUAL_ID:
			return getIFInputEventName_5009Parser();
		case IFOutputEventNameEditPart.VISUAL_ID:
			return getIFOutputEventName_5010Parser();
		case IFInputVarNameEditPart.VISUAL_ID:
			return getIFInputVarName_5011Parser();
		case IFOutputVarNameEditPart.VISUAL_ID:
			return getIFOutputVarName_5012Parser();
		case FBNameEditPart.VISUAL_ID:
			return getFBName_5017Parser();
		case FBInputEventNameEditPart.VISUAL_ID:
			return getFBInputEventName_5013Parser();
		case FBOutputEventNameEditPart.VISUAL_ID:
			return getFBOutputEventName_5014Parser();
		case FBInputVarNameEditPart.VISUAL_ID:
			return getFBInputVarName_5015Parser();
		case FBOutputVarNameEditPart.VISUAL_ID:
			return getFBOutputVarName_5016Parser();
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
