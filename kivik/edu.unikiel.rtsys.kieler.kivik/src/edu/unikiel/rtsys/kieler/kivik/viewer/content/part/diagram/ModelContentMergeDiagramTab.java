/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kivik.viewer.content.part.diagram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.ConflictingDiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.util.DiffAdapterFactory;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.emf.compare.ui.util.EMFCompareEObjectUtils;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.AnimatableScrollPane;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.PlatformUI;

import edu.unikiel.rtsys.kieler.kiml.layout.KimlLayoutPlugin;
import edu.unikiel.rtsys.kieler.kiml.layout.services.DiagramLayouters;
import edu.unikiel.rtsys.kieler.kiml.layout.services.KimlAbstractLayouter;
import edu.unikiel.rtsys.kieler.kiml.layout.util.KimlLayoutPreferenceConstants;
import edu.unikiel.rtsys.kieler.kivik.Constants;
import edu.unikiel.rtsys.kieler.kivik.KivikPlugin;
import edu.unikiel.rtsys.kieler.kivik.preferences.PreferenceConstants;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.ModelContentMergeViewer;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.part.IModelContentMergeViewerTab;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.part.ModelContentMergeTabFolder;
import edu.unikiel.rtsys.kieler.kivik.viewer.content.part.ModelContentMergeTabObject;

/**
 *
 */
