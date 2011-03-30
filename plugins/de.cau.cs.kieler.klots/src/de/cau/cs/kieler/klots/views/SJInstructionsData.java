/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2009 by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 */

package de.cau.cs.kieler.klots.views;

/**
 * The class TableData implements a single data entry that represents a variable or signal within
 * the data table. If it is a signal, then it can be present or absent. An entry always contains of
 * a key and a value String expression.
 * 
 * @author Christian Motika - cmot AT informatik.uni-kiel.de
 */
public class SJInstructionsData {

    /** The parent TableDataList the entry contains to. */
    private SJInstructionsDataList sjInstructionsDataList;
    
    private String instructionsName = "";
    private String label = "";
    private int prio = -1;
    private String param = "";
    private boolean retval = false;
    private boolean initialExecution = false;
    
    
    private boolean hasParam = false;
    private boolean hasRetval = false;
    private boolean hasInitialExecution = false;


    /**
     * Instantiates a new SJInstructionsData entry.
     * 
     * @param parentSJInstructionsDataList
     *            the parent SJInstructionsDataList
     */
    public SJInstructionsData(final SJInstructionsDataList parentSJInstructionsDataList) {
        this.sjInstructionsDataList = parentSJInstructionsDataList;
    }


	public SJInstructionsData(SJInstructionsDataList parentSJInstructionsDataList,
			String instructionsName, String label, int prio,
			String param, boolean retval, boolean initialExecution) {
		this.sjInstructionsDataList = parentSJInstructionsDataList;
		this.instructionsName = instructionsName;
		this.label = label;
		this.prio = prio;
		this.param = param;
		this.retval = retval;
		this.initialExecution = initialExecution;
		this.hasParam = true;
		this.hasRetval = true;
		this.hasInitialExecution = true;
	}

    
	public SJInstructionsData(SJInstructionsDataList parentSJInstructionsDataList,
			String instructionsName, String label, int prio,
			String param, boolean retval) {
		this.sjInstructionsDataList = parentSJInstructionsDataList;
		this.instructionsName = instructionsName;
		this.label = label;
		this.prio = prio;
		this.param = param;
		this.retval = retval;
		this.hasParam = true;
		this.hasRetval = true;
	}
    

	public SJInstructionsData(SJInstructionsDataList parentSJInstructionsDataList,
			String instructionsName, String label, int prio, String param) {
		this.sjInstructionsDataList = parentSJInstructionsDataList;
		this.instructionsName = instructionsName;
		this.label = label;
		this.prio = prio;
		this.param = param;
		this.hasParam = true;
	}
	
	
	public SJInstructionsData(SJInstructionsDataList parentSJInstructionsDataList,
			String instructionsName, String label, int prio) {
		this.sjInstructionsDataList = parentSJInstructionsDataList;
		this.instructionsName = instructionsName;
		this.label = label;
		this.prio = prio;
	}
	
	

	
    /**
     * Gets the parent SJInstructionsDataList.
     * 
     * @return the parent SJInstructionsDataList
     */
    public SJInstructionsDataList getParentSJInstructionsDataList() {
        return sjInstructionsDataList;
    }


    
    public String getInstructionsName() {
		return instructionsName;
	}


    public void setInstructionsName(String instructionsName) {
		this.instructionsName = instructionsName;
	}


    public String getLabel() {
		return label;
	}


    public void setLabel(String label) {
		this.label = label;
	}


    public int getPrio() {
		return prio;
	}


    public void setPrio(int prio) {
		this.prio = prio;
	}


	
    public boolean getRetval() {
		return retval;
	}


    public void setRetval(boolean retval) {
		this.retval = retval;
		this.hasRetval = true;
	}
	
	
    public boolean hasRetval() {
		return hasRetval;
	}


	
    public boolean getInitialExecution() {
		return initialExecution;
	}


    public void setInitialExecution(boolean initialExecution) {
		this.initialExecution = initialExecution;
		this.hasInitialExecution = true;
	}
	
	
    public boolean hasInitialExecution() {
		return hasInitialExecution;
	}
	


    public String getParam() {
		return param;
	}


    public void setParam(String param) {
		this.param = param;
		this.hasParam = true;
	}


    public boolean hasParam() {
		return hasParam;
	}
	
    
    
    public String toString() {
    	String ret = "instruction name: " + this.instructionsName +
    	", label: " + this.label + ", prio: " + this.prio;
    	if( this.hasParam ) {
    		ret += ", param: " + this.param;
    	}
    	if( this.hasRetval ) {
    		ret += ", retval: " + this.retval;
    	}
    	if( this.hasInitialExecution ) {
    		ret += ", initExec: " + this.initialExecution;
    	}
    	return ret;
    }
	
}
