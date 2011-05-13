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
package de.cau.cs.kieler.klots.sj.embedded;

//import lejos.nxt.Button;
//import lejos.nxt.LCD;

import java.io.IOException;

import sj.EmbeddedSJProgram;
import sj.SJLogger;
import sj.Signal;
import sj.exceptions.SignalNotDeclaredException;
import sj.util.LinkedList;


/**
 * @author root
 *
 */
public class EmbeddedSJProgramStarter {

    
    /**
     * @param str 
     * @param program 
     * @return Signal 
     * @throws SignalNotDeclaredException 
     */
    public static Signal string2Signal(final String str, final EmbeddedSJProgram<?> program)
        throws SignalNotDeclaredException {
        Signal[] signals = program.getSignals();
        for (Signal s : signals) {
            if (s.getName().equals(str)) {
                return s;
            }
        }
        throw new SignalNotDeclaredException("Signal " + str + " is not known by program "
                + program.getName() + "!");
    }


    
    /**
     * @param program 
     * @throws IOException 
     */
    public static void start(final EmbeddedSJProgram<?> program) throws IOException {
        start(program, "Program", null);
    }


    
    /**
     * @param program 
     * @param programName 
     * @throws IOException 
     */
    public static void start(final EmbeddedSJProgram<?> program, final String programName)
    throws IOException {
        start(program, programName, null);
    }


    
    /**
     * @param program 
     * @param console 
     * @throws IOException 
     */
    public static void start(final EmbeddedSJProgram<?> program, final EmbeddedRemoteConsole console)
    throws IOException {
        start(program, "Program", console);
    }


    
    /**
     * @param program 
     * @param programName 
     * @param console 
     * @throws IOException 
     */
    public static void start(final EmbeddedSJProgram<?> program, final String programName,
            final EmbeddedRemoteConsole console) throws IOException {
        System.out.println("     ");
        System.out.print("ENTER DEBUG MODE?");

//        int buttonPressed = Button.waitForPress();
//        if (buttonPressed == Button.ID_ESCAPE) {
//            System.out.println("  NO");
//            normalMode(program, programName);
//        } else if (buttonPressed == Button.ID_ENTER) {
//            System.out.println("  YES");
//            debugMode(program, programName, console);
//        }
    }



    // ######################################################################
    // ###################           DEBUG MODE           ###################
    // ######################################################################

