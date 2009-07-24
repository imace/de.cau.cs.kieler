/******************************************************************************
 * KIELER - Kiel Integrated Environment for Layout for the Eclipse RCP
 *
 * http://www.informatik.uni-kiel.de/rtsys/kieler/
 * 
 * Copyright ${year} by
 * + Christian-Albrechts-University of Kiel
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 * See the file epl-v10.html for the license text.
 ******************************************************************************/

package de.cau.cs.kieler.sim.kiem.execution;

import de.cau.cs.kieler.sim.kiem.json.JSONObject;

public class DataPoolTestApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] filter = {"key01","key03","key05","key07"};
		
		// TODO Auto-generated method stub
		try {
			JSONDataPool dataPool = new JSONDataPool();
			//long index = dataPool.getPoolCounter();
			dataPool.putData(new JSONObject("{key01={key01=value01}}"));
			dataPool.putData(new JSONObject("{key02=value02}"));
			dataPool.putData(new JSONObject("{key03=value03}"));
			dataPool.putData(new JSONObject("{key04=value04}"));
			dataPool.putData(new JSONObject("{key05=value05}"));
			dataPool.putData(new JSONObject("{key06=value06}"));
			dataPool.putData(new JSONObject("{key07={key07=value07}}"));
			//System.out.println(dataPool.getDeltaData(filter,index).toString());
			System.out.println(dataPool.getData(null).toString());
			

			System.out.println("");
			System.out.println(dataPool.getDeltaData(filter,0).toString());
			System.out.println(dataPool.getDeltaData(filter,1).toString());
			System.out.println(dataPool.getDeltaData(filter,2).toString());
			System.out.println(dataPool.getDeltaData(filter,3).toString());
			System.out.println(dataPool.getDeltaData(filter,4).toString());
			System.out.println(dataPool.getDeltaData(filter,5).toString());
			System.out.println(dataPool.getDeltaData(filter,6).toString());
			System.out.println(dataPool.getDeltaData(filter,7).toString());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
