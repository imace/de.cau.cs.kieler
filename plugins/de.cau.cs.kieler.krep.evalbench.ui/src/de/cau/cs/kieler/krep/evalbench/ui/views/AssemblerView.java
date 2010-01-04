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
package de.cau.cs.kieler.krep.evalbench.ui.views;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.krep.evalbench.ui.Activator;
import de.cau.cs.kieler.krep.evalbench.program.IAssembler;
import de.cau.cs.kieler.krep.evalbench.ui.editors.ProgramContentProvider;
import de.cau.cs.kieler.krep.evalbench.ui.editors.ProgramLabelProvider;

/**
 * @author ctr
 * 
 */
public class AssemblerView extends ViewPart {

    /** The identifier string for this view. */
    public static final String VIEW_ID = "de.cau.cs.kieler.krep.evalbench.ui.views.assembler";

    /** Column identifiers for the embedded table. */
    private static final String[] COLUMN_NAMES = { "index", "label", "instruction", "opcode" };

    private static final int[] COLUMN_WIDTH = { 40, 90, 300, 50 };

    private static final int[] COLUMN_ALIGN = { SWT.RIGHT, SWT.LEFT, SWT.LEFT, SWT.LEFT };
    /** Activator for this view. */
    public Activator activator = null;

    /** The embedded table. */
    private Table table = null;

    /** The viewer used to display program instructions. */
    private TableViewer viewer = null;

    /**
     * Generate an empty assembler viewer.
     */
    public AssemblerView() {
        super();
        activator = Activator.getDefault();
        activator.setViewer(this);
    }

    @Override
    public final void createPartControl(final Composite parent) {
        // create table
        table = new Table(parent, SWT.MULTI);

        TableColumn column;
        for (int i = 0; i < COLUMN_WIDTH.length; i++) {
            column = new TableColumn(table, COLUMN_ALIGN[i], i);
            column.setText(COLUMN_NAMES[i]);
            column.setWidth(COLUMN_WIDTH[i]);
        }
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        // create table viewer
        viewer = new TableViewer(table);
        viewer.setColumnProperties(COLUMN_NAMES);
        viewer.setContentProvider(new ProgramContentProvider());
        viewer.setLabelProvider(new ProgramLabelProvider());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
     */
    @Override
    public void setFocus() {
        // Nothing to do
    }

    /**
     * Set the assembler that is displayed in the assembler view.
     * 
     * @param assembler
     *            the new assembler that shall be display.
     */
    public final void setAssembler(final IAssembler assembler) {
        if (viewer != null) {
            viewer.setInput(assembler.getInstructions());
            viewer.refresh();
        }
    }

    /**
     * Highlight the currently executed instructions.
     * 
     * @param trace
     *            the active assembler instructions. This is the actual number of instructions, the
     *            assembler is responsible to map them to lines in the assembler.
     */
    public final void markTrace(final int[] trace) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                table.deselectAll();
                table.select(trace);
            }

        });
    }
}
