package edu.unikiel.rtsys.kieler.kiml.ui.custom;

// TODO: doc
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.themes.ColorUtil;

import edu.unikiel.rtsys.kieler.kiml.ui.KimlLayoutHintConstants;

public class KimlColorHelper {
	private final Color DEFAULT_HIGHLIGHT_BG_COLOR = ColorConstants.red;
	private final Color DEFAULT_HIGHLIGHT_FG_COLOR = ColorConstants.red;

	private Color highlightBackgroundColor;
	private Color highlightForegroundColor;
	private HashMap<AbstractGraphicalEditPart, Color> savedForegroundColors;
	private HashMap<AbstractGraphicalEditPart, Color> savedBackgroundColors;

	public KimlColorHelper() {
		savedForegroundColors = new HashMap<AbstractGraphicalEditPart, Color>();
		savedBackgroundColors = new HashMap<AbstractGraphicalEditPart, Color>();
		highlightForegroundColor = DEFAULT_HIGHLIGHT_FG_COLOR;
		highlightBackgroundColor = DEFAULT_HIGHLIGHT_BG_COLOR;
	}

	public void setHighlightForegroundColor(Color fgColor) {
		this.highlightForegroundColor = fgColor;
	}

	public void setHighlightBackgroundColor(Color bgColor) {
		this.highlightBackgroundColor = bgColor;
	}

	public void highlightForegrounds(ArrayList<ShapeNodeEditPart> editParts) {
		for (AbstractGraphicalEditPart editPart : editParts)
			highlightForeground(editPart);
	}

	public void highlightBackgrounds(ArrayList<ShapeNodeEditPart> editParts) {
		for (AbstractGraphicalEditPart editPart : editParts)
			highlightBackground(editPart);
	}

	public void highlightForeground(AbstractGraphicalEditPart editPart) {
		saveForegroundColor(editPart);
		editPart.getContentPane().setForegroundColor(
				this.highlightForegroundColor);
	}

	public void highlightBackground(AbstractGraphicalEditPart editPart) {
		saveBackgroundColor(editPart);
		if (editPart instanceof ShapeNodeEditPart) {
			editPart.getContentPane().setBackgroundColor(
					generateGroupColor((ShapeNodeEditPart) editPart));
		} else {
			editPart.getContentPane().setBackgroundColor(
					this.highlightBackgroundColor);
		}

	}

	public void saveForegroundColor(AbstractGraphicalEditPart editPart) {
		savedForegroundColors.put(editPart, editPart.getContentPane()
				.getForegroundColor());
	}

	public void restoreForeground(AbstractGraphicalEditPart editPart) {
		editPart.getContentPane().setForegroundColor(
				savedForegroundColors.get(editPart));
	}

	public void restoreAllForegrounds() {
		for (AbstractGraphicalEditPart editPart : savedForegroundColors
				.keySet()) {
			restoreForeground(editPart);
		}
	}

	public void saveBackgroundColor(AbstractGraphicalEditPart editPart) {
		savedBackgroundColors.put(editPart, editPart.getContentPane()
				.getBackgroundColor());
	}

	public void restoreBackground(AbstractGraphicalEditPart editPart) {
		editPart.getContentPane().setBackgroundColor(
				savedBackgroundColors.get(editPart));
	}

	public void restoreAllBackgrounds() {
		for (AbstractGraphicalEditPart editPart : savedBackgroundColors
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
		String layoutGroup = KimlLayoutHintHelper
				.getLayoutGroup(shapeNodeEditPart);
		if (layoutGroup.equals(KimlLayoutHintConstants.NOT_GROUPED)) {
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
