package com.dlsc.batik.viewer;

import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import com.dlsc.batik.preferences.PrettyPrintPreferencePage;
import com.dlsc.batik.preferences.SlideshowPreferencePage;

/**
 * The main plugin class to be used in the desktop.
 * 
 * @author Dirk Lemmermann
 */
public class BatikUIPlugin extends AbstractUIPlugin {
	//The shared instance.
	private static BatikUIPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
    public static final String IMG_BATIK_16 = "BATIK-SMALL"; //$NON-NLS-1$
    public static final String IMG_BATIK = "BATIK"; //$NON-NLS-1$
    public static final String IMG_EXPORTRASTER_WIZARD = "EXPORT"; //$NON-NLS-1$
	public static final String IMG_SAMPLE_WIZARD = "SAMPLES"; //$NON-NLS-1$
    public static final String IMG_SVG_FILE = "SVG-FILE"; //$NON-NLS-1$
    public static final String IMG_REFRESH = "REFRESH"; //$NON-NLS-1$
    public static final String IMG_PRINT = "PRINT"; //$NON-NLS-1$
    public static final String IMG_DONATE = "DONATE"; //$NON-NLS-1$

    public static final String DONATION_URL = "http://sourceforge.net/donate/index.php?group_id=107780"; //$NON-NLS-1$

    /**
	 * The constructor.
	 */
	public BatikUIPlugin() {
		super();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		plugin = this;
		try {
			resourceBundle= ResourceBundle.getBundle("svgviewer.SvgViewerPluginResources"); //$NON-NLS-1$
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * Returns the shared instance.
	 */
	public static BatikUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the workspace instance.
	 */
	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle= BatikUIPlugin.getDefault().getResourceBundle();
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	protected void initializeImageRegistry(ImageRegistry registry) {
        registerImage(registry, IMG_BATIK_16,"batik-small.gif"); //$NON-NLS-1$
        registerImage(registry, IMG_BATIK,"batik.gif"); //$NON-NLS-1$
        registerImage(registry, IMG_EXPORTRASTER_WIZARD,"exportraster_wiz.gif"); //$NON-NLS-1$
        registerImage(registry, IMG_SAMPLE_WIZARD,"sample_wiz.gif"); //$NON-NLS-1$
        registerImage(registry, IMG_SVG_FILE,"file_svg.gif"); //$NON-NLS-1$
        registerImage(registry, IMG_REFRESH,"refresh.gif"); //$NON-NLS-1$
        registerImage(registry, IMG_PRINT,"print.gif"); //$NON-NLS-1$
        registerImage(registry, IMG_DONATE,"donate.jpg"); //$NON-NLS-1$
	}

	private void registerImage(ImageRegistry registry, String key, String fileName) {
		try {
			IPath path = new Path("icons/" + fileName); //$NON-NLS-1$
			URL url = find(path);
			if (url != null) {
				ImageDescriptor desc = ImageDescriptor.createFromURL(url);
				registry.put(key, desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Image getImage(String key) {
		return getImageRegistry().get(key);
	}

	public ImageDescriptor getImageDescriptor(String key) {
		return getImageRegistry().getDescriptor(key);
	}
		
	public void initializeDefaultPreferences(IPreferenceStore store) {
		store.setDefault(PrettyPrintPreferencePage.P_NEWLINE, "lf"); //$NON-NLS-1$
		store.setDefault(PrettyPrintPreferencePage.P_TABWIDTH, "4"); //$NON-NLS-1$
		store.setDefault(PrettyPrintPreferencePage.P_DOCWIDTH, "80"); //$NON-NLS-1$
		store.setDefault(PrettyPrintPreferencePage.P_NOFORMAT, false);
		store.setDefault(PrettyPrintPreferencePage.P_XMLDECL, "<?xml version=\"1.0\" standalone=\"no\"?>"); //$NON-NLS-1$
		store.setDefault(PrettyPrintPreferencePage.P_DOCTYPE, "leave");  // "leave", "change", "remove" //$NON-NLS-1$
		store.setDefault(PrettyPrintPreferencePage.P_PUBLICID, "-//W3C//DTD SVG 1.1//EN"); //$NON-NLS-1$
		store.setDefault(PrettyPrintPreferencePage.P_SYSTEMID, "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"); //$NON-NLS-1$

		store.setDefault(SlideshowPreferencePage.P_FRAME_TIME, 5);
		store.setDefault(SlideshowPreferencePage.P_TRANSITION_TIME, 5);
		store.setDefault(SlideshowPreferencePage.P_WINDOW_WIDTH, 600);
		store.setDefault(SlideshowPreferencePage.P_WINDOW_HEIGHT, 600);
		store.setDefault(SlideshowPreferencePage.P_FULL_SCREEN, true);
	}
}
