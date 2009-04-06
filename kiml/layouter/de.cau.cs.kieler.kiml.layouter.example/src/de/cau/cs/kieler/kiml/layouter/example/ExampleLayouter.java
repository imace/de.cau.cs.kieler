/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package de.cau.cs.kieler.kiml.layouter.example;

import org.eclipse.jface.preference.IPreferenceStore;

import de.cau.cs.kieler.core.kgraph.KNode;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KInsets;
import de.cau.cs.kieler.kiml.layout.klayoutdata.KShapeLayout;
import de.cau.cs.kieler.kiml.layout.options.LayoutOptions;
import de.cau.cs.kieler.kiml.layout.util.KimlLayoutUtil;
import de.cau.cs.kieler.kiml.layouter.example.preferences.PreferenceConstants;


/**
 * Simple Example layout algorithm.
 * <p/>
 * Supported features are node sizes and positions. The nodes are laid out in a
 * line with predefined spaces between them. Nothing is done to edges and their
 * labels.
 * <p/>
 * This layouter is not of great use. It was mainly written to demonstrate how
 * fast a new layout provider can be inserted into the KIML infrastructure and
 * to act as an, oh wonder, example for other developers intending to write
 * their own layouter.
 * 
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 * 
 */
public class ExampleLayouter {

	/* preference options */
	private int prefPadX = 25;
	private int prefPadY = 25;
	private boolean prefHorizontal = true;

	/**
	 * Creates a new KIML Example layouter. Loads the preference values.
	 */
	public ExampleLayouter() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		prefPadX = store
				.getInt(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_X);
		prefPadY = store
				.getInt(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_Y);
		prefHorizontal = store
				.getBoolean(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_HORIZONTAL);
	}

	/**
	 * Performs the actual work of the layout process. Works directly on the
	 * KLayoutNode and sub KLayoutNodes and annotates them with the new position
	 * and size information.
	 * <p/>
	 * The nodes are laid out in a line with predefined spaces between them.
	 * 
	 * @param layoutNode
	 *            The node to process
	 */
	public void visit(KNode layoutNode) {

		/* return if nothing to do */
		if (layoutNode == null)
			return;

        KShapeLayout parentLayout = KimlLayoutUtil.getShapeLayout(layoutNode);
		KInsets insets = LayoutOptions.getInsets(parentLayout);
		float currentPos = 0.0f;

		// layout horizontal
		if (prefHorizontal) {
			float maxHeight = 0f;
			for (KNode child : layoutNode.getChildren()) {
			    KShapeLayout childLayout = KimlLayoutUtil.getShapeLayout(child);
			    childLayout.setXpos(currentPos + prefPadX);
			    childLayout.setYpos(prefPadY);

				if (maxHeight < childLayout.getHeight())
					maxHeight = childLayout.getHeight();
				currentPos = childLayout.getXpos() + childLayout.getWidth();
			}
			parentLayout.setWidth(currentPos + prefPadX
			        + insets.getLeft() + insets.getRight());
			parentLayout.setHeight(maxHeight + 2 * prefPadY
					+ insets.getTop() + insets.getBottom());
		}

		// layout vertical
		else {
			float maxWidth = 0f;
			for (KNode child : layoutNode.getChildren()) {
			    KShapeLayout childLayout = KimlLayoutUtil.getShapeLayout(child);
			    childLayout.setYpos(currentPos + prefPadY);
			    childLayout.setXpos(prefPadX);

				if (maxWidth < childLayout.getWidth())
					maxWidth = childLayout.getWidth();
				currentPos = childLayout.getYpos() + childLayout.getHeight();
			}

			parentLayout.setHeight(currentPos + prefPadY
							+ insets.getTop() + insets.getBottom());

			parentLayout.setWidth(maxWidth + 2 * prefPadX
							+ insets.getLeft() + insets.getRight());
		}
	}

}
