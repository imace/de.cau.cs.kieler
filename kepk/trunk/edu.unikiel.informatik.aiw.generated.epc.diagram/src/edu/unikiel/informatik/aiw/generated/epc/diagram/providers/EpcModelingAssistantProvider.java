package edu.unikiel.informatik.aiw.generated.epc.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EPCEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.EventEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.FunctionEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.edit.parts.InformationEditPart;
import edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcDiagramEditorPlugin;
import edu.unikiel.informatik.aiw.generated.epc.diagram.part.Messages;

/**
 * @generated
 */
public class EpcModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof EPCEditPart) {
			List types = new ArrayList();
			types.add(EpcElementTypes.AND_1001);
			types.add(EpcElementTypes.OR_1002);
			types.add(EpcElementTypes.Information_1003);
			types.add(EpcElementTypes.XOR_1004);
			types.add(EpcElementTypes.Event_1005);
			types.add(EpcElementTypes.EPC_1006);
			types.add(EpcElementTypes.Function_1007);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InformationEditPart) {
			List types = new ArrayList();
			types.add(EpcElementTypes.ProvidesDataTo_3002);
			return types;
		}
		if (sourceEditPart instanceof EventEditPart) {
			List types = new ArrayList();
			types.add(EpcElementTypes.ActivatesFunction_3004);
			types.add(EpcElementTypes.EventToOperatorConnection_3005);
			return types;
		}
		if (sourceEditPart instanceof FunctionEditPart) {
			List types = new ArrayList();
			types.add(EpcElementTypes.TriggersEvent_3001);
			types.add(EpcElementTypes.WritesDataTo_3003);
			types.add(EpcElementTypes.FunctionToOperatorConnection_3006);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InformationEditPart) {
			List types = new ArrayList();
			types.add(EpcElementTypes.WritesDataTo_3003);
			return types;
		}
		if (targetEditPart instanceof EventEditPart) {
			List types = new ArrayList();
			types.add(EpcElementTypes.TriggersEvent_3001);
			types.add(EpcElementTypes.OperatorToEventConnection_3007);
			return types;
		}
		if (targetEditPart instanceof FunctionEditPart) {
			List types = new ArrayList();
			types.add(EpcElementTypes.ProvidesDataTo_3002);
			types.add(EpcElementTypes.ActivatesFunction_3004);
			types.add(EpcElementTypes.OperatorToFunctionConnection_3008);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InformationEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof FunctionEditPart) {
				types.add(EpcElementTypes.ProvidesDataTo_3002);
			}
			return types;
		}
		if (sourceEditPart instanceof EventEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof FunctionEditPart) {
				types.add(EpcElementTypes.ActivatesFunction_3004);
			}
			return types;
		}
		if (sourceEditPart instanceof FunctionEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof EventEditPart) {
				types.add(EpcElementTypes.TriggersEvent_3001);
			}
			if (targetEditPart instanceof InformationEditPart) {
				types.add(EpcElementTypes.WritesDataTo_3003);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof InformationEditPart) {
			List types = new ArrayList();
			if (relationshipType == EpcElementTypes.WritesDataTo_3003) {
				types.add(EpcElementTypes.Function_1007);
			}
			return types;
		}
		if (targetEditPart instanceof EventEditPart) {
			List types = new ArrayList();
			if (relationshipType == EpcElementTypes.TriggersEvent_3001) {
				types.add(EpcElementTypes.Function_1007);
			}
			return types;
		}
		if (targetEditPart instanceof FunctionEditPart) {
			List types = new ArrayList();
			if (relationshipType == EpcElementTypes.ProvidesDataTo_3002) {
				types.add(EpcElementTypes.Information_1003);
			}
			if (relationshipType == EpcElementTypes.ActivatesFunction_3004) {
				types.add(EpcElementTypes.Event_1005);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof InformationEditPart) {
			List types = new ArrayList();
			if (relationshipType == EpcElementTypes.ProvidesDataTo_3002) {
				types.add(EpcElementTypes.Function_1007);
			}
			return types;
		}
		if (sourceEditPart instanceof EventEditPart) {
			List types = new ArrayList();
			if (relationshipType == EpcElementTypes.ActivatesFunction_3004) {
				types.add(EpcElementTypes.Function_1007);
			}
			return types;
		}
		if (sourceEditPart instanceof FunctionEditPart) {
			List types = new ArrayList();
			if (relationshipType == EpcElementTypes.TriggersEvent_3001) {
				types.add(EpcElementTypes.Event_1005);
			}
			if (relationshipType == EpcElementTypes.WritesDataTo_3003) {
				types.add(EpcElementTypes.Information_1003);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				EpcDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.EpcModelingAssistantProviderMessage);
		dialog.setTitle(Messages.EpcModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
