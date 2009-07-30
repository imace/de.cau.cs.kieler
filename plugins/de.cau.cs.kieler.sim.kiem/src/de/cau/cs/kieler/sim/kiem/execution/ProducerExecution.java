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

package de.cau.cs.kieler.sim.kiem.execution;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.extension.DataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.json.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ProducerExecution.
 *
 * @author Christian Motika <cmot@informatik.uni-kiel.de>
 * 
 */
public class ProducerExecution implements Runnable {
	
	/** The done. */
	private boolean done;
	
	/** The stop. */
	private boolean stop;
	
	/** The data component. */
	private DataComponent dataComponent;
	
	/** The data. */
	private JSONObject data;
	
	/** The parent. */
	private Execution parent;
	
	/**
	 * Instantiates a new producer execution.
	 * 
	 * @param dataComponent the data component
	 * @param parent the parent
	 */
	public ProducerExecution(DataComponent dataComponent,
						     Execution parent) {
		this.stop = false; 
		this.done = false; 
		this.data = null;
		this.parent = parent;
		this.dataComponent = dataComponent;
	}
	
	/**
	 * Blocking step.
	 */
	public void blockingStep() {
		synchronized(this) {
			done = false;
			//this will awake the execution (blockinWaitUntilDone())
			//AND
			//the waiting producer thread
			//but only the producer thread will proceed, cause done
			//is guaranteed to be false!
			//the execution will fall asleep until the producer has
			//finished doing its step
			this.notifyAll();
		}
	}

	//this method resumes only if producer is done (and sleeping)
	/**
	 * Blocking wait until done.
	 */
	public void blockingWaitUntilDone() {
		synchronized(this) {
			while (!this.done) {
				try {
					//we pass the lock to someone else because
					//we are still waiting for done to become true
					this.notifyAll();
					this.wait();
				}
				catch(Exception e) {
					parent.showWarning(
							null, 
							this.dataComponent.getPluginId(),
							e);
				}
			}//end while
		}//end synchronized
		//at this point done is true and we may reap the results now
	}
	
	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public JSONObject getData() {
		return this.data;
	}
	
	/**
	 * Sets the data.
	 * 
	 * @param data the new data
	 */
	public void setData(JSONObject data) {
		this.data = data;
	}

	/**
	 * Stop execution.
	 */
	public void stopExecution() {
		this.stop = true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (!this.stop) {
			//caller step() must ensure that done == false (before)
			if (!done) {
				try {
					synchronized(this) {
					    //now we got the result and are done
						//so we set done to true to indicate that the results
						//can be reaped
						//while done is true we sleep and awake the
						//execution (blockingWaitUntilDone()) possibly waiting
						//it will return if done==true and being awakened
						this.done = true;
						//only proceed if done == false 
						//(hence blockingStep() was called)
						while (this.done) {
							this.notifyAll();
							//at this point blockingWaitUntilDone() can return
							this.wait();
						}
						//at this point we know that someone wants us
						//to make a step and done is false
					}}
					catch(Exception e) {
						parent.showWarning(e.getMessage(), 
								this.dataComponent.getConfigurationElement()
								.getContributor().getName(),
								e);
					}
				
//System.out.println("  "+dataComponent.getName() + " (Pure Producer) calc start");
				//do asynchronous call
				if (this.dataComponent instanceof JSONObjectDataComponent) {
					JSONObjectDataComponent compJSON = 
						(JSONObjectDataComponent)dataComponent;
					//do not send any data cause this is a producer only
					try {
						this.data = compJSON.step(null);
					}catch(KiemExecutionException e) {
						KiemPlugin.getDefault().handleComponentError(
						 dataComponent, e);
					}
				}
				else {
					JSONStringDataComponent compString = 
						(JSONStringDataComponent)dataComponent;
					//do not send any data cause this is a producer only
					String JSONString = null;
					try {
						JSONString = compString.step(null);
					}catch(KiemExecutionException e) {
						KiemPlugin.getDefault().handleComponentError(
						 dataComponent, e);
					}
					this.data = null;
					if (JSONString != null && !JSONString.equals("")) {
						try {this.data = new JSONObject(JSONString);}
						catch(Exception e) {
							parent.showWarning(
									null, 
									this.dataComponent.getPluginId(),
									e);
						}
					}//not null
				}
			}//end if not done
			
//System.out.println("  "+dataComponent.getName() + " (Pure Producer) calc end");
			
		}//next while not stop
	}
}
