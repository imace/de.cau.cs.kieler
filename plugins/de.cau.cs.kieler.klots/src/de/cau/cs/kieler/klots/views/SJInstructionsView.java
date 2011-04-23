package de.cau.cs.kieler.klots.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.ViewPart;
import de.cau.cs.kieler.klots.KlotsPlugin;
import de.cau.cs.kieler.klots.editor.SJEditor;
import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.execution.Execution;


public class SJInstructionsView extends ViewPart {
	
    /** The ID of the view as specified by the extension. */
    public static final String ID = "de.cau.cs.kieler.klots.view.SJInstructionsView";

    /** The Constant COLUMN_0_WIDTH. */
    private static final int COLUMN_0_WIDTH = 0;
    private static final String COLUMN_0_TEXT = "";
    private static final String COLUMN_0_TOOLTIP = "";

    /** The Constant COLUMN_1_WIDTH. */
    private static final int COLUMN_1_WIDTH = 100;
    private static final String COLUMN_1_TEXT = "Name";
    private static final String COLUMN_1_TOOLTIP = "Instruction's name";

    /** The Constant COLUMN_2_WIDTH. */
    private static final int COLUMN_2_WIDTH = 100;
    private static final String COLUMN_2_TEXT = "Label";
    private static final String COLUMN_2_TOOLTIP = "Instruction's label";

    /** The Constant COLUMN_3_WIDTH. */
    private static final int COLUMN_3_WIDTH = 40;
    private static final String COLUMN_3_TEXT = "Prio";
    private static final String COLUMN_3_TOOLTIP = "Instruction's priority";
    
    /** The Constant COLUMN_4_WIDTH. */
    private static final int COLUMN_4_WIDTH = 150;
    private static final String COLUMN_4_TEXT = "Param";
    private static final String COLUMN_4_TOOLTIP = "Instruction's parameter(s)";
    
    /** The Constant COLUMN_5_WIDTH. */
    private static final int COLUMN_5_WIDTH = 50;
    private static final String COLUMN_5_TEXT = "RetVal";
    private static final String COLUMN_5_TOOLTIP = "Instruction's return value";
    
    /** The Constant COLUMN_6_WIDTH. */
    private static final int COLUMN_6_WIDTH = 50;
    private static final String COLUMN_6_TEXT = "InitExec";
    private static final String COLUMN_6_TOOLTIP = "Initial execution";

    /** This data table view instance. */
    private static SJInstructionsView sjInstructionsView;

    /** The tree viewer. */
    private SJInstructionsViewer viewer;
    
    private int microStepCounter = -1;
    
    
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

//        viewer.getControl().addKeyListener(new KeyListener() {
//            public void keyPressed(final KeyEvent e) {
//                // if user pressed delete
//                if (e.keyCode == KEYBOARD_DELETE) {
//                    getActionDelete().run();
//                }
//                // if user wants to toggle signal
//                if (e.keyCode == KEYBOARD_SPACE) {
//                    getActionSignaltoggle().run();
//                }
//            }
//
//            public void keyReleased(final KeyEvent e) {
//            }
//        });
        
            
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
        			
        			// set microstep counter to point at the last instruction on every new macrostep
        			if( microStepCounter == -1 ) {
        				microStepCounter = viewer.getTree().getItemCount()-1;
        			}
        			
        			// ------------------------------------------------------
        			// XXX: in this KLOTS release, process only the first element of the selection
        			SJInstructionsData data = (SJInstructionsData) selection.getFirstElement();
        			list.add(data);
        			System.out.println(">>> new selected item = " + data.getInstructionsName());
//        			for(Iterator<?> iterator = selection.iterator(); iterator.hasNext(); ) {
//        				list.add( (SJInstructionsData) iterator.next() );
//        			}
        			
        			// forbid multiple selections AND enable/disable microstep actions
        			int i = data.getParentSJInstructionsDataList().indexOf(data);
        			
