package edu.unikiel.rtsys.kieler.kiml.ui;

import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

/**
 * An Action that will execute a KIELER arrange layouting command for any
 * type of GEF editor. Will be only available for GEF based editors, e.g. 
 * GMF or GEMS editors.
 * 
 * This is intended to replace the KimlArrangeAction, which is an GMF specific
 * action contribution.
 * 
 * @author haf
 *
 */
public class KimlArrangeActionGenericGef implements IWorkbenchWindowActionDelegate{

	@Override
	public void dispose() {
		/* empty */		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		/* empty */
	}

	/**
	 * Run method implementing the actual layout execution.
	 */
	@Override
	public void run(IAction action) {
		System.out.println("Action");
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(activeEditor instanceof GraphicalEditor){
			GraphicalEditor graphicalEditor = (GraphicalEditor)activeEditor;
			/* TODO: implement layout behavior here
				problem: get edit parts for layouting from GraphicalEditor
			*/
		}
			
	}

	/**
	 * Enables only for GEF editors
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(activeEditor instanceof GraphicalEditor)
			action.setEnabled(true);
		else
			action.setEnabled(false);
	}	
}
