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
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * @author nbe
 * 
 */

public final class RunLogic {
    // there should be only one RunLogic at a time
    private static RunLogic runlogic;

    private RunLogic() {

    }

    /**
     * Assures that only one instance of the RunLogic is present.
     * 
     * @return the instance of RunLogic
     */
    public static synchronized RunLogic getInstance() {
        // if there is no instance of the RunLogic, create one
        if (runlogic == null)
            runlogic = new RunLogic();

        return runlogic;
    }

    // Lists of the components of the View Management
    static List<ATrigger> triggers;
    static List<AEffect> effects;
    static List<ACombination> combos;
    // keeps track of active combinations in order to finalize them once the RunLogic is shutting
    // down
    List<String> activeCombos;
    private boolean runlogicState;

    /**
     * Initializes lists to be used to store available components
     */
    public void init() {
        triggers = new ArrayList<ATrigger>();
        effects = new ArrayList<AEffect>();
        combos = new ArrayList<ACombination>();
        // update the table in the VM Control view that displays all available combinations
        TableDataList.getInstance().updateViewAsync();
        activeCombos = new ArrayList<String>();

    }

    /**
     * Method to start the Viewmanagement. Reads all available effects, triggers and combinations,
     * sets the runLogicState.
     */
    public void registerListeners() {

        this.init();
        // set indication that the RunLogic is running (This is needed to determine the action of
        // the VM on/off button in the VM Control view)
        runlogicState = true;
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
        // remove all entries in the VM Control view
        for (final ACombination oneCombination : combos) {
            TableDataList.getInstance().remove(oneCombination.getClass().getCanonicalName());
            // finalize only combos that were active
            if (oneCombination.getActive())
                oneCombination.finalize();
            // update the VM Control table
            TableDataList.getInstance().updateViewAsync();
        }
        // finalize the triggers
        for (final ATrigger oneTrigger : triggers)
            oneTrigger.finalize();
        // indicate that the RunLogic is now off (This is needed to determine the action of
        // the VM on/off button in the VM Control view)
        runlogicState = false;

        return;
    }

    // searches the registry for triggers and creates an instance of each. Adds them to the triggers
    // list to make them available
    private void readTriggers() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.triggers");
        for (int i = 0; i < myExtensions.length; i++) {
            try {
                ATrigger myTrigger = (ATrigger) myExtensions[i].createExecutableExtension("class");
                RunLogic.triggers.add(myTrigger);
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    // searches the registry for effects and creates an instance of each. Adds them to the effects
    // list to make them available
    private void readEffects() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.effects");
        for (int i = 0; i < myExtensions.length; i++) {
            try {
                AEffect myEffect = (AEffect) myExtensions[i].createExecutableExtension("class");
                RunLogic.effects.add(myEffect);
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    // searches the registry for triggers and creates an instance of each. Adds them to the triggers
    // list to make them available. Also creates new TableData entires and adds the combinations to
    // the table in the VM Control view. Finally updates the table to make them visible.
    private void readCombinations() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.combination");
        for (int i = 0; i < myExtensions.length; i++) {
            try {

                ACombination myCombo = (ACombination) myExtensions[i]
                        .createExecutableExtension("class");
                RunLogic.combos.add(myCombo);
                // add an entry tp the TableDataList for each combo
                TableDataList.getInstance().add(
                        new TableData(TableDataList.getInstance(), myCombo.getActive(), myCombo
                                .getClass().getCanonicalName()));
                // update the table
                TableDataList.getInstance().updateViewAsync();
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a trigger from list triggers that matches the given name in the argument. Since a
     * direct comparison on the elements of triggers is not possible there will be searched for
     * position in the list
     * 
     * @param name
     *            name of trigger to be searched for
     * @return instance of searched trigger
     */
    public static ATrigger getTrigger(final String name) {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.triggers");
        ATrigger myTrigger = null;
        for (int i = 0; i < myExtensions.length; i++) {
            String attribute = myExtensions[i].getAttribute("name");
            if (attribute.equals(name)) {
                myTrigger = triggers.get(i);

            }
        }

        return myTrigger;
    }

    /**
     * Returns a combination from list combos that matches the given name in the argument. Since a
     * direct comparison on the elements of combos is not possible there will be searched for
     * position in the list
     * 
     * @param name
     *            name of the combination to be searched for
     * @return instance of searched combination
     */
    public static ACombination getCombination(final String name) {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.combination");
        ACombination myCombination = null;
        for (int i = 0; i < myExtensions.length; i++) {
            String attribute = myExtensions[i].getAttribute("name");
            if (attribute.equals(name)) {
                myCombination = combos.get(i);

            }
        }

        return myCombination;
    }

    /**
     * Returns an effect from list effects that matches the given name in the argument. Since a
     * direct comparison on the elements of effects is not possible there will be searched for
     * position in the list
     * 
     * @param name
     *            of the effect to be searched for
     * @return instance of searched trigger
     */
    public static AEffect getEffect(final String name) {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.effects");
        AEffect myEffect = null;
        for (int i = 0; i < myExtensions.length; i++) {
            String attribute = myExtensions[i].getAttribute("name");
            if (attribute.equals(name)) {
                myEffect = effects.get(i);

            }
        }

        return myEffect;
    }

    /**
     * Gives a list of Strings of available effects names
     * 
     * @return list of Strings of available effect names
     */
    public static List<String> getEffects() {
        List<String> textualEffects;
        textualEffects = new ArrayList<String>();

        for (final AEffect oneEffect : effects) {
            final String test2 = (oneEffect.getClass().getCanonicalName());
            textualEffects.add(test2);
        }

        return textualEffects;
    }

    /**
     * Returns the state of the RunLogic, true for on, false for off. This is used to determine the
     * next action of the button in the VM Control view.
     * 
     * @return the state of the RunLogic
     */
    public boolean getRunlogicState() {
        return runlogicState;
    }

}
