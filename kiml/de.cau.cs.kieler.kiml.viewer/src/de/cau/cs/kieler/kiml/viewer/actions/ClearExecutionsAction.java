package de.cau.cs.kieler.kiml.viewer.actions;

import org.eclipse.jface.action.Action;

import de.cau.cs.kieler.kiml.viewer.KimlViewerPlugin;
import de.cau.cs.kieler.kiml.viewer.Messages;
import de.cau.cs.kieler.kiml.viewer.views.ExecutionView;

/**
 * Action that clears all execution data.
 * 
 * @author msp
 */
public class ClearExecutionsAction extends Action {

	/** identifier string for this action */
    private static final String ACTION_ID = "de.cau.cs.kieler.kiml.viewer.clearExecutions";
    /** relative path to the icon to use for this action */
    private static final String ICON_PATH = "icons/clear_exec.gif";

	/** the execution view associated with this action */
    private ExecutionView view;
    
	/**
	 * Creates an image export action for a given layout graph view.
	 * 
	 * @param view execution view that created this action
	 */
	public ClearExecutionsAction(ExecutionView view) {
		this.view = view;
		setId(ACTION_ID);
		setText(Messages.getString("kiml.viewer.8"));
		setToolTipText(Messages.getString("kiml.viewer.9"));
		setImageDescriptor(KimlViewerPlugin.imageDescriptorFromPlugin(
			KimlViewerPlugin.PLUGIN_ID, ICON_PATH));
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		view.clearExecutions();
	}
	
}
