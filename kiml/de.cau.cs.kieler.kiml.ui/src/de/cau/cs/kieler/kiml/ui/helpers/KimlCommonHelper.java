/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.ui.helpers;

import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;

import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KInsets;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KLayoutGraph;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import de.cau.cs.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;


/**
 * Static helper class which fetches labels of EditParts of a GMF model through
 * special adapters, which need to be implemented in the GMF project. Provides
 * also functions to translate Draw2D metrics to KLayoutGraph metrics and back.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KLayoutGraph
 */
public class KimlCommonHelper {

	/**
	 * Fetches a <i>shorter</i> label for the provided GraphicalEditPart. Looks
	 * up if the GMF model this EditParts belongs to has an adapter to provide
	 * the label.
	 * 
	 * @param graphicalEditPart
	 *            The GraphicalEditPart to fetch the <i>shorter</i> label for.
	 * @return The <i>shorter</i> label.
	 */
	public static String getShortLabel(GraphicalEditPart graphicalEditPart) {

		if (graphicalEditPart instanceof NodeEditPart) {

			Map<String, String> labelMap = (Map<String, String>) ((NodeEditPart) graphicalEditPart)
					.getAdapter(Map.class);
			if (labelMap != null && labelMap.get("SHORT_LABEL") != null) {
				return labelMap.get("SHORT_LABEL");
			} else
				return "";
		}
		return "";
	}

	/**
	 * Fetches a <i>longer</i> label for the provided GraphicalEditPart. Looks
	 * up if the GMF model this EditParts belongs to has an adapter to provide
	 * the label.
	 * 
	 * @param graphicalEditPart
	 *            The GraphicalEditPart to fetch the <i>longer</i> label for.
	 * @return The <i>longer</i> label.
	 */
	public static String getLongLabel(GraphicalEditPart nodeEditPart) {

		if (nodeEditPart instanceof NodeEditPart) {

			Map<String, String> labelMap = (Map<String, String>) ((NodeEditPart) nodeEditPart)
					.getAdapter(Map.class);
			if (labelMap != null && labelMap.get("LONG_LABEL") != null) {
				return labelMap.get("LONG_LABEL");
			} else
				return "";
		}
		return "";
	}

	/**
	 * Fetches a the middle label for the provided ConnectionEditPart. Looks up
	 * if the GMF model this EditParts belongs to has an adapter to provide the
	 * label.
	 * 
	 * @param connectionEditPart
	 *            The ConnectionEditPart to fetch the middle label for.
	 * @return The middle label.
	 */
	public static String getMidLabel(GraphicalEditPart connectionEditPart) {

		if (connectionEditPart instanceof ConnectionEditPart) {

			Map<String, String> labelMap = (Map<String, String>) ((ConnectionEditPart) connectionEditPart)
					.getAdapter(Map.class);
			if (labelMap != null && labelMap.get("MID_LABEL") != null) {
				return labelMap.get("MID_LABEL");
			} else
				return "";
		}
		return "";
	}

	/**
	 * Fetches a the tail label for the provided ConnectionEditPart. Looks up if
	 * the GMF model this EditParts belongs to has an adapter to provide the
	 * label.
	 * 
	 * @param connectionEditPart
	 *            The ConnectionEditPart to fetch the tail label for.
	 * @return The tail label.
	 */
	public static String getTailLabel(GraphicalEditPart connectionEditPart) {

		if (connectionEditPart instanceof ConnectionEditPart) {

			Map<String, String> labelMap = (Map<String, String>) ((ConnectionEditPart) connectionEditPart)
					.getAdapter(Map.class);
			if (labelMap != null && labelMap.get("TAIL_LABEL") != null) {
				return labelMap.get("TAIL_LABEL");
			} else
				return "";
		}
		return "";
	}

	/**
	 * Fetches a the head label for the provided ConnectionEditPart. Looks up if
	 * the GMF model this EditParts belongs to has an adapter to provide the
	 * label.
	 * 
	 * @param connectionEditPart
	 *            The ConnectionEditPart to fetch the head label for.
	 * @return The head label.
	 */
	public static String getHeadLabel(GraphicalEditPart connectionEditPart) {

		if (connectionEditPart instanceof ConnectionEditPart) {

			Map<String, String> labelMap = (Map<String, String>) ((ConnectionEditPart) connectionEditPart)
					.getAdapter(Map.class);
			if (labelMap != null && labelMap.get("HEAD_LABEL") != null) {
				return labelMap.get("HEAD_LABEL");
			} else
				return "";
		}
		return "";
	}

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
