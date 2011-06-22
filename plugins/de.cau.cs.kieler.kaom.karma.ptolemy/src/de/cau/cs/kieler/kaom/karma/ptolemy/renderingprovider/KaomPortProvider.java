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
 * 
 *****************************************************************************/
package de.cau.cs.kieler.kaom.karma.ptolemy.renderingprovider;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PolygonShape;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.swt.graphics.Color;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.NamedObj;
import de.cau.cs.kieler.core.annotations.Annotatable;
import de.cau.cs.kieler.core.annotations.Annotation;
import de.cau.cs.kieler.core.annotations.StringAnnotation;
import de.cau.cs.kieler.kaom.Entity;
import de.cau.cs.kieler.kaom.Port;
import de.cau.cs.kieler.kaom.importer.ptolemy.PtolemyHelper;
import de.cau.cs.kieler.kaom.karma.ptolemy.PtolemyPortBorderItemLocator;
import de.cau.cs.kieler.kaom.karma.ptolemy.conditions.HasCommentsCondition;
import de.cau.cs.kieler.karma.IAdvancedRenderingEditPart;
import de.cau.cs.kieler.karma.IRenderingProvider;

/**
 * @author ckru
 */
public class KaomPortProvider implements IRenderingProvider {

    /**
     * {@inheritDoc}
     */
    public IFigure getFigureByString(final String input, final IFigure oldFigure,
            final EObject object, final EditPart part) {
        EditPart parentPart = part.getParent();

        // ///TODO make port name invisible. not working yet. (hitting layout makes it visible
        // again)
        /*
         * Object partChild = part.getChildren().get(0); if (partChild instanceof PortNameEditPart)
         * { PortNameEditPart portNameEditPart = (PortNameEditPart) partChild; if
         * (portNameEditPart.getFigure() instanceof PortNameFigure) { PortNameFigure pnf =
         * (PortNameFigure) portNameEditPart.getFigure(); pnf.setText(""); } //
         * portNameEditPart.getFigure().setVisible(false); //
         * portNameEditPart.getFigure().setSize(0, 0); //
         * portNameEditPart.getFigure().setOpaque(false); }
         */
        // ///
        if (parentPart instanceof IAdvancedRenderingEditPart) {
            // we want to know the ptolemy class of the object that owns this port
            EObject parentObject = ((IAdvancedRenderingEditPart) parentPart).getModelElement();
            if (parentObject instanceof Annotatable) {
                Annotatable myAnnotatable = (Annotatable) parentObject;
                Annotation annotation = myAnnotatable.getAnnotation("ptolemyClass");
                if (annotation != null && annotation instanceof StringAnnotation) {
                    String ptolemyClassString = ((StringAnnotation) annotation).getValue();
                    try {
                        ptolemy.kernel.Entity entity = getPtolemyEntity(ptolemyClassString);
                        if (entity == null) {
                            return getDefaultFigure();
                        }
                        if (object instanceof Port) {
                            // we fetch a ptolemy instance of this port by its name to get some
                            // informations of its former nature.
                            Port port = (Port) object;
                            String name = port.getName();
                            ptolemy.kernel.Port ptolemyPort = entity.getPort(name);
                            // parameterports are gray
                            if (ptolemyPort instanceof ptolemy.actor.parameters.ParameterPort) {
                                if (input.equals("UP")) {
                                    return getUpwardsPortSvgString(ColorConstants.gray);
                                } else if (input.equals("DOWN")) {
                                    return getDownwardsPortSvgString(ColorConstants.gray);
                                } else {
                                    return getPortSvgString(ColorConstants.gray);
                                }
                            } else if (ptolemyPort instanceof ptolemy.actor.IOPort) {
                                // io multiports are white
                                if (((ptolemy.actor.IOPort) (ptolemyPort)).isMultiport()) {
                                    if (input.equals("UP")) {
                                        return getUpwardsPortSvgString(ColorConstants.white);
                                    } else if (input.equals("DOWN")) {
                                        return getDownwardsPortSvgString(ColorConstants.white);
                                    } else {
                                        return getPortSvgString(ColorConstants.white);
                                    }
                                } else {
                                    // other io ports are black
                                    if (input.equals("UP")) {
                                        return getUpwardsPortSvgString(ColorConstants.black);
                                    } else if (input.equals("DOWN")) {
                                        return getDownwardsPortSvgString(ColorConstants.black);
                                    } else {
                                        return getPortSvgString(ColorConstants.black);
                                    }
                                }
                            } else {
                                // all other ports are painted black
                                if (input.equals("UP")) {
                                    return getUpwardsPortSvgString(ColorConstants.black);
                                } else if (input.equals("DOWN")) {
                                    return getDownwardsPortSvgString(ColorConstants.black);
                                } else {
                                    return getPortSvgString(ColorConstants.black);
                                }
                            }
                        }

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public IFigure getDefaultFigure() {
        RectangleFigure defaultFigure = new RectangleFigure();
        defaultFigure.setLineWidth(1);
        defaultFigure.setForegroundColor(ColorConstants.black);
        defaultFigure.setBackgroundColor(ColorConstants.black);
        return defaultFigure;
    }

    private static final double PORT_SIZE_LONG_SIDE = 7;
    private static final double PORT_SIZE_SHORT_SIDE = 3.5;
    private static final int PORT_SIZE_BOUNDS = 8;

    /**
     * Holds a figure of a triangle pointing east.
     * 
     * @param color
     *            an swt compatible color name
     * @return the port figure
     */
    private IFigure getPortSvgString(final Color color) {
        PointList pointList = new PointList();
        pointList.addPoint(new Point(0, PORT_SIZE_LONG_SIDE));
        pointList.addPoint(new Point(0, 0));
        pointList.addPoint(new Point(PORT_SIZE_LONG_SIDE, PORT_SIZE_SHORT_SIDE));
        pointList.addPoint(new Point(0, PORT_SIZE_LONG_SIDE));
        PolygonShape figure = new PolygonShape();
        figure.setPoints(pointList);
        figure.setBackgroundColor(color);
        figure.setForegroundColor(ColorConstants.black);
        figure.setLineWidth(1);
        figure.getBounds().setSize(PORT_SIZE_BOUNDS, PORT_SIZE_BOUNDS);
        return figure;
    }

    /**
     * Holds a figure of a triangle pointing south.
     * 
     * @param color
     *            an swt compatible color name
     * @return the port figure
     */
    private IFigure getDownwardsPortSvgString(final Color color) {
        PointList pointList = new PointList();
        pointList.addPoint(new Point(0, 0));
        pointList.addPoint(new Point(PORT_SIZE_LONG_SIDE, 0));
        pointList.addPoint(new Point(PORT_SIZE_SHORT_SIDE, PORT_SIZE_LONG_SIDE));
        pointList.addPoint(new Point(0, 0));
        PolygonShape figure = new PolygonShape();
        figure.setPoints(pointList);
        figure.setBackgroundColor(color);
        figure.setForegroundColor(ColorConstants.black);
        figure.setLineWidth(1);
        figure.getBounds().setSize(PORT_SIZE_BOUNDS, PORT_SIZE_BOUNDS);
        return figure;
    }

    /**
     * Holds a figure of a triangle pointing north.
     * 
     * @param color
     *            a swt compatible color name
     * @return the port figure
     */
    private IFigure getUpwardsPortSvgString(final Color color) {
        PointList pointList = new PointList();
        pointList.addPoint(new Point(0, PORT_SIZE_LONG_SIDE));
        pointList.addPoint(new Point(PORT_SIZE_LONG_SIDE, PORT_SIZE_LONG_SIDE));
        pointList.addPoint(new Point(PORT_SIZE_SHORT_SIDE, 0));
        pointList.addPoint(new Point(0, PORT_SIZE_LONG_SIDE));
        PolygonShape figure = new PolygonShape();
        figure.setPoints(pointList);
        figure.setBackgroundColor(color);
        figure.setForegroundColor(ColorConstants.black);
        figure.setLineWidth(1);
        figure.getBounds().setSize(PORT_SIZE_BOUNDS, PORT_SIZE_BOUNDS);
        return figure;
    }

    /**
     * {@inheritDoc}
     */
    public LayoutManager getLayoutManagerByString(final String input,
            final LayoutManager oldLayoutManager, final EObject object) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public BorderItemLocator getBorderItemLocatorByString(final String input,
            final IFigure parentFigure, final Object locator, final EObject object, final CollapseStatus collapseStatus) {
        EObject container = object.eContainer();
        if (container instanceof Entity) {
            // Get the parent to check if its a compositeactor. If it is ports are done by the
            // layout.
            Entity parent = (Entity) container;
            EList<Entity> childEntitys = parent.getChildEntities();
            HasCommentsCondition commentsCondition = new HasCommentsCondition();
            if (childEntitys.isEmpty() && !commentsCondition.evaluate(parent)) {
                EList<Port> ports = parent.getChildPorts();
                // The locator needs all the ports of one side to distribute them evenly.
                if (input.equals("NORTH")) {
                    List<Port> portsOfSide = new LinkedList<Port>();
                    for (Port port : ports) {
                        StringAnnotation cardinal = (StringAnnotation) port
                                .getAnnotation("_cardinal");
                        if (cardinal != null && cardinal.getValue() != null
                                && cardinal.getValue().equals("NORTH")) {
                            portsOfSide.add(port);
                        }
                    }
                    BorderItemLocator newlocator = new PtolemyPortBorderItemLocator(parentFigure,
                            PositionConstants.NORTH, portsOfSide, (Port) object);
                    return newlocator;
                } else if (input.equals("EAST")) {
                    List<Port> portsOfSide = new LinkedList<Port>();
                    for (Port port : ports) {
                        StringAnnotation cardinal = (StringAnnotation) port
                                .getAnnotation("_cardinal");
                        Annotation output = port.getAnnotation("output");
                        if ((cardinal != null && cardinal.getValue() != null && cardinal.getValue()
                                .equals("EAST")) || output != null) {
                            portsOfSide.add(port);
                        }
                    }
                    BorderItemLocator newlocator = new PtolemyPortBorderItemLocator(parentFigure,
                            PositionConstants.EAST, portsOfSide, (Port) object);
                    return newlocator;
                } else if (input.equals("SOUTH")) {
                    List<Port> portsOfSide = new LinkedList<Port>();
                    for (Port port : ports) {
                        StringAnnotation cardinal = (StringAnnotation) port
                                .getAnnotation("_cardinal");
                        Annotation output = port.getAnnotation("inputoutput");
                        if ((cardinal != null && cardinal.getValue() != null && cardinal.getValue()
                                .equals("SOUTH")) || output != null) {
                            portsOfSide.add(port);
                        }
                    }
                    BorderItemLocator newlocator = new PtolemyPortBorderItemLocator(parentFigure,
                            PositionConstants.SOUTH, portsOfSide, (Port) object);
                    return newlocator;
                } else if (input.equals("WEST")) {
                    List<Port> portsOfSide = new LinkedList<Port>();
                    for (Port port : ports) {
                        StringAnnotation cardinal = (StringAnnotation) port
                                .getAnnotation("_cardinal");
                        Annotation output = port.getAnnotation("input");
                        if ((cardinal != null && cardinal.getValue() != null && cardinal.getValue()
                                .equals("WEST")) || output != null) {
                            portsOfSide.add(port);
                        }
                    }
                    BorderItemLocator newlocator = new PtolemyPortBorderItemLocator(parentFigure,
                            PositionConstants.WEST, portsOfSide, (Port) object);
                    return newlocator;
                }
            }
        }
        return null;
    }

    /**
     * Loads the given Ptolemy entity.
     * 
     * @param className
     *            the entity's class name.
     * @return the loaded entity.
     * @throws Exception
     *             various exceptions can occurr.
     */
    private ptolemy.kernel.Entity getPtolemyEntity(final String className) throws Exception {
        try {
            Class<?> ptolemy = Class.forName(className);
            Constructor<?> constr = ptolemy.getConstructor(CompositeEntity.class, String.class);
            Object obj = constr.newInstance(new CompositeEntity(), "cache");
            ptolemy.kernel.Entity entity = (ptolemy.kernel.Entity) obj;
            return entity;
        } catch (ClassNotFoundException e) {
            // Not a class actor, continue below
        } catch (NoClassDefFoundError er) {
            // er.printStackTrace();
            return null;
        }
        // Use Ptolemy to load the actor
        PtolemyHelper ptolemyHelper = new PtolemyHelper();
        NamedObj nObj = null;
        try {
        nObj = ptolemyHelper.instantiatePtolemyEntity(className);
        } catch (Exception e) {;
            return null;
        }
        if (nObj instanceof ptolemy.kernel.Entity) {
            return (ptolemy.kernel.Entity) nObj;
        } else {
            throw new Exception("Couldn't load Ptolemy Entity '" + className + "'.");
        }
    }

    /**
     * {@inheritDoc}
     */
    public Dimension getSizeByString(final String input, final EObject object, final EditPart part) {
        return null;
    }

}
