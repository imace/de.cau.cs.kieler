package de.cau.cs.kieler.ssm2.custom.contextMenu;

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

import de.cau.cs.kieler.ssm2.diagram.edit.parts.RegionEditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.State2EditPart;
import de.cau.cs.kieler.ssm2.diagram.edit.parts.StateEditPart;
import de.cau.cs.kieler.ssm2.diagram.providers.Ssm2ElementTypes;

public class AddEntryAction2Action implements IActionDelegate {

	private IStructuredSelection currentSelection;
	private State2EditPart selectedElement;
	
	@Override
	public void run(IAction action) {
		CompoundCommand cc = new CompoundCommand("Add OnEntryAction");

		// Create the new action.
		CreateViewRequest actionRequest = CreateViewRequestFactory.getCreateShapeRequest(Ssm2ElementTypes.Action_3003, selectedElement.getDiagramPreferencesHint());

		//RegionEditPart regionEditPart = (RegionEditPart) selectedElement.getParent();
		Command createActionCmd = /*regionEditPart*/selectedElement.getCommand(actionRequest);
		IAdaptable actionViewAdapter = (IAdaptable) ((List) actionRequest.getNewObject()).get(0);

		cc.add(createActionCmd);

		selectedElement.getDiagramEditDomain().getDiagramCommandStack().execute(cc);

		// put the new action in edit mode
		final EditPartViewer viewer = selectedElement.getViewer();
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
