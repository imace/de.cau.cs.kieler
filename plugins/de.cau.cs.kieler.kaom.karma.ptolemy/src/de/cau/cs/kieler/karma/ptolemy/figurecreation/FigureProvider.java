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

package de.cau.cs.kieler.karma.ptolemy.figurecreation;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Document;

import de.cau.cs.kieler.core.annotations.Annotatable;
import de.cau.cs.kieler.core.annotations.Annotation;
import de.cau.cs.kieler.core.annotations.NamedObject;
import de.cau.cs.kieler.core.annotations.StringAnnotation;
import de.cau.cs.kieler.core.ui.util.CoreUiUtil;
import de.cau.cs.kieler.kvid.KvidUtil;
import de.cau.cs.kieler.kvid.data.DataObject;
import de.cau.cs.kieler.kvid.data.KvidUri;
import de.cau.cs.kieler.kvid.datadistributor.DataDistributor;
import de.cau.cs.kieler.kvid.datadistributor.IDataListener;
import diva.canvas.CanvasUtilities;
import diva.canvas.Figure;
import diva.canvas.toolbox.ImageFigure;

import ptolemy.vergil.icon.EditorIcon;

/**
 * Class for generating draw2d Figures out of svg documents and EditorIcons.
 * 
 * @author ckru
 *
 */
public class FigureProvider {
    
    /**
     * Debug variable. figures are plain rectangles instead of complex svg figures.
     */
    private boolean lightweightGraphics;
    
    /**
     * 
     * @param _lightweightGraphics if true simple rectangles are drawn instead of svg
     */
    public FigureProvider(final boolean _lightweightGraphics) {
        lightweightGraphics = _lightweightGraphics;
    }
    