    private static void debugMode(final EmbeddedSJProgram<?> program, final String programName,
            final EmbeddedRemoteConsole console) {
        // ----------------------- init debug mode --------------------------
        System.out.println("     ");
        System.out.println("|> DEBUG MODE <|");
        System.out.println("     ");
        System.out.println("Waiting for PC  connection...");
        EmbeddedPCCommunicator pcComm = EmbeddedPCCommunicator.getInstance();
        if (console != null) {
            console.openSJMode();
        }
        SJLogger logger = new EmbeddedPCLogger(pcComm);
        program.setLogger(logger);
        System.out.println("     ");
        System.out.println(programName + " is running");
        System.out.println("     ");
        String comm = "";
        int count = 0;
        String[] signals = null;
        pcComm.sendMessage(
                EmbeddedConstants.SYNCHRONIZED_COMMAND_KEY
                + EmbeddedConstants.MESSAGE_LINE_DELIMITER
                + EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY
                + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
        // ------------------------------------------------------------------

        while (!program.isTerminated()) {

            // ------------------ processing PC input -----------------------
            System.out.println("DO NEXT STEP");
            comm = pcComm.receiveMessage().toString();
            System.out.println("INPUT: >" + comm + "<");

            if (comm.substring(0, EmbeddedConstants.STEP_COMMAND_KEY.length())
                    .equals(EmbeddedConstants.STEP_COMMAND_KEY)) {
                System.out.println("NEXT STEP OK");
                comm = comm.substring(EmbeddedConstants.STEP_COMMAND_KEY.length());

                // if there are no input signals do tick without inputs
                if (comm.length() < 2) {
                    doTick(program, null);
                    pcComm.sendMessage(EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY
                            + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
                    continue;
                }

                count = 1;
                for (int i = 0; i < comm.length(); i++) {
                    if (comm.charAt(i) == EmbeddedConstants.SEMICOLON_CHAR) {
                        count++;
                    }
                }
                signals = new String[count];
                count = 0;
                for (int i = 0, j = 0; i < comm.length(); i++) {
                    if (comm.charAt(i) == EmbeddedConstants.SEMICOLON_CHAR) {
                        signals[j] = comm.substring(count, i);
                        count = i + 1;
                        j++;
                        System.out.println("S:>" + signals[j - 1] + "<");
                    }
                }
                signals[signals.length - 1] = comm.substring(count, comm.length());
                System.out.println("S:>" + signals[signals.length - 1] + "<");

            } else if (comm.equals(EmbeddedConstants.STOP_COMMAND_KEY)) {
                pcComm.destroy();
//                LCD.clearDisplay();
                System.out.println("                ");
                System.out.println("                ");
                System.out.println("----------------");
                System.out.println("EXITING PROGRAM!");
                System.out.println("----------------");
                System.out.println("                ");
                System.out.println("                ");
                System.out.println("                ");
                try {
                    java.lang.Thread.sleep(1000);
                } catch (Exception e) {
                    ;
                }
                System.exit(0);

            } else {
                System.out.println("COMMAND ERROR");
                try {
                    java.lang.Thread.sleep(2000);
                } catch (Exception e) {
                    ;
                }
            }
            // --------------------------------------------------------------

            // ------- supply input signals to program and run tick() -------
            doTick(program, signals);
            pcComm.sendMessage(EmbeddedConstants.END_OF_MESSAGE_COMMAND_KEY
                    + EmbeddedConstants.MESSAGE_LINE_DELIMITER);
            // --------------------------------------------------------------

        } // END while (!program.isTerminated())
        pcComm.destroy();
        if (console != null) {
            console.close();
        }

    }



    // ######################################################################
    // ##################           NORMAL MODE           ###################
    // ######################################################################

    /**
     * @param program 
     * @param programName 
     */
    private static void normalMode(final EmbeddedSJProgram<?> program, final String programName) {
        // ----------------------- init normal mode -------------------------
        System.out.println("     ");
        System.out.println(programName + " is running");
        System.out.println("     ");

        String[] signals = null;
        Signal[] knownSignals;
        LinkedList<String> presentSignals = new LinkedList<String>();

        boolean inputExpected = false;
        System.out.print("Does " + programName + " expect signal inputs?");
//        int buttonPressed = Button.waitForPress();
//        if (buttonPressed == Button.ID_ESCAPE) {
//            System.out.println("  NO");
//            System.out.println("                ");
//            System.out.println("                ");
//            System.out.println("----------------");
//            System.out.println("STANDALONE MODE!");
//            System.out.println("----------------");
//            System.out.println("                ");
//            System.out.println("                ");
//            inputExpected = false;
//        } else if (buttonPressed == Button.ID_ENTER) {
//            System.out.println("  YES");
//            inputExpected = true;
//        } else {
//            System.out.println("\nI TAKE THIS AS A\nYES");
//            inputExpected = true;
//        }
        // ------------------------------------------------------------------

        while (!program.isTerminated()) {

            // ---------------- processing button input ---------------------
//            LCD.refresh();
//            if (inputExpected) {
//                presentSignals.clear();
//                System.out.println("Input signals:");
//                knownSignals = program.getSignals();
//                for (int i = 0; i < knownSignals.length; i++) {
//                    System.out.print(knownSignals[i].getName() + ": ");
//                    buttonPressed = Button.waitForPress();
//
//                    if (buttonPressed == Button.ID_LEFT) {
//                        System.out.println("\nAre you sure you\nwant to exit?");
//                        buttonPressed = Button.waitForPress();
//                        if (buttonPressed == Button.ID_ENTER) {
//                            LCD.clearDisplay();
//                            System.out.println("                ");
//                            System.out.println("                ");
//                            System.out.println("----------------");
//                            System.out.println("EXITING PROGRAM!");
//                            System.out.println("----------------");
//                            System.out.println("                ");
//                            System.out.println("                ");
//                            System.out.println("                ");
//                            try {
//                                java.lang.Thread.sleep(1000);
//                            } catch (Exception e) {
//                                ;
//                            }
//                            System.exit(0);
//                        } else {
//                            System.out.println("Input signals:");
//                            i--;
//                            continue;
//                        }
//
//                    } else if (buttonPressed == Button.ID_ENTER) {
//                        presentSignals.add(knownSignals[i].getName() + EmbeddedConstants.COMMA_STRING
//                                + EmbeddedConstants.NULL_STRING);
//                        System.out.println("+");
//
//                    } else {
//                        System.out.println("-");
//                    }
//                } // end for
//
//                signals = new String[presentSignals.size()];
//                int i = 0;
//                for (String s : presentSignals) {
//                    signals[i] = s;
//                    i++;
//                }
//
//            } // end if(inputExpected)
            // --------------------------------------------------------------

            // ------- supply input signals to program and run tick() -------
            doTick(program, signals);
            // --------------------------------------------------------------

        } // end while(!program.isTerminated())
    }



    // ######################################################################
    // #######           DO TICK (same for both run modes)           ########
    // ######################################################################

    private static void doTick(final EmbeddedSJProgram<?> program, final String[] signals) {
//        LCD.refresh();

        // if no input signals do tick without signals
//        if (signals == null) {
//            program.doTick();
//            return;
//        }

        // if there are input signals process input
        Signal[] signalArray = new Signal[signals.length];
        int index = 0;
        Signal sig;
        for (int i = 0; i < signals.length; i++) {
            index = signals[i].indexOf(EmbeddedConstants.COMMA_CHAR);
            // item is not a proper signal
            if (index < 0) {
                continue;
            }
            // add signal to list
            try {
                sig = string2Signal(signals[i].substring(0, index) + "", program);
                // if signal is a valued signal update value
                if (!(signals[i].substring(index + 1)).equals(EmbeddedConstants.NULL_STRING)) {
                    // TODO: deal with valued signals
                }
                signalArray[i] = sig;
            } catch (SignalNotDeclaredException e) {
                System.out.println("SIGNAL INPUT ERR");
            }
        }
        program.doTick(signalArray);
    }

}