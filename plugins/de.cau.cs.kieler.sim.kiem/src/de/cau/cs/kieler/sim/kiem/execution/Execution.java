package de.cau.cs.kieler.sim.kiem.execution;

import java.util.List;

import de.cau.cs.kieler.sim.kiem.KiemPlugin;
import de.cau.cs.kieler.sim.kiem.extension.DataProducerConsumer;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataConsumer;
import de.cau.cs.kieler.sim.kiem.extension.JSONObjectDataProducer;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataProducer;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataConsumer;
import de.cau.cs.kieler.sim.kiem.json.*;

public class Execution implements Runnable {
	
	private int delay;
	private boolean stop;
	private List<DataProducerConsumer> dataProducerConsumerList;
	private int steps;
	
	public Execution(List<DataProducerConsumer> dataProducerConsumerList) {
		this.delay = KiemPlugin.DEFAULT_DELAY;
		this.stop = false; 
		this.steps = 0; // == paused
		this.dataProducerConsumerList = dataProducerConsumerList;
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
					System.out.println("execution step");
					//make a step
					for(int c = 0; c < this.dataProducerConsumerList.size(); c++) {
						DataProducerConsumer dataProducerConsumer = 
							dataProducerConsumerList.get(c);
						if (dataProducerConsumer.isProducer()) {
							if (dataProducerConsumer.isJSON()) {
								((JSONObjectDataProducer)dataProducerConsumer).step();
							}
							else {
								((JSONStringDataProducer)dataProducerConsumer).step();
							}
						}
						if (dataProducerConsumer.isConsumer()) {
							if (dataProducerConsumer.isJSON()) {
								((JSONObjectDataConsumer)dataProducerConsumer).updateData(new JSONObject());
							}
							else {
								((JSONStringDataConsumer)dataProducerConsumer).updateData("JSONstring");
							}
						}
					}//next producer/consumer
				}
			}//end synchronized

			//delay once if run
			if (steps == -1) 
				try{Thread.sleep(this.delay);}catch(Exception e){}
			//delay while paused
			while (steps == 0) {
				try{Thread.sleep(100);}catch(Exception e){}
				//if stop is requested, jump out
				if (this.stop) return;
			}
			
		}//next while not stop
	}

}