    /**
     * creates a draw2d ImageFigure out of an ptolemy EditorIcon
     * @param icon the EditorIcon to display in draw2d
     * @return draw2d Figure representing the EditorIcon
     */
    public IFigure createFigureFromIcon(final EditorIcon icon) {
        Figure shape = icon.createBackgroundFigure();
        Image img;
        img = getImageFromFigure(shape);
        BufferedImage resizedImage = new BufferedImage(img.getWidth(null),
                img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        org.eclipse.swt.graphics.Image image = new org.eclipse.swt.graphics.Image(Display.getCurrent(),
                CoreUiUtil.convertAWTImageToSWT(resizedImage));
        ImageFigureEx fig = new ImageFigureEx(image);
        //ScalableImageFigure fig = new ScalableImageFigure(image);
         if (lightweightGraphics) {
             Dimension size = new Dimension(img.getWidth(null),img.getHeight(null));
             IFigure lightweight = getDefaultFigure();
             //lightweight.setBounds(original.getBounds());
             lightweight.setMinimumSize(size.getCopy());
             lightweight.setPreferredSize(size.getCopy());
             lightweight.getBounds().setSize(size.getCopy());
             lightweight.setSize(size.getCopy());
             return lightweight;
         }
        return fig;
    }
    
    /**
     * Create a draw2d ScalableImageFigure out of an svg Document.
     * @param doc the Document holding the svg description
     * @param lightweightSize container for the size of the new object 
     *        used by the lightweight graphics mechanism
     * @return the figure representing the svg
     */
    public IFigure createFigureFromSvg(final Document doc, final Dimension lightweightSize) {
        String svg = "";
        Source source = new DOMSource(doc);
        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = factory.newTransformer();
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();                    
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        svg = stringWriter.getBuffer().toString();
        
        if (svg == null) {
            return getDefaultFigure();
        } else {
            if (lightweightGraphics) {
                IFigure lightweight = getDefaultFigure();
                //lightweight.setBounds(original.getBounds());
                lightweight.setMinimumSize(lightweightSize.getCopy());
                lightweight.setPreferredSize(lightweightSize.getCopy());
                lightweight.getBounds().setSize(lightweightSize.getCopy());
                lightweight.setSize(lightweightSize.getCopy());
                return lightweight;
            } else {
                return createSvg(svg);
            }
        }
    }
    

    /**
     * builds a default figure for this diagram.
     * @return the default figure
     */
    public IFigure getDefaultFigure() {
        RectangleFigure defaultFigure = new RectangleFigure();
        defaultFigure.setLineWidth(1);
        defaultFigure.setForegroundColor(ColorConstants.black);
        defaultFigure.setBackgroundColor(ColorConstants.white);
        return defaultFigure;
    }
    
    /**
     * method for generating a scalable image figure from a file.
     * 
     * @param svgString
     *            the string representing the svg image
     * @return a scalable image figure
     */
    private IFigure createSvg(final String svgString) {
        RenderedImage img = RenderedImageFactory.getInstance(svgString.getBytes());
        ScalableImageFigure fig = new ScalableImageFigure(img, false, true, true);
        return fig;
    }
    
    /**
     * Gets an awt image out of a diva figure.
     * @param figure diva figure holding an image 
     * @return the awt image of the diva figure
     */
    private Image getImageFromFigure(final Figure figure) {
        if (figure instanceof ImageFigure) {
            ImageFigure imageFigure = (ImageFigure) figure;
            Image image = imageFigure.getImage();
            if (image != null) {
                image = image.getScaledInstance(image.getWidth(null), image.getHeight(null),
                        Image.SCALE_DEFAULT);
                return image;
            } else {
                throw new NullPointerException("Failed to get an image from " + imageFigure);
            }
        } else {
            Rectangle2D bounds = figure.getBounds();
            Rectangle2D size = new Rectangle2D.Double(0, 0, figure.getBounds().getWidth(), figure
                    .getBounds().getHeight());
            AffineTransform transform = CanvasUtilities.computeFitTransform(bounds, size);
            figure.transform(transform);

            BufferedImage image = new BufferedImage((int) figure.getBounds().getWidth(),
                    (int) figure.getBounds().getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D graphics = image.createGraphics();

            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setBackground(new Color(255, 255, 255, 255));
            graphics.clearRect(0, 0, (int) figure.getBounds().getWidth(), (int) figure.getBounds()
                    .getHeight());
            figure.paint(graphics);
            return image;
        }
    }
    
    /**
     * Method holding a figure description used by directors.
     * 
     * @return a figure represention an director
     */
    public IFigure createDirector() {
        RectangleFigure director = new RectangleFigure();
        director.getBounds().setSize(100, 30);
        director.setBackgroundColor(ColorConstants.green);
        director.setForegroundColor(ColorConstants.black);
        return director;
    }

    /**
     * A custom svg of an Accumulator since the ptolemy one is bugged.
     * @return a ScalableImageFigure representing an Accumulator
     */
    public IFigure createAccumulator() {
        String accsvg = "<svg height=\"41\" width=\"41\" >"
                + "<rect height=\"40\" style=\"fill:white;stroke:black;stroke-width:1\" "
                + "width=\"40\" x=\"0.0\" y=\"0.0\" />"
                + "<path d=\"m 29.126953,6.2304687 0,3.0410157 -13.833984,0 8.789062,9.3515626 "
                + "-8.789062,10.335937 14.554687,0 0,3.041016 -18.246093,0 "
                + "0,-3.550781 8.419921,-9.826172 -8.419921,-8.9648439 0,-3.4277344 z\" />"
                + "</svg>";
        if (lightweightGraphics) {
            return getDefaultFigure();
        }
        return createSvg(accsvg);
    }
    
    /**
     * Method for creating a custom monitorvalue figure.
     * 
     * @param object
     *            the modelelement
     * @return the monitorvalue figure
     */
    public IFigure createMonitorValue(final EObject object) {
        MonitorValueFigure monitor = new MonitorValueFigure(object);
        monitor.setLineWidth(1);
        monitor.setForegroundColor(ColorConstants.black);
        monitor.setBackgroundColor(ColorConstants.white);
        return monitor;
    }
    
    /**
     * a monitor figure using the kvid mechanism of displaying its value.
     * 
     * @author ckru
     * 
     */
    private class MonitorValueFigure extends RectangleFigure implements IDataListener {

        private Label value;

        private String referredDataUri;

        private static final int LABELSIZE_WIDTH = 140;
        private static final int LABELSIZE_HEIGHT = 10;
        private static final int LABELLOCATION_X = 70;
        private static final int LABELLOCATION_Y = 10;

        /**
         * constructs this figure and adds a label that displays the current value.
         * 
         * @param object
         *            the model element.
         */
        public MonitorValueFigure(final EObject object) {
            value = new Label();
            value.getBounds().setSize(LABELSIZE_WIDTH, LABELSIZE_HEIGHT);
            value.getBounds().setLocation(LABELLOCATION_X, LABELLOCATION_Y);
            this.setLayoutManager(new BorderLayout());
            this.add(value);
            String uri = object.eResource().getURIFragment(object);
            uri = KvidUtil.fragmentUri2PtolemyUri(uri, object.eResource());
            if (object instanceof de.cau.cs.kieler.kaom.Entity) {
                de.cau.cs.kieler.kaom.Entity entity = (de.cau.cs.kieler.kaom.Entity) object;
                NamedObject port = entity.getChildPorts().get(0);
                uri += ":" + port.getName();
                referredDataUri = uri;
                DataDistributor.getInstance().registerDataListener(this);
            }

        }

        /**
         * {@inheritDoc}
         */
        public void triggerDataChanged(final boolean isHistoryValue) {
            DataObject data = DataDistributor.getInstance().getDataObjectByURI(
                    new KvidUri(referredDataUri));
            if (data != null) {
                value.setText(data.getData().toString());
            }
        }

        /**
         * {@inheritDoc}
         */
        public void triggerWrapup() {
            value.setText("");
        }

    }

    private static final int DEFAULT_WIDTH = 90;
    private static final int DEFAULT_HEIGHT = 30;
    private static final int LABELSIZE_HEIGHT = 12;
    private static final int LABELSIZE_WIDTH = 80;
    private static final int LABELLOCATION_X = 5;
    private static final int LABELLOCATION_Y = 8;

    /**
     * A figure that displays a value.
     * @param object the model element
     * @param valueAttribute name of the annotation holding the value
     * @param part the editpart of the model element
     * @return a figure that display the given value
     */
    public IFigure createValueFigure(final EObject object, final String valueAttribute,
            final EditPart part) {
        RectangleFigure constFigure = (RectangleFigure) getDefaultFigure();
        if (object instanceof Annotatable) {
            Annotation iconAnn = ((Annotatable) object).getAnnotation("_icon");
            int width;
            if (iconAnn != null) {
                StringAnnotation sizeAnn = (StringAnnotation) iconAnn.getAnnotation("displayWidth");

                if (sizeAnn != null) {
                    width = Integer.parseInt(sizeAnn.getValue());
                } else {
                    width = DEFAULT_WIDTH;
                }
            } else {
                width = DEFAULT_WIDTH;
            }
            Dimension dim = new Dimension(width, DEFAULT_HEIGHT);
            constFigure.getBounds().setSize(dim);
            constFigure.setMaximumSize(dim.getCopy());
            constFigure.setMinimumSize(dim.getCopy());
            constFigure.setPreferredSize(dim.getCopy());

            if (!valueAttribute.equals("null")) {
                Annotation valueAnn = ((Annotatable) object).getAnnotation(valueAttribute);
                String value = ((StringAnnotation) valueAnn).getValue();
                Label valueLabel = new Label();
                valueLabel.setText(value);
                valueLabel.setBounds(new Rectangle(LABELLOCATION_X, LABELLOCATION_Y,
                /* width -5 */LABELSIZE_WIDTH, LABELSIZE_HEIGHT));
                constFigure.setLayoutManager(new BorderLayout());
                constFigure.add(valueLabel);
            }

        }
        return constFigure;

    }
    
    
}