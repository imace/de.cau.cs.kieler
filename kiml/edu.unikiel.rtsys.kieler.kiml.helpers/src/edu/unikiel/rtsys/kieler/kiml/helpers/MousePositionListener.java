package edu.unikiel.rtsys.kieler.kiml.helpers;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

public class MousePositionListener implements Listener {

	public MousePositionListener() {
		System.out.println("Registering MouseListener...");
	}
	
	/** handles SWT.MouseMove events */
	@Override
	public void handleEvent(Event event) {
		// get the current mouse position at the whole display
		Point position = Display.getCurrent().getCursorLocation();
		// try to calculate the relative position to the current graphical editor
		try{
			// get the active editor
			IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			// check if it is a graphical editor
			if(editor instanceof DiagramDocumentEditor){
				DiagramDocumentEditor diagEditor = (DiagramDocumentEditor)editor;
				GraphicalViewer diagram = diagEditor.getDiagramGraphicalViewer();
				// calc the relative position
				position = diagram.getControl().toControl(position);
			}
		}catch(Exception e){/*nothing */}
		
		String pos = position + "";
		
		// really ugly stuff to write to the StatusLine in any view
		// TODO: find a better way to contribute to the status line
		IViewReference views[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (int i = 0; i < views.length; i++) {
			try{
				IStatusLineManager line = views[i].getView(false).getViewSite().getActionBars().getStatusLineManager();
				line.setMessage(pos);
				line.update(true);
			}catch(Exception e){/*nothing */}
		}
		
		return;
	}

}
