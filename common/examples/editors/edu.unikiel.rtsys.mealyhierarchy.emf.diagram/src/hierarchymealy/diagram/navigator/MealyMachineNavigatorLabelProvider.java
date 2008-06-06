package hierarchymealy.diagram.navigator;

import hierarchymealy.HierarchyMealyMachine;
import hierarchymealy.diagram.edit.parts.CompositeState2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateEditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateName2EditPart;
import hierarchymealy.diagram.edit.parts.CompositeStateNameEditPart;
import hierarchymealy.diagram.edit.parts.EdgeEditPart;
import hierarchymealy.diagram.edit.parts.EdgeTriggerActionEditPart;
import hierarchymealy.diagram.edit.parts.HierarchyMealyMachineEditPart;
import hierarchymealy.diagram.edit.parts.State2EditPart;
import hierarchymealy.diagram.edit.parts.StateEditPart;
import hierarchymealy.diagram.edit.parts.StateName2EditPart;
import hierarchymealy.diagram.edit.parts.StateNameEditPart;
import hierarchymealy.diagram.part.MealyMachineDiagramEditorPlugin;
import hierarchymealy.diagram.part.MealyMachineVisualIDRegistry;
import hierarchymealy.diagram.providers.MealyMachineElementTypes;
import hierarchymealy.diagram.providers.MealyMachineParserProvider;

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

/**
 * @generated
 */
public class MealyMachineNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MealyMachineDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		MealyMachineDiagramEditorPlugin
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
		if (element instanceof MealyMachineNavigatorItem
				&& !isOwnView(((MealyMachineNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof MealyMachineNavigatorGroup) {
			MealyMachineNavigatorGroup group = (MealyMachineNavigatorGroup) element;
			return MealyMachineDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof MealyMachineNavigatorItem) {
			MealyMachineNavigatorItem navigatorItem = (MealyMachineNavigatorItem) element;
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
		switch (MealyMachineVisualIDRegistry.getVisualID(view)) {
		case HierarchyMealyMachineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.informatik.uni-kiel.de/rtsys/hmealy?HierarchyMealyMachine", MealyMachineElementTypes.HierarchyMealyMachine_1000); //$NON-NLS-1$
		case CompositeStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.informatik.uni-kiel.de/rtsys/hmealy?CompositeState", MealyMachineElementTypes.CompositeState_2001); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.informatik.uni-kiel.de/rtsys/hmealy?State", MealyMachineElementTypes.State_2002); //$NON-NLS-1$
		case State2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.informatik.uni-kiel.de/rtsys/hmealy?State", MealyMachineElementTypes.State_3001); //$NON-NLS-1$
		case CompositeState2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.informatik.uni-kiel.de/rtsys/hmealy?CompositeState", MealyMachineElementTypes.CompositeState_3002); //$NON-NLS-1$
		case EdgeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.informatik.uni-kiel.de/rtsys/hmealy?Edge", MealyMachineElementTypes.Edge_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MealyMachineDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& MealyMachineElementTypes.isKnownElementType(elementType)) {
			image = MealyMachineElementTypes.getImage(elementType);
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
		if (element instanceof MealyMachineNavigatorGroup) {
			MealyMachineNavigatorGroup group = (MealyMachineNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof MealyMachineNavigatorItem) {
			MealyMachineNavigatorItem navigatorItem = (MealyMachineNavigatorItem) element;
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
		switch (MealyMachineVisualIDRegistry.getVisualID(view)) {
		case HierarchyMealyMachineEditPart.VISUAL_ID:
			return getHierarchyMealyMachine_1000Text(view);
		case CompositeStateEditPart.VISUAL_ID:
			return getCompositeState_2001Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002Text(view);
		case State2EditPart.VISUAL_ID:
			return getState_3001Text(view);
		case CompositeState2EditPart.VISUAL_ID:
			return getCompositeState_3002Text(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getHierarchyMealyMachine_1000Text(View view) {
		HierarchyMealyMachine domainModelElement = (HierarchyMealyMachine) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			MealyMachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCompositeState_2001Text(View view) {
		IAdaptable hintAdapter = new MealyMachineParserProvider.HintAdapter(
				MealyMachineElementTypes.CompositeState_2001, (view
						.getElement() != null ? view.getElement() : view),
				MealyMachineVisualIDRegistry
						.getType(CompositeStateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MealyMachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getState_2002Text(View view) {
		IAdaptable hintAdapter = new MealyMachineParserProvider.HintAdapter(
				MealyMachineElementTypes.State_2002,
				(view.getElement() != null ? view.getElement() : view),
				MealyMachineVisualIDRegistry
						.getType(StateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MealyMachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getState_3001Text(View view) {
		IAdaptable hintAdapter = new MealyMachineParserProvider.HintAdapter(
				MealyMachineElementTypes.State_3001,
				(view.getElement() != null ? view.getElement() : view),
				MealyMachineVisualIDRegistry
						.getType(StateName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MealyMachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCompositeState_3002Text(View view) {
		IAdaptable hintAdapter = new MealyMachineParserProvider.HintAdapter(
				MealyMachineElementTypes.CompositeState_3002, (view
						.getElement() != null ? view.getElement() : view),
				MealyMachineVisualIDRegistry
						.getType(CompositeStateName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MealyMachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEdge_4001Text(View view) {
		IAdaptable hintAdapter = new MealyMachineParserProvider.HintAdapter(
				MealyMachineElementTypes.Edge_4001,
				(view.getElement() != null ? view.getElement() : view),
				MealyMachineVisualIDRegistry
						.getType(EdgeTriggerActionEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			MealyMachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

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
		return HierarchyMealyMachineEditPart.MODEL_ID
				.equals(MealyMachineVisualIDRegistry.getModelID(view));
	}

}
