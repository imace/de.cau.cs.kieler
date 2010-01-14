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
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBNameEditPart;
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
	private IParser bFBTypeName_5027Parser;

	/**
	 * @generated
	 */
	private IParser getBFBTypeName_5027Parser() {
		if (bFBTypeName_5027Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			bFBTypeName_5027Parser = parser;
		}
		return bFBTypeName_5027Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFInputEventName_5013Parser;

	/**
	 * @generated
	 */
	private IParser getIFInputEventName_5013Parser() {
		if (iFInputEventName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFInputEventName_5013Parser = parser;
		}
		return iFInputEventName_5013Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFOutputEventName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getIFOutputEventName_5014Parser() {
		if (iFOutputEventName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFOutputEventName_5014Parser = parser;
		}
		return iFOutputEventName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFInputVarName_5015Parser;

	/**
	 * @generated
	 */
	private IParser getIFInputVarName_5015Parser() {
		if (iFInputVarName_5015Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFInputVarName_5015Parser = parser;
		}
		return iFInputVarName_5015Parser;
	}

	/**
	 * @generated
	 */
	private IParser iFOutputVarName_5016Parser;

	/**
	 * @generated
	 */
	private IParser getIFOutputVarName_5016Parser() {
		if (iFOutputVarName_5016Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			iFOutputVarName_5016Parser = parser;
		}
		return iFOutputVarName_5016Parser;
	}

	/**
	 * @generated
	 */
	private IParser internalVarName_5017Parser;

	/**
	 * @generated
	 */
	private IParser getInternalVarName_5017Parser() {
		if (internalVarName_5017Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			internalVarName_5017Parser = parser;
		}
		return internalVarName_5017Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getFBName_5022Parser() {
		if (fBName_5022Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBName_5022Parser = parser;
		}
		return fBName_5022Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputEventName_5018Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputEventName_5018Parser() {
		if (fBInputEventName_5018Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputEventName_5018Parser = parser;
		}
		return fBInputEventName_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputEventName_5019Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputEventName_5019Parser() {
		if (fBOutputEventName_5019Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputEventName_5019Parser = parser;
		}
		return fBOutputEventName_5019Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputVarName_5020Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputVarName_5020Parser() {
		if (fBInputVarName_5020Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputVarName_5020Parser = parser;
		}
		return fBInputVarName_5020Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputVarName_5021Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputVarName_5021Parser() {
		if (fBOutputVarName_5021Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputVarName_5021Parser = parser;
		}
		return fBOutputVarName_5021Parser;
	}

	/**
	 * @generated
	 */
	private IParser sTName_5024Parser;

	/**
	 * @generated
	 */
	private IParser getSTName_5024Parser() {
		if (sTName_5024Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			sTName_5024Parser = parser;
		}
		return sTName_5024Parser;
	}

	/**
	 * @generated
	 */
	private IParser lDName_5025Parser;

	/**
	 * @generated
	 */
	private IParser getLDName_5025Parser() {
		if (lDName_5025Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			lDName_5025Parser = parser;
		}
		return lDName_5025Parser;
	}

	/**
	 * @generated
	 */
	private IParser otherName_5026Parser;

	/**
	 * @generated
	 */
	private IParser getOtherName_5026Parser() {
		if (otherName_5026Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			otherName_5026Parser = parser;
		}
		return otherName_5026Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case BFBTypeNameEditPart.VISUAL_ID:
			return getBFBTypeName_5027Parser();
		case IFInputEventNameEditPart.VISUAL_ID:
			return getIFInputEventName_5013Parser();
		case IFOutputEventNameEditPart.VISUAL_ID:
			return getIFOutputEventName_5014Parser();
		case IFInputVarNameEditPart.VISUAL_ID:
			return getIFInputVarName_5015Parser();
		case IFOutputVarNameEditPart.VISUAL_ID:
			return getIFOutputVarName_5016Parser();
		case InternalVarNameEditPart.VISUAL_ID:
			return getInternalVarName_5017Parser();
		case FBNameEditPart.VISUAL_ID:
			return getFBName_5022Parser();
		case FBInputEventNameEditPart.VISUAL_ID:
			return getFBInputEventName_5018Parser();
		case FBOutputEventNameEditPart.VISUAL_ID:
			return getFBOutputEventName_5019Parser();
		case FBInputVarNameEditPart.VISUAL_ID:
			return getFBInputVarName_5020Parser();
		case FBOutputVarNameEditPart.VISUAL_ID:
			return getFBOutputVarName_5021Parser();
		case STNameEditPart.VISUAL_ID:
			return getSTName_5024Parser();
		case LDNameEditPart.VISUAL_ID:
			return getLDName_5025Parser();
		case OtherNameEditPart.VISUAL_ID:
			return getOtherName_5026Parser();
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
