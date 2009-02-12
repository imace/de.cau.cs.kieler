package de.cau.cs.kieler.klodd.orthogonal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class for access to localized strings.
 * 
 * @author msp
 */
public class Messages {
	
	private static final String BUNDLE_NAME = "de.cau.cs.kieler.klodd.orthogonal.messages"; //$NON-NLS-1$

	/** the resource bundle */
	private static ResourceBundle resourceBundle = null;

	/**
	 * Retrieves a localized string for the given key.
	 * 
	 * @param key key to look up
	 * @return corresponding localized message string
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
