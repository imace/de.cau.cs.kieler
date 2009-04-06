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
import de.cau.cs.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayouter;
import de.cau.cs.kieler.kiml.ui.views.KimlLayoutView;

public class DeepLayoutActionDelegate implements IViewActionDelegate {

    KimlLayoutView view;

    public void init(IViewPart view) {
        this.view = (KimlLayoutView) view;
    }

    public void run(IAction action) {
        try {
            IEditorPart editor = PlatformUI.getWorkbench()
                    .getActiveWorkbenchWindow().getActivePage()
                    .getActiveEditor();
            if (editor instanceof DiagramEditor) {
                DiagramEditor gmfEditor = (DiagramEditor) editor;
                DiagramEditPart dep = gmfEditor.getDiagramEditPart();

                // set layouter type for all edit parts
                AbstractLayoutProvider layouter = view.getSelectedLayouter();
                if (layouter != null)
                    KimlGMFLayoutHintHelper.setAllContainedElementsLayoutHints(
                            dep, layouter.getType(), layouter.getName());

                // perform layout
                DiagramLayouter.layout(editor, true, true, 1);
            } else {
                throw new KielerException(
                        "No GMF diagram editor is open. Make sure the diagram editor is open and made with GMF.",
                        KielerException.Type.LAYOUT_NOT_APPLICABLE);
            }

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
