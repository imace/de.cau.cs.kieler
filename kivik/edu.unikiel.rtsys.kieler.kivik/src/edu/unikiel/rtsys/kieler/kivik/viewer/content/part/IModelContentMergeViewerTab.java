/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 * Contributors: Obeo - initial API and implementation
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kivik.viewer.content.part;

import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.widgets.Control;

/**
 * Represents a tab that will be placed in a {@link ModelContentMergeTabFolder}.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public interface IModelContentMergeViewerTab {
	/**
	 * Registers a selection listener on the tab's Control.
	 * 
	 * @param listener
	 *            Listener which to register on the Control.
	 */
	void addSelectionChangedListener(ISelectionChangedListener listener);

	/**
	 * Disposes of all resources allocated this tab.
	 */
	void dispose();

	/**
	 * Returns the Control displayed by the tab.
	 * 
	 * @return The tab's Control.
	 */
	Control getControl();

	/**
	 * Returns the tab's selection as a list of Items.
	 * 
	 * @return The tab's selection as a list of Items.
	 */
	List<? extends Object> getSelectedElements();

	/**
	 * This will be used when drawing the center part's marquees.
	 * 
	 * @param data
	 *            The data for which we need UI variables for.
	 * @return List of items corresponding to the given data, wrapped along with UI information.
	 */
	ModelContentMergeTabObject getUIElement(EObject data);

	/**
	 * Returns the tab's visible elements as a list of Items.
	 * <p>
	 * Elements are deemed visible if they are currently in the client area of the tab's Control.
	 * </p>
	 * 
	 * @return List of the tab's visible elements.
	 */
	List<ModelContentMergeTabObject> getVisibleElements();

	/**
	 * Redraws the Control displayed by the tab.
	 */
	void redraw();

	/**
	 * Sets the input of the tab.
	 * <p>
	 * This is often implemented by redirecting to the tab's "setInput(Object)" method.
	 * </p>
	 * 
	 * @param input
	 *            New input of the tab's viewer.
	 */
	void setReflectiveInput(Object input);

	/**
	 * Ensures the given List of items is made visible in the tab's Control client area.
	 * 
	 * @param items
	 *            List of the items ot make visible.
	 */
	void showElements(List<DiffElement> elements);
}
