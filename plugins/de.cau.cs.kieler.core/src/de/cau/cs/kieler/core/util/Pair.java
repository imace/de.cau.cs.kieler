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
package de.cau.cs.kieler.core.util;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A simple pair implementation.
 * 
 * @param <F> type of first contained object
 * @param <S> type of second contained object
 * @author <a href="mailto:msp@informatik.uni-kiel.de">Miro Sp&ouml;nemann</a>
 */
public class Pair<F, S> {

    /** the first element. */
    public F first;
    /** the second element. */
    public S second;

    /**
     * Constructs a pair given both elements.
     * 
     * @param thefirst the first element
     * @param thesecond the second element
     */
    public Pair(final F thefirst, final S thesecond) {
        this.first = thefirst;
        this.second = thesecond;
    }

    /**
     * Comparator that uses the first element as base.
     */
    public static class FirstComparator<F extends Comparable<F>, S> implements Comparator<Pair<F, S>>,
            Serializable {
        private static final long serialVersionUID = 1;

        /**
         * {@inheritDoc}
         */
        public int compare(final Pair<F, S> o1, final Pair<F, S> o2) {
            return o1.first.compareTo(o2.first);
        }
    }

    /**
     * Comparator that uses the second element as base.
     */
    public static class SecondComparator<F, S extends Comparable<S>> implements Comparator<Pair<F, S>>,
            Serializable {
        private static final long serialVersionUID = 1;

        /**
         * {@inheritDoc}
         */
        public int compare(final Pair<F, S> o1, final Pair<F, S> o2) {
            return o1.second.compareTo(o2.second);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Pair<?, ?>) {
            Pair<?, ?> other = (Pair<?, ?>) obj;
            return this.first == null ? other.first == null
                    && (this.second == null ? other.second == null : this.second.equals(other.second))
                    : this.first.equals(other.first)
                            && (this.second == null ? other.second == null : this.second
                                    .equals(other.second));
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        if (first == null && second == null) {
            return 0;
        } else if (first == null) {
            return second.hashCode();
        } else if (second == null) {
            return first.hashCode();
        } else {
            return first.hashCode() + second.hashCode();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (first == null && second == null) {
            return "pair(null,null)";
        } else if (first == null) {
            return "pair(null," + second.toString() + ")";
        } else if (second == null) {
            return "pair(" + first.toString() + ",null)";
        } else {
            return "pair(" + first.toString() + "," + second.toString() + ")";
        }
    }

}
