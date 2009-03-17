package de.cau.cs.kieler.kiml.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;

/**
 * A handler to support any arbitrary test. Simply do whatever you like here.
 * It's intended to be mapped to some toolbar button in order to 
 * trigger some function for testing from the UI.
 * @author haf
 *
 */
public class ArbitraryTestHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// test to display an Error dialog with a message and an exception
		NumberFormatException exc = new NumberFormatException("My little Exception message");
		StatusManager.getManager().handle(
			      new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID, "My status error message", exc),
			      StatusManager.BLOCK);
		return null;
	}

}
