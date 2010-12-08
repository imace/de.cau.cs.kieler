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
package de.cau.cs.kieler.kiml.export.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.ui.KielerProgressMonitor;
import de.cau.cs.kieler.kiml.export.ExporterConfiguration;
import de.cau.cs.kieler.kiml.export.ui.ExportDialog;
import de.cau.cs.kieler.kiml.ui.layout.EclipseLayoutServices;

/**
 * The handler that is responsible for exporting graphs from graphical diagrams.
 * 
 * @author mri
 */
public class ExportHandler extends AbstractHandler {

    /**
     * {@inheritDoc}
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        // get the active editor
        IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
        // open the export dialog
        Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
        ExportDialog exportDialog = new ExportDialog(shell);
        int code = exportDialog.open();
        if (code == Dialog.OK) {
            // retrieve a kgraph representation of the diagram
            KNode graph =
                    EclipseLayoutServices.getInstance()
                            .getManager(editorPart, null)
                            .buildLayoutGraph(editorPart, null, false);
            // get the selected configuration
            ExporterConfiguration configuration =
                    exportDialog.getConfiguration();
            // perform the export
            IKielerProgressMonitor monitor =
                    new KielerProgressMonitor(new NullProgressMonitor());
            try {
                configuration.getExporter().doExport(graph, configuration,
                        monitor);
            } catch (KielerException e) {
                // TODO handle this properly
                e.printStackTrace();
            }
        }
        return null;
    }
}
