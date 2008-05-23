package edu.unikiel.informatik.aiw.generated.epc.diagram.navigator;

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

import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ANDEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ActivatesFunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPC2EditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPCNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionToOperatorConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.InformationEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.InformationNameEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OREditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToEventConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.OperatorToFunctionConnectionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.ProvidesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.TriggersEventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.WritesDataToEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.XOREditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcDiagramEditorPlugin;
import edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry;
import edu.unikiel.informatik.aiw.generated.epc.diagram.providers.EpcElementTypes;
import edu.unikiel.informatik.aiw.generated.epc.diagram.providers.EpcParserProvider;

/**
 * @generated
 */
public class EpcNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EpcDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		EpcDiagramEditorPlugin
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
			return EpcDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof EpcNavigatorItem) {
			EpcNavigatorItem navigatorItem = (EpcNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (EpcVisualIDRegistry.getVisualID(view)) {
		case EPCEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://informatik.uni-kiel.de/aiw/epcmodel?EPC", EpcElementTypes.EPC_79); //$NON-NLS-1$
		case ANDEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?AND", EpcElementTypes.AND_1001); //$NON-NLS-1$
		case OREditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?OR", EpcElementTypes.OR_1002); //$NON-NLS-1$
		case InformationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?Information", EpcElementTypes.Information_1003); //$NON-NLS-1$
		case XOREditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?XOR", EpcElementTypes.XOR_1004); //$NON-NLS-1$
		case EventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?Event", EpcElementTypes.Event_1005); //$NON-NLS-1$
		case EPC2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?EPC", EpcElementTypes.EPC_1006); //$NON-NLS-1$
		case FunctionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://informatik.uni-kiel.de/aiw/epcmodel?Function", EpcElementTypes.Function_1007); //$NON-NLS-1$
		case TriggersEventEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?TriggersEvent", EpcElementTypes.TriggersEvent_3001); //$NON-NLS-1$
		case ProvidesDataToEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?ProvidesDataTo", EpcElementTypes.ProvidesDataTo_3002); //$NON-NLS-1$
		case WritesDataToEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?WritesDataTo", EpcElementTypes.WritesDataTo_3003); //$NON-NLS-1$
		case ActivatesFunctionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?ActivatesFunction", EpcElementTypes.ActivatesFunction_3004); //$NON-NLS-1$
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?EventToOperatorConnection", EpcElementTypes.EventToOperatorConnection_3005); //$NON-NLS-1$
		case FunctionToOperatorConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?FunctionToOperatorConnection", EpcElementTypes.FunctionToOperatorConnection_3006); //$NON-NLS-1$
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?OperatorToEventConnection", EpcElementTypes.OperatorToEventConnection_3007); //$NON-NLS-1$
		case OperatorToFunctionConnectionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://informatik.uni-kiel.de/aiw/epcmodel?OperatorToFunctionConnection", EpcElementTypes.OperatorToFunctionConnection_3008); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = EpcDiagramEditorPlugin.getInstance()
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

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
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
		case EPCEditPart.VISUAL_ID:
			return getEPC_79Text(view);
		case ANDEditPart.VISUAL_ID:
			return getAND_1001Text(view);
		case OREditPart.VISUAL_ID:
			return getOR_1002Text(view);
		case InformationEditPart.VISUAL_ID:
			return getInformation_1003Text(view);
		case XOREditPart.VISUAL_ID:
			return getXOR_1004Text(view);
		case EventEditPart.VISUAL_ID:
			return getEvent_1005Text(view);
		case EPC2EditPart.VISUAL_ID:
			return getEPC_1006Text(view);
		case FunctionEditPart.VISUAL_ID:
			return getFunction_1007Text(view);
		case TriggersEventEditPart.VISUAL_ID:
			return getTriggersEvent_3001Text(view);
		case ProvidesDataToEditPart.VISUAL_ID:
			return getProvidesDataTo_3002Text(view);
		case WritesDataToEditPart.VISUAL_ID:
			return getWritesDataTo_3003Text(view);
		case ActivatesFunctionEditPart.VISUAL_ID:
			return getActivatesFunction_3004Text(view);
		case EventToOperatorConnectionEditPart.VISUAL_ID:
			return getEventToOperatorConnection_3005Text(view);
		case FunctionToOperatorConnectionEditPart.VISUAL_ID:
			return getFunctionToOperatorConnection_3006Text(view);
		case OperatorToEventConnectionEditPart.VISUAL_ID:
			return getOperatorToEventConnection_3007Text(view);
		case OperatorToFunctionConnectionEditPart.VISUAL_ID:
			return getOperatorToFunctionConnection_3008Text(view);
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
			EpcDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAND_1001Text(View view) {
		edu.unikiel.informatik.aiw.generated.epc.AND domainModelElement = (edu.unikiel.informatik.aiw.generated.epc.AND) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isShowInEPCEditor());
		} else {
			EpcDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOR_1002Text(View view) {
		edu.unikiel.informatik.aiw.generated.epc.OR domainModelElement = (edu.unikiel.informatik.aiw.generated.epc.OR) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isShowInEPCEditor());
		} else {
			EpcDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1002); //$NON-NLS-1$
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
			EpcDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getXOR_1004Text(View view) {
		edu.unikiel.informatik.aiw.generated.epc.XOR domainModelElement = (edu.unikiel.informatik.aiw.generated.epc.XOR) view
				.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isShowInEPCEditor());
		} else {
			EpcDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEvent_1005Text(View view) {
		IAdaptable hintAdapter = new EpcParserProvider.HintAdapter(
				EpcElementTypes.Event_1005, (view.getElement() != null ? view
						.getElement() : view), EpcVisualIDRegistry
						.getType(EventNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			EpcDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEPC_1006Text(View view) {
		IAdaptable hintAdapter = new EpcParserProvider.HintAdapter(
				EpcElementTypes.EPC_1006, (view.getElement() != null ? view
						.getElement() : view), EpcVisualIDRegistry
						.getType(EPCNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			EpcDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getFunction_1007Text(View view) {
		IAdaptable hintAdapter = new EpcParserProvider.HintAdapter(
				EpcElementTypes.Function_1007,
				(view.getElement() != null ? view.getElement() : view),
				EpcVisualIDRegistry.getType(FunctionNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			EpcDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getTriggersEvent_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProvidesDataTo_3002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getWritesDataTo_3003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getActivatesFunction_3004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEventToOperatorConnection_3005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFunctionToOperatorConnection_3006Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperatorToEventConnection_3007Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperatorToFunctionConnection_3008Text(View view) {
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
		return EPCEditPart.MODEL_ID
				.equals(EpcVisualIDRegistry.getModelID(view));
	}

}
