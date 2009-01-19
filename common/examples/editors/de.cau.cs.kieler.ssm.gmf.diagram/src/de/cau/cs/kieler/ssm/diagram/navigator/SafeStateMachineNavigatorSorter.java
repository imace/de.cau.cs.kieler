package de.cau.cs.kieler.ssm.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import de.cau.cs.kieler.ssm.diagram.part.SafeStateMachineVisualIDRegistry;


/**
 * @generated
 */
public class SafeStateMachineNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7005;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof SafeStateMachineNavigatorItem) {
			SafeStateMachineNavigatorItem item = (SafeStateMachineNavigatorItem) element;
			return SafeStateMachineVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
