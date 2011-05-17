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
package de.cau.cs.kieler.core.model.gmf.figures;

import java.util.Hashtable;

import org.eclipse.draw2d.ArrowLocator;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Path;

import de.cau.cs.kieler.core.model.gmf.util.SplineUtilities;

/**
 * Temporary class implementing the spline extension to polylines until the changes are merged into
 * GMF.
 * 
 * @author mmu
 * 
 */
public class SplineConnection extends PolylineConnectionEx {
    /**
     * Mode for spline drawing.
     */
    private int splineMode = 0;
    /**
     * Remember if advanced graphics support is available, assume yes at first.
     */
    private boolean advancedGraphics = true;
    /**
     * Don't draw splines.
     */
    public static final int SPLINE_OFF = 0;
    /**
     * Draw cubic spline segments.
     */
    public static final int SPLINE_CUBIC = 1;
    /**
     * Approximate cubic spline segments.
     */
    public static final int SPLINE_CUBIC_APPROX = 2;

    /**
     * A dimension used by the isFeedbackLayer() method to check if we are on a feedback layer.
     */
    private static final Dimension DIMCHECK = new Dimension(100, 100);

    /**
     * Tolerance value for distance cursor-line.
     */
    private static final int TOLERANCE = 3;

    /**
     * Shape of line bounds.
     */
    private static final Rectangle LINEBOUNDS = Rectangle.SINGLETON;

    /**
     * Temporary preference key.
     */
    public static final String PREF_SPLINE_MODE = "Connectors.splineMode"; //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx#containsPoint (int, int)
     */
    @Override
    public boolean containsPoint(final int x, final int y) {
        boolean isFeedbackLayer = isFeedbackLayer();
        int calculatedTolerance = calculateTolerance(isFeedbackLayer);

        LINEBOUNDS.setBounds(getBounds());
        LINEBOUNDS.expand(calculatedTolerance, calculatedTolerance);
        if (!LINEBOUNDS.contains(x, y)) {
            return false;
        }

        // CHECKSTYLEOFF MagicNumber
        if (getSplineMode() == SPLINE_CUBIC) {
            PointList points = getPoints();
            int i = 1;
            for (; i < getPoints().size() - 2; i += 3) {
                // check individual spline bounds
                Point start = points.getPoint(i - 1);
                Point c1 = points.getPoint(i);
                Point c2 = points.getPoint(i + 1);
                Point end = points.getPoint(i + 2);
                Rectangle splineBound = new Rectangle(start, end);
                splineBound = splineBound.getUnion(new Rectangle(c1, c2));
                splineBound.expand(calculatedTolerance, calculatedTolerance);
                if (splineBound.contains(x, y)
                        && SplineUtilities.distanceFromSpline(start, c1, c2, end, new Point(x, y)) < calculatedTolerance) {
                    return true;
                }
            }

            if (i == getPoints().size() - 2) {
                // quad left
                if (SplineUtilities.distanceFromSpline(
                        getPoints().getPoint(getPoints().size() - 3),
                        getPoints().getPoint(getPoints().size() - 2),
                        getPoints().getPoint(getPoints().size() - 1), new Point(x, y)) < calculatedTolerance) {
                    return true;
                }
            } else if (i == getPoints().size() - 1) {
                // line left
                if (lineContainsPoint(getPoints().getPoint(i - 1).x, getPoints().getPoint(i - 1).y,
                        getPoints().getPoint(i).x, getPoints().getPoint(i).y, x, y, isFeedbackLayer)) {
                    return true;
                }
            }
        } else if (getSplineMode() == SPLINE_CUBIC_APPROX) {
            int[] ints = SplineUtilities.approximateSpline(getPoints()).toIntArray();
            for (int index = 0; index < ints.length - 3; index++) {
                if (lineContainsPoint(ints[index++], ints[index], ints[index + 1], ints[index + 2],
                        x, y, isFeedbackLayer)) {
                    return true;
                }
            }
        }
        // CHECKSTYLEON MagicNumber

        return super.containsPoint(x, y);
    }

    /**
     * This method checks if we are on a feedback layer by comparing the value of a Dimension with
     * the value after translating it into relative coordinates.
     * 
     * Copied from PolylineConnectionEx because it is private there but required for
     * containsPoint().
     * 
     * @return true if we are on a feedback layer, which means the results after translating were
     *         the same as not translating, or false if we are not on a feedback layer.
     */
    protected boolean isFeedbackLayer() {
        Dimension copied = DIMCHECK.getCopy();
        translateToRelative(copied);
        return DIMCHECK.equals(copied);
    }

