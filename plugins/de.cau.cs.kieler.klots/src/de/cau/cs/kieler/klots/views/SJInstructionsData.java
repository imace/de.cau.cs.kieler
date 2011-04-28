/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse Rich Client
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright 2011 by
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
 * @author root
 */
/**
 * @author root
 *
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


    
    /**
     * @param parentSJInstructionsDataList 
     * @param instructionsName 
     * @param label 
     * @param prio 
     * @param param 
     * @param retval 
     * @param initialExecution 
     */
    public SJInstructionsData(final SJInstructionsDataList parentSJInstructionsDataList,
            final String instructionsName, final String label, final int prio,
            final String param, final boolean retval, final boolean initialExecution) {
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


    
    /**
     * @param parentSJInstructionsDataList 
     * @param instructionsName 
     * @param label 
     * @param prio 
     * @param param 
     * @param retval 
     */
    public SJInstructionsData(final SJInstructionsDataList parentSJInstructionsDataList,
            final String instructionsName, final String label, final int prio,
            final String param, final boolean retval) {
        this.sjInstructionsDataList = parentSJInstructionsDataList;
        this.instructionsName = instructionsName;
        this.label = label;
        this.prio = prio;
        this.param = param;
        this.retval = retval;
        this.hasParam = true;
        this.hasRetval = true;
    }


    
    /**
     * @param parentSJInstructionsDataList 
     * @param instructionsName 
     * @param label 
     * @param prio 
     * @param param 
     */
    public SJInstructionsData(final SJInstructionsDataList parentSJInstructionsDataList,
            final String instructionsName, final String label, final int prio, final String param) {
        this.sjInstructionsDataList = parentSJInstructionsDataList;
        this.instructionsName = instructionsName;
        this.label = label;
        this.prio = prio;
        this.param = param;
        this.hasParam = true;
    }


    
    /**
     * @param parentSJInstructionsDataList 
     * @param instructionsName 
     * @param label 
     * @param prio 
     */
    public SJInstructionsData(final SJInstructionsDataList parentSJInstructionsDataList,
            final String instructionsName, final String label, final int prio) {
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



    /**
     * @return String 
     */
    public String getInstructionsName() {
        return instructionsName;
    }


    
    /**
     * @param instructionsName 
     */
    public void setInstructionsName(final String instructionsName) {
        this.instructionsName = instructionsName;
    }


    
    /**
     * @return String 
     */
    public String getLabel() {
        return label;
    }


    
    /**
     * @param label 
     */
    public void setLabel(final String label) {
        this.label = label;
    }


    
    /**
     * @return int 
     */
    public int getPrio() {
        return prio;
    }


    
    /**
     * @param prio 
     */
    public void setPrio(final int prio) {
        this.prio = prio;
    }



    /**
     * @return boolean 
     */
    public boolean getRetval() {
        return retval;
    }


    
    /**
     * @param retval 
     */
    public void setRetval(final boolean retval) {
        this.retval = retval;
        this.hasRetval = true;
    }


    
    /**
     * @return boolean 
     */
    public boolean hasRetval() {
        return hasRetval;
    }



    /**
     * @return boolean 
     */
    public boolean getInitialExecution() {
        return initialExecution;
    }


    
    /**
     * @param initialExecution 
     */
    public void setInitialExecution(final boolean initialExecution) {
        this.initialExecution = initialExecution;
        this.hasInitialExecution = true;
    }


    
    /**
     * @return boolean 
     */
    public boolean hasInitialExecution() {
        return hasInitialExecution;
    }



    /**
     * @return String 
     */
    public String getParam() {
        return param;
    }


    
    /**
     * @param param 
     */
    public void setParam(final String param) {
        this.param = param;
        this.hasParam = true;
    }


    
    /**
     * @return boolean 
     */
    public boolean hasParam() {
        return hasParam;
    }



    /**
     * {@inheritDoc}
     */
    public String toString() {
        String ret = "instruction name: " + this.instructionsName + ", label: " + this.label
        + ", prio: " + this.prio;
        if (this.hasParam) {
            ret += ", param: " + this.param;
        }
        if (this.hasRetval) {
            ret += ", retval: " + this.retval;
        }
        if (this.hasInitialExecution) {
            ret += ", initExec: " + this.initialExecution;
        }
        return ret;
    }

}