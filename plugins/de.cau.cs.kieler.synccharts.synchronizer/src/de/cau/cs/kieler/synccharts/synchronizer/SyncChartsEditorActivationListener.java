/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2010 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.synccharts.synchronizer;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.cau.cs.kieler.synccharts.presentation.SyncchartsEditor;
import de.cau.cs.kieler.synccharts.synchronizer.kitsView.KitsView;

/**
 * Custom {@link IPartListener} installing the known modelChangeListener on the
 * current active editor's semantic model.
 * 
 * @author chsch 
 */
public class SyncChartsEditorActivationListener implements IPartListener {

    private IEditorPart activeEditor = null;
    private EContentAdapter syncChartModelChangeListener = null;
    private ISelectionChangedListener selectionChangeListener = null;

    public void installModelChangeListener(EContentAdapter theModelChangeListener) {
        this.syncChartModelChangeListener = theModelChangeListener;
    }

    public void installSelectionChangeListener(ISelectionChangedListener theSelectionChangeListener) {
        this.selectionChangeListener = theSelectionChangeListener;
    }

    public void partActivated(IWorkbenchPart part) {

        if (part.equals(this.activeEditor)) {
            return;
        }

        try {
            if (part instanceof IEditorPart) {
                if (this.activeEditor instanceof SyncchartsEditor) {
                    // System.out.println("Notify DE-activation (tree)");

                    this.addRemoveListenerToTreeEditor((SyncchartsEditor) this.activeEditor, false);
                    this.activeEditor = null;
                }

                if (this.activeEditor instanceof XtextEditor) {
                    // System.out.println("Notify DE-activation (xtext)");

                    if (((XtextEditor) this.activeEditor).getDocument() != null) {
                        
                        this.addRemoveListenerToXtextEditor((XtextEditor) this.activeEditor, false);
                    }
                    this.activeEditor = null;
                }

                if (this.activeEditor instanceof DiagramDocumentEditor) {
                    // System.out.println("Notify DE-activation (diagram)");
                    
					if (this.selectionChangeListener != null) {
						((DiagramDocumentEditor) this.activeEditor)
								.getDiagramGraphicalViewer()
								.removeSelectionChangedListener(
										this.selectionChangeListener);
					}

					this.activeEditor = null;

                    ModelChangeTriggerListener.setEnabled(false);
                }
            }

        } catch (NullPointerException e) {
            this.activeEditor = null;
        }

        if (part instanceof SyncchartsEditor) {
            // System.out.println("Notify activation (tree)");
            this.activeEditor = (IEditorPart) part;

            this.addRemoveListenerToTreeEditor((SyncchartsEditor) this.activeEditor, true);

        } else {
            if (part instanceof XtextEditor) {
                // System.out.println("Notify activation (xtext)");
                this.activeEditor = (IEditorPart) part;

                this.addRemoveListenerToXtextEditor((XtextEditor) this.activeEditor, true);

            } else {
                if (part instanceof DiagramDocumentEditor) {
                    // System.out.println("Notify activation (diagram)");
                    this.activeEditor = (IEditorPart) part;
                    
					if (KitsView.getInstance() != null) {
						this.selectionChangeListener = KitsView.getInstance();
						((DiagramDocumentEditor) part)
						.getDiagramGraphicalViewer()
						.addSelectionChangedListener(
								this.selectionChangeListener);
					}
                    
                    ModelChangeTriggerListener.setEnabled(true);
                }
            }
        }
    }

    
    private void addRemoveListenerToTreeEditor(SyncchartsEditor editor, final boolean add) {
        EList<Adapter> adapters = editor.getEditingDomain().getResourceSet().eAdapters();
        if (add) {
            if (!adapters.contains(this.syncChartModelChangeListener)) {
                adapters.add(this.syncChartModelChangeListener);
            }
        } else {
            adapters.remove(this.syncChartModelChangeListener);
        }
    }    
    

    private void addRemoveListenerToXtextEditor(XtextEditor editor, final boolean add) {

        final EContentAdapter modelChangeListener = this.syncChartModelChangeListener;

        editor.getDocument().modify(new IUnitOfWork.Void<XtextResource>() {

            @Override
            public void process(XtextResource state) throws Exception {
                EList<Adapter> adapters = state.getResourceSet().eAdapters();

                if (add) {
                    if (!adapters.contains(modelChangeListener))
                        adapters.add(modelChangeListener);
                } else {
                    adapters.remove(modelChangeListener);
                }
            }
        });
    }

    public void partOpened(IWorkbenchPart part) {
    }

    public void partDeactivated(IWorkbenchPart part) {
    }

    public void partClosed(IWorkbenchPart part) {
    }

    public void partBroughtToTop(IWorkbenchPart part) {
    }
}
