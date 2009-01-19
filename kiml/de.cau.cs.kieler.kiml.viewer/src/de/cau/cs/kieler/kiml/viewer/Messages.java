package de.cau.cs.kieler.kiml.viewer;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Generated class for externalization of strings.
 * 
 * @author msp
 */
public class Messages {
	
	private static final String BUNDLE_NAME = "de.cau.cs.kieler.kiml.viewer.messages"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * Gets the string associated with the given key.
	 * 
	 * @param key key to look up
	 * @return the associated string
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
