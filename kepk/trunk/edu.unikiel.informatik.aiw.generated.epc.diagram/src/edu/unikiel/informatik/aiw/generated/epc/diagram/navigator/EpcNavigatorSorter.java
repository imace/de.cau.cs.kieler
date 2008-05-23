package edu.unikiel.informatik.aiw.generated.epc.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import edu.unikiel.informatik.aiw.generated.epc.diagram.part.EpcVisualIDRegistry;

/**
 * @generated
 */
public class EpcNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 3010;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EpcNavigatorItem) {
			EpcNavigatorItem item = (EpcNavigatorItem) element;
			return EpcVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
