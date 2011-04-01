package de.cau.cs.kieler.klots.views;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.ViewPart;

import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.editor.SJEditorWithKiVi;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.execution.Execution;


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
	
	// KIEM actions
	private Action kiemStepForwards;
	private Action kiemStepBackwards;
	private Action kiemRun;
	private Action kiemPause;
	private Action kiemStop;
	

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
        
            
        viewer.addPostSelectionChangedListener(new ISelectionChangedListener() {
        	public void selectionChanged(SelectionChangedEvent event) {
        		// if the selection is empty do nothing
        		if( event.getSelection().isEmpty() ) {
       	    	   System.out.println("XXXXXXXXXX>>> EMPTY SELECTION");
     	           return;
        		}
        		if( event.getSelection() instanceof IStructuredSelection ) {
        			IStructuredSelection selection = (IStructuredSelection)event.getSelection();
        			List<SJInstructionsData> list = new LinkedList<SJInstructionsData>();
        			for(Iterator<?> iterator = selection.iterator(); iterator.hasNext(); ) {
        				list.add( (SJInstructionsData) iterator.next() );
        			}
        			highlightSelectedSJInstructions(list);
        		}
     	    }
        });
        
    }

    
    
    protected void highlightSelectedSJInstructions(List<SJInstructionsData> list) {
    	System.out.println("XXXXXXXXXXXXX>>>>>>>>>>>> SELECTED ITEMS: ");
		for(SJInstructionsData d : list) {
			System.out.println( d.toString() );
		}
		IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editorPart != null) {
			SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
			// TODO: OPTIMIZE!!! e.g. add an index variable to the SJInstructionsData class
			SJInstructionsData[] sjInstructionsDataListArray = list.get(0).getParentSJInstructionsDataList().getArray();
			int[] indexArray = new int[list.size()];
			int i = 0;
			for(SJInstructionsData d : list) {
				for(int j = 0; j < sjInstructionsDataListArray.length; j++ ) {
					if( d.equals(sjInstructionsDataListArray[j]) ) {
						System.out.println("FOUND MATCH!");
						indexArray[i] = j;
						i++;
						break;
					}
				}
			}
			System.out.print("INDIZES FOUND: [");
			for(int x : indexArray) {
				System.out.print(x + ", ");
			}
			System.out.println("]");
			
			e.doSpecificSingleMicroStep(indexArray);
		} else {
			System.out.println("###>>> SJ INSTRUCTIONS VIEW INITIALIZATIONS ERROR: No active editor!");
		}
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

        for (int i = 0; i < titles.length; i++) {
            TreeViewerColumn column = new TreeViewerColumn(viewerParam, SWT.NONE);
            column.getColumn().setText(titles[i]);
            column.getColumn().setWidth(bounds[i]);
            column.getColumn().setToolTipText(toolTip[i]);
            column.getColumn().setResizable(true);
            column.getColumn().setMoveable(true);
            if (i == 0) {
                column.getColumn().setResizable(false);
            }
        }
        
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
        toolBarManager.add(new Separator());
		toolBarManager.add(kiemStepBackwards);
		toolBarManager.add(kiemStepForwards);
		toolBarManager.add(kiemRun);
		toolBarManager.add(kiemPause);
		toolBarManager.add(kiemStop);
        toolBarManager.add(new Separator());
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
					// do a forward step in the editor
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doMicroStepForwards();
					// do a forward step in the SJ instructions view
					TreeItem[] selections = viewer.getTree().getSelection();
					int i = viewer.getTree().indexOf(selections[selections.length-1]);
					System.out.println("+++++>>>> MICRO STEP BACK: selection index = " + i + ", new selection index = " + (i+1));
					if( i+1 < viewer.getTree().getItemCount() ) {
						viewer.getTree().setSelection(viewer.getTree().getItem(i+1));
					}
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
					// do a backward step in the editor
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doMicroStepBackwards();
					// do a backward step in the SJ instructions view
					TreeItem[] selections = viewer.getTree().getSelection();
					int i = viewer.getTree().indexOf(selections[0]);
					System.out.println("+++++>>>> MICRO STEP BACK: selection index = " + i + ", new selection index = " + (i-1));
					if( i-1 >= 0 ) {
						viewer.getTree().setSelection(viewer.getTree().getItem(i-1));
					}
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
					// do all forward steps in the editor
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doAllForwardMicroSteps();
					// do all forward steps in the SJ instructions view
					int i = viewer.getTree().getItemCount();
					viewer.getTree().setSelection(viewer.getTree().getItem(i-1));
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
					// roll back all steps in the editor
					SJEditorWithKiVi e = (SJEditorWithKiVi) editorPart;
					e.doAllBackwardMicroSteps();
					// roll back all steps in the SJ instructions view
					viewer.getTree().setSelection(viewer.getTree().getItem(0));
				} else {
					System.out.println("###>>> ALL MICRO STEPS BACKWARDS ERROR: No active editor!");
				}
			}
		};
		microStepBackwardsAll.setText("All Backward Microsteps");
		microStepBackwardsAll.setToolTipText("Do all backward microsteps");
		microStepBackwardsAll.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepBackIcon.png") );
		// ------------------------------------------------------------------
		
		
		// ----------------------- KIEM step forwards -----------------------
		kiemStepForwards = new Action() {
			public void run() {
				Execution e = KiemPlugin.getDefault().getExecution();
				if( e == null ) {
					// FIXME: initExecution() does not return??!!
					KiemPlugin.getDefault().initExecution();
				}
				KiemPlugin.getDefault().getExecution().stepExecutionSync();
			}
		};
		kiemStepForwards.setText("KIEM Macrostep Forwards");
		kiemStepForwards.setToolTipText("Take a macrostep forwards");
		kiemStepForwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIcon.png") );

		// ----------------------- KIEM step backwards ----------------------
		kiemStepBackwards = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().stepBackExecutionSync();
			}
		};
		kiemStepBackwards.setText("KIEM Macrostep Backwards");
		kiemStepBackwards.setToolTipText("Take a macrostep backwards");
		kiemStepBackwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepBackIcon.png") );

		// ---------------------------- KIEM run ----------------------------
		kiemRun = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().runExecutionSync();
			}
		};
		kiemRun.setText("KIEM Run");
		kiemRun.setToolTipText("Run execution");
		kiemRun.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMrunIcon.png") );

		// --------------------------- KIEM pause ---------------------------
		kiemPause = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().pauseExecutionSync();
			}
		};
		kiemPause.setText("KIEM Pause");
		kiemPause.setToolTipText("Pause execution");
		kiemPause.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMpauseIcon.png") );

		// ---------------------------- KIEM stop ---------------------------
		kiemStop = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().stopExecutionSync();
			}
		};
		kiemStop.setText("KIEM Stop");
		kiemStop.setToolTipText("Stop execution");
		kiemStop.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstopIcon.png") );
		
		// ------------------------------------------------------------------
		
	}
    
    
    
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
     * Pass the focus request to the viewer's control.
     */
    public void setFocus() {
        viewer.getControl().setFocus();
    }

}
