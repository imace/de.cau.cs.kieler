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
package de.cau.cs.kieler.kvid;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

import de.cau.cs.kieler.core.annotations.NamedObject;
import de.cau.cs.kieler.core.kgraph.KEdge;
import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.core.kgraph.KPort;
import de.cau.cs.kieler.core.model.util.ModelingUtil;
import de.cau.cs.kieler.kaom.Port;
import de.cau.cs.kieler.kiml.klayoutdata.KEdgeLayout;
import de.cau.cs.kieler.kiml.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.klayoutdata.KPoint;
import de.cau.cs.kieler.kiml.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.options.LayoutOptions;
import de.cau.cs.kieler.kiml.ui.layout.DiagramLayoutManager;
import de.cau.cs.kieler.kiml.ui.layout.EclipseLayoutServices;
import de.cau.cs.kieler.kvid.data.KvidUri;
import de.cau.cs.kieler.kvid.datadistributor.RuntimeConfiguration;

/**
 * Utility class for the KViD-Plugin. Holds commonly used methods statically.
 * 
 * @author jjc
 *
 */
public final class KvidUtil {
    
    /**
     * There shouldn't be an instance of this class.
     */
    private KvidUtil() { }

    /**
     * Converts a given AWT {@link Image} in it's SWT representation.
     * 
     * @param image The image in AWT format
     * @return The SWT {@link ImageData} for the given image
     */
    public static ImageData convertAWTImageToSWT(final Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        if (w == -1 || h == -1) {
            return null;
        }
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return convertToSWT(bi);
    }
    
