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

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;

import de.cau.cs.kieler.klots.KlotsPlugin;


/**
 * @author root
 *
 */
public class RemotePrintReceiver /*extends Thread*/ {

    private static KlotsConsole console = KlotsConsole.getInstance();
    private NXTCommunicator comm;

    private boolean broughtToFront = false;

    
    
    /**
     * @param comm 
     */
    public RemotePrintReceiver(final NXTCommunicator comm) {
        this.comm = comm;
    }


    
    /**
     * 
     */
    public void start() { //run() {
        bringToFront();
        String line = comm.receiveMessageLine();
        while (!line.equals(KlotsConstants.END_OF_TRANSMISSION_COMMAND_KEY)) {
            if (line.endsWith(KlotsConstants.MESSAGE_NEW_LINE)) {
                console.print(
                        line.replaceFirst(KlotsConstants.PRINT_TAG, "")
                        .replaceFirst(KlotsConstants.MESSAGE_NEW_LINE, "\n")
                        );
            } else {
                console.print(line.replaceFirst(KlotsConstants.PRINT_TAG, ""));
            }
            line = comm.receiveMessageLine();
        }
        comm.closeTransmission(false);
    }


    
    /**
     * 
     */
    public void destroy() {
        comm.closeTransmission(false);
    }



    /**
     * This method brings the Table view to the front.
     */
    public void bringToFront() {
        broughtToFront = false;
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                // bring view to the front (lazy loading)
                try {
                    IWorkbenchWindow window = KlotsPlugin.getDefault().getWorkbench()
                    .getActiveWorkbenchWindow();
                    IViewPart vP = window.getActivePage().showView("org.eclipse.ui.console.ConsoleView");
                    vP.setFocus();
                    // set done flag
                    broughtToFront = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        while (!broughtToFront) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}