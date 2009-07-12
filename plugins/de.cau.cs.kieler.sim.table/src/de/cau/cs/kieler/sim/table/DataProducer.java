package de.cau.cs.kieler.sim.table;

import de.cau.cs.kieler.sim.kiem.extension.IJSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.extension.JSONStringDataComponent;
import de.cau.cs.kieler.sim.kiem.json.JSONObject;
import de.cau.cs.kieler.sim.table.views.DataTableView;

import java.util.Random;

public class DataProducer extends JSONStringDataComponent implements
		IJSONStringDataComponent {

	public DataProducer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String step(String JSONString) {
		//try{Thread.sleep(new Random().nextInt(200));}catch(Exception e){}
		
		String returnString = "";
		
		TableDataList tableDataList = TableDataList.getInstance();
		for (int c = 0; c < tableDataList.size(); c++) {
			TableData tableData = tableDataList.get(c);
			if (tableData.isModified()) {
				if (tableData.isPresent()) {
					if (!returnString.equals(""))
						returnString += ",";
					String key = tableData.getKey();
					String value = tableData.getValue();
					returnString += "\""+key+"\":\""+value+"\"";
				}
				//we have sent all modified values => reset
				synchronized(tableData) {
					tableData.setModified(false);
				}
			}
		}
		
		//update only if not currently edited
		//synchronized(DataTableView.getInstance()) {
			if (!DataTableView.getInstance().isCurrentlyEdited())
				TableDataList.getInstance().updateView();
		//}
		
		returnString = "{" + returnString + "}";
		
		System.out.println(returnString);
		return returnString;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		System.out.println("Raw Table Producer initialize");
	}

	@Override
	public boolean isConsumer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProducer() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
