/*
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
 */
package de.cau.cs.kieler.krep.evalbench.trace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

import de.cau.cs.kieler.krep.evalbench.Activator;
import de.cau.cs.kieler.krep.evalbench.exceptions.CommunicationException;
import de.cau.cs.kieler.krep.evalbench.exceptions.ParseException;
import de.cau.cs.kieler.krep.evalbench.program.IAssembler;
import de.cau.cs.kieler.krep.evalbench.trace.esi.esiParser;
import de.cau.cs.kieler.krep.evalbench.trace.rif.rifParser;
import de.cau.cs.kieler.krep.evalbench.ui.views.MessageView;

/**
 * @author ctr
 * 
 *         a list of different independent traces, as they are stored in esi files
 */
public class TraceList implements IPartListener {

    /**
     * 
     */
    private static final long serialVersionUID = 5484327142382381107L;

    private ListIterator<Trace> iterator;

    LinkedList<Trace> traces;

    private Trace current;

    private int tablePos;

    private int size = 0;

    private int avg = 0;
    private int min = Integer.MAX_VALUE;
    private int max = 0;

    private static LinkedList<ITraceListener> listeners = new LinkedList<ITraceListener>();

    /**
     * Read a trace list from a trace file. Supported file types are esi, eso and rif.
     * 
     * @param asm
     *            Assembler, for which the test is. This is needed to generate signal indices.
     * @param baseName
     *            name of the trace file without the file suffix
     */
    public TraceList(final IAssembler asm, final String baseName) {
        super();
        traces = new LinkedList<Trace>();
        try {
            File traceFile = null; // = new File(baseName + ".rif");
            if ((new File(baseName + ".rif")).exists()) {
                traceFile = new File(baseName + ".rif");
                traces.add(rifParser.parse(asm, new FileReader(traceFile)));
            } else if ((new File(baseName + ".eso")).exists()) {
                traceFile = new File(baseName + ".eso");
                traces.addAll(esiParser.parse(asm, new FileReader(traceFile)));
            } else if (new File(baseName + ".esi").exists()) {
                traceFile = new File(baseName + ".esi");
                traces.addAll(esiParser.parse(asm, new FileReader(traceFile)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            traces.clear();
            MessageView.print(e.getMessage());
            e.printStackTrace();
        }
        for (Trace trace : traces) {
            size += trace.size() + 1;
            trace.snapshot();
        }
        reset();
        notifyListeners(true);
    }

    /**
     * generate an empty trace list.
     */
    public TraceList() {
        super();
        traces = new LinkedList<Trace>();
        reset();
        notifyListeners(true);
    }

    // Iterator access
    /**
     * @return true if another tick or trace exists
     */
    public boolean hasNext() {
        return iterator.hasNext() || (current != null && current.hasNext());
    }

    /**
     * @return next tick, null if a new trace is started
     */
    public Tick next() {
        tablePos++;
        if (current == null || !current.hasNext()) {
            // start next trace
            current = iterator.next();
            return null;
        } else {
            return current.next();
        }
    }

    /**
     * @return index of the next tick
     */
    public int nextIndex() {
        return iterator.nextIndex();
    }

    /**
     * reset current position to first tick in first trace, delete all output.
     */
    public void reset() {
        tablePos = 0;
        for (Trace t : traces) {
            t.reset();
        }
        notifyListeners(true);
        iterator = traces.listIterator();
        current = null;
        min = Integer.MAX_VALUE;
        max = 0;
        avg = 0;
    }

    /**
     * @return get absolute index of the current position, including all preceding traces
     */
    public int getTablePos() {
        return tablePos;
    }

    /**
     * @return textual representation of the current trace, including input, outputs, reaction time
     *         and additional remarks when an error occurred during simulation
     * 
     */
    public LinkedList<String[]> getTable() {
        final LinkedList<String[]> res = new LinkedList<String[]>();
        int i = 0;
        for (final Trace t : traces) {
            final String[] reset = { "reset", "", "", "", "" };
            i++;
            res.add(reset);
            res.addAll(t.getTicks());
        }
        return res;
    }

    /**
     * Adds a new trace listener that is notified of tick events.
     * 
     * @param listener
     *            listener to be added
     */
    public static void addListener(final ITraceListener listener) {
        listeners.add(listener);
    }

    /**
     * remove a trace listener.
     * 
     * @param listener
     *            to remove
     */
    public static void removeListener(final ITraceListener listener) {
        listeners.remove(listener);
    }

    /**
     * notify all listeners, that the status of the trace has changed.
     * 
     * @param newTrace
     *            true if the complete trace has changed, false if only the current step changed
     */
    public static void notifyListeners(final boolean newTrace) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                Iterator<ITraceListener> i = listeners.iterator();
                while (i.hasNext()) {
                    i.next().traceChanged(newTrace);
                }
            }
        });
    }

    // Editor functions
    /**
     * {@inheritDoc}
     * 
     */
    public void partActivated(final IWorkbenchPart part) {
        // nothing to do
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void partBroughtToTop(final IWorkbenchPart part) {
        // nothing to do
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void partClosed(final IWorkbenchPart part) {
        // nothing to do
    }

    /**
     * {@inheritDoc}
     * 
     */
    public void partDeactivated(final IWorkbenchPart part) {
        // nothing to do

    }

    /**
     * {@inheritDoc}
     * 
     */
    public void partOpened(final IWorkbenchPart part) {
        notifyListeners(true);

    }

    /**
     * @param output
     *            the new output for this tick
     */
    public void setOutput(final Tick output) {
        if (current != null) {
            current.setOutput(output);
        }
    }

    /**
     * @return true when the current tick matches the reference output
     */
    public boolean validateCurrent() {
        if (current != null) {
            return current.validateCurrent();
        }
        return true;
    }

    /**
     * Execute one step of the current trace.
     * 
     * @return when the outputs match the reference output
     * @param manager
     *            to display the current status
     * @throws CommunicationException
     *             thrown for any communication errors
     */
    public boolean executeStep(final IStatusLineManager manager) throws CommunicationException {
        // System.out.println("execute step " + this.tablePos + "/" + size);
        if (hasNext()) {
            Tick tick = next();
            if (tick == null) {
                Activator.getDefault().commonLayer.reset();
                notifyListeners(false);
                return true;
            } else {
                Tick output = Activator.getDefault().commonLayer.step(tick);
                setOutput(output);
                boolean valid = validateCurrent();

                final int pos = this.tablePos;
                final int rt = output.getRT();
                min = Math.min(min, rt);
                max = Math.max(rt, max);
                avg += rt;
                final int dmin = min;
                final int dmax = max;
                final int davg = avg;
                final int dsize = size;

                /** update display each steps*/
                final int updateEach = 128;
                
                if (!hasNext() || pos % updateEach == 0) {
                    Display.getDefault().asyncExec(new Runnable() {
                        public void run() {
                            if (!manager.isDirty()) {
                                manager.setMessage("Tick " + pos + "/" + dsize + ": " + rt + " {"
                                        + dmin + ", " + davg / pos + ", " + dmax + "}");
                            }
                        }

                    });
                }
                notifyListeners(true);
                return valid;
            }
        }
        return true;
    }

    /**
     * @return true if the output of all ticks matches the reference output
     */
    public final boolean isValid() {
        for (final Trace t : traces) {
            if (!t.isValid()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return String that contains minimal, average and maximal reaction time
     */
    public String getWCRT() {
        int minRT = Integer.MAX_VALUE;
        int maxRT = 0;
        int n = 0;
        int sum = 0;
        int avgRT = 0;
        for (final Trace trace : traces) {
            for (final Tick tick : trace.ticks) {
                final int i = tick.getRT();
                if (i < minRT) {
                    minRT = i;
                }
                if (i > maxRT) {
                    maxRT = i;
                }
                n++;
                sum += i;
            }
        }
        if (n > 0) {
            avgRT = sum / n;
        }
        return "{" + minRT + " / " + avgRT + " / " + maxRT + "}";
    }

    /**
     * @return complete size of all traces, including reset steps
     */
    public int size() {
        return size;
    }
}
