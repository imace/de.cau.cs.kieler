package de.cau.cs.kieler.sim.kiem.execution;

import de.cau.cs.kieler.sim.kiem.extension.DataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.json.*;

public class ObserverExecution implements Runnable {
	
	private boolean done;
	private boolean stop;
	private DataComponent dataComponent;
	private JSONObject data;
	private Execution parent;
	
	public ObserverExecution(DataComponent dataComponent,
							 Execution parent) {
		this.stop = false; 
		this.done = true; 
		this.data = null;
		this.parent = parent;
		this.dataComponent = dataComponent;
	}
	
	public synchronized boolean step() {
		//check if we already done
		if (!done) {
			//deadline missed
//System.out.println("  SKIPPED - NOT READY YET");
			return false;
		}
		else {
//System.out.println("  START - READY");
			//deadline met 
			this.done = false;
			//awake this thread
			this.notify();
			return true;
		}
	}

	public JSONObject getData() {
		return this.data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}

	public void stopExecution() {
		this.stop = true;
	}

	public void run() {
		while (!this.stop) {
			//go to sleep
			try {
				synchronized(this){
					//now we got the result and are done
					this.done = true;
//System.out.println("  "+dataComponent.getName() + " (Pure Observer) calc end");
					this.wait();
				}}
				catch(Exception e) {
					parent.showError(e.getMessage(), this.dataComponent.getConfigurationElement().getContributor().getName());
				}
			
			try {
//System.out.println("  "+dataComponent.getName() + " (Pure Observer) calc start");
				//do asynchronous call
				if (this.dataComponent instanceof JSONObjectDataComponent) {
					JSONObjectDataComponent compJSON = 
						(JSONObjectDataComponent)dataComponent;
					//do use any response data cause this is a Observer only
					compJSON.step(this.data);
				}
				else {
					JSONStringDataComponent compString = 
						(JSONStringDataComponent)dataComponent;
					//do use any response data cause this is a Observer only
					if (this.data != null)
						compString.step(this.data.toString());
					else
						compString.step(null);
				}}
				catch(Exception e) {
					parent.showError(e.getMessage(), this.dataComponent.getConfigurationElement().getContributor().getName());
				}
			
		}//next while not stop
	}

}
