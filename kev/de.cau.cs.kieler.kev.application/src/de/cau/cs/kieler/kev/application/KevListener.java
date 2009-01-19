package de.cau.cs.kieler.kev.application;

import java.awt.Dimension;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.gvt.GVTTreeRendererListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.kev.helpers.Tools;


/**
 * Listens to events of KEV. It's used for example to listen to new images loaded and
 * then to resize the Application window according to the image size.
 * @author Hauke Fuhrmann, haf
 */
public class KevListener implements GVTTreeRendererListener {

	JSVGCanvas canvas;
	
	public KevListener(JSVGCanvas c) {
		this.canvas = c;
	}

	@Override
	public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
		Tools.setStatusLine("Image rendering finished.");
		this.resizeWindow();
	}
	@Override
	public void gvtRenderingCancelled(GVTTreeRendererEvent arg0) {
		Tools.setStatusLine("Cancelled image rendering.");
	}
	@Override
	public void gvtRenderingFailed(GVTTreeRendererEvent arg0) {
		Tools.setStatusLine("Failed image rendering.");
	}
	@Override
	public void gvtRenderingPrepare(GVTTreeRendererEvent arg0) {
		Tools.setStatusLine("Image loading...");
	}
	@Override
	public void gvtRenderingStarted(GVTTreeRendererEvent arg0) {
		Tools.setStatusLine("Image rendering...");
	}
	
	private void resizeWindow() {
		Tools.setStatusLine("Automatic resizing of frame...");
		try{
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable(){
				@Override
				public void run() {
					try{
					Dimension size = canvas.getPreferredSize();
					if(size != null && size.width > 0 && size.height > 0){
						Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
						shell.setSize(size.width, size.height);
					}
					}catch(Exception e){/*nothing*/}
					finally{
						Tools.setStatusLine("Automatic resizing finished.");
					}
				}
			});
		}catch(Exception e){
			Tools.showDialog("Could not resize window to fit image: ",e);
		}	
	}
}
