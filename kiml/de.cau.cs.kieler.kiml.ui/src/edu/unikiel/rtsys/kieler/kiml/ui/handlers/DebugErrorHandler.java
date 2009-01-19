package edu.unikiel.rtsys.kieler.kiml.ui.handlers;

import org.eclipse.ui.statushandlers.WorkbenchErrorHandler;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;

/**
 * Custom StatusHandler to react upon handle status requests.
 * This handler customizes the view of error and status dialogs
 * such that as much information is presented to the user as 
 * possible. The default WorkbenchErrorHandler would hide 
 * Exception stack traces for example. This error handler will
 * make them available to the user.
 * 
 * @author haf
 *
 */
public class DebugErrorHandler extends WorkbenchErrorHandler {

	@Override
	protected void configureStatusDialog(
			WorkbenchStatusDialogManager statusDialog) {
		super.configureStatusDialog(statusDialog);
		// enable the debug area of dialogs, which is
		// existing in the default dialogs, but disabled by default
		statusDialog.enableDefaultSupportArea(true);
	}
}
