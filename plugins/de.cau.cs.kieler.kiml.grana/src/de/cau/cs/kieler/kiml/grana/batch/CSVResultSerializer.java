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
package de.cau.cs.kieler.kiml.grana.batch;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.kiml.grana.AbstractInfoAnalysis;
import de.cau.cs.kieler.kiml.grana.visualization.Visualization;
import de.cau.cs.kieler.kiml.grana.visualization.VisualizationServices;

/**
 * A batch result serializer which saves the information as CSV.
 * 
 * @author mri
 */
public class CSVResultSerializer implements IBatchResultSerializer {

    /** the visualization type used in the serialization. */
    private static final String VISUALIZATION_TYPE = "text";

    /**
     * {@inheritDoc}
     */
    public void serialize(final OutputStream outputStream,
            final BatchResult batchResult, final IKielerProgressMonitor monitor)
            throws Exception {
        monitor.begin("Serialize batch result as CSV", 1);
        // create a stream writer
        OutputStreamWriter writer =
                new OutputStreamWriter(outputStream, "UTF-8");
        // write the header
        writer.write("File");
        for (AbstractInfoAnalysis analysis : batchResult.getAnalyses()) {
            writer.write(";" + analysis.getId());
        }
        writer.write("\n");
        // write the job results
        for (BatchJobResult<?> jobResult : batchResult.getJobResults()) {
            writer.write(jobResult.getJob().getParameter().toString());
            Map<String, Object> results = jobResult.getResults();
            for (AbstractInfoAnalysis analysis : batchResult.getAnalyses()) {
                Object result = results.get(analysis.getId());
                Visualization visualization =
                        VisualizationServices.getInstance().getVisualization(
                                VISUALIZATION_TYPE, result);
                String s = visualization.get(result);
                writer.write(";" + s);
            }
            writer.write("\n");
        }
        writer.close();
        monitor.done();
    }

}