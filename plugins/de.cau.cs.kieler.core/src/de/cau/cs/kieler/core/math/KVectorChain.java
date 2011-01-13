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
package de.cau.cs.kieler.core.math;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

import de.cau.cs.kieler.core.KielerException;
import de.cau.cs.kieler.core.util.IDataObject;

/**
 * A chain of vectors. Can be used to describe polylines or similar constructs.
 *
 * @kieler.rating 2011-01-13 proposed yellow msp
 * @author msp
 */
public class KVectorChain extends LinkedList<KVector> implements IDataObject {
    
    /** the serial version UID. */
    private static final long serialVersionUID = -7978287459602078559L;

    /**
     * Creates an empty vector chain.
     */
    public KVectorChain() {
        super();
    }
    
    /**
     * Creates a vector chain from a given collection of vectors.
     * 
     * @param collection a collection of vectors
     */
    public KVectorChain(final Collection<KVector> collection) {
        super(collection);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("(");
        Iterator<KVector> iter = iterator();
        while (iter.hasNext()) {
            KVector vector = iter.next();
            builder.append(vector.x + "," + vector.y);
            if (iter.hasNext()) {
                builder.append("; ");
            }
        }
        return builder.append(")").toString();
    }
    
    /**
     * {@inheritDoc}
     */
    public void parse(final String string) throws KielerException {
        StringTokenizer tokenizer = new StringTokenizer(string, ",;()[]{} \t\n");
        clear();
        try {
            while (tokenizer.countTokens() >= 2) {
                double x = Double.parseDouble(tokenizer.nextToken());
                double y = Double.parseDouble(tokenizer.nextToken());
                add(new KVector(x, y));
            }
        } catch (NumberFormatException exception) {
            throw new KielerException(
                    "The given string does not match the expected format for vectors." + exception);
        }
    }
    
    /**
     * Adds a (0,0) vector to the vector chain.
     */
    public void add() {
        add(new KVector());
    }
    
    /**
     * Adds the vector (x,y) to the vector chain.
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public void add(final double x, final double y) {
        add(new KVector(x, y));
    }
    
    /**
     * Adds a (0,0) vector to the beginning of the vector chain.
     */
    public void addFirst() {
        addFirst(new KVector());
    }
    
    /**
     * Adds the vector (x,y) to the beginning of the vector chain.
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public void addFirst(final double x, final double y) {
        addFirst(new KVector(x, y));
    }
    
    /**
     * Adds a (0,0) vector to the end of the vector chain.
     */
    public void addLast() {
        addLast(new KVector());
    }
    
    /**
     * Adds the vector (x,y) to the end of the vector chain.
     * 
     * @param x x coordinate
     * @param y y coordinate
     */
    public void addLast(final double x, final double y) {
        addLast(new KVector(x, y));
    }
    
    /**
     * Calculate the total length of this vector chain.
     * 
     * @return the total length
     */
    public double getLength() {
        double length = 0;
        if (size() >= 2) {
            Iterator<KVector> iter = iterator();
            KVector point1 = iter.next();
            do {
                KVector point2 = iter.next();
                length += KVector.distance(point1, point2);
                point1 = point2;
            } while (iter.hasNext());
        }
        return length;
    }
    
    /**
     * Calculate a point on this vector chain with given distance. The result is a point
     * whose distance from the first point on the chain equals the given distance.
     * If the parameter is negative, the result is mirrored, i.e. the distance is seen
     * from the last point on the chain.
     * 
     * @param dist the distance from the first point (if positive) or the last point
     *     (if negative)
     * @return a point on the vector chain
     */
    public KVector getPointOnLine(final double dist) {
        if (size() >= 2) {
            double absDistance = Math.abs(dist);
            double distanceSum = 0;
            if (dist >= 0) { 
                ListIterator<KVector> iter = listIterator();
                KVector currentPoint = iter.next();
                while (iter.hasNext()) {
                    double oldDistanceSum = distanceSum;
                    KVector nextPoint = iter.next();
                    double additionalDistanceToNext = KVector.distance(currentPoint, nextPoint);
                    if (additionalDistanceToNext > 0) {
                        distanceSum += additionalDistanceToNext;
                        if (distanceSum >= absDistance) {
                            double thisRelative = (absDistance - oldDistanceSum)
                                    / additionalDistanceToNext;
                            KVector result = nextPoint.differenceCreate(currentPoint);
                            result.scale(thisRelative);
                            result.add(currentPoint);
                            return result;
                        }
                    }
                    currentPoint = nextPoint;
                }
                return iter.previous();
            } else {
                ListIterator<KVector> iter = listIterator(size() - 1);
                KVector currentPoint = iter.previous();
                while (iter.hasPrevious()) {
                    double oldDistanceSum = distanceSum;
                    KVector nextPoint = iter.previous();
                    double additionalDistanceToNext = KVector.distance(currentPoint, nextPoint);
                    if (additionalDistanceToNext > 0) {
                        distanceSum += additionalDistanceToNext;
                        if (distanceSum >= absDistance) {
                            double thisRelative = (absDistance - oldDistanceSum)
                                    / additionalDistanceToNext;
                            KVector result = nextPoint.differenceCreate(currentPoint);
                            result.scale(thisRelative);
                            result.add(currentPoint);
                            return result;
                        }
                    }
                    currentPoint = nextPoint;
                }
                return iter.next();
            }
        } else if (size() == 1) {
            return get(0);
        } else {
            throw new IllegalStateException("Cannot determine a point on an empty vector chain.");
        }
    }

}
