package edu.unikiel.rtsys.kieler.kivik.viewer;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.HistoryItem;
import org.eclipse.compare.contentmergeviewer.ContentMergeViewer;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.compare.diff.metamodel.ModelInputSnapshot;
import org.eclipse.emf.compare.ui.util.EMFCompareConstants;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import edu.unikiel.rtsys.kieler.kiml.ui.layouter.KimlGMFLayouter;
import edu.unikiel.rtsys.kieler.kivik.Constants;
import edu.unikiel.rtsys.kieler.kivik.internal.KivikComparator;
import edu.unikiel.rtsys.kieler.kivik.internal.KivikCompareInput;
import edu.unikiel.rtsys.kieler.kivik.internal.KivikTypedElementWrapper;

/**
 * @author ars
 * 
 */
public class DiagramContentMergeViewer extends ContentMergeViewer {

	private Diagram diagram_left;

	private Diagram diagram_right;

	private DiagramGraphicalViewer viewer_left;

	private DiagramGraphicalViewer viewer_right;

	private DiagramGraphicalViewer viewer_anc = null;

	private final CompareConfiguration compareConfiguration;

	private boolean isThreeWay;

	private long lastHistoryItemDate;

	private IPropertyChangeListener structureSelectionListener;

	private KimlGMFLayouter gmfLayouter = new KimlGMFLayouter();

