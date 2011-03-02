/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
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
package de.cau.cs.kieler.klay.debugview;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

/**
 * The debug window houses controls that allow the user to inspect the debug output
 * produced by Klay Layered.
 * 
 * @author cds
 */
public class DebugWindow extends ApplicationWindow {
    
    // UI CONTROLS
    private Combo folderCombo = null;
    private Button folderBrowseButton = null;
    private Table fileTable = null;
    private TableViewer fileTableViewer = null;
    private Composite imageComposite = null;
    

    /**
     * Constructs a new instance with the given parent shell.
     * 
     * @param parentShell the window's parent.
     */
    protected DebugWindow(final Shell parentShell) {
        super(parentShell);
        
        // Configure the window
        addCoolBar(SWT.FLAT | SWT.HORIZONTAL);
        addStatusLine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Control createContents(final Composite parent) {
        Composite mainContentComposite = createMainContent(parent);
        
        setupCoolBar();
        
        setStatus("Welcome, stranger!");
        
        return mainContentComposite;
    }
    
    /**
     * Creates the main controls to be displayed in the window.
     * 
     * @param parent the parent composite.
     * @return the composite holding the main content.
     */
    private Composite createMainContent(final Composite parent) {
        // GUI code needs magic numbers
        // CHECKSTYLEOFF MagicNumber
        
        Composite composite = new Composite(parent, SWT.NULL);
        composite.setLayout(new FillLayout());
        
        // Sash Form
        SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL | SWT.SMOOTH);
        sashForm.setLayout(new FillLayout());
        
        // Table
        fileTable = new Table(sashForm, SWT.SINGLE | SWT.FULL_SELECTION);
        
        // Image Composite
        imageComposite = new Composite(sashForm, SWT.NULL);
        
        // Set sash form weights
        sashForm.setWeights(new int[] {30, 70});
        
        return composite;
        
        // CHECKSTYLEON MagicNumber
    }
    
    /**
     * Adds all necessary controls to the coolbar.
     */
    private void setupCoolBar() {
        ICoolBarManager manager = getCoolBarManager2();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
