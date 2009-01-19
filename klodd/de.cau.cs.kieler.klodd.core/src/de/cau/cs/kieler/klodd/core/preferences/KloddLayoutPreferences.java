package de.cau.cs.kieler.klodd.core.preferences;

import java.util.AbstractMap;
import java.util.Set;

import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.klodd.core.KloddCorePlugin;


/**
 * A map for layout preferences that is built on the preference store
 * for the KLoDD layouters plugin.
 * 
 * @author msp
 */
public class KloddLayoutPreferences extends AbstractMap<String, Object> {
	
	/** minimal distance between layout elements */
	public static final String MIN_DIST = "klodd.hierarchical.minDist";
	
	/** the preference store used as base */
	private IPreferenceStore preferenceStore;
	
	/**
	 * Creates a layout preferences map.
	 */
	public KloddLayoutPreferences() {
		super();
		preferenceStore = KloddCorePlugin.getDefault().getPreferenceStore();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractMap#get(java.lang.Object)
	 */
	public Object get(Object key) {
		if (MIN_DIST.equals(key))
			return new Float(preferenceStore.getFloat(MIN_DIST));
		else return null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.AbstractMap#entrySet()
	 */
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		throw new UnsupportedOperationException("The requested operation is not supported by the preferences map.");
	}

}
