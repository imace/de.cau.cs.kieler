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
package de.cau.cs.kieler.sim.signals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

/**
 * The SignalASCIITimeLinePlotter plots ASCII art signals to a text file.
 * 
 * @author cmot
 */
public abstract class SignalASCIIPlotter {

    // -------------------------------------------------------------------------

    /**
     * Creates the spaced label.
     * 
     * @param text
     *            the text
     * @param length
     *            the length
     * @param align
     *            the align
     * @return the string
     */
    protected String createSpacedLabel(final String text, final int length, final int align) {
        return createSpacedLabel(text, length, align, ' ');
    }

    // -------------------------------------------------------------------------

    /**
     * Creates the spaced label.
     * 
     * @param text
     *            the text
     * @param length
     *            the length
     * @param align
     *            the style, 0 centered, -1 left, 1 right
     * @param fillChar
     *            the fill char
     * @return the string
     */
    protected String createSpacedLabel(final String text, final int length, final int align,
            final char fillChar) {

        String spaceL = "";
        String spaceR = "";
        if (align == -1) {
            // left
            spaceR = getSpaceCharacters(length - text.length(), fillChar);
        } else if (align == 1) {
            // left
            spaceL = getSpaceCharacters(length - text.length(), fillChar);
        } else {
            spaceR = getSpaceCharacters((length - text.length()) / 2, fillChar);
            spaceL = getSpaceCharacters(length - text.length() - spaceR.length(), fillChar);
        }
        return (spaceL + text + spaceR);
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the space characters.
     * 
     * @param num
     *            the num
     * @return the space characters
     */
    protected String getSpaceCharacters(final int num) {
        return getSpaceCharacters(num, ' ');
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the space characters.
     * 
     * @param num
     *            the num
     * @param fillChar
     *            the fill char
     * @return the space characters
     */
    protected String getSpaceCharacters(final int num, final char fillChar) {
        String returnText = "";
        while (returnText.length() < num) {
            returnText = fillChar + returnText;
        }
        return returnText;
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the tick labels.
     * 
     * @param minTick
     *            the min tick
     * @param maxTick
     *            the max tick
     * @param maxSignalNameLength
     *            the max signal name length
     * @return the tick labels
     */
    protected String[] getTickLabels(final long minTick, final long maxTick,
            final int maxSignalNameLength) {
        int lines = (maxTick + "").length();
        String[] ascii = new String[lines];

        for (int line = 0; line < ascii.length; line++) {
            ascii[line] = getSpaceCharacters(maxSignalNameLength) + "  ";
        }

        for (long tick = minTick; tick <= maxTick; tick++) {
            String tickString = tick + "";
            tickString = getSpaceCharacters(lines - tickString.length()) + tickString;
            for (int line = 0; line < ascii.length; line++) {
                String tickStringPart = tickString.substring(line, line + 1);
                ascii[line] += tickStringPart + " ";
            }
        }

        return ascii;
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the ASCI signal data.
     *
     * @param minTick the min tick
     * @param maxTick the max tick
     * @param signal the signal
     * @param maxSignalNameLength the max signal name length
     * @return the aSCI signal data
     */
    protected String[] getASCISignalData(final long minTick, final long maxTick,
            final Signal signal, final int maxSignalNameLength) {
        String[] ascii = new String[2];

        // build label
        String signalLabel = signal.getName();
        signalLabel = getSpaceCharacters(maxSignalNameLength - signalLabel.length()) + signalLabel
                + " ";
        String nullLabel = getSpaceCharacters(signalLabel.length());

        ascii[0] = nullLabel;
        ascii[1] = signalLabel;

        // build data
        boolean presentBefore = false;
        for (long tick = minTick; tick <= maxTick; tick++) {
            // get the current present value
            boolean present = signal.isPresent(tick);
            // in the first tick start as if this present value was the one
            // before
            if (tick == signal.getMinTick()) {
                presentBefore = present;
            }

            // stay present
            if (presentBefore && present) {
                ascii[0] += "__";
                ascii[1] += "  ";
            } else if (!presentBefore && present) {
                ascii[0] += " _";
                ascii[1] += "| ";
            } else if (presentBefore && !present) {
                ascii[0] += "  ";
                ascii[1] += "|_";
            } else if (!presentBefore && !present) {
                ascii[0] += "  ";
                ascii[1] += "__";
            }

            presentBefore = present;
        }

        return ascii;
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the max signal name length.
     *
     * @param signalList the signal list
     * @return the max signal name length
     */
    protected int getMaxSignalNameLength(final SignalList signalList) {
        int maxLength = 0;
        for (Signal signal : signalList) {
            maxLength = Math.max(maxLength, signal.getName().length());
        }
        return maxLength;
    }

    // -------------------------------------------------------------------------

    /**
     * Plot ASCII.
     * 
     * @param signalList
     *            the signal list
     * @return the string[]
     */
    public String[] plot(final SignalList signalList) {
        LinkedList<String> stringList = new LinkedList<String>();
        return (String[]) stringList.toArray(new String[signalList.size()]);
    }

    // -------------------------------------------------------------------------

    /**
     * Export to ASCII text file.
     *
     * @param path the path
     * @param signalList the signal list
     */
    public void plotToTextFile(final IPath path, final SignalList signalList) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        IFile file = root.getFile(path);

        try {
            if (!file.exists()) {
                file.create(null, IResource.NONE, null);
            }
            String stringPath = file.getRawLocation().toString();
            PrintWriter out = new PrintWriter(stringPath);

            // ASCII plot
            String[] ascii = plot(signalList);

            // write to file
            for (String line : ascii) {
                out.println(line);
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------------------------

    /**
     * Export to ESO ASCII text file appending a new execution run if the file already exists.
     *
     * @param path the path
     * @param signalList the signal list
     * @param inputSignalList the input signal list
     * @param outputSignalList the output signal list
     */
    public void plotToEsoFile(final IPath path, final SignalList signalList,
            final List<Signal> inputSignalList, final List<Signal> outputSignalList) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        IFile file = root.getFile(path);
        boolean newFile = false;
        LinkedList<String> oldFileContent = new LinkedList<String>();

        try {
            if (!file.exists()) {
                file.create(null, IResource.NONE, null);
                newFile = true;
            }

            String stringPath = file.getRawLocation().toString();

            if (!newFile) {
                // copy old contents
                FileInputStream fis = new FileInputStream(stringPath);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String line;
                while ((line = br.readLine()) != null) {
                    oldFileContent.add(line);
                }
                br.close();
                fis.close();
            }

            PrintWriter out = new PrintWriter(stringPath);

            if (!newFile) {
                // restore old contents
                for (String line : oldFileContent) {
                    out.println(line);
                }
            }

            long maxTick = signalList.getMaxTick();

            out.println("! reset;");
            for (long tick = 1; tick <= maxTick; tick++) {
                for (Signal inputSignal : inputSignalList) {
                    if (inputSignal.isPresent(tick)) {
                        out.print(inputSignal.getName() + " ");
                    }
                }
                out.println("");
                out.print("% Output: ");
                for (Signal outputSignal : outputSignalList) {
                    if (outputSignal.isPresent(tick)) {
                        out.print(outputSignal.getName() + " ");
                    }
                }
                out.println("");
                out.println(";");
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------------------------

}
