package de.cau.cs.kieler.klots;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.klots.wizards.NewPOJFileWizard;
import de.cau.cs.kieler.klots.wizards.SJProjectNewFileWizard;
import de.cau.cs.kieler.klots.wizards.SJProjectNewSJProjectWizard;

public class KlotsPerspective implements IPerspectiveFactory {
	
	private static final String VIEW_KLOTS = "de.cau.cs.kieler.klots.view.SJInstructionsView"; //$NON-NLS-1$
	private static final String VIEW_KIEM = "de.cau.cs.kieler.sim.kiem.view"; //$NON-NLS-1$
    private static final String VIEW_KIEM_TABLE = "de.cau.cs.kieler.sim.table.view"; //$NON-NLS-1$
    
    private static final String WIZ_KLOTS = SJProjectNewSJProjectWizard.ID;
    private static final String WIZ_KLOTS_SJ_FILE = SJProjectNewFileWizard.ID;
    private static final String WIZ_KLOTS_POJ_FILE = NewPOJFileWizard.ID;
    private static final String WIZ_FILE = "org.eclipse.ui.wizards.new.file"; //$NON-NLS-1$
    private static final String WIZ_PROJECT = "org.eclipse.ui.wizards.new.project"; //$NON-NLS-1$

	public final static String RIGHT_TOP_VIEW_SITE_ID = "de.cau.cs.kieler.klots.KlotsPerspective.RightTopViewSite";
	public final static String RIGHT_BOTTOM_VIEW_SITE_ID = "de.cau.cs.kieler.klots.KlotsPerspective.RightBottomViewSite";
	
	private final static float LEFT_TO_RIGHT_RATIO = (float) 0.61;
	private final static float TOP_TO_BOTTOM_RATIO = (float) 0.38;
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		createNewWizardShortcuts(layout);
        createViewLayout(layout);
        createViewShortcuts(layout);
	}
	
	
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
	

	protected void createNewWizardShortcuts(IPageLayout layout) {
		layout.addNewWizardShortcut(WIZ_PROJECT);
        layout.addNewWizardShortcut(WIZ_FILE);
        layout.addNewWizardShortcut(WIZ_KLOTS);
        layout.addNewWizardShortcut(WIZ_KLOTS_SJ_FILE);
        layout.addNewWizardShortcut(WIZ_KLOTS_POJ_FILE);        
	}
	
	
	protected void createViewLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();

        // -------------------------- right top -----------------------------
        IFolderLayout rightTop = layout.createFolder(RIGHT_TOP_VIEW_SITE_ID,
        		IPageLayout.RIGHT, LEFT_TO_RIGHT_RATIO, editorArea);
        addViewIfExists(rightTop, IPageLayout.ID_PROJECT_EXPLORER);
        addViewIfExists(rightTop, IPageLayout.ID_OUTLINE);
        addViewIfExists(rightTop, VIEW_KIEM_TABLE);
        
        // ------------------------- right bottom ---------------------------
        IFolderLayout rightBottom = layout.createFolder(RIGHT_BOTTOM_VIEW_SITE_ID,
        		IPageLayout.BOTTOM, TOP_TO_BOTTOM_RATIO, RIGHT_TOP_VIEW_SITE_ID);
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
