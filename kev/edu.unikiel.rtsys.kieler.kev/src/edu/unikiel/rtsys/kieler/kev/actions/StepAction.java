package edu.unikiel.rtsys.kieler.kev.actions;

import org.eclipse.jface.action.Action;

import edu.unikiel.rtsys.kieler.kev.animation.AnimationManager;

public class StepAction extends Action {
	
	private boolean isPaused;
	
	public StepAction() {
		this.setText("Step");
		this.setToolTipText("Step one cycle");
		this.setImageDescriptor(edu.unikiel.rtsys.kieler.kev.KevPlugin.getImageDescriptor("icons/media-skip-forward-32.png"));
		this.isPaused = false;
	}
	
	@Override
	public void run() {
		AnimationManager.getInstance().step();
	}
}
