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
package de.cau.cs.kieler.klots;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.klots.wizards.NewPOJFileWizard;
import de.cau.cs.kieler.klots.wizards.NewSJFileWizard;
import de.cau.cs.kieler.klots.wizards.NewSJProjectWizard;

/**
 * 
 * @author root
 */
public class KlotsPerspective implements IPerspectiveFactory {
    
    /** The ID of the KLOTS perspective. */
    public static final String ID = "de.cau.cs.kieler.klots.KlotsPerspective";
    
    // CHECKSTYLEOFF LineLength
    
    private static final String VIEW_KLOTS = "de.cau.cs.kieler.klots.view.SJInstructionsView"; //$NON-NLS-1$
    private static final String VIEW_KIEM = "de.cau.cs.kieler.sim.kiem.view"; //$NON-NLS-1$
    private static final String VIEW_KIEM_TABLE = "de.cau.cs.kieler.sim.table.view"; //$NON-NLS-1$

    private static final String WIZ_KLOTS = NewSJProjectWizard.ID;
    private static final String WIZ_KLOTS_SJ_FILE = NewSJFileWizard.ID;
    private static final String WIZ_KLOTS_POJ_FILE = NewPOJFileWizard.ID;
    private static final String WIZ_FILE = "org.eclipse.ui.wizards.new.file"; //$NON-NLS-1$
    private static final String WIZ_PROJECT = "org.eclipse.ui.wizards.new.project"; //$NON-NLS-1$

    private static final String RIGHT_TOP_VIEW_SITE_ID = "de.cau.cs.kieler.klots.KlotsPerspective.RightTopViewSite";
    private static final String RIGHT_BOTTOM_VIEW_SITE_ID = "de.cau.cs.kieler.klots.KlotsPerspective.RightBottomViewSite";

    private static final float LEFT_TO_RIGHT_RATIO = (float) 0.61;
    private static final float TOP_TO_BOTTOM_RATIO = (float) 0.38;
    
    // CHECKSTYLEON LineLength

    
    
    /**
     * {@inheritDoc}
     */
    public void createInitialLayout(final IPageLayout layout) {
        createNewWizardShortcuts(layout);
        createViewLayout(layout);
        createViewShortcuts(layout);
    }

    
    
    /**
     * @param layout 
     */
    protected void createViewShortcuts(final IPageLayout layout) {
        layout.addShowViewShortcut(VIEW_KLOTS);
        layout.addShowViewShortcut(VIEW_KIEM);
        layout.addShowViewShortcut(VIEW_KIEM_TABLE);
        layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
        layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
        layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
        // layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
        layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
    }

    
    
    /**
     * @param layout 
     */
    protected void createNewWizardShortcuts(final IPageLayout layout) {
        layout.addNewWizardShortcut(WIZ_PROJECT);
        layout.addNewWizardShortcut(WIZ_FILE);
        layout.addNewWizardShortcut(WIZ_KLOTS);
        layout.addNewWizardShortcut(WIZ_KLOTS_SJ_FILE);
        layout.addNewWizardShortcut(WIZ_KLOTS_POJ_FILE);
    }

    
    
    /**
     * @param layout 
     */
    protected void createViewLayout(final IPageLayout layout) {
        String editorArea = layout.getEditorArea();

        // -------------------------- right top -----------------------------
        IFolderLayout rightTop = layout.createFolder(RIGHT_TOP_VIEW_SITE_ID,
                IPageLayout.RIGHT, LEFT_TO_RIGHT_RATIO, editorArea);
        addViewIfExists(rightTop, IPageLayout.ID_PROJECT_EXPLORER);
        addViewIfExists(rightTop, IPageLayout.ID_OUTLINE);
        addViewIfExists(rightTop, VIEW_KIEM_TABLE);
        
//        layout.addView("org.eclipse.ui.console.ConsoleView",
//                IPageLayout.BOTTOM, (float) 0.8, editorArea);
//        layout.addStandaloneView("org.eclipse.ui.console.ConsoleView", true,
//                IPageLayout.BOTTOM, (float) 0.8, editorArea);
        
//        try {
//            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
//                    "org.eclipse.ui.console.ConsoleView", "org.eclipse.ui.console.ConsoleView2",
//                    IWorkbenchPage.VIEW_CREATE);
//        } catch (PartInitException e) {
//            e.printStackTrace();
//        }

        // ------------------------- right bottom ---------------------------
        IFolderLayout rightBottom = layout.createFolder(
                RIGHT_BOTTOM_VIEW_SITE_ID, IPageLayout.BOTTOM,
                TOP_TO_BOTTOM_RATIO, RIGHT_TOP_VIEW_SITE_ID);
        addViewIfExists(rightBottom, VIEW_KLOTS);
        addViewIfExists(rightBottom, VIEW_KIEM);
        addViewIfExists(rightBottom, "org.eclipse.ui.console.ConsoleView"); //$NON-NLS-1$
    }

    
    
    /**
     * Add a view to a folder only if the view exists. This method can be used
     * to add views from other plugins to get no exceptions if the plugin is not
     * loaded.
     * 
     * @param folder
     *            a folder layout
     * @param id
     *            a view identifier
     */
    protected void addViewIfExists(final IFolderLayout folder, final String id) {
        // first search the view and only add it, if it is available
        if (PlatformUI.getWorkbench().getViewRegistry().find(id) != null) {
            folder.addView(id);
        }
    }

}
