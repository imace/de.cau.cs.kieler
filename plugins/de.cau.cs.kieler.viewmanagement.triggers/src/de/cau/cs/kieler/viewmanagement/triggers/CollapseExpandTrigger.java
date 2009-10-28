package de.cau.cs.kieler.viewmanagement.triggers;

import org.eclipse.emf.ecore.EObject;

import de.cau.cs.kieler.viewmanagement.ATrigger;
import de.cau.cs.kieler.viewmanagement.TriggerEventObject;

public class CollapseExpandTrigger extends ATrigger {

    public void notifyCollapse(EObject affectedObject) {
        TriggerEventObject triggerEvent = new TriggerEventObject();
        triggerEvent.setTriggerActive(true);

        this.notifyTrigger(triggerEvent);
    }

}
