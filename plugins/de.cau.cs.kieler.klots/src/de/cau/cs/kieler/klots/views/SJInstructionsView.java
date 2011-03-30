package de.cau.cs.kieler.klots.views;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.editor.SJEditorWithKiVi;


public class SJInstructionsView extends ViewPart {

    /** The ID of the view as specified by the extension. */
    public static final String ID = "de.cau.cs.kieler.klots.view.SJInstructionsView";

    /** The Constant COLUMN_0_WIDTH. */
    private static final int COLUMN_0_WIDTH = 0;

    /** The Constant COLUMN_1_WIDTH. */
    private static final int COLUMN_1_WIDTH = 100;

    /** The Constant COLUMN_2_WIDTH. */
    private static final int COLUMN_2_WIDTH = 100;

    /** The Constant COLUMN_3_WIDTH. */
    private static final int COLUMN_3_WIDTH = 40;
    
    /** The Constant COLUMN_4_WIDTH. */
    private static final int COLUMN_4_WIDTH = 150;
    
    /** The Constant COLUMN_5_WIDTH. */
    private static final int COLUMN_5_WIDTH = 50;
    
    /** The Constant COLUMN_6_WIDTH. */
    private static final int COLUMN_6_WIDTH = 50;

    /** This data table view instance. */
    private static SJInstructionsView sjInstructionsView;

    /** The tree viewer. */
    private SJInstructionsViewer viewer;
    
    // microstep actions
    private Action microStepForwards;
	private Action microStepBackwards;
	private Action microStepForwardsAll;
	private Action microStepBackwardsAll;
	
	

    public SJInstructionsView() {
        sjInstructionsView = this;
    }

    public static SJInstructionsView getInstance() {
        return sjInstructionsView;
    }

    /**
     * Refreshes the tree viewer.
     */
    public void refreshViewer() {
        viewer.refresh();
        return;
    }


    // -------------------------------------------------------------------------

    /**
     * This is a callback that will allow us to create the viewer and initialize it.
     * 
     * @param parent
     *            the composite parent
     */
    public void createPartControl(final Composite parent) {
        createViewer(parent);
        viewer.setInput(new SJInstructionsDataList(viewer));
        createActions();
//        hookSideEffectActions();
//        hookContextMenu();
        contributeToActionBars();
//        updateEnabled();
    }

    // -------------------------------------------------------------------------

    /**
     * Creates the tree table viewer.
     * 
     * @param parent
     *            the composite parent
     */
    private void createViewer(final Composite parent) {
        viewer = new SJInstructionsViewer(parent, SWT.HIDE_SELECTION | SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.FULL_SELECTION);
        createColumns(viewer);
        viewer.setContentProvider(new SJInstructionsDataContentProvider());
        viewer.setLabelProvider(new SJInstructionsDataLabelProvider());

        viewer.getControl().addKeyListener(new KeyListener() {
            public void keyPressed(final KeyEvent e) {
//                // if user pressed delete
//                if (e.keyCode == KEYBOARD_DELETE) {
//                    getActionDelete().run();
//                }
//                // if user wants to toggle signal
//                if (e.keyCode == KEYBOARD_SPACE) {
//                    getActionSignaltoggle().run();
//                }
            }

            public void keyReleased(final KeyEvent e) {
            }
        });
    }

    // -------------------------------------------------------------------------

    /**
     * This will create the columns for the table.
     * 
     * @param viewerParam
     *            the DataTableViewer
     */
    private void createColumns(final SJInstructionsViewer viewerParam) {
        String[] titles = { "", "Name", "Label", "Prio", "Param", "RetVal", "InitExec" };
        String[] toolTip = { "", "Instruction's name", "Instruction's label", "Instruction's priority", "Instruction's parameter(s)", "Instruction's return value", "Initial execution" };
        int[] bounds = { COLUMN_0_WIDTH, COLUMN_1_WIDTH, COLUMN_2_WIDTH, COLUMN_3_WIDTH, COLUMN_4_WIDTH, COLUMN_5_WIDTH, COLUMN_6_WIDTH };

//        SelectionListener headerListener = new SelectionAdapter() {
//            public void widgetSelected(final SelectionEvent e) {
//                int column = viewer.getTree().indexOf((TreeColumn) e.widget);
//                TableViewerSorter oldSorter = (TableViewerSorter) viewer.getSorter();
//                viewer.getTree().setSortColumn((TreeColumn) e.widget);
//                if (oldSorter != null && column == oldSorter.getColumn()) {
//                      oldSorter.setReversed(!oldSorter.getReversed());
////                    System.out.println("SORTCOMMAND " + column);
//                    viewer.refresh();
////                    viewer.setSorter(null);
//                } else {
//                    viewer.setSorter(new TableViewerSorter(column));
//                }
//            }
//        };

        for (int i = 0; i < titles.length; i++) {
            TreeViewerColumn column = new TreeViewerColumn(viewerParam, SWT.NONE);
            column.getColumn().setText(titles[i]);
            column.getColumn().setWidth(bounds[i]);
            column.getColumn().setToolTipText(toolTip[i]);
            column.getColumn().setResizable(true);
            column.getColumn().setMoveable(true);
//            column.getColumn().addSelectionListener(headerListener);
            if (i == 0) {
                column.getColumn().setResizable(false);
            } else {
//                column.setEditingSupport(new TableDataEditing(viewerParam, i));
            }
        }
        // for default sorting
//        viewer.setSorter(new TableViewerSorter(2));
        
        Tree tree = viewerParam.getTree();
        tree.setHeaderVisible(true);
        tree.setLinesVisible(true);
    }