        			// if this is not a step do nothing
        			if( i == microStepCounter ) {
        				return;
        				
        			// if this is a one step forward do a single step forward
        			} else if( i == microStepCounter+1 ) {
        				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        				if(editorPart != null) {
        					// do a forward step in the editor
        					SJEditor e = (SJEditor) editorPart;
        					e.doMicroStepForwards();
        					// print data
        					System.out.println("+++++>>>> LISTENER MICRO STEP FORWARD: selection index = " + (i-1) + ", new selection index = " + i + ", tree items count = " + viewer.getTree().getItemCount());
        					System.out.println("+++++>>>> LISTENER MICRO STEP FORWARD: increment the selection");
        					// increment the step counter AND enable/disable the microstep buttons
        					microStepCounter++;
        					if( !microStepBackwards.isEnabled() ) {
        						microStepBackwards.setEnabled(true);
        						microStepBackwardsAll.setEnabled(true);
        					}
        					// disable the 'forward' buttons if the new selected item is the last one in the list
        					if( i >= viewer.getTree().getItemCount()-1 ) {
        						microStepForwards.setEnabled(false);
        						microStepForwardsAll.setEnabled(false);
        					}
        				} else {
        					System.out.println("###>>> LISTENER MICRO STEP FORWARDS ERROR: No active editor!");
        				}
        				// OLD IMPLEMENTATION: TO BE REMOVED
//        				// set the selection to the previously item because 'microStepForwards' increments the selection
//        				viewer.getTree().setSelection(viewer.getTree().getItem(i-1));
//        				microStepForwards.run();
        				return;
        				
        			// if this is a one step backward do a single step backward
        			} else if( i == microStepCounter-1 ) {
        				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        				if(editorPart != null) {	
        					// do a backward step in the editor
        					SJEditor e = (SJEditor) editorPart;
        					e.doMicroStepBackwards();
        					// print data
        					System.out.println("+++++>>>> LISTENER MICRO STEP BACK: selection index = " + (i+1) + ", new selection index = " + i);
        					System.out.println("+++++>>>> LISTENER MICRO STEP BACK: decrement the selection");
        					// decrement the step counter AND enable/disable the microstep buttons
        					microStepCounter--;
        					if( !microStepForwards.isEnabled() ) {
        						microStepForwards.setEnabled(true);
        						microStepForwardsAll.setEnabled(true);
        					}
        					// disable the 'backward' buttons if the new selected item is the first one in the list
        					if( i <= 0 ) {
        						microStepBackwards.setEnabled(false);
        						microStepBackwardsAll.setEnabled(false);
        					}
        				} else {
        					System.out.println("###>>> LISTENER MICRO STEP BACKWARDS ERROR: No active editor!");
        				}
        				return;
        			}
        			
