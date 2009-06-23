package de.cau.cs.kieler.kiml.ui.handlers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.kiml.layout.services.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.ui.KimlUiPlugin;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayouter;
import de.cau.cs.kieler.kiml.ui.layout.GmfLayoutHints;
import de.cau.cs.kieler.kiml.ui.views.LayoutView;

/**
 * View action delegate for all actions of the LayoutView.
 * @author haf
 *
 */
public class DeepLayoutActionDelegate implements IViewActionDelegate {

    public final String DEEP_APPLY_ALL = "de.cau.cs.kieler.kiml.ui.layoutview.deepapply";
    public final String EXPAND = "de.cau.cs.kieler.kiml.ui.layoutview.expand";
    
    LayoutView view;

    boolean expanded = false;
    
    public void init(IViewPart view) {
        this.view = (LayoutView) view;
    }

    /**
     * Calls the appropriate method for the corresponding action.
     * Supported actions are EXPAND and DEEP_APPLY_ALL.
     */
    public void run(IAction action) {
        String actionID = action.getId();
        
        if(actionID.equals(DEEP_APPLY_ALL)){
            deepApplyAll();
        }

        else if(actionID.equals(EXPAND)){
            expanded = !expanded;
            expandLayouters(expanded);
        }

    }

    /**
     * Expands the tree of all layouters in the view or
     * collapses it depending on the given state.
     * @param state true iff expanding, false if collapsing
     */
    private void expandLayouters(boolean state) {
        view.setExpanded(state);
    }

    /**
     * Applies the selected layouter to all nodes in the
     * diagram and then executes a layout run for the
     * whole diagram. Will overwrite all local settings
     * for all nodes.
     */
    private void deepApplyAll() {
        try {
            // FIXME instead of overwriting the layouter for all nodes, define general inheritance rules for layout options
            /*IEditorPart editor = PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage()
                    .getActiveEditor();
            if (editor instanceof DiagramEditor) {
                DiagramEditor gmfEditor = (DiagramEditor) editor;
                DiagramEditPart dep = gmfEditor.getDiagramEditPart();

                // set layouter type for all edit parts
                AbstractLayoutProvider layouter = view.getSelectedLayouter();
                if (layouter != null)
                    GmfLayoutHints.setAllContainedElementsLayoutHints(
                            dep, layouter.getType(), layouter.getName());

                // perform layout
                DiagramLayouter.layout(editor, true, true, 1);
            } else {
                throw new KielerException(
                        "No GMF diagram editor is open. Make sure the diagram editor is open and made with GMF.",
                        KielerException.Type.LAYOUT_NOT_APPLICABLE);
            }*/

        } catch (Exception e) {
            Status myStatus = new Status(IStatus.ERROR, KimlUiPlugin.PLUGIN_ID,
                    "Could not perform automatic layout of diagram.", e);
            StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
        }
    }

    public void selectionChanged(IAction action, ISelection selection) {
        // TODO Auto-generated method stub

    }

}
