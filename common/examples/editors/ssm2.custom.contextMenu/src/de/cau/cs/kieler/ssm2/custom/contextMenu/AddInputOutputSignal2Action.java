package de.cau.cs.kieler.ssm2.custom.contextMenu;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;

public class AddInputOutputSignal2Action implements IActionDelegate {

	@Override
	public void run(IAction action) {
		System.out.println("Selected InputOutputSignal2.");

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
