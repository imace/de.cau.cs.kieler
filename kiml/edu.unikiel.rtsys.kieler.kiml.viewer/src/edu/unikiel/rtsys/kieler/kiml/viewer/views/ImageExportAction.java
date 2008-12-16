package edu.unikiel.rtsys.kieler.kiml.viewer.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import edu.unikiel.rtsys.kieler.kiml.viewer.Activator;
import edu.unikiel.rtsys.kieler.kiml.viewer.Messages;

/**
 * Action that exports the currently displayed layout graph into an
 * image file.
 * 
 * @author msp
 */
public class ImageExportAction extends Action {

	/** identifier string for this action */
    private static final String ACTION_ID = "edu.unikiel.rtsys.kieler.kiml.viewer.imageExport";
    /** relative path to the icon to use for this action */
    private static final String ICON_PATH = "icons/pngfile.gif";
    /** preference identifier for the last used file name */
    private static final String LAST_FILE_NAME_PREF = "kiml.viewer.lastFileName";
	
	/** the layout graph view associated with this action */
	private LayoutGraphView view;
	
	/**
	 * Creates an image export action for a given layout graph view.
	 * 
	 * @param view layout graph view that created this action
	 */
	public ImageExportAction(LayoutGraphView view) {
		this.view = view;
		setId(ACTION_ID);
		setText(Messages.getString("kiml.viewer.2"));
		setToolTipText(Messages.getString("kiml.viewer.3"));
		setImageDescriptor(Activator.imageDescriptorFromPlugin(
			Activator.PLUGIN_ID, ICON_PATH));
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		LayoutGraphCanvas canvas = view.getActiveCanvas();
		if (canvas != null) {
			// create an image and paint the layout graph
			Point size = canvas.getSize();
			Image image = new Image(canvas.getDisplay(), size.x, size.y);
			canvas.paintLayoutGraph(new GC(image));
			final ImageLoader imageLoader = new ImageLoader();
			ImageData[] imageData = new ImageData[] { image.getImageData() };
			imageLoader.data = imageData;
			
			// save the image into the selected file
			final String fileName = getFileName(canvas.getDisplay());
			if (fileName != null) {
				Job saveJob = new Job(Messages.getString("kiml.viewer.6")) {
					protected IStatus run(IProgressMonitor monitor) {
						try {
							monitor.beginTask(Messages.getString("kiml.viewer.6"),
									IProgressMonitor.UNKNOWN);
							imageLoader.save(fileName, SWT.IMAGE_PNG);
							return new Status(IStatus.INFO, Activator.PLUGIN_ID,
									0, "OK", null);
						} catch (SWTException exception) {
							return new Status(IStatus.ERROR, Activator.PLUGIN_ID, exception.code,
									Messages.getString("kiml.viewer.7"), exception);
						}
						finally {
							monitor.done();
						}
					}
				};
				IProgressMonitor monitor = Job.getJobManager().createProgressGroup();
				saveJob.setProgressGroup(monitor, IProgressMonitor.UNKNOWN);
				saveJob.setPriority(Job.SHORT);
				saveJob.setUser(true);
				saveJob.schedule();
			}
		}
	}
	
	/**
	 * Opens a file dialog for the user to choose an output file for
	 * the exported image.
	 * 
	 * @param display display to use as parent for the file dialog
	 * @return file name, or null if no file was selected
	 */
	private static String getFileName(Display display) {
		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		
		// create and configure file dialog
		FileDialog fileDialog = new FileDialog(display.getActiveShell(), SWT.SAVE);
		String[] extensions = new String[] { "*.png" };
		fileDialog.setFilterExtensions(extensions);
		String[] names = new String[] { Messages.getString("kiml.viewer.5") };
		fileDialog.setFilterNames(names);
		fileDialog.setOverwrite(true);
		fileDialog.setText(Messages.getString("kiml.viewer.4"));
		fileDialog.setFileName(preferenceStore.getString(LAST_FILE_NAME_PREF));
		
		// open the file dialog and check the output
		String fileName = checkFileName(fileDialog.open());
		
		if (fileName != null)
			preferenceStore.setValue(LAST_FILE_NAME_PREF, fileName);
		return fileName;
	}
	
	/**
	 * Checks whether the extension of the given file name is compatible
	 * with the PNG format and changes it if needed.
	 * 
	 * @param fileName file name given by the user
	 * @return file name with .png as extension
	 */
	private static String checkFileName(String fileName) {
		if (fileName == null)
			return null;
		else {
			String nameCopy = new String(fileName).toLowerCase();
			if (nameCopy.endsWith(".png"))
				return fileName;
			else if (nameCopy.endsWith(".pn"))
				return fileName + "g";
			else if (nameCopy.endsWith(".p"))
				return fileName + "ng";
			else if (nameCopy.endsWith("."))
				return fileName + "png";
			else
				return fileName + ".png";
		}
	}

}
