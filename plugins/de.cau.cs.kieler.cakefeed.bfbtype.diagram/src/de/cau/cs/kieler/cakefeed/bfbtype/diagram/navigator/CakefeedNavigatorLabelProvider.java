package de.cau.cs.kieler.cakefeed.bfbtype.diagram.navigator;

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

import de.cau.cs.kieler.cakefeed.BFBType;
import de.cau.cs.kieler.cakefeed.FBFBDataConnection;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBDiagramEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.BFBTypeEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.IFOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.InternalVarNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.LDNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OtherNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.OutputWithEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.edit.parts.STNameEditPart;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedDiagramEditorPlugin;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.part.CakefeedVisualIDRegistry;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedElementTypes;
import de.cau.cs.kieler.cakefeed.bfbtype.diagram.providers.CakefeedParserProvider;

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
		case BFBDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://kieler.cs.cau.de/cakefeed/?BFBDiagram", CakefeedElementTypes.BFBDiagram_1000); //$NON-NLS-1$
		case BFBTypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://kieler.cs.cau.de/cakefeed/?BFBType", CakefeedElementTypes.BFBType_2001); //$NON-NLS-1$
		case IFInputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFInputEvent", CakefeedElementTypes.IFInputEvent_3015); //$NON-NLS-1$
		case IFOutputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFOutputEvent", CakefeedElementTypes.IFOutputEvent_3016); //$NON-NLS-1$
		case IFInputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFInputVar", CakefeedElementTypes.IFInputVar_3017); //$NON-NLS-1$
		case IFOutputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?IFOutputVar", CakefeedElementTypes.IFOutputVar_3018); //$NON-NLS-1$
		case InternalVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?InternalVar", CakefeedElementTypes.InternalVar_3005); //$NON-NLS-1$
		case FBDEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBD", CakefeedElementTypes.FBD_3006); //$NON-NLS-1$
		case FBEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FB", CakefeedElementTypes.FB_3019); //$NON-NLS-1$
		case FBInputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBInputEvent", CakefeedElementTypes.FBInputEvent_3020); //$NON-NLS-1$
		case FBOutputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBOutputEvent", CakefeedElementTypes.FBOutputEvent_3021); //$NON-NLS-1$
		case FBInputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBInputVar", CakefeedElementTypes.FBInputVar_3022); //$NON-NLS-1$
		case FBOutputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBOutputVar", CakefeedElementTypes.FBOutputVar_3023); //$NON-NLS-1$
		case STEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?ST", CakefeedElementTypes.ST_3008); //$NON-NLS-1$
		case LDEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?LD", CakefeedElementTypes.LD_3009); //$NON-NLS-1$
		case OtherEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?Other", CakefeedElementTypes.Other_3010); //$NON-NLS-1$
		case InputWithEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?InputWith", CakefeedElementTypes.InputWith_4001); //$NON-NLS-1$
		case OutputWithEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?OutputWith", CakefeedElementTypes.OutputWith_4002); //$NON-NLS-1$
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?FBFBDataConnection", CakefeedElementTypes.FBFBDataConnection_4005); //$NON-NLS-1$
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
		case BFBDiagramEditPart.VISUAL_ID:
			return getBFBDiagram_1000Text(view);
		case BFBTypeEditPart.VISUAL_ID:
			return getBFBType_2001Text(view);
		case IFInputEventEditPart.VISUAL_ID:
			return getIFInputEvent_3015Text(view);
		case IFOutputEventEditPart.VISUAL_ID:
			return getIFOutputEvent_3016Text(view);
		case IFInputVarEditPart.VISUAL_ID:
			return getIFInputVar_3017Text(view);
		case IFOutputVarEditPart.VISUAL_ID:
			return getIFOutputVar_3018Text(view);
		case InternalVarEditPart.VISUAL_ID:
			return getInternalVar_3005Text(view);
		case FBDEditPart.VISUAL_ID:
			return getFBD_3006Text(view);
		case FBEditPart.VISUAL_ID:
			return getFB_3019Text(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3020Text(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3021Text(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3022Text(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3023Text(view);
		case STEditPart.VISUAL_ID:
			return getST_3008Text(view);
		case LDEditPart.VISUAL_ID:
			return getLD_3009Text(view);
		case OtherEditPart.VISUAL_ID:
			return getOther_3010Text(view);
		case InputWithEditPart.VISUAL_ID:
			return getInputWith_4001Text(view);
		case OutputWithEditPart.VISUAL_ID:
			return getOutputWith_4002Text(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4005Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getBFBDiagram_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getBFBType_2001Text(View view) {
		BFBType domainModelElement = (BFBType) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFInputEvent_3015Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFInputEvent_3015,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFInputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFOutputEvent_3016Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFOutputEvent_3016,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFOutputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFInputVar_3017Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFInputVar_3017,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFInputVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIFOutputVar_3018Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.IFOutputVar_3018,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(IFOutputVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInternalVar_3005Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.InternalVar_3005,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(InternalVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBD_3006Text(View view) {
		de.cau.cs.kieler.cakefeed.FBD domainModelElement = (de.cau.cs.kieler.cakefeed.FBD) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFB_3019Text(View view) {
		de.cau.cs.kieler.cakefeed.FB domainModelElement = (de.cau.cs.kieler.cakefeed.FB) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3019); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBInputEvent_3020Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBInputEvent_3020,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBInputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBOutputEvent_3021Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBOutputEvent_3021,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBOutputEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBInputVar_3022Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBInputVar_3022,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBInputVarNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBOutputVar_3023Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBOutputVar_3023,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBOutputVarNameEditPart.VISUAL_ID));
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
	private String getST_3008Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.ST_3008, view.getElement() != null ? view
						.getElement() : view, CakefeedVisualIDRegistry
						.getType(STNameEditPart.VISUAL_ID));
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
	private String getLD_3009Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.LD_3009, view.getElement() != null ? view
						.getElement() : view, CakefeedVisualIDRegistry
						.getType(LDNameEditPart.VISUAL_ID));
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
	private String getOther_3010Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.Other_3010,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry.getType(OtherNameEditPart.VISUAL_ID));
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
	private String getFBFBDataConnection_4005Text(View view) {
		FBFBDataConnection domainModelElement = (FBFBDataConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4005); //$NON-NLS-1$
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
		return BFBDiagramEditPart.MODEL_ID.equals(CakefeedVisualIDRegistry
				.getModelID(view));
	}

}
