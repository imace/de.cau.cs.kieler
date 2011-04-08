package de.cau.cs.kieler.klots.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;

import de.cau.cs.kieler.klots.views.SJInstructionsData;


public class SJInstructionsDataList {

    /** The list of SJInstructionsData entries. */
    private List<SJInstructionsData> sjInstructionsDataList;

    /** The one and only static instance of this class. */
    private static SJInstructionsDataList instance;

    /** The parent viewer to trigger refreshes. */
    private SJInstructionsViewer viewer;

    // -------------------------------------------------------------------------

    /**
     * Instantiates a new TableDataList.
     * 
     * @param viewerParam
     *            the parent tree table viewer for refreshes
     */
    public SJInstructionsDataList(final SJInstructionsViewer viewerParam) {
        this.viewer = viewerParam;
        sjInstructionsDataList = new ArrayList<SJInstructionsData>();
        instance = this;
    }

    // -------------------------------------------------------------------------

    /**
     * Returns the index of an SJInstructionsData entry.
     * 
     * @param sjInstructionsData
     *            the SJInstructionsData entry
     * 
     * @return the index
     */
    public int indexOf(final SJInstructionsData sjInstructionsData) {
        return sjInstructionsDataList.indexOf(sjInstructionsData);
    }

    // -------------------------------------------------------------------------


    /**
     * Updates the view of the parent tree table viewer asynchronously.
     */
    public void updateViewAsync() {
        // asynchronously update the table
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                viewer.refresh();
                // select the last microstep in the SJ instructions view
                int i = viewer.getTree().getItemCount();
                // on STARTUP and END there are no microsteps
                if( i > 0 ) {
                	viewer.getTree().setSelection(viewer.getTree().getItem(i-1));
                }
            }
        });
    }

    // -------------------------------------------------------------------------

    /**
     * Adds a SJInstructionsData entry to the list.
     * 
     * @param sjInstructionsData
     *            the SJInstructionsData entry
     */
    public void add(final SJInstructionsData sjInstructionsData) {
        sjInstructionsDataList.add(sjInstructionsData);
    }
    
    
    /**
     * Gets a SJInstructionsData entry with a specific index as an identifier.
     * 
     * @param index
     *            the identifier index
     * 
     * @return the SJInstructionsData entry
     */
    public SJInstructionsData get(final int index) {
        return sjInstructionsDataList.get(index);
    }
    
    
    public void clear() {
        sjInstructionsDataList.clear();
    }


    // -------------------------------------------------------------------------

    /**
     * Gets the single instance of this TableDataList class.
     * 
     * @return single instance of TableDataList
     */
    public static synchronized SJInstructionsDataList getInstance() {
        if (instance != null) {
            return instance;
        }
        return null;
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the size of this list.
     * 
     * @return the size
     */
    public int size() {
        return sjInstructionsDataList.size();
    }

    // -------------------------------------------------------------------------

    /**
     * Gets the list of SJInstructionsData entries as an array of SJInstructionsData entries.
     * 
     * @return the SJInstructionsData[] array
     */
    public SJInstructionsData[] getArray() {
        SJInstructionsData[] array = new SJInstructionsData[this.size()];
        for (int c = 0; c < this.size(); c++) {
            array[c] = this.get(c);
        }
        return array;
    }

}