    // -------------------------------------------------------------------------

    /**
     * Hook context menu that allows editing of entries.
     */
//    private void hookContextMenu() {
//        MenuManager menuMgr = new MenuManager("#PopupMenu");
//        menuMgr.setRemoveAllWhenShown(true);
//        menuMgr.addMenuListener(new IMenuListener() {
//            public void menuAboutToShow(final IMenuManager manager) {
//                buildContextMenu(manager);
//            }
//        });
//        Menu menu = menuMgr.createContextMenu(viewer.getControl());
//        viewer.getControl().setMenu(menu);
//        getSite().registerContextMenu(menuMgr, viewer);
//    }

    // -------------------------------------------------------------------------

    /**
     * Builds the context menu of the tree table viewer.
     * 
     * @param manager
     *            the manager
     */
//    private void buildContextMenu(final IMenuManager manager) {
//        manager.add(getActionSignal());
//        manager.add(getActionSignaltoggle());
//        manager.add(getActionPermanent());
//        manager.add(new Separator());
//        manager.add(getActionAdd());
//        manager.add(getActionDelete());
//        // Other plug-ins can contribute there actions here
//        manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
//    }

    // -------------------------------------------------------------------------

    /**
     * Contribute to the tool bar of this ViewPart.
     */
    private void contributeToActionBars() {
        IActionBars bars = getViewSite().getActionBars();
        IToolBarManager toolBarManager = bars.getToolBarManager();
//        toolBarManager.add(getActionAdd());
//        toolBarManager.add(getActionDelete());
//        toolBarManager.add(new Separator());
//        toolBarManager.add(getActionSignal());
//        toolBarManager.add(getActionSignaltoggle());
//        toolBarManager.add(getActionPermanent());
        
        toolBarManager.add(new Separator());
		toolBarManager.add(microStepBackwardsAll);
		toolBarManager.add(microStepBackwards);
		toolBarManager.add(microStepForwards);
		toolBarManager.add(microStepForwardsAll);
		toolBarManager.add(new Separator());
    }
        	

    
    private void createActions() {		
		// ----------------------- micro step forward -----------------------
		microStepForwards = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doMicroStepForwards();
				} else {
					System.out.println("###>>> MICRO STEP FORWARDS ERROR: No active editor!");
				}
			}
		};
		microStepForwards.setText("Microstep Forwards");
		microStepForwards.setToolTipText("Take a microstep forwards");
		microStepForwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepIcon.png") );
		
		// ----------------------- micro step backward ----------------------
		microStepBackwards = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doMicroStepBackwards();
				} else {
					System.out.println("###>>> MICRO STEP BACKWARDS ERROR: No active editor!");
				}
			}
		};
		microStepBackwards.setText("Microstep Backwards");
		microStepBackwards.setToolTipText("Take a microstep backwards");
		microStepBackwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepBackIcon.png") );
		
		
		// --------------------- all forward micro steps --------------------
		microStepForwardsAll = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doAllForwardMicroSteps();
				} else {
					System.out.println("###>>> ALL MICRO STEPS FORWARDS ERROR: No active editor!");
				}
			}
		};
		microStepForwardsAll.setText("All Forward Microsteps");
		microStepForwardsAll.setToolTipText("Do all forward microsteps");
		microStepForwardsAll.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepIcon.png") );
		
		// --------------------- all backward micro steps -------------------
		microStepBackwardsAll = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doAllBackwardMicroSteps();
				} else {
					System.out.println("###>>> ALL MICRO STEPS BACKWARDS ERROR: No active editor!");
				}
			}
		};
		microStepBackwardsAll.setText("All Backward Microsteps");
		microStepBackwardsAll.setToolTipText("Do all backward microsteps");
		microStepBackwardsAll.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepBackIcon.png") );
		// ------------------------------------------------------------
	}
    
    
    
    // -------------------------------------------------------------------------

    /**
     * Gets the action to add a new variable or signal.
     * 
     * @return the action add
     */
