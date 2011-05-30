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

import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.cau.cs.kieler.klots.KlotsPlugin;


/**
 * @author root
 *
 */
public class KlotsRemotePrintConsole {

    /**
     * 
     */
    public static final String ID = "de.cau.cs.kieler.klots.util.KlotsRemotePrintConsole";
    private static final String KLOTS_CONSOLE_NAME = "KLOTS Remote Print Console";

    private MessageConsole klotsConsole = null;
    private static final KlotsRemotePrintConsole INSTANCE = new KlotsRemotePrintConsole();


    
    /**
     * 
     */
    public KlotsRemotePrintConsole() {
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
    public static KlotsRemotePrintConsole getInstance() {
        return INSTANCE;
    }
    
    
    
    /**
     * @param enabled 
     */
    public void setEnabled(final boolean enabled) {
        if (enabled) {
            try {
                KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().showView("org.eclipse.ui.console.ConsoleView");
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        } else {
            if (
                 PlatformUI.getWorkbench().getViewRegistry().find("org.eclipse.ui.console.ConsoleView")
                 != null
                ) {
                IViewReference[] refs = KlotsPlugin.getDefault().getWorkbench()
                .getActiveWorkbenchWindow().getActivePage().getViewReferences();
                for (IViewReference reference : refs) {
                    if (reference.getId().equals("org.eclipse.ui.console.ConsoleView")) {
                        KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage().hideView(reference);
                    }
                }
            }
        }
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
