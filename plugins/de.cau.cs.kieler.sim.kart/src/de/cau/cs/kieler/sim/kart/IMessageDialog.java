/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2012 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.sim.kart;

/**
 * Interface for an extension point to allow KART to easily display message dialogs.
 * 
 * @author Sebastian Schäfer - ssc AT informatik.uni-kiel.de
 * @kieler.rating 2012-02-23 red
 */
public interface IMessageDialog {
    /**
     * Ask the user a Yes/No question by displaying a message dialog.
     * 
     * @param title the title of the message dialog
     * @param message the actual message
     * @return {@code true} if the user clicked Yes, {@code false} if he clicked No or the dialog
     *          could not be displayed.
     */
    public boolean question(String title, String message);
}
