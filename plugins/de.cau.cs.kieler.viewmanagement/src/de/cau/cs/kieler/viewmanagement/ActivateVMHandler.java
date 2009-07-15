/**
 * 
 */
package de.cau.cs.kieler.viewmanagement;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.menus.CommandContributionItem;

/**
 * @author nbe
 * 
 */
public class ActivateVMHandler extends AbstractHandler implements IHandler {

    /**
	 * 
	 */
    public ActivateVMHandler() {
        // TODO Auto-generated constructor stub
    }

    public Object execute(ExecutionEvent event) throws ExecutionException {
        // TODO Auto-generated method stub

        // Determine state of Toggle Button
        Object trigger = event.getTrigger();
        boolean checked = false;
        if (trigger instanceof Event) {
            Object widget = ((Event) trigger).widget;
            if (widget instanceof ToolItem)
                checked = ((ToolItem) widget).getSelection();
        }
        RunLogic myRunLogic = new RunLogic();
        if (checked) {
            System.out.println("Now VM is on");
            
           myRunLogic.registerListeners();
        } else{
        	myRunLogic.unregisterListeners();
        	System.out.println("VM is off");
        	
        }
            
            
        return null;
    }

}
