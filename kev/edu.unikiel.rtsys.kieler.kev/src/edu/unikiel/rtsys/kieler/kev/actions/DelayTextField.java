package edu.unikiel.rtsys.kieler.kev.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.rtsys.kieler.kev.Activator;
import edu.unikiel.rtsys.kieler.kev.animation.AnimationManager;

public class DelayTextField extends ControlContribution implements KeyListener{

	Text textfield;
	AnimationManager animationManager;
	
	public DelayTextField(AnimationManager animationManager) {
		super("KEV Delay Text Field");
		this.animationManager = animationManager;
	}

	@Override
	protected Control createControl(Composite parent) {
		textfield = new Text(parent,SWT.BORDER);
		textfield.setToolTipText("Delay of steps in run mode (ms)");
		textfield.setText("    500");
		textfield.addKeyListener(this);
		this.updateDelay();
		return textfield;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.character=='\r'){
			updateDelay();
		}			
	}
	@Override
	public void keyReleased(KeyEvent e) {
		/* nothing */
	}
	
	private void updateDelay(){
		try{
			int delay = Integer.parseInt(textfield.getText().trim());
			animationManager.setDelay(delay);			
		}catch(NumberFormatException exc){
			Status s = new Status(Status.ERROR,Activator.PLUGIN_ID,0,"Please enter only integer numbers!",exc);
			ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),"Error",exc.getMessage(),s,IStatus.ERROR);	
		}
	}
}
