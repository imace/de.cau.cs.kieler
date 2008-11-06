package edu.unikiel.rtsys.kieler.kiml.helpers;

import org.eclipse.swt.SWT;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Startup class that implements the startup extension point of eclipse. The method
 * earlyStartup is called by eclipse at startup and initializes all stuff of this
 * helpers plugin.
 * 
 * @author haf
 *
 */
public class HelpersStartup implements IStartup {

	/**
	 * Called by Eclipse at startup. Used to init this helpers plugin.
	 */
	@Override
	public void earlyStartup() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable() {
			   public void run() {
				   // TODO: remove this stuff entirely
				   //workbench.getDisplay().addFilter(SWT.MouseMove, new MousePositionListener());
			   }
			 });
		
	}

}
