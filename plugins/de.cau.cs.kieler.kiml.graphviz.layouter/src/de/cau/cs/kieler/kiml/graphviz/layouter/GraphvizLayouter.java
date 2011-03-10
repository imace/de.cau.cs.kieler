/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.graphviz.layouter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.cau.cs.kieler.kiml.graphviz.dot.GraphvizDotStandaloneSetup;
import de.cau.cs.kieler.kiml.graphviz.dot.dot.GraphvizModel;
import de.cau.cs.kieler.kiml.graphviz.dot.transformations.KGraphDotTransformation;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.util.ForkedOutputStream;
import de.cau.cs.kieler.core.util.ForwardingInputStream;
import de.cau.cs.kieler.core.util.NonBlockingInputStream;

/**
 * Layouter that calls Graphviz through a child process to perform layout. The graph structure and
 * layout information is passed through a textual format called Dot, see the <a
 * href="http://www.graphviz.org/doc/info/lang.html">Dot language specification</a>. Serialization
 * and parsing of this textual format is done using <a
 * href="http://www.eclipse.org/modeling/tmf/">Xtext</a>.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author ars
 * @author haf
 * @author msp
 * @author mri
 */
public class GraphvizLayouter {

    /** the resource set used for parsing and serialization. */
    private XtextResourceSet resourceSet;
    /** base file name for debug output. */
    private String debugFileName;

    /** amount of work for small tasks. */
    private static final int SMALL_TASK = 5;
    /** amount of work for large tasks. */
    private static final int LARGE_TASK = 10;

    /**
     * Performs the actual work of the layout process. Translates the KNode into a structure
     * GraphViz understands, calls the desired GraphViz layouter and annotates the KLayoutGraph with
     * the position and size information provided by GraphViz.
     * 
     * @param parentNode
     *            the node to process
     * @param progressMonitor
     *            a monitor to which progress is reported
     * @param command
     *            Graphviz command to use, determines the layout algorithm
     */
    public void layout(final KNode parentNode, final IKielerProgressMonitor progressMonitor,
            final String command) {
        progressMonitor.begin("Graphviz layout (" + command + ")", SMALL_TASK + LARGE_TASK + LARGE_TASK
                + LARGE_TASK + SMALL_TASK);
        boolean debugMode = parentNode.getData(KShapeLayout.class).getProperty(LayoutOptions.DEBUG_MODE);
        if (debugMode) {
            debugFileName = Integer.toString(parentNode.hashCode());
        }
        // return if there is nothing in this node
        if (parentNode.getChildren().isEmpty()) {
            progressMonitor.done();
            return;
        }

        // create an Xtext resource set for parsing and serialization
        if (resourceSet == null) {
            Injector injector = new GraphvizDotStandaloneSetup().createInjectorAndDoEMFRegistration();
            resourceSet = injector.getInstance(XtextResourceSet.class);
            resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        }

        // start the graphviz process, or retrieve the previously used process
        Process graphvizProcess = GraphvizAPI.startProcess(command);

        // translate the KGraph to Graphviz and write to the process
        KGraphDotTransformation transformation = new KGraphDotTransformation(parentNode);
        GraphvizModel graphvizInput = transformation.transform(command,
                progressMonitor.subTask(SMALL_TASK));
        writeDotGraph(graphvizInput, new BufferedOutputStream(graphvizProcess.getOutputStream()),
                progressMonitor.subTask(LARGE_TASK), debugMode);

        // wait for Graphviz to give some output
        GraphvizAPI.waitForInput(graphvizProcess.getInputStream(), graphvizProcess.getErrorStream(),
                progressMonitor.subTask(LARGE_TASK), debugMode);

        if (!progressMonitor.isCanceled()) {
            // read Graphviz output and apply layout information to the KGraph
            GraphvizModel graphvizOutput = readDotGraph(
                    new BufferedInputStream(graphvizProcess.getInputStream()),
                    progressMonitor.subTask(LARGE_TASK), debugMode);
            transformation.applyLayout(graphvizOutput, progressMonitor.subTask(SMALL_TASK));
        }

        progressMonitor.done();
    }

