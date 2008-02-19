package edu.unikiel.rtsys.kieler.kev.actions;

import org.eclipse.jface.action.Action;

import edu.unikiel.rtsys.kieler.kev.animation.AnimationManager;

public class StepAction extends Action {
	
	private AnimationManager animationManager;
	private boolean isPaused;
	
	public StepAction(AnimationManager animationManager) {
		this.setText("Step");
		this.setToolTipText("Step one cycle");
		this.setImageDescriptor(edu.unikiel.rtsys.kieler.kev.Activator.getImageDescriptor("icons/media-skip-forward-32.png"));
		this.animationManager = animationManager;
		this.isPaused = false;
	}
	
	@Override
	public void run() {
		if(this.isPaused == true)
			animationManager.resume();
		else
			animationManager.suspend();
		this.isPaused = !this.isPaused;
	}
}
