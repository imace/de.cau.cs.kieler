package de.cau.cs.kieler.cakefeed.fbnetwork.diagram.navigator;

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
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBDataConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBFBEventConnectionEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBInputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBNetworkEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputEventNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.edit.parts.FBOutputVarNameEditPart;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedDiagramEditorPlugin;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.part.CakefeedVisualIDRegistry;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.providers.CakefeedElementTypes;
import de.cau.cs.kieler.cakefeed.fbnetwork.diagram.providers.CakefeedParserProvider;

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
		case FBNetworkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://kieler.cs.cau.de/cakefeed/?FBNetwork", CakefeedElementTypes.FBNetwork_1000); //$NON-NLS-1$
		case FBEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://kieler.cs.cau.de/cakefeed/?FB", CakefeedElementTypes.FB_2001); //$NON-NLS-1$
		case FBInputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBInputEvent", CakefeedElementTypes.FBInputEvent_3001); //$NON-NLS-1$
		case FBOutputEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBOutputEvent", CakefeedElementTypes.FBOutputEvent_3002); //$NON-NLS-1$
		case FBInputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBInputVar", CakefeedElementTypes.FBInputVar_3003); //$NON-NLS-1$
		case FBOutputVarEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://kieler.cs.cau.de/cakefeed/?FBOutputVar", CakefeedElementTypes.FBOutputVar_3004); //$NON-NLS-1$
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?FBFBEventConnection", CakefeedElementTypes.FBFBEventConnection_4001); //$NON-NLS-1$
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://kieler.cs.cau.de/cakefeed/?FBFBDataConnection", CakefeedElementTypes.FBFBDataConnection_4002); //$NON-NLS-1$
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
		case FBNetworkEditPart.VISUAL_ID:
			return getFBNetwork_1000Text(view);
		case FBEditPart.VISUAL_ID:
			return getFB_2001Text(view);
		case FBInputEventEditPart.VISUAL_ID:
			return getFBInputEvent_3001Text(view);
		case FBOutputEventEditPart.VISUAL_ID:
			return getFBOutputEvent_3002Text(view);
		case FBInputVarEditPart.VISUAL_ID:
			return getFBInputVar_3003Text(view);
		case FBOutputVarEditPart.VISUAL_ID:
			return getFBOutputVar_3004Text(view);
		case FBFBEventConnectionEditPart.VISUAL_ID:
			return getFBFBEventConnection_4001Text(view);
		case FBFBDataConnectionEditPart.VISUAL_ID:
			return getFBFBDataConnection_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getFBNetwork_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFB_2001Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FB_2001, view.getElement() != null ? view
						.getElement() : view, CakefeedVisualIDRegistry
						.getType(FBNameEditPart.VISUAL_ID));
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
	private String getFBInputEvent_3001Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBInputEvent_3001,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBInputEventNameEditPart.VISUAL_ID));
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
	private String getFBOutputEvent_3002Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBOutputEvent_3002,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBOutputEventNameEditPart.VISUAL_ID));
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
	private String getFBInputVar_3003Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBInputVar_3003,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBInputVarNameEditPart.VISUAL_ID));
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
	private String getFBOutputVar_3004Text(View view) {
		IParser parser = CakefeedParserProvider.getParser(
				CakefeedElementTypes.FBOutputVar_3004,
				view.getElement() != null ? view.getElement() : view,
				CakefeedVisualIDRegistry
						.getType(FBOutputVarNameEditPart.VISUAL_ID));
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
	private String getFBFBEventConnection_4001Text(View view) {
		FBFBEventConnection domainModelElement = (FBFBEventConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFBFBDataConnection_4002Text(View view) {
		FBFBDataConnection domainModelElement = (FBFBDataConnection) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getComment();
		} else {
			CakefeedDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4002); //$NON-NLS-1$
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
		return FBNetworkEditPart.MODEL_ID.equals(CakefeedVisualIDRegistry
				.getModelID(view));
	}

}
