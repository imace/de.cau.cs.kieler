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
package de.cau.cs.kieler.klighd.graphiti.piccolo;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.mm.algorithms.util.AlgorithmsSwitch;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.ManhattanConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.mm.pictograms.util.PictogramsSwitch;

import de.cau.cs.kieler.klighd.IModelTransformation;
import de.cau.cs.kieler.klighd.piccolo.PSWTAdvancedPath;
import de.cau.cs.kieler.klighd.piccolo.PSWTAlignedText;
import edu.umd.cs.piccolo.PNode;
import edu.umd.cs.piccolox.swt.PSWTText;

/**
 * A transformation from a Graphiti Pictogram model to a list of Piccolo nodes.
 * 
 * @author mri
 */
public class Pictogram2PNodeTransformation implements IModelTransformation<Diagram, List<PNode>> {

    /** the Pictogram color for white. */
    private static final Color WHITE = StylesFactory.eINSTANCE.createColor();
    /** the Pictogram color for black. */
    private static final Color BLACK = StylesFactory.eINSTANCE.createColor();

    /** a mapping between Pictogram anchors and Piccolo anchor nodes. */
    private Map<Anchor, AnchorNode> anchorMap = new HashMap<Anchor, AnchorNode>();
    /** a mapping between Pictogram graphics algorithms and Piccolo nodes. */
    private Map<GraphicsAlgorithm, PNode> gaMap = new HashMap<GraphicsAlgorithm, PNode>();

    // CHECKSTYLEOFF MagicNumber
    static {
        WHITE.setRed(255);
        WHITE.setGreen(255);
        WHITE.setBlue(255);
        BLACK.setRed(0);
        BLACK.setGreen(0);
        BLACK.setBlue(0);
    }

    // CHECKSTYLEON MagicNumber

    /**
     * Constructs a Pictogram2PNodeTransformation.
     */
    public Pictogram2PNodeTransformation() {

    }

    /**
     * Performs the actual transformation from the Pictogram model to the Piccolo node.
     * 
     * @param diagram
     *            the Pictogram diagram
     * @return the list of Piccolo nodes which represents the layers of the actual diagram
     */
    public List<PNode> transform(final Diagram diagram) {
        anchorMap.clear();
        gaMap.clear();
        List<PNode> layerRoots = new LinkedList<PNode>();
        // use two layers, one for nodes and one for edges
        PNode edges = new PNode();
        PNode nodes = new PNode();
        layerRoots.add(nodes);
        layerRoots.add(edges);
        // determine default colors from the diagram graphics algorithm
        GraphicsAlgorithm ga = diagram.getGraphicsAlgorithm();
        Color fc, bc;
        if (diagram.getGraphicsAlgorithm() != null) {
            fc = getForegroundColor(ga, BLACK);
            bc = getBackgroundColor(ga, WHITE);
        } else {
            fc = BLACK;
            bc = WHITE;
        }
        // transform shapes
        for (Shape shape : diagram.getChildren()) {
            transformShape(nodes, shape, fc, bc);
        }
        // transform connections
        for (Connection connection : diagram.getConnections()) {
            transformConnection(edges, connection, BLACK, WHITE);
        }
        return layerRoots;
    }

    /**
     * Transforms a Pictogram shape to a Piccolo node.
     * 
     * @param parent
     *            the parent Piccolo node
     * @param shape
     *            the Pictogram shape
     * @param fc
     *            the default foreground color for this shape
     * @param bc
     *            the default background color for this shape
     */
    private void transformShape(final PNode parent, final Shape shape, final Color fc,
            final Color bc) {
        ShapeNode shapeNode = new ShapeNode(shape);
        parent.addChild(shapeNode);
        shapeNode.setPickable(shape.isActive());
        // determine colors and transform the graphics algorithm
        GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
        Color gaFc, gaBc;
        if (ga != null) {
            gaFc = getForegroundColor(ga, fc);
            gaBc = getBackgroundColor(ga, bc);
            PNode gaNode = transformGraphicsAlgorithm(shapeNode, ga, gaFc, gaBc);
            if (gaNode != null) {
                gaNode.translate(-ga.getX(), -ga.getY());
                shapeNode.translate(ga.getX(), ga.getY());
                shapeNode.setWidth(ga.getWidth());
                shapeNode.setHeight(ga.getHeight());
            }
        } else {
            gaFc = fc;
            gaBc = bc;
        }
        // handle child shapes in case of a container shape
        if (shape instanceof ContainerShape) {
            ContainerShape containerShape = (ContainerShape) shape;
            for (Shape childShape : containerShape.getChildren()) {
                transformShape(shapeNode, childShape, gaFc, gaBc);
            }
        }
        // handle anchors
        for (Anchor anchor : shape.getAnchors()) {
            transformAnchor(shapeNode, anchor, gaFc, gaBc);
        }
        shapeNode.setVisible(shape.isVisible());
    }