	protected DiagramContentMergeViewer(Composite parent,
			CompareConfiguration cc) {
		super(SWT.NONE, null, cc);
		compareConfiguration = cc;
		buildControl(parent);
		structureSelectionListener = new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(
						EMFCompareConstants.PROPERTY_STRUCTURE_SELECTION)) {
					SelectionChangedEvent selectionChangedEvent = (SelectionChangedEvent) event
							.getNewValue();
					if (selectionChangedEvent.getSelection() instanceof StructuredSelection) {
						StructuredSelection structuredSelection = (StructuredSelection) selectionChangedEvent
								.getSelection();
						System.out.println("DCMV: Element:  "
								+ structuredSelection.getFirstElement());
						// TODO
						// mark the selected elements in the left and right
						// diagram
					}
				}
			}
		};
		compareConfiguration
				.addPropertyChangeListener(structureSelectionListener);
	}

	protected void copy(boolean leftToRight) {
		// TODO Auto-generated method stub
	}

	protected void createControls(Composite composite) {
		viewer_left = new DiagramGraphicalViewer();
		viewer_left.createControl(composite);
		viewer_left.getControl().setBackground(ColorConstants.listBackground);
		// viewer_left.setRouteEventsToEditDomain(true);
		viewer_right = new DiagramGraphicalViewer();
		viewer_right.createControl(composite);
		viewer_right.getControl().setBackground(ColorConstants.listBackground);
		// viewer_right.setRouteEventsToEditDomain(true);
	}

	/**
	 * Returns the viewer's title.
	 * 
	 * @return The viewer's title.
	 */
	public String getTitle() {
		return Constants.PLUGIN_NAME + ": Diagram comparison"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.compare.contentmergeviewer.ContentMergeViewer#getContents
	 * (boolean)
	 */
	protected byte[] getContents(boolean left) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void handleResizeAncestor(int x, int y, int width, int height) {
		if (viewer_anc != null) {
			if (width > 0) {
				viewer_anc.getControl().setVisible(true);
				viewer_anc.getControl().setBounds(x, y, width, height);
			} else {
				viewer_anc.getControl().setVisible(false);
			}
		}
	}

	protected void handleResizeLeftRight(int x, int y, int leftWidth,
			int centerWidth, int rightWidth, int height) {

		viewer_left.getControl().setBounds(x, y, leftWidth, height);
		viewer_right.getControl().setBounds(x + leftWidth + centerWidth, y,
				rightWidth, height);
		if (viewer_left.getRootEditPart() instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) viewer_left
					.getRootEditPart();
			rootEditPart.getZoomManager().setZoomAnimationStyle(
					ZoomManager.ANIMATE_NEVER);
			rootEditPart.getZoomManager().setZoom(0.7);
		}
		if (viewer_right.getRootEditPart() instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) viewer_right
					.getRootEditPart();
			rootEditPart.getZoomManager().setZoomAnimationStyle(
					ZoomManager.ANIMATE_NEVER);
			rootEditPart.getZoomManager().setZoom(0.7);
		}
	}

	/**
	 * {@inheritDoc}
	 */

	public void setInput(Object input) {
		System.out.println("DCMV: setInput");
		// We won't compare again if the given input is the same as the last.
		boolean changed = false;
		if (input instanceof ICompareInput
				&& ((ICompareInput) input).getAncestor() != null)
			isThreeWay = true;
		if (input instanceof ICompareInput
				&& ((ICompareInput) input).getRight() instanceof HistoryItem) {
			changed = lastHistoryItemDate != ((HistoryItem) ((ICompareInput) input)
					.getRight()).getModificationDate();
			if (changed)
				lastHistoryItemDate = ((HistoryItem) ((ICompareInput) input)
						.getRight()).getModificationDate();
		}
		final KivikComparator comparator = KivikComparator
				.getComparator(compareConfiguration);
		if (comparator.getComparisonResult() != null && !changed) {
			System.out.println("DiagramMergeViewer: 1.");
			final ModelInputSnapshot snapshot = comparator
					.getComparisonResult();
			super.setInput(new KivikCompareInput(snapshot.getMatch(), snapshot
					.getDiff(), comparator));
		} else if (input instanceof ModelInputSnapshot) {
			System.out.println("DiagramMergeViewer: 2.");
			final ModelInputSnapshot snapshot = (ModelInputSnapshot) input;
			super.setInput(new KivikCompareInput(snapshot.getMatch(), snapshot
					.getDiff(), comparator));
		} else if (input instanceof ICompareInput) {
			System.out.println("DiagramMergeViewer: 3.");
			comparator.loadResources((ICompareInput) input);
			final ModelInputSnapshot snapshot = comparator
					.compareViewModel(compareConfiguration);
			super.setInput(new KivikCompareInput(snapshot.getMatch(), snapshot
					.getDiff(), comparator));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.compare.contentmergeviewer.ContentMergeViewer#updateContent
	 * (java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	protected void updateContent(Object ancestor, Object left, Object right) {

		if (left instanceof KivikTypedElementWrapper
				&& ((KivikTypedElementWrapper) left).getViewModel() != null) {
			diagram_left = ((KivikTypedElementWrapper) left).getViewModel();
			// DiagramEditingDomainFactory.getInstance().createEditingDomain(
			// diagram_left.eResource().getResourceSet());
			viewer_left.setEditDomain(new DefaultEditDomain(null));
			viewer_left.setEditPartFactory(EditPartService.getInstance());
			viewer_left.setRootEditPart(new DiagramRootEditPart(diagram_left
					.getMeasurementUnit()));
			viewer_left.setContents(diagram_left);
//			gmfLayouter.setRoot(viewer_left.getRootEditPart().getContents()
//					.getChildren().get(0));
//			gmfLayouter.layout();

		}
		if (right instanceof KivikTypedElementWrapper
				&& ((KivikTypedElementWrapper) right).getViewModel() != null) {
			diagram_right = ((KivikTypedElementWrapper) right).getViewModel();
			DiagramEditingDomainFactory.getInstance().createEditingDomain(
			diagram_right.eResource().getResourceSet());
			viewer_right.setEditDomain(new DefaultEditDomain(null));
			viewer_right.setEditPartFactory(EditPartService.getInstance());
			viewer_right.setRootEditPart(new DiagramRootEditPart(diagram_right
					.getMeasurementUnit()));
			viewer_right.setContents(diagram_right);
			gmfLayouter.setRoot(viewer_left.getRootEditPart().getContents()
					.getChildren().get(0));
			//gmfLayouter.layout();
		}

	}

}
