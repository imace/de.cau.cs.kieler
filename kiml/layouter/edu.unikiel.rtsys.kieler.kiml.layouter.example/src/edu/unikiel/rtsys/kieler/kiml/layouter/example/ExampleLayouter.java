/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.layouter.example;

import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutUtil;
import edu.unikiel.rtsys.kieler.kiml.layouter.example.preferences.PreferenceConstants;

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
	 * KNodeGroup and sub KNodeGroups and annotates them with the new position
	 * and size information.
	 * <p/>
	 * The nodes are laid out in a line with predefined spaces between them.
	 * 
	 * @param nodeGroup
	 *            The KNodeGroup to process
	 */
	public void visit(KNodeGroup nodeGroup) {

		/* return if nothing to do */
		if (nodeGroup == null)
			return;

		KNodeGroup previousGroup = KimlLayoutUtil.createInitializedNodeGroup();

		/*
		 * Layout horizontal
		 */
		if (prefHorizontal) {
			float maxHeight = 0f;
			for (KNodeGroup child : nodeGroup.getSubNodeGroups()) {
				child.getLayout().getLocation().setX(
						previousGroup.getLayout().getLocation().getX()
								+ previousGroup.getLayout().getSize()
										.getWidth() + prefPadX);
				child.getLayout().getLocation().setY(prefPadY);

				if (maxHeight < child.getLayout().getSize().getHeight())
					maxHeight = child.getLayout().getSize().getHeight();
				previousGroup = child;

			}
			nodeGroup.getLayout().getSize().setWidth(
					previousGroup.getLayout().getSize().getWidth()
							+ previousGroup.getLayout().getLocation().getX()
							+ prefPadX
							+ nodeGroup.getLayout().getInsets().getLeft()
							+ nodeGroup.getLayout().getInsets().getRight());
			nodeGroup.getLayout().getSize().setHeight(
					maxHeight + 2 * prefPadY
							+ nodeGroup.getLayout().getInsets().getBottom()
							+ nodeGroup.getLayout().getInsets().getTop());
		}

		/*
		 * Layout vertical
		 */
		else {
			float maxWidth = 0f;
			for (KNodeGroup child : nodeGroup.getSubNodeGroups()) {
				child.getLayout().getLocation().setY(
						previousGroup.getLayout().getLocation().getY()
								+ previousGroup.getLayout().getSize()
										.getHeight() + prefPadY);
				child.getLayout().getLocation().setX(prefPadX);

				if (maxWidth < child.getLayout().getSize().getWidth())
					maxWidth = child.getLayout().getSize().getWidth();
				previousGroup = child;

			}

			nodeGroup.getLayout().getSize().setHeight(
					previousGroup.getLayout().getSize().getHeight()
							+ previousGroup.getLayout().getLocation().getY()
							+ prefPadY
							+ nodeGroup.getLayout().getInsets().getBottom()
							+ nodeGroup.getLayout().getInsets().getTop());

			nodeGroup.getLayout().getSize().setWidth(
					maxWidth + 2 * prefPadX
							+ nodeGroup.getLayout().getInsets().getLeft()
							+ nodeGroup.getLayout().getInsets().getRight());
		}
	}

}
