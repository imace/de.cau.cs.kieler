package de.cau.cs.kieler.klots;

import java.util.Iterator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import de.cau.cs.kieler.klots.views.SJInstructionsData;
import de.cau.cs.kieler.klots.views.SJInstructionsDataList;


public class SJInstructionsViewDataObserver extends JSONObjectDataComponent implements IJSONObjectDataComponent {

    /** The id of the view for KIEM. */
    private static final String SJ_INSTRUCTIONS_VIEW_ID = "de.cau.cs.kieler.klots.view.SJInstructionsView";
    private static final String SIGNAL_TABLE_VIEW_ID = "de.cau.cs.kieler.sim.table.view";

    /**
     * The Constant EYE_CATCH_DELAY. Let the user eye-catch the table entries and delay the update
     * 80ms.
     */
    private static final int EYE_CATCH_DELAY = 80;

    // -------------------------------------------------------------------------

    /**
     * Instantiates a new observer DataComponent.
     */
    public SJInstructionsViewDataObserver() {
    }

    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public JSONObject step(JSONObject jSONObject) {
        SJInstructionsDataList instrList = SJInstructionsDataList.getInstance();
        instrList.clear();
        
        try {
			JSONArray jArray = jSONObject.getJSONArray("executionTrace");
			System.out.println("####>>>> jArray, length=" + jArray.length() + " : " + jArray.toString());
			JSONObject instr = new JSONObject();
			JSONObject instrInside = new JSONObject();
			JSONArray instrParams = new JSONArray();
			String jSONKey = "";
			for(int i = 2; i < jArray.length()-2; i++) {
				instr = jArray.getJSONObject(i);
				System.out.println("####>>>> instr, i=" + i + " : " + instr.toString());
				SJInstructionsData instrData = new SJInstructionsData(instrList);
				for(Iterator<?> iter = instr.keys(); iter.hasNext(); ) {
					jSONKey = (String) iter.next();
				}
				
				if( jSONKey.equals("present") ) {   // FIXME: find a way to deal with 'present' hidden in 'awaitDone'
					continue;
				}
				
				instrData.setInstructionsName(jSONKey);
				instrInside = instr.getJSONObject(jSONKey);
				instrData.setLabel(instrInside.getString("label"));
				instrData.setPrio(instrInside.getInt("prio"));
				if( instrInside.has("retval") ) {
					instrData.setRetval(instrInside.getBoolean("retval"));
				}
				if( instrInside.has("initialExcecution") ) {
					instrData.setInitialExecution(instrInside.getBoolean("initialExcecution"));
				}
				if( instrInside.has("param") ) {
					instrParams = instrInside.getJSONArray("param");
					instrData.setParam(instrParams.toString());
				}
				System.out.println("####>>>> INSTRUCTION DATA: " + instrData.toString());
				instrList.add(instrData);
			}
		} catch (JSONException e) {
//			printConsole("STEP ERROR: " + e.getMessage());
			System.out.println("INSTRUCTIONS VIEW OBSERVER STEP ERROR: ");
			e.printStackTrace();
		}

		// TODO: DEAL WITH HISTORY STEPS!
//                if (this.isHistoryStep()) {
//                    // set all NOT updated entries to absent per default
//                    int tableSize = TableDataList.getInstance().size();
//                    for (int c = 0; c < tableSize; c++) {
//                        TableData tableData = TableDataList.getInstance().get(c);
//                        if (tableData.isPresent() && (!tableData.isModified())) {
//                            if (!sjInstructionsDataTmp.contains(tableData)) {
//                                tableData.setPresent(false);
//                            }
//                        }
//                        if (tableData.isModified()) {
//                            tableData.setModified(false);
//                        }
//                    }
//                }


        // update view
		instrList.updateViewAsync();

        // Slow down so that user can eye-catch all changes!
        try {
            Thread.sleep(EYE_CATCH_DELAY);
        } catch (Exception e) {
            // does not matter if we update a little faster
        }

        return null;
    }

    
    // -------------------------------------------------------------------------

    private boolean broughtToFront;

    /**
     * This method brings the Table view to the front.
     */
    public void bringToFront() {
        broughtToFront = false;
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                // bring view to the front (lazy loading)
                try {
                    IWorkbenchWindow window = KlotsPlugin.getDefault().getWorkbench()
                            .getActiveWorkbenchWindow();
                    IViewPart vP = window.getActivePage().showView(SIGNAL_TABLE_VIEW_ID);
                    vP.setFocus();
                    vP = window.getActivePage().showView(SJ_INSTRUCTIONS_VIEW_ID);
                    vP.setFocus();
                    // set done flag
                    broughtToFront = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        while (!broughtToFront) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void initialize() {
        // bring SJ instructions view to front
    	bringToFront();
        
        // update the view
        //SJInstructionsDataList.getInstance().updateViewAsync();
    }


    /**
     * {@inheritDoc}
     */
    public boolean isObserver() {
        return true;
    }


    /**
     * {@inheritDoc}
     */
    public boolean isProducer() {
        return false;
    }


    /**
     * {@inheritDoc}
     */
    public boolean isHistoryObserver() {
        return true;
    }



    /**
     * {@inheritDoc}
     */
    public void wrapup() {
    	SJInstructionsDataList instrList = SJInstructionsDataList.getInstance();
        instrList.clear();
        instrList.updateViewAsync();
    }

}
