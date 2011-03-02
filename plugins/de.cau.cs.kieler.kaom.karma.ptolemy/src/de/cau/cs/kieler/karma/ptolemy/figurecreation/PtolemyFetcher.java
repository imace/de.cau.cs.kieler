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

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.statushandlers.StatusManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import de.cau.cs.kieler.core.annotations.Annotatable;
import de.cau.cs.kieler.core.annotations.Annotation;
import de.cau.cs.kieler.core.annotations.StringAnnotation;
import de.cau.cs.kieler.kaom.importer.ptolemy.PtolemyHelper;
import de.cau.cs.kieler.kaom.karma.ptolemy.Activator;

import ptolemy.data.expr.XMLParser;
import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.ConfigurableAttribute;
import ptolemy.kernel.util.NamedObj;
import ptolemy.moml.test.TestIconLoader;
import ptolemy.vergil.icon.EditorIcon;

/**
 * Class to fetch some stuff such as svg descriptions and ptolemy class instance from ptolemy.
 * 
 * @author ckru
 *
 */
public final class PtolemyFetcher {

    /**
     * This is a utility Class and thus the constructor is hidden.
     */
    private PtolemyFetcher() {
        
    }
    
    /**
     * Get the EditorIcons from a ptolemy NamedObj.
     * 
     * @param nObj
     *            the NamedObj
     * @return the list of EditorIcons of the given object
     */
    public static List<EditorIcon> fetchIcons(final NamedObj nObj) {
        TestIconLoader til = new TestIconLoader();
        try {
            til.loadIconForClass(nObj.getClassName(), nObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<EditorIcon> icons = nObj.attributeList(EditorIcon.class);
        return icons;
    }

    /**
     * Gets the svg Document representing a ptolemy NamedObj.
     * 
     * @param nObj
     *            the NamedObj
     * @param size
     *            container used by lightweightgraphics mechanism.
     * @return an svg Document representing the NamedObj
     */
    public static Document fetchSvgDoc(final NamedObj nObj, final Dimension size) {
        ConfigurableAttribute ca = (ConfigurableAttribute) nObj.getAttribute("_iconDescription");
        String svg = ca.getConfigureText();
        try {
            XMLParser xmlpars = new XMLParser();
            Document doc;
            try {
                doc = xmlpars.parser(svg);
            } catch (Exception e) {
                svg = repairString(svg);
                doc = xmlpars.parser(svg);
            }
            doc = repairSvg(doc, size);
            return doc;
        } catch (Exception e) {

        }
        return null;

    }

    /**
     * Helper method for converting a ptolemy svg description to an svg description thats compatible
     * with the common svg standard.
     * 
     * @param svg
     *            the string describing an svg in xml
     * @return an svg description compatible with the svg standard
     */
    private static Document repairSvg(final Document doc, final Dimension size) {
        try {
            Element svgElement = (Element) doc.getElementsByTagName("svg").item(0);
            NodeList nodeList = doc.getElementsByTagName("rect");
            int xoffset = 0;
            int yoffset = 0;
            if (nodeList.getLength() != 0) {
                Element rectElement = (Element) doc.getElementsByTagName("rect").item(0);

                svgElement.setAttribute("height",
                        String.valueOf(Integer.parseInt(rectElement.getAttribute("height")) + 1));
                svgElement.setAttribute("width",
                        String.valueOf(Integer.parseInt(rectElement.getAttribute("width")) + 1));
                size.height = Integer.parseInt(rectElement.getAttribute("height")) + 1;
                size.width = Integer.parseInt(rectElement.getAttribute("width")) + 1;
                xoffset = Math.abs(Integer.parseInt(rectElement.getAttribute("x")));
                yoffset = Math.abs(Integer.parseInt(rectElement.getAttribute("y")));
            } else {
                // TODO hacked else case, think of something better
                int childPointer = 0;
                Object object = svgElement.getChildNodes().item(childPointer);
                while (!(object instanceof Element) && (object != svgElement)) {
                    object = svgElement.getElementsByTagName("*").item(childPointer);
                }
                Element firstElement = (Element) object;
                if (firstElement.hasAttribute("points")) {
                    String points = firstElement.getAttribute("points");
                    String[] splittedPoints = points.split(" +");
                    String firstPoint = splittedPoints[0];
                    String[] firstPointCoords = firstPoint.split(",");
                    //xoffset = Math.abs(Integer.parseInt(firstPointCoords[0]));
                    //yoffset = Math.abs(Integer.parseInt(firstPointCoords[1]));
                    List<Integer> pointsX = new LinkedList<Integer>();
                    List<Integer> pointsY = new LinkedList<Integer>();
                    for (String singlePoint : splittedPoints) {
                        String[] pointCoord = singlePoint.split(",");
                        pointsX.add(Integer.parseInt(pointCoord[0]));
                        pointsY.add(Integer.parseInt(pointCoord[1]));
                    }
                    int minX = Collections.min(pointsX);
                    int minY = Collections.min(pointsY);
                    xoffset = Math.abs(minX);
                    yoffset = Math.abs(minY);
                    int maxX = Collections.max(pointsX);
                    int maxY = Collections.max(pointsY);
                    svgElement.setAttribute("height", String.valueOf(maxX + xoffset + 1));
                    svgElement.setAttribute("width", String.valueOf(maxY + yoffset + 1));
                    size.height = maxX + xoffset + 1;
                    size.width = maxY + yoffset + 1;
                }

            }
            for (int i = 0; i < doc.getElementsByTagName("rect").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("rect").item(i);
                if (e.hasAttribute("x") && e.hasAttribute("y") && e.hasAttribute("style")) {
                    float x = Float.parseFloat(e.getAttribute("x"));
                    float y = Float.parseFloat(e.getAttribute("y"));
                    x += xoffset;
                    y += yoffset;
                    e.setAttribute("x", String.valueOf(x));
                    e.setAttribute("y", String.valueOf(y));
                    e.setAttribute("style",
                            e.getAttribute("style").concat(";stroke:black;stroke-width:1"));
                }
            }

            for (int i = 0; i < doc.getElementsByTagName("circle").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("circle").item(i);
                if (e.hasAttribute("cx") && e.hasAttribute("cy")) {
                    float x = Float.parseFloat(e.getAttribute("cx"));
                    float y = Float.parseFloat(e.getAttribute("cy"));
                    x += xoffset;
                    y += yoffset;
                    e.setAttribute("cx", String.valueOf(x));
                    e.setAttribute("cy", String.valueOf(y));
                }
                e.setAttribute("style",
                        e.getAttribute("style").concat(";stroke:black;stroke-width:1"));
            }

            for (int i = 0; i < doc.getElementsByTagName("polygon").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("polygon").item(i);
                if (e.hasAttribute("points")) {
                    String newpoints = "";
                    String allpoints = e.getAttribute("points");
                    String[] pointsarray = allpoints.split(" +");
                    for (String coords : pointsarray) {
                        String[] coordsarray = coords.split(",");
                        float x = Float.parseFloat(coordsarray[0]);
                        float y = Float.parseFloat(coordsarray[1]);
                        x += xoffset;
                        y += yoffset;
                        newpoints += String.valueOf(x) + "," + String.valueOf(y) + " ";

                    }
                    e.setAttribute("points", newpoints);
                    e.setAttribute("style",
                            e.getAttribute("style").concat(";stroke:black;stroke-width:1"));
                }
            }

            for (int i = 0; i < doc.getElementsByTagName("polyline").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("polyline").item(i);
                if (e.hasAttribute("points")) {
                    String newpoints = "";
                    String allpoints = e.getAttribute("points");
                    String[] pointsarray = allpoints.split(" +");
                    for (String coords : pointsarray) {
                        String[] coordsarray = coords.split(",");
                        float x = Float.parseFloat(coordsarray[0]);
                        float y = Float.parseFloat(coordsarray[1]);
                        x += xoffset;
                        y += yoffset;
                        newpoints += String.valueOf(x) + "," + String.valueOf(y) + " ";

                    }
                    e.setAttribute("points", newpoints);
                }
            }

            for (int i = 0; i < doc.getElementsByTagName("line").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("line").item(i);
                if (e.hasAttribute("x1") && e.hasAttribute("y1") && e.hasAttribute("x2")
                        && e.hasAttribute("y2")) {
                    float x1 = Float.parseFloat(e.getAttribute("x1"));
                    float y1 = Float.parseFloat(e.getAttribute("y1"));
                    float x2 = Float.parseFloat(e.getAttribute("x2"));
                    float y2 = Float.parseFloat(e.getAttribute("y2"));
                    x1 += xoffset;
                    y1 += yoffset;
                    x2 += xoffset;
                    y2 += yoffset;
                    e.setAttribute("x1", String.valueOf(x1));
                    e.setAttribute("y1", String.valueOf(y1));
                    e.setAttribute("x2", String.valueOf(x2));
                    e.setAttribute("y2", String.valueOf(y2));
                }
                e.setAttribute("style",
                        e.getAttribute("style").concat(";stroke:black;stroke-width:1"));
            }

            for (int i = 0; i < doc.getElementsByTagName("image").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("image").item(i);
                if (e.hasAttribute("x") && e.hasAttribute("y")) {
                    float x = Float.parseFloat(e.getAttribute("x"));
                    float y = Float.parseFloat(e.getAttribute("y"));
                    x += xoffset;
                    y += yoffset;
                    e.setAttribute("x", String.valueOf(x));
                    e.setAttribute("y", String.valueOf(y));
                }
            }

            for (int i = 0; i < doc.getElementsByTagName("ellipse").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("ellipse").item(i);
                if (e.hasAttribute("cx") && e.hasAttribute("cy")) {
                    float x = Float.parseFloat(e.getAttribute("cx"));
                    float y = Float.parseFloat(e.getAttribute("cy"));
                    x += xoffset;
                    y += yoffset;
                    e.setAttribute("cx", String.valueOf(x));
                    e.setAttribute("cy", String.valueOf(y));
                }
            }

            for (int i = 0; i < doc.getElementsByTagName("text").getLength(); i++) {
                Element e = (Element) doc.getElementsByTagName("text").item(i);
                if (e.hasAttribute("x") && e.hasAttribute("y")) {
                    float x = Float.parseFloat(e.getAttribute("x"));
                    float y = Float.parseFloat(e.getAttribute("y"));
                    x += xoffset;
                    y += yoffset;
                    e.setAttribute("x", String.valueOf(x));
                    e.setAttribute("y", String.valueOf(y));
                }
            }
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper method that adds necessary blanks to an svg description because ptolemy is bugged.
     * 
     * @param input
     *            the broken svg description
     * @return a repaired version of the input that an xml parser can understand.
     */
    private static String repairString(final String input) {
        String[] parts = input.split("\"");
        String output = "";
        for (int i = 0; i < parts.length; i += 2) {
            if (i < parts.length - 1) {
                output += parts[i] + "\"" + parts[i + 1] + "\" ";
            } else {
                output += parts[i];
            }
        }
        return output;
    }
    
    /**
     * Get an instance of a Ptolemy class according to an EObjects annotation.
     * @param object the object representing an ptolemy object. Should have an "ptolemyClass" annotation.
     * @return a ptolemy instance of the object.
     */
    public static NamedObj getPtolemyInstance(final EObject object) {
        if (object instanceof Annotatable) {
            Annotatable myAnnotatable = (Annotatable) object;
            Annotation annotation = myAnnotatable.getAnnotation("ptolemyClass");
            if (annotation != null && annotation instanceof StringAnnotation) {
                String ptolemyClassString = ((StringAnnotation) annotation).getValue();
                try {
                    /* First, assume that the actor is defined in a Java class.
                     * If that fails, we fall back to letting Ptolemy load the
                     * actor, which handles the case of the actor being defined
                     * in its own Ptolemy model file.
                     */
                    Object obj;
                    Class<?> ptolemy = Class.forName(ptolemyClassString);
                    Constructor<?> constr = ptolemy.getConstructor(CompositeEntity.class,
                            String.class);
                    obj = constr.newInstance(new CompositeEntity(), "cache");
                    if (obj instanceof NamedObj) {
                        NamedObj nObj = (NamedObj) obj;
                        return nObj;
                    }
                } catch (ClassNotFoundException ce) {
                    // Do nothing. We'll handle that after the try-catch block.
                } catch (NoClassDefFoundError er) {
                    //er.printStackTrace();
                    return null;
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                
                try {
                    // Use Ptolemy to load the actor
                    PtolemyHelper ptolemyHelper = new PtolemyHelper();
                    NamedObj nObj = ptolemyHelper.instantiatePtolemyEntity(ptolemyClassString);
                    
                    if (nObj != null) {
                        return nObj;
                    }
                } catch (Exception e) {
                    Status myStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "ptolemy instance failed to load", e);
                    StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
                }
            }
        }
        return null;
    }

}
