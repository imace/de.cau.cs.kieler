package edu.unikiel.informatik.aiw.generated.gctl.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
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

import edu.unikiel.informatik.aiw.generated.epc.Implication;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EPCNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.EventNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.FunctionNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.GCTLconnectorEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.ImplicationEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.InformationEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.edit.parts.InformationNameEditPart;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.part.GctlDiagramEditorPlugin;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.providers.EpcElementTypes;
import edu.unikiel.informatik.aiw.generated.gctl.diagram.providers.EpcParserProvider;

/**
 * @generated
 */
public class EpcNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		GctlDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		GctlDiagramEditorPlugin
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
		if (element instanceof EpcNavigatorItem
				&& !isOwnView(((EpcNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof EpcNavigatorGroup) {
			EpcNavigatorGroup group = (EpcNavigatorGroup) element;
			return GctlDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof EpcNavigatorItem) {
			EpcNavigatorItem navigatorItem = (EpcNavigatorItem) element;
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
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case GCTLEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://informatik.uni-kiel.de/aiw/epcmodel?EPC", EpcElementTypes.EPC_79); //$NON-NLS-1$
		case FunctionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?Function", EpcElementTypes.Function_1001); //$NON-NLS-1$
		case EventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?Event", EpcElementTypes.Event_1002); //$NON-NLS-1$
		case InformationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?Information", EpcElementTypes.Information_1003); //$NON-NLS-1$
		case EPCEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?EPC", EpcElementTypes.EPC_1004); //$NON-NLS-1$
		case ImplicationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?Implication", EpcElementTypes.Implication_1005); //$NON-NLS-1$
		case GCTLconnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?GCTLconnector", EpcElementTypes.GCTLconnector_3001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = GctlDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& EpcElementTypes.isKnownElementType(elementType)) {
			image = EpcElementTypes.getImage(elementType);
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
		if (element instanceof EpcNavigatorGroup) {
			EpcNavigatorGroup group = (EpcNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof EpcNavigatorItem) {
			EpcNavigatorItem navigatorItem = (EpcNavigatorItem) element;
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
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case GCTLEditPart.VISUAL_ID:
			return getEPC_79Text(view);
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1001Text(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1002Text(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003Text(view);
		case EPCEditPart.VISUAL_ID:
			return getEPC_1004Text(view);
		case ImplicationEditPart.VISUAL_ID:
			return getImplication_1005Text(view);
		case GCTLconnectorEditPart.VISUAL_ID:
			return getGCTLconnector_3001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getEPC_79Text(View view) {
		edu.unikiel.informatik.aiw.generated.epc.EPC domainModelElement = (edu.unikiel.informatik.aiw.generated.epc.EPC) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			GctlDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFunction_1001Text(View view) {
		IAdaptable hintAdapter = new EpcParserProvider.HintAdapter(
				EpcElementTypes.Function_1001,
				(view.getElement() != null ? view.getElement() : view),
				EpcVisualIDRegistry.getType(FunctionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			GctlDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEvent_1002Text(View view) {
		IAdaptable hintAdapter = new EpcParserProvider.HintAdapter(
				EpcElementTypes.Event_1002, (view.getElement() != null ? view
						.getElement() : view), EpcVisualIDRegistry
						.getType(EventNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			GctlDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getInformation_1003Text(View view) {
		IAdaptable hintAdapter = new EpcParserProvider.HintAdapter(
				EpcElementTypes.Information_1003,
				(view.getElement() != null ? view.getElement() : view),
				EpcVisualIDRegistry.getType(InformationNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			GctlDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEPC_1004Text(View view) {
		IAdaptable hintAdapter = new EpcParserProvider.HintAdapter(
				EpcElementTypes.EPC_1004, (view.getElement() != null ? view
						.getElement() : view), EpcVisualIDRegistry
						.getType(EPCNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			GctlDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getImplication_1005Text(View view) {
		Implication domainModelElement = (Implication) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			GctlDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGCTLconnector_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
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
		return GCTLEditPart.MODEL_ID.equals(EpcVisualIDRegistry
				.getModelID(view));
	}

}