        			// if this is a 'jump' step process it as such
        			highlightSelectedSJInstructions(list);
        			viewer.getTree().setSelection(viewer.getTree().getItem(i));
        			microStepCounter = i;
        			// enable/disable the microstep buttons
        			if( i == 0 ) {
    					microStepForwards.setEnabled(true);
    					microStepForwardsAll.setEnabled(true);
    					microStepBackwards.setEnabled(false);
    					microStepBackwardsAll.setEnabled(false);
    				} else if( i == viewer.getTree().getItemCount()-1 ) {
    					microStepForwards.setEnabled(false);
    					microStepForwardsAll.setEnabled(false);
    					microStepBackwards.setEnabled(true);
    					microStepBackwardsAll.setEnabled(true);
    				} else {
    					microStepForwards.setEnabled(true);
    					microStepForwardsAll.setEnabled(true);
    					microStepBackwards.setEnabled(true);
    					microStepBackwardsAll.setEnabled(true);
    				}
        			// ------------------------------------------------------
        			
        		} else {
        			System.out.println("XXXXXXXXXX>>> BAD ERROR: SELECTION IS NOT A 'STRUCTURED SELECTION'");
        		}
     	    } // end selectionChanged()
        }); // end new ISelectionChangedListener() {}
    }

    
    
    protected void highlightSelectedSJInstructions(List<SJInstructionsData> list) {
    	System.out.println("XXXXXXXXXXXXX>>>>>>>>>>>> SELECTED ITEMS: ");
		for(SJInstructionsData d : list) {
			System.out.println( d.toString() );
		}
		IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editorPart != null) {
			SJEditor e = (SJEditor) editorPart;
			// XXX: OPTIMIZE in the next release if multiple selections are wished!!!
			// e.g. add an index variable to the SJInstructionsData class
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
    	int[] bounds = { COLUMN_0_WIDTH, COLUMN_1_WIDTH, COLUMN_2_WIDTH, COLUMN_3_WIDTH, COLUMN_4_WIDTH, COLUMN_5_WIDTH, COLUMN_6_WIDTH };
        String[] titles = { COLUMN_0_TEXT, COLUMN_1_TEXT, COLUMN_2_TEXT, COLUMN_3_TEXT, COLUMN_4_TEXT, COLUMN_5_TEXT, COLUMN_6_TEXT };
        String[] toolTip = { COLUMN_0_TOOLTIP, COLUMN_1_TOOLTIP, COLUMN_2_TOOLTIP, COLUMN_3_TOOLTIP, COLUMN_4_TOOLTIP, COLUMN_5_TOOLTIP, COLUMN_6_TOOLTIP };
        
        for (int i = 0; i < titles.length; i++) {
            TreeViewerColumn column = new TreeViewerColumn(viewerParam, SWT.NONE);
            column.getColumn().setWidth(bounds[i]);
            column.getColumn().setText(titles[i]);
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

    
    
    /**
     * Contribute to the tool bar of this ViewPart.
     */
    private void contributeToActionBars() {
    	
    	class TextContributionItem extends ContributionItem {
    		private String s;
    		public TextContributionItem(String text) {
    			super( text );
    			s = text;
    		}
    		public final void fill( ToolBar parent, int index ) {
    			Label text = new Label( parent, SWT.RIGHT );
		        text.setText(s);
		        text.setFont(new Font(Display.getDefault(), "Verdana", 7, SWT.BOLD));
		        ToolItem ti = new ToolItem( parent, SWT.SEPARATOR, index );
		        ti.setControl(text);
		        ti.setWidth(120);
		    }
    	}
    	
    	IActionBars bars = getViewSite().getActionBars();
        IToolBarManager toolBarManager = bars.getToolBarManager();
    	
    	TextContributionItem text1 = new TextContributionItem("MACROSTEP \nACTIONS    ");		
		toolBarManager.add(text1);
    	
		toolBarManager.add(kiemStepBackwards);
		toolBarManager.add(kiemStepForwards);
		toolBarManager.add(kiemRun);
		toolBarManager.add(kiemPause);
		toolBarManager.add(kiemStop);
        toolBarManager.add(new Separator());
			
		TextContributionItem text2 = new TextContributionItem("MICROSTEP \nACTIONS   ");		
		toolBarManager.add(text2);
		
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
					SJEditor e = (SJEditor) editorPart;
					e.doMicroStepForwards();
					
					// do a forward step in the SJ instructions view
					TreeItem[] selections = viewer.getTree().getSelection();
					int i = viewer.getTree().indexOf(selections[selections.length-1]);
					System.out.println("+++++>>>> MICRO STEP FORWARD: selection index = " + i + ", new selection index = " + (i+1) + ", tree items count = " + viewer.getTree().getItemCount());
					System.out.println("+++++>>>> MICRO STEP FORWARD: increment the selection");
					// set the new selection
					viewer.getTree().setSelection(viewer.getTree().getItem(i+1));
					microStepCounter++;
					if( !microStepBackwards.isEnabled() ) {
						microStepBackwards.setEnabled(true);
						microStepBackwardsAll.setEnabled(true);
					}
					// disable the 'forward' buttons if the new selected item is the last one in the list
					if( i+1 >= viewer.getTree().getItemCount()-1 ) {
						microStepForwards.setEnabled(false);
						microStepForwardsAll.setEnabled(false);
					}
					
				} else {
					System.out.println("###>>> MICRO STEP FORWARDS ERROR: No active editor!");
				}
			}
		};
		microStepForwards.setText("Microstep Forwards");
		microStepForwards.setToolTipText("Take a microstep forwards");
		microStepForwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepIcon.png") );
		microStepForwards.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepIconDisabled.png") );
		
		// ----------------------- micro step backward ----------------------
		microStepBackwards = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					
					// set microstep counter to point at the last instruction on every new macrostep
        			if( microStepCounter == -1 ) {
        				microStepCounter = viewer.getTree().getItemCount()-1;
        			}
					
					// do a backward step in the editor
					SJEditor e = (SJEditor) editorPart;
					e.doMicroStepBackwards();
					
					// do a backward step in the SJ instructions view
					TreeItem[] selections = viewer.getTree().getSelection();
					int i = viewer.getTree().indexOf(selections[0]);
					System.out.println("+++++>>>> MICRO STEP BACK: selection index = " + i + ", new selection index = " + (i-1));
					System.out.println("+++++>>>> MICRO STEP BACK: decrement the selection");
					// set the new selection
					viewer.getTree().setSelection(viewer.getTree().getItem(i-1));
					microStepCounter--;
					if( !microStepForwards.isEnabled() ) {
						microStepForwards.setEnabled(true);
						microStepForwardsAll.setEnabled(true);
					}
					// disable the 'backward' buttons if the new selected item is the first one in the list
					if( i-1 <= 0 ) {
						microStepBackwards.setEnabled(false);
						microStepBackwardsAll.setEnabled(false);
					}
					
				} else {
					System.out.println("###>>> MICRO STEP BACKWARDS ERROR: No active editor!");
				}
			}
		};
		microStepBackwards.setText("Microstep Backwards");
		microStepBackwards.setToolTipText("Take a microstep backwards");
		microStepBackwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepBackIcon.png") );
		microStepBackwards.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/microStepBackIconDisabled.png") );
		
		
		// --------------------- all forward micro steps --------------------
		microStepForwardsAll = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					// do all forward steps in the editor
					SJEditor e = (SJEditor) editorPart;
					e.doAllForwardMicroSteps();
					// do all forward steps in the SJ instructions view
					int i = viewer.getTree().getItemCount();
					viewer.getTree().setSelection(viewer.getTree().getItem(i-1));
					microStepCounter = i-1;
					microStepBackwards.setEnabled(true);
					microStepBackwardsAll.setEnabled(true);
					microStepForwards.setEnabled(false);
					microStepForwardsAll.setEnabled(false);
				} else {
					System.out.println("###>>> ALL MICRO STEPS FORWARDS ERROR: No active editor!");
				}
			}
		};
		microStepForwardsAll.setText("All Forward Microsteps");
		microStepForwardsAll.setToolTipText("Do all forward microsteps");
		microStepForwardsAll.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepIcon.png") );
		microStepForwardsAll.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepIconDisabled.png") );
		
		// --------------------- all backward micro steps -------------------
		microStepBackwardsAll = new Action() {
			public void run() {
				IEditorPart  editorPart = KlotsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart != null) {
					// roll back all steps in the editor
					SJEditor e = (SJEditor) editorPart;
					e.doAllBackwardMicroSteps();
					// roll back all steps in the SJ instructions view
					viewer.getTree().setSelection(viewer.getTree().getItem(0));
					microStepCounter = 0;
					microStepForwards.setEnabled(true);
					microStepForwardsAll.setEnabled(true);
					microStepBackwards.setEnabled(false);
					microStepBackwardsAll.setEnabled(false);
				} else {
					System.out.println("###>>> ALL MICRO STEPS BACKWARDS ERROR: No active editor!");
				}
			}
		};
		microStepBackwardsAll.setText("All Backward Microsteps");
		microStepBackwardsAll.setToolTipText("Do all backward microsteps");
		microStepBackwardsAll.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepBackIcon.png") );
		microStepBackwardsAll.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/macroStepBackIconDisabled.png") );
		// ------------------------------------------------------------------
		
		
		// ----------------------- KIEM step forwards -----------------------
		kiemStepForwards = new Action() {
			public void run() {
				Execution e = KiemPlugin.getDefault().getExecution();
				if( e == null ) {
					// FIXME: initExecution() does not return??!!
					KiemPlugin.getDefault().initExecution();			
					// enable/disable the KIEM actions
					kiemStepBackwards.setEnabled(true);
					kiemStop.setEnabled(true);
				} else {
					KiemPlugin.getDefault().getExecution().stepExecutionSync();
					
					// enable/disable the microstep actions
					microStepForwards.setEnabled(false);
					microStepForwardsAll.setEnabled(false);
					microStepBackwards.setEnabled(true);
					microStepBackwardsAll.setEnabled(true);
				}

				// reset microstep counter on every macrostep
				microStepCounter = -1;
			}
		};
		kiemStepForwards.setText("KIEM Macrostep Forwards");
		kiemStepForwards.setToolTipText("Take a macrostep forwards");
		kiemStepForwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIcon.png") );
		kiemStepForwards.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepIconDisabled.png") );

		// ----------------------- KIEM step backwards ----------------------
		kiemStepBackwards = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().stepBackExecutionSync();
				
				// enable/disable the microstep actions
				microStepForwards.setEnabled(false);
				microStepForwardsAll.setEnabled(false);
				microStepBackwards.setEnabled(true);
				microStepBackwardsAll.setEnabled(true);
				
				// reset microstep counter on every macrostep
				microStepCounter = -1;
			}
		};
		kiemStepBackwards.setText("KIEM Macrostep Backwards");
		kiemStepBackwards.setToolTipText("Take a macrostep backwards");
		kiemStepBackwards.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepBackIcon.png") );
		kiemStepBackwards.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstepBackIconDisabled.png") );

		// ---------------------------- KIEM run ----------------------------
		kiemRun = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().runExecutionSync();
				
				// enable/disable the KIEM actions
				kiemStepForwards.setEnabled(false);
				kiemStepBackwards.setEnabled(false);
				kiemRun.setEnabled(false);
				kiemPause.setEnabled(true);
				kiemStop.setEnabled(true);
				
				// enable/disable the microstep actions
				microStepForwards.setEnabled(false);
				microStepForwardsAll.setEnabled(false);
				microStepBackwards.setEnabled(false);
				microStepBackwardsAll.setEnabled(false);
				
				// reset microstep counter on starting macrostep
				microStepCounter = -1;
			}
		};
		kiemRun.setText("KIEM Run");
		kiemRun.setToolTipText("Run execution");
		kiemRun.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMrunIcon.png") );
		kiemRun.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMrunIconDisabled.png") );

		// --------------------------- KIEM pause ---------------------------
		kiemPause = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().pauseExecutionSync();
				
				// enable/disable the KIEM actions
				kiemStepForwards.setEnabled(true);
				kiemStepBackwards.setEnabled(true);
				kiemRun.setEnabled(true);
				kiemPause.setEnabled(false);
				
				// enable/disable the microstep actions
				microStepForwards.setEnabled(false);
				microStepForwardsAll.setEnabled(false);
				microStepBackwards.setEnabled(true);
				microStepBackwardsAll.setEnabled(true);
			}
		};
		kiemPause.setText("KIEM Pause");
		kiemPause.setToolTipText("Pause execution");
		kiemPause.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMpauseIcon.png") );
		kiemPause.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMpauseIconDisabled.png") );

		// ---------------------------- KIEM stop ---------------------------
		kiemStop = new Action() {
			public void run() {
				KiemPlugin.getDefault().getExecution().stopExecutionSync();
				
				// enable/disable the KIEM actions
				kiemStepForwards.setEnabled(true);
				kiemStepBackwards.setEnabled(false);
				kiemRun.setEnabled(true);
				kiemPause.setEnabled(false);
				kiemStop.setEnabled(false);
				
				// enable/disable the microstep actions
				microStepForwards.setEnabled(false);
				microStepForwardsAll.setEnabled(false);
				microStepBackwards.setEnabled(false);
				microStepBackwardsAll.setEnabled(false);
			}
		};
		kiemStop.setText("KIEM Stop");
		kiemStop.setToolTipText("Stop execution");
		kiemStop.setImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstopIcon.png") );
		kiemStop.setDisabledImageDescriptor( KlotsPlugin.imageDescriptorFromPlugin(KlotsPlugin.PLUGIN_ID, "icons/KIEMstopIconDisabled.png") );
		// ------------------------------------------------------------------
		
		
		// ------------------ set initial enabled/disabled ------------------
		kiemStepForwards.setEnabled(true);
		kiemStepBackwards.setEnabled(false);
		kiemRun.setEnabled(true);
		kiemPause.setEnabled(false);
		kiemStop.setEnabled(false);
		
		microStepForwards.setEnabled(false);
		microStepForwardsAll.setEnabled(false);
		microStepBackwards.setEnabled(false);
		microStepBackwardsAll.setEnabled(false);
		// ------------------------------------------------------------------
		
	}
    
    
    // -------------------------------------------------------------------------

    
    /**
     * Pass the focus request to the viewer's control.
     */
    public void setFocus() {
        viewer.getControl().setFocus();
    }
    
    

    
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------

//    /**
//     * Hook context menu that allows editing of entries.
//     */
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

//    /**
//     * Builds the context menu of the tree table viewer.
//     * 
//     * @param manager
//     *            the manager
//     */
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

//    /**
//     * Hook double click and selection changed effect actions.
//     */
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


}
