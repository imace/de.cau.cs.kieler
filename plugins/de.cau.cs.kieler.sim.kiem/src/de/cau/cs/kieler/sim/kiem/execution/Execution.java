package de.cau.cs.kieler.sim.kiem.execution;

import java.util.List;

import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.extension.DataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.json.*;

public class Execution implements Runnable {
	
	private int delay;
	private boolean stop;
	private List<DataComponent> dataComponentList;
	private int steps;
	private ConsumerExecution[] consumerExecutionArray;
	private ProducerExecution[] producerExecutionArray;
	
	public Execution(List<DataComponent> dataComponentList) {
		this.delay = KiemPlugin.DELAY_DEFAULT;
		this.stop = false; 
		this.steps = 0; // == paused
		this.dataComponentList = dataComponentList;
		
		consumerExecutionArray = new ConsumerExecution[this.dataComponentList.size()];
		producerExecutionArray = new ProducerExecution[this.dataComponentList.size()];
		
		//for each pure consumer ... create ConsumerExecution Thread
		//for each pure producer ... create ProducerExecution Thread
		for (int c = 0; c < dataComponentList.size(); c++) {
			DataComponent dataComponent = dataComponentList.get(c);
			if (dataComponent.isEnabled()) {
				if(dataComponent.isPureConsumer()) {
					//pure Consumer
					consumerExecutionArray[c] = new ConsumerExecution(dataComponent);
					(new Thread(consumerExecutionArray[c])).start();
				}
				else if(dataComponent.isPureProducer()) {
					//pure Producer
					producerExecutionArray[c] = new ProducerExecution(dataComponent);
					(new Thread(producerExecutionArray[c])).start();
				}
			}
		}
		
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	public void pauseExecution() {
		this.steps = 0;
	}
	
	public void runExecution() {
		this.steps = -1;
	}
	
	public boolean isPaused() {
		return (steps == 0);
	}

	public boolean isRunning() {
		return (steps == -1);
	}
	
	public void stopExecution() {
		this.stop = true;
		this.steps = 0;
		
		//stop all child execution threads
		for (int c = 0; c < this.dataComponentList.size(); c++) {
			if (this.consumerExecutionArray[c] != null)
				this.consumerExecutionArray[c].stopExecution();
			if (this.producerExecutionArray[c] != null)
				this.producerExecutionArray[c].stopExecution();
		}
		
	}
	
	public synchronized void stepExecution() {
		this.steps++;
	}
	
	public void run() {
		while (!this.stop) {
			
			synchronized(this) {
				if ((steps == -1)||(steps > 0)) {
					
					//reduce number of steps
					if (steps > -1) steps--;
					System.out.println("-- execution step -------------------------------");

					//call all pure producers first
					for(int c = 0; c < this.dataComponentList.size(); c++) {
						DataComponent dataComponent = 
							dataComponentList.get(c);
						if (dataComponent.isEnabled() && 
							dataComponent.isPureProducer()) {
								System.out.println(c + ") " + dataComponent.getName() + " (Pure Producer) call");
								producerExecutionArray[c].setDone(false);
								producerExecutionArray[c].step();
						}
					}//next producer/consumer
					
					//make a step - according to the dataComponentList order
					for(int c = 0; c < this.dataComponentList.size(); c++) {
						DataComponent dataComponent = 
							dataComponentList.get(c);
						if (!dataComponent.isEnabled()) continue;
						
						if (dataComponent.isProducerConsumer()) {
							System.out.println(c + ") " +dataComponent.getName() + " (Norm Producer) call");
							//Consumer AND Producer => blocking
							if (dataComponent.isJSON()) {
								//TODO: reasonable data
								((JSONObjectDataComponent)dataComponent).step(null);
							}
							else {
								//TODO: reasonable data
								((JSONStringDataComponent)dataComponent).step(null);
							}
							System.out.println(dataComponent.getName() + " (Norm Producer) return");
						}
						else if(dataComponent.isPureConsumer()) {
								System.out.println(c + ") " +dataComponent.getName() + " (Pure Consumer) call");
								//pure Consumer
								//set current data
								//TODO: reasonable data
								consumerExecutionArray[c].setData(null);
								//call async method
								//if (consumerExecutionArray[c].isDone())
									consumerExecutionArray[c].step();
								//else
								//	System.out.println("  SKIPPED - NOT READY YET");
									
						}
						else if(dataComponent.isPureProducer()) {
								System.out.println(c + ") " +dataComponent.getName() + " (Pure Producer) wait");
								//pure Producer
								//get blocking result
								while (!producerExecutionArray[c].isDone()) {
									Thread.yield();
								}
								System.out.println(c + ") " +dataComponent.getName() + " (Pure Producer) done");
								//TODO: reasonable data
								producerExecutionArray[c].getData();
						}
					}//next producer/consumer
				}
			}//end synchronized

			//delay once if run
			if (steps == -1) 
				try{Thread.sleep(this.delay);}catch(Exception e){}
			//delay while paused
			while (steps == 0) {
				try{Thread.sleep(50);}catch(Exception e){}
				//if stop is requested, jump out
				if (this.stop) return;
			}
			
		}//next while not stop
	}

}