    /**
     * Transforms a Pictogram anchor to a Piccolo node.
     * 
     * @param parent
     *            the parent Piccolo node
     * @param anchor
     *            the Pictogram anchor
     * @param fc
     *            the default foreground color for this shape
     * @param bc
     *            the default background color for this shape
     */
    private void transformAnchor(final ShapeNode parent, final Anchor anchor, final Color fc,
            final Color bc) {
        // find the node representing the graphics algorithm referenced by the anchor
        GraphicsAlgorithm referenceGa = anchor.getReferencedGraphicsAlgorithm();
        PNode reference;
        if (referenceGa != null) {
            reference = gaMap.get(referenceGa);
            if (reference == null) {
                reference = parent;
            }
        } else {
            referenceGa = parent.getPictogramShape().getGraphicsAlgorithm();
            if (referenceGa != null) {
                reference = gaMap.get(referenceGa);
                if (reference == null) {
                    reference = parent;
                }
            } else {
                reference = parent;
            }
        }
        // create the anchor
        AnchorNode anchorNode = new AnchorNode(anchor, reference);
        parent.addAnchor(anchorNode);
        anchorNode.setPickable(false);
        // transform the graphics algorithm
        GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
        if (ga != null) {
            Color gaFc = getForegroundColor(ga, fc);
            Color gaBc = getBackgroundColor(ga, bc);
            transformGraphicsAlgorithm(anchorNode, ga, gaFc, gaBc);
        }
        anchorMap.put(anchor, anchorNode);
        anchorNode.setVisible(anchor.isVisible());
        // try to find the initial anchor position
        anchorNode.updateAnchorPosition(null);
    }

    /**
     * Transforms a Pictogram connection to a Piccolo node.
     * 
     * @param parent
     *            the parent Piccolo node
     * @param connection
     *            the Pictogram connection
     * @param fc
     *            the default foreground color for this shape
     * @param bc
     *            the default background color for this shape
     */
    private void transformConnection(final PNode parent, final Connection connection,
            final Color fc, final Color bc) {
        ConnectionNode node = new PictogramsSwitch<ConnectionNode>() {
            public ConnectionNode caseFreeFormConnection(final FreeFormConnection object) {
                return transformFreeFormConnection(object, fc, bc);
            }

            public ConnectionNode caseManhattanConnection(final ManhattanConnection object) {
                return transformManhattanConnection(object, fc, bc);
            }
        } .doSwitch(connection);
        // ignore the connection if no PNode representation could be found
        if (node != null) {
            node.setPickable(false);
            parent.addChild(node);
            // transform decorators
            for (ConnectionDecorator decorator : connection.getConnectionDecorators()) {
                GraphicsAlgorithm ga = decorator.getGraphicsAlgorithm();
                // create the decoration
                DecorationNode decoration =
                        new DecorationNode(decorator, !(ga instanceof AbstractText));
                node.addDecoration(decoration);
                // transform graphics algorithm for this decorator
                Color gaFc = getForegroundColor(ga, fc);
                Color gaBc = getBackgroundColor(ga, bc);
                transformGraphicsAlgorithm(decoration, ga, gaFc, gaBc);
            }
            node.updateDecorations();
        }
    }

    private ConnectionNode transformFreeFormConnection(final FreeFormConnection ffc,
            final Color fc, final Color bc) {
        AnchorNode source = anchorMap.get(ffc.getStart());
        AnchorNode target = anchorMap.get(ffc.getEnd());
        if (source != null && target != null && ffc.getGraphicsAlgorithm() != null
                && ffc.getGraphicsAlgorithm() instanceof Polyline) {
            ConnectionNode connection = new ConnectionNode(ffc, source, target);
            PSWTAdvancedPath path =
                    transformPolyline((Polyline) ffc.getGraphicsAlgorithm(), fc, bc);
            path.setPickable(false);
            connection.setPolyline(path);
            return connection;
        }
        return null;
    }

