package de.cau.cs.kieler.synccharts.custom.contextMenu;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;

import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateExitActionsCompartmentEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateRegionCompartmentEditPart;
import de.cau.cs.kieler.synccharts.diagram.providers.SyncchartsElementTypes;

public class AddExitActionAction implements IActionDelegate {

	private IStructuredSelection currentSelection;
	private StateEditPart selectedElement;
	private StateExitActionsCompartmentEditPart exitActionsCompartment;
	
	@Override
	public void run(IAction action) {
		
		// Search for exit action compartment
		List<EditPart> compartments = selectedElement.getResizableCompartments();
		for (EditPart editPart : compartments) {
			if (editPart instanceof StateExitActionsCompartmentEditPart) {
				exitActionsCompartment = (StateExitActionsCompartmentEditPart) editPart;
			}
		}
		
		CompoundCommand cc = new CompoundCommand("Add OnExitAction");

		// Create the new action.
		CreateViewRequest actionRequest = CreateViewRequestFactory.getCreateShapeRequest(SyncchartsElementTypes.Action_3005, selectedElement.getDiagramPreferencesHint());

		Command createActionCmd = exitActionsCompartment.getCommand(actionRequest);
		IAdaptable actionViewAdapter = (IAdaptable) ((List) actionRequest.getNewObject()).get(0);

		cc.add(createActionCmd);

		exitActionsCompartment.getDiagramEditDomain().getDiagramCommandStack().execute(cc);

		// put the new action in edit mode
		final EditPartViewer viewer = exitActionsCompartment.getViewer();
		final EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(actionViewAdapter.getAdapter(View.class));
		if (elementPart != null) {
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
						viewer.setSelection(new StructuredSelection(elementPart));
						Request der = new Request(RequestConstants.REQ_DIRECT_EDIT);
						elementPart.performRequest(der);
					}
			});
		}
	}

	// Update variables upon selection change
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		try {
			currentSelection = (IStructuredSelection) selection;
			selectedElement = (StateEditPart) currentSelection.getFirstElement();
			action.setEnabled(true);
			return;
		}
		catch (Exception e) {
			currentSelection = StructuredSelection.EMPTY;
		}
	}

}
