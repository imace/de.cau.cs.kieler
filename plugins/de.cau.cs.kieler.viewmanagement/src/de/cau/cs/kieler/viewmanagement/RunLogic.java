/*
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
package de.cau.cs.kieler.viewmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.cau.cs.kieler.viewmanagement.view.TableData;
import de.cau.cs.kieler.viewmanagement.view.TableDataList;

/**
 * The RunLogic is the central administration of the view management. It keeps track of all the
 * available components, triggers, effects and combinations. On startup, it reads all of them and
 * makes instances available to the other components. It can also be asked to give an instance of a
 * specified component, using e.g. the getTrigger method. Finally it provides with finalize() a way
 * to simply shut down the view management.
 * 
 * @author nbe
 * 
 */

public final class RunLogic {
    // string constants UPPERCASE
    private static final String EFFECTSPATH = "de.cau.cs.kieler.viewmanagement.effects";
    private static final String COMBOPATH = "de.cau.cs.kieler.viewmanagement.combination";
    private static final String TRIGGERPATH = "de.cau.cs.kieler.viewmanagement.triggers";

    // there should be only one RunLogic at a time
    private static RunLogic runlogic = new RunLogic();

    /**
     * Constructor initializes only the used lists.
     */
    private RunLogic() {
        init();
    }

    /**
     * Returns the instance of the RunLogic.
     * 
     * @return the instance of RunLogic
     */
    public static synchronized RunLogic getInstance() {

        return runlogic;
    }

    /**
     * Lists instances of all available triggers.
     */
    private HashMap<String, ATrigger> triggers;

    /**
     * Lists instances of all available effects.
     */
    private HashMap<String, AEffect> effects;

    /**
     * Lists instances of all available combinations.
     */
    private HashMap<String, ACombination> combos;

    /**
     * keeps track of the combos that have been activated in order to shut them down cleanly if
     * needed.
     */
    List<String> activeCombos;

    /**
     * indicates the status of the RunLogic. Is used to determine the action of the toggle button in
     * the VM Control view.
     */
    private boolean state;

    /**
     * Initializes lists to be used to store available components no getter/setter in class remove
     * setter
     */
    public void init() {
        triggers = (new HashMap<String, ATrigger>());
        effects = (new HashMap<String, AEffect>());
        combos = (new HashMap<String, ACombination>());
        // update the table in the VM Control view that displays all available combinations
        TableDataList.getInstance().updateViewAsync();
        activeCombos = new ArrayList<String>();

    }

    /**
     * Method to start the Viewmanagement. Reads all available effects, triggers and combinations,
     * sets the runLogicState.
     */
    public void registerListeners() {

        triggers.clear();
        combos.clear();
        effects.clear();
        activeCombos.clear();

        // set indication that the RunLogic is running (This is needed to determine the action of
        // the VM on/off button in the VM Control view)
        state = true;
        // read available effects, triggers and combinations
        this.readEffects();
        this.readTriggers();
        this.readCombinations();
        // update the table in the VM Control view once more
        TableDataList.getInstance().updateViewAsync();

        return;
    }

    /**
     * Method to stop the Viewmanagement. Removes combinations from the VM Table, calls finalize()
     * for active combos and finalize for active triggers. Sets status runLogicState.
     */
    public void unregisterListeners() {

        Iterator<ACombination> i3 = getCombos().values().iterator();
        Iterator<String> i2 = getCombos().keySet().iterator();
        // Remove entries from VM Control table
        while (i2.hasNext()) {
            TableDataList.getInstance().remove(i2.next());
        }
        // finalize combos, if they are active
        while (i3.hasNext()) {
            if (i3.next().isActive()) {
                i3.next().finalize();
            }
        }

        // update the VM Control table
        TableDataList.getInstance().updateViewAsync();

        // finalize the triggers
        Set<String> t = triggers.keySet();
        Iterator<String> i = t.iterator();
        while (i.hasNext()) {
            triggers.get(i.next()).finalize();
        }

        // indicate that the RunLogic is now off (This is needed to determine the action of
        // the VM on/off button in the VM Control view)
        state = false;

        return;
    }

    /**
     * searches the registry for triggers and creates an instance of each. Adds them to the triggers
     * list to make them available
     */

    private void readTriggers() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(TRIGGERPATH);
        for (int i = 0; i < myExtensions.length; i++) {

            try {
                ATrigger myTrigger = (ATrigger) myExtensions[i].createExecutableExtension("class");

                getTriggers().put(myExtensions[i].getAttribute("name"), myTrigger);
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * searches the registry for effects and creates an instance of each. Adds them to the effects
     * list to make them available
     */

    private void readEffects() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(EFFECTSPATH);
        for (int i = 0; i < myExtensions.length; i++) {
            try {
                AEffect myEffect = (AEffect) myExtensions[i].createExecutableExtension("class");

                effects.put(myExtensions[i].getAttribute("name"), myEffect);
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * searches the registry for triggers and creates an instance of each. Adds them to the triggers
     * list to make them available. Also creates new TableData entires and adds the combinations to
     * the table in the VM Control view. Finally updates the table to make them visible.
     **/
    private void readCombinations() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(COMBOPATH);
        for (int i = 0; i < myExtensions.length; i++) {
            try {

                ACombination myCombo = (ACombination) myExtensions[i]
                        .createExecutableExtension("class");
                getCombos().put(myExtensions[i].getAttribute("name"), myCombo);
                // add an entry tp the TableDataList for each combo
                TableDataList.getInstance().add(
                        new TableData(TableDataList.getInstance(), myCombo.isActive(),
                                myExtensions[i].getAttribute("name")));
                // update the table
                TableDataList.getInstance().updateViewAsync();
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a trigger from list triggers that matches the given name in the argument.
     * 
     * @param name
     *            name of trigger to be searched for
     * @return instance of searched trigger
     */
    public ATrigger getTrigger(final String name) {

        ATrigger myTrigger = getTriggers().get(name);
        return myTrigger;
    }

    /**
     * Returns a combination from list combos that matches the given name in the argument.
     * 
     * @param name
     *            name of the combination to be searched for
     * @return instance of searched combination
     */
    public ACombination getCombination(final String name) {
        ACombination myCombination = getCombos().get(name);

        return myCombination;
    }

    /**
     * Returns an effect from list effects that matches the given name in the argument.
     * 
     * @param name
     *            of the effect to be searched for
     * @return instance of searched trigger
     */
    public AEffect getEffect(final String name) {

        AEffect myEffect = getEffects().get(name);

        return myEffect;
    }

    /**
     * Gives a list of Strings of available effects names
     * 
     * @return list of Strings of available effect names
     */
    public List<String> getEffectsAsText() {
        List<String> textualEffects;
        textualEffects = new ArrayList<String>();

        Set<String> s = getEffects().keySet();
        Iterator<String> i = s.iterator();
        while (i.hasNext()) {
            textualEffects.add(i.next());
        }

        return textualEffects;
    }

    /**
     * Returns the state of the RunLogic, true for on, false for off. This is used to determine the
     * next action of the button in the VM Control view.
     * 
     * @return the state of the RunLogic
     */
    public boolean getState() {
        return state;
    }

    /**
     * @return the triggers
     */
    private HashMap<String, ATrigger> getTriggers() {
        return triggers;
    }

    /**
     * @return the effects
     */
    HashMap<String, AEffect> getEffects() {
        return effects;
    }

    /**
     * @return the combos
     */
    public HashMap<String, ACombination> getCombos() {
        return combos;
    }

}
