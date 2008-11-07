package edu.unikiel.rtsys.kieler.kiml.ui.helpers;

// TODO: doc
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.themes.ColorUtil;



public class KimlGMFColorHelper {
	private final Color DEFAULT_HIGHLIGHT_BG_COLOR = ColorConstants.red;
	private final Color DEFAULT_HIGHLIGHT_FG_COLOR = ColorConstants.red;

	private Color highlightBackgroundColor;
	private Color highlightForegroundColor;
	private HashMap<GraphicalEditPart, Color> savedForegroundColors;
	private HashMap<GraphicalEditPart, Color> savedBackgroundColors;

	public KimlGMFColorHelper() {
		savedForegroundColors = new HashMap<GraphicalEditPart, Color>();
		savedBackgroundColors = new HashMap<GraphicalEditPart, Color>();
		highlightForegroundColor = DEFAULT_HIGHLIGHT_FG_COLOR;
		highlightBackgroundColor = DEFAULT_HIGHLIGHT_BG_COLOR;
	}

	public void setHighlightForegroundColor(Color fgColor) {
		this.highlightForegroundColor = fgColor;
	}

	public void setHighlightBackgroundColor(Color bgColor) {
		this.highlightBackgroundColor = bgColor;
	}

	public void highlightForegrounds(ArrayList<GraphicalEditPart> editParts) {
		for (GraphicalEditPart editPart : editParts)
			highlightForeground(editPart);
	}

	public void highlightBackgrounds(ArrayList<GraphicalEditPart> editParts) {
		for (GraphicalEditPart editPart : editParts)
			highlightBackground(editPart);
	}

	public void highlightForeground(GraphicalEditPart editPart) {
		saveForegroundColor(editPart);
		editPart.getContentPane().setForegroundColor(
				this.highlightForegroundColor);
	}

	public void highlightBackground(GraphicalEditPart editPart) {
		saveBackgroundColor(editPart);
		if (editPart instanceof ShapeNodeEditPart) {
			editPart.getContentPane().setBackgroundColor(
					generateGroupColor((ShapeNodeEditPart) editPart));
		} else {
			editPart.getContentPane().setBackgroundColor(
					this.highlightBackgroundColor);
		}

	}

	public void saveForegroundColor(GraphicalEditPart editPart) {
		savedForegroundColors.put(editPart, editPart.getContentPane()
				.getForegroundColor());
	}

	public void restoreForeground(GraphicalEditPart editPart) {
		editPart.getContentPane().setForegroundColor(
				savedForegroundColors.get(editPart));
	}

	public void restoreAllForegrounds() {
		for (GraphicalEditPart editPart : savedForegroundColors
				.keySet()) {
			restoreForeground(editPart);
		}
	}

	public void saveBackgroundColor(GraphicalEditPart editPart) {
		savedBackgroundColors.put(editPart, editPart.getContentPane()
				.getBackgroundColor());
	}

	public void restoreBackground(GraphicalEditPart editPart) {
		editPart.getContentPane().setBackgroundColor(
				savedBackgroundColors.get(editPart));
	}

	public void restoreAllBackgrounds() {
		for (GraphicalEditPart editPart : savedBackgroundColors
				.keySet()) {
			restoreBackground(editPart);
		}
	}

	public void clear() {
		savedForegroundColors.clear();
		savedBackgroundColors.clear();
	}

	public void clearForeground() {
		savedForegroundColors.clear();
	}

	public void clearBackground() {
		savedBackgroundColors.clear();
	}

	/**
	 * TODO: Use better method to generate a wider range of nice colors.
	 * 
	 * Returns a color for each layout group. Color is derived from the layout
	 * group String of the ShapeNodeEditPart
	 * 
	 * @param shapeNodeEditPart
	 *            The ShapeNodeEditPart to generate the group color for
	 * @return The Color, which is the same for each element belonging to the
	 *         same group
	 */
	public static Color generateGroupColor(ShapeNodeEditPart shapeNodeEditPart) {
		String layoutGroup = KimlGMFLayoutHintHelper
				.getLayoutGroup(shapeNodeEditPart);
		if (layoutGroup.equals(KimlGMFLayoutHintHelper.NOT_GROUPED)) {
			return null;
		} else {
			int r = (layoutGroup.hashCode() + 160) & 255;
			int g = (layoutGroup.hashCode() + 80) & 255;
			int b = layoutGroup.hashCode() & 255;
			return new Color(null, ColorUtil.blend(new RGB(r, g, b),
					ColorConstants.white.getRGB(), 80));
		}
	}
}
