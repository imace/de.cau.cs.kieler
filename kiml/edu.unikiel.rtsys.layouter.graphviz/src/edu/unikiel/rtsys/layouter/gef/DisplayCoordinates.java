package edu.unikiel.rtsys.layouter.gef;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;

public class DisplayCoordinates implements PaintListener, MouseMoveListener, IWorkbenchWindowActionDelegate{

	private boolean activated = false;
	
	@Override
	public void paintControl(PaintEvent e) {
		System.out.println("paintControl");
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseMove(MouseEvent e) {
		System.out.println("mouseMove");
		// TODO Auto-generated method stub
	}

	@Override
	public void run(IAction action) {
		System.out.println("run");
		this.activated = !this.activated;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("selectionChanged");
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() ;
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		System.out.println("dispose");
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		System.out.println("init");
		
	}

	
	
	

}
