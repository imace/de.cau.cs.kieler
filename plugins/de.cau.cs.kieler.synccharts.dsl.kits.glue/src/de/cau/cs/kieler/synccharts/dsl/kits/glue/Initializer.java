/**
 * 
 */
package de.cau.cs.kieler.synccharts.dsl.kits.glue;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.synccharts.dsl.kits.glue.concurrency.ConcurrentModificationObserver;

/**
 * @author oba
 * 
 */
public class Initializer implements IStartup {

	public void earlyStartup() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage activePage = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				activePage.addPartListener(new ConcurrentModificationObserver(
						activePage));
			}
		});
	}

}
