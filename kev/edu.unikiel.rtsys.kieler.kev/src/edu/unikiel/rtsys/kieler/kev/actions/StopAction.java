package edu.unikiel.rtsys.kieler.kev.actions;

import org.eclipse.jface.action.Action;

import edu.unikiel.rtsys.kieler.kev.animation.AnimationManager;

public class StopAction extends Action {
	
	private AnimationManager animationManager;
	
	public StopAction(AnimationManager animationManager) {
		this.setText("Stop");
		this.setToolTipText("Stop animation run");
		this.setImageDescriptor(edu.unikiel.rtsys.kieler.kev.Activator.getImageDescriptor("icons/media-playback-stop-32.png"));
		this.animationManager = animationManager;
	}
	
	@Override
	public void run() {
		animationManager.stop();
	}
}
