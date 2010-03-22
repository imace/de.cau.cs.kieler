/**
 * 
 */
package de.cau.cs.kieler.core.ui.examplewizard.manager;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * @author Vertigo
 * 
 */
public class StartExampleManagerActionDelegate implements IObjectActionDelegate {

	private IStructuredSelection selection;
	
	private IWorkbenchPart targetPart; 
	
	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;

	}

	@Override
	public void run(IAction action) {
		IWorkbenchPartSite site = targetPart.getSite();
		IWorkbenchWindow window = site.getWorkbenchWindow();
		ExampleManager manager = new ExampleManager();
		WizardDialog dialog = new WizardDialog(window.getShell(), manager);
		dialog.open();

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection instanceof IStructuredSelection ? (IStructuredSelection) selection
				: null;
	}

}
