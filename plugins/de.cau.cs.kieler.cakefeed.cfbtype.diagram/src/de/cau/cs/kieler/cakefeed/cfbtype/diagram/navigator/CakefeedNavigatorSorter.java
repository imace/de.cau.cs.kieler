package de.cau.cs.kieler.cakefeed.cfbtype.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import de.cau.cs.kieler.cakefeed.cfbtype.diagram.part.CakefeedVisualIDRegistry;

/**
 * @generated
 */
public class CakefeedNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7007;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof CakefeedNavigatorItem) {
			CakefeedNavigatorItem item = (CakefeedNavigatorItem) element;
			return CakefeedVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
