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
package examples;

import sj.EmbeddedSJProgram;
import sj.Signal;
import examples.EmbeddedABRO.StateLabel;
import static examples.EmbeddedABRO.StateLabel.*;

/**
 * 
 * The program ABRO. ABRO is the "hello world" of synchronous languages. This is the version of ABRO
 * in SJ that can be used on embedded systems. This implementation based on the SC version of ABRO.
 * For informations about SC see the <a href="http://www.informatik.uni-kiel.de/rtsys/sc"
 * target="_parent">SC homepage</a>.
 * 
 * @author mhei
 * @see ABRO
 * 
 */
public class EmbeddedABRO extends EmbeddedSJProgram<StateLabel> {

    /**
     * The labels used for the different parts of the program.
     */
    enum StateLabel {
        ABO, AB, WaitA, WaitB, ABMain, ABOMain
    }

    /**
     * The signals used by the Program.
     * 
     * Because the class SJProgram is in a different package than this program, all signals must be
     * public.
     */
    // SUPPRESS CHECKSTYLE NEXT VisibilityModifierCheck
    public Signal a, b, r, o;

    // CHECKSTYLEOFF MagicNumber
    // Priority's are part of the concept and not magic numbers

    /**
     * Starts a new instance of the program EmbeddedABRO.
     */
    public EmbeddedABRO() {
        // start ABRO at label ABO with the priority 4
        super(ABO, 4);
        a = new Signal("a");
        b = new Signal("b");
        r = new Signal("r");
        o = new Signal("o");
        addSignals(a, b, r, o);
    }

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
            	Motor.A.setSpeed(720);
                forkEB(ABMain);
                break;

            case WaitA:
                if (awaitDoneCB(a)) {
                	Motor.A.forward();
                    termB();
                }
                break;

            case WaitB:
                if (awaitDoneCB(b)) {
                	Motor.A.backward();
                    termB();
                }
                break;

            case ABMain:
                if (joinDoneCB()) {
                    o.emit();
                	Motor.A.stop();
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