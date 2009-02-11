package de.cau.cs.kieler.core.util;

import java.util.Map;

/**
 * Debugger Class to visualize the contents of a Map. Simply prints the Map
 * contents into a String.
 * @author haf
 */

public class MapPrinter {
	
	public static String toString(Map m){
		StringBuffer b = new StringBuffer();
		
		for (Object key : m.keySet()) {
			if(key != null){
				b.append(key.toString());
				b.append(" ("+key.hashCode()+") ");
				b.append(" = ");
				b.append(m.get(key)+"\n");
			}
		}
		
		return b.toString();
	}
}
