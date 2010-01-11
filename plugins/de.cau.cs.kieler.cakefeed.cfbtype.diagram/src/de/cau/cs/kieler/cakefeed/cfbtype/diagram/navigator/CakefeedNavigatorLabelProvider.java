package de.cau.cs.kieler.cakefeed.cfbtype.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.FBFBEventConnection;
import de.cau.cs.kieler.cakefeed.FBIFDataConnection;
import de.cau.cs.kieler.cakefeed.FBIFEventConnection;
import de.cau.cs.kieler.cakefeed.IFFBDataConnection;
import de.cau.cs.kieler.cakefeed.IFFBEventConnection;
import de.cau.cs.kieler.cakefeed.IFIFDataConnection;
import de.cau.cs.kieler.cakefeed.IFIFEventConnection;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.CFBTypeNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFIFEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.IFOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedDiagramEditorPlugin;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedElementTypes;
import de.cau.cs.kieler.cakefeed.cfbtype.diagram.providers.CakefeedParserProvider;

/**
 * @generated
 */
public class CakefeedNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		CakefeedDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		CakefeedDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof CakefeedNavigatorItem
				&& !isOwnView(((CakefeedNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof CakefeedNavigatorGroup) {
			CakefeedNavigatorGroup group = (CakefeedNavigatorGroup) element;
			return CakefeedDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof CakefeedNavigatorItem) {
			CakefeedNavigatorItem navigatorItem = (CakefeedNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case CFBDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://kieler.cs.cau.de/cakefeed/?CFBDiagram", CakefeedElementTypes.CFBDiagram_1000); //$NON-NLS-1$
		case CFBTypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://kieler.cs.cau.de/cakefeed/?CFBType", CakefeedElementTypes.CFBType_2002); //$NON-NLS-1$
		case IFInputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFInputEvent", CakefeedElementTypes.IFInputEvent_3021); //$NON-NLS-1$
		case IFOutputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFOutputEvent", CakefeedElementTypes.IFOutputEvent_3022); //$NON-NLS-1$
		case IFInputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFInputVar", CakefeedElementTypes.IFInputVar_3023); //$NON-NLS-1$
		case IFOutputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFOutputVar", CakefeedElementTypes.IFOutputVar_3024); //$NON-NLS-1$
		case FBEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FB", CakefeedElementTypes.FB_3025); //$NON-NLS-1$
		case FBInputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBInputEvent", CakefeedElementTypes.FBInputEvent_3026); //$NON-NLS-1$
		case FBOutputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBOutputEvent", CakefeedElementTypes.FBOutputEvent_3027); //$NON-NLS-1$
		case FBInputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBInputVar", CakefeedElementTypes.FBInputVar_3028); //$NON-NLS-1$
		case FBOutputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBOutputVar", CakefeedElementTypes.FBOutputVar_3029); //$NON-NLS-1$
		case InputWithEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?InputWith", CakefeedElementTypes.InputWith_4001); //$NON-NLS-1$
		case OutputWithEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?OutputWith", CakefeedElementTypes.OutputWith_4002); //$NON-NLS-1$
		case IFIFEventConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?IFIFEventConnection", CakefeedElementTypes.IFIFEventConnection_4007); //$NON-NLS-1$
		case IFFBEventConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?IFFBEventConnection", CakefeedElementTypes.IFFBEventConnection_4008); //$NON-NLS-1$
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?FBIFEventConnection", CakefeedElementTypes.FBIFEventConnection_4009); //$NON-NLS-1$
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?FBFBEventConnection", CakefeedElementTypes.FBFBEventConnection_4010); //$NON-NLS-1$
		case IFIFDataConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?IFIFDataConnection", CakefeedElementTypes.IFIFDataConnection_4011); //$NON-NLS-1$
		case IFFBDataConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?IFFBDataConnection", CakefeedElementTypes.IFFBDataConnection_4012); //$NON-NLS-1$
		case FBIFDataConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?FBIFDataConnection", CakefeedElementTypes.FBIFDataConnection_4013); //$NON-NLS-1$
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?FBFBDataConnection", CakefeedElementTypes.FBFBDataConnection_4014); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = CakefeedDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& CakefeedElementTypes.isKnownElementType(elementType)) {
			image = CakefeedElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof CakefeedNavigatorGroup) {
			CakefeedNavigatorGroup group = (CakefeedNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof CakefeedNavigatorItem) {
			CakefeedNavigatorItem navigatorItem = (CakefeedNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (CakefeedVisualIDRegistry.getVisualID(view)) {
		case CFBDiagramEditPart.VISUAL_ID:
			return getCFBDiagram_1000Text(view);
		case CFBTypeEditPart.VISUAL_ID:
			return getCFBType_2002Text(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3021Text(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3022Text(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3023Text(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3024Text(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3025Text(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3026Text(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3027Text(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3028Text(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3029Text(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001Text(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002Text(view);
		case IFIFEventConnectionEditPart.VISUAL_ID:
			return getIFIFEventConnection_4007Text(view);
		case IFFBEventConnectionEditPart.VISUAL_ID:
			return getIFFBEventConnection_4008Text(view);
		case FBIFEventConnectionEditPart.VISUAL_ID:
			return getFBIFEventConnection_4009Text(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4010Text(view);
		case IFIFDataConnectionEditPart.VISUAL_ID:
			return getIFIFDataConnection_4011Text(view);
		case IFFBDataConnectionEditPart.VISUAL_ID:
			return getIFFBDataConnection_4012Text(view);
		case FBIFDataConnectionEditPart.VISUAL_ID:
			return getFBIFDataConnection_4013Text(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4014Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getCFBDiagram_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCFBType_2002Text(View view) {
		IParser parser = CakefeedParserProvider
				.getParser(CakefeedElementTypes.CFBType_2002,
						view.getElement() != null ? view.getElement() : view,
						CakefeedVisualIDRegistry
								.getType(CFBTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFInputEvent_3021Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFInputEvent_3021,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFInputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFOutputEvent_3022Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFOutputEvent_3022,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFOutputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFInputVar_3023Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFInputVar_3023,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFInputVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFOutputVar_3024Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFOutputVar_3024,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFOutputVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFB_3025Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FB_3025, view.getElement() != null ? view
						.getElement() : view, CakefeedVisualIDRegistry
						.getType(FBNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBInputEvent_3026Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBInputEvent_3026,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBInputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBOutputEvent_3027Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBOutputEvent_3027,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBOutputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBInputVar_3028Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBInputVar_3028,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBInputVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBOutputVar_3029Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBOutputVar_3029,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBOutputVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInputWith_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOutputWith_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getIFIFEventConnection_4007Text(View view) {
		IFIFEventConnection domainModelElement = (IFIFEventConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFFBEventConnection_4008Text(View view) {
		IFFBEventConnection domainModelElement = (IFFBEventConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBIFEventConnection_4009Text(View view) {
		FBIFEventConnection domainModelElement = (FBIFEventConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBFBEventConnection_4010Text(View view) {
		FBFBEventConnection domainModelElement = (FBFBEventConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFIFDataConnection_4011Text(View view) {
		IFIFDataConnection domainModelElement = (IFIFDataConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFFBDataConnection_4012Text(View view) {
		IFFBDataConnection domainModelElement = (IFFBDataConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBIFDataConnection_4013Text(View view) {
		FBIFDataConnection domainModelElement = (FBIFDataConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBFBDataConnection_4014Text(View view) {
		FBFBDataConnection domainModelElement = (FBFBDataConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return CFBDiagramEditPart.MODEL_ID.equals(CakefeedVisualIDRegistry
				.getModelID(view));
	}

}
