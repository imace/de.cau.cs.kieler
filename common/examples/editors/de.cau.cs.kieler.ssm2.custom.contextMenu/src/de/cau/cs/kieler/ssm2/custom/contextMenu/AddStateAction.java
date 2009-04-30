package de.cau.cs.kieler.ssm2.custom.contextMenu;

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

import de.cau.cs.kieler.ssm2.diagram.edit.parts.Region2EditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.RegionStateCompartmentEditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.StateRegionCompartmentEditPart;
import de.cau.cs.kieler.ssm2.diagram.providers.Ssm2ElementTypes;

public class AddStateAction implements IActionDelegate {

	private IStructuredSelection currentSelection;
	private RegionEditPart selectedElement;
	private RegionStateCompartmentEditPart stateCompartment;
	
	@Override
	public void run(IAction action) {
		
		// Search for region compartment
		List<Object> compartments = selectedElement.getChildren();
		for (Object editPart : compartments) {
			if (editPart instanceof RegionStateCompartmentEditPart) {
				stateCompartment = (RegionStateCompartmentEditPart) editPart;
			}
		}
		
		CompoundCommand cc = new CompoundCommand("Add State");

		// Create the new State
		CreateViewRequest stateRequest = CreateViewRequestFactory.getCreateShapeRequest(Ssm2ElementTypes.State_2012, selectedElement.getDiagramPreferencesHint());

		
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

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		try {
			currentSelection = (IStructuredSelection) selection;
			selectedElement = (RegionEditPart) currentSelection.getFirstElement();
			action.setEnabled(true);
			return;
		}
		catch (Exception e) {
			currentSelection = StructuredSelection.EMPTY;
		}
	}

}