    private ConnectionNode transformManhattanConnection(final ManhattanConnection mhc,
            final Color fc, final Color bc) {
        // TODO implement this
        return null;
    }

    /**
     * Transforms a Pictogram graphics algorithm to a Piccolo node.
     * 
     * @param parent
     *            the parent Piccolo node
     * @param ga
     *            the graphics algorithm
     * @param fc
     *            the default foreground color for this graphics algorithm
     * @param bc
     *            the default background color for this graphics algorithm
     * @return the Piccolo node representing the graphics algorithm
     */
    private PNode transformGraphicsAlgorithm(final PNode parent, final GraphicsAlgorithm ga,
            final Color fc, final Color bc) {
        PNode node = new AlgorithmsSwitch<PNode>() {
            public PNode caseRectangle(final Rectangle object) {
                return transformRectangle(object, fc, bc);
            }

            public PNode caseRoundedRectangle(final RoundedRectangle object) {
                return transformRoundedRectangle(object, fc, bc);
            }

            public PNode caseEllipse(final Ellipse object) {
                return transformEllipse(object, fc, bc);
            }

            public PNode casePolygon(final Polygon object) {
                return transformPolygon(object, fc, bc);
            }

            public PNode casePolyline(final Polyline object) {
                return transformPolyline(object, fc, bc);
            }

            public PNode caseText(final Text object) {
                return transformText(object, fc, bc);
            }

            public PNode caseMultiText(final MultiText object) {
                return transformText(object, fc, bc);
            }

            public PNode caseImage(final Image object) {
                return transformImage(object);
            }
        } .doSwitch(ga);
        // ignore the graphics algorithm if no Piccolo node representation could be found
        if (node != null) {
            node.setPickable(false);
            node.translate(ga.getX(), ga.getY());
            parent.addChild(node);
            gaMap.put(ga, node);
            // transform child graphics algorithms
            for (GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
                Color childFc = getForegroundColor(childGa, fc);
                Color childBc = getBackgroundColor(childGa, bc);
                transformGraphicsAlgorithm(node, childGa, childFc, childBc);
            }
        }
        return node;
    }

    private PSWTAdvancedPath transformRectangle(final Rectangle r, final Color fc, final Color bc) {
        PSWTAdvancedPath rect = PSWTAdvancedPath.createRectangle(0, 0, r.getWidth(), r.getHeight());
        rect.setLineWidth(r.getLineWidth());
        if (r.getLineVisible()) {
            rect.setStrokeColor(transformColor(fc));
        } else {
            rect.setStrokeColor(null);
        }
        if (r.getFilled()) {
            rect.setPaint(transformColor(bc));
        } else {
            rect.setPaint(null);
        }
        return rect;
    }

    private PSWTAdvancedPath transformRoundedRectangle(final RoundedRectangle rr, final Color fc,
            final Color bc) {
        PSWTAdvancedPath rrect =
                PSWTAdvancedPath.createRoundRectangle(0, 0, rr.getWidth(), rr.getHeight(),
                        rr.getCornerWidth(), rr.getCornerHeight());
        rrect.setLineWidth(rr.getLineWidth());
        if (rr.getLineVisible()) {
            rrect.setStrokeColor(transformColor(fc));
        } else {
            rrect.setStrokeColor(null);
        }
        if (rr.getFilled()) {
            rrect.setPaint(transformColor(bc));
        } else {
            rrect.setPaint(null);
        }
        return rrect;
    }

    private PSWTAdvancedPath transformEllipse(final Ellipse e, final Color fc, final Color bc) {
        PSWTAdvancedPath ellipse =
                PSWTAdvancedPath.createEllipse(0, 0, e.getWidth(), e.getHeight());
        ellipse.setLineWidth(e.getLineWidth());
        if (e.getLineVisible()) {
            ellipse.setStrokeColor(transformColor(fc));
        } else {
            ellipse.setStrokeColor(null);
        }
        if (e.getFilled()) {
            ellipse.setPaint(transformColor(bc));
        } else {
            ellipse.setPaint(null);
        }
        return ellipse;
    }

