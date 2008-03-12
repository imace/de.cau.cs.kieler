package edu.unikiel.rtsys.kieler.kev.animation;

import java.awt.Dimension;

import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.rtsys.kieler.kev.Activator;
import edu.unikiel.rtsys.kieler.kev.Messages;
import edu.unikiel.rtsys.kieler.kev.animation.mapping.AnimationMapping;
import edu.unikiel.rtsys.kieler.kev.extension.AnimationData;
import edu.unikiel.rtsys.kieler.kev.extension.AnimationDataController;
import edu.unikiel.rtsys.kieler.kev.extension.ControlFlowChangeEvent;
import edu.unikiel.rtsys.kieler.kev.extension.ControlFlowEventSource;
import edu.unikiel.rtsys.kieler.kev.extension.DataChangeEvent;
import edu.unikiel.rtsys.kieler.kev.extension.DataChangeListener;
import edu.unikiel.rtsys.kieler.kev.helpers.Tools;
import edu.unikiel.rtsys.kieler.kev.ui.KevPreferencePage;
import edu.unikiel.rtsys.kieler.kev.views.EnvironmentView;

public class AnimationManager extends GVTTreeRendererAdapter implements DataChangeListener{

	//AnimationJob animationJob;
	AnimationMapping animationMapping;
	EnvironmentView view;
	
	//DataChangeEventSource dataChangeEventSource;
	ControlFlowEventSource controlFlowEventSource;
	
	int delay = 0;
	
	/** Implementing singleton pattern */
	private static AnimationManager instance;
	
	public AnimationManager(EnvironmentView view) {
		this.view = view;
		//dataChangeEventSource = new DataChangeEventSource();
		controlFlowEventSource = new ControlFlowEventSource();
		instance = this;
	}
	
	/** Implementing singleton pattern */
	public static AnimationManager getInstance(){
		return instance;
	}
	
	public void init() {
		animationMapping = new AnimationMapping(view);
		System.out.println("DisplayPortSize: "+animationMapping.getDisplayPortSize()+" ControlPortSize: "+animationMapping.getControlPortsize());
		controlFlowEventSource = new ControlFlowEventSource();
		String controllerString = Activator.getDefault().getPreferenceStore().getString(KevPreferencePage.CONTROLLER);
		registerController(controllerString);
		resizeWindow();
	}
	
	private void resizeWindow() {
		try{
			Dimension size = view.getComposite().getSvgCanvas().getSize();
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable(){
				@Override
				public void run() {
					Dimension size = view.getComposite().getSvgCanvas().getPreferredSize();
					Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
					shell.setSize(size.width, size.height);
				}
			});

		}catch(Exception e){
			Tools.showDialog("Could not resize window to fit image: ",e);
		}
		
	}

	public void start() {
		init(); // reload preferences (might have been changed)
		controlFlowEventSource.fireControlFlowChangeEvent(ControlFlowChangeEvent.Type.START, null);
	}
	public void stop() {
		controlFlowEventSource.fireControlFlowChangeEvent(ControlFlowChangeEvent.Type.STOP, null);
	}
	public void step(){
		controlFlowEventSource.fireControlFlowChangeEvent(ControlFlowChangeEvent.Type.STEP, null);
	}

	public void setDelay(int delay){
		this.delay = delay; // need to store the state of the delay, because Job might be instantiated later
		controlFlowEventSource.fireControlFlowChangeEvent(ControlFlowChangeEvent.Type.DELAY, new Integer(delay));
	}

	/**
	 * Callback called when rendering of image has finished. Means a new image was
	 * successfully loaded.
	 */
	public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
		// when a new image was loaded, reinit the animation manager
		System.out.println("Rendering finished"); //$NON-NLS-1$
		this.init();
	}

	/**
	 * Listens to DataChangeEvents that are supposed to indicate that input data
	 * has changed, that should be animated in the graphical representation.
	 */
	@Override
	public void dataChanged(DataChangeEvent e) {
		//System.out.println("Input Data has changed: "+e.getData());
		try {
			view.getComposite().getSvgCanvas().getUpdateManager().getUpdateRunnableQueue()
					.invokeLater(new AnimationRunner(e.getData()));
		} catch(Exception exc){
			/* do nothing */
		}
	}

	@Override
	public void setDataSize(int size) {
		System.out.println("Control data size: "+size);
	}
	
	public AnimationMapping getAnimationMapping() {
		return animationMapping;
	}

	public void registerController(String controllerName) {
		this.controlFlowEventSource.removeControlFlowChangeListeners();
		this.getAnimationMapping().unregisterControlListeners();
		
		// get the available interfaces
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(Messages.extensionPointID);
		for (int i = 0; i < configElements.length; i++) {
			try{
				AnimationDataController animationController = (AnimationDataController)configElements[i].createExecutableExtension("class"); //$NON-NLS-1$
				animationController.removeDataChangeListeners();
				if(animationController.getName().equals(controllerName)){
					// now add listeners to selected controller
					animationController.addDataChangeListener(this);
					this.getAnimationMapping().registerControlListeners(animationController);
					this.controlFlowEventSource.addControlFlowChangeListener(animationController);
					// set size of data
					animationController.setSize(animationMapping.getDisplayPortSize());
				}
			}catch(Exception e){Tools.showDialog("Error at loading a KEV data interface plugin",e);} 
		}
		// set initial delay (will be fired to listeners now they are added)
		this.setDelay(delay);
	}

	
	/**
	 * Very simple runnable that takes data and calls all animations of
	 * the animations stored in the animationMapping.
	 * This is required to do the task asynchronously the Batik way.
	 */
	private class AnimationRunner implements Runnable{
		AnimationData data;
		public AnimationRunner(AnimationData data) {
			this.data = data;
		}
		@Override
		public void run() {
			for (int i = 0; i < animationMapping.getAnimationList().size(); i++) {
				animationMapping.getAnimationList().get(i).doAnimation(data);
			}
		}
	}
	
}
