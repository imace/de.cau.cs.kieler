package edu.unikiel.rtsys.kieler.kiml.ui.helpers;

import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KDimension;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KPoint;
import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KimlLayoutGraphFactory;

public class KimlCommonHelper {

	public static String getShortLabel(GraphicalEditPart nodeEditPart) {

		if (nodeEditPart instanceof NodeEditPart) {

			Map<String, String> labelMap = (Map<String, String>) ((NodeEditPart) nodeEditPart)
					.getAdapter(Map.class);
			if (labelMap != null && labelMap.get("SHORT_LABEL") != null) {
				return labelMap.get("SHORT_LABEL");
			} else
				return "";
		}
		return "";
	}

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

	public static Point kPoint2Point(KPoint kPoint) {
		return new Point((int) kPoint.getX(), (int) kPoint.getY());
	}

	public static KPoint point2KPoint(Point point) {
		KPoint kPoint = KimlLayoutGraphFactory.eINSTANCE.createKPoint();
		kPoint.setX(point.x);
		kPoint.setY(point.y);
		return kPoint;
	}

	public static Dimension kDimension2Dimension(KDimension kDimension) {
		return new Dimension((int) kDimension.getWidth(), (int) kDimension
				.getHeight());
	}

	public static KDimension dimension2KDimension(Dimension dimension) {
		KDimension kDimension = KimlLayoutGraphFactory.eINSTANCE
				.createKDimension();
		kDimension.setWidth(dimension.width);
		kDimension.setHeight(dimension.height);
		return kDimension;
	}

}