    /**
     * Helper method for converting AWT images into SWT ones.
     * 
     * @param bufferedImage The {@link BufferedImage} resulting from the first step of conversion
     * @return The SWT {@link ImageData} for the given image
     */
    private static ImageData convertToSWT(final BufferedImage bufferedImage) {
        if (bufferedImage.getColorModel() instanceof DirectColorModel) {
            DirectColorModel colorModel
                    = (DirectColorModel) bufferedImage.getColorModel();
            PaletteData palette = new PaletteData(colorModel.getRedMask(),
                    colorModel.getGreenMask(), colorModel.getBlueMask());
            ImageData data = new ImageData(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), colorModel.getPixelSize(),
                    palette);
            WritableRaster raster = bufferedImage.getRaster();
            final int rasterSize = 3;
            int[] pixelArray = new int[rasterSize];
            for (int y = 0; y < data.height; y++) {
                for (int x = 0; x < data.width; x++) {
                    raster.getPixel(x, y, pixelArray);
                    int pixel = palette.getPixel(new RGB(pixelArray[0],
                            pixelArray[1], pixelArray[2]));
                    data.setPixel(x, y, pixel);
                }
            }
            return data;
        } else if (bufferedImage.getColorModel() instanceof IndexColorModel) {
            IndexColorModel colorModel = (IndexColorModel)
                    bufferedImage.getColorModel();
            int size = colorModel.getMapSize();
            byte[] reds = new byte[size];
            byte[] greens = new byte[size];
            byte[] blues = new byte[size];
            colorModel.getReds(reds);
            colorModel.getGreens(greens);
            colorModel.getBlues(blues);
            RGB[] rgbs = new RGB[size];
            final int mask = 0xFF;
            for (int i = 0; i < rgbs.length; i++) {
                rgbs[i] = new RGB(reds[i] & mask, greens[i] & mask,
                        blues[i] & mask);
            }
            PaletteData palette = new PaletteData(rgbs);
            ImageData data = new ImageData(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), colorModel.getPixelSize(),
                    palette);
            data.transparentPixel = colorModel.getTransparentPixel();
            WritableRaster raster = bufferedImage.getRaster();
            int[] pixelArray = new int[1];
            for (int y = 0; y < data.height; y++) {
                for (int x = 0; x < data.width; x++) {
                    raster.getPixel(x, y, pixelArray);
                    data.setPixel(x, y, pixelArray[0]);
                }
            }
            return data;
        }
        return null;
    }
    
    /**
     * Converts a EMF/GMF Fragment URI into a Ptolemy URI.
     * A Fragment URI looks like: //(type).(number of child of this type)/ etc.
     * A Ptolemy URI looks like: .(element name).(second element name)
     * 
     * This requires unique names on the same hierarchy level.
     * 
     * @param fragmentUri The Fragment URI to convert
     * @param resource The resource which holds the model element referred by
     *          the Fragment URI
     * @return A Ptolemy URI referring the model element
     */
    public static String fragmentUri2PtolemyUri(final String fragmentUri, final Resource resource) {
        //Ptolemy URIs do not tend to be larger than fragment URIs
        StringBuilder result = new StringBuilder(fragmentUri.length());
        if (fragmentUri.startsWith("//")) {
            EObject model = resource.getEObject(fragmentUri);
            while (model.eContainer() != null) {
                if (model instanceof NamedObject) {
                    result.insert(0, ((NamedObject) model).getName());
                    if (model instanceof Port) {
                        result.insert(0, ":");
                    } else  {
                        result.insert(0, ".");
                    }
                } else {
                    throw new IllegalArgumentException("Ptolemy URIs will only work with NamedObjects");
                }
                model = model.eContainer();
            }
        } else {
            throw new IllegalArgumentException("Malformatted Fragment URI");
        }
        return result.toString();
    }
    
    /**
     * Converts a Ptolemy URI into a EMF/GMF Fragment URI.
     * A Fragment URI looks like: //(type).(number of child of this type)/ etc.
     * A Ptolemy URI looks like: .(element name).(second element name)
     * 
     * This requires unique names on the same hierarchy level.
     * 
     * @param ptolemyUri A Ptolemy URI referring the model element
     * @param resource The resource which holds the model element referred by
     *          the Fragment URI
     * @return The Fragment URI
     */
    public static String ptolemyUri2FragmentUri(final String ptolemyUri, final Resource resource) {
        //Fragmemt URIs are about twice as long as PtolemyURIs
        StringBuilder result = new StringBuilder(ptolemyUri.length() * 2);
        if (ptolemyUri.startsWith(".")) {
            EObject root = resource.getContents().get(0);
            result.append("/");
            StringTokenizer tokenizer = new StringTokenizer(ptolemyUri, ".");
            while (tokenizer.hasMoreTokens()) {
                //parse Ptolemy URI and find corresponding EObject on the current level 
                result.append("/");
                String currentUri = tokenizer.nextToken();
                
                String currentResult = new String(result.toString());
                for (EObject eo : root.eContents()) {
                    //iterate through the current level and find the NamedObject with the same name
                    if (eo instanceof NamedObject) {
                        if (((NamedObject) eo).getName() != null
                                && ((NamedObject) eo).getName().equals(
                                        currentUri)) {
                            result.append(((InternalEObject) eo.eContainer())
                                    .eURIFragmentSegment(
                                            eo.eContainingFeature(), eo));
                            root = eo;
                            break;
                        }
                    }
                }
                if (currentResult.equals(result)) {
                    //Element wasn't found, although this was the right level
                    //Return null then
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("Malformatted Name-based URI");
        }
        return result.toString();
    }
    
    /**
     * Will return the absolute position on the canvas of an KNode from a KGraph.
     * 
     * @param node The node to find the absolute position for
     * @return The absolute position on the canvas of the KNode
     * 
     */
    public static Point getAbsolutePosition(final KNode node) {
        KShapeLayout nodeLayout = node.getData(KShapeLayout.class);
        float xPos = nodeLayout.getXpos();
        float yPos = nodeLayout.getYpos();
        KNode iterNode = node;
        while (iterNode.getParent() != null) {
            iterNode = iterNode.getParent();
            KShapeLayout iterLayout = iterNode.getData(KShapeLayout.class);
            xPos += iterLayout.getXpos();
            yPos += iterLayout.getYpos();
            KInsets iterInsets = iterLayout.getProperty(LayoutOptions.INSETS);
            xPos += iterInsets.getLeft();
            yPos += iterInsets.getTop();
        }
        return new Point(xPos, yPos);
    }
    
    /**
     * Will return the absolute position on the canvas of an KPort from a KGraph.
     * 
     * @param port The port to find the absolute position for
     * @return The absolute position on the canvas of the KPort
     * 
     */
    public static Point getAbsolutePosition(final KPort port) {
        Point position = getAbsolutePosition(port.getNode());
        KShapeLayout portLayout = port.getData(KShapeLayout.class);
        position.translate((int) portLayout.getXpos(), (int) portLayout.getYpos());
        return position;
    }
    
    /**
     * Gives the absolute positions of all bend points on the given edge.
     * 
     * @param edge The edge to get the bend points from
     * @return A list of points, being the absolute positions of the bend points
     * 
     */
    public static List<Point> getBendPointsAbsolutePositions(final KEdge edge) {
        List<Point> result = new LinkedList<Point>();
        KShapeLayout parentLayout = edge.getSource().getParent().getData(KShapeLayout.class);
        Point parentPosition = getAbsolutePosition(edge.getSource().getParent());
        KInsets insets = parentLayout.getProperty(LayoutOptions.INSETS);
        parentPosition.translate((int) insets.getLeft(), (int) insets.getTop());
        Point pathStep = new Point(parentPosition);
        KEdgeLayout edgeLayout = edge.getData(KEdgeLayout.class);
        pathStep.translate((int) edgeLayout.getSourcePoint().getX(),
                (int) edgeLayout.getSourcePoint().getY());
        result.add(pathStep);
        for (KPoint bendPoint : edge.getData(KEdgeLayout.class).getBendPoints()) {
            pathStep = new Point(parentPosition);
            pathStep.translate((int) bendPoint.getX(), (int) bendPoint.getY());
            result.add(pathStep);
        }
        pathStep = new Point(parentPosition);
        pathStep.translate((int) edgeLayout.getTargetPoint().getX(),
                (int) edgeLayout.getTargetPoint().getY());
        result.add(pathStep);
        return result;
    }
    
    /**
     * Compute animation paths and location for a port.
     * 
     * @param port The port to perform pathfinding for
     * @return A list of paths for animation purposes
     */
    private static List<List<Point>> getPathsByPort(final KPort port) {
        List<List<Point>> result = new LinkedList<List<Point>>();
        List<List<Point>> subresult = new LinkedList<List<Point>>();
        for (KEdge edge : port.getEdges()) {
            if (edge.getSourcePort() != null && edge.getSourcePort().equals(port)) {
                List<Point> path = new LinkedList<Point>();
                path.addAll(getBendPointsAbsolutePositions(edge));
                if (edge.getTargetPort() == null) {
                    KShapeLayout targetLayout = edge.getTarget().getData(KShapeLayout.class);
                    if (targetLayout.getProperty(LayoutOptions.HYPERNODE)) {
                        subresult.addAll(getPathsByNode(edge.getTarget()));
                    }
                }
                if (subresult.size() > 0) {
                    for (List<Point> subpath : subresult) {
                        List<Point> completePath = new LinkedList<Point>();
                        completePath.addAll(path);
                        completePath.addAll(subpath);
                        result.add(completePath);
                    }
                } else {
                    result.add(path);
                }
                subresult.clear();
            }
        }
        return result;
    }
    
    /**
     * Compute animation paths and location for a node.
     * 
     * @param port The node to perform pathfinding for
     * @return A list of paths for animation purposes
     */
    private static List<List<Point>> getPathsByNode(final KNode node) {
        List<List<Point>> result = new LinkedList<List<Point>>();
        List<List<Point>> subresult = new LinkedList<List<Point>>();
        for (KEdge edge : node.getOutgoingEdges()) {
            List<Point> path = new LinkedList<Point>();
            path.addAll(getBendPointsAbsolutePositions(edge));
            if (edge.getTargetPort() == null) {
                KShapeLayout targetLayout = edge.getTarget().getData(
                        KShapeLayout.class);
                if (targetLayout.getProperty(LayoutOptions.HYPERNODE)
                        .booleanValue()) {
                    subresult.addAll(getPathsByNode(edge.getTarget()));
                }
            }
            if (subresult.size() > 0) {
                for (List<Point> subpath : subresult) {
                    List<Point> completePath = new LinkedList<Point>();
                    completePath.addAll(path);
                    completePath.addAll(subpath);
                    result.add(completePath);
                }
            } else {
                result.add(path);
            }
            subresult.clear();
        }
        return result;
    }
    
    /**
     * Compute animation paths and location for a given model element (referred by an URI).
     * 
     * @param elementUri The URI object referring the model element
     * @param currentEditor The editor which holds the model element
     * @param diagramLayout The layout of the diagram which contains the model element
     * @return A list of paths, represented by a list of {@link Point}s
     * 
     */
    public static List<List<Point>> getPathsByElement(final KvidUri elementUri,
            final DiagramEditor currentEditor, final KNode diagramLayout) {
        List<List<Point>> result = new LinkedList<List<Point>>();
        String elementUriPart = elementUri.getElementUri();
        Resource resource;
        DiagramLayoutManager manager = EclipseLayoutServices.getInstance()
                                            .getManager(currentEditor, null);
        if (currentEditor.getDiagram() != null && currentEditor.getDiagram().getElement() != null) {
            resource = currentEditor.getDiagram().getElement().eResource();
        } else {
            Status status = new Status(Status.WARNING, KvidPlugin.PLUGIN_ID, 
                    "There was a problem with the diagram's resource.");
            StatusManager.getManager().handle(status, StatusManager.SHOW);
            return null;
        }
        
        if (!elementUriPart.startsWith("/")) {
            try {
                //If not, it might be a Fragment URI, try to translate
                elementUriPart = ptolemyUri2FragmentUri(elementUriPart, resource);
            } catch (IllegalArgumentException iaex) {
                //Notify user about malformatted URI and ignore value during visualization
                Status status = new Status(Status.WARNING, KvidPlugin.PLUGIN_ID, 
                        "Needs Fragment URI or URI in Ptolemy Notation. Got: " + elementUriPart,
                        iaex);
                StatusManager.getManager().handle(status, StatusManager.SHOW);
                return null;
            }
        }
        
        if (elementUriPart == null) {
            //Element couldn't be resolved, can't decide on paths then
            return null;
        }
        EObject modelElement = resource.getEObject(elementUriPart);
        List<EditPart> parts = ModelingUtil.getEditParts(
                currentEditor.getDiagramEditPart(), modelElement);
        KNode currentNode = null;
        for (EditPart part : parts) {
            currentNode = (KNode) manager.getLayoutNode(part);
            if (currentNode != null) {
                break;
            }
        }
        if (currentNode == null) {
            //Couldn't find the referred element, so no paths are created
            return null;
        }
        
        if (currentNode.getPorts().size() > 0) {
            for (KPort port : currentNode.getPorts()) {
                String portName = "";
                String portOption = RuntimeConfiguration.getInstance()
                        .currentValueOfProperty("Default output port");
                if (elementUri.hasPort()) {
                    portName = elementUri.getPort();
                } else if (portOption != "") {
                    portName = portOption;
                }
                if (port.getLabel().getText().equals(portName) || portName.isEmpty()) {
                    result.addAll(getPathsByPort(port));
                }
            }
        } else {
            result.addAll(getPathsByNode(currentNode));
        }
        return result;
    }
    
    /**
     * Helper method for getting the currently active editor.
     * 
     * @return The currently active editor in the UI or null
     */
    public static IEditorPart getActiveEditor() {
        IEditorPart editor = null;
        IWorkbenchWindow[] activeWindows = PlatformUI.getWorkbench()
                .getWorkbenchWindows();
        for (int i = 0; i < activeWindows.length; i++) {
            IWorkbenchPage page = activeWindows[i].getActivePage();
            if (page.getActiveEditor() != null) {
                editor = page.getActiveEditor();
            }
        }
        return editor;
    }
}