//    private Action getActionAdd() {
//        if (actionNew != null) {
//            return actionNew;
//        }
//        actionNew = new Action() {
//            public void run() {
//                SJInstructionsData newElement = new SJInstructionsData(SJInstructionsDataList.getInstance(), false, " ", "");
//                SJInstructionsDataList.getInstance().add(newElement);
//                refreshViewer();
//                viewer.setSelection((new StructuredSelection(newElement)));
//                updateEnabled();
//            }
//        };
//        actionNew.setText("Add Entry");
//        actionNew.setToolTipText("Add Entry");
//        actionNew.setImageDescriptor(TablePlugin.getImageDescriptor("icons/add.png"));
//        return actionNew;
//    }

    // -------------------------------------------------------------------------

    /**
     * Gets the action to delete a variable or signal.
     * 
     * @return the action delete
     */
//    private Action getActionDelete() {
//        if (actionDelete != null) {
//            return actionDelete;
//        }
//        actionDelete = new Action() {
//            public void run() {
//                IStructuredSelection selection = (org.eclipse.jface.viewers.StructuredSelection) viewer
//                        .getSelection();
//                for (int c = 0; c < selection.size(); c++) {
//                    SJInstructionsData tableData = (SJInstructionsData) selection.toArray()[c];
//                    if (SJInstructionsDataList.getInstance().contains(tableData.getKey())) {
//                        SJInstructionsDataList.getInstance().remove(tableData.getKey());
//                    }
//                }
//                // viewer.setSelection(null);
//                refreshViewer();
//                updateEnabled();
//            }
//        };
//        actionDelete.setText("Delete Entry");
//        actionDelete.setToolTipText("Delete Entry");
//        actionDelete.setImageDescriptor(TablePlugin.getImageDescriptor("icons/delete.png"));
//        return actionDelete;
//    }

    // -------------------------------------------------------------------------

    /**
     * Gets the action to toggle presence of signals.
     * 
     * @return the action delete
     */
//    private Action getActionSignaltoggle() {
//        if (actionSignaltoggle != null) {
//            return actionSignaltoggle;
//        }
//        actionSignaltoggle = new Action("", IAction.AS_CHECK_BOX) {
//            public void run() {
//                IStructuredSelection selection = (org.eclipse.jface.viewers.StructuredSelection) viewer
//                        .getSelection();
//                // toggle w.r.t first selected value
//                boolean presentValue = !((SJInstructionsData) ((IStructuredSelection) selection)
//                        .getFirstElement()).isPresent();
//                for (int c = 0; c < selection.size(); c++) {
//                    SJInstructionsData tableData = (SJInstructionsData) selection.toArray()[c];
//                    boolean isSignal = tableData.isSignal();
//                    boolean isPresent = tableData.isPresent();
//                    boolean isModified = tableData.isModified();
//                    tableData.setSignal(true);
//                    tableData.setPresent(presentValue);
//                    tableData.setModified(isModified || !isSignal || (isPresent != presentValue));
//                }
//                // viewer.setSelection(null);
//                refreshViewer();
//                updateEnabled();
//            }
//        };
//        actionSignaltoggle.setText("Present/Absent");
//        actionSignaltoggle.setToolTipText("Present/Absent");
//        actionSignaltoggle.setImageDescriptor(TablePlugin.getImageDescriptor("icons/checked.png"));
//        return actionSignaltoggle;
//    }

    // -------------------------------------------------------------------------

    /**
     * Gets the action to flag a variable or signal as permanent.
     * 
     * @return the action permanent
     */
