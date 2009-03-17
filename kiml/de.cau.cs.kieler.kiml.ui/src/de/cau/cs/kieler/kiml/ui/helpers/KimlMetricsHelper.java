/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2008 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */
package de.cau.cs.kieler.kiml.ui.helpers;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;

/**
 * Static helper class which provides functions to translate Draw2D metrics to
 * KLayoutGraph metrics and back.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KLayoutGraph
 */
public class KimlMetricsHelper {

	/**
	 * Translates the given KPoint into a Draw2D Point.
	 * 
	 * @param kPoint
	 *            KPoint to translate
	 * @return new Point with the same coordinates
	 */
	public static Point kPoint2Point(KPoint kPoint) {
		return new Point((int) kPoint.getX(), (int) kPoint.getY());
	}

	/**
	 * Translates the given Draw2D Point into a KPoint.
	 * 
	 * @param point
	 *            Draw2D Point to translate
	 * @return new KPoint with the same coordinates
	 */
	public static KPoint point2KPoint(Point point) {
		KPoint kPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		kPoint.setX(point.x);
		kPoint.setY(point.y);
		return kPoint;
	}

	/**
	 * Translates a KDimension into a Draw2D Dimension.
	 * 
	 * @param kDimension
	 *            The KDimension to translate
	 * @return new Draw2D Dimension with the same size
	 */
	public static Dimension kDimension2Dimension(KDimension kDimension) {
		return new Dimension((int) kDimension.getWidth(), (int) kDimension
				.getHeight());
	}

	/**
	 * Translates a Draw2D Dimension into a KDimension.
	 * 
	 * @param dimension
	 *            The Draw2D Dimension to translate
	 * @return new KDimension with the same size
	 */
	public static KDimension dimension2KDimension(Dimension dimension) {
		KDimension kDimension = KimlLayoutGraphFactory.eINSTANCE
				.createKDimension();
		kDimension.setWidth(dimension.width);
		kDimension.setHeight(dimension.height);
		return kDimension;
	}

	/**
	 * Translates KInsets to Draw2D Insets.
	 * 
	 * @param kInsets
	 *            The KInsets to translate
	 * @return new Draw2D Insets
	 */
	public static Insets kInsets2Insets(KInsets kInsets) {
		return new Insets((int) kInsets.getTop(), (int) kInsets.getLeft(),
				(int) kInsets.getBottom(), (int) kInsets.getRight());
	}

	/**
	 * Translates Draw2D Insets to KInsets.
	 * 
	 * @param insets
	 *            The Draw2D Insets to translate
	 * @return new KInsets
	 */
	public static KInsets insets2KInsets(Insets insets) {
		KInsets kInsets = KimlLayoutGraphFactory.eINSTANCE.createKInsets();
		kInsets.setTop(insets.top);
		kInsets.setLeft(insets.left);
		kInsets.setBottom(insets.bottom);
		kInsets.setRight(insets.right);
		return kInsets;
	}
}
