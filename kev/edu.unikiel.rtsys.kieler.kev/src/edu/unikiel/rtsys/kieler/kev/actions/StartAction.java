package edu.unikiel.rtsys.kieler.kev.actions;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

import edu.unikiel.rtsys.kieler.kev.animation.AnimationManager;

public class StartAction extends Action {

	AnimationManager animationManager;
	
	public StartAction(AnimationManager animationManager) {
		this.setText("Start");
		this.setToolTipText("Start animation run");
		this.setImageDescriptor(edu.unikiel.rtsys.kieler.kev.Activator.getImageDescriptor("icons/media-playback-start-32.png"));
		this.animationManager = animationManager;
	}
	
	@Override
	public void run() {
		animationManager.start();
	}
	
}
