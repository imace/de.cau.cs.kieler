package de.cau.cs.kieler.sim.table.views;


import java.util.Arrays;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.extension.DataProducerConsumer;
import de.cau.cs.kieler.sim.table.TableData;
import de.cau.cs.kieler.sim.table.TableDataContentProvider;
import de.cau.cs.kieler.sim.table.TableDataEditing;
import de.cau.cs.kieler.sim.table.TableDataLabelProvider;
import de.cau.cs.kieler.sim.table.TableDataList;
import de.cau.cs.kieler.sim.table.TablePlugin;


public class DataTableView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.cau.cs.kieler.sim.table.views.KiemTable";

	private TableViewer viewer;
	private Action doubleClickAction;
	private TableDataList tableDataList;
	private Table table;

	private Action action0; //new
	private Action action1;	//delete
	/**
	 * The constructor.
	 */
	public DataTableView() {
	}

	
	public String[] getColumnNames() {
		String[] columnNames = {"Present","Key","Value"};
		return columnNames;
	}
	public java.util.List getColumnNamesList() {
		return Arrays.asList(getColumnNames());
	}
	
		
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		createViewer(parent);
		viewer.setInput(TableDataList.getInstance());
		hookDoubleClickAction();
		hookContextMenu();
		contributeToActionBars();
	}

	private void createViewer(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		createColumns(viewer);
		viewer.setContentProvider(new TableDataContentProvider());
		viewer.setLabelProvider(new TableDataLabelProvider());
	}

	// This will create the columns for the table
	private void createColumns(TableViewer viewer) {
		String[] titles = { "P", "Key", "Value" };
		String[] toolTip = { "Present", "Key", "Value" };
		int[] bounds = { 22, 120, 120 };

		for (int i = 0; i < titles.length; i++) {
			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText(titles[i]);
			column.getColumn().setWidth(bounds[i]);
			column.getColumn().setToolTipText(toolTip[i]);
			column.getColumn().setResizable(true);
			column.getColumn().setMoveable(true);
			column.setEditingSupport(new TableDataEditing(viewer, i));
		}
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.add( getAction0());
		menuMgr.add( getAction1());
		menuMgr.setRemoveAllWhenShown(true);
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager manager0 = bars.getMenuManager();
		manager0.add(getAction0());
		manager0.add(getAction1());
		IToolBarManager manager1 = bars.getToolBarManager();
		manager1.add(getAction0());
		manager1.add(getAction1());
	}
	
	private Action getAction0() {
		if (action0 != null) return action0;
		action0 = new Action() {
			public void run() {
				TableDataList.getInstance().add(new TableData(tableDataList));
				viewer.refresh();
			}
		};
		action0.setText("Add");
		action0.setToolTipText("Add Entry");
		action0.setImageDescriptor(TablePlugin.getImageDescriptor("icons/add.png"));
		return action0;
	}
	
	private Action getAction1() {
		if (action1 != null) return action1;
		action1 = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Delete "+obj.toString());
				TableDataList.getInstance().remove("");
				viewer.refresh();
			}
		};
		action1.setText("Delete");
		action1.setToolTipText("Delete Entry");
		action1.setImageDescriptor(TablePlugin.getImageDescriptor("icons/delete.png"));
		return action1;
	}


	private void makeActions() {
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				//Object obj = ((IStructuredSelection)selection).getFirstElement();
				//showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"KIEM Table Data Consumer",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}