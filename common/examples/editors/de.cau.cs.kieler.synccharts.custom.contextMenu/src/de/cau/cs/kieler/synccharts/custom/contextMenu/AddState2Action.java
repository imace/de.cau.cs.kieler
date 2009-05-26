package de.cau.cs.kieler.synccharts.custom.contextMenu;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
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

import de.cau.cs.kieler.synccharts.diagram.edit.parts.Region2EditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.RegionStateCompartmentEditPart;
import de.cau.cs.kieler.synccharts.diagram.edit.parts.StateRegionCompartmentEditPart;
import de.cau.cs.kieler.synccharts.diagram.providers.SyncchartsElementTypes;

public class AddState2Action implements IActionDelegate {

	private IStructuredSelection currentSelection;
	private Region2EditPart selectedElement;
	private RegionStateCompartmentEditPart stateCompartment;
	
	@Override
	public void run(IAction action) {
		
		// Search for StateCompartment
		List<EditPart> compartments = selectedElement.getResizableCompartments();
		for (EditPart editPart : compartments) {
			if (editPart instanceof RegionStateCompartmentEditPart) {
				stateCompartment = (RegionStateCompartmentEditPart) editPart;
			}
		}
		
		CompoundCommand cc = new CompoundCommand("Add State");

		// Create the new State
		CreateViewRequest stateRequest = CreateViewRequestFactory.getCreateShapeRequest(SyncchartsElementTypes.State_3009, selectedElement.getDiagramPreferencesHint());

		Command createStateCmd = stateCompartment.getCommand(stateRequest);
		IAdaptable stateViewAdapter = (IAdaptable) ((List) stateRequest.getNewObject()).get(0);
		
		cc.add(createStateCmd);

		stateCompartment.getDiagramEditDomain().getDiagramCommandStack().execute(cc);

		// Put the new State in edit mode
		final EditPartViewer viewer = stateCompartment.getViewer();
		final EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(stateViewAdapter.getAdapter(View.class));
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
			selectedElement = (Region2EditPart) currentSelection.getFirstElement();
			action.setEnabled(true);
			return;
		}
		catch (Exception e) {
			currentSelection = StructuredSelection.EMPTY;
		}
	}

}