public class ModelContentMergeDiagramTab extends DiagramGraphicalViewer
		implements IModelContentMergeViewerTab, IPropertyChangeListener {

	/** <code>int</code> representing this viewer part side. */
	protected final int partSide;

	/** Maps DiffElements to the TreeItems' data. */
	private final Map<EObject, DiffElement> dataToDiff = new EMFCompareMap<EObject, DiffElement>();
	private final Map<EObject, DiffElement> dataToRecursivelyDiff = new EMFCompareMap<EObject, DiffElement>();

	/** Maps a TreeItem to its data. */
	private final Map<DiffElement, ModelContentMergeTabObject> diffToTabObject = new EMFCompareMap<DiffElement, ModelContentMergeTabObject>();

	/** Keeps a reference to the containing tab folder. */
	private final ModelContentMergeTabFolder parent;

	private RenderedDiagramRootEditPart rootEditPart = null;
	private FreeformLayer feedbackLayer = null;
	private Viewport viewport = null;
	private BorderItemsAwareFreeFormLayer primaryLayer = null;
	private ZoomManager zoomManager = null;
	private AdapterFactoryLabelProvider adapterLabelProvider = new AdapterFactoryLabelProvider(
			AdapterUtils.getAdapterFactory());

	private double prefInitialZoom;
	private boolean prefZoomToElement;
	private boolean prefRelayoutDiagram;
	private boolean prefCollapseUnchanged;
	private boolean prefEnableSelection;
	private boolean prefEnableScrolling;

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
	public ModelContentMergeDiagramTab(Composite parentComposite, int side,
			ModelContentMergeTabFolder parentFolder) {

		/* standards */
		super();
		updatePreferences();
		createControl(parentComposite);
		partSide = side;
		parent = parentFolder;

		/* read in preferences every time the change */
		KivikPlugin.getDefault().getPreferenceStore()
				.addPropertyChangeListener(this);

		/* initialize the DiagramGraphicalViewer */
		setEditDomain(new EditDomain());
		setEditPartFactory(EditPartService.getInstance());
		setRootEditPart(new RenderedDiagramRootEditPart(
				MeasurementUnit.PIXEL_LITERAL));

		/* fetch some often needed objects */
		rootEditPart = (RenderedDiagramRootEditPart) getRootEditPart();

		zoomManager = (ZoomManager) rootEditPart.getZoomManager();

		feedbackLayer = new FreeformLayer();
		feedbackLayer.setEnabled(false);
		ScalableFreeformLayeredPane scalableLayers = (ScalableFreeformLayeredPane) rootEditPart
				.getLayer(DiagramRootEditPart.SCALABLE_LAYERS);

		scalableLayers.add(feedbackLayer,
				DiagramRootEditPart.SCALED_FEEDBACK_LAYER);
		viewport = zoomManager.getViewport();

		primaryLayer = (BorderItemsAwareFreeFormLayer) rootEditPart
				.getLayer(DiagramRootEditPart.PRIMARY_LAYER);

		zoomManager.setZoom(prefInitialZoom);
		/* set some initial values and options */
		if (prefEnableScrolling) {
			zoomManager.setZoomAnimationStyle(ZoomManager.ANIMATE_ZOOM_IN_OUT);
		} else {
			zoomManager.setZoomAnimationStyle(ZoomManager.ANIMATE_NEVER);
		}

		setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.MOD1),
				MouseWheelZoomHandler.SINGLETON);
	}

	/**
	 */
	public void dispose() {
		dataToDiff.clear();
		diffToTabObject.clear();
		KivikPlugin.getDefault().getPreferenceStore()
				.removePropertyChangeListener(this);
	}

	/**
	 * 
	 */
	public void setReflectiveInput(Object object) {
		// We *need* to invalidate the cache here since setInput() would try to
		// use it otherwise
		dataToDiff.clear();
		dataToRecursivelyDiff.clear();
		diffToTabObject.clear();

		Diagram diagram = null;
		if (object instanceof Diagram) {
			diagram = (Diagram) object;

		} else {
			assert object instanceof EObject;
			EObject eobj = (EObject) object;
			Resource resource = eobj.eResource();
			diagram = (Diagram) resource.getContents().get(1);
		}

		DiagramEditingDomainFactory.getInstance().createEditingDomain(
				diagram.eResource().getResourceSet());

		setContents(diagram);

		mapDifferences();
		mapDiffGroups();
		mapDiffToTabObjects();

		if (prefCollapseUnchanged) {
			collapseUnchanged(diagram);
		}

		if (prefRelayoutDiagram || prefCollapseUnchanged) {
			primaryLayer.validate();
			IEditorRegistry reg = PlatformUI.getWorkbench().getEditorRegistry();
			String filename = diagram.eResource().getURI().toString();
			IEditorDescriptor editorDescriptor = reg.getDefaultEditor(filename);
			KimlAbstractLayouter diagramLayouter = DiagramLayouters
					.getInstance().getDiagramLayouter(editorDescriptor.getId());
			boolean oldPrefSetting = KimlLayoutPlugin
					.getDefault()
					.getPreferenceStore()
					.getBoolean(
							KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_MULTIPLE_LAYOUT_RUNS);
			KimlLayoutPlugin
					.getDefault()
					.getPreferenceStore()
					.setValue(
							KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_MULTIPLE_LAYOUT_RUNS,
							true);
			diagramLayouter.layout(getEditPartRegistry().get(diagram));
			KimlLayoutPlugin
					.getDefault()
					.getPreferenceStore()
					.setValue(
							KimlLayoutPreferenceConstants.PREF_DIAGRAMLAYOUTERS_MULTIPLE_LAYOUT_RUNS,
							oldPrefSetting);
		}

		primaryLayer.validate();

		if (!prefEnableSelection) {
			primaryLayer.setEnabled(false);
		}
		colorizeEditParts();

	}

	private void collapseUnchanged(Diagram diagram) {
		TreeIterator<EObject> allContents = diagram.eAllContents();

		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof View) {
				View theView = (View) next;
				DiffElement theChange = dataToRecursivelyDiff.get(theView
						.getElement());
				boolean forceCollapse = false;
				if (theChange instanceof DiffGroup) {
					DiffGroup diffGroup = (DiffGroup) theChange;
					forceCollapse = true;
					for (DiffElement element : diffGroup.getSubDiffElements()) {
						if (!(element instanceof ReferenceChange))
							forceCollapse = false;
					}
				}
				if (theChange == null || forceCollapse) {
					Object editPart = getEditPartRegistry().get(theView);
					if (editPart instanceof ShapeCompartmentEditPart) {
						ShapeCompartmentFigure scf = ((ShapeCompartmentEditPart) editPart)
								.getShapeCompartmentFigure();
						((AnimatableScrollPane) scf.getScrollPane()).collapse();
					}
				}
			}
		}
	}

	private void colorizeEditParts() {
		for (ModelContentMergeTabObject object : getVisibleElements()) {
			if (object.getActualObject() instanceof AbstractGraphicalEditPart) {

				String backgroundColor = object.getBackgroundColor();
				if (backgroundColor == Constants.DO_NOT_COLORIZE)
					continue;

				Color highlightColor = new Color(null, ModelContentMergeViewer
						.getColor(backgroundColor));

				AbstractGraphicalEditPart changedEditPart = (AbstractGraphicalEditPart) object
						.getActualObject();

				if (changedEditPart instanceof ConnectionEditPart) {
					changedEditPart.getFigure().setForegroundColor(
							highlightColor);
				} else {
					/*
					 * If a compartment is collapsed, then highlight the whole
					 * container
					 */
					if (changedEditPart.getParent() != null
							&& changedEditPart.getParent() instanceof AbstractGraphicalEditPart) {
						if (((AbstractGraphicalEditPart) changedEditPart
								.getParent()).getFigure() instanceof ResizableCompartmentFigure) {
							ResizableCompartmentFigure parentFigure = (ResizableCompartmentFigure) ((AbstractGraphicalEditPart) changedEditPart
									.getParent()).getFigure();
							AnimatableScrollPane asp = (AnimatableScrollPane) parentFigure
									.getScrollPane();
							if (!asp.isExpanded()) {

								parentFigure.getParent().setBackgroundColor(
										highlightColor);
							}
						}
					}
					changedEditPart.getContentPane().setBackgroundColor(
							highlightColor);
				}
				if (changedEditPart.getChildren().size() > 0
						&& changedEditPart.getChildren().get(0) instanceof ShapeCompartmentEditPart) {
					ShapeCompartmentEditPart scep = (ShapeCompartmentEditPart) changedEditPart
							.getChildren().get(0);
					scep.getFigure().setToolTip(
							getToolTip(changedEditPart, highlightColor));
				} else {
					changedEditPart.getContentPane().setToolTip(
							getToolTip(changedEditPart, highlightColor));
				}

			}
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
			final EObject diffContainer = diff.eContainer();
			final EObject dataContainer;

			if (diffContainer instanceof DiffGroup) {
				dataContainer = EMFCompareEObjectUtils
						.getLeftElement(((DiffGroup) diffContainer));
				if (dataContainer != null)
					dataToDiff.put(dataContainer, (DiffElement) diffContainer);
			}
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
				dataToDiff.put(getDiagram().getElement(), diff);
		}
	}

	private void mapDiffGroups() {
		dataToRecursivelyDiff.clear();
		final TreeIterator<EObject> diffGroupIterator = parent.getDiffModel()
				.eAllContents();
		while (diffGroupIterator.hasNext()) {
			EObject next = diffGroupIterator.next();
			if (next instanceof DiffGroup) {
				DiffGroup diffGroup = (DiffGroup) next;
				// diffGroup.
				EObject data = EMFCompareEObjectUtils.getLeftElement(diffGroup);

				if (data != null) {
					EObject matchElements = parent.findMatchFromElement(data);
					if (matchElements instanceof Match2Elements) {
						if (partSide == EMFCompareConstants.LEFT) {
							dataToRecursivelyDiff.put(
									((Match2Elements) matchElements)
											.getLeftElement(), diffGroup);
						} else if (partSide == EMFCompareConstants.RIGHT) {
							dataToRecursivelyDiff.put(
									((Match2Elements) matchElements)
											.getRightElement(), diffGroup);
						}

					}
				}
			} else {
				if (next instanceof DiffElement) {
					DiffElement diffElement = (DiffElement) next;
					if (partSide == EMFCompareConstants.LEFT
							&& !dataToRecursivelyDiff
									.containsKey(EMFCompareEObjectUtils
											.getLeftElement(diffElement))) {
						dataToRecursivelyDiff.put(EMFCompareEObjectUtils
								.getLeftElement(diffElement), diffElement);
					}
					if (partSide == EMFCompareConstants.RIGHT
							&& !dataToRecursivelyDiff
									.containsKey(EMFCompareEObjectUtils
											.getRightElement(diffElement))) {
						dataToRecursivelyDiff.put(EMFCompareEObjectUtils
								.getRightElement(diffElement), diffElement);
					}
				}
			}
		}
	}

	/**
	 * This will map all the TreeItems in this TreeViewer that need be taken
	 * into account when drawing diff markers to a corresponding
	 * ModelContentMergeTabItem. This will allow us to browse everything once
	 * and for all.
	 */
	private void mapDiffToTabObjects() {
		diffToTabObject.clear();
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
			if (data == null) {
				EObject matchElements = parent
						.findMatchFromElement(EMFCompareEObjectUtils
								.getLeftElement(diff));
				if (matchElements instanceof Match2Elements) {
					// data = ((Match2Elements)
					// matchElements).getRightElement();
				}
			}
			final AbstractGraphicalEditPart actualEditPart = findAbstractGraphicalEditPart(data);

			if (actualEditPart == null)
				continue;

			AbstractGraphicalEditPart visibleEditPart = null;
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
					visibleEditPart = findAbstractGraphicalEditPart(left
							.eContents().get(leftIndex));
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
					visibleEditPart = findAbstractGraphicalEditPart(right
							.eContents().get(rightIndex));
			}

			// and now the color which should be used for this kind of
			// differences
			final String color;
			final String backgroundColor;
			if (diff.getKind() == DifferenceKind.CONFLICT
					|| diff.isConflicting()) {
				color = EMFCompareConstants.PREFERENCES_KEY_CONFLICTING_COLOR;
				backgroundColor = EMFCompareConstants.PREFERENCES_KEY_CONFLICTING_COLOR;

			} else if (diff.getKind() == DifferenceKind.ADDITION) {
				color = EMFCompareConstants.PREFERENCES_KEY_ADDED_COLOR;
				// if (partSide == EMFCompareConstants.LEFT) {
				// backgroundColor = Constants.DO_NOT_COLORIZE;
				// } else {
				backgroundColor = EMFCompareConstants.PREFERENCES_KEY_ADDED_COLOR;
				// }

			} else if (diff.getKind() == DifferenceKind.DELETION) {
				color = EMFCompareConstants.PREFERENCES_KEY_REMOVED_COLOR;
				// if (partSide == EMFCompareConstants.RIGHT) {
				// backgroundColor = Constants.DO_NOT_COLORIZE;
				// } else {
				backgroundColor = EMFCompareConstants.PREFERENCES_KEY_REMOVED_COLOR;
				// }
			} else if (diff.getKind() == DifferenceKind.DELETION) {
				color = EMFCompareConstants.PREFERENCES_KEY_REMOVED_COLOR;
				backgroundColor = EMFCompareConstants.PREFERENCES_KEY_REMOVED_COLOR;

			} else if (diff.getKind() == DifferenceKind.CHANGE) {
				color = EMFCompareConstants.PREFERENCES_KEY_CHANGED_COLOR;
				backgroundColor = EMFCompareConstants.PREFERENCES_KEY_CHANGED_COLOR;

			} else if (diff.getKind() == DifferenceKind.MOVE) {
				color = EMFCompareConstants.PREFERENCES_KEY_CHANGED_COLOR;
				backgroundColor = EMFCompareConstants.PREFERENCES_KEY_CHANGED_COLOR;

			} else {
				color = Constants.DO_NOT_COLORIZE;
				backgroundColor = Constants.DO_NOT_COLORIZE;
			}
			final ModelContentMergeTabObject wrappedItem;
			// if (visibleEditPart != null)
			// wrappedItem = new ModelContentMergeTabObject(actualEditPart,
			// visibleEditPart, color, backgroundColor);
			// else
			wrappedItem = new ModelContentMergeTabObject(actualEditPart,
					actualEditPart, color, backgroundColor);
			diffToTabObject.put(diff, wrappedItem);
		}
	}

	private Diagram getDiagram() {
		return (Diagram) getRootEditPart().getContents().getModel();
	}

	@Override
	public List<? extends AbstractGraphicalEditPart> getSelectedElements() {
		List<AbstractGraphicalEditPart> selectedEditParts = new ArrayList<AbstractGraphicalEditPart>();
		for (Object element : getSelectedEditParts()) {
			if (element instanceof AbstractGraphicalEditPart)
				selectedEditParts.add((AbstractGraphicalEditPart) element);
		}
		return selectedEditParts;
	}

	@Override
	public ModelContentMergeTabObject getUIElement(EObject data) {
		// If the diff is hidden by another (diff extension), the item won't be
		// returned
		// Same goes for diffs that couldn't be matched
		final DiffElement diff = dataToDiff.get(data);
		if (diff != null && DiffAdapterFactory.shouldBeHidden(diff))
			return null;

		return diffToTabObject.get(diff);
	}

	@Override
	public List<ModelContentMergeTabObject> getVisibleElements() {
		final List<ModelContentMergeTabObject> result = new ArrayList<ModelContentMergeTabObject>();
		// This will happen if the user has "merged all"
		if (parent.getDiffAsList().size() == 0)
			return result;
		// At the moment return all TODO: fix
		for (ModelContentMergeTabObject tabObject : diffToTabObject.values()) {
			result.add(tabObject);
		}
		return result;
	}

	@Override
	public void showElements(List<DiffElement> diffElements) {
		deselectAll();

		final List<AbstractGraphicalEditPart> newSelection = new ArrayList<AbstractGraphicalEditPart>();
		AbstractGraphicalEditPart editPart = null;

		for (DiffElement diffElement : diffElements) {

			if (partSide == EMFCompareConstants.ANCESTOR
					&& diffElement instanceof ConflictingDiffElement) {
				editPart = findAbstractGraphicalEditPart(((ConflictingDiffElement) diffElement)
						.getOriginElement());
			} else if (partSide == EMFCompareConstants.LEFT) {
				editPart = findAbstractGraphicalEditPart(EMFCompareEObjectUtils
						.getLeftElement(diffElement));
			} else {
				// convenience hack, highlight also diffgroup in right diagram
				if (diffElement instanceof DiffGroup
						&& EMFCompareEObjectUtils.getLeftElement(diffElement) != null)
					editPart = findAbstractGraphicalEditPart(EMFCompareEObjectUtils
							.getRightElement(parent
									.findMatchFromElement(EMFCompareEObjectUtils
											.getLeftElement(diffElement))));
				else if (!(diffElement instanceof DiffGroup)) {
					editPart = findAbstractGraphicalEditPart(EMFCompareEObjectUtils
							.getRightElement(diffElement));
				}
			}

			if (editPart != null) {
				newSelection.add(editPart);
			}
		}

		markEditParts(newSelection);

	}

	private void markEditParts(List<AbstractGraphicalEditPart> editParts) {
		feedbackLayer.removeAll();

		if (editParts.size() > 0) {
			AbstractGraphicalEditPart editPart = editParts.get(0);

			/* scrolling and zoom */
			IFigure fig = editPart.getFigure();
			Rectangle figBounds = translateFromTo(fig, viewport);

			if (prefZoomToElement) {
				if (editPart.equals(getContents())) {
					zoomManager.setZoomAsText(ZoomManager.FIT_ALL);
				} else {
					zoomManager.zoomTo(figBounds.expand(50, 50));
				}
			} else {
				/* this is SCROLLING */
				Rectangle newZoomLocation = new Rectangle(figBounds.getCenter()
						.translate(viewport.getSize().scale(-0.5)), viewport
						.getBounds().getSize());
				zoomManager.zoomTo(newZoomLocation);
			}

			if (editPart.getParent() != null
					&& editPart.getParent() instanceof AbstractGraphicalEditPart) {
				if (((AbstractGraphicalEditPart) editPart.getParent())
						.getFigure() instanceof ResizableCompartmentFigure) {
					ResizableCompartmentFigure parentFigure = (ResizableCompartmentFigure) ((AbstractGraphicalEditPart) editPart
							.getParent()).getFigure();
					AnimatableScrollPane asp = (AnimatableScrollPane) parentFigure
							.getScrollPane();
					if (!asp.isExpanded()) {
						fig = parentFigure.getParent();
					}
				}
			}

			Color highlightColor = new Color(
					null,
					ModelContentMergeViewer
							.getColor(EMFCompareConstants.PREFERENCES_KEY_HIGHLIGHT_COLOR));

			Rectangle newBounds = translateFromTo(fig, feedbackLayer);

			RoundedRectangle markerFigure = new RoundedRectangle();
			markerFigure.setBounds(newBounds.expand(8, 8));
			markerFigure.setLineWidth(5);
			markerFigure.setForegroundColor(highlightColor);
			markerFigure.setFill(false);

			feedbackLayer.add(markerFigure);
		}
	}

	private AbstractGraphicalEditPart findAbstractGraphicalEditPart(
			EObject target) {

		GraphicalEditPart gepBegin = (GraphicalEditPart) getContents();
		if (target == null || gepBegin == null)
			return null;

		AbstractGraphicalEditPart foundEditPart = (GraphicalEditPart) gepBegin
				.findEditPart(null, target);

		if (foundEditPart == null) {
			GraphicalEditPart gepParent = (GraphicalEditPart) gepBegin
					.findEditPart(null, target.eContainer());
			foundEditPart = (AbstractGraphicalEditPart) findConnectionEditPart(
					gepParent, target);
		}
		return foundEditPart;
	}

	/* Finds an EditPart given a starting EditPart and an EObject */
	private AbstractGraphicalEditPart findConnectionEditPart(
			AbstractGraphicalEditPart epBegin, EObject theElement) {
		if (theElement == null || epBegin == null) {
			return null;
		}

		// check if gmf graphical edit part to be able to get connections
		if (epBegin instanceof GraphicalEditPart) {
			GraphicalEditPart epStart = (GraphicalEditPart) epBegin;

			// source connections
			for (Object obj : epStart.getSourceConnections()) {
				if (obj instanceof ConnectionEditPart) {
					ConnectionEditPart connectionEditPart = (ConnectionEditPart) obj;

					final View view = (View) ((IAdaptable) connectionEditPart)
							.getAdapter(View.class);

					if (view != null) {

						EObject el = ViewUtil.resolveSemanticElement(view);

						if ((el != null) && el.equals(theElement)) {
							return (AbstractGraphicalEditPart) connectionEditPart;
						}
					}
				}
			}

			// same for target connections
			for (Object obj : epStart.getTargetConnections()) {
				if (obj instanceof ConnectionEditPart) {
					ConnectionEditPart connectionEditPart = (ConnectionEditPart) obj;

					final View view = (View) ((IAdaptable) connectionEditPart)
							.getAdapter(View.class);

					if (view != null) {

						EObject el = ViewUtil.resolveSemanticElement(view);

						if ((el != null) && el.equals(theElement)) {
							return (AbstractGraphicalEditPart) connectionEditPart;
						}
					}
				}
			}

			ListIterator<?> childLI = epStart.getChildren().listIterator();
			while (childLI.hasNext()) {
				AbstractGraphicalEditPart epChild = (AbstractGraphicalEditPart) childLI
						.next();

				AbstractGraphicalEditPart elementEP = findConnectionEditPart(
						epChild, theElement);
				if (elementEP != null) {
					return elementEP;
				}
			}
		}
		return null;
	}

	private Rectangle translateFromTo(IFigure from, IFigure to) {
		Rectangle newBounds = from.getBounds().getCopy();
		from.translateToAbsolute(newBounds);
		to.translateToRelative(newBounds);
		return newBounds;
	}

	private IFigure getToolTip(AbstractGraphicalEditPart changedEditPart,
			Color highlightColor) {

		DiffElement diffElement = dataToRecursivelyDiff
				.get(((View) changedEditPart.getModel()).getElement());

		if (diffElement != null) {
			/* get the nicely formatted text */

			String text = null;
			Image image = null;
			if (diffElement instanceof AbstractDiffExtension) {
				text = ((AbstractDiffExtension) diffElement).getText();
			} else {
				if (diffElement instanceof IFile) {
					text = ((IFile) diffElement).getName();
				} else {
					text = adapterLabelProvider.getText(diffElement);
					image = adapterLabelProvider.getImage(diffElement);
				}
			}

			Label smallToolTip = new Label(text);
			smallToolTip.setBorder(new MarginBorder(8));
			smallToolTip.setBackgroundColor(highlightColor);
			smallToolTip.setIcon(image);
			smallToolTip.setIconAlignment(PositionConstants.LEFT);
			smallToolTip.setIconTextGap(5);
			return smallToolTip;
		} else {
			return null;
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		updatePreferences();
	}

	private void updatePreferences() {
		IPreferenceStore prefs = KivikPlugin.getDefault().getPreferenceStore();
		prefRelayoutDiagram = prefs
				.getBoolean(PreferenceConstants.PREF_KIVIK_ENABLE_AUTO_LAYOUT);
		prefCollapseUnchanged = prefs
				.getBoolean(PreferenceConstants.PREF_KIVIK_ENABLE_COLLAPSING_OF_UNCHANGED_ELEMENTS);
		prefEnableSelection = prefs
				.getBoolean(PreferenceConstants.PREF_KIVIK_ENABLE_SELECTING_IN_DIAGRAM);
		prefZoomToElement = prefs
				.getBoolean(PreferenceConstants.PREF_KIVIK_ENABLE_ZOOMING_TO_CHANGED_ELEMENTS);
		prefEnableScrolling = prefs
				.getBoolean(PreferenceConstants.PREF_KIVIK_ENABLE_SCROLLING_ANIMATION);
		prefInitialZoom = prefs
				.getInt(PreferenceConstants.PREF_KIVIK_INITIAL_ZOOM_FACTOR) / 100.0f;

		if (primaryLayer != null)
			primaryLayer.setEnabled(prefEnableSelection);
	}

	@Override
	public void redraw() {
	}
}
