/******************************************************************************
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
package de.cau.cs.kieler.ksbase.core;

import java.util.LinkedList;


/**
 * A menu contribution, defined by an extension point.
 * Contains a list of commands, sub menus and a data property. 
 * @author mim
 *
 */
public class KSBasEMenuContribution {
    
    private String data; //If this contribution is a root contribution, the data is a
                        //locationURI, else it is the id of a menu.
    private String label; //The label for this contribution, currently used only for menus
    private LinkedList<String> commands; //The list of commands
    private LinkedList<KSBasEMenuContribution> subMenus; //The list of sub menus
    
    /**
     * Creates a new menu contribution with the given data content
     * (Id or locationURI).
     * @param data The data property
     */
    public KSBasEMenuContribution(final String data) {
        this.data = data;
        this.commands = new LinkedList<String>();
        this.subMenus = new LinkedList<KSBasEMenuContribution>();
        this.label = "";
    }
    
    /**
     * Adds a command to this contribution.
     * @param transformationId The id of the called transformation
     */
    public final void addCommand(final String transformationId) {
        commands.add(transformationId);
        
    }
    
    /**
     * Adds a sub menu to this contribution.
     * @param menu the menu to add
     */
    public final void addSubMenu(final KSBasEMenuContribution menu) {
        subMenus.add(menu);
    }
    
    /**
     * Returns a list of all sub menus contained in this contribution.
     * @return A list of menu contributions
     */
    public final LinkedList<KSBasEMenuContribution> getMenus() {
        return subMenus;
    }
    
    /**
     * Returns the list of commands.
     * @return A list of commands
     */
    public final LinkedList<String> getCommands() {
        return commands;
    }
    
    /**
     * Returns the string property. 
     * @return The content of the data property
     */
    public final String getData()
    {
        return data;
    }

    /**
     * Returns the label.
     * @return The label
     */
    public final String getLabel() {
        return label;
    }

    /**
     * Sets the label.
     * @param label the new label
     */
    public final void setLabel(final String label) {
        this.label = label;
    }
}
