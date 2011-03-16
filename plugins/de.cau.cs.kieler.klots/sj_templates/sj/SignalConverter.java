/*
 * SJ - Synchronous Java.
 *
 * http://www.informatik.uni-kiel.de/rtsys/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package sj;

import sj.exceptions.SignalNotDeclaredException;

/**
 * Utility class to convert different signal representations.
 * 
 * @author mhei
 * 
 */
public final class SignalConverter {

    /**
     * This utility class does not need a public constructor.
     */
    private SignalConverter() {

    }

    /**
     * Converts a given string representation of a signal to a signal object.
     * 
     * Attention: signal2String is case sensitive. "A" != "a"!
     * 
     * @param program
     *            The program the signal is part of.
     * @param signalName
     *            The of the signal we want the object representation of.
     * @return the signal object with the given signal name
     *
     */
    public static Signal string2Signal(final EmbeddedSJProgram<?> program, final String signalName) {

        for (Signal s : program.getSignals()) {
            if (s.getName().equals(signalName/*.trim()*/)) { //FIXME: replace trim in leJOS
                return s;
            }
        }
        throw new SignalNotDeclaredException(
                "The given signalname is not part of the given program "
                        + "and can not convert so a signal object");

    }

    // NiceToHave: jsonString2Signal

}
