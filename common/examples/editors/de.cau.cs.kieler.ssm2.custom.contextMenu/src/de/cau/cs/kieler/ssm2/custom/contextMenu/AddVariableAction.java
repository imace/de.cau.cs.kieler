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

import de.cau.cs.kieler.ssm2.diagram.edit.parts.StateEditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.StateRegionCompartmentEditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.StateVariableCompartmentEditPart;
import de.cau.cs.kieler.ssm2.diagram.providers.Ssm2ElementTypes;

public class AddVariableAction implements IActionDelegate {

	private IStructuredSelection currentSelection;
	private StateEditPart selectedElement;
	private StateVariableCompartmentEditPart variableCompartment;
	
	@Override
	public void run(IAction action) {
		
		// Search for variable compartment
		List<EditPart> compartments = selectedElement.getResizableCompartments();
		for (EditPart editPart : compartments) {
			if (editPart instanceof StateVariableCompartmentEditPart) {
				variableCompartment = (StateVariableCompartmentEditPart) editPart;
			}
		}
		
		CompoundCommand cc = new CompoundCommand("Add Variable");

		// Create the new Variable
		CreateViewRequest variableRequest = CreateViewRequestFactory.getCreateShapeRequest(Ssm2ElementTypes.Variable_3010, selectedElement.getDiagramPreferencesHint());

		//RegionEditPart regionEditPart = (RegionEditPart) selectedElement.getParent();
		Command createVariableCmd = /*regionEditPart*/variableCompartment.getCommand(variableRequest);
		IAdaptable variableViewAdapter = (IAdaptable) ((List) variableRequest.getNewObject()).get(0);
		
		cc.add(createVariableCmd);

		variableCompartment.getDiagramEditDomain().getDiagramCommandStack().execute(cc);

		// Put the new Variable in edit mode
		final EditPartViewer viewer = variableCompartment.getViewer();
		final EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(variableViewAdapter.getAdapter(View.class));
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
			selectedElement = (StateEditPart) currentSelection.getFirstElement();
			action.setEnabled(true);
			return;
		}
		catch (Exception e) {
			currentSelection = StructuredSelection.EMPTY;
		}
	}

}

