package de.cau.cs.kieler.sim.kiem.extension;

public abstract class JSONObjectDataConsumer extends DataProducerConsumer implements JSONObjectDataConsumerInterface {
	
	//constructor
	public JSONObjectDataConsumer() {
		super();
		this.setConsumer(true);
		this.setProducer(false);
		this.setJSON(true);
	}
	
	//provide some key's of interest 
	public String[] getFilterKeys() {
		return null;
	}
	
	
	public boolean isDeltaListener() {
		return false;
	}
	
}