//    private Action getActionPermanent() {
//        if (actionPermanent != null) {
//            return actionPermanent;
//        }
//        actionPermanent = new Action("", IAction.AS_CHECK_BOX) {
//            public void run() {
//                IStructuredSelection selection = (org.eclipse.jface.viewers.StructuredSelection) viewer
//                        .getSelection();
//                // toggle w.r.t first selected value
//                boolean permanentValue = !((SJInstructionsData) ((IStructuredSelection) selection)
//                        .getFirstElement()).isPermanent();
//                for (int c = 0; c < selection.size(); c++) {
//                    SJInstructionsData tableData = (SJInstructionsData) selection.toArray()[c];
//                    tableData.setPermanent(permanentValue);
//                    // if this is a signal and set to permanent, set it to present status by
//                    // default!
//                    if (tableData.isPermanent() && tableData.isSignal()) {
//                        tableData.setPresent(true);
//                    } // end if
//                }
//                // enable updates for the table because we cannot edit the element anyway
//                if (permanentValue) {
//                    SJInstructionsView.getInstance().setCurrentlyEditing(false);
//                }
//
//                // viewer.setSelection(null);
//                refreshViewer();
//                updateEnabled();
//            }
//        };
//        actionPermanent.setText("Permanent");
//        actionPermanent.setToolTipText("Permanent");
//        actionPermanent.setImageDescriptor(TablePlugin
//                .getImageDescriptor("icons/permanentIcon.png"));
//        return actionPermanent;
//    }

    // -------------------------------------------------------------------------

    /**
     * Gets the action to toggle a variable to a signal and vice versa.
     * 
     * @return the action signal
     */
//    private Action getActionSignal() {
//        if (actionSignal != null) {
//            return actionSignal;
//        }
//        actionSignal = new Action("", IAction.AS_CHECK_BOX) {
//            public void run() {
//                IStructuredSelection selection = (org.eclipse.jface.viewers.StructuredSelection) viewer
//                        .getSelection();
//                // toggle w.r.t first selected value
//                boolean signalValue = !((SJInstructionsData) ((IStructuredSelection) selection)
//                        .getFirstElement()).isSignal();
//                for (int c = 0; c < selection.size(); c++) {
//                    SJInstructionsData tableData = (SJInstructionsData) selection.toArray()[c];
//                    boolean isSignal = tableData.isSignal();
//                    boolean isModified = tableData.isModified();
//                    tableData.setSignal(signalValue);
//                    tableData.setModified(isModified || isSignal != signalValue);
//                }
//                // viewer.setSelection(null);
//                refreshViewer();
//                updateEnabled();
//            }
//        };
//        actionSignal.setText("Signal");
//        actionSignal.setToolTipText("Signal");
//        actionSignal.setImageDescriptor(TablePlugin.getImageDescriptor("icons/signalIcon.png"));
//        return actionSignal;
//    }

    // -------------------------------------------------------------------------

    /**
     * Hook double click and selection changed effect actions.
     */
//    private void hookSideEffectActions() {
//        viewer.addDoubleClickListener(new IDoubleClickListener() {
//            public void doubleClick(final DoubleClickEvent event) {
//                ISelection selection = viewer.getSelection();
//                if (selection != null) {
//                    Object obj = ((IStructuredSelection) selection).getFirstElement();
//                    if (obj != null) {
//                        // toggle permanent
//                        getActionPermanent().run();
//                    }
//                }
//            }
//        });
//        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
//            public void selectionChanged(final SelectionChangedEvent event) {
//                updateEnabled();
//            }
//        });
//    }

    // -------------------------------------------------------------------------

    /**
     * Updates the enableness and toggle status of actions.
     */
//    private void updateEnabled() {
//        Object obj = ((org.eclipse.jface.viewers.StructuredSelection) viewer.getSelection())
//                .getFirstElement();
//        if (obj == null) {
//            // no object selected
//            getActionDelete().setEnabled(false);
//            getActionPermanent().setEnabled(false);
//            getActionSignal().setEnabled(false);
//            getActionSignaltoggle().setEnabled(false);
//        } else {
//            // object selected
//            getActionDelete().setEnabled(true);
//            getActionPermanent().setEnabled(true);
//            getActionSignal().setEnabled(true);
//            getActionSignaltoggle().setEnabled(true);
//            if (((SJInstructionsData) obj).isPermanent()) {
//                actionPermanent.setChecked(true);
//            } else {
//                actionPermanent.setChecked(false);
//            }
//            if (((SJInstructionsData) obj).isSignal()) {
//                actionSignal.setChecked(true);
//            } else {
//                actionSignal.setChecked(false);
//            }
//            if (((SJInstructionsData) obj).isPresent()) {
//                actionSignaltoggle.setChecked(true);
//            } else {
//                actionSignaltoggle.setChecked(false);
//            }
//        }
//
//    }

    // -------------------------------------------------------------------------

    /**
     * Pass the focus request to the viewer's control.
     */
    public void setFocus() {
        viewer.getControl().setFocus();
    }

}
