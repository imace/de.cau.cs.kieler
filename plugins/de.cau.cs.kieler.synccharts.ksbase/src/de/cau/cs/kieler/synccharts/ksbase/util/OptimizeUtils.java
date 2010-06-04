/**
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 * 
 *****************************************************************************/
package de.cau.cs.kieler.synccharts.ksbase.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.synccharts.Region;
import de.cau.cs.kieler.synccharts.State;
import de.cau.cs.kieler.synccharts.SyncchartsPackage;
import de.cau.cs.kieler.synccharts.contentadapter.SyncchartsContentUtil;
import de.cau.cs.kieler.synccharts.contentadapter.UniqueStringCache;
import de.cau.cs.kieler.synccharts.ksbase.SyncchartsKsbasePlugin;

/**
 * Utils for optimization.
 * 
 * @author soh
 */
public final class OptimizeUtils {

    /** Preference Prefix. */
    public static final String PREFIX = "_OPTIMIZE_";
    /** Identifier for fixing the state and region ids. */
    public static final String FIX_IDS = "fixIDs";
    /** Identifier for fixing the transition priorities. */
    public static final String FIX_TRANSITION_PRIORITIES = "fixTransitionPriorities";
    /** Identifier for fixing transitions leaving conditional states. */
    public static final String FIX_CONDITIONAL_OUTGOING_IMMEDIATE = "fixConditionalOutgoingImmediate";
    /** Identifier for fixing transition types. */
    public static final String FIX_TRANSITION_TYPES = "fixTransitionTypes";
    /** Identifier for removing dummy states. */
    public static final String REMOVE_DUMMY_STATES = "removeDummyStates";
    /** Identifier for removing white space from trigger and effects. */
    public static final String REMOVE_WHITE_SPACES = "removeWhiteSpaces";
    /** Identifier for removing dummy regions. */
    public static final String REMOVE_DUMMY_REGIONS = "removeDummyRegions";

    /**
     * Contains the identifiers for all optimizations that are required to have
     * a valid syncchart. Register new optimizations here.
     * 
     */
    private static final String[] REQUIRED_KEYS = { FIX_IDS,
            FIX_TRANSITION_PRIORITIES, FIX_TRANSITION_TYPES,
            FIX_CONDITIONAL_OUTGOING_IMMEDIATE };

    /**
     * Contains the identifiers for all optimizations that improve a syncchart
     * but are not required.
     */
    private static final String[] OPTIONAL_KEYS = { REMOVE_DUMMY_STATES,
            REMOVE_WHITE_SPACES, REMOVE_DUMMY_REGIONS };

    /** Contains the list of all available keys. */
    private static List<String> keys = null;

    /** The preference store. */
    private static IPreferenceStore store = null;

    /** Cached region and state ids. */
    private static List<UniqueStringCache> caches = new LinkedList<UniqueStringCache>();

    /**
     * 
     * Dummy.
     * 
     */
    private OptimizeUtils() {

    }

    /**
     * Initialize the list of keys.
     * 
     * @return the list of keys
     */
    public static List<String> getKeys() {
        if (keys == null) {
            keys = new ArrayList<String>(REQUIRED_KEYS.length
                    + OPTIONAL_KEYS.length);
            for (String s : REQUIRED_KEYS) {
                keys.add(PREFIX + s);
            }
            for (String s : OPTIONAL_KEYS) {
                keys.add(PREFIX + s);
            }
        }
        return keys;
    }

    /**
     * Save the configuration in the preference store back to the persistent
     * store.
     * 
     */
    public static void saveConfiguration() {
        if (store != null) {
            IEclipsePreferences prefs = new InstanceScope()
                    .getNode(SyncchartsKsbasePlugin.PLUGIN_ID);
            for (String key : keys) {
                Boolean value = store.getBoolean(key);
                if (value != null) {
                    prefs.putBoolean(key, value);
                }
            }
        }
    }

    /**
     * Load the configuration from the persistent store to the preference store.
     * This has to be done before the values are accessed the first time. It
     * will have no effect once the store is loaded for the first time.
     * 
     */
    public static void loadConfiguration() {
        if (store == null) {
            store = SyncchartsKsbasePlugin.getDefault().getPreferenceStore();
            IEclipsePreferences prefs = new InstanceScope()
                    .getNode(SyncchartsKsbasePlugin.PLUGIN_ID);
            for (String key : getKeys()) {
                boolean value = prefs.getBoolean(key, true);
                store.setValue(key, value);
            }
        }
    }

    /**
     * Debug output for xtend code.
     * 
     * @param object
     *            the message
     */
    public static void debug(final Object object) {
        System.out.println("BUGFIX DEBUG: " + object.toString());
    }

    /**
     * 
     * @return a new list of states
     */
    public static List<State> getStateList() {
        return new LinkedList<State>();
    }

    /**
     * 
     * @return a new list of regions
     */
    public static List<Region> getRegionList() {
        return new LinkedList<Region>();
    }

    /**
     * Clear the caches.
     */
    public static void clearCache() {
        caches.clear();
    }

