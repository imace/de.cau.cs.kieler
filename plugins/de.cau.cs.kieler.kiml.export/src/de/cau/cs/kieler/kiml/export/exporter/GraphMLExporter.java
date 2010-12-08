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
package de.cau.cs.kieler.kiml.export.exporter;

import java.io.IOException;

import org.graphdrawing.graphml.util.GraphMLResourceFactoryImpl;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.model.transformation.TransformationException;
import de.cau.cs.kieler.kiml.export.AbstractExporter;
import de.cau.cs.kieler.kiml.export.ExportUtil;
import de.cau.cs.kieler.kiml.export.ExporterConfiguration;
import de.cau.cs.kieler.kiml.export.util.XtendUtil;

/**
 * A graph exporter for the GraphML file format.
 * 
 * @author mri
 */
public class GraphMLExporter extends AbstractExporter {

    /** the supported file extensions. */
    private static final String[] SUPPORTED_FILE_EXTENSIONS = { "graphml" };
    /** the xtend transformation file. */
    private static final String XTEND_TRANSFORMATION_FILE =
            "/transformations/kgraph2graphml.ext";
    /** the xtend extension which is performing the transformation. */
    private static final String XTEND_TRANSFORMATION = "transform";

    /**
     * Constructs a GML exporter.
     */
    public GraphMLExporter() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "GraphML";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDefaultExtension() {
        return SUPPORTED_FILE_EXTENSIONS[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getExtensions() {
        return SUPPORTED_FILE_EXTENSIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExport(final KNode graph,
            final ExporterConfiguration configuration,
            final IKielerProgressMonitor monitor) throws KielerException {
        monitor.begin("Exporting KGraph to GraphML", 1);

        try {
            XtendUtil.resetGenerators();
            ExportUtil.transformKGraph2Model(
                    monitor.subTask(1),
                    XTEND_TRANSFORMATION_FILE,
                    XTEND_TRANSFORMATION,
                    null,
                    graph,
                    ExportUtil.createOutputStream(
                            configuration.getExportFilePath(),
                            configuration.isWorkspacePath()),
                    new GraphMLResourceFactoryImpl(),
                    "de.cau.cs.kieler.core.kgraph.KGraphPackage",
                    "org.graphdrawing.graphml.GraphMLPackage");
        } catch (IOException e) {
            throw new KielerException(ERROR_MESSAGE_EXPORT_FAILED, e);
        } catch (TransformationException e) {
            throw new KielerException(ERROR_MESSAGE_EXPORT_FAILED, e);
        } finally {
            monitor.done();
        }
    }
}
