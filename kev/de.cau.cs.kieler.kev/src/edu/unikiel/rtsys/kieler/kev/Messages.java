package edu.unikiel.rtsys.kieler.kev;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "edu.unikiel.rtsys.kieler.kev.messages"; //$NON-NLS-1$
	public static String extensionPointID;
	public static String Refresh;
	public static String ReloadSVGImage;
	public static String ViewTitle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
