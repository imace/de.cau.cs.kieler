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
package de.cau.cs.kieler.kiml.util;

import java.util.Random;

import de.cau.cs.kieler.core.alg.IKielerProgressMonitor;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KLabel;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.AbstractLayoutProvider;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KLayoutDataFactory;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;

/**
 * Layout provider that computes random layouts.
 *
 * @kieler.rating 2011-01-13 proposed yellow msp
 * @author msp
 */
public class RandomLayoutProvider extends AbstractLayoutProvider {
    
    /** the layout provider id. */
    public static final String ID = "de.cau.cs.kieler.random";

    /** default value for aspect ratio. */
    private static final float DEF_ASPECT_RATIO = 1.6f;
    /** default value for object spacing. */
    private static final float DEF_SPACING = 20.0f;
    
    /**
     * Initialize default options of the layout provider.
     */
    public RandomLayoutProvider() {
        setProperty(LayoutOptions.RANDOM_SEED, 0);
        setProperty(LayoutOptions.ASPECT_RATIO, DEF_ASPECT_RATIO);
        setProperty(LayoutOptions.SPACING, DEF_SPACING);
        setProperty(LayoutOptions.BORDER_SPACING, DEF_SPACING);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void doLayout(final KNode parentNode, final IKielerProgressMonitor progressMonitor) {
        progressMonitor.begin("Random Layout", 1);
        if (parentNode.getChildren().size() == 0) {
            progressMonitor.done();
            return;
        }
        KShapeLayout parentLayout = parentNode.getData(KShapeLayout.class);
        
        // initialize random seed
        Random random;
        Integer randomSeed = parentLayout.getProperty(LayoutOptions.RANDOM_SEED);
        if (randomSeed != null && randomSeed != 0) {
            random = new Random(randomSeed);
        } else {
            random = new Random();
        }
        
        // get aspect ratio
        float aspectRatio = parentLayout.getProperty(LayoutOptions.ASPECT_RATIO);
        if (aspectRatio <= 0) {
            aspectRatio = DEF_ASPECT_RATIO;
        }
        
        // get spacing values
        float spacing = parentLayout.getProperty(LayoutOptions.SPACING);
        if (spacing <= 0) {
            spacing = DEF_SPACING;
        }
        float offset = parentLayout.getProperty(LayoutOptions.BORDER_SPACING);
        if (offset <= 0) {
            offset = DEF_SPACING;
        }
        
        // randomize the layout
        randomize(parentNode, random, aspectRatio, spacing, offset);

        progressMonitor.done();
    }
    
    /**
     * Randomize the given graph.
     * 
     * @param parent the parent node of the graph
     * @param random the random number generator
     * @param aspectRatio desired aspect ratio
     * @param spacing desired object spacing
     * @param offset offset to the border
     */
    private void randomize(final KNode parent, final Random random, final float aspectRatio,
            final float spacing, final float offset) {
        // determine width and height of the drawing
        float nodesArea = 0.0f, maxWidth = 0.0f, maxHeight = 0.0f;
        for (KNode node : parent.getChildren()) {
            KShapeLayout nodeLayout = node.getData(KShapeLayout.class);
            float width = nodeLayout.getWidth();
            maxWidth = Math.max(maxWidth, width);
            float height = nodeLayout.getHeight();
            maxHeight = Math.max(maxHeight, height);
            nodesArea += width * height;
        }
        int n = parent.getChildren().size();
        float drawArea = nodesArea + 2 * spacing * (float) Math.sqrt(nodesArea * n);
        float areaSqrt = (float) Math.sqrt(drawArea);
        float drawWidth = Math.max(areaSqrt * aspectRatio, maxWidth);
        float drawHeight = Math.max(areaSqrt / aspectRatio, maxHeight);
        
        // randomize node positions
        for (KNode node : parent.getChildren()) {
            KShapeLayout nodeLayout = node.getData(KShapeLayout.class);
            float x = offset + random.nextFloat() * (drawWidth - nodeLayout.getWidth());
            nodeLayout.setXpos(x);
            float y = offset + random.nextFloat() * (drawHeight - nodeLayout.getHeight());
            nodeLayout.setYpos(y);
        }
        
        // randomize edge positions
        float totalWidth = drawWidth + 2 * offset;
        float totalHeight = drawHeight + 2 * offset;
        for (KNode source : parent.getChildren()) {
            for (KEdge edge : source.getOutgoingEdges()) {
                KNode target = edge.getTarget();
                if (source.getParent() == target.getParent()) {
                    randomize(edge, source, target, random, totalWidth, totalHeight);
                }
            }
        }
        
        KShapeLayout parentLayout = parent.getData(KShapeLayout.class);
        KInsets insets = parentLayout.getProperty(LayoutOptions.INSETS);
        parentLayout.setWidth(totalWidth + insets.getLeft() + insets.getRight());
        parentLayout.setHeight(totalHeight + insets.getTop() + insets.getBottom());
    }
    
    private static final int MAX_BENDS = 5;
    private static final float RAND_FACT = 0.2f;
    
    /**
     * Randomize the given edge.
     * 
     * @param edge an edge
     * @param source the source node
     * @param target the target node
     * @param random the random number generator
     * @param drawWidth the total width of the drawing
     * @param drawHeight the total Height of the drawing
     */
    private void randomize(final KEdge edge, final KNode source, final KNode target,
            final Random random, final float drawWidth, final float drawHeight) {
        KEdgeLayout edgeLayout = edge.getData(KEdgeLayout.class);
        
        KShapeLayout sourceLayout = source.getData(KShapeLayout.class);
        float sourceX = sourceLayout.getXpos(), sourceY = sourceLayout.getYpos(),
                sourceWidth = sourceLayout.getWidth() / 2,
                sourceHeight = sourceLayout.getHeight() / 2;
        if (edge.getSourcePort() != null) {
            KShapeLayout portLayout = edge.getSourcePort().getData(KShapeLayout.class);
            sourceWidth = portLayout.getWidth() / 2;
            sourceHeight = portLayout.getHeight() / 2;
            sourceX += portLayout.getXpos();
            sourceY += portLayout.getYpos();
        }
        sourceX += sourceWidth;
        sourceY += sourceHeight;
        
        KShapeLayout targetLayout = target.getData(KShapeLayout.class);
        float targetX = targetLayout.getXpos(), targetY = targetLayout.getYpos(),
                targetWidth = targetLayout.getWidth() / 2,
                targetHeight = targetLayout.getHeight() / 2;
        if (edge.getTargetPort() != null) {
            KShapeLayout portLayout = edge.getTargetPort().getData(KShapeLayout.class);
            targetWidth = portLayout.getWidth() / 2;
            targetHeight = portLayout.getHeight() / 2;
            targetX += portLayout.getXpos();
            targetY += portLayout.getYpos();
        }
        targetX += targetWidth;
        targetY += targetHeight;
        
        float sourcePX = targetX;
        if (targetX > sourceX + sourceWidth) {
            sourcePX = sourceX + sourceWidth;
        } else if (targetX < sourceX - sourceWidth) {
            sourcePX = sourceX - sourceWidth;
        }
        float sourcePY = targetY;
        if (targetY > sourceY + sourceHeight) {
            sourcePY = sourceY + sourceHeight;
        } else if (targetY < sourceY - sourceHeight) {
            sourcePY = sourceY - sourceHeight;
        }
        if (sourcePX > sourceX - sourceWidth && sourcePX < sourceX + sourceWidth
                && sourcePY > sourceY - sourceHeight && sourcePY < sourceY + sourceHeight) {
            sourcePX = sourceX + sourceWidth;
        }
        KPoint sourcePoint = edgeLayout.getSourcePoint();
        sourcePoint.setX(sourcePX);
        sourcePoint.setY(sourcePY);
        
        float targetPX = sourceX;
        if (sourceX > targetY + targetWidth) {
            targetPX = targetY + targetWidth;
        } else if (sourceX < targetY - targetWidth) {
            targetPX = targetY - targetWidth;
        }
        float targetPY = sourceY;
        if (sourceY > targetY + targetHeight) {
            targetPY = targetY + targetHeight;
        } else if (sourceY < targetY - targetHeight) {
            targetPY = targetY - targetHeight;
        }
        if (targetPX > targetX - targetWidth && targetPX < targetX + targetWidth
                && targetPY > targetY - targetHeight && targetPY < targetY + targetHeight) {
            targetPY = targetY + targetHeight;
        }
        KPoint targetPoint = edgeLayout.getTargetPoint();
        targetPoint.setX(targetPX);
        targetPoint.setY(targetPY);
        
        edgeLayout.getBendPoints().clear();
        int bendsNum = random.nextInt(MAX_BENDS);
        if (source == target) {
            bendsNum++;
        }
        float xdiff = targetPX - sourcePX;
        float ydiff = targetPY - sourcePY;
        float totalDist = (float) Math.sqrt(xdiff * xdiff + ydiff * ydiff);
        float maxRand = totalDist * RAND_FACT;
        float xincr = xdiff / (bendsNum + 1);
        float yincr = ydiff / (bendsNum + 1);
        float x = sourcePX, y = sourcePY;
        for (int i = 0; i < bendsNum; i++) {
            x += xincr;
            y += yincr;
            float randx = x + random.nextFloat() * maxRand - maxRand / 2;
            if (randx < 0) {
                randx = 1;
            } else if (randx > drawWidth) {
                randx = drawWidth - 1;
            }
            float randy = y + random.nextFloat() * maxRand - maxRand / 2;
            if (randy < 0) {
                randy = 1;
            } else if (randy > drawHeight) {
                randy = drawHeight - 1;
            }
            KPoint bendPoint = KLayoutDataFactory.eINSTANCE.createKPoint();
            bendPoint.setX(randx);
            bendPoint.setY(randy);
            edgeLayout.getBendPoints().add(bendPoint);
        }
        
        // invalidate edge labels
        for (KLabel label : edge.getLabels()) {
            label.getData(KShapeLayout.class).setProperty(LayoutOptions.NO_LAYOUT, true);
        }
    }

}