    /**
     * Checks if edge corners should be rounded. Same as super method, except it doesn't check if
     * edge routing is orthogonal.
     * 
     * @return {@code true} if edge corners should be rounded.
     */
    @Override
    public boolean isRoundingBendpoints() {
        if (super.getRoundedBendpointsRadius() > 0 && getSmoothness() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Calculate and store the tolerance value for determining whether the line contains a point or
     * not.
     * 
     * Copied from PolylineConnectionEx because it is private there but required for
     * containsPoint().
     * 
     * @param isFeedbackLayer
     *            see the isFeedbackLayer() method
     * @return tolerance value
     */
    protected int calculateTolerance(final boolean isFeedbackLayer) {
        Dimension absTol = new Dimension(TOLERANCE, 0);

        if (!isFeedbackLayer) {
            MapModeUtil.getMapMode(this).DPtoLP(absTol);
        }

        return absTol.width + lineWidth / 2;
    }

    /**
     * Checks whether a point is near a line or not.
     * 
     * @param x1
     *            line start
     * @param y1
     *            line start
     * @param x2
     *            line end
     * @param y2
     *            line end
     * @param px
     *            point
     * @param py
     *            point
     * @param isFeedbackLayer
     *            whether we're on a feedback layer or not
     * @return true if (px,py) is near the line
     */
    protected boolean lineContainsPoint(final int x1, final int y1, final int x2, final int y2,
            final int px, final int py, final boolean isFeedbackLayer) {
        LINEBOUNDS.setSize(0, 0);
        LINEBOUNDS.setLocation(x1, y1);
        LINEBOUNDS.union(x2, y2);
        int calculatedTolerance = calculateTolerance(isFeedbackLayer);
        LINEBOUNDS.expand(calculatedTolerance, calculatedTolerance);
        if (!LINEBOUNDS.contains(px, py)) {
            return false;
        }

        double v1x, v1y, v2x, v2y;
        double numerator, denominator;
        double result = 0;

        if (x1 != x2 && y1 != y2) {
            v1x = (double) x2 - x1;
            v1y = (double) y2 - y1;
            v2x = (double) px - x1;
            v2y = (double) py - y1;

            numerator = v2x * v1y - v1x * v2y;

            denominator = v1x * v1x + v1y * v1y;

            result = numerator * numerator / denominator;
        }

        // if it is the same point, and it passes the bounding box test,
        // the result is always true.
        return result <= calculatedTolerance * calculatedTolerance;
    }

    /**
     * Set spline mode for this connection.
     * 
     * @param mode
     *            spline mode
     */
    public void setSplineMode(final int mode) {
        splineMode = mode;
        refreshLine();
    }

    /**
     * Gets the spline mode for this connection. Fall back to approximation if smooth splines are
     * selected but no advanced graphics support is available
     * 
     * @return spline mode
     */
    public int getSplineMode() {
        if (splineMode == SPLINE_CUBIC && !advancedGraphics) {
            // fall back to approximation
            return SPLINE_CUBIC_APPROX;
        } else {
            return splineMode;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx#outlineShape
     * (org.eclipse.draw2d.Graphics)
     */
    @Override
    public void outlineShape(final Graphics g) {
        if (getSplineMode() == SPLINE_CUBIC) {
            try {
                int size = getPoints().size();
                if (size < 1) {
                    return; // nothing to do
                }
                Path p = new Path(null);
                p.moveTo(getPoints().getFirstPoint().x, getPoints().getFirstPoint().y);

                // draw cubic sections
                int pI = 1;
                // CHECKSTYLEOFF MagicNumber
                for (; pI < size - 2; pI += 3) {
                    p.cubicTo(getPoints().getPoint(pI).x, getPoints().getPoint(pI).y, getPoints()
                            .getPoint(pI + 1).x, getPoints().getPoint(pI + 1).y, getPoints()
                            .getPoint(pI + 2).x, getPoints().getPoint(pI + 2).y);
                }
                // CHECKSTYLEON MagicNumber

                // draw remaining sections, won't happen if DOT was applied
                // size-1: one straight line
                // size-2: one quadratic
                switch (size - pI) {
                case 1:
                    p.lineTo(getPoints().getPoint(pI).x, getPoints().getPoint(pI).y);
                    break;
                case 2:
                    p.quadTo(getPoints().getPoint(pI).x, getPoints().getPoint(pI).y, getPoints()
                            .getPoint(pI + 1).x, getPoints().getPoint(pI + 1).y);
                    break;
                }

                g.drawPath(p);
                p.dispose();
            } catch (SWTException e) {
                // Exception due to no advanced graphics?
                if (e.code == SWT.ERROR_NO_GRAPHICS_LIBRARY) {
                    advancedGraphics = false;
                }
                g.drawPolyline(SplineUtilities.approximateSpline(getPoints()));
            }
        } else if (getSplineMode() == SPLINE_CUBIC_APPROX) {
            g.drawPolyline(SplineUtilities.approximateSpline(getPoints()));
        } else if (isRoundingBendpoints()) {
            ///////////////////////////////////////////////////////
            /////////////Temporary gmf bugfix//////////////////////
            //https://bugs.eclipse.org/bugs/show_bug.cgi?id=345886/
            ///////////////////////////////////////////////////////

            PointList displayPoints = getSmoothPoints(false);

            Hashtable<Point, Integer> originalDisplayPoints = null;
            originalDisplayPoints = new Hashtable<Point, Integer>();
            for (int i = 0; i < displayPoints.size(); i++) {
                originalDisplayPoints.put(displayPoints.getPoint(i), new Integer(i));
            }
            // In originalDisplayPoints, each bendpoint will be replaced with two points: start and
            // end point of the arc.
            // If jump links is on, then displayPoints will also contain points identifying jump
            // links, if any.
            int i = 1;
            int rDefault = getRoundedBendpointsRadius();
            while (i < displayPoints.size() - 1) {
                // Consider points at indexes i-1, i, i+1.
                int x0 = 0, y0 = 0;
                boolean firstPointAssigned = false;
                if (i < displayPoints.size() - 1) { // if we still didn't reach the end after
                                                    // drawing jump link polyline
                    // Draw a segment starting at index i-1 and ending at index i,
                    // and arc with starting point at index i and ending point at index i+1.
                    // But first, find points at i-1, i and i+1.
                    if (!firstPointAssigned) {
                        x0 = displayPoints.getPoint(i - 1).x;
                        y0 = displayPoints.getPoint(i - 1).y;
                    }
                    int x1;
                    
                    int y1;
                    // If points at i-1 and i are equal (could happen if jump link algorithm
                    // inserts a point that already exists), just skip the point i
                    while (i < displayPoints.size() - 1 && x0 == displayPoints.getPoint(i).x
                            && y0 == displayPoints.getPoint(i).y) {
                        i++;
                    }
                    if (i < displayPoints.size() - 1) {
                        x1 = displayPoints.getPoint(i).x;
                        y1 = displayPoints.getPoint(i).y;
                    } else {
                        break;
                    }

                    // The same goes for point at i and i+1
                    int x2;
                    int y2;
                    while (i + 1 < displayPoints.size() - 1
                            && x1 == displayPoints.getPoint(i + 1).x
                            && y1 == displayPoints.getPoint(i + 1).y) {
                        i++;
                    }
                    if (i < displayPoints.size() - 1) {
                        x2 = displayPoints.getPoint(i + 1).x;
                        y2 = displayPoints.getPoint(i + 1).y;
                    } else {
                        break;
                    }

                    // Draw the segment
                    g.drawLine(x0, y0, x1, y1);

                    // Find out if arc size is default, or if it had to be decreased because of lack
                    // of space
                    this.getRoundedCornersPoints(false);
                    int r = rDefault;
                    Point p = displayPoints.getPoint(i);
                    int origIndex = ((Integer) originalDisplayPoints.get(p)).intValue();
                    Object o = rForBendpointArc.get(new Integer((origIndex + 1) / 2));
                    if (o != null) {
                        r = ((Integer) o).intValue();
                    }
                    // Find out the location of enclosing rectangle (x, y), as well as staring angle
                    // of the arc.
                    int x, y;
                    int startAngle;
                    if (x0 == x1 && x1 < x2) {
                        x = x1;
                        y = y1 - r;
                        if (y1 > y2) {
                            startAngle = 90;
                        } else {
                            startAngle = 180;
                        }
                    } else if (x0 > x1 && x1 > x2) {
                        x = x2;
                        y = y2 - r;
                        if (y1 > y2) {
                            startAngle = 180;
                        } else {
                            startAngle = 90;
                        }
                    } else if (x0 == x1 && x1 > x2) {
                        if (y1 > y2) {
                            x = x2 - r;
                            y = y2;
                            startAngle = 0;
                        } else {
                            x = x1 - 2 * r;
                            y = y1 - r;
                            startAngle = 270;
                        }
                    } else { // x0 < x1 && x1 < x2
                        if (y1 > y2) {
                            x = x2 - 2 * r;
                            y = y2 - r;
                            startAngle = 270;
                        } else {
                            x = x1 - r;
                            y = y1;
                            startAngle = 0;
                        }
                    }
                    // Draw the arc.
                    g.drawArc(x, y, 2 * r, 2 * r, startAngle, 90);
                    i += 2;
                }
            }
            // Draw the last segment.
            g.drawLine(displayPoints.getPoint(displayPoints.size() - 2),
                    displayPoints.getLastPoint());
            //bugfix end
        } else {
            super.outlineShape(g);
        }
    }

    ///////////////////////////////////////////////////////
    /////////////Temporary gmf bugfix//////////////////////
    //https://bugs.eclipse.org/bugs/show_bug.cgi?id=345886/
    ///////////////////////////////////////////////////////
    private Hashtable<Integer, Integer> rForBendpointArc;
    @Override
    public PointList getRoundedCornersPoints(boolean calculateAppoxPoints) {
        if (rForBendpointArc != null) {
            rForBendpointArc.clear();
        } else {
            rForBendpointArc = new Hashtable<Integer, Integer>();
        }

        return SplineUtilities.calcRoundedCornersPolyline(getPoints(),
                getRoundedBendpointsRadius(), rForBendpointArc, calculateAppoxPoints);
    }
    //bugfix end

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.PolylineConnection#setTargetDecoration(org.eclipse
     * .draw2d.RotatableDecoration)
     */
    @Override
    public void setTargetDecoration(final RotatableDecoration dec) {
        super.setTargetDecoration(dec, new ArrowLocatorEx(this, ConnectionLocator.TARGET));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.draw2d.PolylineConnection#setSourceDecoration(org.eclipse
     * .draw2d.RotatableDecoration)
     */
    @Override
    public void setSourceDecoration(final RotatableDecoration dec) {
        super.setSourceDecoration(dec, new ArrowLocatorEx(this, ConnectionLocator.SOURCE));
    }

    /**
     * An extension of the ArrowLocator that is capable of using spline points as references.
     * 
     * @author mmu
     * 
     */
    public static class ArrowLocatorEx extends ArrowLocator {

        /**
         * 
         * @param connection
         *            the connection
         * @param location
         *            source or target
         */
        public ArrowLocatorEx(final Connection connection, final int location) {
            super(connection, location);
        }

        /**
         * Relocates the passed in figure (which must be a {@link RotatableDecoration}) at either
         * the start or end of the connection.
         * 
         * If the connection is a SplineConnection with spline mode enabled the angle is computed
         * from the spline itself, not from the draggable points.
         * 
         * @param target
         *            The RotatableDecoration to relocate
         */
        public void relocate(final IFigure target) {
            PointList points = getConnection().getPoints();
            RotatableDecoration arrow = (RotatableDecoration) target;
            arrow.setLocation(getLocation(points));

            if (getConnection() instanceof SplineConnection) {
                SplineConnection spline = (SplineConnection) getConnection();
                if (spline.getSplineMode() == SplineConnection.SPLINE_CUBIC) {
                    // int size = (arrow.getBounds().height + arrow.getBounds().width) / 2;
                    // this caused the wobbling arrowheads
                    // FIXME find a better mechanism of determining the size of an arrowhead
                    // SUPPRESS CHECKSTYLE NEXT MagicNumber
                    int size = 10;
                    if (getAlignment() == SOURCE) {
                        arrow.setReferencePoint(SplineUtilities.sourceReferencePoint(points, size));
                    } else if (getAlignment() == TARGET) {
                        arrow.setReferencePoint(SplineUtilities.targetReferencePoint(points, size));
                    }
                } else if (spline.getSplineMode() == SplineConnection.SPLINE_CUBIC_APPROX) {
                    points = SplineUtilities.approximateSpline(points);
                    if (getAlignment() == SOURCE) {
                        arrow.setReferencePoint(points.getPoint(1));
                    } else if (getAlignment() == TARGET) {
                        arrow.setReferencePoint(points.getPoint(points.size() - 2));
                    }
                } else {
                    if (getAlignment() == SOURCE) {
                        arrow.setReferencePoint(points.getPoint(1));
                    } else if (getAlignment() == TARGET) {
                        arrow.setReferencePoint(points.getPoint(points.size() - 2));
                    }
                }
            } else {
                if (getAlignment() == SOURCE) {
                    arrow.setReferencePoint(points.getPoint(1));
                } else if (getAlignment() == TARGET) {
                    arrow.setReferencePoint(points.getPoint(points.size() - 2));
                }
            }
        }
    }
}
