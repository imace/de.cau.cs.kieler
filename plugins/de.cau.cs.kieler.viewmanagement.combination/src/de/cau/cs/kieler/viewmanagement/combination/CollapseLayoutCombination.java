package de.cau.cs.kieler.viewmanagement.combination;

import java.util.ArrayList;
import java.util.List;

import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.RunLogic;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;
import de.cau.cs.kieler.viewmanagement.effects.LayoutEffect;
import de.cau.cs.kieler.viewmanagement.triggers.CollapseExpandTrigger;


public class CollapseLayoutCombination extends ACombination {


   
    
    public CollapseLayoutCombination() {
      
    }

    @Override
    public boolean evaluate(TriggerEventObject triggerEvent) {
        return true;
    }

    @Override
    public void execute() {
        LayoutEffect layoutEffect = new LayoutEffect();
        // the layouter should layout the whole diagram
        layoutEffect.setTarget(this.getRootEPAsParent());
        layoutEffect.execute();
    }

    @Override
    public List<ATrigger> getTriggers() {
        ATrigger ct = (CollapseExpandTrigger)RunLogic.getTrigger("CollapseExpandTrigger");
        List<ATrigger> myTriggers = new ArrayList<ATrigger>();
        myTriggers.add(ct);
        return myTriggers;
    }

}
