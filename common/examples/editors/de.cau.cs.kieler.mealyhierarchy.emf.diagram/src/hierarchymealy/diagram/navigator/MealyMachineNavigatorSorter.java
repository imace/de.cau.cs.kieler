package hierarchymealy.diagram.navigator;

import hierarchymealy.diagram.part.MealyMachineVisualIDRegistry;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class MealyMachineNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5004;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof MealyMachineNavigatorItem) {
			MealyMachineNavigatorItem item = (MealyMachineNavigatorItem) element;
			return MealyMachineVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
