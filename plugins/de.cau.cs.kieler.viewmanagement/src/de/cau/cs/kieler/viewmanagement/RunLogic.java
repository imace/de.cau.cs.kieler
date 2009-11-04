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

    private static RunLogic runlogic;

    private RunLogic() {

    }

    public static synchronized RunLogic getInstance() {
        if (runlogic == null)
            runlogic = new RunLogic();

        return runlogic;
    }

    static// Local references to all triggers, effects and combos
    List<ATrigger> triggers;
    static List<AEffect> effects;
    static List<ACombination> combos;
    List<String> activeCombos;
    private boolean runlogicState;

    public void init() {
        triggers = new ArrayList<ATrigger>();
        effects = new ArrayList<AEffect>();
        combos = new ArrayList<ACombination>();

        TableDataList.getInstance().updateViewAsync();
        activeCombos = new ArrayList<String>();

    }

    public void registerListeners() {
        // System.out.println("Registering");
        this.init();
        runlogicState = true;
        // read all extension points and store results in local lists
        this.readEffects();
        this.readTriggers();
        this.readCombinations();
        TableDataList.getInstance().updateViewAsync();

        // for (ACombination oneCombination : combos) {
        //
        // for (String comboToCheck : activeCombos)
        // if (oneCombination.getClass().getCanonicalName().equals(comboToCheck))
        //
        // oneCombination.setActive(true);
        // }

        // for (ACombination oneCombination : combos) {
        // if (oneCombination.getActive()) // initialize only combos set to active
        // oneCombination.initialize();
        // }

        return;
    }

    public void unregisterListeners() {

        for (ACombination oneCombination : combos) {
            TableDataList.getInstance().remove(oneCombination.getClass().getCanonicalName());

            if (oneCombination.getActive()) // finalize only combos that were active
                oneCombination.finalize();
            TableDataList.getInstance().updateViewAsync();
        }
        for (ATrigger oneTrigger : triggers)
            oneTrigger.finalize();
        runlogicState = false;
        return;
    }

    /**
     * Read all entries for the trigger extension point and add all trigger implementations to out
     * local list of triggers.
     */
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

    private void readEffects() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.effects");
        for (int i = 0; i < myExtensions.length; i++) {
            try {
                AEffect myEffect = (AEffect) myExtensions[i].createExecutableExtension("class");
                this.effects.add(myEffect);
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    private void readCombinations() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("de.cau.cs.kieler.viewmanagement.combination");
        for (int i = 0; i < myExtensions.length; i++) {
            try {

                ACombination myCombo = (ACombination) myExtensions[i]
                        .createExecutableExtension("class");
                this.combos.add(myCombo);
                TableDataList.getInstance().add(
                        new TableData(TableDataList.getInstance(), myCombo.getActive(), myCombo
                                .getClass().getCanonicalName()));
                TableDataList.getInstance().updateViewAsync();
            } catch (CoreException e) {

                e.printStackTrace();
            }
        }
    }

    public static ATrigger getTrigger(String name) {
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
    
    public static ACombination getCombination(String name) {
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
    public static AEffect getEffect(String name){
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
    
    public static List<AEffect> getEffects(){
        return effects;
    }

    public boolean getRunlogicState() {
        return runlogicState;
    }

}
