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
package examples;

import java.io.IOException;

import sj.EmbeddedSJProgram;
import sj.EmbeddedSJProgramStarter;
import sj.Signal;
import examples.EmbeddedABRO.StateLabel;
/* Note: In order to allow static imports, the Java Compiler compliance level
 * should be set to 1.5 */
// CHECKSTYLEOFF AbstractCheck
import static examples.EmbeddedABRO.StateLabel.*;

/**
 * The program ABRO. ABRO is the "hello world" of synchronous languages. This
 * version of ABRO in Synchronous Java (SJ) can be run on Lego Mindstorms NXT
 * systems. This implementation is based on the Synchronous C (SC) version of
 * ABRO. For informations about SC see the
 * <a href="http://www.informatik.uni-kiel.de/rtsys/sc" target="_parent">
 * SC homepage
 * </a>.
 * 
 * @author mhei, ybe
 * @see ABRO
 * @version 1.1
 */
public class EmbeddedABRO extends EmbeddedSJProgram<StateLabel> {

    /**
     * The labels used for the different parts of the program.
     */
    enum StateLabel { ABO, AB, WaitA, WaitB, ABMain, ABOMain }

    /**
     * The signals used by the program.
     * Because the class EmbeddedSJProgram is in a different package than
     * this program, all signals must be public.
     */
    // SUPPRESS CHECKSTYLE NEXT VisibilityModifierCheck
    public Signal a, b, r, o;

    // CHECKSTYLEOFF MagicNumber
    // Priority's are part of the SJ concept and are not magic numbers.

    /**
     * Initializes a new instance of EmbeddedABRO.
     */
    public EmbeddedABRO() {
        // Start EmbeddedABRO at label ABO with priority 4.
        super(ABO, 4);
        a = new Signal("a");
        b = new Signal("b");
        r = new Signal("r");
        o = new Signal("o");
        addSignals(a, b, r, o);
    }


    /**
     * Starts the program.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        try {
            EmbeddedSJProgramStarter.start(new EmbeddedABRO(), "ABRO");
        } catch (IOException e) {
            // ignore
        }
    }


    /**
     * The heart method of the EmbeddedABRO program.
     * tick() is executed each macrostep until program termination.
     */
    @Override
    public void tick() {
        while (!isTickDone()) {
            switch (state()) {
            case ABO:
                fork(AB, 1);
                forkEB(ABOMain);
                break;

            case AB:
                fork(WaitA, 2);
                fork(WaitB, 3);
                forkEB(ABMain);
                break;

            case WaitA:
                if (awaitDoneCB(a)) {
                    termB();
                }
                break;

            case WaitB:
                if (awaitDoneCB(b)) {
                    termB();
                }
                break;

            case ABMain:
                if (joinDoneCB()) {
                    o.emit();
                    termB();
                }
                break;

            case ABOMain:
                if (awaitDoneCB(r)) {
                    transB(ABO);
                }
                break;
            }
        }
    }
}
