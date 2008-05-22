package edu.unikiel.rtsys.kieler.kiml.helpers;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;


public class MousePositionListenerAdderAction implements
		IWorkbenchWindowActionDelegate {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable() {
			   public void run() {
				   workbench.getDisplay().addFilter(SWT.MouseMove, new MousePositionListener());
			   }
			 });
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
