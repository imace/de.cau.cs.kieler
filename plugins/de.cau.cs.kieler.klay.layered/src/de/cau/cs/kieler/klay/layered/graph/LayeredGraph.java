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
package de.cau.cs.kieler.klay.layered.graph;

import java.io.IOException;
import java.io.Writer;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.cau.cs.kieler.core.math.KVector;
import de.cau.cs.kieler.klay.layered.properties.EdgeType;
import de.cau.cs.kieler.klay.layered.properties.NodeType;
import de.cau.cs.kieler.klay.layered.properties.Properties;

/**
 * A layered graph has a set of layers that contain the nodes, as well as a
 * list of nodes that are not yet assigned to a layer. Layout algorithms are
 * required to layout the graph from left to right. If another layout direction
 * is desired, it can be obtained by pre-processing and post-processing the graph.
 * 
 * @author msp
 */
public class LayeredGraph extends LGraphElement implements Iterable<Layer> {
    
    /**
     * Map mapping node types to the colors used to represent those types when
     * writing debug output graphs. The colors are given as strings of the form
     * "#RGB", where each component is given as a two-digit hexadecimal value.
     */
    public static final Map<NodeType, String> NODE_TYPE_COLORS = new EnumMap<NodeType, String>(
            NodeType.class);
    
    // Initialize the node-type-to-color-map
    static {
        NODE_TYPE_COLORS.put(NodeType.COMPOUND_SIDE, "#808080");
        NODE_TYPE_COLORS.put(NodeType.EXTERNAL_PORT, "#cc99cc");
        NODE_TYPE_COLORS.put(NodeType.LONG_EDGE, "#eaed00");
        NODE_TYPE_COLORS.put(NodeType.NORTH_SOUTH_PORT, "#0034de");
        NODE_TYPE_COLORS.put(NodeType.LOWER_COMPOUND_BORDER, "#18e748");
        NODE_TYPE_COLORS.put(NodeType.LOWER_COMPOUND_PORT, "#2f6d3e");
        NODE_TYPE_COLORS.put(NodeType.UPPER_COMPOUND_BORDER, "#fb0838");
        NODE_TYPE_COLORS.put(NodeType.UPPER_COMPOUND_PORT, "#b01d38");
    }
    

