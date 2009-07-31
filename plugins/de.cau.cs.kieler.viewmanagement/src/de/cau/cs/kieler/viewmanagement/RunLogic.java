package de.cau.cs.kieler.viewmanagement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

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
    
   

    public void init() {
        triggers = new ArrayList<ATrigger>();
        effects = new ArrayList<AEffect>();
        combos = new ArrayList<ACombination>();
    }

    public void registerListeners() {
        System.out.println("Registering");
        this.init();
        // read all extension points and store results in local lists
        this.readEffects();
        this.readTriggers();
        this.readCombinations();
//        FOR TESTING: Activate all available combos (Should be set by user/other module later)
        for (ACombination oneCombination : combos)
        	oneCombination.comboActive=true;

        for (ACombination oneCombination : combos) {
        	if (oneCombination.comboActive) //initialize only combos set to active
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
        	if(oneCombination.comboActive) //finalize only combos that were active
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
