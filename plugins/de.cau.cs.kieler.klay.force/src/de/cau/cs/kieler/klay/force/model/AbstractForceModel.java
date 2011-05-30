/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.klay.force.model;

import java.util.List;
import java.util.Random;

import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.klay.force.graph.FBendpoint;
import de.cau.cs.kieler.klay.force.graph.FEdge;
import de.cau.cs.kieler.klay.force.graph.FGraph;
import de.cau.cs.kieler.klay.force.graph.FLabel;
import de.cau.cs.kieler.klay.force.graph.FNode;
import de.cau.cs.kieler.klay.force.graph.FParticle;
import de.cau.cs.kieler.klay.force.properties.Properties;

/**
 * Superclass for force models.
 *
 * @author msp
 */
public abstract class AbstractForceModel {

    /** the random number generator used for this model. */
    private Random random;
    /** the graph for which this model was initialized. */
    private FGraph graph;
    
    /**
     * Initialize the force model with the given graph. Subclasses that override this
     * must call the superclass method first.
     * 
     * @param graph a force graph
     */
    protected void initialize(final FGraph graph) {
        this.graph = graph;
        this.random = graph.getProperty(Properties.RANDOM);
        
        // if interactive mode is off, randomize the layout
        if (!graph.getProperty(LayoutOptions.INTERACTIVE)) {
            for (FNode node : graph.getNodes()) {
                KVector pos = node.getPosition();
                pos.x = random.nextDouble();
                pos.y = random.nextDouble();
            }
        }
        
        // create bend points for node repulsion
        List<FBendpoint> bends = graph.getBendpoints();
        for (FEdge edge : graph.getEdges()) {
            int count = edge.getProperty(Properties.EDGE_REP);
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    bends.add(new FBendpoint(edge));
                }
                edge.distributeBendpoints();
            }
        }
    }
    
    /**
     * Return the graph for which the model was initialized.
     * 
     * @return the force graph
     */
    public final FGraph getGraph() {
        return graph;
    }
    
    /**
     * Return the random number generator for this model.
     * 
     * @return the random number generator
     */
    protected final Random getRandom() {
        return random;
    }
    
    /**
     * Perform layout on the given force graph.
     * 
     * @param graph a force graph
     */
    public void layout(final FGraph graph) {
        initialize(graph);
        int iterations = 0;
        
        while (moreIterations(iterations)) {
            
            // calculate attractive and repulsive forces
            for (FNode v : graph.getNodes()) {
                for (FParticle u : graph.getParticles()) {
                    if (u != v) {
                        KVector displacement = calcDisplacement(u, v);
                        if (displacement != null) {
                            v.getDisplacement().add(displacement);
                        }
                    }
                }
            }
            
            // apply calculated displacement
            for (FNode v : graph.getNodes()) {
                v.getPosition().add(v.getDisplacement());
                v.getDisplacement().reset();
            }
            
            iterationDone();
            iterations++;
        }
    }
    
    /**
     * Perform all necessary calculations after a full iteration. Subclasses must call
     * the superclass method first.
     */
    protected void iterationDone() {
        for (FEdge edge : graph.getEdges()) {
            // adjust label positions
            for (FLabel label : edge.getLabels()) {
                label.refreshPosition();
            }
            
            // adjust bend point positions
            edge.distributeBendpoints();
        }
    }
    
    /**
     * Determine whether more iterations need to be performed.
     * 
     * @param count the current iterations count
     * @return {@code true} if more iterations shall be done
     */
    protected abstract boolean moreIterations(int count);
    
    /**
     * Calculate a displacement for the given particles.
     * 
     * @param forcer the particle that is causing the force
     * @param forcee the particle that is affected by the force
     * @return a displacement vector for the forcee, or {@code null} if no force is applied
     */
    protected abstract KVector calcDisplacement(FParticle forcer, FParticle forcee);
    
    /**
     * Avoid having nodes on the same position by moving them a little.
     * 
     * @param u first node
     * @param v second node
     */
    public static void avoidSamePosition(final Random random, final FParticle u, final FParticle v) {
        KVector pu = u.getPosition();
        KVector pv = v.getPosition();
        while (pu.x - pv.x == 0 && pu.y - pv.y == 0) {
            pu.wiggle(random, 1);
            pv.wiggle(random, 1);
        }
    }

}
