package de.cau.cs.kieler.kiml.viewer.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.viewer.KimlViewerPlugin;

/**
 * Label provider for execution times retrieved from KIELER progress
 * monitors.
 * 
 * @author msp
 */
public class ExecutionLabelProvider extends LabelProvider {

	/** path to the image used for elements */
	private static final String IMAGE_PATH = "/icons/execution.gif";
	
	/** the image used for each element */
	private Image elementImage;
	
	/**
	 * Creates an execution label provider.
	 */
	public ExecutionLabelProvider() {
		elementImage = KimlViewerPlugin.imageDescriptorFromPlugin(
				KimlViewerPlugin.PLUGIN_ID, IMAGE_PATH).createImage();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if (element instanceof IKielerProgressMonitor)
			return elementImage;
		else return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element instanceof IKielerProgressMonitor) {
			IKielerProgressMonitor monitor = (IKielerProgressMonitor)element;
			String baseText = monitor.getTaskName() + ": ";
			double time = monitor.getExecutionTime();
			if (time >= 1.0)
				return baseText + Double.toString(time) + " s";
			else
				return baseText + Double.toString(time * 1000) + " ms";
		}
		else return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	public void dispose() {
		super.dispose();
		if (elementImage != null)
			elementImage.dispose();
	}

}
