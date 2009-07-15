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
package de.cau.cs.kieler.viewmanagement.combination;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;

import de.cau.cs.kieler.viewmanagement.ACombination;
import de.cau.cs.kieler.viewmanagement.AEffect;
import de.cau.cs.kieler.viewmanagement.effects.HighlightEffect;

/**
 * @author haf
 *
 */
public class SelectionHighlightCombination extends ACombination{

    static HighlightEffect effect;
    List <String> myTriggers;
    String st =  "SelectionTrigger";
    
    	@Override
    	public List<String> getTriggers(){
    		myTriggers.add(st);
    	return myTriggers;
    	
    	
    }
    
 // just a test to trigger some effect
   /* public static void doSomething(ShapeEditPart target){
        // if there is still something highlighted, remove it
        if(effect != null){
            effect.undo();
        }
        
        effect = new HighlightEffect();
        effect.setTarget(target);
        effect.execute();
    }
    */
    
}
