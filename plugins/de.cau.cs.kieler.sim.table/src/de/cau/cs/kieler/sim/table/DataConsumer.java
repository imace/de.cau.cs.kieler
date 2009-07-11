package de.cau.cs.kieler.sim.table;

import java.util.Random;

import de.cau.cs.kieler.sim.kiem.extension.IJSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.json.JSONArray;
import de.cau.cs.kieler.sim.kiem.json.JSONObject;

public class DataConsumer extends JSONStringDataComponent implements
		IJSONStringDataComponent {

	public DataConsumer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String step(String JSONString) {
		//set all entries to absent per default
		//boolean modified = false;
		for (int c = 0; c < TableDataList.getInstance().size(); c++) {
			TableData tableData = TableDataList.getInstance().get(c);
			if (tableData.isPresent()) {
				//modified = true;
				tableData.setPresent(false);
			}
		}
		
		// TODO Auto-generated method stub
		System.out.println("    CONSUMER START");
		System.out.println("RECEIVED: "+JSONString);
		
		try {
			JSONObject allData = new JSONObject(JSONString);
			String[] fieldNames = JSONObject.getNames(allData);
			if (fieldNames != null) {
				for (int c = 0; c < fieldNames.length; c++) {
					//extract key, value from JSONObject
					Object obj = allData.get(fieldNames[c]);
					String key = fieldNames[c];
					String value;
					if (obj instanceof JSONObject) {
						value = ((JSONObject)obj).toString();
					}
					if (obj instanceof JSONArray) {
						value = ((JSONArray)obj).toString();
					}
					else {
						value = (String)obj;
					}
					//add to table or update table
					if (TableDataList.getInstance().contains(key)) {
						//update
						TableData data = TableDataList.getInstance().get(key);
						data.setValue(value);
						data.setPresent(true);
						//modified = true;
					}
					else {
						//add
						TableDataList.getInstance().add(new TableData(TableDataList.getInstance(),
													true, 
													key,
													value));
						//modified = true;
					}
				}
				//if (modified)
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		TableDataList.getInstance().updateView();
		try{Thread.sleep(new Random().nextInt(200));}catch(Exception e){}
		System.out.println("    CONSUMER DONE");
		return null;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		System.out.println("Raw Table Consumer initialize");
	}

	@Override
	public boolean isConsumer() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isProducer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDeltaConsumer() {
		// TODO Auto-generated method stub
		return true;
	}
}
