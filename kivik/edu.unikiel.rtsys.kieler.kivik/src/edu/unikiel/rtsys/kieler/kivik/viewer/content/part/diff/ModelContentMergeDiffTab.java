/*******************************************************************************
 * Copyright (c) 2006, 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Arne Schipper - change from item to object to comply with the changed 
 *                interface, which was changed to handle diagrams
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kivik.viewer.content.part.diff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.diff.metamodel.ConflictingDiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.util.DiffAdapterFactory;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.FeatureMapEntry;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.edit.provider.FeatureMapEntryWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.unikiel.rtsys.kieler.kivik.viewer.content.ModelContentMergeViewer;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.part.IModelContentMergeViewerTab;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.part.ModelContentMergeTabFolder;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.part.ModelContentMergeTabObject;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.part.diagram.ModelContentMergeDiagramTab;

/**
 * Represents the tree view under a {@link ModelContentMergeTabFolder}'s diff
 * tab.
 * <p/>
 * Initial implementation by <a href="mailto:laurent.goubet@obeo.fr">Laurent
 * Goubet</a>, small changes from item to object to comply with the changed
 * interface, which was changed to handle diagrams.
 * 
 * @see ModelContentMergeDiagramTab
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @author <a href="mailto:ars@informatik.uni-kiel.de">Arne Schipper</a>
 */
