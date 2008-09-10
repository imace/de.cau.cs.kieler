package edu.unikiel.rtsys.kieler.kiml.ui.views;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFColorHelper;
import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

/**
 * The KIML Layout Hints View.
 * 
 * This view displays information about grouped elements in a graphical editor
 * to easy up the working with the grouped elements. The aim of this view is to
 * work with any editor. Right now, there are some limitations. Full
 * functionality, better functionality at all, is at the moment just available
 * for GMF editors. This is due to following restrictions, to which will be
 * referred to in the comments below with the following keys:
 * 
 * <ul>
 * <li><b>GMF-Notation:</b> As the grouping information itself is stored inside
 * the GMF-Notation model for the model in the editor, grouping is just
 * available for GMF editors and models.</li>
 * 
 * <li><b>EMF-Model:</b> Sometimes, e.g. for the notification of changes, where
 * Emma uses the TransactionalEditingDomain to monitor the changes of the
 * GMF-Notation model, the EMF Model stuff is needed.</li>
 * </ul>
 * 
 * Nevertheless, were available, the methods work for, or are prepared to work
 * for, GEF-Editors.
 */
public class KimlLayoutHintView extends ViewPart implements ISelectionListener,
		IPartListener, ResourceSetListener {

	public static final String ID = "edu.unikiel.rtsys.kieler.kiml.ui.views.KimlLayoutHintView";

	private IEditorPart activeEditor = null;
	private TableViewer tableViewer;
	private Table table;
	private KimlGMFColorHelper savedEditPartColors;

	// TODO: externalize strings
	// Set the table column property names
	private final String NODE_COLUMN = "Node name";
	private final String LAYOUTGROUP_COLUMN = "Layout group";
	private final String LAYOUTTYPE_COLUMN = "Layout type";
	private final String LAYOUTERNAME_COLUMN = "Layouter name";

	// Set column names
	private String[] columnNames = new String[] { NODE_COLUMN,
			LAYOUTGROUP_COLUMN, LAYOUTTYPE_COLUMN, LAYOUTERNAME_COLUMN };

	public class GroupSorter extends ViewerSorter {

		/*
		 * Creates a resource sorter that will use the group
		 */
		public GroupSorter() {
			super();
		}

		/*
		 * (non-Javadoc) Method declared on ViewerSorter.
		 */
		public int compare(Viewer viewer, Object o1, Object o2) {
			String layoutGroup1 = KimlGMFLayoutHintHelper
					.getLayoutGroup((ShapeNodeEditPart) o1);
			String layoutGroup2 = KimlGMFLayoutHintHelper
					.getLayoutGroup((ShapeNodeEditPart) o2);
			return layoutGroup1.compareTo(layoutGroup2);
		}
	}

	/*
	 * The content provider class
	 */
	class ViewContentProvider implements IStructuredContentProvider {
		ArrayList<ShapeNodeEditPart> selectedNodeElements = new ArrayList<ShapeNodeEditPart>();

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			selectedNodeElements.clear();
			if (newInput != null && newInput instanceof IStructuredSelection) {
				for (Object element : ((IStructuredSelection) newInput)
						.toList()) {
					if (element instanceof ShapeNodeEditPart)
						selectedNodeElements.add((ShapeNodeEditPart) element);
				}
			}
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			return selectedNodeElements.toArray();
		}
	}

	/*
	 * The label provider class
	 */
	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider, ITableColorProvider {

		/*
		 * Emma returns the same color for each layout group, the color is
		 * generated from the layout group string. No color (= white) is of
		 * course returned if the other columns are asked for the color or if
		 * the element is not grouped.
		 */
		public Color getBackground(Object element, int columnIndex) {
			if (columnIndex == 1 && element instanceof ShapeNodeEditPart) {
				return KimlGMFColorHelper
						.generateGroupColor((ShapeNodeEditPart) element);
			} else
				return null;
		}

		public Color getForeground(Object element, int columnIndex) {
			return ColorConstants.black;
		}

		/**
		 * Limited functionality due to <b>GMF-Notation</b>.
		 */
		public String getColumnText(Object obj, int index) {
			ShapeNodeEditPart snep = (ShapeNodeEditPart) obj;
			switch (index) {
			case 0: /*
					 * Returns some sort of name. Uses the Adapter factory which
					 * needs to be contributed be the respective editor. The
					 * String.class adapter must return a name for the object.
					 * If no such adapter is present, the simple class name is
					 * returned. This works for all editors.
					 */
				String nodeName = ((Map<String, String>) Platform
						.getAdapterManager().getAdapter(obj, Map.class))
						.get("LONG_LABEL");
				if (nodeName != null) {
					return nodeName;
				} else {
					return obj.getClass().getSimpleName();
				}
			case 1: /*
					 * Returns the string nor grouped, if the element is not
					 * grouped, and nothing, if the element is grouped, as we
					 * use colors indicating groups/group members.
					 * 
					 * TODO: This works just for GMF, GMF-Notation above.
					 */
				return KimlGMFLayoutHintHelper.getLayoutGroup(snep).equals(
						KimlGMFLayoutHintHelper.NOT_GROUPED) ? KimlGMFLayoutHintHelper.NOT_GROUPED
						: "";

			case 2: // returns the layout type for this object
				return KimlGMFLayoutHintHelper.getLayoutType(snep).getLiteral();

			case 3: // returns the layouter name for this object
				return KimlGMFLayoutHintHelper.getLayouterName(snep);

			default: // Mister play-it-safe was afraid to fly ...
				return "";
			}
		}

		public Image getColumnImage(Object obj, int index) {
			if (index == 0)
				return getImage(obj);
			else
				return null;
		}

		/*
		 * TODO: Use adapter(?) to get the right image.
		 */
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	/**
	 * The constructor.
	 */
	public KimlLayoutHintView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {

		savedEditPartColors = new KimlGMFColorHelper();

		createTable(parent);

		createTableViewer();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(
				tableViewer.getControl(),
				"edu.unikiel.rtsys.kieler.layouter.viewer");
		hookContextMenu();
		hookDoubleClickAction();
		hookSelectionChangedListener();
	}

	/**
	 * Creates the Table
	 */
	private void createTable(Composite parent) {
		int style = SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		table = new Table(parent, style);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// 1st column
		TableColumn column = new TableColumn(table, SWT.LEFT, 0);
		column.setText(NODE_COLUMN);
		column.setWidth(400);

		// 2nd column
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText(LAYOUTGROUP_COLUMN);
		column.setWidth(100);

		// 3rd column
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText(LAYOUTTYPE_COLUMN);
		column.setWidth(100);

		// 4th column
		column = new TableColumn(table, SWT.LEFT, 3);
		column.setText(LAYOUTERNAME_COLUMN);
		column.setWidth(100);
	}

	/**
	 * Creates the TableViewer
	 */
	private void createTableViewer() {

		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);

		tableViewer.setContentProvider(new ViewContentProvider());
		tableViewer.setLabelProvider(new ViewLabelProvider());
		tableViewer.setSorter(new GroupSorter());
		tableViewer.setInput(getViewSite());
	}

	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		site.getPage().addSelectionListener(this);
		site.getPage().addPartListener(this);
	}

	public void dispose() {
		super.dispose();
		getSite().getPage().removeSelectionListener(this);
		getSite().getPage().removePartListener(this);
	}

	/*
	 * When clicking on an entry shown in the table the context menu for the
	 * ShapeNodeEditParts as defined in this plug-in will be available (i.e.
	 * GroupAs..., ungroup, ...). Also all other Context Menu actions from other
	 * plug-ins for a specific type of ShapeNodeEditPart will be available.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		Menu menu = menuMgr.createContextMenu(tableViewer.getControl());
		tableViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tableViewer);
	}

	/*
	 * Double clicking on an entry in the KIML Layout Hints table selects this
	 * EditPart in the Diagram Viewer, useful if several EditParts are selected
	 * and shown in the table.
	 */
	private void hookDoubleClickAction() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = tableViewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				if (obj instanceof AbstractGraphicalEditPart) {
					((AbstractGraphicalEditPart) obj).getViewer().select(
							(AbstractGraphicalEditPart) obj);
				}
			}
		});
	}

	/*
	 * Selecting an entry in the KIML Layout Hints table selects the
	 * corresponding EditPart in the Diagram Viewer, useful if several EditParts
	 * are selected and shown in the table.
	 */
	private void hookSelectionChangedListener() {
		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						savedEditPartColors.restoreAllForegrounds();
						savedEditPartColors.clearForeground();
						ISelection selection = event.getSelection();
						for (Object obj : ((IStructuredSelection) selection)
								.toArray()) {
							if (obj instanceof AbstractGraphicalEditPart) {
								savedEditPartColors
										.saveForegroundColor((AbstractGraphicalEditPart) obj);
								((AbstractGraphicalEditPart) obj)
										.getContentPane().setForegroundColor(
												ColorConstants.red);
							}
						}
					}
				});
	}

	/*
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		tableViewer.getControl().setFocus();
	}

	/*
	 * This method will be called when the selection in the Diagram view is
	 * changed
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		tableViewer.setInput(selection);
	}

	/*
	 * The following partXXX methods are needed to satisfy the IPartListener.
	 * Emma then knows which editor is activated and can add the
	 * ElementStateListener to the Editor. If we switch to another editor, Emma
	 * removes the listener prior to that and adds the listener to the new
	 * editor. TODO: What about non GMF Editors?
	 */
	public void partActivated(IWorkbenchPart part) {
		/*
		 * Emma clicked on the KIML Layout Hints View. I most cases, some
		 * Elements in the Editor have been selected before, but Emma wants them
		 * to be unselected.
		 */
		if (part.equals(this)) {
			if (activeEditor != null) {
				// This is GEF Code, so everything is fine
				GraphicalViewer gv = (GraphicalViewer) ((GraphicalEditor) activeEditor)
						.getAdapter(GraphicalViewer.class);
				gv.deselectAll();
			}
		}
		/*
		 * If another part was activated, i.e. not the KIML Layout Hints View,
		 * it might be the case that another editor was activated. Emma wants
		 * the new editor to inform the KIML Layout Hints View about changes in
		 * the grouping. This is at the moment just possible for GMF, because
		 * the grouping information is stored in the GMF-Notation model of the
		 * element in the editor.
		 */
		else {
			IEditorPart newEditor = part.getSite().getPage().getActiveEditor();
			// Check if we have a new editor
			if (newEditor != null && !newEditor.equals(activeEditor)) {

				/*
				 * If there wasn't an editor before, set the active editor
				 * first. Doesn't affect the removing of the listener below.
				 */
				if (activeEditor == null)
					activeEditor = newEditor;

				/*
				 * This is for GMF Editors, which are more convenient and offer
				 * more functions for the KIML Layout Hints View at the moment.
				 */
				if (newEditor instanceof DiagramDocumentEditor) {
					if (activeEditor instanceof DiagramDocumentEditor
							&& ((DiagramDocumentEditor) activeEditor)
									.getEditingDomain() != null) {
						((DiagramDocumentEditor) activeEditor)
								.getEditingDomain().removeResourceSetListener(
										this);
					}
					((DiagramDocumentEditor) newEditor).getEditingDomain()
							.addResourceSetListener(this);
					activeEditor = newEditor;
				}
				/*
				 * This is for GEF Editors.
				 * 
				 * TODO: implement it, but keep in mind that at the moment the
				 * grouping information is stored in the GMF-Notation model and
				 * hence works just for GMF editors.
				 */
				else if (newEditor instanceof GraphicalEditor) {

					;
				}
			}
		}
	}

	/*
	 * When loosing the focus of the KIML Layout Hints View, Emma wants to reset
	 * all the colorings made before to the diagram elements.
	 */
	public void partDeactivated(IWorkbenchPart part) {
		if (part.equals(this)) {
			savedEditPartColors.restoreAllForegrounds();
			savedEditPartColors.clearForeground();
		}
	}

	public void partOpened(IWorkbenchPart part) {
	}

	public void partBroughtToTop(IWorkbenchPart part) {
	}

	public void partClosed(IWorkbenchPart part) {
	}

	/*
	 * TODO: This works just for EMF
	 * 
	 * The following functions are implemented to satisfy the
	 * ResourceSetListener. Emma just needs the resourceSetChanged function in
	 * order to check if some Elements of the diagram were grouped by a context
	 * menu action.
	 */
	public void resourceSetChanged(ResourceSetChangeEvent arg0) {
		tableViewer.refresh();
	}

	public NotificationFilter getFilter() {
		return null;
	}

	public boolean isAggregatePrecommitListener() {
		return false;
	}

	public boolean isPostcommitOnly() {
		return false;
	}

	public boolean isPrecommitOnly() {
		return false;
	}

	public Command transactionAboutToCommit(ResourceSetChangeEvent arg0)
			throws RollbackException {
		return null;
	}

}