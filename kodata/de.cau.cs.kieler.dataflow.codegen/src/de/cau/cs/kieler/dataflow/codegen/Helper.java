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

package de.cau.cs.kieler.dataflow.codegen;

import java.util.HashSet;

import dataflow.Port;

public class Helper {

	private static HashSet<String> defs = new HashSet<String>();
	
	public static boolean isDefined(Port p){
		boolean res = defs.contains(p.getName());
		if(!res){
			defs.add(p.getName());
		}
		return res;
	}
	
	public static boolean isDefined(String p){
		boolean res = defs.contains(p);
		if(!res){
			defs.add(p);
		}
		return res;
	}
	
	public static boolean huhu(){
		return false;
	}
	
	public static String timestamp() {
		return String.valueOf( System.currentTimeMillis() );
	}
}


