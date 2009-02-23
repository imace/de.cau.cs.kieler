package de.cau.cs.kieler.klodd.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class for access to internationalized strings.
 * 
 * @author msp
 */
public class Messages {

	private static final String BUNDLE_NAME = "de.cau.cs.kieler.klodd.ui.messages"; //$NON-NLS-1$
	private static ResourceBundle resourceBundle = null;

	/**
	 * Returns a string for the given key.
	 * 
	 * @param key key to lookup
	 * @return readable message string
	 */
	public static String getString(String key) {
		try {
			if (resourceBundle == null) {
				resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
			}
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
