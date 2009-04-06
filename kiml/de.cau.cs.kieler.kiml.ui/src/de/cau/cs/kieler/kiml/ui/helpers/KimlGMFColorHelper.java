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

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.themes.ColorUtil;


/**
 * Helper class which colorize EditParts. Must be instantiated to be able to
 * highlight EditParts and switch the highlighting off afterwards.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * @see KLayoutGraph
 */
public class KimlGMFColorHelper {

	/* defaults (highlight) */
	private final Color DEFAULT_HIGHLIGHT_BG_COLOR = ColorConstants.red;
	private final Color DEFAULT_HIGHLIGHT_FG_COLOR = ColorConstants.red;

	/* the highlight colors for this instance of this helper class */
	private Color highlightBackgroundColor;
	private Color highlightForegroundColor;

	/* save the original color of the EditParts to highlight */
	private HashMap<GraphicalEditPart, Color> savedForegroundColors;
	private HashMap<GraphicalEditPart, Color> savedBackgroundColors;

	/**
	 * Constructor is needed, as state information has to be maintained. For
	 * example, if selecting EditParts and highlighting them, the original color
	 * has to be saved to switch the highlighting of.
	 */
	public KimlGMFColorHelper() {
		savedForegroundColors = new HashMap<GraphicalEditPart, Color>();
		savedBackgroundColors = new HashMap<GraphicalEditPart, Color>();
		highlightForegroundColor = DEFAULT_HIGHLIGHT_FG_COLOR;
		highlightBackgroundColor = DEFAULT_HIGHLIGHT_BG_COLOR;
	}

	/**
	 * Sets the highlight color for the foreground.
	 * 
	 * @param fgColor
	 *            Highlight color for the foreground
	 */
	public void setHighlightForegroundColor(Color fgColor) {
		this.highlightForegroundColor = fgColor;
	}

	/**
	 * Sets the highlight color for the background.
	 * 
	 * @param bgColor
	 *            Highlight color for the background
	 */
	public void setHighlightBackgroundColor(Color bgColor) {
		this.highlightBackgroundColor = bgColor;
	}

	/**
	 * Highlights all the foregrounds of the Figures of the provided EditParts
	 * in the current foreground color. Saves the actual color to be able to
	 * switch off highlighting.
	 * 
	 * @param editParts
	 *            The EditParts whose foreground should be highlighted
	 */
	public void highlightForegrounds(ArrayList<GraphicalEditPart> editParts) {
		for (GraphicalEditPart editPart : editParts)
			highlightForeground(editPart);
	}

	/**
	 * Highlights all the backgrounds of the Figures of the provided EditParts
	 * in the current backgrounds color. Saves the actual color to be able to
	 * switch off highlighting.
	 * 
	 * @param editParts
	 *            The EditParts whose backgrounds should be highlighted
	 */
	public void highlightBackgrounds(ArrayList<GraphicalEditPart> editParts) {
		for (GraphicalEditPart editPart : editParts)
			highlightBackground(editPart);
	}

	/**
	 * Highlights the foreground of the Figure of the provided EditPart in the
	 * current foreground color. Saves the actual color to be able to switch off
	 * highlighting.
	 * 
	 * @param editPart
	 *            The EditPart whose foreground should be highlighted
	 */
	public void highlightForeground(GraphicalEditPart editPart) {
		saveForegroundColor(editPart);
		editPart.getContentPane().setForegroundColor(
				this.highlightForegroundColor);
	}

	/**
	 * Highlights the background of the Figure of the provided EditPart in the
	 * current backgrounds color. Saves the actual color to be able to switch
	 * off highlighting.
	 * 
	 * @param editPart
	 *            The EditPart whose backgrounds should be highlighted
	 */
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

	/**
	 * Saves the foreground color of the provided EditPart in this instance of
	 * the helper class.
	 */
	public void saveForegroundColor(GraphicalEditPart editPart) {
		savedForegroundColors.put(editPart, editPart.getContentPane()
				.getForegroundColor());
	}

	/**
	 * Restores the foreground color of the provided EditPart from the
	 * information saved in this instance of the helper class.
	 */
	public void restoreForeground(GraphicalEditPart editPart) {
		editPart.getContentPane().setForegroundColor(
				savedForegroundColors.get(editPart));
	}

	/**
	 * Restores all foreground colors of EditParts from the information saved in
	 * this instance of the helper class.
	 */
	public void restoreAllForegrounds() {
		for (GraphicalEditPart editPart : savedForegroundColors.keySet()) {
			restoreForeground(editPart);
		}
	}

	/**
	 * Saves the background color of the provided EditPart in this instance of
	 * the helper class.
	 */
	public void saveBackgroundColor(GraphicalEditPart editPart) {
		savedBackgroundColors.put(editPart, editPart.getContentPane()
				.getBackgroundColor());
	}

	/**
	 * Restores the background color of the provided EditPart from the
	 * information saved in this instance of the helper class.
	 */
	public void restoreBackground(GraphicalEditPart editPart) {
		editPart.getContentPane().setBackgroundColor(
				savedBackgroundColors.get(editPart));
	}

	/**
	 * Restores all background colors of EditParts from the information saved in
	 * this instance of the helper class.
	 */
	public void restoreAllBackgrounds() {
		for (GraphicalEditPart editPart : savedBackgroundColors.keySet()) {
			restoreBackground(editPart);
		}
	}

	/**
	 * Clears all the mappings keeping track of EditParts and colors.
	 */
	public void clear() {
		savedForegroundColors.clear();
		savedBackgroundColors.clear();
	}

	/**
	 * Clears the foreground mappings keeping track of EditParts and colors.
	 */
	public void clearForeground() {
		savedForegroundColors.clear();
	}

	/**
	 * Clears the background mappings keeping track of EditParts and colors.
	 */
	public void clearBackground() {
		savedBackgroundColors.clear();
	}

	/**
	 * Returns a color for each layout group. Color is derived from the layout
	 * group String of the ShapeNodeEditPart
	 * 
	 * @param shapeNodeEditPart
	 *            The ShapeNodeEditPart to generate the group color for
	 * @return The Color, which is the same for each element belonging to the
	 *         same group
	 * 
	 */
	public static Color generateGroupColor(ShapeNodeEditPart shapeNodeEditPart) {

		/* TODO: Use better method to generate a wider range of nice colors. */
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