    /**
     * Writes a serialized version of the Graphviz model to the given output stream.
     * 
     * @param graphvizModel
     *            Graphviz model to serialize
     * @param processStream
     *            output stream to which the model is written
     * @param monitor
     *            a monitor to which progress is reported
     * @param debugMode
     *            whether debug mode is active
     */
    private void writeDotGraph(final GraphvizModel graphvizModel, final OutputStream processStream,
            final IKielerProgressMonitor monitor, final boolean debugMode) {
        monitor.begin("Serialize model", 1);
        OutputStream outputStream = processStream;
        // enable debug output if needed
        FileOutputStream debugStream = null;
        if (debugMode) {
            try {
                String path = System.getProperty("user.home");
                if (path.endsWith(File.separator)) {
                    path += "tmp" + File.separator + "graphviz";
                } else {
                    path += File.separator + "tmp" + File.separator + "graphviz";
                }
                new File(path).mkdirs();
                debugStream = new FileOutputStream(new File(path + File.separator + debugFileName
                        + "-in.dot"));
                outputStream = new ForkedOutputStream(processStream, debugStream);
            } catch (Exception exception) {
                System.out.println("GraphvizLayouter: Could not initialize debug output: "
                        + exception.getMessage());
            }
        }

        try {
            XtextResource resource = (XtextResource) resourceSet.createResource(URI
                    .createURI("process.graphviz-dot"));
            resource.getContents().add(graphvizModel);
            resource.save(outputStream, null);
            outputStream.write('\n');
            outputStream.flush();
        } catch (IOException exception) {
            GraphvizAPI.endProcess();
            throw new RuntimeException("Failed to serialize the Dot graph.", exception);
        } finally {
            if (debugStream != null) {
                try {
                    debugStream.close();
                } catch (IOException exception) {
                    // ignore exception
                }
            }
        }
        monitor.done();
    }

    /**
     * Reads and parses a serialized Graphviz model.
     * 
     * @param inputStream
     *            input stream from which the model is read
     * @param monitor
     *            a monitor to which progress is reported
     * @param debugMode
     *            whether debug mode is active
     * @return an instance of the parsed graphviz model
     */
    private GraphvizModel readDotGraph(final InputStream processStream,
            final IKielerProgressMonitor monitor, final boolean debugMode) {
        monitor.begin("Parse output", 1);
        InputStream inputStream = new NonBlockingInputStream(processStream);
        // enable debug output if needed
        FileOutputStream debugStream = null;
        if (debugMode) {
            try {
                String path = System.getProperty("user.home");
                if (path.endsWith(File.separator)) {
                    path += "tmp" + File.separator + "graphviz";
                } else {
                    path += File.separator + "tmp" + File.separator + "graphviz";
                }
                new File(path).mkdirs();
                debugStream = new FileOutputStream(new File(path + File.separator + debugFileName
                        + "-out.dot"));
                inputStream = new ForwardingInputStream(inputStream, debugStream);
            } catch (Exception exception) {
                System.out.println("GraphvizLayouter: Could not initialize debug output: "
                        + exception.getMessage());
            }
        }

        // parse the output stream of the dot process
        XtextResource resource = (XtextResource) resourceSet.createResource(URI
                .createURI("process.graphviz-dot"));
        try {
            resource.load(inputStream, null);
            EcoreUtil.resolveAll(resource);
        } catch (IOException exception) {
            GraphvizAPI.endProcess();
            throw new RuntimeException("Failed to read Graphviz output.", exception);
        } finally {
            if (debugStream != null) {
                try {
                    debugStream.close();
                } catch (IOException exception) {
                    // ignore exception
                }
            }
        }

        // analyze errors and retrieve parse result
        if (!resource.getErrors().isEmpty()) {
            StringBuilder errorString = new StringBuilder("Errors in Graphviz output:");
            for (Diagnostic diagnostic : resource.getErrors()) {
                errorString.append("\n" + diagnostic.getLine() + ": " + diagnostic.getMessage());
            }
            GraphvizAPI.endProcess();
            throw new RuntimeException(errorString.toString());
        }
        GraphvizModel graphvizModel = (GraphvizModel) resource.getParseResult().getRootASTElement();
        if (graphvizModel.getGraphs().isEmpty()) {
            GraphvizAPI.endProcess();
            throw new RuntimeException("No output from the Graphviz process.");
        }

        monitor.done();
        return graphvizModel;
    }
}