    /** the total size of the drawing, without offset. */
    private KVector size = new KVector();
    /** the graph's insets. */
    private LInsets.Double insets = new LInsets.Double(0, 0, 0, 0);
    /** the offset to be added to all positions. */
    private KVector offset = new KVector();
    /** nodes that are not currently part of a layer. */
    private List<LNode> layerlessNodes = new LinkedList<LNode>();
    /** the layers of the layered graph. */
    private List<Layer> layers = new LinkedList<Layer>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (layers.isEmpty()) {
            return "G-unlayered" + layerlessNodes.toString();
        } else if (layerlessNodes.isEmpty()) {
            return "G-layered" + layers.toString();
        }
        return "G[layerless" + layerlessNodes.toString() + ", layers" + layers.toString() + "]";
    }

    /**
     * Returns the size of the graph, that is the bounding box that covers the
     * whole drawing. The size does not include insets or anything.
     * 
     * @return the size of the layered graph
     */
    public KVector getSize() {
        return size;
    }
    
    /**
     * Returns the graph's size including any borders. If the graph represents a
     * hierarchical node, the returned size represents the node's size. The returned
     * size can be modified at will without having any influence on the graph's size
     * or the actual size returned on the next method call.
     * 
     * @return the graph's size including borders.
     */
    public KVector getActualSize() {
        float borderSpacing = getProperty(Properties.BORDER_SPACING);
        return new KVector(
                size.x + insets.left + insets.right + (2 * borderSpacing),
                size.y + insets.top + insets.bottom + (2 * borderSpacing));
    }
    
    /**
     * Returns the insets of the graph. The insets determine the amount of space between
     * the content area and the graph's actual border.
     * 
     * @return the insets.
     */
    public LInsets.Double getInsets() {
        return insets;
    }

    /**
     * Returns the offset for the graph, that is a coordinate vector that has
     * to be added to all position values of nodes and edges. It is usually used
     * to reserve some space in the content area for additional edge routing.
     * 
     * <b>Note:</b> Since many different parts of the algorithm may contribute to
     * the offset, never set the offset to an absolute value! Rather, only add to
     * the offset!
     * 
     * @return the offset of the layered graph
     */
    public KVector getOffset() {
        return offset;
    }
    
    /**
     * Returns the list of nodes that are not currently assigned to a layer.
     * 
     * @return the layerless nodes.
     */
    public List<LNode> getLayerlessNodes() {
        return layerlessNodes;
    }

    /**
     * Returns the list of layers of the graph.
     * 
     * @return the layers
     */
    public List<Layer> getLayers() {
        return layers;
    }

    /**
     * Returns an iterator over the layers.
     * 
     * @return an iterator for the layers of this layered graph
     */
    public Iterator<Layer> iterator() {
        return layers.iterator();
    }
    
    /**
     * Outputs a representation of this graph in dot format to the given writer. The
     * following conventions are used:
     * <ul>
     *   <li>Standard nodes are drawn as rectangles.</li>
     *   <li>Dummy nodes are drawn as ellipses.</li>
     *   <li>Nodes have a color that depends on their node type.
     *     (yellow for {@code LONG_EDGE}, turquoise for {@code ODD_PORT_SIDE},
     *     dark blue for {@code NORTH_SOUTH_PORT})</li>
     * </ul>
     * 
     * @param writer the writer to output the graph to. An attempt is made to close the
     *               writer when finished.
     * @throws IOException if anything goes wrong with the writer.
     */
    public void writeDotGraph(final Writer writer) throws IOException {
        // Begin the digraph
        writer.write("digraph {\n");
        
        // Digraph options
        writer.write("    rankdir=LR;\n");
        
        // Write layerless nodes and edges
        writeLayer(writer, -1, layerlessNodes);
        
        // Go through the layers
        int layerNumber = -1;
        for (Layer layer : layers) {
            layerNumber++;
            
            // Write the nodes and edges
            writeLayer(writer, layerNumber, layer.getNodes());
        }
        
        // Close the digraph. And the writer.
        writer.write("}\n");
        writer.close();
    }
    
    /**
     * Writes the given list of nodes and their edges.
     * 
     * @param writer writer to write to.
     * @param layerNumber the layer number. {@code -1} for layerless nodes.
     * @param nodes the nodes in the layer.
     * @throws IOException if anything goes wrong with the writer.
     */
    private void writeLayer(final Writer writer, final int layerNumber, final List<LNode> nodes)
            throws IOException {
        
        if (nodes.isEmpty()) {
            return;
        }
        
        // Start a subgraph for the layer
        writer.write("    {\n");
        
        if (layerNumber != -1) {
            writer.write("        rank=same;\n");
        }
        
        // Go through the layer's nodes
        int nodeNumber = -1;
        for (LNode node : nodes) {
            nodeNumber++;
            
            // Output the node name
            writer.write("        " + node.hashCode());
            
            // Options time!
            StringBuffer options = new StringBuffer();
            
            // Label
            options.append("label=\"");
            if (node.getName() != null) {
                options.append(node.getName().replace("\"", "\\\"") + " ");
            }
            options.append("(" + layerNumber + "," + nodeNumber + ")\",");
            
            // Node type
            if (node.getProperty(Properties.NODE_TYPE).equals(NodeType.NORMAL)) {
                options.append("shape=box,");
            } else {
                options.append("shape=circle,style=filled,");
                
                String color = NODE_TYPE_COLORS.get(node.getProperty(Properties.NODE_TYPE));
                if (color != null) {
                    options.append("color=\"" + color + "\",");
                }
            }
            
            // Print options, if any
            options.deleteCharAt(options.length() - 1);
            if (options.length() > 0) {
                writer.write("[" + options + "]");
            }
            
            // End the node line
            writer.write(";\n");
        }
        
        if (layerNumber != -1) {
            // End the layer's subgraph
            writer.write("    }\n");
        }
        
        // Write the edges
        for (LNode node : nodes) {
            // Go through all edges and output those that have this node as their source
            for (LPort port : node.getPorts()) {
                for (LEdge edge : port.getOutgoingEdges()) {
                    writer.write("    " + node.hashCode() + " -> "
                            + edge.getTarget().getNode().hashCode());
                    
                    // Check if this is a compound dummy edge (connecting ancestors and descendants)
                    if (edge.getProperty(Properties.EDGE_TYPE) == EdgeType.COMPOUND_DUMMY) {
                        writer.write(" [style=\"dashed\"]");
                    }
                    
                    // Check if this is a compound side dummy edge (connecting side dummy nodes)
                    if (edge.getProperty(Properties.EDGE_TYPE) == EdgeType.COMPOUND_SIDE) {
                        writer.write(" [style=\"dotted\"]");
                    }
                    
                    writer.write(";\n");
                }
            }
        }
        
        if (layerNumber == -1) {
            // End the layer's subgraph
            writer.write("    }\n");
        }
    }
    
}