    /**
     * Generate a unique id for the state.
     * 
     * @param state
     *            the state.
     */
    public static void generateStateId(final State state) {
        if (state.getId() == null || state.getId().trim().equals("")) {
            String anonymousId = getUniqueString(state,
                    SyncchartsPackage.eINSTANCE.getState_Id(), "_S");
            state.setId(anonymousId);
            return;
        }

        // check whether ID is unique
        Region parentRegion = state.getParentRegion();
        if (parentRegion != null) {
            for (State sibling : parentRegion.getInnerStates()) {
                String siblingId = sibling.getId();
                if (siblingId != null && siblingId.equals(state.getId())
                        && sibling != state) {
                    // resolve conflict by changing auto generated IDs (for
                    // anonymous states)

                    String dummyId = getUniqueString(sibling,
                            SyncchartsPackage.eINSTANCE.getState_Id(), sibling
                                    .getLabel());
                    sibling.setId(dummyId);

                }
            }
        }
    }

    /**
     * Generate a unique id for the region.
     * 
     * @param region
     *            the region
     */
    public static void generateRegionId(final Region region) {
        if (region.getId() == null || region.getId().trim().equals("")) {
            String anonymousId = getUniqueString(region,
                    SyncchartsPackage.eINSTANCE.getRegion_Id(), "_R");
            region.setId(anonymousId);
            return;
        }

        // check whether ID is unique
        State parentState = region.getParentState();
        if (parentState != null) {
            for (Region sibling : parentState.getRegions()) {
                String siblingId = sibling.getId();
                if (siblingId != null && siblingId.equals(region.getId())) {
                    // resolve conflict by changing auto generated IDs (for
                    // anonymous states)
                    if (sibling.getId() == null
                            || sibling.getId().trim().equals("")) {
                        String dummyId = getUniqueString(sibling,
                                SyncchartsPackage.eINSTANCE.getRegion_Id(),
                                "_R");
                        sibling.setId(dummyId);
                    }
                }
            }
        }
    }

    /**
     * 
     * @param target
     * @param attribute
     * @param prefix
     * @return
     */
    private static String getUniqueString(final EObject target,
            final EAttribute attribute, final String prefix) {
        EObject parent = target.eContainer();
        UniqueStringCache cache = null;
        for (UniqueStringCache c : caches) {
            if (c != null && (parent == null && c.getParent() == null)
                    || (c.getParent() != null && c.getParent().equals(parent))
                    && c.getAttribute().equals(attribute)) {
                cache = c;
            }
        }
        if (cache == null) {
            cache = new UniqueStringCache(parent, attribute);
            caches.add(cache);
        }
        String temp = SyncchartsContentUtil.getNewUniqueString(target,
                attribute, prefix, cache);
        cache.add(temp);
        return temp;
    }

    /**
     * Returns whether or not an optimization should be run.
     * 
     * @param key
     *            the key
     * @return true if it should be run
     */
    public static Boolean isEnabled(final String key) {
        loadConfiguration();
        Boolean result = store.getBoolean(PREFIX + key);
        if (result != null) {
            return result;
        }
        return false;
    }

    /**
     * Getter for the displayable name of the optimization.
     * 
     * @param key
     *            the key
     * @return the display name
     */
    public static String getDisplay(final String key) {
        if (key.equals(PREFIX + FIX_IDS)) {
            return "Fix state and region IDs (REQUIRED)";
        } else if (key.equals(PREFIX + FIX_TRANSITION_PRIORITIES)) {
            return "Fix transition priorities (REQUIRED)";
        } else if (key.equals(PREFIX + FIX_CONDITIONAL_OUTGOING_IMMEDIATE)) {
            return "Fix transitions leaving conditional states (REQUIRED)";
        } else if (key.equals(PREFIX + FIX_TRANSITION_TYPES)) {
            return "Fix transition types (REQUIRED)";
        } else if (key.equals(PREFIX + REMOVE_DUMMY_STATES)) {
            return "Remove redundant states";
        } else if (key.equals(PREFIX + REMOVE_DUMMY_REGIONS)) {
            return "Remove redundant regions";
        } else if (key.equals(PREFIX + REMOVE_WHITE_SPACES)) {
            return "Remove white spaces from trigger and effects";
        }
        return key;
    }

    /**
     * Getter for the tooltip of the optimization.
     * 
     * @param key
     *            the key
     * @return the tooltip
     */
    public static String getTooltip(final String key) {
        if (key.equals(PREFIX + FIX_IDS)) {
            return "Generates unique IDs for each region and state.";
        } else if (key.equals(PREFIX + FIX_TRANSITION_PRIORITIES)) {
            return "Ensures that the lowest transition priority is 1.";
        } else if (key.equals(PREFIX + FIX_CONDITIONAL_OUTGOING_IMMEDIATE)) {
            return "Makes all transitions leaving conditional states immediate.";
        } else if (key.equals(PREFIX + REMOVE_DUMMY_STATES)) {
            return "Removes states that have no effect on the syncchart.";
        } else if (key.equals(PREFIX + REMOVE_DUMMY_REGIONS)) {
            return "Removes empty regions with no variables and signals.";
        } else if (key.equals(PREFIX + REMOVE_WHITE_SPACES)) {
            return "Removes white spaces from trigger and effects string as they are redundant.";
        } else if (key.equals(PREFIX + FIX_TRANSITION_TYPES)) {
            return "Transitions leaving simple states must be WEAKABORT.\n"
                    + "Transitions without trigger leaving complex states must be NORMALTERMINATION.";
        }
        return key;
    }
}