    private PSWTAdvancedPath transformPolygon(final Polygon p, final Color fc, final Color bc) {
        if (p.getPoints().size() > 0) {
            Point2D[] points = new Point2D[p.getPoints().size()];
            int i = 0;
            for (Point point : p.getPoints()) {
                points[i++] = new java.awt.Point(point.getX(), point.getY());
            }
            PSWTAdvancedPath polygon = PSWTAdvancedPath.createPolygon(points);
            polygon.setLineWidth(p.getLineWidth());
            if (p.getLineVisible()) {
                polygon.setStrokeColor(transformColor(fc));
            } else {
                polygon.setStrokeColor(null);
            }
            if (p.getFilled()) {
                polygon.setPaint(transformColor(bc));
            } else {
                polygon.setPaint(null);
            }
            return polygon;
        }
        return null;
    }

    private PSWTAdvancedPath transformPolyline(final Polyline p, final Color fc, final Color bc) {
        PSWTAdvancedPath line;
        if (p.getPoints().size() > 0) {
            Point2D[] points = new Point2D[p.getPoints().size()];
            int i = 0;
            for (Point point : p.getPoints()) {
                points[i++] = new java.awt.Point(point.getX(), point.getY());
            }
            line = PSWTAdvancedPath.createPolyline(points);
        } else {
            line = new PSWTAdvancedPath();
        }
        line.setLineWidth(p.getLineWidth());
        if (p.getLineVisible()) {
            line.setStrokeColor(transformColor(fc));
        } else {
            line.setStrokeColor(null);
        }
        if (p.getFilled()) {
            line.setPaint(transformColor(bc));
        } else {
            line.setPaint(null);
        }
        return line;
    }

    private PSWTText transformText(final AbstractText t, final Color fc, final Color bc) {
        PSWTAlignedText text = new PSWTAlignedText();
        text.setFont(transformFont(t.getFont()));
        text.setText(t.getValue() != null ? t.getValue() : "");
        text.setTransparent(true);
        text.setWidth(t.getWidth());
        text.setHeight(t.getHeight());
        switch (t.getHorizontalAlignment()) {
        case ALIGNMENT_LEFT:
            text.setAlignment(PSWTAlignedText.Alignment.LEFT);
            break;
        case ALIGNMENT_MIDDLE:
        case ALIGNMENT_CENTER:
            text.setAlignment(PSWTAlignedText.Alignment.CENTER);
            break;
        case ALIGNMENT_RIGHT:
            text.setAlignment(PSWTAlignedText.Alignment.RIGHT);
            break;
        }
        if (t.getLineVisible()) {
            text.setPenColor(transformColor(fc));
        } else {
            text.setPenColor(null);
        }
        if (t.getFilled()) {
            text.setBackgroundColor(transformColor(bc));
        } else {
            text.setBackgroundColor(null);
        }
        return text;
    }

    private PNode transformImage(final Image i) {
        // TODO implement this if possible (may not)
        return new PNode();
    }

    private java.awt.Color transformColor(final Color color) {
        return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    private java.awt.Font transformFont(final Font font) {
        int style = 0;
        if (font.isBold()) {
            style |= java.awt.Font.BOLD;
        }
        if (font.isItalic()) {
            style |= java.awt.Font.ITALIC;
        }
        // TODO the font is not completely accurate yet
        return new java.awt.Font(font.getName(), style, font.getSize() - 1);
    }

    private Color getForegroundColor(final GraphicsAlgorithm ga, final Color def) {
        if (ga.getForeground() != null) {
            return ga.getForeground();
        }
        if (ga.getStyle() != null) {
            return getForegroundColor(ga.getStyle(), def);
        }
        return def;
    }

    private Color getForegroundColor(final Style style, final Color def) {
        if (style.getForeground() != null) {
            return style.getForeground();
        }
        if (style.getStyleContainer() != null && style.getStyleContainer() instanceof Style) {
            Style parentStyle = (Style) style.getStyleContainer();
            return getForegroundColor(parentStyle, def);
        }
        return def;
    }

    private Color getBackgroundColor(final GraphicsAlgorithm ga, final Color def) {
        if (ga.getBackground() != null) {
            return ga.getBackground();
        }
        if (ga.getStyle() != null) {
            return getBackgroundColor(ga.getStyle(), def);
        }
        return def;
    }

    private Color getBackgroundColor(final Style style, final Color def) {
        if (style.getBackground() != null) {
            return style.getBackground();
        }
        if (style.getStyleContainer() != null && style.getStyleContainer() instanceof Style) {
            Style parentStyle = (Style) style.getStyleContainer();
            return getBackgroundColor(parentStyle, def);
        }
        return def;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isModelSupported(final Object model) {
        return model instanceof Diagram;
    }

}
