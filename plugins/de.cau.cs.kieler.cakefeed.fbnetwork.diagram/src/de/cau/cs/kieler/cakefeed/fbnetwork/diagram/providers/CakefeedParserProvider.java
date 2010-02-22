package de.cau.cs.kieler.cakefeed.fbnetwork.diagram.providers;

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
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.parsers.MessageFormatParser;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class CakefeedParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser fBName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getFBName_5005Parser() {
		if (fBName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBName_5005Parser = parser;
		}
		return fBName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputEventName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputEventName_5001Parser() {
		if (fBInputEventName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputEventName_5001Parser = parser;
		}
		return fBInputEventName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputEventName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputEventName_5002Parser() {
		if (fBOutputEventName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputEventName_5002Parser = parser;
		}
		return fBOutputEventName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBInputVarName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getFBInputVarName_5003Parser() {
		if (fBInputVarName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBInputVarName_5003Parser = parser;
		}
		return fBInputVarName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser fBOutputVarName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getFBOutputVarName_5004Parser() {
		if (fBOutputVarName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { CakefeedPackage.eINSTANCE
					.getNamedAndCommented_Name() };
			MessageFormatParser parser = new MessageFormatParser(features,
					editableFeatures);
			fBOutputVarName_5004Parser = parser;
		}
		return fBOutputVarName_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case FBNameEditPart.VISUAL_ID:
			return getFBName_5005Parser();
		case FBInputEventNameEditPart.VISUAL_ID:
			return getFBInputEventName_5001Parser();
		case FBOutputEventNameEditPart.VISUAL_ID:
			return getFBOutputEventName_5002Parser();
		case FBInputVarNameEditPart.VISUAL_ID:
			return getFBInputVarName_5003Parser();
		case FBOutputVarNameEditPart.VISUAL_ID:
			return getFBOutputVarName_5004Parser();
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
