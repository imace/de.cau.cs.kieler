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
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.properties.MapPropertyHolder;
import de.cau.cs.kieler.kiml.export.AbstractExporter;
import de.cau.cs.kieler.kiml.graphviz.dot.GraphvizDotStandaloneSetup;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.GraphvizModel;
import de.cau.cs.kieler.kiml.graphviz.dot.transformations.KGraphDotTransformation;

/**
 * A graph exporter for the Dot format.
 * 
 * @author mri
 */
public class DotExporter extends AbstractExporter {

    /** the supported file extensions. */
    private static final String[] SUPPORTED_FILE_EXTENSIONS = { "dot" };

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Dot";
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
    public void doExport(final KNode graph, final OutputStream stream,
            final MapPropertyHolder options,
            final IKielerProgressMonitor monitor) throws KielerException {
        monitor.begin("Exporting KGraph to Dot", 2);
        try {
            // transform the graph
            KGraphDotTransformation transformation =
                    new KGraphDotTransformation(graph);
            GraphvizModel dotGraph =
                    transformation.transform(
                            KGraphDotTransformation.DOT_COMMAND,
                            monitor.subTask(1));
            // write to file
            Injector injector =
                    new GraphvizDotStandaloneSetup()
                            .createInjectorAndDoEMFRegistration();
            XtextResourceSet resourceSet =
                    injector.getInstance(XtextResourceSet.class);
            XtextResource resource =
                    (XtextResource) resourceSet.createResource(URI
                            .createURI("http:///My.graphviz-dot"));
            resource.getContents().add(dotGraph);
            Map<String, Object> resourceOptions = new HashMap<String, Object>();
            resourceOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
            // write to the stream
            resource.save(stream, resourceOptions);
        } catch (IOException e) {
            throw new KielerException(ERROR_MESSAGE_EXPORT_FAILED, e);
        } finally {
            monitor.done();
        }
    }

}