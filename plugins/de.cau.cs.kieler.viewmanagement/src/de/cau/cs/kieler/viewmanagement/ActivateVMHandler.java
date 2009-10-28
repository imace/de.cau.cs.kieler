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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;


/**
 * @author nbe
 * 
 */
public class ActivateVMHandler extends AbstractHandler implements IHandler {

 
    public ActivateVMHandler() {
      
    }

    public Object execute(ExecutionEvent event) throws ExecutionException {
      

        // Determine state of Toggle Button
        Object trigger = event.getTrigger();
        boolean checked = false;
        if (trigger instanceof Event) {
            Object widget = ((Event) trigger).widget;
            if (widget instanceof ToolItem)
                checked = ((ToolItem) widget).getSelection();
        }
        //RunLogic myRunLogic = new RunLogic();
        if (checked) {
            System.out.println("Now VM is on");
            
           RunLogic.getInstance().registerListeners();
        } else{
        	RunLogic.getInstance().unregisterListeners();
        	System.out.println("VM is off");
        	
        }
            
            
        return null;
    }

}
