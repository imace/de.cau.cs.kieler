/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klots.util;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;


/**
 * @author root
 *
 */
public class KlotsConsole {

    private static final String KLOTS_CONSOLE_NAME = "KLOTS Console";

    private MessageConsole klotsConsole = null;
    private static final KlotsConsole INSTANCE = new KlotsConsole();


    
    /**
     * 
     */
    public KlotsConsole() {
        boolean found = false;
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++) {
            if (KLOTS_CONSOLE_NAME.equals(existing[i].getName())) {
                klotsConsole = (MessageConsole) existing[i];
                found = true;
                break;
            }
        }
        if (!found) {
            // if no console found, so create a new one
            klotsConsole = new MessageConsole(KLOTS_CONSOLE_NAME, null);
            conMan.addConsoles(new IConsole[] { klotsConsole });
        }
    }


    
    /**
     * @return KlotsConsole 
     */
    public static KlotsConsole getInstance() {
        return INSTANCE;
    }


    
    /**
     * Clears the klots console.
     */
    public void clear() {
        print(null);
    }


    
    /**
     * @param text 
     */
    public void println(final String text) {
        print(text + "\n");
    }


    
    /**
     * Prints to the klots console.
     * 
     * @param text
     *            the text
     */
    public void print(final String text) {
        if (text != null) {
            MessageConsoleStream out = klotsConsole.newMessageStream();
            out.print(text);
        } else {
            klotsConsole.clearConsole();
        }
    }

}