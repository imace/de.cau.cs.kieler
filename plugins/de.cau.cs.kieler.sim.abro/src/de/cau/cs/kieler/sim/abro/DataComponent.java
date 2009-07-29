/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
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
 ******************************************************************************/

package de.cau.cs.kieler.sim.abro;

import de.cau.cs.kieler.sim.kiem.data.KiemProperty;
import de.cau.cs.kieler.sim.kiem.data.KiemPropertyException;
import de.cau.cs.kieler.sim.kiem.data.KiemPropertyList;
import de.cau.cs.kieler.sim.kiem.data.KiemPropertyTypeChoice;
import de.cau.cs.kieler.sim.kiem.data.KiemPropertyTypeEditor;
import de.cau.cs.kieler.sim.kiem.data.KiemPropertyTypeFile;
import de.cau.cs.kieler.sim.kiem.data.KiemPropertyTypeWorkspaceFile;
import de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.json.JSONException;
import de.cau.cs.kieler.sim.kiem.json.JSONObject;

public class DataComponent extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	boolean wA;
	boolean wB;
	boolean dA;
	boolean dB;
	boolean done;
	String stateName;
	
	boolean paused; //demonstrate isPauseFlag() usage
	
	/**
	 * Instantiates a new data component.
	 */
	public DataComponent() {
	}
	
	/**
	 * Reset abo.
	 */
	private void resetABO() {
		wA = true;
		wB = true;
		dA = false;
		dB = false;
		done = false;
	}
	
	/**
	 * Transition_w a_d a.
	 */
	private void transition_wA_dA() {
		wA = false;
		dA = true;
	}
	
	/**
	 * Transition_w b_d b.
	 */
	private void transition_wB_dB() {
		wB = false;
		dB = true;
	}
	
	/**
	 * Transition_done.
	 */
	private void transition_done() {
		dB = false;
		dA = false;
		done = true;
		paused = true;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.IJSONObjectDataComponent#step(de.cau.cs.kieler.sim.kiem.json.JSONObject)
	 */
	public JSONObject step(JSONObject JSONobject) {
System.out.println("ABRO: "+ JSONobject.toString());

		JSONObject returnObj = new JSONObject();
		try{
			if (JSONobject.has("R")
				&& (JSONSignalValues.isPresent(JSONobject.get("R")))) {
					resetABO();
			}
			else {
				if (wA && JSONobject.has("A") 
					&& (JSONSignalValues.isPresent(JSONobject.get("A")))) {
					transition_wA_dA();
				}
				if (wB && JSONobject.has("B")
					&& (JSONSignalValues.isPresent(JSONobject.get("B")))) {
					transition_wB_dB();
				}
				if (dA && dB) {
					transition_done();
					returnObj.accumulate("O", JSONSignalValues.newValue(true));
				}
			}
			if (done) {
				returnObj.accumulate(stateName, "done");
			}
			if (dA && !dB) {
				returnObj.accumulate(stateName, "dA, wB");
			}
			if (dB && !dA) {
				returnObj.accumulate(stateName, "wa, dB");
			}
			if (wA && wB) {
				returnObj.accumulate(stateName, "wA, wB");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//try{Thread.sleep(800);}catch(Exception e){}
		
		return returnObj;
	}

	//--------------------------------------------------------------------------
	//additional methods
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#initialize()
	 */
	public void initialize() {
		// TODO Auto-generated method stub
		stateName = getProperties()[0].getValue();
		System.out.println("ABRO in Java in Kieler IN ACTION :-) initialize");
		resetABO();
		paused = false;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#wrapup()
	 */
	public void wrapup() {
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#isObserver()
	 */
	public boolean isObserver() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#isObserver()
	 */
	public boolean isDeltaObserver() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.IDataComponent#isProducer()
	 */
	public boolean isProducer() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.DataComponent#isMaster()
	 */
	@Override
	public boolean isMaster() {
		return false;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.DataComponent#isPauseFlag()
	 */
	@Override
	public boolean isPauseFlag() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.DataComponent#commandPause()
	 */
	@Override
	public void commandPause() {
		paused = false;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.DataComponent#provideInterfaceVariables()
	 */
	@Override
	public String[] provideInterfaceVariables() {
		String[] signals = {getProperties()[0].getValue(), "A", "B", "R", "O"}; 
		return signals;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.DataComponent#isMultiInstantiable()
	 */
	@Override
	public boolean isMultiInstantiable() {
		return true;
	}

	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.DataComponent#provideProperties()
	 */
	@Override
	public KiemProperty[] provideProperties() {
		KiemProperty[] properties = new KiemProperty[7];
		properties[0] = new KiemProperty(
				"state name",
				"ABRO state");
		properties[1] = new KiemProperty(
				"some bool",
				true);
		properties[2] = new KiemProperty(
				"an integer",
				2);
		properties[3] = new KiemProperty(
				"a file",
				new KiemPropertyTypeFile(),
				"c:/nothing.txt");
		String[] items = {"trace 1","trace 2", "trace 3", "trace 4"};
		properties[4] = new KiemProperty(
				"a choice",
				new KiemPropertyTypeChoice(items),
				items[2]);
		properties[5] = new KiemProperty(
				"workspace file",
				new KiemPropertyTypeWorkspaceFile(),
				"/nothing.txt");
		properties[6] = new KiemProperty(
				"editor",
				new KiemPropertyTypeEditor(),
				"");
		return properties;
	}
	
	/* (non-Javadoc)
	 * @see de.cau.cs.kieler.sim.kiem.extension.DataComponent#checkProperties(de.cau.cs.kieler.sim.kiem.data.KiemProperty[])
	 */
	@Override
	public void checkProperties(KiemProperty[] properties) throws KiemPropertyException {
		if (properties[0].getValue().trim().length() == 0) {
			throw new KiemPropertyException("The state name cannot be empty!");
		}
	}

}
