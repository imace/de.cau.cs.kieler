/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.layout.util.alg;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import de.cau.cs.kieler.core.alg.AbstractAlgorithm;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;

/**
 * Placing algorithm for boxes. Edges of the graph are not considered.
 * 
 * @kieler.rating 2009-12-11 proposed yellow msp
 * @author msp
 */
public class BoxPlacer extends AbstractAlgorithm {

    /** maximal factor by which a row may be broader than the maximal row width. */
    public static final float DEF_ASPECT_RATIO = 1.3f;

    // width and height of the parent node
    private float parentWidth, parentHeight;

    /**
     * Place the boxes of the given sorted list according to their order in the
     * list.
     * 
     * @param sortedBoxes sorted list of boxes
     * @param parentNode parent node
     * @param objSpacing minimal spacing between elements
     * @param borderSpacing spacing to the border
     * @param expandNodes if true, the nodes are expanded to fill their parent
     */
    public void placeBoxes(final List<KNode> sortedBoxes, final KNode parentNode,
            final float objSpacing, final float borderSpacing, final boolean expandNodes) {
        getMonitor().begin("Box placement", 1);
        KShapeLayout parentLayout = KimlLayoutUtil.getShapeLayout(parentNode);
        KInsets insets = LayoutOptions.getObject(parentLayout, KInsets.class);
        float minWidth = Math.max(LayoutOptions.getFloat(parentLayout, LayoutOptions.MIN_WIDTH)
                - insets.getLeft() - insets.getRight(), 0);
        float minHeight = Math.max(LayoutOptions.getFloat(parentLayout, LayoutOptions.MIN_HEIGHT)
                - insets.getTop() - insets.getBottom(), 0);
        float aspectRatio = LayoutOptions.getFloat(parentLayout, LayoutOptions.ASPECT_RATIO);
        if (Float.isNaN(aspectRatio) || aspectRatio <= 0) {
            aspectRatio = DEF_ASPECT_RATIO;
        }

        // do place the boxes
        placeBoxes(sortedBoxes, objSpacing, borderSpacing, minWidth, minHeight,
                expandNodes, aspectRatio);

        // adjust parent size
        parentLayout.setWidth(insets.getLeft() + parentWidth + insets.getRight());
        parentLayout.setHeight(insets.getTop() + parentHeight + insets.getBottom());

        getMonitor().done();
    }

    /**
     * Place the boxes of the given sorted list according to their order in the
     * list.
     * 
     * @param sortedBoxes sorted list of boxes
     * @param minSpacing minimal spacing between elements
     * @param borderSpacing spacing to the border
     * @param minTotalWidth minimal width of the parent node
     * @param minTotalHeight minimal height of the parent node
     * @param expandNodes if true, the nodes are expanded to fill their parent
     * @param aspectRatio the desired aspect ratio
     */
    private void placeBoxes(final List<KNode> sortedBoxes, final float minSpacing,
            final float borderSpacing, final float minTotalWidth, final float minTotalHeight,
            final boolean expandNodes, final float aspectRatio) {
        // determine the maximal row width by the maximal box width and the
        // total area
        float maxRowWidth = 0.0f;
        float totalArea = 0.0f;
        for (KNode box : sortedBoxes) {
            KShapeLayout boxLayout = KimlLayoutUtil.getShapeLayout(box);
            if (!LayoutOptions.getBoolean(boxLayout, LayoutOptions.FIXED_SIZE)) {
                KimlLayoutUtil.resizeNode(box);
            }
            maxRowWidth = Math.max(maxRowWidth, boxLayout.getWidth());
            totalArea += boxLayout.getWidth() * boxLayout.getHeight();
        }
        maxRowWidth = Math.max(maxRowWidth, (float) Math.sqrt(totalArea) * aspectRatio)
                + borderSpacing;

        // place nodes iteratively into rows
        float xpos = borderSpacing, ypos = borderSpacing, highestBox = 0.0f,
                broadestRow = 2 * borderSpacing;
        LinkedList<Integer> rowIndices = new LinkedList<Integer>();
        rowIndices.add(Integer.valueOf(0));
        LinkedList<Float> rowHeights = new LinkedList<Float>();
        ListIterator<KNode> boxIter = sortedBoxes.listIterator();
        while (boxIter.hasNext()) {
            KShapeLayout boxLayout = KimlLayoutUtil.getShapeLayout(boxIter.next());
            float width = boxLayout.getWidth();
            float height = boxLayout.getHeight();
            if (xpos + width > maxRowWidth) {
                // place box into the next row
                if (expandNodes) {
                    rowHeights.addLast(Float.valueOf(highestBox));
                    rowIndices.addLast(Integer.valueOf(boxIter.previousIndex()));
                }
                xpos = borderSpacing;
                ypos += highestBox + minSpacing;
                highestBox = 0.0f;
                broadestRow = Math.max(broadestRow, 2 * borderSpacing + width);
            }
            boxLayout.setXpos(xpos);
            boxLayout.setYpos(ypos);
            broadestRow = Math.max(broadestRow, xpos + width + borderSpacing);
            highestBox = Math.max(highestBox, height);
            xpos += width + minSpacing;
        }
        broadestRow = Math.max(broadestRow, minTotalWidth);
        float totalHeight = ypos + highestBox + borderSpacing;
        if (totalHeight < minTotalHeight) {
            highestBox += minTotalHeight - totalHeight;
            totalHeight = minTotalHeight;
        }

        // expand nodes if required
        if (expandNodes) {
            xpos = borderSpacing;
            boxIter = sortedBoxes.listIterator();
            rowIndices.addLast(Integer.valueOf(sortedBoxes.size()));
            ListIterator<Integer> rowIndexIter = rowIndices.listIterator();
            int nextRowIndex = rowIndexIter.next();
            rowHeights.addLast(Float.valueOf(highestBox));
            ListIterator<Float> rowHeightIter = rowHeights.listIterator();
            float rowHeight = 0.0f;
            while (boxIter.hasNext()) {
                if (boxIter.nextIndex() == nextRowIndex) {
                    xpos = borderSpacing;
                    rowHeight = rowHeightIter.next();
                    nextRowIndex = rowIndexIter.next();
                }
                KNode box = boxIter.next();
                KShapeLayout boxLayout = KimlLayoutUtil.getShapeLayout(box);
                boxLayout.setHeight(rowHeight);
                if (boxIter.nextIndex() == nextRowIndex) {
                    float newWidth = broadestRow - xpos - borderSpacing;
                    float oldWidth = boxLayout.getWidth();
                    boxLayout.setWidth(newWidth);
                    KimlLayoutUtil.translate(box, (newWidth - oldWidth) / 2, 0.0f);
                }
                xpos += boxLayout.getWidth() + minSpacing;
            }
        }

        // set parent size
        parentWidth = broadestRow;
        parentHeight = totalHeight;
    }

}
