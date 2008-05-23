package edu.unikiel.informatik.aiw.generated.gctl.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import edu.unikiel.informatik.aiw.generated.gctl.diagram.part.EpcVisualIDRegistry;

/**
 * @generated
 */
public class EpcNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 3003;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 3002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EpcNavigatorItem) {
			EpcNavigatorItem item = (EpcNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return EpcVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
