package edu.unikiel.rtsys.kieler.kev.animation;

import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.JSVGComponent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

import edu.unikiel.rtsys.kieler.kev.animation.mapping.AnimationMapping;
import edu.unikiel.rtsys.kieler.kev.views.EnvironmentView;

public class AnimationManager extends GVTTreeRendererAdapter{

	AnimationJob animationJob;
	AnimationMapping animationMapping;
	EnvironmentView view;
	int delay = 0;
		
	public AnimationManager(EnvironmentView view) {
		this.view = view;
	}
	
	private void init() {
		
		animationJob = new AnimationJob();
		animationJob.setDelay(delay);
		animationMapping = new AnimationMapping(view);
		
		// taken from original modelgui
		view.getComposite().getSvgCanvas().setDocumentState(JSVGComponent.ALWAYS_DYNAMIC);
		view.getComposite().getSvgCanvas().setDoubleBufferedRendering(false);
		view.getComposite().getSvgCanvas().setDisableInteractions(true);
		// svgCanvas.enableInputMethods(false);
		//this.canvas.setAnimationLimitingCPU(0.5f);
		// svgCanvas.setDoubleBuffered(true);	
	}

	public void start() {
		if(animationJob != null)
			animationJob.schedule();		
	}
	public void stop() {
		if(animationJob != null)
			animationJob.cancel();
	}
	public void suspend() {
		if(animationJob != null)
			animationJob.sleep();
	}
	public void resume(){
		if(animationJob != null)
			animationJob.wakeUp();
	}
	
	public void setDelay(int delay){
		this.delay = delay; // need to store the state of the delay, because Job might be instantiated later
		if(animationJob != null){
			animationJob.setDelay(delay);
		}
	}

/*	
	public void selectionChanged(IWorkbenchPart part, ISelection s) {
		if (s instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) s;
			Object obj = ss.getFirstElement();
			if (obj instanceof IFile) {
				IFile f = (IFile) obj;
				IPath path = (IPath) f.getLocation();
				if (path != null) {
					if (path.toFile().exists()) {
						if (path.getFileExtension().equals("svg") //$NON-NLS-1$
								|| path.getFileExtension().equals("svgz")) { //$NON-NLS-1$
							this.init();
						}
					}
				}
			}
		}
	}
*/	
	public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
		System.out.println("Rendering finished");
		this.init();
	}

	
	
	
}
