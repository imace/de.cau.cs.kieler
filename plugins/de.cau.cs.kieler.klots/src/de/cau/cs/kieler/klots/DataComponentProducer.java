package de.cau.cs.kieler.klots;

import org.json.JSONException;
import org.json.JSONObject;

import de.cau.cs.kieler.sim.kiem.IJSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONObjectDataComponent;
import de.cau.cs.kieler.sim.kiem.JSONSignalValues;
import de.cau.cs.kieler.sim.kiem.KiemExecutionException;
import de.cau.cs.kieler.sim.kiem.KiemInitializationException;

public class DataComponentProducer extends JSONObjectDataComponent implements
		IJSONObjectDataComponent {
	
	NXTCommunicator comm;
	
	@Override
	public void initialize() throws KiemInitializationException {
//		System.out.println("DataComponentProvider -> INIT!");
		comm = NXTCommunicator.getInstance();
    }

	@Override
	public void wrapup() throws KiemInitializationException {
//		System.out.println("DataComponentProvider -> STOP!");
		comm.sendMessage("STOP");
		comm.closeTransmission();
    }

	@Override
	public boolean isProducer() {
		return true;
	}

	@Override
	public boolean isObserver() {
		return true;
	}

	@Override
	public JSONObject step(final JSONObject jSONObject) throws KiemExecutionException {
//		System.out.println("DataComponentProvider -> STEP!");
		
		String msg = "";
		try {
			if (jSONObject.has("A") && (JSONSignalValues.isPresent(jSONObject.get("A")))) {
	            msg += "A\n";
	        }
	        if (jSONObject.has("B") && (JSONSignalValues.isPresent(jSONObject.get("B")))) {
	            msg += "B\n";
	        }
	        if (jSONObject.has("R") && (JSONSignalValues.isPresent(jSONObject.get("R")))) {
	            msg += "R\n";
	        }
		} catch (JSONException e) {
            e.printStackTrace();
        }
		
		comm.sendMessage("STEP\n" + msg);
		return null;
	}
	
	@Override
    public JSONObject provideInitialVariables() {
        JSONObject returnObj = new JSONObject();
        try {
            returnObj.accumulate("a", JSONSignalValues.newValue(false));
            returnObj.accumulate("b", JSONSignalValues.newValue(false));
            returnObj.accumulate("r", JSONSignalValues.newValue(false));
            returnObj.accumulate("o", JSONSignalValues.newValue(false));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

}