public class ModelContentMergeDiffTab extends TreeViewer implements
		IModelContentMergeViewerTab {

	/** <code>int</code> representing this viewer part side. */
	protected final int partSide;

	/** Maps DiffElements to the TreeItems' data. */
	private final Map<EObject, DiffElement> dataToDiff = new EMFCompareMap<EObject, DiffElement>();

	/** Maps a TreeItem to its data. */
	private final Map<DiffElement, ModelContentMergeTabObject> dataToItem = new EMFCompareMap<DiffElement, ModelContentMergeTabObject>();

	/**
	 * Maps a TreeItem to its data. We're compelled to map the Tree like this
	 * because of EMF's FeatureMapEntry which default TreeViewers cannot handle
	 * accurately.
	 */
	private final Map<Object, TreeItem> dataToTreeItem = new EMFCompareMap<Object, TreeItem>();

	/** Keeps a reference to the containing tab folder. */
	private final ModelContentMergeTabFolder parent;

	/**
	 * Creates a tree viewer under the given parent control.
	 * 
	 * @param parentComposite
	 *            The parent {@link Composite} for this tree viewer.
	 * @param side
	 *            Side of this viewer part.
	 * @param parentFolder
	 *            Parent folder of this tab.
	 */
	public ModelContentMergeDiffTab(Composite parentComposite, int side,
			ModelContentMergeTabFolder parentFolder) {
		super(
				new Tree(parentComposite, SWT.MULTI | SWT.V_SCROLL
						| SWT.H_SCROLL));
		partSide = side;
		parent = parentFolder;

		setUseHashlookup(true);
		setContentProvider(new AdapterFactoryContentProvider(AdapterUtils
				.getAdapterFactory()));
		setLabelProvider(new AdapterFactoryLabelProvider(AdapterUtils
				.getAdapterFactory()));
		getTree().addPaintListener(new TreePaintListener());
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		dataToDiff.clear();
		dataToItem.clear();
		getTree().dispose();
	}

	/**
	 * Returns a {@link List} of the selected elements.
	 * 
	 * @return {@link List} of the selected elements.
	 */
	public List<TreeItem> getSelectedElements() {
		return Arrays.asList(getTree().getSelection());
	}

	/**
	 * {@inheritDoc}
	 */
	public ModelContentMergeTabObject getUIElement(EObject data) {
		ModelContentMergeTabObject result = null;
		// If the diff is hidden by another (diff extension), the item won't be
		// returned
		// Same goes for diffs that couldn't be matched
		final DiffElement diff = dataToDiff.get(data);
		if (diff != null && DiffAdapterFactory.shouldBeHidden(diff))
			return result;

		final ModelContentMergeTabObject item = dataToItem.get(diff);
		if (item == null)
			return null;
		// This is a match, we'll search the first visible element in its tree
		// path
		Item treeItem = null;
		Object visibleObject = item.getVisibleObject();
		if (visibleObject instanceof Item) {
			treeItem = getVisibleAncestorOf((Item) visibleObject);
		}

		if (treeItem == item.getVisibleObject()) {
			// This is actually a perfect match : the item is visible in the
			// tree and it is the actual
			// item displayed by the diff
			result = item;
		} else {
			// The item corresponding to the diff is not visible. We'll wrap its
			// first visible ancestor.
			result = new ModelContentMergeTabObject(item.getActualObject(),
					treeItem, item.getCurveColor());
		}

		// we should have found an item. sets the curve width and Y coordinate
		final int curveY;
		if (result.getActualObject() == result.getVisibleObject()) {
			if (partSide == EMFCompareConstants.LEFT
					&& diff instanceof ModelElementChangeRightTarget)
				curveY = ((TreeItem) result.getVisibleObject()).getBounds().y
						+ ((TreeItem) result.getVisibleObject()).getBounds().height;
			else if (partSide == EMFCompareConstants.RIGHT
					&& diff instanceof ModelElementChangeLeftTarget)
				curveY = ((TreeItem) result.getVisibleObject()).getBounds().y
						+ ((TreeItem) result.getVisibleObject()).getBounds().height;
			else
				curveY = ((TreeItem) result.getVisibleObject()).getBounds().y
						+ ((TreeItem) result.getVisibleObject()).getBounds().height
						/ 2;
			result.setCurveY(curveY);
		} else {
			if (partSide == EMFCompareConstants.LEFT
					&& diff instanceof ModelElementChangeRightTarget)
				curveY = ((TreeItem) result.getVisibleObject()).getBounds().y
						+ ((TreeItem) result.getVisibleObject()).getBounds().height;
			else if (partSide == EMFCompareConstants.RIGHT
					&& diff instanceof ModelElementChangeLeftTarget)
				curveY = ((TreeItem) result.getVisibleObject()).getBounds().y
						+ ((TreeItem) result.getVisibleObject()).getBounds().height;
			else
				curveY = ((TreeItem) result.getVisibleObject()).getBounds().y
						+ ((TreeItem) result.getVisibleObject()).getBounds().height;
			result.setCurveY(curveY);
		}
		if (getSelectedElements().contains(result.getActualObject()))
			result.setCurveSize(2);
		else
			result.setCurveSize(1);

		return result;
	}

	/**
	 * Returns a list of all the {@link Tree tree}'s visible elements.
	 * 
	 * @return List containing all the {@link Tree tree}'s visible elements.
	 */
	public List<ModelContentMergeTabObject> getVisibleElements() {
		final List<ModelContentMergeTabObject> result = new ArrayList<ModelContentMergeTabObject>();
		// This will happen if the user has "merged all"
		if (parent.getDiffAsList().size() == 0)
			return result;

		final List<Item> visibleTreeItems = getVisibleTreeItems();
		final Iterator<DiffElement> differences = dataToItem.keySet()
				.iterator();
		while (differences.hasNext()) {
			final DiffElement data = differences.next();
			final ModelContentMergeTabObject nextItem = dataToItem.get(data);
			if (nextItem.getActualObject() instanceof Item) {
				final ModelContentMergeTabObject nextVisibleItem = getUIElement((EObject) internalFindActualData(((Item) nextItem
						.getActualObject()).getData()));
				if (visibleTreeItems.contains(nextVisibleItem
						.getVisibleObject())) {
					final ModelContentMergeTabObject next = new ModelContentMergeTabObject(
							nextItem.getActualObject(), nextVisibleItem
									.getVisibleObject(), nextItem
									.getCurveColor(), nextVisibleItem
									.getCurveY(), nextVisibleItem
									.getCurveSize());
					result.add(next);
				}
			}
		}
		return result;
	}

	/**
	 */
	public void redraw() {
		getTree().redraw();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ColumnViewer#refresh(java.lang.Object,
	 *      boolean)
	 */
	@Override
	public void refresh(Object element, boolean updateLabels) {
		super.refresh(element, updateLabels);
		mapTreeItems();
		mapDifferences();
		mapTreeItemsToUI();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeedu.unikiel.rtsys.kieler.kivik.viewer.content.part.
	 * IModelContentMergeViewerTab#setReflectiveInput(java.lang.Object)
	 */
	public void setReflectiveInput(Object object) {
		// We *need* to invalidate the cache here since setInput() would try to
		// use it otherwise
		dataToDiff.clear();
		dataToItem.clear();
		dataToTreeItem.clear();

		final AdapterFactory adapterFactory = AdapterUtils.getAdapterFactory();
		setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		if (object instanceof DiagramImpl) {
			if (((DiagramImpl) object).getElement().eResource() != null)
				setInput(((DiagramImpl) object).getElement().eResource()
						.getContents().get(0));
			else {
				setInput(null);
				MessageDialog
						.openInformation(
								PlatformUI.getWorkbench()
										.getActiveWorkbenchWindow().getShell(),
								"KIELER KiViK Plug-in",
								"Not able to get domain history version for provided object. Try using an editor which saves domain and notation model in one file.");
			}
		} else if (object instanceof EObject) {
			setInput(((EObject) object));// .eResource());
		} else {
			assert object instanceof Resource;
			setInput(object);
		}

		mapTreeItems();
		mapDifferences();
		mapTreeItemsToUI();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.AbstractTreeViewer#inputChanged(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected void inputChanged(Object input, Object oldInput) {
		final TreePath[] expandedTreePaths = getExpandedTreePaths();

		super.inputChanged(input, oldInput);

		// Expands all items so that we'll be able to find them back (defeats
		// purpose of lazy loading)
		expandAll();
		setExpandedTreePaths(expandedTreePaths);
	}

	/**
	 * Ensures the first element of the given list of items is visible in the
	 * tree, and sets the tree's selection to this list.
	 * 
	 * @param items
	 *            Items to make visible.
	 */
	public void showElements(List<DiffElement> items) {
		final List<EObject> datas = new ArrayList<EObject>();
		for (int i = 0; i < items.size(); i++) {
			if (partSide == EMFCompareConstants.ANCESTOR
					&& items.get(i) instanceof ConflictingDiffElement)
				datas.add(((ConflictingDiffElement) items.get(i))
						.getOriginElement());
			else if (partSide == EMFCompareConstants.LEFT)
				datas.add(EMFCompareEObjectUtils.getLeftElement(items.get(i)));
			else
				datas.add(EMFCompareEObjectUtils.getRightElement(items.get(i)));
		}
		setSelection(new StructuredSelection(datas), true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.AbstractTreeViewer#doFindItem(java.lang.Object)
	 */
	@Override
	protected Widget doFindInputItem(Object element) {
		final Widget res = dataToTreeItem.get(element);
		if (res != null && !res.isDisposed())
			return res;
		else if (res != null) {
			// mapped items are disposed
			mapTreeItems();
			mapDifferences();
			mapTreeItemsToUI();
			// won't call this recursively since it could eventually lead to
			// stack overflows
			dataToTreeItem.get(element);
		}
		return super.doFindInputItem(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see StructuredViewer#setSelectionToWidget(List, boolean)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setSelectionToWidget(List l, boolean reveal) {
		// Will expand the treeItem to one level below the current if needed
		final List<TreeItem> newSelection = new ArrayList<TreeItem>();
		for (Object data : l) {
			Widget widget = null;
			if (data instanceof EObject)
				widget = findItemForEObject((EObject) data);
			else if (data instanceof TreePath)
				widget = findItemForEObject((EObject) ((TreePath) data)
						.getLastSegment());
			else if (data != null)
				widget = findItem(data);
			if (widget != null && widget instanceof TreeItem) {
				newSelection.add((TreeItem) widget);
				if (((TreeItem) widget).getExpanded()
						&& getChildren(widget).length > 0)
					expandToLevel(data, 1);
			}
		}
		if (newSelection.size() > 0)
			setSelection(newSelection);
		else
			super.setSelectionToWidget(l, reveal);
	}

	/**
	 * Returns the Item corresponding to the given EObject or its container if
	 * none can be found.
	 * 
	 * @param element
	 *            {@link EObject} to seek in the tree.
	 * @return The Item corresponding to the given EObject.
	 */
	private Widget findItemForEObject(EObject element) {
		Widget result = super.findItem(element);
		if (result == null) {
			if (element.eContainer() != null) {
				result = findItemForEObject(element.eContainer());
			} else if (getTree().getItemCount() > 0)
				result = getTree().getItem(0);
		}
		if (result instanceof Tree && getTree().getItemCount() > 0)
			result = getTree().getItem(0);
		return result;
	}

	/**
	 * Returns a visible ancestor of the given item. Will return the first
	 * container that is not expanded.
	 * 
	 * @param item
	 *            item we look for a visible ancestor of.
	 * @return The first container of <tt>item</tt> that is not expanded, the
	 *         element itself if its container is expanded.
	 */
	private Item getVisibleAncestorOf(Item item) {
		Item result = item;
		final TreePath path = getTreePathFromItem(item);
		if (path.getSegmentCount() > 1) {
			for (int i = 0; i < path.getSegmentCount(); i++) {
				final TreeItem ancestor = (TreeItem) findItem(path
						.getSegment(i));
				if (!ancestor.getExpanded()) {
					result = ancestor;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Returns a list of all the {@link Tree tree}'s visible elements.
	 * 
	 * @return List containing all the {@link Tree tree}'s visible elements.
	 */
	private List<Item> getVisibleTreeItems() {
		final TreeItem topItem = getTree().getTopItem();
		if (topItem != null) {
			// We won't go further down than the visible height of the tree,
			// yet we will take the whole width into account when searching for
			// elements.
			final int treeHeight = getTree().getClientArea().height;
			final int treeWidth = getTree().getBounds().width;
			final int itemHeight = topItem.getBounds().height;
			final int itemWidth = topItem.getBounds().width;
			final List<Item> visibleItems = new ArrayList<Item>(treeHeight
					/ itemHeight + 1);

			visibleItems.add(topItem);

			// The loop will start at the element directly following the "top"
			// one,
			// And we'll go down to one item more than there are in the tree
			final int loopStart = topItem.getBounds().y + itemHeight
					+ itemHeight / 2;
			final int loopEnd = treeHeight;
			for (int i = loopStart; i <= loopEnd; i += itemHeight) {
				TreeItem next = null;
				// we'll try and seek on all the line, thus increasing x on each
				// iteration
				for (int xCoord = topItem.getBounds().x; xCoord < treeWidth; xCoord += itemWidth >> 1) {
					next = getTree().getItem(new Point(xCoord, i));
					// We found the item, it is unnecessary to probe any further
					// on the line
					if (next != null)
						break;
				}
				if (next != null) {
					visibleItems.add(next);
				} else {
					// We did not found an item, it is thus useless to probe any
					// further down
					break;
				}
			}

			return visibleItems;
		}
		return new ArrayList<Item>();
	}

	/**
	 * This will seek out the first value of the given Object that is not
	 * instance of either FeatureMapEntryWrapperItemProvider or
	 * DelegatingWrapperItemProvider.
	 * 
	 * @param data
	 *            The data we seek the actual value of.
	 * @return Actual value of the given TreeItem's data.
	 */
	private Object internalFindActualData(Object data) {
		Object actualData = data;
		if (data instanceof FeatureMapEntryWrapperItemProvider)
			actualData = internalFindActualData(((FeatureMapEntryWrapperItemProvider) data)
					.getValue());
		else if (data instanceof DelegatingWrapperItemProvider)
			actualData = internalFindActualData(((DelegatingWrapperItemProvider) data)
					.getValue());
		else if (data instanceof ContainmentUpdatingFeatureMapEntry)
			actualData = ((ContainmentUpdatingFeatureMapEntry) data).getValue();
		return actualData;
	}

	/**
	 * Maps the children of the given <tt>item</tt>.
	 * 
	 * @param item
	 *            TreeItem which children are to be mapped.
	 */
	private void internalMapTreeItems(TreeItem item) {
		for (TreeItem child : item.getItems()) {
			dataToTreeItem.put(internalFindActualData(child.getData()), child);
			internalMapTreeItems(child);
		}
	}

	/**
	 * Maps the input's differences if any.
	 */
	private void mapDifferences() {
		dataToDiff.clear();
		final Iterator<DiffElement> diffIterator = parent.getDiffAsList()
				.iterator();
		while (diffIterator.hasNext()) {
			final DiffElement diff = diffIterator.next();
			final EObject data;
			if (partSide == EMFCompareConstants.ANCESTOR
					&& diff instanceof ConflictingDiffElement)
				data = ((ConflictingDiffElement) diff).getOriginElement();
			else if (partSide == EMFCompareConstants.LEFT)
				data = EMFCompareEObjectUtils.getLeftElement(diff);
			else
				data = EMFCompareEObjectUtils.getRightElement(diff);
			if (data != null)
				dataToDiff.put(data, diff);
			else
				// TODO for now, we're using the first item's data, we should
				// look for the matchedElement
				dataToDiff.put((EObject) getTree().getItems()[0].getData(),
						diff);
		}
	}

	/**
	 * This will map this TreeViewer's TreeItems to their data. We need to do
	 * this in order to find the items associated to {@link FeatureMapEntry}s
	 * since default TreeViewers cannot handle such data.
	 */
	private void mapTreeItems() {
		dataToTreeItem.clear();
		for (TreeItem item : getTree().getItems()) {
			dataToTreeItem.put(internalFindActualData(item.getData()), item);
			internalMapTreeItems(item);
		}
	}

	/**
	 * This will map all the TreeItems in this TreeViewer that need be taken
	 * into account when drawing diff markers to a corresponding
	 * ModelContentMergeTabItem. This will allow us to browse everything once
	 * and for all.
	 */
	private void mapTreeItemsToUI() {
		dataToItem.clear();
		for (EObject key : dataToDiff.keySet()) {
			final DiffElement diff = dataToDiff.get(key);
			// Defines the TreeItem corresponding to this difference
			EObject data;
			if (partSide == EMFCompareConstants.ANCESTOR
					&& diff instanceof ConflictingDiffElement)
				data = ((ConflictingDiffElement) diff).getOriginElement();
			else if (partSide == EMFCompareConstants.LEFT)
				data = EMFCompareEObjectUtils.getLeftElement(diff);
			else
				data = EMFCompareEObjectUtils.getRightElement(diff);
			if (data == null)
				// TODO for now, we're using the first item's data, we should
				// look for the matchedElement
				data = (EObject) getTree().getItems()[0].getData();
			Object foundItem = findItem(data);
			Item actualItem = null;
			if (foundItem instanceof Item) {
				actualItem = (Item) foundItem;
			}
			if (actualItem == null)
				return;

			Item visibleItem = null;
			if (partSide == EMFCompareConstants.LEFT
					&& diff instanceof ModelElementChangeRightTarget
					&& ((ModelElementChangeRightTarget) diff).getRightElement()
							.eContainer() != null) {
				// in the case of a modelElementChangeRightTarget, we know we
				// can't find
				// the element itself, we'll then search for one with the same
				// index
				final EObject right = ((ModelElementChangeRightTarget) diff)
						.getRightElement();
				final EObject left = ((ModelElementChangeRightTarget) diff)
						.getLeftParent();
				final int rightIndex = right.eContainer().eContents().indexOf(
						right);
				// Ensures we cannot trigger ArrayOutOfBounds exeptions
				final int leftIndex = Math.min(rightIndex - 1, left.eContents()
						.size() - 1);
				if (left.eContents().size() > 0)
					visibleItem = (Item) findItem(left.eContents().get(
							leftIndex));
			} else if (partSide == EMFCompareConstants.RIGHT
					&& diff instanceof ModelElementChangeLeftTarget
					&& ((ModelElementChangeLeftTarget) diff).getLeftElement()
							.eContainer() != null) {
				// in the case of a modelElementChangeLeftTarget, we know we
				// can't find
				// the element itself, we'll then search for one with the same
				// index
				final EObject right = ((ModelElementChangeLeftTarget) diff)
						.getRightParent();
				final EObject left = ((ModelElementChangeLeftTarget) diff)
						.getLeftElement();
				final int leftIndex = left.eContainer().eContents().indexOf(
						left);
				// Ensures we cannot trigger ArrayOutOfBounds exeptions
				final int rightIndex = Math.max(0, Math.min(leftIndex - 1,
						right.eContents().size() - 1));
				if (right.eContents().size() > 0)
					visibleItem = (Item) findItem(right.eContents().get(
							rightIndex));
			}

			// and now the color which should be used for this kind of
			// differences
			final String color;
			if (diff.getKind() == DifferenceKind.CONFLICT
					|| diff.isConflicting()) {
				color = EMFCompareConstants.PREFERENCES_KEY_CONFLICTING_COLOR;
			} else if (diff.getKind() == DifferenceKind.ADDITION) {
				color = EMFCompareConstants.PREFERENCES_KEY_ADDED_COLOR;
			} else if (diff.getKind() == DifferenceKind.DELETION) {
				color = EMFCompareConstants.PREFERENCES_KEY_REMOVED_COLOR;
			} else
				color = EMFCompareConstants.PREFERENCES_KEY_CHANGED_COLOR;

			final ModelContentMergeTabObject wrappedItem;
			if (visibleItem != null)
				wrappedItem = new ModelContentMergeTabObject(actualItem,
						visibleItem, color);
			else
				wrappedItem = new ModelContentMergeTabObject(actualItem, color);
			dataToItem.put(diff, wrappedItem);
		}
	}

	/**
	 * This implementation of {@link PaintListener} handles the drawing of
	 * blocks around modified members in the tree tab.
	 * 
	 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
	 */
	class TreePaintListener implements PaintListener {
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
		 */
		public void paintControl(PaintEvent event) {
			if (ModelContentMergeViewer.shouldDrawDiffMarkers()) {
				for (ModelContentMergeTabObject item : getVisibleElements()) {
					drawRectangle(event, item);
				}
			}
		}

		/**
		 * Handles the drawing itself.
		 * 
		 * @param event
		 *            {@link PaintEvent} that triggered this operation.
		 * @param item
		 *            Item that need to be circled and connected to the center
		 *            part.
		 */
		private void drawRectangle(PaintEvent event,
				ModelContentMergeTabObject item) {
			final Rectangle treeBounds = getTree().getClientArea();
			final Rectangle treeItemBounds = ((TreeItem) item
					.getVisibleObject()).getBounds();

			// Defines the circling Color
			final RGB color = ModelContentMergeViewer.getColor(item
					.getCurveColor());

			// We add a margin before the rectangle to circle the "+" as well as
			// the tree line.
			final int margin = 60;

			// Defines all variables needed for drawing the rectangle.
			final int rectangleX = treeItemBounds.x - margin;
			final int rectangleY = treeItemBounds.y;
			final int rectangleWidth = treeItemBounds.width + margin;
			final int rectangleHeight = treeItemBounds.height - 1;
			final int rectangleArcWidth = 5;
			final int rectangleArcHeight = 5;

			// Performs the actual drawing
			event.gc.setLineWidth(item.getCurveSize());
			event.gc.setForeground(new Color(getTree().getDisplay(), color));
			if (partSide == EMFCompareConstants.LEFT) {
				if (item.getCurveY() != treeItemBounds.y
						+ treeItemBounds.height / 2) {
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX, item.getCurveY(),
							treeBounds.width + treeBounds.x, item.getCurveY());
				} else {
					event.gc.setLineStyle(SWT.LINE_DASHDOT);
					event.gc.drawRoundRectangle(rectangleX, rectangleY,
							rectangleWidth, rectangleHeight, rectangleArcWidth,
							rectangleArcHeight);
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX + rectangleWidth, item
							.getCurveY(), treeBounds.width + treeBounds.x, item
							.getCurveY());
				}
			} else if (partSide == EMFCompareConstants.RIGHT) {
				if (item.getCurveY() != treeItemBounds.y
						+ treeItemBounds.height / 2) {
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX + rectangleWidth, item
							.getCurveY(), treeBounds.x, item.getCurveY());
				} else {
					event.gc.setLineStyle(SWT.LINE_DASHDOT);
					event.gc.drawRoundRectangle(rectangleX, rectangleY,
							rectangleWidth, rectangleHeight, rectangleArcWidth,
							rectangleArcHeight);
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX, item.getCurveY(),
							treeBounds.x, item.getCurveY());
				}
			} else {
				if (item.getCurveY() != treeItemBounds.y
						+ treeItemBounds.height / 2) {
					event.gc.setLineStyle(SWT.LINE_SOLID);
					event.gc.drawLine(rectangleX + rectangleWidth, item
							.getCurveY(), rectangleX, item.getCurveY());
				} else {
					event.gc.setLineStyle(SWT.LINE_DASHDOT);
					event.gc.drawRoundRectangle(rectangleX, rectangleY,
							rectangleWidth, rectangleHeight, rectangleArcWidth,
							rectangleArcHeight);
				}
			}
		}
	}
}
