/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
		
	private RunLogic(){
		
	}
	
	public static synchronized RunLogic getInstance(){
		if (runlogic == null)
			runlogic = new RunLogic();
		return runlogic;
	}


    static // Local references to all triggers, effects and combos
    List<ATrigger> triggers;
    List<AEffect> effects;
    List<ACombination> combos;
    List<String> activeCombos;
    
   

    public void init() {
        triggers = new ArrayList<ATrigger>();
        effects = new ArrayList<AEffect>();
        combos = new ArrayList<ACombination>();
        activeCombos = new ArrayList<String>();
//        For now, manually add the Combinations that should be active here. Later it'd be better to do this with a table.
        activeCombos.add("de.cau.cs.kieler.viewmanagement.combination.SelectionHighlightCombination");
        //activeCombos.add("de.cau.cs.kieler.viewmanagement.combination.SelectionTextualRepresentationCombination");
        //activeCombos.add("de.cau.cs.kieler.viewmanagement.combination.SelectionFilterCombination");
        //activeCombos.add("de.cau.cs.kieler.viewmanagement.combination.SelectionLayoutCombination");
      //activeCombos.add("de.cau.cs.kieler.viewmanagement.combination.SelectionZoomCombination");
    }

    public void registerListeners() {
        System.out.println("Registering");
        this.init();
        // read all extension points and store results in local lists
        this.readEffects();
        this.readTriggers();
        this.readCombinations();

	
		
        for (ACombination oneCombination : combos){
//        	String test = oneCombination.getClass().getCanonicalName();
        for(String comboToCheck : activeCombos)
        	if (oneCombination.getClass().getCanonicalName().equals(comboToCheck))
        		oneCombination.setActive(true);
        }

        for (ACombination oneCombination : combos) {
        	if (oneCombination.getActive()) //initialize only combos set to active
            oneCombination.initialize();
        }        
        // print all available extensions
        // this.printExtensions();
        return;
    }
    
    public void unregisterListeners() {
		System.out.println("Unregistering");
		//this.init();
		//this.readEffects();
        //this.readTriggers();
        //this.readCombinations();
		
        
        for (ACombination oneCombination : combos)
        	if(oneCombination.getActive()) //finalize only combos that were active
            oneCombination.finalize();
        for (ATrigger oneTrigger : triggers)
        	oneTrigger.finalize();
        
        return;
        }

    /**
     * Read all entries for the trigger extension point and add all trigger
     * implementations to out local list of triggers.
     */
    private void readTriggers() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        "de.cau.cs.kieler.viewmanagement.triggers");
        for (int i = 0; i < myExtensions.length; i++) {
            try {
                ATrigger myTrigger = (ATrigger) myExtensions[i]
                        .createExecutableExtension("class");
                RunLogic.triggers.add(myTrigger);
            } catch (CoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void readEffects() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        "de.cau.cs.kieler.viewmanagement.effects");
        for (int i = 0; i < myExtensions.length; i++) {
            try {
                AEffect myEffect = (AEffect) myExtensions[i]
                        .createExecutableExtension("class");
                this.effects.add(myEffect);
            } catch (CoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void readCombinations() {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        "de.cau.cs.kieler.viewmanagement.combination");
        for (int i = 0; i < myExtensions.length; i++) {
            try {
                
                ACombination myCombo = (ACombination)myExtensions[i]
                        .createExecutableExtension("class");
                this.combos.add(myCombo);
            } catch (CoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static ATrigger getTrigger(String name) {
        IConfigurationElement[] myExtensions = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        "de.cau.cs.kieler.viewmanagement.triggers");
        ATrigger myTrigger = null;
        for (int i = 0; i < myExtensions.length; i++) {
            String attribute = myExtensions[i].getAttribute("name");
			if( attribute.equals(name)){
			     myTrigger = triggers.get(i);
			    
			}
        }
       
		return myTrigger; 
    }
   
    

	
    /*
     * private void printExtensions(){ for (AEffect myEffect : this.effects) {
     * System.out.println("Effect: "+myEffect); } for (ATrigger myTrigger :
     * this.triggers) { System.out.println("Trigger: "+myTrigger); } for (Object
     * myCombo : this.combos) { System.out.println("Combination: "+myCombo); } }
     */

}
