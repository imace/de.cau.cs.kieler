/*******************************************************************************
 * Copyright (c) 2008 Real-Time and Embedded Systems group
 *
 * INSERT LICENCE HERE
 *
 *
 * Author: Arne Schipper, ars@informatik.uni-kiel.de 
 *
 *******************************************************************************/
package edu.unikiel.rtsys.kieler.kiml.ui.snippets;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import edu.unikiel.rtsys.kieler.kiml.ui.helpers.KimlGMFLayoutHintHelper;

/**
 * TODO doc, TODO add a listener to refresh if updated via context menu, i.e.
 * GroupAsDot
 */
public class ViewSnippet extends ViewPart implements ISelectionListener {
	private TableViewer tableViewer;
	private Table table;
	private Action high;
	private Action action2;
	private Action doubleClickAction;

	// TODO: externalize strings
	// Set the table column property names
	private final String NODE_COLUMN = "node";
	private final String LAYOUTGROUP_COLUMN = "layoutGroup";
	private final String LAYOUTTYPE_COLUMN = "layoutType";

	// Set column names
	private String[] columnNames = new String[] { NODE_COLUMN,
			LAYOUTGROUP_COLUMN, LAYOUTTYPE_COLUMN };

	

	/**
	 * This class implements an ICellModifier An ICellModifier is called when
	 * the user modifies a cell in the tableViewer
	 *//*
	public class ViewCellModifier implements ICellModifier {

		public ViewCellModifier() {
			super();
		}

		*//**
		 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object,
		 *      java.lang.String)
		 *//*
		public boolean canModify(Object element, String property) {
			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);
			// can modify column 1 (layout group) and 2 (layout hint)
			if (columnIndex == 1 || columnIndex == 2)
				return true;
			else
				return false;
		}

		*//**
		 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object,
		 *      java.lang.String)
		 *//*
		public Object getValue(Object element, String property) {
			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);
			ShapeNodeEditPart snep = (ShapeNodeEditPart) element;
			switch (columnIndex) {
			case 0: // NODE_COLUMN
				return snep.getClass().toString();

			case 1: // LAYOUTGROUP_COLUMN
				return KimlGMFLayoutHintHelper.getLayoutGroup(snep);

			case 2: // LAYOUTTYPE_COLUMN
				// translate the result to Integers for the ComboBox
				String[] choices = ((ComboBoxCellEditor) (tableViewer
						.getCellEditors())[2]).getItems();
				String layoutHint = KimlGMFLayoutHintHelper.getLayoutType(snep);
				int i = choices.length - 1;
				while (!layoutHint.equals(choices[i]) && i > 0)
					--i;
				return new Integer(i);

			default:
				return "";
			}
		}

		*//**
		 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
		 *      java.lang.String, java.lang.Object)
		 *//*
		public void modify(Object element, String property, Object value) {
			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);
			// object may be of instance item, so cope with it
			if (element instanceof Item) {
				element = ((Item) element).getData();
			}
			final ShapeNodeEditPart snep = (ShapeNodeEditPart) element;
			switch (columnIndex) {

			case 0: // NODE_COLUMN
				break;

			case 1: // LAYOTGROUP_COLUMN
				if (value instanceof String) {
					final String groupID = (String) value;
					KimlGMFLayoutHintHelper.setLayoutGroup(snep, groupID);
				}
				break;

			case 2: // LAYOUTTYPE_COLUMN
				if (value instanceof Integer) {
					// get the choices to relate them to the ComboBox input,
					// which is numerical
					String[] choices = ((ComboBoxCellEditor) (tableViewer
							.getCellEditors())[2]).getItems();
					final String layoutType = choices[((Integer) value)
							.intValue()];
					// do it
					KimlGMFLayoutHintHelper.setLayoutType(snep, layoutType);
				}
				break;
			default:
				break;
			}
			tableViewer.refresh();
		}
	}

	
	 * The content provider class
	 
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

	
	 * The label provider class
	 
	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public String getColumnText(Object obj, int index) {
			ShapeNodeEditPart snep = (ShapeNodeEditPart) obj;
			switch (index) {
			case 0: // returns some sort of name
				return snep.getClass().toString();

			case 1: // returns layout group identifier
				return KimlGMFLayoutHintHelper.getLayoutGroup(snep);

			case 2: // returns the layout hint for this object
				return KimlGMFLayoutHintHelper.getLayoutType(snep);

			default: // This will not happen, but you never know ...
				return "";
			}
		}

		public Image getColumnImage(Object obj, int index) {
			if (index == 0)
				return getImage(obj);
			else
				return null;
		}

		public Image getImage(Object obj) {
			// Adapter imageAdapter =
			// ((ShapeNodeEditPart)obj).getAdapter(getClass());
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	
	 * The name sorter class
	 
	class NameSorter extends ViewerSorter {
	}

	*//**
	 * The constructor.
	 *//*
	public ViewSnippet() {
	}

	*//**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 *//*
	public void createPartControl(Composite parent) {

		createTable(parent);

		createTableViewer();

		tableViewer.setContentProvider(new ViewContentProvider());
		tableViewer.setLabelProvider(new ViewLabelProvider());

		tableViewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(
				tableViewer.getControl(),
				"edu.unikiel.rtsys.kieler.layouter.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	*//**
	 * Create the Table
	 *//*
	private void createTable(Composite parent) {
		int style = SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		table = new Table(parent, style);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// 1st column
		TableColumn column = new TableColumn(table, SWT.LEFT, 0);
		column.setText("Node name");
		column.setWidth(400);

		// 2nd column
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Layout group");
		column.setWidth(100);
		
		// 3rd column
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText("Layout type");
		column.setWidth(100);
	}

	*//**
	 * Create the TableViewer
	 *//*
	private void createTableViewer() {

		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);

		tableViewer.setColumnProperties(columnNames);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];

		// Column 1 : Completed (Checkbox)
		editors[0] = new CheckboxCellEditor(table);

		// Column 2 : Description (Free text)
		TextCellEditor textEditor = new TextCellEditor(table);
		// ((Text) textEditor.getControl()).set TextLimit(60);
		editors[1] = textEditor;

		// Column 3 : Owner (Combo Box)
		editors[2] = new ComboBoxCellEditor(table,
				KimlLayoutHintConstants.layoutTypes);

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new ViewCellModifier());
		// Set the default sorter for the viewer
		//tableViewer.setSorter(new GroupSorter());
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		// Register PartListener
		site.getPage().addSelectionListener(this);
	}

	@Override
	public void dispose() {
		super.dispose();
		getSite().getPage().removeSelectionListener(this);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ViewSnippet.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(tableViewer.getControl());
		tableViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tableViewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		System.out.println("fillLocalPullDown");
		manager.add(high);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		System.out.println("fillContextMenu");
		manager.add(high);
		manager.add(action2);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(high);
		manager.add(action2);
	}
*/
	private void makeActions() {
		high = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		high.setText("Action 1");
		high.setToolTipText("Action 1 tooltip");
		high.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = tableViewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		System.out.println("Hints: showMessage");
		MessageDialog.openInformation(tableViewer.getControl().getShell(),
				"KIML", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		tableViewer.getControl().setFocus();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		tableViewer.setInput(selection);
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
	}

}