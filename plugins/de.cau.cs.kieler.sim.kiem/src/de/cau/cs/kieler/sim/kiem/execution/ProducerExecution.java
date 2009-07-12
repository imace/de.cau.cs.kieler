package de.cau.cs.kieler.sim.kiem.execution;

import de.cau.cs.kieler.sim.kiem.extension.DataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.json.*;

public class ProducerExecution implements Runnable {
	
	private boolean done;
	private boolean stop;
	private DataComponent dataComponent;
	private JSONObject data;
	
	public ProducerExecution(DataComponent dataComponent,
						     Execution parent) {
		this.stop = false; 
		this.done = false; 
		this.data = null;
		this.dataComponent = dataComponent;
	}
	
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
					e.printStackTrace();
				}
			}//end while
		}//end synchronized
		//at this point done is true and we may reap the results now
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
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
				System.out.println("  "+dataComponent.getName() + " (Pure Producer) calc start");
				//do asynchronous call
				if (this.dataComponent.isJSON()) {
					JSONObjectDataComponent compJSON = 
						(JSONObjectDataComponent)dataComponent;
					//do not send any data cause this is a producer only
					this.data = compJSON.step(null);
				}
				else {
					JSONStringDataComponent compString = 
						(JSONStringDataComponent)dataComponent;
					//do not send any data cause this is a producer only
					String JSONString = compString.step(null);
					this.data = null;
					if (JSONString != null && !JSONString.equals("")) {
						try {
							this.data = new JSONObject(JSONString);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}//not null
				}
			}//end if not done
			
			System.out.println("  "+dataComponent.getName() + " (Pure Producer) calc end");
			
		}//next while not stop
	}

}
