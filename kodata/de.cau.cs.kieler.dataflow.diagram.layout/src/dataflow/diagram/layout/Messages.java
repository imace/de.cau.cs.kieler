package dataflow.diagram.layout;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Messages class for language specific strings.
 * 
 * @author msp
 */
public class Messages {
	
	private static final String BUNDLE_NAME = "dataflow.diagram.layout.messages"; //$NON-NLS-1$
	private static ResourceBundle resourceBundle = null;

	/**
	 * Returns the string for a given message key.
	 * 
	 * @param key key to look up
	 * @return localized string
	 */
	public static String getString(String key) {
		try {
			if (resourceBundle == null)
				resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
