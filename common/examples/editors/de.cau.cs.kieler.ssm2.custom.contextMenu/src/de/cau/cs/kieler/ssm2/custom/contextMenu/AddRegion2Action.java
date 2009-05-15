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

import de.cau.cs.kieler.ssm2.diagram.edit.parts.State2EditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.StateRegionCompartment2EditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.StateRegionCompartmentEditPart;
import de.cau.cs.kieler.ssm2.diagram.providers.Ssm2ElementTypes;

public class AddRegion2Action implements IActionDelegate {

	private IStructuredSelection currentSelection;
	private State2EditPart selectedElement;
	private StateRegionCompartment2EditPart regionCompartment;
	
	@Override
	public void run(IAction action) {
		
		// Search for region compartment
		List<EditPart> compartments = selectedElement.getResizableCompartments();
		for (EditPart editPart : compartments) {
			if (editPart instanceof StateRegionCompartment2EditPart) {
				regionCompartment = (StateRegionCompartment2EditPart) editPart;
			}
		}
		
		CompoundCommand cc = new CompoundCommand("Add Region");

		// Create the new Region
		CreateViewRequest regionRequest = CreateViewRequestFactory.getCreateShapeRequest(Ssm2ElementTypes.Region_3006, selectedElement.getDiagramPreferencesHint());

		
		Command createRegionCmd = regionCompartment.getCommand(regionRequest);
		IAdaptable regionViewAdapter = (IAdaptable) ((List) regionRequest.getNewObject()).get(0);
		
		cc.add(createRegionCmd);

		regionCompartment.getDiagramEditDomain().getDiagramCommandStack().execute(cc);

		// Put the new Region in edit mode
		final EditPartViewer viewer = regionCompartment.getViewer();
		final EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(regionViewAdapter.getAdapter(View.class));
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
			selectedElement = (State2EditPart) currentSelection.getFirstElement();
			action.setEnabled(true);
			return;
		}
		catch (Exception e) {
			currentSelection = StructuredSelection.EMPTY;
		}
	}

}
