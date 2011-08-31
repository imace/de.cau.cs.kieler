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
package de.cau.cs.kieler.klighd.piccolo.graph.layout;

import edu.umd.cs.piccolo.PCamera;
import edu.umd.cs.piccolo.activities.PInterpolatingActivity;

/**
 * The Piccolo activity to zoom a diagram.
 * 
 * @author mri
 */
public class ZoomActivity extends PInterpolatingActivity {

    /** the default duration for the activity. */
    private static final long DEFAULT_DURATION = 1000;

    /**
     * Constructs a zoom activity on a given camera. The activity performs a zoom-to-fit for the
     * camera.
     * 
     * @param camera
     *            the camera
     */
    public ZoomActivity(final PCamera camera) {
        super(DEFAULT_DURATION);
    }

    /**
     * Constructs a zoom activity on a given camera with a specified duration. The activity performs
     * a zoom-to-fit for the camera.
     * 
     * @param camera
     *            the camera
     * @param duration
     *            the duration over which the activity performs the zoom-to-fit
     */
    public ZoomActivity(final PCamera camera, final long duration) {
        super(duration);
    }

    /**
     * Constructs a zoom activity on a given camera. The activity performs a zoom to the given
     * scale.
     * 
     * @param camera
     *            the camera
     * @param scale
     *            the scale to zoom to
     */
    public ZoomActivity(final PCamera camera, final double scale) {
        super(DEFAULT_DURATION);
    }

    /**
     * Constructs a zoom activity on a given camera with a specified duration. The activity performs
     * a zoom to the given scale.
     * 
     * @param camera
     *            the camera
     * @param duration
     *            the duration over which the activity performs the zoom-to-fit
     * @param scale
     *            the scale to zoom to
     */
    public ZoomActivity(final PCamera camera, final double scale, final long duration) {
        super(duration);
    }

}