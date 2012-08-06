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
package de.cau.cs.kieler.synccharts.synchronizer.kitsView;
// SUPPRESS CHECKSTYLE PREVIOUS PackageName

import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

import de.cau.cs.kieler.synccharts.text.ui.KitsUIPlugin;

/**
 * View providing textual view on parts of SyncCharts models.
 * The view serves as a SelectionListener to retrieve the graphical editors' models.
 * 
 * @author chsch
 * @kieler.ignore (excluded from review process)
 */
public class KitsView extends ViewPart {
    
    private static final long DELAY = 2000L; 

    private EmbeddedXtextEditor kitsEditor;

    private EmbeddedXtextEditor kitsStateEditor;

    private EmbeddedXtextEditor actionsEditor;

    private SyncChartSynchronizerJob synchronizer;
    
    private StackLayout layout;

    @Override
    public void createPartControl(final Composite parent) {
        layout = new StackLayout();        
        parent.setLayout(layout);

        Injector actionsInjector = KitsUIPlugin.getInstance().getInjector(
                KitsUIPlugin.ACTIONS_LANGUAGE);
        
        Injector kitsInjector = KitsUIPlugin.getInstance().getInjector(
                KitsUIPlugin.KITS_LANGUAGE_EMBEDDED);

        Injector kitsStateInjector = KitsUIPlugin.getInstance().getInjector(
                KitsUIPlugin.KITS_STATE_LANGUAGE);

        actionsEditor = new EmbeddedXtextEditor(parent, actionsInjector);
        
        actionsEditor.getDocument().addModelListener(new IXtextModelListener() {
            public void modelChanged(final XtextResource resource) {
                synchronizer.cancel();
                if (!documentHasErrors(actionsEditor.getDocument())) {
                    synchronizer.schedule(DELAY);
                }
            }
        });

        kitsStateEditor = new EmbeddedXtextEditor(parent, kitsStateInjector);
        
        kitsStateEditor.getDocument().addModelListener(new IXtextModelListener() {
            public void modelChanged(final XtextResource resource) {
                synchronizer.cancel();
                if (!documentHasErrors(kitsStateEditor.getDocument())) {
                    synchronizer.schedule(DELAY);
                }
            }
        });


        kitsEditor = new EmbeddedXtextEditor(parent, kitsInjector);
        
        kitsEditor.getDocument().addModelListener(new IXtextModelListener() {
            public void modelChanged(final XtextResource resource) {
                synchronizer.cancel();
                if (!documentHasErrors(kitsEditor.getDocument())) {
                    synchronizer.schedule(DELAY);
                }
            }
        });

        layout.topControl = kitsEditor.getViewer().getControl();
        
        synchronizer = new SyncChartSynchronizerJob("SyncChartsSynchronizer", actionsEditor,
                kitsEditor, kitsStateEditor);

        ((ISelectionService) getSite().getService(ISelectionService.class))
                .addSelectionListener(synchronizer);

    }

    /**
     * Copied from @{link org.eclipselabs.xtfo.demo.rcp.editor.detailspage.Domain
     * DomainModelDetailsPage}. (and simplified)
     * 
     * @param xtextDocument
     * @return true if the document could not be parsed and linked correctly, false otherwise
     */
    private boolean documentHasErrors(final IXtextDocument xtextDocument) {
        return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
            public Boolean exec(final XtextResource state) throws Exception {
                IParseResult parseResult = state.getParseResult();
                return !state.getErrors().isEmpty() || parseResult == null
                        || parseResult.getSyntaxErrors().iterator().hasNext();
            }
        }));
    }

    /**
     * {@inheritDoc}
     */
    public void dispose() {
        ((ISelectionService) getSite().getService(ISelectionService.class))
                .removeSelectionListener(synchronizer);
        kitsEditor.dispose();
        kitsStateEditor.dispose();
        actionsEditor.dispose();
        super.dispose();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFocus() {
        layout.topControl.setFocus();
    }
    

}
