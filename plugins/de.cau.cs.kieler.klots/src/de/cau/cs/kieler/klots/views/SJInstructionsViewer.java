package de.cau.cs.kieler.klots.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;


public class SJInstructionsViewer extends TreeViewer {
	
	public static final String ID = "de.cau.cs.kieler.klots.view.SJInstructionsViewer";

    // -------------------------------------------------------------------------

    /**
     * Instantiates a new SJInstructionsViewer.
     * 
     * @param parent
     *            the composite parent
     * @param style
     *            the style
     */
    public SJInstructionsViewer(final Composite parent, final int style) {
        super(parent, style);
    }

    // -------------------------------------------------------------------------

    /**
     * Instantiates a new SJInstructionsViewer.
     * 
     * @param parent
     *            the composite parent
     */
    public SJInstructionsViewer(final Composite parent) {
        super(parent);
    }

    // -------------------------------------------------------------------------

    /**
     * Instantiates a new SJInstructionsViewer.
     * 
     * @param table
     *            the table
     */
    public SJInstructionsViewer(final Table table) {
        super(table);
    }

}
