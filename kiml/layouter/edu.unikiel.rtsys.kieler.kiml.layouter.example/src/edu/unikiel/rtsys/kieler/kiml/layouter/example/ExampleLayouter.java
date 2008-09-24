package edu.unikiel.rtsys.kieler.kiml.layouter.example;

import org.eclipse.jface.preference.IPreferenceStore;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutGraph.KNodeGroup;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutUtil;
import edu.unikiel.rtsys.kieler.kiml.layouter.example.preferences.PreferenceConstants;

public class ExampleLayouter {

	private int PAD_X = 25;
	private int PAD_Y = 25;
	private boolean HORIZONTAL = true;

	public ExampleLayouter() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		PAD_X = store
				.getInt(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_X);
		PAD_Y = store
				.getInt(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_PADDING_Y);
		HORIZONTAL = store
				.getBoolean(PreferenceConstants.PREF_LAYOUTER_EXAMPLE_HORIZONTAL);
	}

	public void visit(KNodeGroup nodeGroup) {

		if (nodeGroup == null)
			return;

		KNodeGroup previousGroup = KimlLayoutUtil.createInitializedNodeGroup();

		/*
		 * Layout horizontal
		 */
		if (HORIZONTAL) {
			float maxHeight = 0f;
			for (KNodeGroup child : nodeGroup.getSubNodeGroups()) {
				child.getLayout().getLocation().setX(
						previousGroup.getLayout().getLocation().getX()
								+ previousGroup.getLayout().getSize()
										.getWidth() + PAD_X);
				child.getLayout().getLocation().setY(PAD_Y);

				if (maxHeight < child.getLayout().getSize().getHeight())
					maxHeight = child.getLayout().getSize().getHeight();
				previousGroup = child;

			}
			nodeGroup.getLayout().getSize().setWidth(
					previousGroup.getLayout().getSize().getWidth()
							+ previousGroup.getLayout().getLocation().getX()
							+ PAD_X
							+ nodeGroup.getLayout().getInsets().getLeft()
							+ nodeGroup.getLayout().getInsets().getRight());
			nodeGroup.getLayout().getSize().setHeight(
					maxHeight + 2 * PAD_Y
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
										.getHeight() + PAD_Y);
				child.getLayout().getLocation().setX(PAD_X);

				if (maxWidth < child.getLayout().getSize().getWidth())
					maxWidth = child.getLayout().getSize().getWidth();
				previousGroup = child;

			}

			nodeGroup.getLayout().getSize().setHeight(
					previousGroup.getLayout().getSize().getHeight()
							+ previousGroup.getLayout().getLocation().getY()
							+ PAD_Y
							+ nodeGroup.getLayout().getInsets().getBottom()
							+ nodeGroup.getLayout().getInsets().getTop());

			nodeGroup.getLayout().getSize().setWidth(
					maxWidth + 2 * PAD_X
							+ nodeGroup.getLayout().getInsets().getLeft()
							+ nodeGroup.getLayout().getInsets().getRight());
		}
	}

}
